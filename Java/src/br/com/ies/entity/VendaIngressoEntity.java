package br.com.ies.entity;

public class VendaIngressoEntity {

	
	private Integer     veiCodigo;
	private VendaEntity vendaEntity;
	private String      veiNome;
	private String      veiDocumento;
	private Boolean     veiUtilizado;
	
	
	public Integer getVeiCodigo() {
		return veiCodigo;
	}
	public void setVeiCodigo(Integer veiCodigo) {
		this.veiCodigo = veiCodigo;
	}
	public VendaEntity getVendaEntity() {
		return vendaEntity;
	}
	public void setVendaEntity(VendaEntity vendaEntity) {
		this.vendaEntity = vendaEntity;
	}
	public String getVeiNome() {
		return veiNome;
	}
	public void setVeiNome(String veiNome) {
		this.veiNome = veiNome;
	}
	public String getVeiDocumento() {
		return veiDocumento;
	}
	public void setVeiDocumento(String veiDocumento) {
		this.veiDocumento = veiDocumento;
	}
	public Boolean getVeiUtilizado() {
		return veiUtilizado;
	}
	public void setVeiUtilizado(Boolean veiUtilizado) {
		this.veiUtilizado = veiUtilizado;
	}
	
	
	
}
