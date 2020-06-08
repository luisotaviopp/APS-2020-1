--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-06-08 20:42:43

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
-- TOC entry 7 (class 2615 OID 24989)
-- Name: evento; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA evento;


ALTER SCHEMA evento OWNER TO postgres;

--
-- TOC entry 9 (class 2615 OID 24990)
-- Name: faturamento; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA faturamento;


ALTER SCHEMA faturamento OWNER TO postgres;

--
-- TOC entry 10 (class 2615 OID 24991)
-- Name: usuario; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA usuario;


ALTER SCHEMA usuario OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 205 (class 1259 OID 24992)
-- Name: artista; Type: TABLE; Schema: evento; Owner: postgres
--

CREATE TABLE evento.artista (
    art_codigo integer NOT NULL,
    art_nome character varying(100),
    art_descricao character varying(100)
);


ALTER TABLE evento.artista OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 24995)
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
-- TOC entry 2960 (class 0 OID 0)
-- Dependencies: 206
-- Name: artista_art_codigo_seq; Type: SEQUENCE OWNED BY; Schema: evento; Owner: postgres
--

ALTER SEQUENCE evento.artista_art_codigo_seq OWNED BY evento.artista.art_codigo;


--
-- TOC entry 207 (class 1259 OID 24997)
-- Name: evento; Type: TABLE; Schema: evento; Owner: postgres
--

CREATE TABLE evento.evento (
    loc_codigo integer,
    art_codigo integer,
    tie_codigo integer,
    usr_codigo_abertura integer,
    eve_titulo character varying(50),
    eve_qtd_ingressos integer,
    eve_valor_ingresso double precision,
    eve_codigo integer NOT NULL
);


ALTER TABLE evento.evento OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 25136)
-- Name: evento_eve_codigo_seq; Type: SEQUENCE; Schema: evento; Owner: postgres
--

CREATE SEQUENCE evento.evento_eve_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE evento.evento_eve_codigo_seq OWNER TO postgres;

--
-- TOC entry 2961 (class 0 OID 0)
-- Dependencies: 224
-- Name: evento_eve_codigo_seq; Type: SEQUENCE OWNED BY; Schema: evento; Owner: postgres
--

ALTER SEQUENCE evento.evento_eve_codigo_seq OWNED BY evento.evento.eve_codigo;


--
-- TOC entry 208 (class 1259 OID 25000)
-- Name: local; Type: TABLE; Schema: evento; Owner: postgres
--

CREATE TABLE evento.local (
    loc_codigo integer NOT NULL,
    loc_logradouro character varying(255) NOT NULL,
    loc_numero character varying(10) NOT NULL,
    loc_bairro character varying(100) NOT NULL,
    loc_cidade character varying(100) NOT NULL,
    loc_uf character varying(50) NOT NULL,
    loc_lotacao_maxima integer,
    loc_cep character varying(16)
);


ALTER TABLE evento.local OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 25006)
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
-- TOC entry 2962 (class 0 OID 0)
-- Dependencies: 209
-- Name: local_loc_codigo_seq; Type: SEQUENCE OWNED BY; Schema: evento; Owner: postgres
--

ALTER SEQUENCE evento.local_loc_codigo_seq OWNED BY evento.local.loc_codigo;


--
-- TOC entry 210 (class 1259 OID 25008)
-- Name: tipo_evento; Type: TABLE; Schema: evento; Owner: postgres
--

CREATE TABLE evento.tipo_evento (
    tie_codigo integer NOT NULL,
    tie_descricao character varying(100)
);


ALTER TABLE evento.tipo_evento OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 25011)
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
-- TOC entry 2963 (class 0 OID 0)
-- Dependencies: 211
-- Name: tipo_evento_tie_codigo_seq; Type: SEQUENCE OWNED BY; Schema: evento; Owner: postgres
--

ALTER SEQUENCE evento.tipo_evento_tie_codigo_seq OWNED BY evento.tipo_evento.tie_codigo;


--
-- TOC entry 212 (class 1259 OID 25013)
-- Name: forma_pagamento; Type: TABLE; Schema: faturamento; Owner: postgres
--

CREATE TABLE faturamento.forma_pagamento (
    fop_codigo integer NOT NULL,
    fop_descricao character varying(50)
);


ALTER TABLE faturamento.forma_pagamento OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 25016)
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
-- TOC entry 2964 (class 0 OID 0)
-- Dependencies: 213
-- Name: forma_pagamento_fop_codigo_seq; Type: SEQUENCE OWNED BY; Schema: faturamento; Owner: postgres
--

