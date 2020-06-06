package br.com.ies.entity;

import br.com.ies.annotation.Coluna;
import br.com.ies.annotation.ChaveEstrangeira;
import br.com.ies.annotation.ChavePrimaria;
import br.com.ies.annotation.Tabela;

@Tabela(schema="usuario", nome="usuario")
public class UsuarioEntity {

	@ChavePrimaria
	@Coluna(nome = "usr_codigo")
	private Integer usrCodigo;

	@ChaveEstrangeira
	@Coluna(nome = "nvl_codigo")
	private NivelEntity nivelEntity;

	@Coluna(nome = "usr_nome")
	private String usrNome;

	@Coluna(nome = "usr_email")
	private String usrEmail;

	@Coluna(nome = "usr_login")
	private String usrLogin;

	@Coluna(nome = "usr_senha")
	private String usrSenha;

	@Coluna(nome = "usr_ativo")
	private Boolean usrAtivo;
	
	public Integer getUsrCodigo() {
		return usrCodigo;
	}

	public void setUsrCodigo(Integer usrCodigo) {
		this.usrCodigo = usrCodigo;
	}

	public NivelEntity getNivelEntity() {
		return nivelEntity;
	}

	public void setNivelEntity(NivelEntity nivelEntity) {
		this.nivelEntity = nivelEntity;
	}

	public String getUsrNome() {
		return usrNome;
	}

	public void setUsrNome(String usrNome) {
		this.usrNome = usrNome;
	}

	public String getUsrEmail() {
		return usrEmail;
	}

	public void setUsrEmail(String usrEmail) {
		this.usrEmail = usrEmail;
	}

	public String getUsrLogin() {
		return usrLogin;
	}

	public void setUsrLogin(String usrLogin) {
		this.usrLogin = usrLogin;
	}

	public String getUsrSenha() {
		return usrSenha;
	}

	public void setUsrSenha(String usrSenha) {
		this.usrSenha = usrSenha;
	}

	public Boolean getUsrAtivo() {
		return usrAtivo;
	}

	public void setUsrAtivo(Boolean usrAtivo) {
		this.usrAtivo = usrAtivo;
	}

}
