package br.com.ies.backend.entity;

import java.io.Serializable;

import br.com.ies.backend.annotation.ChavePrimaria;
import br.com.ies.backend.annotation.Coluna;
import br.com.ies.backend.annotation.Tabela;

@Tabela(schema = "usuario", nome = "nivel")
public class NivelEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ChavePrimaria
	@Coluna(nome = "nvl_codigo")
	private Integer nvlCodigo;

	@Coluna(nome = "nvl_descricao")
	private String nvlDescricao;

	public Integer getNvlCodigo() {
		return nvlCodigo;
	}

	public void setNvlCodigo(Integer nvlCodigo) {
		this.nvlCodigo = nvlCodigo;
	}

	public String getNvlDescricao() {
		return nvlDescricao;
	}

	public void setNvlDescricao(String nvlDescricao) {
		this.nvlDescricao = nvlDescricao;
	}

	@Override
	public String toString() {
		return "NivelEntity [nvlCodigo=" + nvlCodigo + ", nvlDescricao=" + nvlDescricao + "]";
	}

}
