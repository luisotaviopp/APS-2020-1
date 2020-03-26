package br.com.ies.entity;

import br.com.ies.annotation.Coluna;
import br.com.ies.annotation.Tabela;

@Tabela(schema="evento", nome="artista")
public class ArtistaEntity {

	@Coluna(nome="art_codigo")
	private Integer artCodigo;
	
	@Coluna(nome="art_nome")
	private String  artNome;
	
	@Coluna(nome="art_descricao")
	private String  artDescricao;
	
	
	public Integer getArtCodigo() {
		return artCodigo;
	}
	public void setArtCodigo(Integer artCodigo) {
		this.artCodigo = artCodigo;
	}
	public String getArtNome() {
		return artNome;
	}
	public void setArtNome(String artNome) {
		this.artNome = artNome;
	}
	public String getArtDescricao() {
		return artDescricao;
	}
	public void setArtDescricao(String artDescricao) {
		this.artDescricao = artDescricao;
	}
	
	
	
}
