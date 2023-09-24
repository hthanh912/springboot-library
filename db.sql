--
-- PostgreSQL database dump
--

-- Dumped from database version 16.0
-- Dumped by pg_dump version 16.0

-- Started on 2023-09-24 19:07:50

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
-- TOC entry 2 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 4895 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 216 (class 1259 OID 16397)
-- Name: authors; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.authors (
    author_id uuid NOT NULL,
    created_at timestamp(6) without time zone,
    name character varying(255),
    updated_at timestamp(6) without time zone
);


ALTER TABLE public.authors OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16400)
-- Name: book_collections_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.book_collections_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.book_collections_seq OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16401)
-- Name: books; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.books (
    book_id uuid NOT NULL,
    created_at timestamp(6) without time zone,
    title character varying(255),
    updated_at timestamp(6) without time zone,
    author_author_id uuid,
    number_of_reviews integer,
    sum_of_rate integer
);


ALTER TABLE public.books OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16404)
-- Name: books_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.books_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.books_seq OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16408)
-- Name: posts_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.posts_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.posts_seq OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 16470)
-- Name: quotes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.quotes (
    quote_id uuid NOT NULL,
    content character varying(255),
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    book_book_id uuid
);


ALTER TABLE public.quotes OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16405)
-- Name: reviews; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reviews (
    review_id uuid NOT NULL,
    content character varying(255),
    created_at timestamp(6) without time zone,
    rate integer,
    updated_at timestamp(6) without time zone,
    book_book_id uuid,
    user_id uuid
);


ALTER TABLE public.reviews OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16409)
-- Name: single_books_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.single_books_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.single_books_seq OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16410)
-- Name: token; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.token (
    id integer NOT NULL,
    expired boolean NOT NULL,
    revoked boolean NOT NULL,
    token character varying(255),
    token_type character varying(255),
    user_id uuid
);


ALTER TABLE public.token OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16415)
-- Name: token_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.token_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.token_seq OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16416)
-- Name: user_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.user_seq OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 16417)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone,
    first_name character varying(255),
    last_name character varying(255),
    password character varying(255),
    role character varying(255),
    updated_at timestamp(6) without time zone,
    username character varying(255)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 16422)
-- Name: users_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_seq OWNER TO postgres;

--
-- TOC entry 4877 (class 0 OID 16397)
-- Dependencies: 216
-- Data for Name: authors; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.authors VALUES ('6a39b1d5-5f57-4781-b7e8-06584792e40e', '2023-07-12 23:37:42.875109', 'Chan Ho Kei', '2023-07-12 23:37:42.875109');
INSERT INTO public.authors VALUES ('d447a0f8-9ae6-43e9-9ac9-6b8344091f83', '2023-09-23 16:05:10.845879', 'Higashino Keigo', '2023-09-23 16:05:10.845879');


--
-- TOC entry 4879 (class 0 OID 16401)
-- Dependencies: 218
-- Data for Name: books; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.books VALUES ('7ba0e0b2-6176-427a-8212-da414d7e6edb', '2023-07-12 23:37:46.425488', 'Người trong lưới', '2023-07-13 23:55:28.61', '6a39b1d5-5f57-4781-b7e8-06584792e40e', 9, 42);
INSERT INTO public.books VALUES ('9328bdc9-d5e4-49a5-868a-aa9dd5acd920', '2023-07-14 00:10:35.456', '13.67', '2023-07-14 00:10:35.456', '6a39b1d5-5f57-4781-b7e8-06584792e40e', 0, 0);


--
-- TOC entry 4889 (class 0 OID 16470)
-- Dependencies: 228
-- Data for Name: quotes; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.quotes VALUES ('f054d3dc-17ff-42c1-b228-982c5358d92b', 'this is quote for 1367', '2023-09-24 00:15:10.158026', '2023-09-24 00:15:10.158026', '9328bdc9-d5e4-49a5-868a-aa9dd5acd920');
INSERT INTO public.quotes VALUES ('558791b7-4822-430d-871e-8c16e3bed669', 'this is quote for nguoi trong luoi', '2023-09-24 00:23:44.992296', '2023-09-24 00:23:44.992296', '7ba0e0b2-6176-427a-8212-da414d7e6edb');


