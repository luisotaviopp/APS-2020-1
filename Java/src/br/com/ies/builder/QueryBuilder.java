package br.com.ies.builder;

import java.lang.reflect.Field;
import java.util.ArrayList;

import br.com.ies.annotation.Coluna;
import br.com.ies.annotation.Tabela;
import br.com.ies.dto.ColumnValueDTO;
import br.com.ies.dto.QueryDTO;
import br.com.ies.util.Utils;

public class QueryBuilder {

	private Object object;

	public QueryBuilder(Object object) {
		this.object = object;
	}

	public QueryDTO build() throws IllegalArgumentException, IllegalAccessException {
		QueryDTO queryDto = new QueryDTO();
		
		Tabela table = Utils.getTabelaFromClass(object.getClass());
		ArrayList<ColumnValueDTO> columnValueSet = new ArrayList<>();

		queryDto.setSchema(table.schema());
		queryDto.setTabela(table.nome());
		
		for(Field field : Utils.getDeclaredFieldsByAnnotation(object.getClass(), Coluna.class)) {
			ColumnValueDTO columnValueDto = new ColumnValueDTO();
			Object value = Utils.getFieldValue(field, object);
			
			columnValueDto.setColumn(Utils.getColunaFromField(field).nome());
			columnValueDto.setValue(Utils.getFieldValue(field, object) == null ? null : (Utils.isChaveEstrageira(field) ? Utils.getFieldValue(Utils.getChavePrimaria(value), value) : value));
			
			columnValueSet.add(columnValueDto);
		}
		queryDto.setColumnValue(columnValueSet);
		queryDto.setChavePrimaria(Utils.getChavePrimaria(object));
		
		return queryDto;
	}
}
