package br.com.ies.backend.entity;

import java.io.Serializable;

import br.com.ies.backend.annotation.ChaveEstrangeira;
import br.com.ies.backend.annotation.ChavePrimaria;
import br.com.ies.backend.annotation.Coluna;
import br.com.ies.backend.annotation.Tabela;

@Tabela(schema = "faturamento", nome = "venda_pagamento")
public class VendaPagamentoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ChavePrimaria
	@Coluna(nome = "vep_codigo")
	private Integer vepCodigo;

	@ChaveEstrangeira
	@Coluna(nome = "fop_codigo")
	private FormaPagamentoEntity formaPagamentoEntity;

	@Coluna(nome = "vep_valor")
	private Double vepValor;

	@Coluna(nome = "vep_qtd_parcelas")
	private Integer vepQtdParcelas;
	
	@ChaveEstrangeira
	@Coluna(nome = "ven_codigo")
	private VendaEntity vendaEntity;

	public Integer getVepCodigo() {
		return vepCodigo;
	}

	public void setVepCodigo(Integer vepCodigo) {
		this.vepCodigo = vepCodigo;
	}

	public FormaPagamentoEntity getFormaPagamentoEntity() {
		return formaPagamentoEntity;
	}

	public void setFormaPagamentoEntity(FormaPagamentoEntity formaPagamentoEntity) {
		this.formaPagamentoEntity = formaPagamentoEntity;
	}

	public Double getVepValor() {
		return vepValor;
	}

	public void setVepValor(Double vepValor) {
		this.vepValor = vepValor;
	}

	public Integer getVepQtdParcelas() {
		return vepQtdParcelas;
	}

	public void setVepQtdParcelas(Integer vepQtdParcelas) {
		this.vepQtdParcelas = vepQtdParcelas;
	}
	
	public VendaEntity getVendaEntity() {
		return vendaEntity;
	}

	public void setVendaEntity(VendaEntity vendaEntity) {
		this.vendaEntity = vendaEntity;
	}

	@Override
	public String toString() {
		return "VendaPagamentoEntity [vepCodigo=" + vepCodigo + ", formaPagamentoEntity=" + formaPagamentoEntity
				+ ", vepValor=" + vepValor + ", vepQtdParcelas=" + vepQtdParcelas + "]";
	}

}
