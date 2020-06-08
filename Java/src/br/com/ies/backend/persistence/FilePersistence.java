package br.com.ies.backend.persistence;

import java.util.Arrays;

import br.com.ies.backend.dto.PersistenceDTO;
import br.com.ies.backend.dto.PersistenceParameterDTO;
import br.com.ies.backend.persistence.impl.PersistenceImpl;
import br.com.ies.backend.util.PersistenceUtil;
import br.com.ies.backend.util.ReflectionUtil;
import br.com.ies.backend.util.lib.Callback;

public class FilePersistence extends PersistenceImpl {

	private final String FILE_NAME = new String("objetos.txt");
	private final String PERSISTANCE_NAME = new String("Arquivo");

	public FilePersistence() {
		super.setName(PERSISTANCE_NAME);
	}

	@Override
	public void persist(PersistenceDTO queryDTO) {
		ReflectionUtil.setFieldValue(queryDTO.getObject(), queryDTO.getChavePrimaria(), PersistenceUtil.getValueFromChavePrimaria(queryDTO));
		Object object = queryDTO.getObject();
		PersistenceUtil.writeObjectInFile(object, FILE_NAME);
	}

	@Override
	public <T> void select(PersistenceParameterDTO<T> select, Callback callback) {
		Object[] objects = PersistenceUtil.listObjectsFromFile(select.getObject().getClass(), FILE_NAME);
		Object object = Arrays.stream(objects)
				.filter(o -> ReflectionUtil.getFieldValue(ReflectionUtil.getChavePrimaria(select.getObject()), o)
						.toString().equals(select.getParameter().toString()))
				.reduce((first, second) -> second).orElse(null);
		
		callback.call(Arrays.asList(object));
	}
}
