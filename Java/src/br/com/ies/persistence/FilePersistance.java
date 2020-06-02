package br.com.ies.persistence;

import java.util.Arrays;

import br.com.ies.dto.PersistanceParameterDTO;
import br.com.ies.dto.QueryDTO;
import br.com.ies.persistence.impl.PersistanceImpl;
import br.com.ies.util.Callback;
import br.com.ies.util.Util;

public class FilePersistance extends PersistanceImpl {

	private final String FILE_NAME = new String("objetos.txt");
	private final String PERSISTANCE_NAME = new String("Arquivo");

	public FilePersistance() {
		super.setName(PERSISTANCE_NAME);
	}

	@Override
	public void persist(QueryDTO queryDTO) {
		Object object = queryDTO.getObject();
		Util.writeObjectInFile(object, FILE_NAME);
	}

	@Override
	public <T> void select(PersistanceParameterDTO<T> select, Callback callback) {
		Object object = Util.listObjectsFromFile(select.getObject().getClass(), FILE_NAME).stream()
				.filter(o -> Util.getFieldValue(Util.getChavePrimaria(select.getObject()), o).toString()
						.equals(select.getParameter().toString()))
				.findFirst().orElse(null);
		callback.call(Arrays.asList(object));
	}
}
