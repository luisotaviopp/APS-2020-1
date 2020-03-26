package br.com.ies.entity;

public class VendaPagamentoEntity {

	
	private Integer              vepCodigo;
	private FormaPagamentoEntity formaPagamentoEntity;
	private Double               vepValor;
	private Integer              vepQtdParcelas;
	
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
	
	
}
