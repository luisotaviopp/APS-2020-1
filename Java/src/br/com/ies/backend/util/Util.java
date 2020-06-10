package br.com.ies.backend.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

import javax.swing.JOptionPane;

import br.com.ies.backend.dto.ColumnValueDTO;

public class Util {

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

	@SuppressWarnings("unchecked")
	public static List<Object[]> castObjectToList(Object object) {
		return (List<Object[]>) object;
	}

	public static String dateToString(String format, Date date) {
		return new SimpleDateFormat(format).format(date);
	}

	public static void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public static String[] listToArray(List<String> list) {
		return list.stream().toArray(String[]::new);
	}

	public static String fillColunasAndValuesFromColumnStringList(List<String> columnStringList) {
		StringJoiner stringJoiner = new StringJoiner(",");
		columnStringList.forEach(cs -> stringJoiner.add(cs));
		return stringJoiner.toString();
	}

	public static void removeColumnFromList(String column, List<ColumnValueDTO> list) {
		Iterator<ColumnValueDTO> iterator = list.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getColumn().equalsIgnoreCase(column))
				iterator.remove();
		}
	}
}
