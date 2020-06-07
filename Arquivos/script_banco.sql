--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: evento; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA evento;


ALTER SCHEMA evento OWNER TO postgres;

--
-- Name: faturamento; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA faturamento;


ALTER SCHEMA faturamento OWNER TO postgres;

--
-- Name: usuario; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA usuario;


ALTER SCHEMA usuario OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: artista; Type: TABLE; Schema: evento; Owner: postgres
--

CREATE TABLE evento.artista (
    art_codigo integer NOT NULL,
    art_nome character(100),
    art_descricao character(100)
);


ALTER TABLE evento.artista OWNER TO postgres;

--
-- Name: artista_art_codigo_seq; Type: SEQUENCE; Schema: evento; Owner: postgres
--

CREATE SEQUENCE evento.artista_art_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE evento.artista_art_codigo_seq OWNER TO postgres;

--
-- Name: artista_art_codigo_seq; Type: SEQUENCE OWNED BY; Schema: evento; Owner: postgres
--

ALTER SEQUENCE evento.artista_art_codigo_seq OWNED BY evento.artista.art_codigo;


--
-- Name: evento; Type: TABLE; Schema: evento; Owner: postgres
--

CREATE TABLE evento.evento (
    eve_codigo integer NOT NULL,
    loc_codigo integer,
    art_codigo integer,
    tie_codigo integer,
    usr_codigo_abertura integer,
    eve_titulo character(50),
    eve_qtd_ingressos integer,
    eve_valor_ingresso double precision
);


ALTER TABLE evento.evento OWNER TO postgres;

--
-- Name: local; Type: TABLE; Schema: evento; Owner: postgres
--

CREATE TABLE evento.local (
    loc_codigo integer NOT NULL,
    loc_logradouro character(255) NOT NULL,
    loc_numero character(10) NOT NULL,
    loc_bairro character(100) NOT NULL,
    loc_cidade character(100) NOT NULL,
    loc_uf character(50) NOT NULL,
    loc_lotacao_maxima integer,
    loc_cep character varying(16)
);


ALTER TABLE evento.local OWNER TO postgres;

--
-- Name: local_loc_codigo_seq; Type: SEQUENCE; Schema: evento; Owner: postgres
--

CREATE SEQUENCE evento.local_loc_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE evento.local_loc_codigo_seq OWNER TO postgres;

--
-- Name: local_loc_codigo_seq; Type: SEQUENCE OWNED BY; Schema: evento; Owner: postgres
--

ALTER SEQUENCE evento.local_loc_codigo_seq OWNED BY evento.local.loc_codigo;


--
-- Name: tipo_evento; Type: TABLE; Schema: evento; Owner: postgres
--

CREATE TABLE evento.tipo_evento (
    tie_codigo integer NOT NULL,
    tie_descricao character(100)
);


ALTER TABLE evento.tipo_evento OWNER TO postgres;

--
-- Name: tipo_evento_tie_codigo_seq; Type: SEQUENCE; Schema: evento; Owner: postgres
--

CREATE SEQUENCE evento.tipo_evento_tie_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE evento.tipo_evento_tie_codigo_seq OWNER TO postgres;

--
-- Name: tipo_evento_tie_codigo_seq; Type: SEQUENCE OWNED BY; Schema: evento; Owner: postgres
--

ALTER SEQUENCE evento.tipo_evento_tie_codigo_seq OWNED BY evento.tipo_evento.tie_codigo;


--
-- Name: forma_pagamento; Type: TABLE; Schema: faturamento; Owner: postgres
--

CREATE TABLE faturamento.forma_pagamento (
    fop_codigo integer NOT NULL,
    fop_descricao character(50)
);


ALTER TABLE faturamento.forma_pagamento OWNER TO postgres;

--
-- Name: forma_pagamento_fop_codigo_seq; Type: SEQUENCE; Schema: faturamento; Owner: postgres
--

CREATE SEQUENCE faturamento.forma_pagamento_fop_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE faturamento.forma_pagamento_fop_codigo_seq OWNER TO postgres;

--
-- Name: forma_pagamento_fop_codigo_seq; Type: SEQUENCE OWNED BY; Schema: faturamento; Owner: postgres
--

ALTER SEQUENCE faturamento.forma_pagamento_fop_codigo_seq OWNED BY faturamento.forma_pagamento.fop_codigo;


--
-- Name: situacao_venda; Type: TABLE; Schema: faturamento; Owner: postgres
--

