package br.com.ies.entity;

import br.com.ies.annotation.Coluna;

import java.io.Serializable;

import br.com.ies.annotation.ChaveEstrangeira;
import br.com.ies.annotation.ChavePrimaria;
import br.com.ies.annotation.Tabela;

@Tabela(schema = "faturamento", nome = "venda_ingresso")
public class VendaIngressoEntity implements Serializable {

	private static final long serialVersionUID = 8126488599761660643L;

	@ChavePrimaria
	@Coluna(nome = "vei_codigo")
	private Integer veiCodigo;

	@ChaveEstrangeira
	@Coluna(nome = "ven_codigo")
	private VendaEntity vendaEntity;

	@Coluna(nome = "vei_nome")
	private String veiNome;

	@Coluna(nome = "vei_documento")
	private String veiDocumento;

	@Coluna(nome = "vei_utilizado")
	private Boolean veiUtilizado;

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

	@Override
	public String toString() {
		return "VendaIngressoEntity [veiCodigo=" + veiCodigo + ", vendaEntity=" + vendaEntity + ", veiNome=" + veiNome
				+ ", veiDocumento=" + veiDocumento + ", veiUtilizado=" + veiUtilizado + "]";
	}

}
