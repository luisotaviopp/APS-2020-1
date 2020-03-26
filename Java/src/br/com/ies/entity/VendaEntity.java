package br.com.ies.entity;

public class VendaEntity {

	
	private Integer              venCodigo;
	private SituacaoVendaEntity  situacaoVendaEntity;
	private VendaPagamentoEntity vendaPagamentoEntity;
	private UsuarioEntity        usuarioEntity;
	private EventoEntity         eventoEntity;
	
	
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
	
	
}
