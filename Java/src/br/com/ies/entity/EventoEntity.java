package br.com.ies.entity;

import br.com.ies.annotation.Coluna;
import br.com.ies.annotation.Tabela;

@Tabela(schema="evento", nome="evento")
public class EventoEntity {

	@Coluna(nome="eve_codigo")
	private Integer          eveCodigo;
	
	private LocalEntity      localEntity;
	private ArtistaEntity    artistaEntity;
	private TipoEventoEntity tipoEventoEntity;
	private UsuarioEntity    aberturaUsuarioEntity;
	
	@Coluna(nome="eve_titulo")
	private String           eveTitulo;
	
	@Coluna(nome="eve_qtd_ingressos")
	private Integer          eveQtdIngressos;
	
	@Coluna(nome="eve_valor_ingresso")
	private Double           eveValorIngresso;
	
	
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
	
	
	
}
