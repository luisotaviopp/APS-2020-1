package br.com.ies.backend.entity;

import java.io.Serializable;

import br.com.ies.backend.annotation.ChaveEstrangeira;
import br.com.ies.backend.annotation.ChavePrimaria;
import br.com.ies.backend.annotation.Coluna;
import br.com.ies.backend.annotation.Tabela;

@Tabela(schema="faturamento", nome="venda")
public class VendaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ChavePrimaria
	@Coluna(nome = "ven_codigo")
	private Integer venCodigo;

	@ChaveEstrangeira
	@Coluna(nome = "siv_codigo")
	private SituacaoVendaEntity situacaoVendaEntity;

	@ChaveEstrangeira
	@Coluna(nome = "vep_codigo")
	private VendaPagamentoEntity vendaPagamentoEntity;

	@ChaveEstrangeira
	@Coluna(nome = "usr_codigo")
	private UsuarioEntity usuarioEntity;

	@ChaveEstrangeira
	@Coluna(nome = "eve_codigo")
	private EventoEntity eventoEntity;
	
	
	public Integer getVenCodigo() {
		return venCodigo;
	}
	public void setVenCodigo(Integer venCodigo) {
		this.venCodigo = venCodigo;
	}
	public SituacaoVendaEntity getSituacaoVendaEntity() {
		return situacaoVendaEntity;
	}
	public void setSituacaoVendaEntity(SituacaoVendaEntity situacaoVendaEntity) {
		this.situacaoVendaEntity = situacaoVendaEntity;
	}
	public VendaPagamentoEntity getVendaPagamentoEntity() {
		return vendaPagamentoEntity;
	}
	public void setVendaPagamentoEntity(VendaPagamentoEntity vendaPagamentoEntity) {
		this.vendaPagamentoEntity = vendaPagamentoEntity;
	}
	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}
	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}
	public EventoEntity getEventoEntity() {
		return eventoEntity;
	}
	public void setEventoEntity(EventoEntity eventoEntity) {
		this.eventoEntity = eventoEntity;
	}
	@Override
	public String toString() {
		return "VendaEntity [venCodigo=" + venCodigo + ", situacaoVendaEntity=" + situacaoVendaEntity
				+ ", vendaPagamentoEntity=" + vendaPagamentoEntity + ", usuarioEntity=" + usuarioEntity
				+ ", eventoEntity=" + eventoEntity + "]";
	}
	
	
}