--
-- TOC entry 4881 (class 0 OID 16405)
-- Dependencies: 220
-- Data for Name: reviews; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.reviews VALUES ('243585fb-ec7d-430f-9aba-b2da328f9758', 'Such an incredible book', '2023-07-12 23:39:59.368884', 5, '2023-07-12 23:39:59.368884', '7ba0e0b2-6176-427a-8212-da414d7e6edb', '89da780c-85f6-4d05-9517-aeed09113f26');
INSERT INTO public.reviews VALUES ('91d3f754-6ad2-4bd2-9203-db21f734c16f', 'Just amazing', '2023-07-12 23:56:56.647515', 4, '2023-07-12 23:56:56.647515', '7ba0e0b2-6176-427a-8212-da414d7e6edb', '89da780c-85f6-4d05-9517-aeed09113f26');
INSERT INTO public.reviews VALUES ('f1529e1b-0d8c-44ee-bfb7-28094cb33a59', 'Great book for weekend', '2023-07-13 01:14:45.966', 5, '2023-07-13 01:14:45.966', '7ba0e0b2-6176-427a-8212-da414d7e6edb', '899c46f1-1358-4869-a7bd-635f747b5cb9');
INSERT INTO public.reviews VALUES ('c8d69373-787d-496b-836f-fd855b4e5a23', 'Can wait for next chapter', '2023-07-13 01:17:23.9', 4, '2023-07-13 01:17:23.9', '7ba0e0b2-6176-427a-8212-da414d7e6edb', '899c46f1-1358-4869-a7bd-635f747b5cb9');
INSERT INTO public.reviews VALUES ('9ef29f32-5816-412e-92c8-20f50179a9ee', 'Haven''t read a book like this', '2023-07-13 23:13:23.738', 4, '2023-07-13 23:13:23.738', '7ba0e0b2-6176-427a-8212-da414d7e6edb', '899c46f1-1358-4869-a7bd-635f747b5cb9');
INSERT INTO public.reviews VALUES ('8cac05c5-94e5-4607-9c58-78d6c5843a94', 'Love this book', '2023-07-13 23:17:32.74', 5, '2023-07-13 23:17:32.74', '7ba0e0b2-6176-427a-8212-da414d7e6edb', '899c46f1-1358-4869-a7bd-635f747b5cb9');
INSERT INTO public.reviews VALUES ('d230b3b3-9dd8-4640-aae2-a248e1de94e0', 'This man is a great author', '2023-07-13 23:20:40.635', 5, '2023-07-13 23:20:40.635', '7ba0e0b2-6176-427a-8212-da414d7e6edb', '899c46f1-1358-4869-a7bd-635f747b5cb9');
INSERT INTO public.reviews VALUES ('49d235f7-e044-4c07-864e-3799f1e0b0aa', 'Highly recomment this book', '2023-07-13 23:27:58.777', 5, '2023-07-13 23:27:58.777', '7ba0e0b2-6176-427a-8212-da414d7e6edb', '899c46f1-1358-4869-a7bd-635f747b5cb9');
INSERT INTO public.reviews VALUES ('ddd9ac62-fba6-496d-839d-a20457c6e1ab', 'It made my day', '2023-07-13 23:55:28.632', 5, '2023-07-13 23:55:28.632', '7ba0e0b2-6176-427a-8212-da414d7e6edb', '899c46f1-1358-4869-a7bd-635f747b5cb9');


