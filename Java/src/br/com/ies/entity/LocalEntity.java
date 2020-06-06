package br.com.ies.entity;

import br.com.ies.annotation.Coluna;

import java.io.Serializable;

import br.com.ies.annotation.ChavePrimaria;
import br.com.ies.annotation.Tabela;

@Tabela(schema = "evento", nome = "local")
public class LocalEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ChavePrimaria
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

	@Coluna(nome = "loc_cep")
	private String locCep;

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

	public String getLocNumero() {
		return locNumero;
	}

	public void setLocNumero(String locNumero) {
		this.locNumero = locNumero;
	}

	public String getLocCep() {
		return locCep;
	}

	public void setLocCep(String locCep) {
		this.locCep = locCep;
	}

	@Override
	public String toString() {
		return "LocalEntity [locCodigo=" + locCodigo + ", locLogradouro=" + locLogradouro + ", locNumero=" + locNumero
				+ ", locBairro=" + locBairro + ", locCidade=" + locCidade + ", locUf=" + locUf + ", locLotacaoMaxima="
				+ locLotacaoMaxima + ", locCep=" + locCep + "]";
	}
}
