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
-- Name: estacionamento; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA estacionamento;


ALTER SCHEMA estacionamento OWNER TO postgres;

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
-- Name: revista; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA revista;


ALTER SCHEMA revista OWNER TO postgres;

--
-- Name: usuario; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA usuario;


ALTER SCHEMA usuario OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: cliente; Type: TABLE; Schema: estacionamento; Owner: postgres
--

CREATE TABLE estacionamento.cliente (
    cpf integer NOT NULL,
    nome character varying(124) NOT NULL,
    dt_nascimento date NOT NULL
);


ALTER TABLE estacionamento.cliente OWNER TO postgres;

--
-- Name: estaciona; Type: TABLE; Schema: estacionamento; Owner: postgres
--

CREATE TABLE estacionamento.estaciona (
    cd_estaciona integer NOT NULL,
    nm_patio integer NOT NULL,
    veiculo_placa character varying(8) NOT NULL,
    dt_entrada date NOT NULL,
    dt_saida date NOT NULL,
    hs_entrada time without time zone NOT NULL,
    hs_saida time without time zone NOT NULL
);


ALTER TABLE estacionamento.estaciona OWNER TO postgres;

--
-- Name: estaciona_cd_estaciona_seq; Type: SEQUENCE; Schema: estacionamento; Owner: postgres
--

CREATE SEQUENCE estacionamento.estaciona_cd_estaciona_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE estacionamento.estaciona_cd_estaciona_seq OWNER TO postgres;

--
-- Name: estaciona_cd_estaciona_seq; Type: SEQUENCE OWNED BY; Schema: estacionamento; Owner: postgres
--

ALTER SEQUENCE estacionamento.estaciona_cd_estaciona_seq OWNED BY estacionamento.estaciona.cd_estaciona;


--
-- Name: modelo; Type: TABLE; Schema: estacionamento; Owner: postgres
--

CREATE TABLE estacionamento.modelo (
    cd_modelo integer NOT NULL,
    desc_2 character varying(40) NOT NULL
);


ALTER TABLE estacionamento.modelo OWNER TO postgres;

--
-- Name: modelo_cd_modelo_seq; Type: SEQUENCE; Schema: estacionamento; Owner: postgres
--

CREATE SEQUENCE estacionamento.modelo_cd_modelo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE estacionamento.modelo_cd_modelo_seq OWNER TO postgres;

--
-- Name: modelo_cd_modelo_seq; Type: SEQUENCE OWNED BY; Schema: estacionamento; Owner: postgres
--

ALTER SEQUENCE estacionamento.modelo_cd_modelo_seq OWNED BY estacionamento.modelo.cd_modelo;


--
-- Name: patio; Type: TABLE; Schema: estacionamento; Owner: postgres
--

CREATE TABLE estacionamento.patio (
    nm_patio integer NOT NULL,
    ender character varying(40) NOT NULL,
    capacidade integer NOT NULL
);


ALTER TABLE estacionamento.patio OWNER TO postgres;

--
-- Name: patio_nm_patio_seq; Type: SEQUENCE; Schema: estacionamento; Owner: postgres
--

CREATE SEQUENCE estacionamento.patio_nm_patio_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE estacionamento.patio_nm_patio_seq OWNER TO postgres;

--
-- Name: patio_nm_patio_seq; Type: SEQUENCE OWNED BY; Schema: estacionamento; Owner: postgres
--

ALTER SEQUENCE estacionamento.patio_nm_patio_seq OWNED BY estacionamento.patio.nm_patio;


--
-- Name: veiculo; Type: TABLE; Schema: estacionamento; Owner: postgres
--

CREATE TABLE estacionamento.veiculo (
    placa character varying(8) NOT NULL,
    modelo_cd_modelo integer NOT NULL,
    cliente_cpf integer NOT NULL,
    cor character varying(20) NOT NULL,
    ano integer NOT NULL
);


ALTER TABLE estacionamento.veiculo OWNER TO postgres;

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
-- Name: assinante; Type: TABLE; Schema: revista; Owner: postgres
--

