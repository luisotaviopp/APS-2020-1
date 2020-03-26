package br.com.ies.entity;

public class EventoEntity {

	private Integer          eveCodigo;
	private LocalEntity      localEntity;
	private ArtistaEntity    artistaEntity;
	private TipoEventoEntity tipoEventoEntity;
	private UsuarioEntity    aberturaUsuarioEntity;
	private String           eveTitulo;
	private Integer          eveQtdIngressos;
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
