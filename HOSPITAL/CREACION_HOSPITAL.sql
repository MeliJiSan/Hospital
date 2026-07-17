--
-- PostgreSQL database dump
--

\restrict fJtybYqOzSb5fVf0DLAnPCUh5qPEgSnHqTa6qU6fmKDMneqFDOQOUgFA3id2m9u

-- Dumped from database version 18.3
-- Dumped by pg_dump version 18.3

-- Started on 2026-07-16 19:09:16

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 8 (class 2615 OID 25963)
-- Name: Hospital; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA "Hospital";


ALTER SCHEMA "Hospital" OWNER TO postgres;

--
-- TOC entry 6 (class 2615 OID 25842)
-- Name: practica1; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA practica1;


ALTER SCHEMA practica1 OWNER TO postgres;

--
-- TOC entry 7 (class 2615 OID 25856)
-- Name: practica2; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA practica2;


ALTER SCHEMA practica2 OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 238 (class 1259 OID 25988)
-- Name: consultas; Type: TABLE; Schema: Hospital; Owner: postgres
--

CREATE TABLE "Hospital".consultas (
    id_consulta integer CONSTRAINT consultas_id_consultas_not_null NOT NULL,
    alergias text NOT NULL,
    observaciones_sintomas text NOT NULL,
    diagnostico text NOT NULL,
    fecha_registro timestamp with time zone NOT NULL,
    id_paciente integer NOT NULL,
    id_doctor integer NOT NULL
);


ALTER TABLE "Hospital".consultas OWNER TO postgres;

--
-- TOC entry 237 (class 1259 OID 25986)
-- Name: consultas_id_consultas_seq; Type: SEQUENCE; Schema: Hospital; Owner: postgres
--

CREATE SEQUENCE "Hospital".consultas_id_consultas_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE "Hospital".consultas_id_consultas_seq OWNER TO postgres;

--
-- TOC entry 5130 (class 0 OID 0)
-- Dependencies: 237
-- Name: consultas_id_consultas_seq; Type: SEQUENCE OWNED BY; Schema: Hospital; Owner: postgres
--

ALTER SEQUENCE "Hospital".consultas_id_consultas_seq OWNED BY "Hospital".consultas.id_consulta;


--
-- TOC entry 244 (class 1259 OID 26052)
-- Name: detalle_receta; Type: TABLE; Schema: Hospital; Owner: postgres
--

CREATE TABLE "Hospital".detalle_receta (
    id_receta integer NOT NULL,
    medicamento_nombre character varying NOT NULL,
    dosis character varying NOT NULL,
    frecuencia character varying NOT NULL,
    via_administracion character varying NOT NULL,
    duracion character varying
);


ALTER TABLE "Hospital".detalle_receta OWNER TO postgres;

--
-- TOC entry 243 (class 1259 OID 26051)
-- Name: detalle_receta_id_receta_seq; Type: SEQUENCE; Schema: Hospital; Owner: postgres
--

CREATE SEQUENCE "Hospital".detalle_receta_id_receta_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE "Hospital".detalle_receta_id_receta_seq OWNER TO postgres;

--
-- TOC entry 5131 (class 0 OID 0)
-- Dependencies: 243
-- Name: detalle_receta_id_receta_seq; Type: SEQUENCE OWNED BY; Schema: Hospital; Owner: postgres
--

ALTER SEQUENCE "Hospital".detalle_receta_id_receta_seq OWNED BY "Hospital".detalle_receta.id_receta;


--
-- TOC entry 246 (class 1259 OID 26069)
-- Name: doctor; Type: TABLE; Schema: Hospital; Owner: postgres
--

CREATE TABLE "Hospital".doctor (
    id_doctor integer NOT NULL,
    nombre_doctor character varying NOT NULL,
    num_cedula character varying NOT NULL,
    apellidop character varying NOT NULL
);


ALTER TABLE "Hospital".doctor OWNER TO postgres;

--
-- TOC entry 245 (class 1259 OID 26068)
-- Name: doctor_id_doctor_seq; Type: SEQUENCE; Schema: Hospital; Owner: postgres
--

CREATE SEQUENCE "Hospital".doctor_id_doctor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE "Hospital".doctor_id_doctor_seq OWNER TO postgres;

--
-- TOC entry 5132 (class 0 OID 0)
-- Dependencies: 245
-- Name: doctor_id_doctor_seq; Type: SEQUENCE OWNED BY; Schema: Hospital; Owner: postgres
--

ALTER SEQUENCE "Hospital".doctor_id_doctor_seq OWNED BY "Hospital".doctor.id_doctor;