CREATE TABLE revista.assinante (
    cd_assinante integer NOT NULL,
    nm_assinante character varying(100),
    ass_ramo integer,
    ass_tipo integer,
    ass_end integer
);


ALTER TABLE revista.assinante OWNER TO postgres;

--
-- Name: Assinante_cd_assinante_seq; Type: SEQUENCE; Schema: revista; Owner: postgres
--

CREATE SEQUENCE revista."Assinante_cd_assinante_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE revista."Assinante_cd_assinante_seq" OWNER TO postgres;

--
-- Name: Assinante_cd_assinante_seq; Type: SEQUENCE OWNED BY; Schema: revista; Owner: postgres
--

ALTER SEQUENCE revista."Assinante_cd_assinante_seq" OWNED BY revista.assinante.cd_assinante;


--
-- Name: endereco; Type: TABLE; Schema: revista; Owner: postgres
--

CREATE TABLE revista.endereco (
    cd_endereco integer NOT NULL,
    ds_endereco text,
    complemento text,
    bairro text,
    cep character varying(15),
    end_fone integer,
    end_munic integer
);


ALTER TABLE revista.endereco OWNER TO postgres;

--
-- Name: endereco_cd_endereco_seq; Type: SEQUENCE; Schema: revista; Owner: postgres
--

CREATE SEQUENCE revista.endereco_cd_endereco_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE revista.endereco_cd_endereco_seq OWNER TO postgres;

--
-- Name: endereco_cd_endereco_seq; Type: SEQUENCE OWNED BY; Schema: revista; Owner: postgres
--

ALTER SEQUENCE revista.endereco_cd_endereco_seq OWNED BY revista.endereco.cd_endereco;


--
-- Name: municipio; Type: TABLE; Schema: revista; Owner: postgres
--

CREATE TABLE revista.municipio (
    cd_municipio integer NOT NULL,
    ds_municipio text
);


ALTER TABLE revista.municipio OWNER TO postgres;

--
-- Name: municipio_cd_municipio_seq; Type: SEQUENCE; Schema: revista; Owner: postgres
--

CREATE SEQUENCE revista.municipio_cd_municipio_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE revista.municipio_cd_municipio_seq OWNER TO postgres;

--
-- Name: municipio_cd_municipio_seq; Type: SEQUENCE OWNED BY; Schema: revista; Owner: postgres
--

ALTER SEQUENCE revista.municipio_cd_municipio_seq OWNED BY revista.municipio.cd_municipio;


--
-- Name: ramo_atividade; Type: TABLE; Schema: revista; Owner: postgres
--

CREATE TABLE revista.ramo_atividade (
    cd_ramo integer NOT NULL,
    ds_ramo text
);


ALTER TABLE revista.ramo_atividade OWNER TO postgres;

--
-- Name: ramo_atividade_cd_ramo_seq; Type: SEQUENCE; Schema: revista; Owner: postgres
--

CREATE SEQUENCE revista.ramo_atividade_cd_ramo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE revista.ramo_atividade_cd_ramo_seq OWNER TO postgres;

--
-- Name: ramo_atividade_cd_ramo_seq; Type: SEQUENCE OWNED BY; Schema: revista; Owner: postgres
--

ALTER SEQUENCE revista.ramo_atividade_cd_ramo_seq OWNED BY revista.ramo_atividade.cd_ramo;


--
-- Name: telefone; Type: TABLE; Schema: revista; Owner: postgres
--

CREATE TABLE revista.telefone (
    cd_fone integer NOT NULL,
    ddd character varying(3),
    n_fone text
);


ALTER TABLE revista.telefone OWNER TO postgres;

--
-- Name: telefone_cd_fone_seq; Type: SEQUENCE; Schema: revista; Owner: postgres
--

CREATE SEQUENCE revista.telefone_cd_fone_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE revista.telefone_cd_fone_seq OWNER TO postgres;

--
-- Name: telefone_cd_fone_seq; Type: SEQUENCE OWNED BY; Schema: revista; Owner: postgres
--

ALTER SEQUENCE revista.telefone_cd_fone_seq OWNED BY revista.telefone.cd_fone;


