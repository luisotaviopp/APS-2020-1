package br.com.ies.backend.persistence;

import java.util.Arrays;
import java.util.stream.IntStream;

import br.com.ies.backend.dto.PersistanceDTO;
import br.com.ies.backend.dto.PersistanceParameterDTO;
import br.com.ies.backend.persistence.impl.PersistanceImpl;
import br.com.ies.backend.util.Callback;
import br.com.ies.backend.util.Util;

public class FilePersistance extends PersistanceImpl {

	private final String FILE_NAME = new String("objetos.txt");
	private final String PERSISTANCE_NAME = new String("Arquivo");

	public FilePersistance() {
		super.setName(PERSISTANCE_NAME);
	}

	@Override
	public void persist(PersistanceDTO queryDTO) {
		Object object = queryDTO.getObject();
		Util.writeObjectInFile(object, FILE_NAME);
	}

	@Override
	public <T> void select(PersistanceParameterDTO<T> select, Callback callback) {
		Object[] objects = Util.listObjectsFromFile(select.getObject().getClass(), FILE_NAME);
		Object object = IntStream.range(0, objects.length).mapToObj(i -> objects[i])
				.filter(o -> Util.getFieldValue(Util.getChavePrimaria(select.getObject()), o).toString()
						.equals(select.getParameter().toString()))
				.reduce((first, second) -> second).orElse(null);
		callback.call(Arrays.asList(object));
	}
}