ALTER SEQUENCE faturamento.forma_pagamento_fop_codigo_seq OWNED BY faturamento.forma_pagamento.fop_codigo;


--
-- TOC entry 214 (class 1259 OID 25018)
-- Name: situacao_venda; Type: TABLE; Schema: faturamento; Owner: postgres
--

CREATE TABLE faturamento.situacao_venda (
    siv_descricao character varying(50),
    siv_codigo integer NOT NULL
);


ALTER TABLE faturamento.situacao_venda OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 25185)
-- Name: situacao_venda_siv_codigo_seq; Type: SEQUENCE; Schema: faturamento; Owner: postgres
--

CREATE SEQUENCE faturamento.situacao_venda_siv_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE faturamento.situacao_venda_siv_codigo_seq OWNER TO postgres;

--
-- TOC entry 2965 (class 0 OID 0)
-- Dependencies: 228
-- Name: situacao_venda_siv_codigo_seq; Type: SEQUENCE OWNED BY; Schema: faturamento; Owner: postgres
--

ALTER SEQUENCE faturamento.situacao_venda_siv_codigo_seq OWNED BY faturamento.situacao_venda.siv_codigo;


--
-- TOC entry 215 (class 1259 OID 25021)
-- Name: venda; Type: TABLE; Schema: faturamento; Owner: postgres
--

CREATE TABLE faturamento.venda (
    usr_codigo integer,
    eve_codigo integer,
    ven_codigo integer NOT NULL,
    siv_codigo integer,
    ven_data date
);


ALTER TABLE faturamento.venda OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 25024)
-- Name: venda_ingresso; Type: TABLE; Schema: faturamento; Owner: postgres
--

CREATE TABLE faturamento.venda_ingresso (
    vei_nome character varying(50),
    vei_documento character varying(50),
    vei_utilizado boolean,
    ven_codigo integer,
    vei_codigo integer NOT NULL
);


ALTER TABLE faturamento.venda_ingresso OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 25158)
-- Name: venda_ingresso_vei_codigo_seq; Type: SEQUENCE; Schema: faturamento; Owner: postgres
--

CREATE SEQUENCE faturamento.venda_ingresso_vei_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE faturamento.venda_ingresso_vei_codigo_seq OWNER TO postgres;

--
-- TOC entry 2966 (class 0 OID 0)
-- Dependencies: 226
-- Name: venda_ingresso_vei_codigo_seq; Type: SEQUENCE OWNED BY; Schema: faturamento; Owner: postgres
--

ALTER SEQUENCE faturamento.venda_ingresso_vei_codigo_seq OWNED BY faturamento.venda_ingresso.vei_codigo;


--
-- TOC entry 217 (class 1259 OID 25027)
-- Name: venda_pagamento; Type: TABLE; Schema: faturamento; Owner: postgres
--

CREATE TABLE faturamento.venda_pagamento (
    vep_valor double precision,
    vep_qtd_parcelas integer,
    fop_codigo integer,
    vep_codigo integer NOT NULL,
    ven_codigo integer
);


ALTER TABLE faturamento.venda_pagamento OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 25172)
-- Name: venda_pagamento_vep_codigo_seq; Type: SEQUENCE; Schema: faturamento; Owner: postgres
--

CREATE SEQUENCE faturamento.venda_pagamento_vep_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE faturamento.venda_pagamento_vep_codigo_seq OWNER TO postgres;

--
-- TOC entry 2967 (class 0 OID 0)
-- Dependencies: 227
-- Name: venda_pagamento_vep_codigo_seq; Type: SEQUENCE OWNED BY; Schema: faturamento; Owner: postgres
--

ALTER SEQUENCE faturamento.venda_pagamento_vep_codigo_seq OWNED BY faturamento.venda_pagamento.vep_codigo;


--
-- TOC entry 225 (class 1259 OID 25150)
-- Name: venda_ven_codigo_seq; Type: SEQUENCE; Schema: faturamento; Owner: postgres
--

CREATE SEQUENCE faturamento.venda_ven_codigo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE faturamento.venda_ven_codigo_seq OWNER TO postgres;

--
-- TOC entry 2968 (class 0 OID 0)
-- Dependencies: 225
-- Name: venda_ven_codigo_seq; Type: SEQUENCE OWNED BY; Schema: faturamento; Owner: postgres
--