CREATE TABLE faturamento.situacao_venda (
    siv_codigo integer NOT NULL,
    siv_descricao character(50)
);


ALTER TABLE faturamento.situacao_venda OWNER TO postgres;

--
-- Name: venda; Type: TABLE; Schema: faturamento; Owner: postgres
--

CREATE TABLE faturamento.venda (
    ven_codigo integer NOT NULL,
    siv_codigo integer,
    vep_codigo integer,
    usr_codigo integer,
    eve_codigo integer
);


ALTER TABLE faturamento.venda OWNER TO postgres;

--
-- Name: venda_ingresso; Type: TABLE; Schema: faturamento; Owner: postgres
--

CREATE TABLE faturamento.venda_ingresso (
    vei_codigo integer NOT NULL,
    ven_codigo integer,
    vei_nome character(50),
    vei_documento character(50),
    vei_utilizado boolean
);


ALTER TABLE faturamento.venda_ingresso OWNER TO postgres;

--
-- Name: venda_pagamento; Type: TABLE; Schema: faturamento; Owner: postgres
--

CREATE TABLE faturamento.venda_pagamento (
    vep_codigo integer NOT NULL,
    vep_valor double precision,
    vep_qtd_parcelas integer,
    fop_codigo integer
);


ALTER TABLE faturamento.venda_pagamento OWNER TO postgres;

--
-- Name: controle_acesso; Type: TABLE; Schema: usuario; Owner: postgres
--

CREATE TABLE usuario.controle_acesso (
    usr_codigo integer,
    coa_codigo integer NOT NULL,
    coa_data date
);


ALTER TABLE usuario.controle_acesso OWNER TO postgres;

--
-- Name: controle_acesso_coa_codigo_seq; Type: SEQUENCE; Schema: usuario; Owner: postgres
--

CREATE SEQUENCE usuario.controle_acesso_coa_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuario.controle_acesso_coa_codigo_seq OWNER TO postgres;

--
-- Name: controle_acesso_coa_codigo_seq; Type: SEQUENCE OWNED BY; Schema: usuario; Owner: postgres
--

ALTER SEQUENCE usuario.controle_acesso_coa_codigo_seq OWNED BY usuario.controle_acesso.coa_codigo;


--
-- Name: nivel; Type: TABLE; Schema: usuario; Owner: postgres
--

CREATE TABLE usuario.nivel (
    nvl_codigo integer NOT NULL,
    nvl_descricao character(100)
);


ALTER TABLE usuario.nivel OWNER TO postgres;

--
-- Name: nivel_nvl_codigo_seq; Type: SEQUENCE; Schema: usuario; Owner: postgres
--

CREATE SEQUENCE usuario.nivel_nvl_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuario.nivel_nvl_codigo_seq OWNER TO postgres;

--
-- Name: nivel_nvl_codigo_seq; Type: SEQUENCE OWNED BY; Schema: usuario; Owner: postgres
--

ALTER SEQUENCE usuario.nivel_nvl_codigo_seq OWNED BY usuario.nivel.nvl_codigo;


--
-- Name: usuario; Type: TABLE; Schema: usuario; Owner: postgres
--

CREATE TABLE usuario.usuario (
    usr_codigo integer NOT NULL,
    nvl_codigo integer,
    usr_nome character(100),
    usr_email character(50),
    usr_login character(50),
    usr_senha character(50),
    usr_ativo boolean
);


ALTER TABLE usuario.usuario OWNER TO postgres;

--
-- Name: usuario_usr_codigo_seq; Type: SEQUENCE; Schema: usuario; Owner: postgres
--

CREATE SEQUENCE usuario.usuario_usr_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuario.usuario_usr_codigo_seq OWNER TO postgres;

--
-- Name: usuario_usr_codigo_seq; Type: SEQUENCE OWNED BY; Schema: usuario; Owner: postgres
--

ALTER SEQUENCE usuario.usuario_usr_codigo_seq OWNED BY usuario.usuario.usr_codigo;


--
-- Name: artista art_codigo; Type: DEFAULT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.artista ALTER COLUMN art_codigo SET DEFAULT nextval('evento.artista_art_codigo_seq'::regclass);


--
-- Name: local loc_codigo; Type: DEFAULT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.local ALTER COLUMN loc_codigo SET DEFAULT nextval('evento.local_loc_codigo_seq'::regclass);


