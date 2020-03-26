package br.com.ies.dto;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class QueryDTO {

	private String schema;
	private String tabela;

	private HashSet<ColunaValorDTO> setColunaValor;

	public QueryDTO() {
		setColunaValor = new HashSet<>();
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

	public void setColunaValor(HashSet<ColunaValorDTO> setColunaValor) {
		this.setColunaValor = setColunaValor;
	}

	public Set<ColunaValorDTO> getColunaValor() {
		return Collections.unmodifiableSet(setColunaValor);
	}

}