--
-- Name: tipo_assinante; Type: TABLE; Schema: revista; Owner: postgres
--

CREATE TABLE revista.tipo_assinante (
    cd_tipo integer NOT NULL,
    ds_tipo text
);


ALTER TABLE revista.tipo_assinante OWNER TO postgres;

--
-- Name: tipo_assinante_cd_tipo_seq; Type: SEQUENCE; Schema: revista; Owner: postgres
--

CREATE SEQUENCE revista.tipo_assinante_cd_tipo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE revista.tipo_assinante_cd_tipo_seq OWNER TO postgres;

--
-- Name: tipo_assinante_cd_tipo_seq; Type: SEQUENCE OWNED BY; Schema: revista; Owner: postgres
--

ALTER SEQUENCE revista.tipo_assinante_cd_tipo_seq OWNED BY revista.tipo_assinante.cd_tipo;


--
-- Name: TB_BAIRROS; Type: TABLE; Schema: usuario; Owner: postgres
--

CREATE TABLE usuario."TB_BAIRROS" (
    "BAI_CODIGO" integer NOT NULL,
    "BAI_BAIRRO" character varying(45)
);


ALTER TABLE usuario."TB_BAIRROS" OWNER TO postgres;

--
-- Name: TB_BAIRROS_TB_BAIRROS_seq; Type: SEQUENCE; Schema: usuario; Owner: postgres
--

CREATE SEQUENCE usuario."TB_BAIRROS_TB_BAIRROS_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuario."TB_BAIRROS_TB_BAIRROS_seq" OWNER TO postgres;

--
-- Name: TB_BAIRROS_TB_BAIRROS_seq; Type: SEQUENCE OWNED BY; Schema: usuario; Owner: postgres
--

ALTER SEQUENCE usuario."TB_BAIRROS_TB_BAIRROS_seq" OWNED BY usuario."TB_BAIRROS"."BAI_CODIGO";


--
-- Name: TB_CIDADES; Type: TABLE; Schema: usuario; Owner: postgres
--

CREATE TABLE usuario."TB_CIDADES" (
    "CID_CODIGO" integer NOT NULL,
    "CID_CIDADE" character varying(45)
);


ALTER TABLE usuario."TB_CIDADES" OWNER TO postgres;

--
-- Name: TB_CIDADES_CID_CODIGO_seq; Type: SEQUENCE; Schema: usuario; Owner: postgres
--

CREATE SEQUENCE usuario."TB_CIDADES_CID_CODIGO_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE usuario."TB_CIDADES_CID_CODIGO_seq" OWNER TO postgres;

--
-- Name: TB_CIDADES_CID_CODIGO_seq; Type: SEQUENCE OWNED BY; Schema: usuario; Owner: postgres
--

ALTER SEQUENCE usuario."TB_CIDADES_CID_CODIGO_seq" OWNED BY usuario."TB_CIDADES"."CID_CODIGO";


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
-- Name: estaciona cd_estaciona; Type: DEFAULT; Schema: estacionamento; Owner: postgres
--

ALTER TABLE ONLY estacionamento.estaciona ALTER COLUMN cd_estaciona SET DEFAULT nextval('estacionamento.estaciona_cd_estaciona_seq'::regclass);


--
-- Name: modelo cd_modelo; Type: DEFAULT; Schema: estacionamento; Owner: postgres
--

ALTER TABLE ONLY estacionamento.modelo ALTER COLUMN cd_modelo SET DEFAULT nextval('estacionamento.modelo_cd_modelo_seq'::regclass);


--
-- Name: patio nm_patio; Type: DEFAULT; Schema: estacionamento; Owner: postgres
--

ALTER TABLE ONLY estacionamento.patio ALTER COLUMN nm_patio SET DEFAULT nextval('estacionamento.patio_nm_patio_seq'::regclass);


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
-- Name: assinante cd_assinante; Type: DEFAULT; Schema: revista; Owner: postgres
--

ALTER TABLE ONLY revista.assinante ALTER COLUMN cd_assinante SET DEFAULT nextval('revista."Assinante_cd_assinante_seq"'::regclass);


