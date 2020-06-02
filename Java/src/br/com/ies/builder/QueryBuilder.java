package br.com.ies.builder;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.com.ies.annotation.Coluna;
import br.com.ies.annotation.Tabela;
import br.com.ies.dto.ColumnValueDTO;
import br.com.ies.dto.PersistanceDTO;
import br.com.ies.util.Util;

public class QueryBuilder {

	public static <T> PersistanceDTO build(T object) throws IllegalArgumentException, IllegalAccessException {
		PersistanceDTO queryDto = new PersistanceDTO();

		Tabela table = Util.getTabelaFromClass(object.getClass());
		List<ColumnValueDTO> columnValueSet = new ArrayList<>();

		queryDto.setObject(object);
		queryDto.setSchema(table.schema());
		queryDto.setTabela(table.nome());

		for (Field field : Util.getDeclaredFieldsByAnnotation(object.getClass(), Coluna.class)) {
			ColumnValueDTO columnValueDto = new ColumnValueDTO();
			Object value = Util.getFieldValue(field, object);

			columnValueDto.setColumn(Util.getColunaFromField(field).nome());
			columnValueDto.setValue(Util.getFieldValue(field, object) == null ? null: (Util.isChaveEstrageira(field) ? Util.getFieldValue(Util.getChavePrimaria(value), value): value));
			columnValueSet.add(columnValueDto);
		}
		queryDto.setColumnValue(columnValueSet);
		queryDto.setChavePrimaria(Util.getChavePrimaria(object));

		return queryDto;
	}
}
