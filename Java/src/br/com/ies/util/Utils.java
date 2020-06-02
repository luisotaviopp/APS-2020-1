package br.com.ies.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import br.com.ies.annotation.ChaveEstrangeira;
import br.com.ies.annotation.ChavePrimaria;
import br.com.ies.annotation.Coluna;
import br.com.ies.annotation.Tabela;
import br.com.ies.dto.ColumnValueDTO;

public class Utils {

	
	public static Tabela getTabelaFromClass(Class<?> clazz) {
		return clazz.getAnnotation(Tabela.class);
	}
	
	public static Coluna getColunaFromField(Field field) {
		return field.getAnnotation(Coluna.class);
	}
	public static boolean isChaveEstrageira(Field field) {
		return field.getAnnotation(ChaveEstrangeira.class) != null;
	}
	
	public static List<Field> getDeclaredFieldsByAnnotation(Class<?> clazz, Class<? extends Annotation> annotation){
		return Arrays
				.stream(clazz.getDeclaredFields())
				.filter(f -> f.isAnnotationPresent(annotation))
				.collect(Collectors.toList());
	}
	public static Field getChavePrimaria(Object object) {
		return getDeclaredFieldsByAnnotation(object.getClass(), ChavePrimaria.class).stream().findFirst().orElse(null);
	}

	public static Object getFieldValue(Field field, Object fromObject) throws IllegalArgumentException, IllegalAccessException {
		field.setAccessible(true);
		return field.get(fromObject);
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