--
-- TOC entry 239 (class 1259 OID 26008)
-- Name: egresos; Type: TABLE; Schema: Hospital; Owner: postgres
--

CREATE TABLE "Hospital".egresos (
    id_egreso integer NOT NULL,
    observaciones_egreso text NOT NULL,
    fecha_registro timestamp with time zone NOT NULL,
    id_paciente integer NOT NULL,
    hora_salida time with time zone NOT NULL
);


ALTER TABLE "Hospital".egresos OWNER TO postgres;

--
-- TOC entry 240 (class 1259 OID 26011)
-- Name: egresos_id_egreso_seq; Type: SEQUENCE; Schema: Hospital; Owner: postgres
--

CREATE SEQUENCE "Hospital".egresos_id_egreso_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE "Hospital".egresos_id_egreso_seq OWNER TO postgres;

--
-- TOC entry 5133 (class 0 OID 0)
-- Dependencies: 240
-- Name: egresos_id_egreso_seq; Type: SEQUENCE OWNED BY; Schema: Hospital; Owner: postgres
--

ALTER SEQUENCE "Hospital".egresos_id_egreso_seq OWNED BY "Hospital".egresos.id_egreso;


--
-- TOC entry 235 (class 1259 OID 25964)
-- Name: pacientes; Type: TABLE; Schema: Hospital; Owner: postgres
--

CREATE TABLE "Hospital".pacientes (
    id_paciente integer CONSTRAINT pacientes_id_pacientes_not_null NOT NULL,
    nombre character varying NOT NULL,
    apellidop character varying NOT NULL,
    apellidom character varying NOT NULL,
    fecha_nacimiento date NOT NULL,
    edad integer NOT NULL,
    genero character varying NOT NULL,
    peso double precision NOT NULL,
    fecha_hora_ingreso timestamp with time zone NOT NULL,
    creado_en timestamp with time zone NOT NULL
);


ALTER TABLE "Hospital".pacientes OWNER TO postgres;

--
-- TOC entry 236 (class 1259 OID 25967)
-- Name: pacientes_id_pacientes_seq; Type: SEQUENCE; Schema: Hospital; Owner: postgres
--

CREATE SEQUENCE "Hospital".pacientes_id_pacientes_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE "Hospital".pacientes_id_pacientes_seq OWNER TO postgres;

--
-- TOC entry 5134 (class 0 OID 0)
-- Dependencies: 236
-- Name: pacientes_id_pacientes_seq; Type: SEQUENCE OWNED BY; Schema: Hospital; Owner: postgres
--

ALTER SEQUENCE "Hospital".pacientes_id_pacientes_seq OWNED BY "Hospital".pacientes.id_paciente;


--
-- TOC entry 242 (class 1259 OID 26031)
-- Name: recetas; Type: TABLE; Schema: Hospital; Owner: postgres
--

CREATE TABLE "Hospital".recetas (
    id_receta integer NOT NULL,
    fecha_emision timestamp with time zone NOT NULL,
    indicaciones_generales text NOT NULL,
    id_consulta integer NOT NULL
);


ALTER TABLE "Hospital".recetas OWNER TO postgres;

--
-- TOC entry 241 (class 1259 OID 26029)
-- Name: recetas_id_receta_seq; Type: SEQUENCE; Schema: Hospital; Owner: postgres
--

CREATE SEQUENCE "Hospital".recetas_id_receta_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE "Hospital".recetas_id_receta_seq OWNER TO postgres;

--
-- TOC entry 5135 (class 0 OID 0)
-- Dependencies: 241
-- Name: recetas_id_receta_seq; Type: SEQUENCE OWNED BY; Schema: Hospital; Owner: postgres
--

ALTER SEQUENCE "Hospital".recetas_id_receta_seq OWNED BY "Hospital".recetas.id_receta;


--
-- TOC entry 222 (class 1259 OID 25843)
-- Name: usuarios; Type: TABLE; Schema: practica1; Owner: postgres
--

CREATE TABLE practica1.usuarios (
    id integer CONSTRAINT "Usuarios_id_not_null" NOT NULL,
    nombre character varying,
    apellidop character varying
);


ALTER TABLE practica1.usuarios OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 25846)
-- Name: Usuarios_id_seq; Type: SEQUENCE; Schema: practica1; Owner: postgres
--

CREATE SEQUENCE practica1."Usuarios_id_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE practica1."Usuarios_id_seq" OWNER TO postgres;