ALTER SEQUENCE faturamento.venda_ven_codigo_seq OWNED BY faturamento.venda.ven_codigo;


--
-- TOC entry 218 (class 1259 OID 25030)
-- Name: controle_acesso; Type: TABLE; Schema: usuario; Owner: postgres
--

CREATE TABLE usuario.controle_acesso (
    usr_codigo integer,
    coa_codigo integer NOT NULL,
    coa_data date
);


ALTER TABLE usuario.controle_acesso OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 25033)
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
-- TOC entry 2969 (class 0 OID 0)
-- Dependencies: 219
-- Name: controle_acesso_coa_codigo_seq; Type: SEQUENCE OWNED BY; Schema: usuario; Owner: postgres
--

ALTER SEQUENCE usuario.controle_acesso_coa_codigo_seq OWNED BY usuario.controle_acesso.coa_codigo;


--
-- TOC entry 220 (class 1259 OID 25035)
-- Name: nivel; Type: TABLE; Schema: usuario; Owner: postgres
--

CREATE TABLE usuario.nivel (
    nvl_codigo integer NOT NULL,
    nvl_descricao character varying(100)
);


ALTER TABLE usuario.nivel OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 25038)
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
-- TOC entry 2970 (class 0 OID 0)
-- Dependencies: 221
-- Name: nivel_nvl_codigo_seq; Type: SEQUENCE OWNED BY; Schema: usuario; Owner: postgres
--

ALTER SEQUENCE usuario.nivel_nvl_codigo_seq OWNED BY usuario.nivel.nvl_codigo;


--
-- TOC entry 222 (class 1259 OID 25040)
-- Name: usuario; Type: TABLE; Schema: usuario; Owner: postgres
--

CREATE TABLE usuario.usuario (
    usr_codigo integer NOT NULL,
    nvl_codigo integer,
    usr_nome character varying(100),
    usr_email character varying(50),
    usr_login character varying(50),
    usr_senha character varying(50),
    usr_ativo boolean
);


ALTER TABLE usuario.usuario OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 25043)
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
-- TOC entry 2971 (class 0 OID 0)
-- Dependencies: 223
-- Name: usuario_usr_codigo_seq; Type: SEQUENCE OWNED BY; Schema: usuario; Owner: postgres
--

ALTER SEQUENCE usuario.usuario_usr_codigo_seq OWNED BY usuario.usuario.usr_codigo;


--
-- TOC entry 2757 (class 2604 OID 25045)
-- Name: artista art_codigo; Type: DEFAULT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.artista ALTER COLUMN art_codigo SET DEFAULT nextval('evento.artista_art_codigo_seq'::regclass);


--
-- TOC entry 2758 (class 2604 OID 25138)
-- Name: evento eve_codigo; Type: DEFAULT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.evento ALTER COLUMN eve_codigo SET DEFAULT nextval('evento.evento_eve_codigo_seq'::regclass);


--
-- TOC entry 2759 (class 2604 OID 25046)
-- Name: local loc_codigo; Type: DEFAULT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.local ALTER COLUMN loc_codigo SET DEFAULT nextval('evento.local_loc_codigo_seq'::regclass);


--
-- TOC entry 2760 (class 2604 OID 25047)
-- Name: tipo_evento tie_codigo; Type: DEFAULT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.tipo_evento ALTER COLUMN tie_codigo SET DEFAULT nextval('evento.tipo_evento_tie_codigo_seq'::regclass);


--
-- TOC entry 2761 (class 2604 OID 25048)
-- Name: forma_pagamento fop_codigo; Type: DEFAULT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.forma_pagamento ALTER COLUMN fop_codigo SET DEFAULT nextval('faturamento.forma_pagamento_fop_codigo_seq'::regclass);


--
-- TOC entry 2762 (class 2604 OID 25187)
-- Name: situacao_venda siv_codigo; Type: DEFAULT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.situacao_venda ALTER COLUMN siv_codigo SET DEFAULT nextval('faturamento.situacao_venda_siv_codigo_seq'::regclass);


--
-- TOC entry 2763 (class 2604 OID 25152)
-- Name: venda ven_codigo; Type: DEFAULT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda ALTER COLUMN ven_codigo SET DEFAULT nextval('faturamento.venda_ven_codigo_seq'::regclass);


