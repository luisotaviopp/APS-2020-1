package br.com.ies.type;

public enum StringType {

	DATABASE_URL("jdbc:postgresql://localhost:5432/faculdade");

	private String text;
	
	private StringType(String text) {
		this.text = text;
	}
	public String getText() {
		return text;
	}
	
}