--
-- TOC entry 5136 (class 0 OID 0)
-- Dependencies: 223
-- Name: Usuarios_id_seq; Type: SEQUENCE OWNED BY; Schema: practica1; Owner: postgres
--

ALTER SEQUENCE practica1."Usuarios_id_seq" OWNED BY practica1.usuarios.id;


--
-- TOC entry 224 (class 1259 OID 25857)
-- Name: alumno; Type: TABLE; Schema: practica2; Owner: postgres
--

CREATE TABLE practica2.alumno (
    nombre character varying NOT NULL,
    id_alumno integer NOT NULL,
    apellidop character varying NOT NULL,
    edad integer NOT NULL
);


ALTER TABLE practica2.alumno OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 25869)
-- Name: alumno_id_alumno_seq; Type: SEQUENCE; Schema: practica2; Owner: postgres
--

CREATE SEQUENCE practica2.alumno_id_alumno_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE practica2.alumno_id_alumno_seq OWNER TO postgres;

--
-- TOC entry 5137 (class 0 OID 0)
-- Dependencies: 227
-- Name: alumno_id_alumno_seq; Type: SEQUENCE OWNED BY; Schema: practica2; Owner: postgres
--

ALTER SEQUENCE practica2.alumno_id_alumno_seq OWNED BY practica2.alumno.id_alumno;


--
-- TOC entry 225 (class 1259 OID 25860)
-- Name: maestro; Type: TABLE; Schema: practica2; Owner: postgres
--

CREATE TABLE practica2.maestro (
    id_maestro integer NOT NULL,
    nombre character varying NOT NULL,
    apellidop character varying NOT NULL,
    id_materia integer NOT NULL
);


ALTER TABLE practica2.maestro OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 25863)
-- Name: maestro_alumno; Type: TABLE; Schema: practica2; Owner: postgres
--

CREATE TABLE practica2.maestro_alumno (
    id_alumno integer NOT NULL,
    id_maestro integer NOT NULL,
    id_materia integer NOT NULL,
    hora_clase timestamp without time zone NOT NULL
);


ALTER TABLE practica2.maestro_alumno OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 25896)
-- Name: maestro_alumno_id_alumno_seq; Type: SEQUENCE; Schema: practica2; Owner: postgres
--

CREATE SEQUENCE practica2.maestro_alumno_id_alumno_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE practica2.maestro_alumno_id_alumno_seq OWNER TO postgres;

--
-- TOC entry 5138 (class 0 OID 0)
-- Dependencies: 229
-- Name: maestro_alumno_id_alumno_seq; Type: SEQUENCE OWNED BY; Schema: practica2; Owner: postgres
--

ALTER SEQUENCE practica2.maestro_alumno_id_alumno_seq OWNED BY practica2.maestro_alumno.id_alumno;


--
-- TOC entry 230 (class 1259 OID 25902)
-- Name: maestro_alumno_id_maestro_seq; Type: SEQUENCE; Schema: practica2; Owner: postgres
--

CREATE SEQUENCE practica2.maestro_alumno_id_maestro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE practica2.maestro_alumno_id_maestro_seq OWNER TO postgres;

--
-- TOC entry 5139 (class 0 OID 0)
-- Dependencies: 230
-- Name: maestro_alumno_id_maestro_seq; Type: SEQUENCE OWNED BY; Schema: practica2; Owner: postgres
--

ALTER SEQUENCE practica2.maestro_alumno_id_maestro_seq OWNED BY practica2.maestro_alumno.id_maestro;


--
-- TOC entry 232 (class 1259 OID 25920)
-- Name: maestro_alumno_id_materia_seq; Type: SEQUENCE; Schema: practica2; Owner: postgres
--

CREATE SEQUENCE practica2.maestro_alumno_id_materia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE practica2.maestro_alumno_id_materia_seq OWNER TO postgres;

--
-- TOC entry 5140 (class 0 OID 0)
-- Dependencies: 232
-- Name: maestro_alumno_id_materia_seq; Type: SEQUENCE OWNED BY; Schema: practica2; Owner: postgres
--

ALTER SEQUENCE practica2.maestro_alumno_id_materia_seq OWNED BY practica2.maestro_alumno.id_materia;


--
-- TOC entry 228 (class 1259 OID 25881)
-- Name: maestro_id_maestro_seq; Type: SEQUENCE; Schema: practica2; Owner: postgres
--

CREATE SEQUENCE practica2.maestro_id_maestro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE practica2.maestro_id_maestro_seq OWNER TO postgres;

--
-- TOC entry 5141 (class 0 OID 0)
-- Dependencies: 228
-- Name: maestro_id_maestro_seq; Type: SEQUENCE OWNED BY; Schema: practica2; Owner: postgres
--

