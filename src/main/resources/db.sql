PGDMP     4    %             	    {            postgres    15.2    15.2 5    J           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            K           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            L           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            M           1262    5    postgres    DATABASE     j   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';
    DROP DATABASE postgres;
                postgres    false            N           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3661                        3079    16384 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false            O           0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    2            �            1259    16398    authors    TABLE     ,  CREATE TABLE public.authors (
    author_id uuid NOT NULL,
    created_at timestamp(6) without time zone,
    name character varying(255),
    updated_at timestamp(6) without time zone,
    photo_url character varying(255),
    description character varying(2048),
    born character varying(255)
);
    DROP TABLE public.authors;
       public         heap    postgres    false            �            1259    16401    book_collections_seq    SEQUENCE     ~   CREATE SEQUENCE public.book_collections_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.book_collections_seq;
       public          postgres    false            �            1259    16486 
   book_genre    TABLE     Z   CREATE TABLE public.book_genre (
    book_id uuid NOT NULL,
    genre_id uuid NOT NULL
);
    DROP TABLE public.book_genre;
       public         heap    postgres    false            �            1259    16402    books    TABLE     )  CREATE TABLE public.books (
    book_id uuid NOT NULL,
    created_at timestamp(6) without time zone,
    title character varying(255),
    updated_at timestamp(6) without time zone,
    author_author_id uuid,
    number_of_reviews integer,
    average_rate real,
    number_of_ratings integer
);
    DROP TABLE public.books;
       public         heap    postgres    false            �            1259    16405 	   books_seq    SEQUENCE     s   CREATE SEQUENCE public.books_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.books_seq;
       public          postgres    false            �            1259    16471    genres    TABLE     �   CREATE TABLE public.genres (
    genre_id uuid NOT NULL,
    name character varying(255),
    description character varying(2048)
);
    DROP TABLE public.genres;
       public         heap    postgres    false            �            1259    16406 	   posts_seq    SEQUENCE     s   CREATE SEQUENCE public.posts_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.posts_seq;
       public          postgres    false            �            1259    16407    quotes    TABLE     �   CREATE TABLE public.quotes (
    quote_id uuid NOT NULL,
    content character varying(255),
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    book_book_id uuid
);
    DROP TABLE public.quotes;
       public         heap    postgres    false            �            1259    16410    reviews    TABLE     �   CREATE TABLE public.reviews (
    review_id uuid NOT NULL,
    content character varying(255),
    created_at timestamp(6) without time zone,
    rate integer,
    updated_at timestamp(6) without time zone,
    book_book_id uuid,
    user_id uuid
);
    DROP TABLE public.reviews;
       public         heap    postgres    false            �            1259    16413    single_books_seq    SEQUENCE     z   CREATE SEQUENCE public.single_books_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.single_books_seq;
       public          postgres    false            �            1259    16414    token    TABLE     �   CREATE TABLE public.token (
    id integer NOT NULL,
    expired boolean NOT NULL,
    revoked boolean NOT NULL,
    token character varying(255),
    token_type character varying(255),
    user_id uuid
);
    DROP TABLE public.token;
       public         heap    postgres    false            �            1259    16419 	   token_seq    SEQUENCE     s   CREATE SEQUENCE public.token_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.token_seq;
       public          postgres    false            �            1259    16420    user_seq    SEQUENCE     r   CREATE SEQUENCE public.user_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.user_seq;
       public          postgres    false            �            1259    16421    users    TABLE     q  CREATE TABLE public.users (
    id uuid NOT NULL,
    created_at timestamp(6) without time zone,
    first_name character varying(255),
    last_name character varying(255),
    password character varying(255),
    role character varying(255),
    updated_at timestamp(6) without time zone,
    username character varying(255),
    avatar_url character varying(255)
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    16426 	   users_seq    SEQUENCE     s   CREATE SEQUENCE public.users_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.users_seq;
       public          postgres    false            9          0    16398    authors 
   TABLE DATA           h   COPY public.authors (author_id, created_at, name, updated_at, photo_url, description, born) FROM stdin;
    public          postgres    false    215   W<       G          0    16486 
   book_genre 
   TABLE DATA           7   COPY public.book_genre (book_id, genre_id) FROM stdin;
    public          postgres    false    229   �C       ;          0    16402    books 
   TABLE DATA           �   COPY public.books (book_id, created_at, title, updated_at, author_author_id, number_of_reviews, average_rate, number_of_ratings) FROM stdin;
    public          postgres    false    217   �D       F          0    16471    genres 
   TABLE DATA           =   COPY public.genres (genre_id, name, description) FROM stdin;
    public          postgres    false    228   �F       >          0    16407    quotes 
   TABLE DATA           Y   COPY public.quotes (quote_id, content, created_at, updated_at, book_book_id) FROM stdin;
    public          postgres    false    220   �L       ?          0    16410    reviews 
   TABLE DATA           j   COPY public.reviews (review_id, content, created_at, rate, updated_at, book_book_id, user_id) FROM stdin;
    public          postgres    false    221   �M       A          0    16414    token 
   TABLE DATA           Q   COPY public.token (id, expired, revoked, token, token_type, user_id) FROM stdin;
    public          postgres    false    223    Q       D          0    16421    users 
   TABLE DATA           x   COPY public.users (id, created_at, first_name, last_name, password, role, updated_at, username, avatar_url) FROM stdin;
    public          postgres    false    226   mY       P           0    0    book_collections_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.book_collections_seq', 1, false);
          public          postgres    false    216            Q           0    0 	   books_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.books_seq', 1001, true);
          public          postgres    false    218            R           0    0 	   posts_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.posts_seq', 101, true);
          public          postgres    false    219            S           0    0    single_books_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.single_books_seq', 1, false);
          public          postgres    false    222            T           0    0 	   token_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.token_seq', 2851, true);
          public          postgres    false    224            U           0    0    user_seq    SEQUENCE SET     7   SELECT pg_catalog.setval('public.user_seq', 1, false);
          public          postgres    false    225            V           0    0 	   users_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.users_seq', 151, true);
          public          postgres    false    227            �           2606    16428    authors authors_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.authors
    ADD CONSTRAINT authors_pkey PRIMARY KEY (author_id);
 >   ALTER TABLE ONLY public.authors DROP CONSTRAINT authors_pkey;
       public            postgres    false    215            �           2606    16490    book_genre book_genre_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.book_genre
    ADD CONSTRAINT book_genre_pkey PRIMARY KEY (book_id, genre_id);
 D   ALTER TABLE ONLY public.book_genre DROP CONSTRAINT book_genre_pkey;
       public            postgres    false    229    229            �           2606    16430    books books_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (book_id);
 :   ALTER TABLE ONLY public.books DROP CONSTRAINT books_pkey;
       public            postgres    false    217            �           2606    16432    reviews comments_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.reviews
    ADD CONSTRAINT comments_pkey PRIMARY KEY (review_id);
 ?   ALTER TABLE ONLY public.reviews DROP CONSTRAINT comments_pkey;
       public            postgres    false    221            �           2606    16475    genres genres_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.genres
    ADD CONSTRAINT genres_pkey PRIMARY KEY (genre_id);
 <   ALTER TABLE ONLY public.genres DROP CONSTRAINT genres_pkey;
       public            postgres    false    228            �           2606    16434    quotes quotes_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.quotes
    ADD CONSTRAINT quotes_pkey PRIMARY KEY (quote_id);
 <   ALTER TABLE ONLY public.quotes DROP CONSTRAINT quotes_pkey;
       public            postgres    false    220            �           2606    16436    token token_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.token
    ADD CONSTRAINT token_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.token DROP CONSTRAINT token_pkey;
       public            postgres    false    223            �           2606    16438 "   token uk_pddrhgwxnms2aceeku9s2ewy5 
   CONSTRAINT     ^   ALTER TABLE ONLY public.token
    ADD CONSTRAINT uk_pddrhgwxnms2aceeku9s2ewy5 UNIQUE (token);
 L   ALTER TABLE ONLY public.token DROP CONSTRAINT uk_pddrhgwxnms2aceeku9s2ewy5;
       public            postgres    false    223            �           2606    16440    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    226            �           2606    16441 #   reviews fk5g0c14g8g60pvtudp7xapu0xf    FK CONSTRAINT     �   ALTER TABLE ONLY public.reviews
    ADD CONSTRAINT fk5g0c14g8g60pvtudp7xapu0xf FOREIGN KEY (book_book_id) REFERENCES public.books(book_id);
 M   ALTER TABLE ONLY public.reviews DROP CONSTRAINT fk5g0c14g8g60pvtudp7xapu0xf;
       public          postgres    false    221    217    3477            �           2606    16446 !   books fk7nphya60sreok6xd9kucg7cd6    FK CONSTRAINT     �   ALTER TABLE ONLY public.books
    ADD CONSTRAINT fk7nphya60sreok6xd9kucg7cd6 FOREIGN KEY (author_author_id) REFERENCES public.authors(author_id);
 K   ALTER TABLE ONLY public.books DROP CONSTRAINT fk7nphya60sreok6xd9kucg7cd6;
       public          postgres    false    3475    217    215            �           2606    16451 #   reviews fk8omq0tc18jd43bu5tjh6jvraq    FK CONSTRAINT     �   ALTER TABLE ONLY public.reviews
    ADD CONSTRAINT fk8omq0tc18jd43bu5tjh6jvraq FOREIGN KEY (user_id) REFERENCES public.users(id);
 M   ALTER TABLE ONLY public.reviews DROP CONSTRAINT fk8omq0tc18jd43bu5tjh6jvraq;
       public          postgres    false    226    3487    221            �           2606    16456 !   token fkj8rfw4x0wjjyibfqq566j4qng    FK CONSTRAINT     �   ALTER TABLE ONLY public.token
    ADD CONSTRAINT fkj8rfw4x0wjjyibfqq566j4qng FOREIGN KEY (user_id) REFERENCES public.users(id);
 K   ALTER TABLE ONLY public.token DROP CONSTRAINT fkj8rfw4x0wjjyibfqq566j4qng;
       public          postgres    false    226    3487    223            �           2606    16461 "   quotes fklan4q0uqacadkmd6fyxitep4b    FK CONSTRAINT     �   ALTER TABLE ONLY public.quotes
    ADD CONSTRAINT fklan4q0uqacadkmd6fyxitep4b FOREIGN KEY (book_book_id) REFERENCES public.books(book_id);
 L   ALTER TABLE ONLY public.quotes DROP CONSTRAINT fklan4q0uqacadkmd6fyxitep4b;
       public          postgres    false    220    217    3477            �           2606    16491 &   book_genre fknkh6m50njl8771p0ll3lylqp2    FK CONSTRAINT     �   ALTER TABLE ONLY public.book_genre
    ADD CONSTRAINT fknkh6m50njl8771p0ll3lylqp2 FOREIGN KEY (genre_id) REFERENCES public.genres(genre_id);
 P   ALTER TABLE ONLY public.book_genre DROP CONSTRAINT fknkh6m50njl8771p0ll3lylqp2;
       public          postgres    false    228    229    3489            �           2606    16496 &   book_genre fkq0f88ptislu8lv230mvgonssl    FK CONSTRAINT     �   ALTER TABLE ONLY public.book_genre
    ADD CONSTRAINT fkq0f88ptislu8lv230mvgonssl FOREIGN KEY (book_id) REFERENCES public.books(book_id);
 P   ALTER TABLE ONLY public.book_genre DROP CONSTRAINT fkq0f88ptislu8lv230mvgonssl;
       public          postgres    false    217    3477    229            9   ~  x�uWM���=k~E��H I�%����3;;c%{�`�A�l����e69��4{J������h$�A�C$7��b7�HU����8��Dv}��W�j�(��db'lځ�v���Н�d8J&Q�w�����;8�©�9á��ޅ��Rp�$��9�5�ܩ9n�+D\�r�!��\��õ��Zc	g���%����sx���_�����[�R�M�<d&��-E�KPKHJ��I%�&S��R/����t�ʊ��H�����\���ځS����@�k^���K�5:�����������U��U=��'c2��+�)�	��*��ey�Ԫy��p��ԁ�_�k���T�<��,x���[1��5�-Ә�� ؾ�yp����w���Us<s�.�Fdb4�ۚ� _}@�}V��N��Z���>�na�ӈ�n`�tg\����;���Hrt�
[Q吕B;��FmK�!e�
�H���^cx���N��s0f�(�ґ=Z�&v0	=;���vǣ0�D>ܖR���|��p2|'��<7����T��\��<:
���	�{�K��*W�
M���/���y��l�:�FɄn<Uțs�Cd1(oU��w�M�e�E��e&$����jHjAFlAhD&[��TT��/6�5��s�%."��DM�+Z���y����,3��ld=�VSz����*�ݫ���w�L��,Yue:�Lb�be��y�V�@0���x�Js����s1M�Llǖ݈͖�
�������.k/UQ�-]p�Y٤ܦ�H%��c������y��5&G?���P��۷,N�����^���щy�������Xd�mG�M)�shS;Ω
���V�!��H-�n��	�SK����\�2h+�s4����i�M#�yS���q��r`�p�3��9�4��?�e�Ѭ��j|�ș((F���	x�e�A��W�ڨB@��j�N�#�A�'�Rf�����_ڡ�B�{Qc�K��Uxם���9~���?��{8kX�?��|O�]�Z��{�V�W+���J&{�����9�at���&e$��{Z��K1p�oU��4���RҰ�`�+<$��ܖF&�D�������(�� m� cH�������{q�Pԉ�O����t��4�o��ƪ���3iL����y�ߒ���0��[��V�"��7��#��N�B���"#��8E���� GSw���=������k��������/��7߿��?f���UfalԦ.X�I��ؗ��M�n��������D�>D����H���U�d���l�c$p�ʶ�>���uDz��.5�<~ab��֤N��z�5졉�I/i�Ll6��	�Z�u^���7%v�iʓ��堑�V�*C���l�Q���*!��:��^�)�#e3*FJq+#��E��p�)f�O���Ŋam��K�Z�I�T1�\I����;�a��RZ�3���!a��@��A$-j�SN��^E������܍Ҝɤ���Rk���I��<)y5��jk]��Ȍd�6�s�m�2��V��'w��P˔7+Q��3�V��r�F���;����.M�Lڟ��E��LIj�f����QJ���.R��IH[��y%��73tom@%N��2-���kI��Y�(��um�Hw"�٣�-Ե�/ql~�re�"֟\w�ݕ��u-�uq{���H�����`"�W"����:��ft1J�}(�Ya&x�3Fia�h�m�]�9\ }�1�c�;�$�ꋹ**�|�zX����O�����o9(��db�[��P�f�n�������WY�p�6
V����)d��f{��qM�X�wsrO��L-Md�!��U���GuZ��f��p����v��)J�R�Xk�ߧ����� ���      G   �   x����q@!ϡe��z��<��K%p��JZ���o!��B1m"V�Ɨ��G:���P~b|pS�tU'�Տ��d�˳Tl����$���>�mh���6ú_�=0�32�KzY�~3֙gFEAd9BJ�D�K��ۻ7�˦����?�`      ;   �  x��S�n1�w��?0+?��xK> %���{	(�)(�hiB�
�EJ�-���'�&��E�_ұ��c�T���'�d ��!yb�R���j��h�NY7[;;�L0ß/�u�t�ޮ˥���|�ʺ�bu�6'�^���vח���d�����"F֝ q��%Y�!�C��tr�p��1�n:[&
�F��Be4Xc��;&�؍��Ä�#�pt|s�.���p���X��v��'n�y?[�DZ`���|�0n%��@O�m��`̀2��Y�U�W�0�
���j�\j����ֳѳ��0��
�
7�/���6R}�P�ED�X�
.�����s�chF=���׻�+1n���<�@%B�HR���y��t��|��^
��Z���/��m�%R�]�'�Vy��a��n�W���SU&�я��s���N���j�\��)c�b� [������6�I�%���[r~�^-jws����$�����d���T���{����L�8�&��      F   0  x�}W�n�F<�_1��$A��rZ`��!���e/#NS���Q�!�|�H�p�$�=$EnH"g�Q]]��ܮ�-驾[n���1��秇������~��hc�p��x�OU�*YJ���H�ii����N�F'~��DN��Ǔ����2�f4����e�򩡠�>����Z僊�I�� N[5x6sMVn)FX�rQw:Q7*��@l�
�������U7O�Ju���%�jK���M��Gn�b�FJ�484��cp|��}�#�`0�<�緷oZ��%��Q6Eำ"F�Yฮ�,y��M7�`�]
:&���l�m��(!Ծ��X���.ؔN*�nm�V�g����@jG�"�Q�h��(��po(H<��� Uh
�A���a`���	\����zE����--��l�#\
L%��� �Fϑ���fh��@�|�igߴ��F��bl1#	pm[{.nɁ�Z�C.�Fo�>�C�hj�\*������Ph�Z}v�ݻ'�
����F_Y�Ǐ`�Ľ\+H�GQ��B���6eI8��5@��#�Р����r����=��Ƽ��t�L����PHԯ�ǔv)��~�Qx�X·{D��o)$?�}�_G���e��c86�83wwT��WO���R�
;���{[��'^��,A��d$�)�=�:�F�uEWc�|���(O ��t�"U����v�|�C0��PϽ������M;Ml|8Imr��5�Ѣ���ʤ"vA��a�������?w�d��#�X��=}{q����I� c��3oc��'#p�����m�4c��X�ၣ7�W�/�O��t���<��R?bTm�`0�i]ߙ�O�-{��}:�X�*�Ax/�9�"
p�Y�� �}~��)쨡�}YgW{�m�#w>�4�<�hR�︈�L�*�,G5춑Ρ��@�PP��2�R��2�0�u��F�Ӧ'��P�"��b�:�.(�A���������9J6�`xh��	BV� >�ߡ\b�w2�e����yPV `�U[�s�*r�����[��h"_]�t*/XW{g
�B�0���D�^� ,���!z����ǀ`�<�*r��<`��gw�����2�Z+>/3z�0N8T�㰮d,CVN +n�a��3��SԻy��������8/e-�3l�[��L`�m�6h��2'��-��U}ǡIq�>�e�V�/�:- �� ޸���m۝A����`Z�"��yhф�c��.7k,�wO����q��5��Y/kS?<��{���};���*c�($s|�����lx�Y�����=U��}�3��x��l�ճ_[�bA��Ԥ�xb}�Th�}��y���9��mu��`Q�dTu������/�x��[���;���TB3\-
s8�Վ�?�h�S��aY�6L�~ �Z�n���@OH�umQ�^�Vxޥ���x]�&;�n��U�@kw&FjE����"���)��BYzk[ւ�{DF��B��ే��h�,E��*;��.3��!�lr>������?3��a���('���-D��������Z�Ǥ      >   �   x�}�An�0��+�$EI��ҋ$�i�"F����AQ`�a�aO>�궁� ��
�<r����r|ޞ���k?f��G�Tꅑ�KD\)��eE.�!K�݇��) �2h���{n�\Đ�V�^A�$��V����L}z)������o�x��k�:��Ud1c�w�_���;C�Z�Sjeb�&$^g����B���N�      ?   q  x���Mo�F�����-�!vvf?���Ф(ri���%ؒ
Yv�����Ɩ��ȁ�@A|�܇/ߙ�er����
L���� ۚ��.������v\o˾�u�mc��nk,�	�v�4��N&�1F�{b��4�-x؆Ѣ�����[�C��B4OU�@H�U#�ԭ��ԃc�Z����f�=�}����0�M�g��>�r^?�������sGg�aSc�� ��F#\2Qr2��o�����w��[k7m[_i48#��&����3�'����W��@
��'���J���
!�">C$ߡ��\�撥���[Z������XV�C۟���$���9���n��QiDJk�3$Ikç�ж��^������������Qc�tD�¿Q�Ï%�I���]�m�7S~�=<����3U��N�߆�TX��Z2�2�Ԫ�<H�YH�c���!���ts�'w���S���a�۟Z3��t��We9v����3p�͢�D:�&����zu��9)�ͦm����S��EY��Z%o��䏵Y�6���](�a��烺^۸ykz<�rn�Q����r��G�T#�)�c�, �	����;?����k��Ǖ�����D�	� �h�Ln6<�!�2�{�rO����AB׀{"���/l�d��֯M�$#G��C����N�/�帍$5�t��NL�Z�΁q"
���O����1�Q9�.��}�&?P��ڰ�5N��]�菣����� �?7*K)u��f�߉�=���Z¨R����V��<�K�e9X1��HG�Ta�1^_T�Mtl����9I�)N���4�PhAƎ���Y�vQFS=���5ų����e����bbNϕ��NWWW�S ��      A   =  x���YϢ��������eF��� "��L�~�������G�1&�Փ媪U�`��>}�a�b�j�FvFQ��kzO{y~L"R��ȗ"9q2	l�l��~10t��M:9��j��������ҩ{wR�Z�	�(Y�=Β�A����T]M�8�R�+�5�͜|��C�&�$��`b���(:��`g���`�!xf������Q�ޙN��������t���c��}Ӕ���]�e�8����fᠽ��qF���ѫ(U��äS��US���J���ay��=2�����Y<j�8�� ��MK���MWb-bI�Y�:��$=Yt�9�����a_\?|��vة�8F����z��T�#�輕���I��Q6�b����:��L��g�|LC8M2�O'�Ĉ3�S̤�����Iq�f�9�eH$6�Yܣ�λ��;�T���I���G�bJ�YN~�*_��S:xU<�``��h	�=�Ն����G��z�&`ns��R��Ye���o!�g�˓�C�*�y�?�w�j�����h�sc(rpV)O��k���i�׵��[�K�����x����	\���j�H��i�R�|@�2'׆z���[c���	���/�8�Qv���U����Yi%l�G��9�F�q�po�!��|s����e]����S��x���xH�5��z��g�$��CM�%�4��2q#���p�0�'��������MSS�<��`L�{:Zkջ[�;t��M7����S�e����&e���[���38�u<�h��D��ߨJj6���E�z)k��}h���j���~Wy�<�O�L�%���;T������NU��U��ZĹ)��g,g>R<�f���h
X�3N�y ��<�`����lY}�o�fy��F�5��E�V��Y�B����d�S�7p�,6�G�ɕ�b[����4u��8ߺ���g=C�3�U�������7����z75s`�>��Ɯ��غ+W�ߡ[2�*��c8k�o�nQ+��Z;�%���g� �退H�' <���,��r:���>�/��{��/x�ͱ����WS-[��n��N��"BYR��7k'�EW���oz�+�Qe��t8���s:�a'^�����H,�X�ac%K���m��QX��U`�9������sV1�,�S�V��J[Z}�x�3[���p+oPf����T��L�)��� BU[���9�p\��FP�T%7�N���r}�eL� ���.��g�p�8���)����8;�r��KU�+�_�L:�lS��2������=��m@(��U����Z�����<�a3�"{�;��[�XxU*	gM9��¥�^��`y���=O����UF���l=b#'�z�,���m_�.¯|���+�fZ>`���e����<�%�j����8�����l2�yֵ��;-,��l�p��H���뮮�/T�3�ϊ��8'�hv<g�C���Bb4c�vh��Y*�
]8����������?�c�k;|*�ϐ�Ғl���;q�('�����ڿ�uM ��Z��牯�1�w�׬��!l{.�h��Ψr|jI�:&Gks�*O�S�����������?%�7�ǽf���rbJ>����`��Ma�y[S�%�uɨv� g��~���x�>�^���S;���*�@��{��Ú���p��X=��*�Sv.��-�'������{W�<��Q ^�S���;�sq�ժa֩�)��C�v;K�ڢY+ln���l*-n���U�G��~�*�3hM�d���y��񑲬�^��d:���wq�T\�G9v�*������o��4�GXo"t� �C�uE�:�ӣl7���R�I���Z�~r� ԑ5�}�*����*Z�*g�Tu��Ӊ��u�\�H��YP:��c��p��<1�OE��*>�����B�o[�**�0l'�쌸�"%DW���co�f���(�͑��0h��H���`������#�m�:��N�U�}{��g�0|�fZe�Z�:j�^������ϟ$��      D   �  x�u��n�@D��W�`�6��F@�Zk�l+B.��)�ZH�f�>�� F�����z��vL�`�`Jh`��@P�J&-wV
���t�����R�`�4��Ɣ�`�5mRW�\at��>V�?|ݎ1��X�U�8W���l��x��~U���f��q�<������m6u}��0LJwn�u�AmK��6u�;��|o���|��l�x����w?�I1��r��v�,�Kg�����
�<�|j����&~�hc	S���%(�8H<�{ϱ#��� �%(�<bJEo�s��K��E?�=��Ӫ���mޖ�e~�MW�Y��< ]���׺xY�Ǝ��$���7��2�
Ƃ�J�8���l�m���P3��X�S�(��Z���0%5�*騋�
9�x* �ͱ&y�1M��� �!q
���n��Po+�&�L.�f�#7��.FY���~�sr��|?��l��A|{7�|LGHDťlH����_��g�����H%�     