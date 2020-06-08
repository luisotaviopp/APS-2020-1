package br.com.ies.backend.type;

public enum QueryType {

	INSERT_QUERY("INSERT INTO %s (%s) VALUES(%s)"),
	UPDATE_QUERY("UPDATE %s SET %s WHERE %s");
	
	private String query;
	
	private QueryType(String query) {
		this.query = query;
	}
	public String getQuery() {
		return query;
	}
}