--
-- Name: endereco cd_endereco; Type: DEFAULT; Schema: revista; Owner: postgres
--

ALTER TABLE ONLY revista.endereco ALTER COLUMN cd_endereco SET DEFAULT nextval('revista.endereco_cd_endereco_seq'::regclass);


--
-- Name: municipio cd_municipio; Type: DEFAULT; Schema: revista; Owner: postgres
--

ALTER TABLE ONLY revista.municipio ALTER COLUMN cd_municipio SET DEFAULT nextval('revista.municipio_cd_municipio_seq'::regclass);


--
-- Name: ramo_atividade cd_ramo; Type: DEFAULT; Schema: revista; Owner: postgres
--

ALTER TABLE ONLY revista.ramo_atividade ALTER COLUMN cd_ramo SET DEFAULT nextval('revista.ramo_atividade_cd_ramo_seq'::regclass);


--
-- Name: telefone cd_fone; Type: DEFAULT; Schema: revista; Owner: postgres
--

ALTER TABLE ONLY revista.telefone ALTER COLUMN cd_fone SET DEFAULT nextval('revista.telefone_cd_fone_seq'::regclass);


--
-- Name: tipo_assinante cd_tipo; Type: DEFAULT; Schema: revista; Owner: postgres
--

ALTER TABLE ONLY revista.tipo_assinante ALTER COLUMN cd_tipo SET DEFAULT nextval('revista.tipo_assinante_cd_tipo_seq'::regclass);


--
-- Name: TB_BAIRROS BAI_CODIGO; Type: DEFAULT; Schema: usuario; Owner: postgres
--

ALTER TABLE ONLY usuario."TB_BAIRROS" ALTER COLUMN "BAI_CODIGO" SET DEFAULT nextval('usuario."TB_BAIRROS_TB_BAIRROS_seq"'::regclass);


--
-- Name: TB_CIDADES CID_CODIGO; Type: DEFAULT; Schema: usuario; Owner: postgres
--

ALTER TABLE ONLY usuario."TB_CIDADES" ALTER COLUMN "CID_CODIGO" SET DEFAULT nextval('usuario."TB_CIDADES_CID_CODIGO_seq"'::regclass);


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
-- Data for Name: cliente; Type: TABLE DATA; Schema: estacionamento; Owner: postgres
--

COPY estacionamento.cliente (cpf, nome, dt_nascimento) FROM stdin;
1010101101	Pedrinho	2001-01-01
\.


--
-- Data for Name: estaciona; Type: TABLE DATA; Schema: estacionamento; Owner: postgres
--

COPY estacionamento.estaciona (cd_estaciona, nm_patio, veiculo_placa, dt_entrada, dt_saida, hs_entrada, hs_saida) FROM stdin;
1	1	JEG-1010	2020-01-01	2021-02-01	11:53:00	00:31:00
2	2	JJJ-2020	2020-01-01	2021-02-01	11:54:00	00:32:00
\.


--
-- Data for Name: modelo; Type: TABLE DATA; Schema: estacionamento; Owner: postgres
--

COPY estacionamento.modelo (cd_modelo, desc_2) FROM stdin;
1	Sedan
2	4x4
\.


--
-- Data for Name: patio; Type: TABLE DATA; Schema: estacionamento; Owner: postgres
--

COPY estacionamento.patio (nm_patio, ender, capacidade) FROM stdin;
1	rua por ai	200
\.


--
-- Data for Name: veiculo; Type: TABLE DATA; Schema: estacionamento; Owner: postgres
--

COPY estacionamento.veiculo (placa, modelo_cd_modelo, cliente_cpf, cor, ano) FROM stdin;
JEG-1010	2	1010101101	Verde cor de ceu	2012
JJJ-2020	2	1010101101	Verde cor de ceu	2012
\.


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
-- Data for Name: assinante; Type: TABLE DATA; Schema: revista; Owner: postgres
--