ALTER SEQUENCE practica2.maestro_id_maestro_seq OWNED BY practica2.maestro.id_maestro;


--
-- TOC entry 231 (class 1259 OID 25911)
-- Name: maestro_id_materia_seq; Type: SEQUENCE; Schema: practica2; Owner: postgres
--

CREATE SEQUENCE practica2.maestro_id_materia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE practica2.maestro_id_materia_seq OWNER TO postgres;

--
-- TOC entry 5142 (class 0 OID 0)
-- Dependencies: 231
-- Name: maestro_id_materia_seq; Type: SEQUENCE OWNED BY; Schema: practica2; Owner: postgres
--

ALTER SEQUENCE practica2.maestro_id_materia_seq OWNED BY practica2.maestro.id_materia;


--
-- TOC entry 233 (class 1259 OID 25926)
-- Name: materia; Type: TABLE; Schema: practica2; Owner: postgres
--

CREATE TABLE practica2.materia (
    id_materia integer NOT NULL,
    nombre_materia character varying NOT NULL,
    carrera character varying NOT NULL
);


ALTER TABLE practica2.materia OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 25929)
-- Name: materia_id_materia_seq; Type: SEQUENCE; Schema: practica2; Owner: postgres
--

CREATE SEQUENCE practica2.materia_id_materia_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE practica2.materia_id_materia_seq OWNER TO postgres;

--
-- TOC entry 5143 (class 0 OID 0)
-- Dependencies: 234
-- Name: materia_id_materia_seq; Type: SEQUENCE OWNED BY; Schema: practica2; Owner: postgres
--

ALTER SEQUENCE practica2.materia_id_materia_seq OWNED BY practica2.materia.id_materia;


--
-- TOC entry 4921 (class 2604 OID 25991)
-- Name: consultas id_consulta; Type: DEFAULT; Schema: Hospital; Owner: postgres
--

ALTER TABLE ONLY "Hospital".consultas ALTER COLUMN id_consulta SET DEFAULT nextval('"Hospital".consultas_id_consultas_seq'::regclass);


--
-- TOC entry 4924 (class 2604 OID 26055)
-- Name: detalle_receta id_receta; Type: DEFAULT; Schema: Hospital; Owner: postgres
--

ALTER TABLE ONLY "Hospital".detalle_receta ALTER COLUMN id_receta SET DEFAULT nextval('"Hospital".detalle_receta_id_receta_seq'::regclass);


--
-- TOC entry 4925 (class 2604 OID 26072)
-- Name: doctor id_doctor; Type: DEFAULT; Schema: Hospital; Owner: postgres
--

ALTER TABLE ONLY "Hospital".doctor ALTER COLUMN id_doctor SET DEFAULT nextval('"Hospital".doctor_id_doctor_seq'::regclass);


--
-- TOC entry 4922 (class 2604 OID 26012)
-- Name: egresos id_egreso; Type: DEFAULT; Schema: Hospital; Owner: postgres
--

ALTER TABLE ONLY "Hospital".egresos ALTER COLUMN id_egreso SET DEFAULT nextval('"Hospital".egresos_id_egreso_seq'::regclass);


--
-- TOC entry 4920 (class 2604 OID 25968)
-- Name: pacientes id_paciente; Type: DEFAULT; Schema: Hospital; Owner: postgres
--

ALTER TABLE ONLY "Hospital".pacientes ALTER COLUMN id_paciente SET DEFAULT nextval('"Hospital".pacientes_id_pacientes_seq'::regclass);


--
-- TOC entry 4923 (class 2604 OID 26034)
-- Name: recetas id_receta; Type: DEFAULT; Schema: Hospital; Owner: postgres
--

ALTER TABLE ONLY "Hospital".recetas ALTER COLUMN id_receta SET DEFAULT nextval('"Hospital".recetas_id_receta_seq'::regclass);


--
-- TOC entry 4912 (class 2604 OID 25847)
-- Name: usuarios id; Type: DEFAULT; Schema: practica1; Owner: postgres
--

ALTER TABLE ONLY practica1.usuarios ALTER COLUMN id SET DEFAULT nextval('practica1."Usuarios_id_seq"'::regclass);


--
-- TOC entry 4913 (class 2604 OID 25870)
-- Name: alumno id_alumno; Type: DEFAULT; Schema: practica2; Owner: postgres
--

ALTER TABLE ONLY practica2.alumno ALTER COLUMN id_alumno SET DEFAULT nextval('practica2.alumno_id_alumno_seq'::regclass);


