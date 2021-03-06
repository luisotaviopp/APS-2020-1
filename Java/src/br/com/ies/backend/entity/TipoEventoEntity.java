package br.com.ies.backend.entity;

import java.io.Serializable;

import br.com.ies.backend.annotation.ChavePrimaria;
import br.com.ies.backend.annotation.Coluna;
import br.com.ies.backend.annotation.Tabela;

@Tabela(schema = "evento", nome = "tipo_evento")
public class TipoEventoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

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

	@Override
	public String toString() {
		return "TipoEventoEntity [tieCodigo=" + tieCodigo + ", ticDescricao=" + ticDescricao + "]";
	}

}