COPY revista.assinante (cd_assinante, nm_assinante, ass_ramo, ass_tipo, ass_end) FROM stdin;
1	Pedro da Silva	1	1	1
2	Joao Dinossauro	2	2	2
3	Carlos Pintor	3	3	3
\.


--
-- Data for Name: endereco; Type: TABLE DATA; Schema: revista; Owner: postgres
--

COPY revista.endereco (cd_endereco, ds_endereco, complemento, bairro, cep, end_fone, end_munic) FROM stdin;
1	Rua Pedro Vasques	Casa	Jardim Cidade	88120-000	1	4
2	Rua Onde Deus Dara	Apartamento 01	Kobrasol	88130-000	2	2
3	Avenida Jogador do Brasil	Casa	Ponte Maruim	88132-101	3	3
\.


--
-- Data for Name: municipio; Type: TABLE DATA; Schema: revista; Owner: postgres
--

COPY revista.municipio (cd_municipio, ds_municipio) FROM stdin;
5	Sao Jose
6	Joao Camara
7	Natal
8	Pelotas
1	Sao Jose
2	Joao Camara
3	Natal
4	Pelotas
\.


--
-- Data for Name: ramo_atividade; Type: TABLE DATA; Schema: revista; Owner: postgres
--

COPY revista.ramo_atividade (cd_ramo, ds_ramo) FROM stdin;
7	Comercio
8	Agronegocio
9	Alimenticio
1	Comercio
2	Agronegocio
3	Alimenticio
\.


--
-- Data for Name: telefone; Type: TABLE DATA; Schema: revista; Owner: postgres
--

COPY revista.telefone (cd_fone, ddd, n_fone) FROM stdin;
4	048	00000000
5	047	00000000
6	041	00000000
1	048	00000000
2	047	00000000
3	041	00000000
\.


--
-- Data for Name: tipo_assinante; Type: TABLE DATA; Schema: revista; Owner: postgres
--

COPY revista.tipo_assinante (cd_tipo, ds_tipo) FROM stdin;
7	Mensal
8	Anual
9	Comercial
1	Mensal
2	Anual
3	Comercial
\.


--
-- Data for Name: TB_BAIRROS; Type: TABLE DATA; Schema: usuario; Owner: postgres
--

COPY usuario."TB_BAIRROS" ("BAI_CODIGO", "BAI_BAIRRO") FROM stdin;
1	Passa Vinte
\.


--
-- Data for Name: TB_CIDADES; Type: TABLE DATA; Schema: usuario; Owner: postgres
--

COPY usuario."TB_CIDADES" ("CID_CODIGO", "CID_CIDADE") FROM stdin;
1	Palhoça
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
-- Name: estaciona_cd_estaciona_seq; Type: SEQUENCE SET; Schema: estacionamento; Owner: postgres
--

SELECT pg_catalog.setval('estacionamento.estaciona_cd_estaciona_seq', 1, false);


--
-- Name: modelo_cd_modelo_seq; Type: SEQUENCE SET; Schema: estacionamento; Owner: postgres
--

SELECT pg_catalog.setval('estacionamento.modelo_cd_modelo_seq', 1, false);


--
-- Name: patio_nm_patio_seq; Type: SEQUENCE SET; Schema: estacionamento; Owner: postgres
--

SELECT pg_catalog.setval('estacionamento.patio_nm_patio_seq', 1, false);


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
-- Name: Assinante_cd_assinante_seq; Type: SEQUENCE SET; Schema: revista; Owner: postgres
--

SELECT pg_catalog.setval('revista."Assinante_cd_assinante_seq"', 1, true);


--
-- Name: endereco_cd_endereco_seq; Type: SEQUENCE SET; Schema: revista; Owner: postgres
--

SELECT pg_catalog.setval('revista.endereco_cd_endereco_seq', 1, true);


--
-- Name: municipio_cd_municipio_seq; Type: SEQUENCE SET; Schema: revista; Owner: postgres
--

SELECT pg_catalog.setval('revista.municipio_cd_municipio_seq', 1, true);


--
-- Name: ramo_atividade_cd_ramo_seq; Type: SEQUENCE SET; Schema: revista; Owner: postgres
--