--
-- TOC entry 4884 (class 0 OID 16410)
-- Dependencies: 223
-- Data for Name: token; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.token VALUES (1352, true, true, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4OTA5MTY3MywiZXhwIjoxNjg5MDk1MjczfQ.i8iXocVHj2SKd4H7IKrufHIC-UHPnvHpoRD4mUXKpZk', 'BEARER', '89da780c-85f6-4d05-9517-aeed09113f26');
INSERT INTO public.token VALUES (1353, true, true, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4OTA5MjQ5NSwiZXhwIjoxNjg5MDk2MDk1fQ.QnaYf8hvpX3adI3D701wVmGVGgEqWyxssnDPbl3KOoc', 'BEARER', '89da780c-85f6-4d05-9517-aeed09113f26');
INSERT INTO public.token VALUES (1402, true, true, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4OTE3NjcyOSwiZXhwIjoxNjg5MTgwMzI5fQ.2oGHpS4J4chwNHiXNiCuNx4BOYqZ7w3l6f3ZATz96oo', 'BEARER', '89da780c-85f6-4d05-9517-aeed09113f26');
INSERT INTO public.token VALUES (1502, true, true, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4OTE4MjgzOCwiZXhwIjoxNjg5MTg2NDM4fQ.RSGCMUXFfZOPK15FG3hkbG16qVw4CrM1idS8qOUpIUE', 'BEARER', '89da780c-85f6-4d05-9517-aeed09113f26');
INSERT INTO public.token VALUES (1452, true, true, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aGFuaCIsImlhdCI6MTY4OTE4MTcwNiwiZXhwIjoxNjg5MTg1MzA2fQ.4yo_04xMp7uhmPDShleR3nhqDb_z1KJUKTFbAd1iP1E', 'BEARER', '899c46f1-1358-4869-a7bd-635f747b5cb9');
INSERT INTO public.token VALUES (1552, true, true, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aGFuaCIsImlhdCI6MTY4OTE4MzIxOCwiZXhwIjoxNjg5MTg2ODE4fQ.Ca4rj1eGsqfGW2jVYmFCt0eMiIPE6Xx68Ao2_Kp9n5s', 'BEARER', '899c46f1-1358-4869-a7bd-635f747b5cb9');
INSERT INTO public.token VALUES (1602, true, true, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aGFuaCIsImlhdCI6MTY4OTI2MDUyMiwiZXhwIjoxNjg5MjY0MTIyfQ.bOh1YuMSvckmnoi_5Dpx7850CJrpvnIyai9BjRBTVMY', 'BEARER', '899c46f1-1358-4869-a7bd-635f747b5cb9');
INSERT INTO public.token VALUES (1652, true, true, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aGFuaCIsImlhdCI6MTY4OTI2NDc5MCwiZXhwIjoxNjg5MjY4MzkwfQ.W-svVMqElTJOWfsQKIbfN7YHPPoe9qCdBaqqONxLKDM', 'BEARER', '899c46f1-1358-4869-a7bd-635f747b5cb9');
INSERT INTO public.token VALUES (1653, false, false, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aGFuaCIsImlhdCI6MTY4OTI2NDk2NSwiZXhwIjoxNjg5MjY4NTY1fQ.OiG5BIjssZiKlGDb8rjUkOyqL9WarsQxiys5h1xxy-4', 'BEARER', '899c46f1-1358-4869-a7bd-635f747b5cb9');
INSERT INTO public.token VALUES (1503, true, true, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4OTE4Mjg3NSwiZXhwIjoxNjg5MTg2NDc1fQ.RMAJUBOn0RG_TmkykANe7_BelPEtsAyi0EkJtkvv1Hw', 'BEARER', '89da780c-85f6-4d05-9517-aeed09113f26');
INSERT INTO public.token VALUES (1702, true, true, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY4OTI2ODIyMiwiZXhwIjoxNjg5MjcxODIyfQ.c8lDGestWN_pFfKdH0-r32RUA6AibPXnhUZe9GxTmlU', 'BEARER', '89da780c-85f6-4d05-9517-aeed09113f26');
INSERT INTO public.token VALUES (1752, true, true, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY5Mjg5MTgxMiwiZXhwIjoxNjkyODk1NDEyfQ.k-4nl9R-oibW2-_SJSBxXLPM4V2zq3c2iJ3IJYHiYKY', 'BEARER', '89da780c-85f6-4d05-9517-aeed09113f26');
INSERT INTO public.token VALUES (1802, true, true, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY5NTMxODAwMiwiZXhwIjoxNjk1MzIxNjAyfQ.3uzP4eqESMO4Fd8E-d_gr7pHsJVq8eKKN-xHjv5tTZs', 'BEARER', '89da780c-85f6-4d05-9517-aeed09113f26');
INSERT INTO public.token VALUES (1852, false, false, 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY5NTQ1NjQwMSwiZXhwIjoxNjk1NDYwMDAxfQ.9lCh9WSDOt-pq8_lHLIP7pyUugN-uFLSl-CXi6YDfRM', 'BEARER', '89da780c-85f6-4d05-9517-aeed09113f26');


--
-- TOC entry 4887 (class 0 OID 16417)
-- Dependencies: 226
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users VALUES ('89da780c-85f6-4d05-9517-aeed09113f26', '2023-07-11 23:07:53.806', 'Thanh', 'Nguyen', '$2a$10$yHQ/9ks.AqNeP7R/uZl2Cu4F0ER.RIgidJAmXEc7TY.f5mJg0PQ9m', 'ADMIN', '2023-07-11 23:07:53.806', 'admin');
INSERT INTO public.users VALUES ('899c46f1-1358-4869-a7bd-635f747b5cb9', '2023-07-13 00:08:26.769', 'Huu Thanh', 'Nguyen', '$2a$10$AKkDVs5FHxkJ15l1A9/ssuccj6OT.XbAcAAlkHcFsjxijhG0WRAjW', 'USER', '2023-07-13 00:08:26.769', 'thanh');


--
-- TOC entry 4896 (class 0 OID 0)
-- Dependencies: 217
-- Name: book_collections_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.book_collections_seq', 1, false);


--
-- TOC entry 4897 (class 0 OID 0)
-- Dependencies: 219
-- Name: books_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.books_seq', 1001, true);


--
-- TOC entry 4898 (class 0 OID 0)
-- Dependencies: 221
-- Name: posts_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.posts_seq', 101, true);


--
-- TOC entry 4899 (class 0 OID 0)
-- Dependencies: 222
-- Name: single_books_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.single_books_seq', 1, false);


--
-- TOC entry 4900 (class 0 OID 0)
-- Dependencies: 224
-- Name: token_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.token_seq', 1901, true);


--
-- TOC entry 4901 (class 0 OID 0)
-- Dependencies: 225
-- Name: user_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_seq', 1, false);


--
-- TOC entry 4902 (class 0 OID 0)
-- Dependencies: 227
-- Name: users_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_seq', 151, true);


--
-- TOC entry 4716 (class 2606 OID 16424)
-- Name: authors authors_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.authors
    ADD CONSTRAINT authors_pkey PRIMARY KEY (author_id);


--
-- TOC entry 4718 (class 2606 OID 16426)
-- Name: books books_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (book_id);


--
-- TOC entry 4720 (class 2606 OID 16428)
-- Name: reviews comments_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reviews
    ADD CONSTRAINT comments_pkey PRIMARY KEY (review_id);


--
-- TOC entry 4728 (class 2606 OID 16474)
-- Name: quotes quotes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quotes
    ADD CONSTRAINT quotes_pkey PRIMARY KEY (quote_id);


--
-- TOC entry 4722 (class 2606 OID 16430)
-- Name: token token_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.token
    ADD CONSTRAINT token_pkey PRIMARY KEY (id);


--
-- TOC entry 4724 (class 2606 OID 16432)
-- Name: token uk_pddrhgwxnms2aceeku9s2ewy5; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.token
    ADD CONSTRAINT uk_pddrhgwxnms2aceeku9s2ewy5 UNIQUE (token);


--
-- TOC entry 4726 (class 2606 OID 16434)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 4730 (class 2606 OID 16435)
-- Name: reviews fk5g0c14g8g60pvtudp7xapu0xf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reviews
    ADD CONSTRAINT fk5g0c14g8g60pvtudp7xapu0xf FOREIGN KEY (book_book_id) REFERENCES public.books(book_id);


--
-- TOC entry 4729 (class 2606 OID 16440)
-- Name: books fk7nphya60sreok6xd9kucg7cd6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT fk7nphya60sreok6xd9kucg7cd6 FOREIGN KEY (author_author_id) REFERENCES public.authors(author_id);


--
-- TOC entry 4731 (class 2606 OID 16445)
-- Name: reviews fk8omq0tc18jd43bu5tjh6jvraq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reviews
    ADD CONSTRAINT fk8omq0tc18jd43bu5tjh6jvraq FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4732 (class 2606 OID 16450)
-- Name: token fkj8rfw4x0wjjyibfqq566j4qng; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.token
    ADD CONSTRAINT fkj8rfw4x0wjjyibfqq566j4qng FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 4733 (class 2606 OID 16475)
-- Name: quotes fklan4q0uqacadkmd6fyxitep4b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quotes
    ADD CONSTRAINT fklan4q0uqacadkmd6fyxitep4b FOREIGN KEY (book_book_id) REFERENCES public.books(book_id);


-- Completed on 2023-09-24 19:07:51

--
-- PostgreSQL database dump complete
--

