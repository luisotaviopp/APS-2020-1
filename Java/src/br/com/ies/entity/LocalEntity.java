package br.com.ies.entity;

import br.com.ies.annotation.Coluna;
import br.com.ies.annotation.Tabela;

@Tabela(schema="evento", nome="local")
public class LocalEntity {

	
	@Coluna(nome = "loc_codigo")
	private Integer locCodigo;

	@Coluna(nome = "loc_logradouro")
	private String locLogradouro;

	@Coluna(nome = "loc_numero")
	private String locNumero;

	@Coluna(nome = "loc_bairro")
	private String locBairro;

	@Coluna(nome = "loc_cidade")
	private String locCidade;

	@Coluna(nome = "loc_uf")
	private String locUf;

	@Coluna(nome = "loc_lotacao_maxima")
	private Integer locLotacaoMaxima;
	
	
	public Integer getLocCodigo() {
		return locCodigo;
	}
	public void setLocCodigo(Integer locCodigo) {
		this.locCodigo = locCodigo;
	}
	public String getLocLogradouro() {
		return locLogradouro;
	}
	public void setLocLogradouro(String locLogradouro) {
		this.locLogradouro = locLogradouro;
	}
	public String getLocBairro() {
		return locBairro;
	}
	public void setLocBairro(String locBairro) {
		this.locBairro = locBairro;
	}
	public String getLocCidade() {
		return locCidade;
	}
	public void setLocCidade(String locCidade) {
		this.locCidade = locCidade;
	}
	public String getLocUf() {
		return locUf;
	}
	public void setLocUf(String locUf) {
		this.locUf = locUf;
	}
	public Integer getLocLotacaoMaxima() {
		return locLotacaoMaxima;
	}
	public void setLocLotacaoMaxima(Integer locLotacaoMaxima) {
		this.locLotacaoMaxima = locLotacaoMaxima;
	}

	
	
}
