package br.com.ies.frontend.util;

public enum RelatoriosDisponiveis {
	INGRESSOS_DISPONIVEIS("Ingressos Disponíveis"
			, "Cód., Titulo, Ing. Disponiveis, Ing. Vendidos"
			," select evento.eve_codigo, eve_titulo, eve_qtd_ingressos as disponivel, COUNT (vei_codigo) as vendidos from evento.evento " + 
			" INNER JOIN faturamento.venda ON venda.eve_codigo = evento.eve_codigo " + 
			" INNER JOIN faturamento.venda_ingresso ON venda_ingresso.ven_codigo = venda.ven_codigo " + 
			" GROUP BY evento.eve_codigo, eve_titulo, eve_qtd_ingressos "),
	VENDAS_POR_SITUACAO("Vendas por situação"
			, "Situação, Quantidade"
			," SELECT siv_descricao, COUNT(venda.ven_codigo) as quantidade FROM faturamento.situacao_venda " + 
				" FULL OUTER JOIN faturamento.venda ON venda.siv_codigo = situacao_venda.siv_codigo " + 
				" group by siv_descricao "),
	ACESSOS_USUARIO("Acessos Usuário",
					"Nome, Cód., Total de acessos, Ultimos 30 dias",
					"SELECT usr_nome, sq.usr_codigo, SUM(acessos) as acessos, SUM (acessos_ultimo_mes) as acessos_ultimo_mes FROM ( " + 
					"	SELECT usr_codigo, count(coa_codigo) as acessos, 0 as acessos_ultimo_mes FROM usuario.controle_acesso " + 
					"	GROUP BY usr_codigo " + 
					" " + 
					"	UNION " + 
					" " + 
					"	SELECT usr_codigo, 0, count(coa_codigo) as acessos_ultimo_mes FROM usuario.controle_acesso " + 
					"	WHERE coa_data BETWEEN current_timestamp - ('1 month')::interval AND current_timestamp " + 
					"	GROUP BY usr_codigo " + 
					") sq " + 
					"INNER JOIN usuario.usuario ON usuario.usr_codigo = sq.usr_codigo " + 
					"GROUP BY sq.usr_codigo, usr_nome"),
	VENDAS_TRIMESTRE("Vendas por Trimestre",
					 "Cód., Artista, T1, T2, T3, T4",
					 "select sq.art_codigo, art_nome, SUM(Q1) as q1, SUM (Q2) as q2, SUM (Q3) as q3, SUM(Q4) as q4 " + 
					 "from  " + 
					 " " + 
					 "( " + 
					 "	select art.art_codigo, art_nome, SUM (ven_qtd * eve_valor_ingresso) as Q1, 0 AS Q2, 0 AS Q3, 0 AS Q4 " + 
					 "	from faturamento.venda " + 
					 "	INNER JOIN evento.evento AS eve ON eve.eve_codigo = venda.eve_codigo " + 
					 "	INNER JOIN evento.artista as art ON art.art_codigo = eve.art_codigo " + 
					 "	WHERE extract(quarter from venda.ven_data) = 1 AND extract(year from venda.ven_data) = extract(year from current_date) " + 
					 "	GROUP BY art.art_codigo, art_nome " + 
					 " " + 
					 "	UNION " + 
					 " " + 
					 "	select art.art_codigo, art_nome, 0, SUM (ven_qtd * eve_valor_ingresso) as Q2, 0, 0 " + 
					 "	from faturamento.venda " + 
					 "	INNER JOIN evento.evento AS eve ON eve.eve_codigo = venda.eve_codigo " + 
					 "	INNER JOIN evento.artista as art ON art.art_codigo = eve.art_codigo " + 
					 "	WHERE extract(quarter from venda.ven_data) = 2 AND extract(year from venda.ven_data) = extract(year from current_date) " + 
					 "	GROUP BY art.art_codigo, art_nome " + 
					 " " + 
					 "	UNION  " + 
					 " " + 
					 "	select art.art_codigo, art_nome, 0, 0, SUM (ven_qtd * eve_valor_ingresso) as Q3, 0 " + 
					 "	from faturamento.venda " + 
					 "	INNER JOIN evento.evento AS eve ON eve.eve_codigo = venda.eve_codigo " + 
					 "	INNER JOIN evento.artista as art ON art.art_codigo = eve.art_codigo " + 
					 "	WHERE extract(quarter from venda.ven_data) = 3 AND extract(year from venda.ven_data) = extract(year from current_date) " + 
					 "	GROUP BY art.art_codigo, art_nome " + 
					 " " + 
					 "	UNION " + 
					 " " + 
					 "	select art.art_codigo, art_nome, 0, 0, 0, SUM (ven_qtd * eve_valor_ingresso) as Q4 " + 
					 "	from faturamento.venda " + 
					 "	INNER JOIN evento.evento AS eve ON eve.eve_codigo = venda.eve_codigo " + 
					 "	INNER JOIN evento.artista as art ON art.art_codigo = eve.art_codigo " + 
					 "	WHERE extract(quarter from venda.ven_data) = 4 AND extract(year from venda.ven_data) = extract(year from current_date) " + 
					 "	GROUP BY art.art_codigo, art_nome " + 
					 ") sq " + 
					 "GROUP BY art_codigo, art_nome");
	
	private String titulo;
	private String colunas;
	private String query;
	
	private RelatoriosDisponiveis(String titulo, String colunas, String query) {
		this.titulo = titulo;
		this.colunas = colunas;
		this.query = query;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public String getColunas() {
		return colunas;
	}
	public String getQuery() {
		return query;
	}
	
}
