package br.com.ies.entity;

import br.com.ies.annotation.Coluna;
import br.com.ies.annotation.ChavePrimaria;
import br.com.ies.annotation.Tabela;

@Tabela(schema="evento", nome="tipo_evento")
public class TipoEventoEntity {

	@ChavePrimaria
	@Coluna(nome = "tie_codigo")
	private Integer tieCodigo;

	@Coluna(nome = "tie_descricao")
	private String ticDescricao;

	public Integer getTieCodigo() {
		return tieCodigo;
	}

	public void setTieCodigo(Integer tieCodigo) {
		this.tieCodigo = tieCodigo;
	}

	public String getTicDescricao() {
		return ticDescricao;
	}

	public void setTicDescricao(String ticDescricao) {
		this.ticDescricao = ticDescricao;
	}
	
}
