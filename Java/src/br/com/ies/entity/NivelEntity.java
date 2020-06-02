package br.com.ies.entity;

import br.com.ies.annotation.Coluna;

import java.io.Serializable;

import br.com.ies.annotation.ChavePrimaria;
import br.com.ies.annotation.Tabela;

@Tabela(schema = "usuario", nome = "nivel")
public class NivelEntity implements Serializable {

	private static final long serialVersionUID = 4315542634045806953L;

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
