package br.com.ies.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ies.annotation.Coluna;
import br.com.ies.annotation.Tabela;

public class Utils {

	
	public static Tabela getTabelaFromClass(Class<?> clazz) {
		return clazz.getAnnotation(Tabela.class);
	}
	
	public static Coluna getColunaFromField(Field field) {
		return field.getAnnotation(Coluna.class);
	}
	public static List<Field> getDeclaredFieldsByAnnotation(Class<?> clazz, Class<? extends Annotation> annotation){
		return Arrays
				.stream(clazz.getDeclaredFields())
				.filter(f -> f.isAnnotationPresent(annotation))
				.collect(Collectors.toList());
	}

	public static Object getFieldValue(Field field, Object fromObject) throws IllegalArgumentException, IllegalAccessException {
		field.setAccessible(true);
		return field.get(fromObject);
	}
}
