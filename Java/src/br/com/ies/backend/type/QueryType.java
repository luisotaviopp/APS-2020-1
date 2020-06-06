package br.com.ies.backend.type;

public enum QueryType {

	CONFLICT_QUERY("%s ON CONFLICT(%s) DO %s"),
	INSERT_QUERY("INSERT INTO %s (%s) VALUES(%s)"),
	UPDATE_QUERY("UPDATE SET %s"),
	SELECT_QUERY("SELECT %s FROM %s.%s ");
	
	private String query;
	
	private QueryType(String query) {
		this.query = query;
	}
	public String getQuery() {
		return query;
	}
}
