package br.com.ies.backend.entity;

import java.io.Serializable;

import br.com.ies.backend.annotation.ChavePrimaria;
import br.com.ies.backend.annotation.Coluna;
import br.com.ies.backend.annotation.Tabela;

@Tabela(schema="faturamento", nome="forma_pagamento")
public class FormaPagamentoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ChavePrimaria
	@Coluna(nome = "fop_codigo")
	private Integer fopCodigo;

	@Coluna(nome = "fop_descricao")
	private String fopDescricao;

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

	@Override
	public String toString() {
		return "FormaPagamentoEntity [fopCodigo=" + fopCodigo + ", fopDescricao=" + fopDescricao + "]";
	}
	
}
