PGDMP                     	    {            postgres    15.2    15.2 5    J           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
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
       public         heap    postgres    false            �            1259    16402    books    TABLE     �  CREATE TABLE public.books (
    book_id uuid NOT NULL,
    created_at timestamp(6) without time zone,
    title character varying(255),
    updated_at timestamp(6) without time zone,
    author_author_id uuid,
    number_of_reviews integer,
    average_rate real,
    number_of_ratings integer,
    cover_url character varying(255),
    description character varying(2048),
    published_date timestamp(6) without time zone
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
    public          postgres    false    215   =       G          0    16486 
   book_genre 
   TABLE DATA           7   COPY public.book_genre (book_id, genre_id) FROM stdin;
    public          postgres    false    229   �D       ;          0    16402    books 
   TABLE DATA           �   COPY public.books (book_id, created_at, title, updated_at, author_author_id, number_of_reviews, average_rate, number_of_ratings, cover_url, description, published_date) FROM stdin;
    public          postgres    false    217   0E       F          0    16471    genres 
   TABLE DATA           =   COPY public.genres (genre_id, name, description) FROM stdin;
    public          postgres    false    228   oK       >          0    16407    quotes 
   TABLE DATA           Y   COPY public.quotes (quote_id, content, created_at, updated_at, book_book_id) FROM stdin;
    public          postgres    false    220   �Q       ?          0    16410    reviews 
   TABLE DATA           j   COPY public.reviews (review_id, content, created_at, rate, updated_at, book_book_id, user_id) FROM stdin;
    public          postgres    false    221   �R       A          0    16414    token 
   TABLE DATA           Q   COPY public.token (id, expired, revoked, token, token_type, user_id) FROM stdin;
    public          postgres    false    223   >V       D          0    16421    users 
   TABLE DATA           x   COPY public.users (id, created_at, first_name, last_name, password, role, updated_at, username, avatar_url) FROM stdin;
    public          postgres    false    226   �^       P           0    0    book_collections_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.book_collections_seq', 1, false);
          public          postgres    false    216            Q           0    0 	   books_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.books_seq', 1001, true);
          public          postgres    false    218            R           0    0 	   posts_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.posts_seq', 101, true);
          public          postgres    false    219            S           0    0    single_books_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.single_books_seq', 1, false);
          public          postgres    false    222            T           0    0 	   token_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.token_seq', 2951, true);
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
       public          postgres    false    3475    215    217            �           2606    16451 #   reviews fk8omq0tc18jd43bu5tjh6jvraq    FK CONSTRAINT     �   ALTER TABLE ONLY public.reviews
    ADD CONSTRAINT fk8omq0tc18jd43bu5tjh6jvraq FOREIGN KEY (user_id) REFERENCES public.users(id);
 M   ALTER TABLE ONLY public.reviews DROP CONSTRAINT fk8omq0tc18jd43bu5tjh6jvraq;
       public          postgres    false    221    3487    226            �           2606    16456 !   token fkj8rfw4x0wjjyibfqq566j4qng    FK CONSTRAINT     �   ALTER TABLE ONLY public.token
    ADD CONSTRAINT fkj8rfw4x0wjjyibfqq566j4qng FOREIGN KEY (user_id) REFERENCES public.users(id);
 K   ALTER TABLE ONLY public.token DROP CONSTRAINT fkj8rfw4x0wjjyibfqq566j4qng;
       public          postgres    false    3487    223    226            �           2606    16461 "   quotes fklan4q0uqacadkmd6fyxitep4b    FK CONSTRAINT     �   ALTER TABLE ONLY public.quotes
    ADD CONSTRAINT fklan4q0uqacadkmd6fyxitep4b FOREIGN KEY (book_book_id) REFERENCES public.books(book_id);
 L   ALTER TABLE ONLY public.quotes DROP CONSTRAINT fklan4q0uqacadkmd6fyxitep4b;
       public          postgres    false    217    3477    220            �           2606    16491 &   book_genre fknkh6m50njl8771p0ll3lylqp2    FK CONSTRAINT     �   ALTER TABLE ONLY public.book_genre
    ADD CONSTRAINT fknkh6m50njl8771p0ll3lylqp2 FOREIGN KEY (genre_id) REFERENCES public.genres(genre_id);
 P   ALTER TABLE ONLY public.book_genre DROP CONSTRAINT fknkh6m50njl8771p0ll3lylqp2;
       public          postgres    false    3489    229    228            �           2606    16496 &   book_genre fkq0f88ptislu8lv230mvgonssl    FK CONSTRAINT     �   ALTER TABLE ONLY public.book_genre
    ADD CONSTRAINT fkq0f88ptislu8lv230mvgonssl FOREIGN KEY (book_id) REFERENCES public.books(book_id);
 P   ALTER TABLE ONLY public.book_genre DROP CONSTRAINT fkq0f88ptislu8lv230mvgonssl;
       public          postgres    false    217    3477    229            9   ~  x�uWM���=k~E��H I�%����3;;c%{�`�A�l����e69��4{J������h$�A�C$7��b7�HU����8��Dv}��W�j�(��db'lځ�v���Н�d8J&Q�w�����;8�©�9á��ޅ��Rp�$��9�5�ܩ9n�+D\�r�!��\��õ��Zc	g���%����sx���_�����[�R�M�<d&��-E�KPKHJ��I%�&S��R/����t�ʊ��H�����\���ځS����@�k^���K�5:�����������U��U=��'c2��+�)�	��*��ey�Ԫy��p��ԁ�_�k���T�<��,x���[1��5�-Ә�� ؾ�yp����w���Us<s�.�Fdb4�ۚ� _}@�}V��N��Z���>�na�ӈ�n`�tg\����;���Hrt�
[Q吕B;��FmK�!e�
�H���^cx���N��s0f�(�ґ=Z�&v0	=;���vǣ0�D>ܖR���|��p2|'��<7����T��\��<:
���	�{�K��*W�
M���/���y��l�:�FɄn<Uțs�Cd1(oU��w�M�e�E��e&$����jHjAFlAhD&[��TT��/6�5��s�%."��DM�+Z���y����,3��ld=�VSz����*�ݫ���w�L��,Yue:�Lb�be��y�V�@0���x�Js����s1M�Llǖ݈͖�
�������.k/UQ�-]p�Y٤ܦ�H%��c������y��5&G?���P��۷,N�����^���щy�������Xd�mG�M)�shS;Ω
���V�!��H-�n��	�SK����\�2h+�s4����i�M#�yS���q��r`�p�3��9�4��?�e�Ѭ��j|�ș((F���	x�e�A��W�ڨB@��j�N�#�A�'�Rf�����_ڡ�B�{Qc�K��Uxם���9~���?��{8kX�?��|O�]�Z��{�V�W+���J&{�����9�at���&e$��{Z��K1p�oU��4���RҰ�`�+<$��ܖF&�D�������(�� m� cH�������{q�Pԉ�O����t��4�o��ƪ���3iL����y�ߒ���0��[��V�"��7��#��N�B���"#��8E���� GSw���=������k��������/��7߿��?f���UfalԦ.X�I��ؗ��M�n��������D�>D����H���U�d���l�c$p�ʶ�>���uDz��.5�<~ab��֤N��z�5졉�I/i�Ll6��	�Z�u^���7%v�iʓ��堑�V�*C���l�Q���*!��:��^�)�#e3*FJq+#��E��p�)f�O���Ŋam��K�Z�I�T1�\I����;�a��RZ�3���!a��@��A$-j�SN��^E������܍Ҝɤ���Rk���I��<)y5��jk]��Ȍd�6�s�m�2��V��'w��P˔7+Q��3�V��r�F���;����.M�Lڟ��E��LIj�f����QJ���.R��IH[��y%��73tom@%N��2-���kI��Y�(��um�Hw"�٣�-Ե�/ql~�re�"֟\w�ݕ��u-�uq{���H�����`"�W"����:��ft1J�}(�Ya&x�3Fia�h�m�]�9\ }�1�c�;�$�ꋹ**�|�zX����O�����o9(��db�[��P�f�n�������WY�p�6
V����)d��f{��qM�X�wsrO��L-Md�!��U���GuZ��f��p����v��)J�R�Xk�ߧ����� ���      G   �   x����q@!ϡe��z��<��K%p��JZ���o!��B1m"V�Ɨ��G:���P~b|pS�tU'�Տ��d�˳Tl����$���>�mh���6ú_�=0�32�KzY�~3֙gFEAd9BJ�D�K��ۻ7�˦����?�`      ;   /  x��VM��]��
.[�����f�f�IE2��+��K�C�~�]�.�.�v]����"E�H�ϋ.������R��$ئ�+�{�=���HJ��6�U�EVƼ��WY��h�R&�$JRG<JY���d��e�ǋ�?���7;�9�e��۱�|�1��̝o^lYw���#�~4����-yE*�"U�u�
Uq[��d!��B,�<��EM����q�� ^&q�%�X�B�J�sʨ�q�S��J�K�d�,���s>�U3gG�f�����#�̲UR.�1���c���
.
�U�J�Y)�*Q"R�8@�1�m����m!9ER�Je��e[��Z�r%�e������,����2��eS���D����TF5i��"
�טD[�JJ���zZ�'Jj���(�Do�*�U�-��H��צct������j��i����O).DUp*�2��RE��;���U#�Rd`��2�ǯ C{�9���o~j�L�ϛ�/���eL%Wq%kt�nUt_�&e-Q���ZQ�˼$N�3jd�Dod$|�8�,_��2/^#�Oc4s'�B�鱗h�-�E�kK��A=���9�=���v�Oz�Xc����4k��Ր9�^���pe���A*��F�)R5$��{���s#SO�㤘�[���~�|b��a;#��U���jܫ�h�OYC���@�M[2��5��ng�7�_[����խ;��"?���d����h�x�$s�A0���N3N7�,۷
���F���qH?R���}�GǴaq���kM��ƱZ�k�L0>x�~5ª�>��w�~�!�ۂ2e��HoM�L�d�n�`�����!�cM�̀ȟ|�CE�4M��&L+�y�d����;��g��t�E&Q�^��N�����S߃���4�`�IC} �2v����'V�`�V���Woq�0҄&��1u�mgf&GN-ٽ�� ��F�����[0�N]�]�,����b�d��lG����>�yGX�Z^P� �)���e��P�v��Tϭ����Ӭ���Neq�Y>�~����D�[�L=�{w�ν�3u�WpM=ԋ�r�=s[hц6`n��G#�g�h�}�?�#�ak��۰ސ���n2��%A3v�8 7(���
-���[�5ۏ�h�q��]w��s�/�`��m�͂i��]�U{E��>ۡ1�x͚Kp��F?��V�Ө�2��UESaj|�����G1Or�ǅ�E�V2����q��D9v�(��")��~��ͯ�b�d�(MN�2N7/q�7_B�����2[a�˲�}�K�yw��8�O�0���Y����u]u8�0ӝo�v̜����s�
�tz���|�7k�o��K���$q��9��>��+n���>CBf�p���iFs���:J�O���$�A�?j�Ty�"��>��N���PL��PVH��N�aR����2L}y�����u���7��W���ه���Oj8�X��������?v�\�e>~ɀ��7΃��O?��0����!�7� ZB�v>(���[�9]8^0y�@��������(�������ݜ�      F   0  x�}W�n�F<�_1��$A��rZ`��!���e/#NS���Q�!�|�H�p�$�=$EnH"g�Q]]��ܮ�-驾[n���1��秇������~��hc�p��x�OU�*YJ���H�ii����N�F'~��DN��Ǔ����2�f4����e�򩡠�>����Z僊�I�� N[5x6sMVn)FX�rQw:Q7*��@l�
�������U7O�Ju���%�jK���M��Gn�b�FJ�484��cp|��}�#�`0�<�緷oZ��%��Q6Eำ"F�Yฮ�,y��M7�`�]
:&���l�m��(!Ծ��X���.ؔN*�nm�V�g����@jG�"�Q�h��(��po(H<��� Uh
�A���a`���	\����zE����--��l�#\
L%��� �Fϑ���fh��@�|�igߴ��F��bl1#	pm[{.nɁ�Z�C.�Fo�>�C�hj�\*������Ph�Z}v�ݻ'�
����F_Y�Ǐ`�Ľ\+H�GQ��B���6eI8��5@��#�Р����r����=��Ƽ��t�L����PHԯ�ǔv)��~�Qx�X·{D��o)$?�}�_G���e��c86�83wwT��WO���R�
;���{[��'^��,A��d$�)�=�:�F�uEWc�|���(O ��t�"U����v�|�C0��PϽ������M;Ml|8Imr��5�Ѣ���ʤ"vA��a�������?w�d��#�X��=}{q����I� c��3oc��'#p�����m�4c��X�ၣ7�W�/�O��t���<��R?bTm�`0�i]ߙ�O�-{��}:�X�*�Ax/�9�"
p�Y�� �}~��)쨡�}YgW{�m�#w>�4�<�hR�︈�L�*�,G5춑Ρ��@�PP��2�R��2�0�u��F�Ӧ'��P�"��b�:�.(�A���������9J6�`xh��	BV� >�ߡ\b�w2�e����yPV `�U[�s�*r�����[��h"_]�t*/XW{g
�B�0���D�^� ,���!z����ǀ`�<�*r��<`��gw�����2�Z+>/3z�0N8T�㰮d,CVN +n�a��3��SԻy��������8/e-�3l�[��L`�m�6h��2'��-��U}ǡIq�>�e�V�/�:- �� ޸���m۝A����`Z�"��yhф�c��.7k,�wO����q��5��Y/kS?<��{���};���*c�($s|�����lx�Y�����=U��}�3��x��l�ճ_[�bA��Ԥ�xb}�Th�}��y���9��mu��`Q�dTu������/�x��[���;���TB3\-
s8�Վ�?�h�S��aY�6L�~ �Z�n���@OH�umQ�^�Vxޥ���x]�&;�n��U�@kw&FjE����"���)��BYzk[ւ�{DF��B��ే��h�,E��*;��.3��!�lr>������?3��a���('���-D��������Z�Ǥ      >   �   x�}�An�0��+�$EI��ҋ$�i�"F����AQ`�a�aO>�궁� ��
�<r����r|ޞ���k?f��G�Tꅑ�KD\)��eE.�!K�݇��) �2h���{n�\Đ�V�^A�$��V����L}z)������o�x��k�:��Ud1c�w�_���;C�Z�Sjeb�&$^g����B���N�      ?   �  x���=o#G�����.�A��L���5Iy��lI�,����PvΖ���bA���v�}�%9=%�Z�Л,Y �*ޥΑ���}Y���۲ou�oۘw�����D�nt~�<O>��p��Ę�4����YU�b�-����Ub2O/����F�֪ak}w�m�=B�� ���3jv�G�ņ>�vwe#����gX�5�di���嘻%��f05@lr�\2�%{/�ï�&�'�Ǿۏ�Z�i��
�Gcg�3��!��}�|���n�ߔ S`��+O=b�T2_�T��!�cT8dH>t�5el$��hL����D�mƲ��mg�'>�����as뎻w@�Ꝭk����N�Fnm�$m��aT��(Ͼ߮o�xX��N5��Oo��(��"�P� �ÀA㢗G��D/��ﻇgԳ�|���wSķ!9���Λ��U/
h@�9�����!���ts�'w���S������� ���L�����;���wh��b)`���5���i}��}Ԝ��fӶ��u�ř�c�dQ��V��,�X�Uk���n�b	�J>������X��hvIu���r��'�T#�}�c�,���-��S�0����k��Ǖ�����D�	�kG�fO���o�=q�'�l�̓Xj�]<$��4���H���k9����P�f�����ܗ�r܆E��J����V(b��`d۟��٬匊P�������@A�j�]�!@���m8�BbƢ��}lT�R��!�7���{&-I��JY[�{�Zi4�.a_��`�h��:5�
ێ��Q�=�d�+��/�$i�i��}�&�_��ۂ�j֡]��� ���L	��C=~èC�h�謘0�S�se1��λ��j�u`��.hV�FXzek���u����t��
���\C�����t�h�uX���'Ǐ~�����㧶K      A   �  x���[Ϣj����;����r�Lb��"�r���ٓi���G1&\=Y��ZUb��xLO<lңez��0-�pM/���/ӽ�U�4�zIO�����S�7�.��i�[��	��y4�Ϳ26�o��中�H���yV����Q�Ju�D���j�/~�$ޒ�,w
��:�yB)��0	���rF�q�'FPć�Ii�p|����2�l�V>� !2(�yWٓ��}Ӕ�q��~�����G�K��G���$5��7Y�lrCFi�)��e�S�ɕ�{�#.������ѷ�2p�Cp�ɨ_�qM��nٲ ]}�놊Qk�H���ѵב�b��fkݭ�+-T��GCy��߀;Q�e_�18��N�J��b�����[D����0b��U���?a���8��C&���2�Bԙ!�#�I��G��Nq]�fŅ���X,7�Y��\���a��{��o�A���j���ߴ���T�� ��:`���z�Oh�Qq-oف��a)T�ܫ�C�q��Z9��8��Q�]�<�~����wH�z��.�FߝSǳ��a�b�N���u�ߪ"\
N�8O����N����P�dj��g�E��=w}���.�7f��b}? �B����WW!����J4�[�߸+�D-��\��൘9��!=~�P��<��ŔnYWa>k�`*B��G��~�؋(��c���Y=)(r'p��i>;~�����{�zq�0�'������ŠOSS��@���Y�-;�p�`o�U�oHz�X�m�	�,P�e���S�'e���[���38�2�%����J��ܙJi6^�ƪ�!������7�?Q\sLL��ڿ�kb�A��'p�"����R���l��T��L4���D�3:�\�}�xQ݉�_��Fw�>� �->U�¯����Ʀ���~?�!��0�:�X�����)���n�_�	����*sŷ�%��i�`�y�w��g#Ǥ3�U�F����7���h������(|�Vs��hb?��{���o���q�=�6������Z�������s�'�#��\H!dS;Y�����DM,3������_c���`���CN��i	�F�q'vmU��걾�X�&����c�����Gm��p7;]4�tXs�'_������Uh"�x�c�mq�
��m�� -��*(��
_����sV��<62�����ZV{d*r[��<�.��R�3��-�?S|J���>�p�Sq��	��H�1�#��R�F�qwIP?�C�о��Q�z��v8y\Lȯ�	����8;��?�-b��!�7ָֹ��;�q� �����#U�m@8��U����^�c�j9�^��G�A��O&	V=��J!y��0"�R<.F>X,S����n~�*c�A��U���e�IF�(N���IW!���J���@&\m�n���'��\s��7�Sxm��8�:wE޵6�מ]vpm4EY�1d���[������R��Ut'��3	�>�7)5�1m;�Az���BEF>��"�I��\�q�E��	�����W��YXɓa��Ie�5/KR]RK�Z1�k�w�.��b-���ğ�	Mt�����	�x-���֔��	bf+�:�G{s*�L�S�?������^�8%�/Oz�1g�?M�1$8����P��-i�[�0��U˙v�Bw�������bҽ[E�v(�U���g�v�F�������z�O�W5��|rC�|HC�e�������F�z/Nݙ��X�ũU��[g�RT���\y�-����Y�|a���S�Tz�,@߽��	��N�=�L௠5�+����+7�ʲ�z5���X*��%2��;��_��g���l@��6�A>�F�3��c$�+�Ѱ��Ӕ`}c,�2�pٵ��<Ai#?���U(�9��U�&�5����.��#h�{cO2s����I�,�L������>a��Nj�ߊk*s�o���������ɩ�ɥ2J��;���l6a�찏v��Aw�E�܁ôH�]e��`��)(;�^e���θi��x͵꺑�w�b���v��qR�=d���Cs��w(O�G<�XU���{�h�\�������a�Z��f��8�a>A����;�|W��ֳ�{'#�ģ�
hc�6�j�i�a�U�匝#��_������q��      D   �  x�u��n�@D��W�`�6��F@�Zk�l+B.��)�ZH�f�>�� F�����z��vL�`�`Jh`��@P�J&-wV
���t�����R�`�4��Ɣ�`�5mRW�\at��>V�?|ݎ1��X�U�8W���l��x��~U���f��q�<������m6u}��0LJwn�u�AmK��6u�;��|o���|��l�x����w?�I1��r��v�,�Kg�����
�<�|j����&~�hc	S���%(�8H<�{ϱ#��� �%(�<bJEo�s��K��E?�=��Ӫ���mޖ�e~�MW�Y��< ]���׺xY�Ǝ��$���7��2�
Ƃ�J�8���l�m���P3��X�S�(��Z���0%5�*騋�
9�x* �ͱ&y�1M��� �!q
���n��Po+�&�L.�f�#7��.FY���~�sr��|?��l��A|{7�|LGHDťlH����_��g�����H%�     