package br.com.ies.dto;

public class ColumnValueDTO {

	private String column;
	private Object value;

	public ColumnValueDTO() {
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
