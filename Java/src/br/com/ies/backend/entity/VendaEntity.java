package br.com.ies.backend.entity;

import java.io.Serializable;
import java.util.Date;

import br.com.ies.backend.annotation.ChaveEstrangeira;
import br.com.ies.backend.annotation.ChavePrimaria;
import br.com.ies.backend.annotation.Coluna;
import br.com.ies.backend.annotation.Tabela;

@Tabela(schema = "faturamento", nome = "venda")
public class VendaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ChavePrimaria
	@Coluna(nome = "ven_codigo")
	private Integer venCodigo;

	@ChaveEstrangeira
	@Coluna(nome = "siv_codigo")
	private SituacaoVendaEntity situacaoVendaEntity;

	@ChaveEstrangeira
	@Coluna(nome = "usr_codigo")
	private UsuarioEntity usuarioEntity;

	@ChaveEstrangeira
	@Coluna(nome = "eve_codigo")
	private EventoEntity eventoEntity;

	@Coluna(nome = "ven_data")
	private Date venData;

	@Coluna(nome = "ven_qtd")
	private Integer venQtd;

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

	public Date getVenData() {
		return venData;
	}

	public void setVenData(Date venData) {
		this.venData = venData;
	}
	

	
	public Integer getVenQtd() {
		return venQtd;
	}

	public void setVenQtd(Integer venQtd) {
		this.venQtd = venQtd;
	}

	@Override
	public String toString() {
		return "VendaEntity [venCodigo=" + venCodigo + ", situacaoVendaEntity=" + situacaoVendaEntity
				+ ", usuarioEntity=" + usuarioEntity + ", eventoEntity=" + eventoEntity + ", venData=" + venData + "]";
	}

}