--
-- Name: tipo_evento tie_codigo; Type: DEFAULT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.tipo_evento ALTER COLUMN tie_codigo SET DEFAULT nextval('evento.tipo_evento_tie_codigo_seq'::regclass);


--
-- Name: forma_pagamento fop_codigo; Type: DEFAULT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.forma_pagamento ALTER COLUMN fop_codigo SET DEFAULT nextval('faturamento.forma_pagamento_fop_codigo_seq'::regclass);


--
-- Name: controle_acesso coa_codigo; Type: DEFAULT; Schema: usuario; Owner: postgres
--

ALTER TABLE ONLY usuario.controle_acesso ALTER COLUMN coa_codigo SET DEFAULT nextval('usuario.controle_acesso_coa_codigo_seq'::regclass);


--
-- Name: nivel nvl_codigo; Type: DEFAULT; Schema: usuario; Owner: postgres
--

ALTER TABLE ONLY usuario.nivel ALTER COLUMN nvl_codigo SET DEFAULT nextval('usuario.nivel_nvl_codigo_seq'::regclass);


--
-- Name: usuario usr_codigo; Type: DEFAULT; Schema: usuario; Owner: postgres
--

ALTER TABLE ONLY usuario.usuario ALTER COLUMN usr_codigo SET DEFAULT nextval('usuario.usuario_usr_codigo_seq'::regclass);


--
-- Data for Name: artista; Type: TABLE DATA; Schema: evento; Owner: postgres
--

COPY evento.artista (art_codigo, art_nome, art_descricao) FROM stdin;
\.


--
-- Data for Name: evento; Type: TABLE DATA; Schema: evento; Owner: postgres
--

COPY evento.evento (eve_codigo, loc_codigo, art_codigo, tie_codigo, usr_codigo_abertura, eve_titulo, eve_qtd_ingressos, eve_valor_ingresso) FROM stdin;
\.


--
-- Data for Name: local; Type: TABLE DATA; Schema: evento; Owner: postgres
--

COPY evento.local (loc_codigo, loc_logradouro, loc_numero, loc_bairro, loc_cidade, loc_uf, loc_lotacao_maxima, loc_cep) FROM stdin;
18	Rua: Nada4                                                                                                                                                                                                                                                     	159       	Campinas                                                                                            	Palhoca23                                                                                           	SC                                                	80000	\N
12	Rua: Nada                                                                                                                                                                                                                                                      	158       	Campinas                                                                                            	Sao Jose                                                                                            	SC                                                	10000	881132321
13	Rua: Nada2                                                                                                                                                                                                                                                     	158       	Campinas                                                                                            	Palhoca                                                                                             	SC                                                	80000	\N
19	Rua: Nada4                                                                                                                                                                                                                                                     	159       	Campinas                                                                                            	Palhoca23                                                                                           	SC                                                	80000	\N
4	teste                                                                                                                                                                                                                                                          	24        	Daniel                                                                                              	teste                                                                                               	sc                                                	\N	\N
16	Rua: Nada4                                                                                                                                                                                                                                                     	159       	Campinas                                                                                            	Palhoca23                                                                                           	SC                                                	80000	\N
14	Rua: Nada                                                                                                                                                                                                                                                      	158       	Campinas                                                                                            	Palhoca                                                                                             	SC                                                	80000	\N
15	Rua: Nada4                                                                                                                                                                                                                                                     	159       	Campinas                                                                                            	Palhoca23                                                                                           	SC                                                	80000	\N
20	Rua: Nada7                                                                                                                                                                                                                                                     	159       	Campinas                                                                                            	Palhoca23                                                                                           	SC                                                	80000	\N
17	Rua: Nada9                                                                                                                                                                                                                                                     	120       	Campinas                                                                                            	Palhoca23                                                                                           	SC                                                	80000	\N
\.


--
-- Data for Name: tipo_evento; Type: TABLE DATA; Schema: evento; Owner: postgres
--

COPY evento.tipo_evento (tie_codigo, tie_descricao) FROM stdin;
\.


--
-- Data for Name: forma_pagamento; Type: TABLE DATA; Schema: faturamento; Owner: postgres
--

COPY faturamento.forma_pagamento (fop_codigo, fop_descricao) FROM stdin;
\.


--
-- Data for Name: situacao_venda; Type: TABLE DATA; Schema: faturamento; Owner: postgres
--

