package br.com.ies.entity;

import java.util.Date;

public class ControleAcessoEntity {

	
	private Integer 		coaCodigo;
	private UsuarioEntity   usuarioEntity;
	private Date            coaData;
	
	
	public Integer getCoaCodigo() {
		return coaCodigo;
	}
	public void setCoaCodigo(Integer coaCodigo) {
		this.coaCodigo = coaCodigo;
	}
	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}
	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}
	public Date getCoaData() {
		return coaData;
	}
	public void setCoaData(Date coaData) {
		this.coaData = coaData;
	}
}
