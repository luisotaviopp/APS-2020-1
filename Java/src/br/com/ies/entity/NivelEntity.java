package br.com.ies.entity;

import br.com.ies.annotation.Coluna;
import br.com.ies.annotation.Tabela;

@Tabela(schema="usuario", nome="nivel")
public class NivelEntity {

	
	@Coluna(nome="nvl_codigo")
	private Integer nvlCodigo;
	
	@Coluna(nome= "nvl_descricao")
	private String  nvlDescricao;

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

}
