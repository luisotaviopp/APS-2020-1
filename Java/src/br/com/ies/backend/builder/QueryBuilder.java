package br.com.ies.backend.builder;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.com.ies.backend.annotation.Coluna;
import br.com.ies.backend.annotation.Tabela;
import br.com.ies.backend.dto.ColumnValueDTO;
import br.com.ies.backend.dto.PersistenceDTO;
import br.com.ies.backend.util.ReflectionUtil;

public class QueryBuilder {

	public static <T> PersistenceDTO build(T object) throws IllegalArgumentException, IllegalAccessException {
		PersistenceDTO queryDto = new PersistenceDTO();

		Tabela table = ReflectionUtil.getTabelaFromClass(object.getClass());
		List<ColumnValueDTO> columnValueSet = new ArrayList<>();

		queryDto.setObject(object);
		queryDto.setSchema(table.schema());
		queryDto.setTabela(table.nome());

		for (Field field : ReflectionUtil.getDeclaredFieldsByAnnotation(object.getClass(), Coluna.class)) {
			ColumnValueDTO columnValueDto = new ColumnValueDTO();
			Object value = ReflectionUtil.getFieldValue(field, object);

			columnValueDto.setColumn(ReflectionUtil.getColunaFromField(field).nome());
			columnValueDto.setValue(ReflectionUtil.getFieldValue(field, object) == null ? null: (ReflectionUtil.isChaveEstrageira(field) ? ReflectionUtil.getFieldValue(ReflectionUtil.getChavePrimaria(value), value): value));
			columnValueSet.add(columnValueDto);
		}
		queryDto.setColumnValue(columnValueSet);
		queryDto.setChavePrimaria(ReflectionUtil.getChavePrimaria(object));

		return queryDto;
	}
}
