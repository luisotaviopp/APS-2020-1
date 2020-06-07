package br.com.ies.backend.entity;

import java.io.Serializable;

import br.com.ies.backend.annotation.ChavePrimaria;
import br.com.ies.backend.annotation.Coluna;
import br.com.ies.backend.annotation.Tabela;

@Tabela(schema="faturamento", nome="situacao_venda")
public class SituacaoVendaEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@ChavePrimaria
	@Coluna(nome = "siv_codigo")
	private Integer sivCodigo;

	@Coluna(nome = "siv_descricao")
	private String sivDescricao;

	public Integer getSivCodigo() {
		return sivCodigo;
	}

	public void setSivCodigo(Integer sivCodigo) {
		this.sivCodigo = sivCodigo;
	}

	public String getSivDescricao() {
		return sivDescricao;
	}

	public void setSivDescricao(String sivDescricao) {
		this.sivDescricao = sivDescricao;
	}

	@Override
	public String toString() {
		return "SituacaoVendaEntity [sivCodigo=" + sivCodigo + ", sivDescricao=" + sivDescricao + "]";
	}

}