--
-- TOC entry 4914 (class 2604 OID 25882)
-- Name: maestro id_maestro; Type: DEFAULT; Schema: practica2; Owner: postgres
--

ALTER TABLE ONLY practica2.maestro ALTER COLUMN id_maestro SET DEFAULT nextval('practica2.maestro_id_maestro_seq'::regclass);


--
-- TOC entry 4915 (class 2604 OID 25912)
-- Name: maestro id_materia; Type: DEFAULT; Schema: practica2; Owner: postgres
--

ALTER TABLE ONLY practica2.maestro ALTER COLUMN id_materia SET DEFAULT nextval('practica2.maestro_id_materia_seq'::regclass);


--
-- TOC entry 4916 (class 2604 OID 25897)
-- Name: maestro_alumno id_alumno; Type: DEFAULT; Schema: practica2; Owner: postgres
--

ALTER TABLE ONLY practica2.maestro_alumno ALTER COLUMN id_alumno SET DEFAULT nextval('practica2.maestro_alumno_id_alumno_seq'::regclass);


--
-- TOC entry 4917 (class 2604 OID 25903)
-- Name: maestro_alumno id_maestro; Type: DEFAULT; Schema: practica2; Owner: postgres
--

ALTER TABLE ONLY practica2.maestro_alumno ALTER COLUMN id_maestro SET DEFAULT nextval('practica2.maestro_alumno_id_maestro_seq'::regclass);


--
-- TOC entry 4918 (class 2604 OID 25921)
-- Name: maestro_alumno id_materia; Type: DEFAULT; Schema: practica2; Owner: postgres
--

ALTER TABLE ONLY practica2.maestro_alumno ALTER COLUMN id_materia SET DEFAULT nextval('practica2.maestro_alumno_id_materia_seq'::regclass);


--
-- TOC entry 4919 (class 2604 OID 25930)
-- Name: materia id_materia; Type: DEFAULT; Schema: practica2; Owner: postgres
--

ALTER TABLE ONLY practica2.materia ALTER COLUMN id_materia SET DEFAULT nextval('practica2.materia_id_materia_seq'::regclass);


--
-- TOC entry 5116 (class 0 OID 25988)
-- Dependencies: 238
-- Data for Name: consultas; Type: TABLE DATA; Schema: Hospital; Owner: postgres
--

COPY "Hospital".consultas (id_consulta, alergias, observaciones_sintomas, diagnostico, fecha_registro, id_paciente, id_doctor) FROM stdin;
\.


--
-- TOC entry 5122 (class 0 OID 26052)
-- Dependencies: 244
-- Data for Name: detalle_receta; Type: TABLE DATA; Schema: Hospital; Owner: postgres
--

COPY "Hospital".detalle_receta (id_receta, medicamento_nombre, dosis, frecuencia, via_administracion, duracion) FROM stdin;
\.


--
-- TOC entry 5124 (class 0 OID 26069)
-- Dependencies: 246
-- Data for Name: doctor; Type: TABLE DATA; Schema: Hospital; Owner: postgres
--

COPY "Hospital".doctor (id_doctor, nombre_doctor, num_cedula, apellidop) FROM stdin;
\.


--
-- TOC entry 5117 (class 0 OID 26008)
-- Dependencies: 239
-- Data for Name: egresos; Type: TABLE DATA; Schema: Hospital; Owner: postgres
--

COPY "Hospital".egresos (id_egreso, observaciones_egreso, fecha_registro, id_paciente, hora_salida) FROM stdin;
\.


--
-- TOC entry 5113 (class 0 OID 25964)
-- Dependencies: 235
-- Data for Name: pacientes; Type: TABLE DATA; Schema: Hospital; Owner: postgres
--

COPY "Hospital".pacientes (id_paciente, nombre, apellidop, apellidom, fecha_nacimiento, edad, genero, peso, fecha_hora_ingreso, creado_en) FROM stdin;
\.


--
-- TOC entry 5120 (class 0 OID 26031)
-- Dependencies: 242
-- Data for Name: recetas; Type: TABLE DATA; Schema: Hospital; Owner: postgres
--

COPY "Hospital".recetas (id_receta, fecha_emision, indicaciones_generales, id_consulta) FROM stdin;
\.


--
-- TOC entry 5100 (class 0 OID 25843)
-- Dependencies: 222
-- Data for Name: usuarios; Type: TABLE DATA; Schema: practica1; Owner: postgres
--