COPY faturamento.situacao_venda (siv_codigo, siv_descricao) FROM stdin;
\.


--
-- Data for Name: venda; Type: TABLE DATA; Schema: faturamento; Owner: postgres
--

COPY faturamento.venda (ven_codigo, siv_codigo, vep_codigo, usr_codigo, eve_codigo) FROM stdin;
\.


--
-- Data for Name: venda_ingresso; Type: TABLE DATA; Schema: faturamento; Owner: postgres
--

COPY faturamento.venda_ingresso (vei_codigo, ven_codigo, vei_nome, vei_documento, vei_utilizado) FROM stdin;
\.


--
-- Data for Name: venda_pagamento; Type: TABLE DATA; Schema: faturamento; Owner: postgres
--

COPY faturamento.venda_pagamento (vep_codigo, vep_valor, vep_qtd_parcelas, fop_codigo) FROM stdin;
\.


--
-- Data for Name: controle_acesso; Type: TABLE DATA; Schema: usuario; Owner: postgres
--

COPY usuario.controle_acesso (usr_codigo, coa_codigo, coa_data) FROM stdin;
\.


--
-- Data for Name: nivel; Type: TABLE DATA; Schema: usuario; Owner: postgres
--

COPY usuario.nivel (nvl_codigo, nvl_descricao) FROM stdin;
24	talvez                                                                                              
12	Teste                                                                                               
1	teste                                                                                               
\.


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: usuario; Owner: postgres
--

COPY usuario.usuario (usr_codigo, nvl_codigo, usr_nome, usr_email, usr_login, usr_senha, usr_ativo) FROM stdin;
1	12	Jorge1585357796086                                                                                  	teste@teste.com                                   	teste                                             	1235436                                           	t
2	12	Jorge1585357845389                                                                                  	asfasfteste.com                                   	teste                                             	1235436                                           	t
\.


--
-- Name: artista_art_codigo_seq; Type: SEQUENCE SET; Schema: evento; Owner: postgres
--

SELECT pg_catalog.setval('evento.artista_art_codigo_seq', 1, false);


--
-- Name: local_loc_codigo_seq; Type: SEQUENCE SET; Schema: evento; Owner: postgres
--

SELECT pg_catalog.setval('evento.local_loc_codigo_seq', 1, false);


--
-- Name: tipo_evento_tie_codigo_seq; Type: SEQUENCE SET; Schema: evento; Owner: postgres
--

SELECT pg_catalog.setval('evento.tipo_evento_tie_codigo_seq', 1, false);


--
-- Name: forma_pagamento_fop_codigo_seq; Type: SEQUENCE SET; Schema: faturamento; Owner: postgres
--

SELECT pg_catalog.setval('faturamento.forma_pagamento_fop_codigo_seq', 1, false);


--
-- Name: controle_acesso_coa_codigo_seq; Type: SEQUENCE SET; Schema: usuario; Owner: postgres
--

SELECT pg_catalog.setval('usuario.controle_acesso_coa_codigo_seq', 1, false);


--
-- Name: nivel_nvl_codigo_seq; Type: SEQUENCE SET; Schema: usuario; Owner: postgres
--

SELECT pg_catalog.setval('usuario.nivel_nvl_codigo_seq', 1, false);


--
-- Name: usuario_usr_codigo_seq; Type: SEQUENCE SET; Schema: usuario; Owner: postgres
--

SELECT pg_catalog.setval('usuario.usuario_usr_codigo_seq', 1, false);


--
-- Name: artista art_codigo; Type: CONSTRAINT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.artista
    ADD CONSTRAINT art_codigo PRIMARY KEY (art_codigo);


--
-- Name: evento eve_codigo; Type: CONSTRAINT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.evento
    ADD CONSTRAINT eve_codigo PRIMARY KEY (eve_codigo);


--
-- Name: local loc_codigo; Type: CONSTRAINT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.local
    ADD CONSTRAINT loc_codigo PRIMARY KEY (loc_codigo);


--
-- Name: tipo_evento tie_codigo; Type: CONSTRAINT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.tipo_evento
    ADD CONSTRAINT tie_codigo PRIMARY KEY (tie_codigo);


--
-- Name: forma_pagamento fop_codigo; Type: CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.forma_pagamento
    ADD CONSTRAINT fop_codigo PRIMARY KEY (fop_codigo);