--
-- TOC entry 2764 (class 2604 OID 25160)
-- Name: venda_ingresso vei_codigo; Type: DEFAULT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda_ingresso ALTER COLUMN vei_codigo SET DEFAULT nextval('faturamento.venda_ingresso_vei_codigo_seq'::regclass);


--
-- TOC entry 2765 (class 2604 OID 25174)
-- Name: venda_pagamento vep_codigo; Type: DEFAULT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda_pagamento ALTER COLUMN vep_codigo SET DEFAULT nextval('faturamento.venda_pagamento_vep_codigo_seq'::regclass);


--
-- TOC entry 2766 (class 2604 OID 25049)
-- Name: controle_acesso coa_codigo; Type: DEFAULT; Schema: usuario; Owner: postgres
--

ALTER TABLE ONLY usuario.controle_acesso ALTER COLUMN coa_codigo SET DEFAULT nextval('usuario.controle_acesso_coa_codigo_seq'::regclass);


--
-- TOC entry 2767 (class 2604 OID 25050)
-- Name: nivel nvl_codigo; Type: DEFAULT; Schema: usuario; Owner: postgres
--

ALTER TABLE ONLY usuario.nivel ALTER COLUMN nvl_codigo SET DEFAULT nextval('usuario.nivel_nvl_codigo_seq'::regclass);


--
-- TOC entry 2768 (class 2604 OID 25051)
-- Name: usuario usr_codigo; Type: DEFAULT; Schema: usuario; Owner: postgres
--

ALTER TABLE ONLY usuario.usuario ALTER COLUMN usr_codigo SET DEFAULT nextval('usuario.usuario_usr_codigo_seq'::regclass);


--
-- TOC entry 2931 (class 0 OID 24992)
-- Dependencies: 205
-- Data for Name: artista; Type: TABLE DATA; Schema: evento; Owner: postgres
--

COPY evento.artista (art_codigo, art_nome, art_descricao) FROM stdin;
\.


--
-- TOC entry 2933 (class 0 OID 24997)
-- Dependencies: 207
-- Data for Name: evento; Type: TABLE DATA; Schema: evento; Owner: postgres
--

COPY evento.evento (loc_codigo, art_codigo, tie_codigo, usr_codigo_abertura, eve_titulo, eve_qtd_ingressos, eve_valor_ingresso, eve_codigo) FROM stdin;
\.


--
-- TOC entry 2934 (class 0 OID 25000)
-- Dependencies: 208
-- Data for Name: local; Type: TABLE DATA; Schema: evento; Owner: postgres
--

COPY evento.local (loc_codigo, loc_logradouro, loc_numero, loc_bairro, loc_cidade, loc_uf, loc_lotacao_maxima, loc_cep) FROM stdin;
18	Rua: Nada4	159	Campinas	Palhoca23	SC	80000	\N
12	Rua: Nada	158	Campinas	Sao Jose	SC	10000	881132321
13	Rua: Nada2	158	Campinas	Palhoca	SC	80000	\N
19	Rua: Nada4	159	Campinas	Palhoca23	SC	80000	\N
4	teste	24	Daniel	teste	sc	\N	\N
16	Rua: Nada4	159	Campinas	Palhoca23	SC	80000	\N
14	Rua: Nada	158	Campinas	Palhoca	SC	80000	\N
15	Rua: Nada4	159	Campinas	Palhoca23	SC	80000	\N
20	Rua: Nada7	159	Campinas	Palhoca23	SC	80000	\N
17	Rua: Nada9	120	Campinas	Palhoca23	SC	80000	\N
\.


--
-- TOC entry 2936 (class 0 OID 25008)
-- Dependencies: 210
-- Data for Name: tipo_evento; Type: TABLE DATA; Schema: evento; Owner: postgres
--

COPY evento.tipo_evento (tie_codigo, tie_descricao) FROM stdin;
\.


--
-- TOC entry 2938 (class 0 OID 25013)
-- Dependencies: 212
-- Data for Name: forma_pagamento; Type: TABLE DATA; Schema: faturamento; Owner: postgres
--

COPY faturamento.forma_pagamento (fop_codigo, fop_descricao) FROM stdin;
\.


--
-- TOC entry 2940 (class 0 OID 25018)
-- Dependencies: 214
-- Data for Name: situacao_venda; Type: TABLE DATA; Schema: faturamento; Owner: postgres
--

COPY faturamento.situacao_venda (siv_descricao, siv_codigo) FROM stdin;
\.