SELECT pg_catalog.setval('revista.ramo_atividade_cd_ramo_seq', 1, true);


--
-- Name: telefone_cd_fone_seq; Type: SEQUENCE SET; Schema: revista; Owner: postgres
--

SELECT pg_catalog.setval('revista.telefone_cd_fone_seq', 1, true);


--
-- Name: tipo_assinante_cd_tipo_seq; Type: SEQUENCE SET; Schema: revista; Owner: postgres
--

SELECT pg_catalog.setval('revista.tipo_assinante_cd_tipo_seq', 1, true);


--
-- Name: TB_BAIRROS_TB_BAIRROS_seq; Type: SEQUENCE SET; Schema: usuario; Owner: postgres
--

SELECT pg_catalog.setval('usuario."TB_BAIRROS_TB_BAIRROS_seq"', 1, false);


--
-- Name: TB_CIDADES_CID_CODIGO_seq; Type: SEQUENCE SET; Schema: usuario; Owner: postgres
--

SELECT pg_catalog.setval('usuario."TB_CIDADES_CID_CODIGO_seq"', 1, false);


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
-- Name: cliente cliente_cpf_key; Type: CONSTRAINT; Schema: estacionamento; Owner: postgres
--

ALTER TABLE ONLY estacionamento.cliente
    ADD CONSTRAINT cliente_cpf_key UNIQUE (cpf);


--
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: estacionamento; Owner: postgres
--

ALTER TABLE ONLY estacionamento.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (cpf);


--
-- Name: estaciona estaciona_pkey; Type: CONSTRAINT; Schema: estacionamento; Owner: postgres
--

ALTER TABLE ONLY estacionamento.estaciona
    ADD CONSTRAINT estaciona_pkey PRIMARY KEY (cd_estaciona);


--
-- Name: modelo modelo_pkey; Type: CONSTRAINT; Schema: estacionamento; Owner: postgres
--

ALTER TABLE ONLY estacionamento.modelo
    ADD CONSTRAINT modelo_pkey PRIMARY KEY (cd_modelo);


--
-- Name: patio patio_pkey; Type: CONSTRAINT; Schema: estacionamento; Owner: postgres
--

ALTER TABLE ONLY estacionamento.patio
    ADD CONSTRAINT patio_pkey PRIMARY KEY (nm_patio);


--
-- Name: veiculo veiculo_pkey; Type: CONSTRAINT; Schema: estacionamento; Owner: postgres
--

ALTER TABLE ONLY estacionamento.veiculo
    ADD CONSTRAINT veiculo_pkey PRIMARY KEY (placa);


--
-- Name: veiculo veiculo_placa_key; Type: CONSTRAINT; Schema: estacionamento; Owner: postgres
--

ALTER TABLE ONLY estacionamento.veiculo
    ADD CONSTRAINT veiculo_placa_key UNIQUE (placa);


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
-- Name: assinante Assinante_pkey; Type: CONSTRAINT; Schema: revista; Owner: postgres
--

ALTER TABLE ONLY revista.assinante
    ADD CONSTRAINT "Assinante_pkey" PRIMARY KEY (cd_assinante);


--
-- Name: endereco endereco_pkey; Type: CONSTRAINT; Schema: revista; Owner: postgres
--

ALTER TABLE ONLY revista.endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (cd_endereco);


--
-- Name: municipio municipio_pkey; Type: CONSTRAINT; Schema: revista; Owner: postgres
--

ALTER TABLE ONLY revista.municipio
    ADD CONSTRAINT municipio_pkey PRIMARY KEY (cd_municipio);


--
-- Name: ramo_atividade ramo_atividade_pkey; Type: CONSTRAINT; Schema: revista; Owner: postgres
--

ALTER TABLE ONLY revista.ramo_atividade
    ADD CONSTRAINT ramo_atividade_pkey PRIMARY KEY (cd_ramo);


--
-- Name: telefone telefone_pkey; Type: CONSTRAINT; Schema: revista; Owner: postgres
--

ALTER TABLE ONLY revista.telefone
    ADD CONSTRAINT telefone_pkey PRIMARY KEY (cd_fone);