COPY practica1.usuarios (id, nombre, apellidop) FROM stdin;
1	Angel	Torres
2	Angel	Torres
3	Maria	Santos
4	Itayetzi	Sanchez
6	Melanie	Jimenez
7	Melanie	Jimenez
8	Melanie	Jimenez
\.


--
-- TOC entry 5102 (class 0 OID 25857)
-- Dependencies: 224
-- Data for Name: alumno; Type: TABLE DATA; Schema: practica2; Owner: postgres
--

COPY practica2.alumno (nombre, id_alumno, apellidop, edad) FROM stdin;
Angel	3	Lopez	15
Adriana	5	Perez	45
Maria	6	Sanchez	25
Juan	14	Pérez	19
María	15	Gómez	20
Luis	16	Rodríguez	21
Ana	17	Pérez	22
Juan	18	Martínez	19
Carlos	19	Sánchez	24
Sofía	20	López	26
\.


--
-- TOC entry 5103 (class 0 OID 25860)
-- Dependencies: 225
-- Data for Name: maestro; Type: TABLE DATA; Schema: practica2; Owner: postgres
--

COPY practica2.maestro (id_maestro, nombre, apellidop, id_materia) FROM stdin;
2	Reynaldo	Castaneira	2
5	Alvaro Contreras	Pacheco	2
10	José	Hernández	10
11	José	Díaz	10
12	Ricardo	Alvarez	11
13	Elena	Torres	12
\.


--
-- TOC entry 5104 (class 0 OID 25863)
-- Dependencies: 226
-- Data for Name: maestro_alumno; Type: TABLE DATA; Schema: practica2; Owner: postgres
--

COPY practica2.maestro_alumno (id_alumno, id_maestro, id_materia, hora_clase) FROM stdin;
3	2	2	2026-06-17 10:00:00
14	10	10	2026-07-16 15:00:00
15	10	10	2026-07-16 15:00:00
16	11	10	2026-07-16 15:00:00
17	12	11	2026-07-16 15:00:00
\.


--
-- TOC entry 5111 (class 0 OID 25926)
-- Dependencies: 233
-- Data for Name: materia; Type: TABLE DATA; Schema: practica2; Owner: postgres
--

COPY practica2.materia (id_materia, nombre_materia, carrera) FROM stdin;
1	Etica	Sistemas
2	Calculo	Administracion
4		civil
5	Discretas	Mecanica
10	Química	Ingeniería Química
11	Cálculo Integral	Ingeniería en Sistemas
12	Programación Orientada a Objetos	Ingeniería en Sistemas
13	Física General	Ingeniería Industrial
\.


--
-- TOC entry 5144 (class 0 OID 0)
-- Dependencies: 237
-- Name: consultas_id_consultas_seq; Type: SEQUENCE SET; Schema: Hospital; Owner: postgres
--

SELECT pg_catalog.setval('"Hospital".consultas_id_consultas_seq', 1, false);


--
-- TOC entry 5145 (class 0 OID 0)
-- Dependencies: 243
-- Name: detalle_receta_id_receta_seq; Type: SEQUENCE SET; Schema: Hospital; Owner: postgres
--

SELECT pg_catalog.setval('"Hospital".detalle_receta_id_receta_seq', 1, false);


--
-- TOC entry 5146 (class 0 OID 0)
-- Dependencies: 245
-- Name: doctor_id_doctor_seq; Type: SEQUENCE SET; Schema: Hospital; Owner: postgres
--

SELECT pg_catalog.setval('"Hospital".doctor_id_doctor_seq', 1, false);


--
-- TOC entry 5147 (class 0 OID 0)
-- Dependencies: 240
-- Name: egresos_id_egreso_seq; Type: SEQUENCE SET; Schema: Hospital; Owner: postgres
--

SELECT pg_catalog.setval('"Hospital".egresos_id_egreso_seq', 1, false);


--
-- TOC entry 5148 (class 0 OID 0)
-- Dependencies: 236
-- Name: pacientes_id_pacientes_seq; Type: SEQUENCE SET; Schema: Hospital; Owner: postgres
--

SELECT pg_catalog.setval('"Hospital".pacientes_id_pacientes_seq', 1, false);


--
-- TOC entry 5149 (class 0 OID 0)
-- Dependencies: 241
-- Name: recetas_id_receta_seq; Type: SEQUENCE SET; Schema: Hospital; Owner: postgres
--

SELECT pg_catalog.setval('"Hospital".recetas_id_receta_seq', 1, false);


--
-- TOC entry 5150 (class 0 OID 0)
-- Dependencies: 223
-- Name: Usuarios_id_seq; Type: SEQUENCE SET; Schema: practica1; Owner: postgres
--

