package br.com.ies.backend.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.ies.backend.Main;
import br.com.ies.backend.builder.QueryBuilder;
import br.com.ies.backend.dto.PersistenceDTO;

public class PersistenceUtil {

	private static final ExecutorService EXECUTORS = Executors.newFixedThreadPool(2);
	
	public static void persist(Serializable object) {
		EXECUTORS.execute( 
			() -> {
			try {
				PersistenceDTO buildObject = QueryBuilder.build(object);
				Main.getPersistenceManager().getPersistenceList().stream().forEachOrdered(persist -> persist.persist(buildObject));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
				);
	}
	
	public static void execute(Runnable runnable) {
		EXECUTORS.execute(runnable);
	}

	public static Integer getValueFromChavePrimaria(PersistenceDTO persistenceDTO) {
		Integer value = -1;

		if (ReflectionUtil.getFieldValue(persistenceDTO.getChavePrimaria(), persistenceDTO.getObject()) != null)
			return (Integer) ReflectionUtil.getFieldValue(persistenceDTO.getChavePrimaria(),persistenceDTO.getObject());

		try {
			PreparedStatement preparedStatement = Main.getConnectionFactory().getPreparedStatement("SELECT "
					+ ReflectionUtil.getColunaFromField(persistenceDTO.getChavePrimaria()).nome() + " FROM "
					+ persistenceDTO.getSchema().concat(".").concat(persistenceDTO.getTabela()) + " ORDER BY "
					+ ReflectionUtil.getColunaFromField(persistenceDTO.getChavePrimaria()).nome() + " DESC LIMIT 1");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				value = resultSet.getInt(ReflectionUtil.getColunaFromField(persistenceDTO.getChavePrimaria()).nome());
			}
			resultSet.close();
			preparedStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return value;
	}

	public static List<Object[]> resultSetToList(ResultSet resultSet) throws SQLException {
		ResultSetMetaData md = resultSet.getMetaData();
		int columns = md.getColumnCount();
		List<Object[]> rows = new ArrayList<Object[]>();
		while (resultSet.next()) {
			Object[] row = new Object[columns];
			for (int i = 1; i <= columns; ++i) {
				row[i - 1] = resultSet.getObject(i);
			}
			rows.add(row);
		}
		return rows;
	}

	public static void writeObjectInFile(Object object, String fileName) {
		try {
			File file = new File(fileName);

			if (!file.exists())
				file.createNewFile();

			Object[] oldObjects = listObjectsFromFile(null, fileName);
			Object[] objects = Arrays.copyOf(oldObjects, oldObjects.length + 1);
			objects[objects.length - 1] = object;

			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(objects);
			objectOutputStream.close();
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File is not present.");
		}
	}

	public static Object[] listObjectsFromFile(Class<?> objectClass, String fileName) {
		Object[] objects = new Object[1];
		try (ObjectInputStream ins = new ObjectInputStream(new FileInputStream(fileName))) {
			objects = (Object[]) ins.readObject();
			ins.close();
		} catch (Exception e) {
		}
		return Arrays.stream(objects).filter(Objects::nonNull)
				.filter(o -> objectClass == null || o.getClass().equals(objectClass)).toArray();
	}

	public static void setParameter(PreparedStatement preparedStatement, int index, Object value) {
		String typeName = value == null ? "null" : value.getClass().getTypeName();
		try {
			switch (typeName) {
			case "java.lang.String":
				preparedStatement.setString(index, (String) value);
				break;
			case "java.lang.Integer":
				preparedStatement.setInt(index, (Integer) value);
				break;
			case "java.lang.Double":
				preparedStatement.setDouble(index, (Double) value);
				break;
			case "java.lang.Long":
				preparedStatement.setLong(index, (Long) value);
				break;
			case "java.lang.Boolean":
				preparedStatement.setBoolean(index, (boolean) value);
				break;
			case "java.util.Date":
				preparedStatement.setDate(index, new java.sql.Date(((Date) value).getTime()));
				break;
			case "null":
				preparedStatement.setString(index, new String());
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