--
-- Name: tipo_assinante tipo_assinante_pkey; Type: CONSTRAINT; Schema: revista; Owner: postgres
--

ALTER TABLE ONLY revista.tipo_assinante
    ADD CONSTRAINT tipo_assinante_pkey PRIMARY KEY (cd_tipo);


--
-- Name: TB_BAIRROS TB_BAIRROS_pkey; Type: CONSTRAINT; Schema: usuario; Owner: postgres
--

ALTER TABLE ONLY usuario."TB_BAIRROS"
    ADD CONSTRAINT "TB_BAIRROS_pkey" PRIMARY KEY ("BAI_CODIGO");


--
-- Name: TB_CIDADES TB_CIDADES_pkey; Type: CONSTRAINT; Schema: usuario; Owner: postgres
--

ALTER TABLE ONLY usuario."TB_CIDADES"
    ADD CONSTRAINT "TB_CIDADES_pkey" PRIMARY KEY ("CID_CODIGO");


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
-- Name: veiculo cliente_cpf_pkey; Type: FK CONSTRAINT; Schema: estacionamento; Owner: postgres
--

ALTER TABLE ONLY estacionamento.veiculo
    ADD CONSTRAINT cliente_cpf_pkey FOREIGN KEY (cliente_cpf) REFERENCES estacionamento.cliente(cpf) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: veiculo modelo_codmod_pkey; Type: FK CONSTRAINT; Schema: estacionamento; Owner: postgres
--

ALTER TABLE ONLY estacionamento.veiculo
    ADD CONSTRAINT modelo_codmod_pkey FOREIGN KEY (modelo_cd_modelo) REFERENCES estacionamento.modelo(cd_modelo) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: estaciona placa_num_pkey; Type: FK CONSTRAINT; Schema: estacionamento; Owner: postgres
--

ALTER TABLE ONLY estacionamento.estaciona
    ADD CONSTRAINT placa_num_pkey FOREIGN KEY (veiculo_placa) REFERENCES estacionamento.veiculo(placa) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: estaciona veiculo_placa_pkey; Type: FK CONSTRAINT; Schema: estacionamento; Owner: postgres
--

ALTER TABLE ONLY estacionamento.estaciona
    ADD CONSTRAINT veiculo_placa_pkey FOREIGN KEY (veiculo_placa) REFERENCES estacionamento.veiculo(placa) ON UPDATE CASCADE ON DELETE CASCADE;


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
-- Name: assinante ass_end_pkey; Type: FK CONSTRAINT; Schema: revista; Owner: postgres
--

ALTER TABLE ONLY revista.assinante
    ADD CONSTRAINT ass_end_pkey FOREIGN KEY (ass_end) REFERENCES revista.endereco(cd_endereco) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: assinante ass_ramo_pkey; Type: FK CONSTRAINT; Schema: revista; Owner: postgres
--

ALTER TABLE ONLY revista.assinante
    ADD CONSTRAINT ass_ramo_pkey FOREIGN KEY (ass_ramo) REFERENCES revista.ramo_atividade(cd_ramo) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: assinante ass_tipo_pkey; Type: FK CONSTRAINT; Schema: revista; Owner: postgres
--

ALTER TABLE ONLY revista.assinante
    ADD CONSTRAINT ass_tipo_pkey FOREIGN KEY (ass_tipo) REFERENCES revista.tipo_assinante(cd_tipo) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: endereco end_fone_pkey; Type: FK CONSTRAINT; Schema: revista; Owner: postgres
--

ALTER TABLE ONLY revista.endereco
    ADD CONSTRAINT end_fone_pkey FOREIGN KEY (end_fone) REFERENCES revista.telefone(cd_fone) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: endereco end_munic_pkey; Type: FK CONSTRAINT; Schema: revista; Owner: postgres
--

ALTER TABLE ONLY revista.endereco
    ADD CONSTRAINT end_munic_pkey FOREIGN KEY (end_munic) REFERENCES revista.municipio(cd_municipio) ON UPDATE CASCADE ON DELETE CASCADE;


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