--
-- Name: situacao_venda siv_codigo; Type: CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.situacao_venda
    ADD CONSTRAINT siv_codigo PRIMARY KEY (siv_codigo);


--
-- Name: venda_ingresso vel_codigo; Type: CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda_ingresso
    ADD CONSTRAINT vel_codigo PRIMARY KEY (vei_codigo);


--
-- Name: venda ven_codigo; Type: CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda
    ADD CONSTRAINT ven_codigo PRIMARY KEY (ven_codigo);


--
-- Name: venda_pagamento vep_codigo; Type: CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda_pagamento
    ADD CONSTRAINT vep_codigo PRIMARY KEY (vep_codigo);


--
-- Name: controle_acesso coa_codigo; Type: CONSTRAINT; Schema: usuario; Owner: postgres
--

ALTER TABLE ONLY usuario.controle_acesso
    ADD CONSTRAINT coa_codigo PRIMARY KEY (coa_codigo);


--
-- Name: nivel nivel_pkey; Type: CONSTRAINT; Schema: usuario; Owner: postgres
--

ALTER TABLE ONLY usuario.nivel
    ADD CONSTRAINT nivel_pkey PRIMARY KEY (nvl_codigo);


--
-- Name: usuario usr_codigo; Type: CONSTRAINT; Schema: usuario; Owner: postgres
--

ALTER TABLE ONLY usuario.usuario
    ADD CONSTRAINT usr_codigo PRIMARY KEY (usr_codigo);


--
-- Name: evento art_codigo; Type: FK CONSTRAINT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.evento
    ADD CONSTRAINT art_codigo FOREIGN KEY (art_codigo) REFERENCES evento.artista(art_codigo);


--
-- Name: evento loc_codigo; Type: FK CONSTRAINT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.evento
    ADD CONSTRAINT loc_codigo FOREIGN KEY (loc_codigo) REFERENCES evento.local(loc_codigo);


--
-- Name: evento tie_codigo; Type: FK CONSTRAINT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.evento
    ADD CONSTRAINT tie_codigo FOREIGN KEY (tie_codigo) REFERENCES evento.tipo_evento(tie_codigo);


--
-- Name: evento usr_codigo_abertura; Type: FK CONSTRAINT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.evento
    ADD CONSTRAINT usr_codigo_abertura FOREIGN KEY (usr_codigo_abertura) REFERENCES usuario.usuario(usr_codigo);


--
-- Name: venda_pagamento fop_codigo; Type: FK CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda_pagamento
    ADD CONSTRAINT fop_codigo FOREIGN KEY (fop_codigo) REFERENCES faturamento.forma_pagamento(fop_codigo);


--
-- Name: venda siv_codigo; Type: FK CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda
    ADD CONSTRAINT siv_codigo FOREIGN KEY (siv_codigo) REFERENCES faturamento.situacao_venda(siv_codigo);


--
-- Name: venda usr_codigo; Type: FK CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda
    ADD CONSTRAINT usr_codigo FOREIGN KEY (usr_codigo) REFERENCES usuario.usuario(usr_codigo);


--
-- Name: venda_ingresso ven_codigo; Type: FK CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda_ingresso
    ADD CONSTRAINT ven_codigo FOREIGN KEY (ven_codigo) REFERENCES faturamento.venda(ven_codigo);


--
-- Name: venda venda_eve_codigo_fkey; Type: FK CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda
    ADD CONSTRAINT venda_eve_codigo_fkey FOREIGN KEY (eve_codigo) REFERENCES evento.evento(eve_codigo);


--
-- Name: venda vep_codigo; Type: FK CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda
    ADD CONSTRAINT vep_codigo FOREIGN KEY (vep_codigo) REFERENCES faturamento.venda_pagamento(vep_codigo);


--
-- Name: usuario nlv_codigo; Type: FK CONSTRAINT; Schema: usuario; Owner: postgres
--

ALTER TABLE ONLY usuario.usuario
    ADD CONSTRAINT nlv_codigo FOREIGN KEY (nvl_codigo) REFERENCES usuario.nivel(nvl_codigo);


--
-- Name: controle_acesso usr_codigo; Type: FK CONSTRAINT; Schema: usuario; Owner: postgres
--

ALTER TABLE ONLY usuario.controle_acesso
    ADD CONSTRAINT usr_codigo FOREIGN KEY (usr_codigo) REFERENCES usuario.usuario(usr_codigo);


--
-- PostgreSQL database dump complete
--