SELECT pg_catalog.setval('practica1."Usuarios_id_seq"', 8, true);


--
-- TOC entry 5151 (class 0 OID 0)
-- Dependencies: 227
-- Name: alumno_id_alumno_seq; Type: SEQUENCE SET; Schema: practica2; Owner: postgres
--

SELECT pg_catalog.setval('practica2.alumno_id_alumno_seq', 20, true);


--
-- TOC entry 5152 (class 0 OID 0)
-- Dependencies: 229
-- Name: maestro_alumno_id_alumno_seq; Type: SEQUENCE SET; Schema: practica2; Owner: postgres
--

SELECT pg_catalog.setval('practica2.maestro_alumno_id_alumno_seq', 1, false);


--
-- TOC entry 5153 (class 0 OID 0)
-- Dependencies: 230
-- Name: maestro_alumno_id_maestro_seq; Type: SEQUENCE SET; Schema: practica2; Owner: postgres
--

SELECT pg_catalog.setval('practica2.maestro_alumno_id_maestro_seq', 1, false);


--
-- TOC entry 5154 (class 0 OID 0)
-- Dependencies: 232
-- Name: maestro_alumno_id_materia_seq; Type: SEQUENCE SET; Schema: practica2; Owner: postgres
--

SELECT pg_catalog.setval('practica2.maestro_alumno_id_materia_seq', 1, false);


--
-- TOC entry 5155 (class 0 OID 0)
-- Dependencies: 228
-- Name: maestro_id_maestro_seq; Type: SEQUENCE SET; Schema: practica2; Owner: postgres
--

SELECT pg_catalog.setval('practica2.maestro_id_maestro_seq', 13, true);


--
-- TOC entry 5156 (class 0 OID 0)
-- Dependencies: 231
-- Name: maestro_id_materia_seq; Type: SEQUENCE SET; Schema: practica2; Owner: postgres
--

SELECT pg_catalog.setval('practica2.maestro_id_materia_seq', 1, false);


--
-- TOC entry 5157 (class 0 OID 0)
-- Dependencies: 234
-- Name: materia_id_materia_seq; Type: SEQUENCE SET; Schema: practica2; Owner: postgres
--

SELECT pg_catalog.setval('practica2.materia_id_materia_seq', 13, true);


--
-- TOC entry 4937 (class 2606 OID 26002)
-- Name: consultas consultas_pkey; Type: CONSTRAINT; Schema: Hospital; Owner: postgres
--

ALTER TABLE ONLY "Hospital".consultas
    ADD CONSTRAINT consultas_pkey PRIMARY KEY (id_consulta);


--
-- TOC entry 4943 (class 2606 OID 26080)
-- Name: doctor doctor_pkey; Type: CONSTRAINT; Schema: Hospital; Owner: postgres
--

ALTER TABLE ONLY "Hospital".doctor
    ADD CONSTRAINT doctor_pkey PRIMARY KEY (id_doctor);


--
-- TOC entry 4939 (class 2606 OID 26023)
-- Name: egresos egresos_pkey; Type: CONSTRAINT; Schema: Hospital; Owner: postgres
--

ALTER TABLE ONLY "Hospital".egresos
    ADD CONSTRAINT egresos_pkey PRIMARY KEY (id_egreso);


--
-- TOC entry 4935 (class 2606 OID 25985)
-- Name: pacientes pacientes_pkey; Type: CONSTRAINT; Schema: Hospital; Owner: postgres
--

ALTER TABLE ONLY "Hospital".pacientes
    ADD CONSTRAINT pacientes_pkey PRIMARY KEY (id_paciente);


--
-- TOC entry 4941 (class 2606 OID 26045)
-- Name: recetas recetas_pkey; Type: CONSTRAINT; Schema: Hospital; Owner: postgres
--

ALTER TABLE ONLY "Hospital".recetas
    ADD CONSTRAINT recetas_pkey PRIMARY KEY (id_receta);


--
-- TOC entry 4927 (class 2606 OID 25855)
-- Name: usuarios Usuarios_pkey; Type: CONSTRAINT; Schema: practica1; Owner: postgres
--

ALTER TABLE ONLY practica1.usuarios
    ADD CONSTRAINT "Usuarios_pkey" PRIMARY KEY (id);


--
-- TOC entry 4929 (class 2606 OID 25880)
-- Name: alumno alumno_pkey; Type: CONSTRAINT; Schema: practica2; Owner: postgres
--