--
-- TOC entry 2941 (class 0 OID 25021)
-- Dependencies: 215
-- Data for Name: venda; Type: TABLE DATA; Schema: faturamento; Owner: postgres
--

COPY faturamento.venda (usr_codigo, eve_codigo, ven_codigo, siv_codigo, ven_data) FROM stdin;
\.


--
-- TOC entry 2942 (class 0 OID 25024)
-- Dependencies: 216
-- Data for Name: venda_ingresso; Type: TABLE DATA; Schema: faturamento; Owner: postgres
--

COPY faturamento.venda_ingresso (vei_nome, vei_documento, vei_utilizado, ven_codigo, vei_codigo) FROM stdin;
\.


--
-- TOC entry 2943 (class 0 OID 25027)
-- Dependencies: 217
-- Data for Name: venda_pagamento; Type: TABLE DATA; Schema: faturamento; Owner: postgres
--

COPY faturamento.venda_pagamento (vep_valor, vep_qtd_parcelas, fop_codigo, vep_codigo, ven_codigo) FROM stdin;
\.


--
-- TOC entry 2944 (class 0 OID 25030)
-- Dependencies: 218
-- Data for Name: controle_acesso; Type: TABLE DATA; Schema: usuario; Owner: postgres
--

COPY usuario.controle_acesso (usr_codigo, coa_codigo, coa_data) FROM stdin;
\.


--
-- TOC entry 2946 (class 0 OID 25035)
-- Dependencies: 220
-- Data for Name: nivel; Type: TABLE DATA; Schema: usuario; Owner: postgres
--

COPY usuario.nivel (nvl_codigo, nvl_descricao) FROM stdin;
24	talvez
12	Teste
1	teste
\.


--
-- TOC entry 2948 (class 0 OID 25040)
-- Dependencies: 222
-- Data for Name: usuario; Type: TABLE DATA; Schema: usuario; Owner: postgres
--

COPY usuario.usuario (usr_codigo, nvl_codigo, usr_nome, usr_email, usr_login, usr_senha, usr_ativo) FROM stdin;
1	12	Jorge1585357796086	teste@teste.com	teste	1235436	t
2	12	Jorge1585357845389	asfasfteste.com	teste	1235436	t
\.


--
-- TOC entry 2972 (class 0 OID 0)
-- Dependencies: 206
-- Name: artista_art_codigo_seq; Type: SEQUENCE SET; Schema: evento; Owner: postgres
--

SELECT pg_catalog.setval('evento.artista_art_codigo_seq', 1, false);


--
-- TOC entry 2973 (class 0 OID 0)
-- Dependencies: 224
-- Name: evento_eve_codigo_seq; Type: SEQUENCE SET; Schema: evento; Owner: postgres
--

SELECT pg_catalog.setval('evento.evento_eve_codigo_seq', 1, false);


--
-- TOC entry 2974 (class 0 OID 0)
-- Dependencies: 209
-- Name: local_loc_codigo_seq; Type: SEQUENCE SET; Schema: evento; Owner: postgres
--

SELECT pg_catalog.setval('evento.local_loc_codigo_seq', 1, false);


--
-- TOC entry 2975 (class 0 OID 0)
-- Dependencies: 211
-- Name: tipo_evento_tie_codigo_seq; Type: SEQUENCE SET; Schema: evento; Owner: postgres
--

SELECT pg_catalog.setval('evento.tipo_evento_tie_codigo_seq', 1, false);


--
-- TOC entry 2976 (class 0 OID 0)
-- Dependencies: 213
-- Name: forma_pagamento_fop_codigo_seq; Type: SEQUENCE SET; Schema: faturamento; Owner: postgres
--

SELECT pg_catalog.setval('faturamento.forma_pagamento_fop_codigo_seq', 1, false);


--
-- TOC entry 2977 (class 0 OID 0)
-- Dependencies: 228
-- Name: situacao_venda_siv_codigo_seq; Type: SEQUENCE SET; Schema: faturamento; Owner: postgres
--

SELECT pg_catalog.setval('faturamento.situacao_venda_siv_codigo_seq', 1, false);


--
-- TOC entry 2978 (class 0 OID 0)
-- Dependencies: 226
-- Name: venda_ingresso_vei_codigo_seq; Type: SEQUENCE SET; Schema: faturamento; Owner: postgres
--

SELECT pg_catalog.setval('faturamento.venda_ingresso_vei_codigo_seq', 1, false);


