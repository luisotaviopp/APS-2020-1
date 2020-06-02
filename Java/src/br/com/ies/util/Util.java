package br.com.ies.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import br.com.ies.annotation.ChaveEstrangeira;
import br.com.ies.annotation.ChavePrimaria;
import br.com.ies.annotation.Coluna;
import br.com.ies.annotation.Tabela;
import br.com.ies.dto.ColumnValueDTO;

public class Util {

	public static Tabela getTabelaFromClass(Class<?> clazz) {
		return clazz.getAnnotation(Tabela.class);
	}

	public static Coluna getColunaFromField(Field field) {
		return field.getAnnotation(Coluna.class);
	}

	public static boolean isChaveEstrageira(Field field) {
		return field.getAnnotation(ChaveEstrangeira.class) != null;
	}

	public static List<Field> getDeclaredFieldsByAnnotation(Class<?> clazz, Class<? extends Annotation> annotation) {
		return Arrays.stream(clazz.getDeclaredFields()).filter(f -> f.isAnnotationPresent(annotation))
				.collect(Collectors.toList());
	}

	public static Field getChavePrimaria(Object object) {
		return getDeclaredFieldsByAnnotation(object.getClass(), ChavePrimaria.class).stream().findFirst().orElse(null);
	}

	public static Object getFieldValue(Field field, Object fromObject) {
		field.setAccessible(true);
		try {
			return field.get(fromObject);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String fillCharInString(Character fillChar, int times) {
		StringJoiner stringJoiner = new StringJoiner(",");
		IntStream.range(0, times).forEach(i -> stringJoiner.add(fillChar.toString()));
		return stringJoiner.toString();
	}

	public static String fillColunasNameByColumnValueList(List<ColumnValueDTO> columnValueList) {
		StringJoiner stringJoiner = new StringJoiner(",");
		columnValueList.forEach(cv -> stringJoiner.add(cv.getColumn()));
		return stringJoiner.toString();
	}

	public static String fillColunasAndValuesFromColumnStringList(List<String> columnStringList) {
		StringJoiner stringJoiner = new StringJoiner(",");
		columnStringList.forEach(cs -> stringJoiner.add(cs));
		return stringJoiner.toString();
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
