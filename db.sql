PGDMP                      {            postgres    16.0    16.0 )               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    5    postgres    DATABASE     �   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE postgres;
                postgres    false                       0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    4887                        3079    16384 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false                       0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    2            �            1259    16397    authors    TABLE     �   CREATE TABLE public.authors (
    author_id uuid NOT NULL,
    created_at timestamp(6) without time zone,
    name character varying(255),
    updated_at timestamp(6) without time zone
);
    DROP TABLE public.authors;
       public         heap    postgres    false            �            1259    16400    book_collections_seq    SEQUENCE     ~   CREATE SEQUENCE public.book_collections_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.book_collections_seq;
       public          postgres    false            �            1259    16401    books    TABLE       CREATE TABLE public.books (
    book_id uuid NOT NULL,
    created_at timestamp(6) without time zone,
    title character varying(255),
    updated_at timestamp(6) without time zone,
    author_author_id uuid,
    number_of_reviews integer,
    sum_of_rate integer
);
    DROP TABLE public.books;
       public         heap    postgres    false            �            1259    16404 	   books_seq    SEQUENCE     s   CREATE SEQUENCE public.books_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.books_seq;
       public          postgres    false            �            1259    16408 	   posts_seq    SEQUENCE     s   CREATE SEQUENCE public.posts_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.posts_seq;
       public          postgres    false            �            1259    16405    reviews    TABLE     �   CREATE TABLE public.reviews (
    review_id uuid NOT NULL,
    content character varying(255),
    created_at timestamp(6) without time zone,
    rate integer,
    updated_at timestamp(6) without time zone,
    book_book_id uuid,
    user_id uuid
);
    DROP TABLE public.reviews;
       public         heap    postgres    false            �            1259    16409    single_books_seq    SEQUENCE     z   CREATE SEQUENCE public.single_books_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.single_books_seq;
       public          postgres    false            �            1259    16410    token    TABLE     �   CREATE TABLE public.token (
    id integer NOT NULL,
    expired boolean NOT NULL,
    revoked boolean NOT NULL,
    token character varying(255),
    token_type character varying(255),
    user_id uuid
);
    DROP TABLE public.token;
       public         heap    postgres    false            �            1259    16415 	   token_seq    SEQUENCE     s   CREATE SEQUENCE public.token_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.token_seq;
       public          postgres    false            �            1259    16416    user_seq    SEQUENCE     r   CREATE SEQUENCE public.user_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.user_seq;
       public          postgres    false            �            1259    16417    users    TABLE     J  CREATE TABLE public.users (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone,
    first_name character varying(255),
    last_name character varying(255),
    password character varying(255),
    role character varying(255),
    updated_at timestamp(6) without time zone,
    username character varying(255)
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    16422 	   users_seq    SEQUENCE     s   CREATE SEQUENCE public.users_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.users_seq;
       public          postgres    false                      0    16397    authors 
   TABLE DATA           J   COPY public.authors (author_id, created_at, name, updated_at) FROM stdin;
    public          postgres    false    216   �,                 0    16401    books 
   TABLE DATA           y   COPY public.books (book_id, created_at, title, updated_at, author_author_id, number_of_reviews, sum_of_rate) FROM stdin;
    public          postgres    false    218   �-       
          0    16405    reviews 
   TABLE DATA           j   COPY public.reviews (review_id, content, created_at, rate, updated_at, book_book_id, user_id) FROM stdin;
    public          postgres    false    220   c.                 0    16410    token 
   TABLE DATA           Q   COPY public.token (id, expired, revoked, token, token_type, user_id) FROM stdin;
    public          postgres    false    223   �0                 0    16417    users 
   TABLE DATA           l   COPY public.users (id, created_at, first_name, last_name, password, role, updated_at, username) FROM stdin;
    public          postgres    false    226   \4                  0    0    book_collections_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.book_collections_seq', 1, false);
          public          postgres    false    217                       0    0 	   books_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.books_seq', 1001, true);
          public          postgres    false    219                       0    0 	   posts_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.posts_seq', 101, true);
          public          postgres    false    221                       0    0    single_books_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.single_books_seq', 1, false);
          public          postgres    false    222                       0    0 	   token_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.token_seq', 1901, true);
          public          postgres    false    224                       0    0    user_seq    SEQUENCE SET     7   SELECT pg_catalog.setval('public.user_seq', 1, false);
          public          postgres    false    225                        0    0 	   users_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.users_seq', 151, true);
          public          postgres    false    227            h           2606    16424    authors authors_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.authors
    ADD CONSTRAINT authors_pkey PRIMARY KEY (author_id);
 >   ALTER TABLE ONLY public.authors DROP CONSTRAINT authors_pkey;
       public            postgres    false    216            j           2606    16426    books books_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (book_id);
 :   ALTER TABLE ONLY public.books DROP CONSTRAINT books_pkey;
       public            postgres    false    218            l           2606    16428    reviews comments_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.reviews
    ADD CONSTRAINT comments_pkey PRIMARY KEY (review_id);
 ?   ALTER TABLE ONLY public.reviews DROP CONSTRAINT comments_pkey;
       public            postgres    false    220            n           2606    16430    token token_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.token
    ADD CONSTRAINT token_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.token DROP CONSTRAINT token_pkey;
       public            postgres    false    223            p           2606    16432 "   token uk_pddrhgwxnms2aceeku9s2ewy5 
   CONSTRAINT     ^   ALTER TABLE ONLY public.token
    ADD CONSTRAINT uk_pddrhgwxnms2aceeku9s2ewy5 UNIQUE (token);
 L   ALTER TABLE ONLY public.token DROP CONSTRAINT uk_pddrhgwxnms2aceeku9s2ewy5;
       public            postgres    false    223            r           2606    16434    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    226            t           2606    16435 #   reviews fk5g0c14g8g60pvtudp7xapu0xf    FK CONSTRAINT     �   ALTER TABLE ONLY public.reviews
    ADD CONSTRAINT fk5g0c14g8g60pvtudp7xapu0xf FOREIGN KEY (book_book_id) REFERENCES public.books(book_id);
 M   ALTER TABLE ONLY public.reviews DROP CONSTRAINT fk5g0c14g8g60pvtudp7xapu0xf;
       public          postgres    false    4714    220    218            s           2606    16440 !   books fk7nphya60sreok6xd9kucg7cd6    FK CONSTRAINT     �   ALTER TABLE ONLY public.books
    ADD CONSTRAINT fk7nphya60sreok6xd9kucg7cd6 FOREIGN KEY (author_author_id) REFERENCES public.authors(author_id);
 K   ALTER TABLE ONLY public.books DROP CONSTRAINT fk7nphya60sreok6xd9kucg7cd6;
       public          postgres    false    4712    218    216            u           2606    16445 #   reviews fk8omq0tc18jd43bu5tjh6jvraq    FK CONSTRAINT     �   ALTER TABLE ONLY public.reviews
    ADD CONSTRAINT fk8omq0tc18jd43bu5tjh6jvraq FOREIGN KEY (user_id) REFERENCES public.users(id);
 M   ALTER TABLE ONLY public.reviews DROP CONSTRAINT fk8omq0tc18jd43bu5tjh6jvraq;
       public          postgres    false    226    220    4722            v           2606    16450 !   token fkj8rfw4x0wjjyibfqq566j4qng    FK CONSTRAINT     �   ALTER TABLE ONLY public.token
    ADD CONSTRAINT fkj8rfw4x0wjjyibfqq566j4qng FOREIGN KEY (user_id) REFERENCES public.users(id);
 K   ALTER TABLE ONLY public.token DROP CONSTRAINT fkj8rfw4x0wjjyibfqq566j4qng;
       public          postgres    false    223    226    4722               �   x�}�;�0@����+;vb;+K%���������K ������>Ӓ!�YA�f�X��z�}H�P�RL\Y���4�p���W���B��6\���ݿ�t(��:����!q�R1W��$��0[{���m�5<����0�         �   x����I�1F�I�&�L�_R�xI6qY����{�;�=�I���x|��������}@01�!$˷�5#W@�k��Ŋ�JDz8�|}\���ח��|���nԛ��9�Q�Qۤ��O� �w ��x�-�SK¹U��N�niC!,����qZ���"b'�U��%�����_�0?���/`�F      
   N  x���Oo�0��Χ�m'E���;�vێ�P�m�!u�u�~J�I�;0d؏6z~4��ɷZbr�K�X�aj}�ݗ�(�q�-{��|�c��n4��D�8��O��.��h��1�Q����@B�P�,ըAkW���x���mQ���uÂmu-z� �r_���Ѷ��І/�w�(���^�a�Џe���=�r��zd�LM�T!��a*�9�<|ګ��.�m�Uot[_�h�di"����>S����f��>�� 1WηH1��yQR좃�Q�!�Р��}&��n��c�(���z��汬���s�8�[��'�/��ڐ�C���7Y��� M��FV��A�汻^Gy��v}��Z�#�XXw@�.�(��OE���;z3.�<�����i��{xA=���89\F:ɱp9ڊ�d�p��(�E���j߄�@7���]���9�r?�v�3@4�eo��U�;q��נ���f)������Fd�Z_�n�zN�n����O�1N>-c�o��*��V�Z�p���g�k�ݐ�%��<|���U���X����	Sw��*����\, ���         �  x���ˎ�J�q����~" t
����I
�
������m契�I������p���t4�H���L�e#S����d��V����<Q ��u|��_�=�n��`�%���->��6u�2
ڳ��u�fP��pO7���*{6V�-�f��Ԗo�����	��x�MH��8J �i��E1ͿSǼ/��=����}�����0�0�@R�ꨯ�֮ǡ�N�U����48K�����E<:�����w�a8]�F�&�m�����=�3'l�B�T|�le�.�u=νgaq�;���U�b���l���q-���L^F:ŷ��UΐB�'�NЀ@���/g�����^��ǽ�����4��c�#�6�5?���W�9���e�?��B.�?��|Fx�E�y��QB��	�qq$��_����S⎪=W�칠R�k3}M��8W.d
p5~3�\�;��N\7��rT�x	�~O�I��#'��+�nqy<�hǩ� �����v�I�b9�W0�-q�g9���ċ�����5��V��*�t�Y��@��Bh�n�J����m��ç�©p�-��xI?�!��~��C��]�EV���x.���Oi�?w���S�0��'_��Va��_�?�K(���9�K}�˱��T�����.�<"R+�Ky�QF?�U����%?�x<<�1<+UO����5��J�83�2�yE���T��X�/<�����7��jڪ���{��%Q�hM;��f��Ӆ슾�LL#�fh��
����l�d���zT�]�8s��l�jt�y"jD�;�����U+��e�Qܸ���&�q�Y���],z���հ��<`�T)���T�B4����O�
�\6q�z�l��N�������:�!�         �   x�uλn�0@��<EV��6��Y��j�PڤU0�RE����2ui^�|G��P֢�8�@`#��E]W`(�����t�x*�h�(?�m��Z��g�O�������ߛz��`�<��9L �H�jO���ة��4bX��ݙ���js�)��4z�ʆbʅơ�����Q�*�+�_�/ "��DI��y^��k����$��ү�8Sk�i����KN�u֞��%Sw9u�G�g�ۣ��8�K���x����[-     