package br.com.ies.type;

public enum QueryType {

	CONFLICT_QUERY("%insert_query% ON CONFLICT(%primary_key%) DO %update%"),
	INSERT_QUERY("INSERT INTO %table% (%format%) VALUES(%values%)"),
	UPDATE_QUERY("UPDATE SET %values%");
	
	private String query;
	
	private QueryType(String query) {
		this.query = query;
	}
	public String getQuery() {
		return query;
	}
}