--
-- TOC entry 2979 (class 0 OID 0)
-- Dependencies: 227
-- Name: venda_pagamento_vep_codigo_seq; Type: SEQUENCE SET; Schema: faturamento; Owner: postgres
--

SELECT pg_catalog.setval('faturamento.venda_pagamento_vep_codigo_seq', 1, false);


--
-- TOC entry 2980 (class 0 OID 0)
-- Dependencies: 225
-- Name: venda_ven_codigo_seq; Type: SEQUENCE SET; Schema: faturamento; Owner: postgres
--

SELECT pg_catalog.setval('faturamento.venda_ven_codigo_seq', 1, false);


--
-- TOC entry 2981 (class 0 OID 0)
-- Dependencies: 219
-- Name: controle_acesso_coa_codigo_seq; Type: SEQUENCE SET; Schema: usuario; Owner: postgres
--

SELECT pg_catalog.setval('usuario.controle_acesso_coa_codigo_seq', 1, false);


--
-- TOC entry 2982 (class 0 OID 0)
-- Dependencies: 221
-- Name: nivel_nvl_codigo_seq; Type: SEQUENCE SET; Schema: usuario; Owner: postgres
--

SELECT pg_catalog.setval('usuario.nivel_nvl_codigo_seq', 1, false);


--
-- TOC entry 2983 (class 0 OID 0)
-- Dependencies: 223
-- Name: usuario_usr_codigo_seq; Type: SEQUENCE SET; Schema: usuario; Owner: postgres
--

SELECT pg_catalog.setval('usuario.usuario_usr_codigo_seq', 1, false);


--
-- TOC entry 2770 (class 2606 OID 25053)
-- Name: artista art_codigo; Type: CONSTRAINT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.artista
    ADD CONSTRAINT art_codigo PRIMARY KEY (art_codigo);


--
-- TOC entry 2772 (class 2606 OID 25144)
-- Name: evento eve_codigo; Type: CONSTRAINT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.evento
    ADD CONSTRAINT eve_codigo PRIMARY KEY (eve_codigo) INCLUDE (eve_codigo);


--
-- TOC entry 2774 (class 2606 OID 25057)
-- Name: local loc_codigo; Type: CONSTRAINT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.local
    ADD CONSTRAINT loc_codigo PRIMARY KEY (loc_codigo);


--
-- TOC entry 2776 (class 2606 OID 25059)
-- Name: tipo_evento tie_codigo; Type: CONSTRAINT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.tipo_evento
    ADD CONSTRAINT tie_codigo PRIMARY KEY (tie_codigo);


--
-- TOC entry 2778 (class 2606 OID 25061)
-- Name: forma_pagamento fop_codigo; Type: CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.forma_pagamento
    ADD CONSTRAINT fop_codigo PRIMARY KEY (fop_codigo);


--
-- TOC entry 2780 (class 2606 OID 25192)
-- Name: situacao_venda siv_codigo; Type: CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.situacao_venda
    ADD CONSTRAINT siv_codigo PRIMARY KEY (siv_codigo) INCLUDE (siv_codigo);


--
-- TOC entry 2784 (class 2606 OID 25166)
-- Name: venda_ingresso vei_codigo; Type: CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda_ingresso
    ADD CONSTRAINT vei_codigo PRIMARY KEY (vei_codigo) INCLUDE (vei_codigo);


--
-- TOC entry 2782 (class 2606 OID 25157)
-- Name: venda ven_codigo; Type: CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda
    ADD CONSTRAINT ven_codigo PRIMARY KEY (ven_codigo) INCLUDE (ven_codigo);


--
-- TOC entry 2786 (class 2606 OID 25179)
-- Name: venda_pagamento vep_codigo; Type: CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda_pagamento
    ADD CONSTRAINT vep_codigo PRIMARY KEY (vep_codigo) INCLUDE (vep_codigo);


--
-- TOC entry 2788 (class 2606 OID 25071)
-- Name: controle_acesso coa_codigo; Type: CONSTRAINT; Schema: usuario; Owner: postgres
--

ALTER TABLE ONLY usuario.controle_acesso
    ADD CONSTRAINT coa_codigo PRIMARY KEY (coa_codigo);


--
-- TOC entry 2790 (class 2606 OID 25073)
-- Name: nivel nivel_pkey; Type: CONSTRAINT; Schema: usuario; Owner: postgres
--

