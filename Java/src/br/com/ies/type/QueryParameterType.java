package br.com.ies.type;

public enum QueryParameterType {

	INSERT_QUERY("%insert_query%"), 
	PRIMARY_KEY("%primary_key%"), 
	UPDATE("%update%"), 
	TABLE("%table%"),
	TABLE_VALUES("%format%"),
	VALUES("%values%");

	private String text;

	private QueryParameterType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
