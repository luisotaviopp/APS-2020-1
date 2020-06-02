package br.com.ies.entity;

import br.com.ies.annotation.Coluna;

import java.io.Serializable;

import br.com.ies.annotation.ChavePrimaria;
import br.com.ies.annotation.Tabela;

@Tabela(schema="evento", nome="artista")
public class ArtistaEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ChavePrimaria
	@Coluna(nome = "art_codigo")
	private Integer artCodigo;

	@Coluna(nome = "art_nome")
	private String artNome;

	@Coluna(nome = "art_descricao")
	private String artDescricao;

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

	@Override
	public String toString() {
		return "ArtistaEntity [artCodigo=" + artCodigo + ", artNome=" + artNome + ", artDescricao=" + artDescricao
				+ "]";
	}
	
}
