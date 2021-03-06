package br.com.ies.backend.entity;

import java.io.Serializable;
import java.util.Date;

import br.com.ies.backend.annotation.ChaveEstrangeira;
import br.com.ies.backend.annotation.ChavePrimaria;
import br.com.ies.backend.annotation.Coluna;
import br.com.ies.backend.annotation.Tabela;

@Tabela(schema="evento", nome="evento")
public class EventoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ChavePrimaria
	@Coluna(nome = "eve_codigo")
	private Integer eveCodigo;

	@ChaveEstrangeira
	@Coluna(nome = "loc_codigo")
	private LocalEntity localEntity;

	@ChaveEstrangeira
	@Coluna(nome = "art_codigo")
	private ArtistaEntity artistaEntity;

	@ChaveEstrangeira
	@Coluna(nome = "tie_codigo")
	private TipoEventoEntity tipoEventoEntity;

	@ChaveEstrangeira
	@Coluna(nome = "usr_codigo_abertura")
	private UsuarioEntity aberturaUsuarioEntity;

	@Coluna(nome = "eve_titulo")
	private String eveTitulo;

	@Coluna(nome = "eve_qtd_ingressos")
	private Integer eveQtdIngressos;

	@Coluna(nome = "eve_valor_ingresso")
	private Double eveValorIngresso;
	
	@Coluna(nome = "eve_data")
	private Date eveData;

	public Integer getEveCodigo() {
		return eveCodigo;
	}

	public void setEveCodigo(Integer eveCodigo) {
		this.eveCodigo = eveCodigo;
	}

	public LocalEntity getLocalEntity() {
		return localEntity;
	}

	public void setLocalEntity(LocalEntity localEntity) {
		this.localEntity = localEntity;
	}

	public ArtistaEntity getArtistaEntity() {
		return artistaEntity;
	}

	public void setArtistaEntity(ArtistaEntity artistaEntity) {
		this.artistaEntity = artistaEntity;
	}

	public TipoEventoEntity getTipoEventoEntity() {
		return tipoEventoEntity;
	}

	public void setTipoEventoEntity(TipoEventoEntity tipoEventoEntity) {
		this.tipoEventoEntity = tipoEventoEntity;
	}

	public UsuarioEntity getAberturaUsuarioEntity() {
		return aberturaUsuarioEntity;
	}

	public void setAberturaUsuarioEntity(UsuarioEntity aberturaUsuarioEntity) {
		this.aberturaUsuarioEntity = aberturaUsuarioEntity;
	}

	public String getEveTitulo() {
		return eveTitulo;
	}

	public void setEveTitulo(String eveTitulo) {
		this.eveTitulo = eveTitulo;
	}

	public Integer getEveQtdIngressos() {
		return eveQtdIngressos;
	}

	public void setEveQtdIngressos(Integer eveQtdIngressos) {
		this.eveQtdIngressos = eveQtdIngressos;
	}

	public Double getEveValorIngresso() {
		return eveValorIngresso;
	}

	public void setEveValorIngresso(Double eveValorIngresso) {
		this.eveValorIngresso = eveValorIngresso;
	}
	
	public Date getEveData() {
		return eveData;
	}

	public void setEveData(Date eveData) {
		this.eveData = eveData;
	}

	@Override
	public String toString() {
		return "EventoEntity [eveCodigo=" + eveCodigo + ", localEntity=" + localEntity + ", artistaEntity="
				+ artistaEntity + ", tipoEventoEntity=" + tipoEventoEntity + ", aberturaUsuarioEntity="
				+ aberturaUsuarioEntity + ", eveTitulo=" + eveTitulo + ", eveQtdIngressos=" + eveQtdIngressos
				+ ", eveValorIngresso=" + eveValorIngresso + "]";
	}

}
