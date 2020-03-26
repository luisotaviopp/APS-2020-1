package br.com.ies.entity;

import br.com.ies.annotation.Coluna;
import br.com.ies.annotation.Tabela;

@Tabela(schema="faturamento", nome="forma_pagamento")
public class FormaPagamentoEntity {

	
	@Coluna(nome="fop_codigo")
	private Integer fopCodigo;
	
	@Coluna(nome="fop_descricao")
	private String  fopDescricao;
	
	
	public Integer getFopCodigo() {
		return fopCodigo;
	}
	public void setFopCodigo(Integer fopCodigo) {
		this.fopCodigo = fopCodigo;
	}
	public String getFopDescricao() {
		return fopDescricao;
	}
	public void setFopDescricao(String fopDescricao) {
		this.fopDescricao = fopDescricao;
	}
	
	
	
}
