package br.com.ies.entity;

import java.util.Date;

import br.com.ies.annotation.Coluna;
import br.com.ies.annotation.ChaveEstrangeira;
import br.com.ies.annotation.ChavePrimaria;
import br.com.ies.annotation.Tabela;

@Tabela(schema="usuario", nome= "controle_acesso")
public class ControleAcessoEntity {

	@ChavePrimaria
	@Coluna(nome = "coa_codigo")
	private Integer coaCodigo;

	@ChaveEstrangeira
	@Coluna(nome = "usr_codigo")
	private UsuarioEntity usuarioEntity;

	@Coluna(nome = "coa_data")
	private Date coaData;

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
