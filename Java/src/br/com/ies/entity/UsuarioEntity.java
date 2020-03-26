package br.com.ies.entity;

public class UsuarioEntity {

	private Integer     usrCodigo;
	private NivelEntity nivelEntity;
	private String      usrNome;
	private String      usrEmail;
	private String      usrLogin;
	private String      usrSenha;
	private Boolean     usrAtivo;
	
	
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