ALTER TABLE ONLY usuario.nivel
    ADD CONSTRAINT nivel_pkey PRIMARY KEY (nvl_codigo);


--
-- TOC entry 2792 (class 2606 OID 25075)
-- Name: usuario usr_codigo; Type: CONSTRAINT; Schema: usuario; Owner: postgres
--

ALTER TABLE ONLY usuario.usuario
    ADD CONSTRAINT usr_codigo PRIMARY KEY (usr_codigo);


--
-- TOC entry 2793 (class 2606 OID 25076)
-- Name: evento art_codigo; Type: FK CONSTRAINT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.evento
    ADD CONSTRAINT art_codigo FOREIGN KEY (art_codigo) REFERENCES evento.artista(art_codigo);


--
-- TOC entry 2794 (class 2606 OID 25081)
-- Name: evento loc_codigo; Type: FK CONSTRAINT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.evento
    ADD CONSTRAINT loc_codigo FOREIGN KEY (loc_codigo) REFERENCES evento.local(loc_codigo);


--
-- TOC entry 2795 (class 2606 OID 25086)
-- Name: evento tie_codigo; Type: FK CONSTRAINT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.evento
    ADD CONSTRAINT tie_codigo FOREIGN KEY (tie_codigo) REFERENCES evento.tipo_evento(tie_codigo);


--
-- TOC entry 2796 (class 2606 OID 25091)
-- Name: evento usr_codigo_abertura; Type: FK CONSTRAINT; Schema: evento; Owner: postgres
--

ALTER TABLE ONLY evento.evento
    ADD CONSTRAINT usr_codigo_abertura FOREIGN KEY (usr_codigo_abertura) REFERENCES usuario.usuario(usr_codigo);


--
-- TOC entry 2798 (class 2606 OID 25145)
-- Name: venda eve_codigo; Type: FK CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda
    ADD CONSTRAINT eve_codigo FOREIGN KEY (eve_codigo) REFERENCES evento.evento(eve_codigo) NOT VALID;


--
-- TOC entry 2801 (class 2606 OID 25096)
-- Name: venda_pagamento fop_codigo; Type: FK CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda_pagamento
    ADD CONSTRAINT fop_codigo FOREIGN KEY (fop_codigo) REFERENCES faturamento.forma_pagamento(fop_codigo);


--
-- TOC entry 2799 (class 2606 OID 25193)
-- Name: venda siv_codigo; Type: FK CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda
    ADD CONSTRAINT siv_codigo FOREIGN KEY (siv_codigo) REFERENCES faturamento.situacao_venda(siv_codigo) NOT VALID;


--
-- TOC entry 2797 (class 2606 OID 25106)
-- Name: venda usr_codigo; Type: FK CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda
    ADD CONSTRAINT usr_codigo FOREIGN KEY (usr_codigo) REFERENCES usuario.usuario(usr_codigo);


--
-- TOC entry 2800 (class 2606 OID 25167)
-- Name: venda_ingresso ven_codigo; Type: FK CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda_ingresso
    ADD CONSTRAINT ven_codigo FOREIGN KEY (ven_codigo) REFERENCES faturamento.venda(ven_codigo) NOT VALID;


--
-- TOC entry 2802 (class 2606 OID 25198)
-- Name: venda_pagamento ven_codigo; Type: FK CONSTRAINT; Schema: faturamento; Owner: postgres
--

ALTER TABLE ONLY faturamento.venda_pagamento
    ADD CONSTRAINT ven_codigo FOREIGN KEY (ven_codigo) REFERENCES faturamento.venda(ven_codigo) NOT VALID;


--
-- TOC entry 2804 (class 2606 OID 25126)
-- Name: usuario nlv_codigo; Type: FK CONSTRAINT; Schema: usuario; Owner: postgres
--

ALTER TABLE ONLY usuario.usuario
    ADD CONSTRAINT nlv_codigo FOREIGN KEY (nvl_codigo) REFERENCES usuario.nivel(nvl_codigo);


--
-- TOC entry 2803 (class 2606 OID 25131)
-- Name: controle_acesso usr_codigo; Type: FK CONSTRAINT; Schema: usuario; Owner: postgres
--

ALTER TABLE ONLY usuario.controle_acesso
    ADD CONSTRAINT usr_codigo FOREIGN KEY (usr_codigo) REFERENCES usuario.usuario(usr_codigo);


-- Completed on 2020-06-08 20:42:43

--
-- PostgreSQL database dump complete
--

