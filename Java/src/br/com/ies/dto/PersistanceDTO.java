package br.com.ies.dto;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersistanceDTO {

	private Object object;
	private String schema;
	private String tabela;
	private Field chavePrimaria;

	private List<ColumnValueDTO> columnValueSet;

	public PersistanceDTO() {
		columnValueSet = new ArrayList<>();
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getTabela() {
		return tabela;
	}

	public void setTabela(String tabela) {
		this.tabela = tabela;
	}

	public void setColumnValue(List<ColumnValueDTO> columnValueSet) {
		this.columnValueSet = columnValueSet;
	}

	public List<ColumnValueDTO> getColumnValue() {
		return Collections.unmodifiableList(columnValueSet);
	}

	public Field getChavePrimaria() {
		return chavePrimaria;
	}

	public void setChavePrimaria(Field chavePrimaria) {
		this.chavePrimaria = chavePrimaria;
	}

}