ALTER TABLE ONLY practica2.alumno
    ADD CONSTRAINT alumno_pkey PRIMARY KEY (id_alumno);


--
-- TOC entry 4931 (class 2606 OID 25893)
-- Name: maestro maestro_pkey; Type: CONSTRAINT; Schema: practica2; Owner: postgres
--

ALTER TABLE ONLY practica2.maestro
    ADD CONSTRAINT maestro_pkey PRIMARY KEY (id_maestro);


--
-- TOC entry 4933 (class 2606 OID 25941)
-- Name: materia materia_pkey; Type: CONSTRAINT; Schema: practica2; Owner: postgres
--

ALTER TABLE ONLY practica2.materia
    ADD CONSTRAINT materia_pkey PRIMARY KEY (id_materia);


--
-- TOC entry 4951 (class 2606 OID 26103)
-- Name: recetas id_consulta; Type: FK CONSTRAINT; Schema: Hospital; Owner: postgres
--

ALTER TABLE ONLY "Hospital".recetas
    ADD CONSTRAINT id_consulta FOREIGN KEY (id_consulta) REFERENCES "Hospital".consultas(id_consulta) NOT VALID;


--
-- TOC entry 4948 (class 2606 OID 26115)
-- Name: consultas id_doctor; Type: FK CONSTRAINT; Schema: Hospital; Owner: postgres
--

ALTER TABLE ONLY "Hospital".consultas
    ADD CONSTRAINT id_doctor FOREIGN KEY (id_doctor) REFERENCES "Hospital".doctor(id_doctor) NOT VALID;


--
-- TOC entry 4949 (class 2606 OID 26096)
-- Name: consultas id_paciente; Type: FK CONSTRAINT; Schema: Hospital; Owner: postgres
--

ALTER TABLE ONLY "Hospital".consultas
    ADD CONSTRAINT id_paciente FOREIGN KEY (id_paciente) REFERENCES "Hospital".pacientes(id_paciente) NOT VALID;


--
-- TOC entry 4950 (class 2606 OID 26024)
-- Name: egresos id_paciente; Type: FK CONSTRAINT; Schema: Hospital; Owner: postgres
--

ALTER TABLE ONLY "Hospital".egresos
    ADD CONSTRAINT id_paciente FOREIGN KEY (id_paciente) REFERENCES "Hospital".pacientes(id_paciente) NOT VALID;


--
-- TOC entry 4952 (class 2606 OID 26063)
-- Name: detalle_receta id_receta; Type: FK CONSTRAINT; Schema: Hospital; Owner: postgres
--

ALTER TABLE ONLY "Hospital".detalle_receta
    ADD CONSTRAINT id_receta FOREIGN KEY (id_receta) REFERENCES "Hospital".recetas(id_receta) NOT VALID;


--
-- TOC entry 4945 (class 2606 OID 25942)
-- Name: maestro_alumno id_alumno; Type: FK CONSTRAINT; Schema: practica2; Owner: postgres
--

ALTER TABLE ONLY practica2.maestro_alumno
    ADD CONSTRAINT id_alumno FOREIGN KEY (id_alumno) REFERENCES practica2.alumno(id_alumno) NOT VALID;


--
-- TOC entry 4946 (class 2606 OID 25947)
-- Name: maestro_alumno id_maestro; Type: FK CONSTRAINT; Schema: practica2; Owner: postgres
--

ALTER TABLE ONLY practica2.maestro_alumno
    ADD CONSTRAINT id_maestro FOREIGN KEY (id_maestro) REFERENCES practica2.maestro(id_maestro) NOT VALID;


--
-- TOC entry 4944 (class 2606 OID 25958)
-- Name: maestro id_materia; Type: FK CONSTRAINT; Schema: practica2; Owner: postgres
--

ALTER TABLE ONLY practica2.maestro
    ADD CONSTRAINT id_materia FOREIGN KEY (id_materia) REFERENCES practica2.materia(id_materia) NOT VALID;


--
-- TOC entry 4947 (class 2606 OID 25952)
-- Name: maestro_alumno id_materia; Type: FK CONSTRAINT; Schema: practica2; Owner: postgres
--

ALTER TABLE ONLY practica2.maestro_alumno
    ADD CONSTRAINT id_materia FOREIGN KEY (id_materia) REFERENCES practica2.materia(id_materia) NOT VALID;


-- Completed on 2026-07-16 19:09:16

--
-- PostgreSQL database dump complete
--

\unrestrict fJtybYqOzSb5fVf0DLAnPCUh5qPEgSnHqTa6qU6fmKDMneqFDOQOUgFA3id2m9u

