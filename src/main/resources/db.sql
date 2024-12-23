PGDMP  
    &             	    {            database    16.0    16.0 4    ,           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            -           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            .           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            /           1262    16979    database    DATABASE     �   CREATE DATABASE database WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE database;
                postgres    false                        3079    16980 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false            0           0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    2            �            1259    16990    authors    TABLE     ,  CREATE TABLE public.authors (
    author_id uuid NOT NULL,
    created_at timestamp(6) without time zone,
    name character varying(255),
    updated_at timestamp(6) without time zone,
    photo_url character varying(255),
    description character varying(2048),
    born character varying(255)
);
    DROP TABLE public.authors;
       public         heap    postgres    false            �            1259    16995    book_collections_seq    SEQUENCE     ~   CREATE SEQUENCE public.book_collections_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.book_collections_seq;
       public          postgres    false            �            1259    16996 
   book_genre    TABLE     Z   CREATE TABLE public.book_genre (
    book_id uuid NOT NULL,
    genre_id uuid NOT NULL
);
    DROP TABLE public.book_genre;
       public         heap    postgres    false            �            1259    16999    books    TABLE     �  CREATE TABLE public.books (
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
       public         heap    postgres    false            �            1259    17004 	   books_seq    SEQUENCE     s   CREATE SEQUENCE public.books_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.books_seq;
       public          postgres    false            �            1259    17005    genres    TABLE     �   CREATE TABLE public.genres (
    genre_id uuid NOT NULL,
    name character varying(255),
    description character varying(2048)
);
    DROP TABLE public.genres;
       public         heap    postgres    false            �            1259    17010 	   posts_seq    SEQUENCE     s   CREATE SEQUENCE public.posts_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.posts_seq;
       public          postgres    false            �            1259    17011    quotes    TABLE     �   CREATE TABLE public.quotes (
    quote_id uuid NOT NULL,
    content character varying(255),
    created_at timestamp(6) without time zone,
    updated_at timestamp(6) without time zone,
    book_book_id uuid
);
    DROP TABLE public.quotes;
       public         heap    postgres    false            �            1259    17014    reviews    TABLE     �   CREATE TABLE public.reviews (
    review_id uuid NOT NULL,
    content character varying(255),
    created_at timestamp(6) without time zone,
    rate integer,
    updated_at timestamp(6) without time zone,
    book_book_id uuid,
    user_id uuid
);
    DROP TABLE public.reviews;
       public         heap    postgres    false            �            1259    17017    single_books_seq    SEQUENCE     z   CREATE SEQUENCE public.single_books_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.single_books_seq;
       public          postgres    false            �            1259    17018    token    TABLE     �   CREATE TABLE public.token (
    id integer NOT NULL,
    expired boolean NOT NULL,
    revoked boolean NOT NULL,
    token character varying(255),
    token_type character varying(255),
    user_id uuid,
    refresh_token character varying(255)
);
    DROP TABLE public.token;
       public         heap    postgres    false            �            1259    17023 	   token_seq    SEQUENCE     s   CREATE SEQUENCE public.token_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.token_seq;
       public          postgres    false            �            1259    17024    user_seq    SEQUENCE     r   CREATE SEQUENCE public.user_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.user_seq;
       public          postgres    false            �            1259    17025    users    TABLE     q  CREATE TABLE public.users (
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
       public         heap    postgres    false            �            1259    17030 	   users_seq    SEQUENCE     s   CREATE SEQUENCE public.users_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.users_seq;
       public          postgres    false                      0    16990    authors 
   TABLE DATA           h   COPY public.authors (author_id, created_at, name, updated_at, photo_url, description, born) FROM stdin;
    public          postgres    false    216   |<                 0    16996 
   book_genre 
   TABLE DATA           7   COPY public.book_genre (book_id, genre_id) FROM stdin;
    public          postgres    false    218   D                 0    16999    books 
   TABLE DATA           �   COPY public.books (book_id, created_at, title, updated_at, author_author_id, number_of_reviews, average_rate, number_of_ratings, cover_url, description, published_date) FROM stdin;
    public          postgres    false    219   �D                  0    17005    genres 
   TABLE DATA           =   COPY public.genres (genre_id, name, description) FROM stdin;
    public          postgres    false    221   6M       "          0    17011    quotes 
   TABLE DATA           Y   COPY public.quotes (quote_id, content, created_at, updated_at, book_book_id) FROM stdin;
    public          postgres    false    223   vS       #          0    17014    reviews 
   TABLE DATA           j   COPY public.reviews (review_id, content, created_at, rate, updated_at, book_book_id, user_id) FROM stdin;
    public          postgres    false    224   GT       %          0    17018    token 
   TABLE DATA           `   COPY public.token (id, expired, revoked, token, token_type, user_id, refresh_token) FROM stdin;
    public          postgres    false    226   qX       (          0    17025    users 
   TABLE DATA           x   COPY public.users (id, created_at, first_name, last_name, password, role, updated_at, username, avatar_url) FROM stdin;
    public          postgres    false    229   �X       1           0    0    book_collections_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.book_collections_seq', 1, false);
          public          postgres    false    217            2           0    0 	   books_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.books_seq', 1001, true);
          public          postgres    false    220            3           0    0 	   posts_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.posts_seq', 101, true);
          public          postgres    false    222            4           0    0    single_books_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.single_books_seq', 1, false);
          public          postgres    false    225            5           0    0 	   token_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.token_seq', 4101, true);
          public          postgres    false    227            6           0    0    user_seq    SEQUENCE SET     7   SELECT pg_catalog.setval('public.user_seq', 1, false);
          public          postgres    false    228            7           0    0 	   users_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.users_seq', 151, true);
          public          postgres    false    230            t           2606    17032    authors authors_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.authors
    ADD CONSTRAINT authors_pkey PRIMARY KEY (author_id);
 >   ALTER TABLE ONLY public.authors DROP CONSTRAINT authors_pkey;
       public            postgres    false    216            v           2606    17034    book_genre book_genre_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.book_genre
    ADD CONSTRAINT book_genre_pkey PRIMARY KEY (book_id, genre_id);
 D   ALTER TABLE ONLY public.book_genre DROP CONSTRAINT book_genre_pkey;
       public            postgres    false    218    218            x           2606    17036    books books_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (book_id);
 :   ALTER TABLE ONLY public.books DROP CONSTRAINT books_pkey;
       public            postgres    false    219            ~           2606    17038    reviews comments_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.reviews
    ADD CONSTRAINT comments_pkey PRIMARY KEY (review_id);
 ?   ALTER TABLE ONLY public.reviews DROP CONSTRAINT comments_pkey;
       public            postgres    false    224            z           2606    17040    genres genres_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.genres
    ADD CONSTRAINT genres_pkey PRIMARY KEY (genre_id);
 <   ALTER TABLE ONLY public.genres DROP CONSTRAINT genres_pkey;
       public            postgres    false    221            |           2606    17042    quotes quotes_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.quotes
    ADD CONSTRAINT quotes_pkey PRIMARY KEY (quote_id);
 <   ALTER TABLE ONLY public.quotes DROP CONSTRAINT quotes_pkey;
       public            postgres    false    223            �           2606    17044    token token_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.token
    ADD CONSTRAINT token_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.token DROP CONSTRAINT token_pkey;
       public            postgres    false    226            �           2606    17046 "   token uk_pddrhgwxnms2aceeku9s2ewy5 
   CONSTRAINT     ^   ALTER TABLE ONLY public.token
    ADD CONSTRAINT uk_pddrhgwxnms2aceeku9s2ewy5 UNIQUE (token);
 L   ALTER TABLE ONLY public.token DROP CONSTRAINT uk_pddrhgwxnms2aceeku9s2ewy5;
       public            postgres    false    226            �           2606    17048    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    229            �           2606    17049 #   reviews fk5g0c14g8g60pvtudp7xapu0xf    FK CONSTRAINT     �   ALTER TABLE ONLY public.reviews
    ADD CONSTRAINT fk5g0c14g8g60pvtudp7xapu0xf FOREIGN KEY (book_book_id) REFERENCES public.books(book_id);
 M   ALTER TABLE ONLY public.reviews DROP CONSTRAINT fk5g0c14g8g60pvtudp7xapu0xf;
       public          postgres    false    4728    224    219            �           2606    17054 !   books fk7nphya60sreok6xd9kucg7cd6    FK CONSTRAINT     �   ALTER TABLE ONLY public.books
    ADD CONSTRAINT fk7nphya60sreok6xd9kucg7cd6 FOREIGN KEY (author_author_id) REFERENCES public.authors(author_id);
 K   ALTER TABLE ONLY public.books DROP CONSTRAINT fk7nphya60sreok6xd9kucg7cd6;
       public          postgres    false    219    4724    216            �           2606    17059 #   reviews fk8omq0tc18jd43bu5tjh6jvraq    FK CONSTRAINT     �   ALTER TABLE ONLY public.reviews
    ADD CONSTRAINT fk8omq0tc18jd43bu5tjh6jvraq FOREIGN KEY (user_id) REFERENCES public.users(id);
 M   ALTER TABLE ONLY public.reviews DROP CONSTRAINT fk8omq0tc18jd43bu5tjh6jvraq;
       public          postgres    false    224    4740    229            �           2606    17064 !   token fkj8rfw4x0wjjyibfqq566j4qng    FK CONSTRAINT     �   ALTER TABLE ONLY public.token
    ADD CONSTRAINT fkj8rfw4x0wjjyibfqq566j4qng FOREIGN KEY (user_id) REFERENCES public.users(id);
 K   ALTER TABLE ONLY public.token DROP CONSTRAINT fkj8rfw4x0wjjyibfqq566j4qng;
       public          postgres    false    4740    226    229            �           2606    17069 "   quotes fklan4q0uqacadkmd6fyxitep4b    FK CONSTRAINT     �   ALTER TABLE ONLY public.quotes
    ADD CONSTRAINT fklan4q0uqacadkmd6fyxitep4b FOREIGN KEY (book_book_id) REFERENCES public.books(book_id);
 L   ALTER TABLE ONLY public.quotes DROP CONSTRAINT fklan4q0uqacadkmd6fyxitep4b;
       public          postgres    false    4728    223    219            �           2606    17074 &   book_genre fknkh6m50njl8771p0ll3lylqp2    FK CONSTRAINT     �   ALTER TABLE ONLY public.book_genre
    ADD CONSTRAINT fknkh6m50njl8771p0ll3lylqp2 FOREIGN KEY (genre_id) REFERENCES public.genres(genre_id);
 P   ALTER TABLE ONLY public.book_genre DROP CONSTRAINT fknkh6m50njl8771p0ll3lylqp2;
       public          postgres    false    4730    221    218            �           2606    17079 &   book_genre fkq0f88ptislu8lv230mvgonssl    FK CONSTRAINT     �   ALTER TABLE ONLY public.book_genre
    ADD CONSTRAINT fkq0f88ptislu8lv230mvgonssl FOREIGN KEY (book_id) REFERENCES public.books(book_id);
 P   ALTER TABLE ONLY public.book_genre DROP CONSTRAINT fkq0f88ptislu8lv230mvgonssl;
       public          postgres    false    4728    219    218               �  x�uVM��=sE��� ��/�3�퇀]I�5DڊB�Ls��a7=ݳuZ�8�� 9X���!r����b	r�����Zr�Œ�骮z��UMX'^6vƫ��	���$S9�d�����{���;u<�`Lg�?��cύ{��p��\4�<���g�h�G��+ER�j�>�M�*�~�&O���9����?��/o��vLC�*	LfP1�y�����s(��NUk|�ߴZ��8p��y5�Vbkv�0�+g�"����y&��@� U���9�jt/�7
�0E�h��L��0���rNL!*�wL�g����o5&l�TU{xu���2m-�tmàs'�I��\_ݼ�]!�`�K����Jg/���=��i�db�8# ��fǥ%�(�E6��K���W�,Վ�sV5!�!>T)��H�y?)k�pr��=�O�A�yC���3+QiR]�r��{py<���W��zxf<�z���Q���s�&�6�m%�shC;-�
��[��!��̆��B=�(Će� �M|h�$V�:���1(��p.a['�bє�E�Z���u�s����g[:pR˜�Y-���tY0Q��9����,����Tj�J"r��z�e~ʽ0c�$u����y,r�g	v`���� \wx3��axqo�ÿ��b��ﾑ?k�`���j~��k�~����b����?-�7Cd�q4/K��1��P	씕H�Pr',Ë3m��`"�ۦ�^JZ6[��D^�ۊ�	%�7��GD䝥*+K0xA�$Ș
�&F` ��[�ŭ�F�s�(��Oi���MT[�Q�~ea8e�*rb�'N����3I� ��[EA�c���Mf�x湣(GӸw.r�ѓ��\�p<s�QO���잮����[o�����~�9����7_�g@ȷ��7�&溭K�hR�]Y�2���[r�������D��G���3$J�U駤yX�%��)8�	e�l.�G��'����J�5�W�x���֤N%��zY���A>Ƀ��6��v�q�q����뛛��®�Myvo��4R�*½L�Q��m�
> =�JHl�'���F
�I٬��R���3�,�8����fX���
��"-�*+i�?��nX>��AJkx�[��MJ�c�E��j�j�Ǳuӥ���(ͅL[}~+d�F��'U^��f0�3��u��xO�$s������1�-�n_~�+#RVB-3�\h�)--�L�U;��X�w'?��Bl]:(�Bٰ?���o`�k�]$��Q�2�@)�
"q�J�m}����i^I�����-���V�%0�E�#"5x�E�8�SES���C%J�)'R�ul�C{a�R��� Wv,b���������u]����R��0���F�B���N(�9%Fa�i� �5+�oTb�(,,�	�q��vs�D��c��zᓌ7t`�/6=TTS7-o��Y����O�9Dm�k�m9(�]0��-~E�������n��+�u�`妳%Hm!�h��=�I+�w-�4:����:��ɻr��>R	��YYo�U #�0���K��uZ��c�gq8��p2�ҩ��i䄾:I�eN�"w��`��h�3�qx���Feܻ$#ٙd�vdL��f�FF����8/��5�ˋ���
��??��/����__����ف�x��}�H�8oO�J3o�^���#
����
���|��P��c����?~�ߗ��Y�[�lԔv�f��k����(���{���ˢ���%��
��HӒ���r~M�0˰[�@�i���i�iW�C��}D&i�Fd��{Ɗ:@�Ğm�����ݮ� (���ǜ���a7Y:���8�IHR�WB�<�[�UF<m3c��Ȭ��F&f�]�q�������         �   x����q@!ϡe��z��<��K%p��JZ���o!��B1m"V�Ɨ��G:���P~b|pS�tU'�Տ��d�˳Tl����$���>�mh���6ú_�=0�32�KzY�~3֙gFEAd9BJ�D�K��ۻ7�˦����?�`         v  x��W]��}�E=&0����a���Ŏ	�~4���ju�tW�ݥ��[�}a	�BLX�cf�����y���C�%9�Z#y���t����=��so�/)�[�\���A��<s�����Y��I�<���p�g�?����]�EmV����f�����9�7���zh��,�f�Z��h�B|�T�pʄ�BF<�e�oyʣ,��I�2�G�(��`����gN��ȍ�ʋO<��ܠ�e$�lp����ȥO�hxa�$���w�7��+f�VOYMOO�~��/c$�4s���e� &�b�p'
� N=8r� ��cRF%��"ʸ��)
�~��~RfY�-n2	�����z	W��SdDQ��<q��g)�g"qb��a�#���0e�ˢ �n����8^�� ��8��{������Ǟ�lx�[�k^�7d���~i�'�����%Y�IE(AZ*B�D��B �P�E�9�4�q&�C>�0��8�w���&�7���Ӳ�;�U։n�Yֶ��g�ٛlֵ�yݫ#��N5��h+�0�NAF��r*u�����.]
idnhU�1���(d�kz�x.{�L��ɬ�%3l+����O{;�l��e��cv�=��Q�NX.z�c�0��	���r��k^��v�jf��-�R�f�RtX�I��pu����X̈C�$�u��Ӵ��{�T�7-B+���H���`�}�ZÔfnſbhuY�ܰL�c)��s���ŨdB��7o�_}��f�Lj��F/�ߜ
�{���`�׃�x���Z���z<GD췢�E�/vZ�����6�����/��Y��9���+��Q�੮��`I��`�I-jK��5��;pF6���X�����$�T�|�C��Q�Hb�`���j0/�l`�7��1�i�A���n��kb�����צG��)����~��������&�F�R^`�I�%�v�������V��Դ����F�Ҳ��a��8ĺ�VD"�b5���ie����H
�D-4�	��(bn-v6�ksv�E�4k;vK���԰i�f3[o�uD�Ц����n� ���
-�F�1;j�h���L��
b��K����r`���2�K�t�H��g_ϑ��=fy�R�3�A�u%8�*pjiQZZHU��!,K�i�.��q�Q����&E�I�K!y�1��+�N��K\۳��wѓ��=�ض7�s��m�+V�{�Ks/��J�r��^�W$\�i���f�t�)C����%Q����Îf��v��H0\��K��9��:������G���n�$��o��z�>��0�;z!�G
2��|mN��X5����߆��	��4�N�g��`���[��3X��P�l����+���Y>����/,�^	�W��KqZ:�������l�9��a���6�K�`�4;Z?�Cq�wg���B���&'焐���a�|��|p�Ѕ�v/��a'���>���O�b3�=k��ǘ= PHy5߬��vN�9�� �{��O/'p��A_�#
�f�X[؄d�(�-qCxԟ���'�q��� �9����Z_ *M='�޽���Y}��l�=�bƆd��"�/��L[���&�t�߬~��tᯊ�>p>�����~�Q;˟i��a��ts������f��i�6��AE/�[Yr��q�����,)C�|�9���^ѓ�u`s8�B��QN�b�|���j��5d
�v:����3l\=�t�������R��I�.���8+���&᫺"��#���O���r�/p�8�������μ�2Vz�~��Ecߑ��B�n�/t��?`Ԫ�|��R��9��N�ﱞ�n�e�/�(�	�N��f���n�oHÑ<�x��AC�cM����AM]|����/7��#��70l��#t��Q#Z�}eMq�C��u�[��Ss���� GKJ^Q�R���Di5�~ݾ�S�\�"^ke3N��Ơ�.�9���r[қ՟;�t�9a�Y9�پ��=(�m�O�{['ۮj�m������غKhݷ?Z:T���dn��b/Nk몪!�k�9Nj����3�8K�-��y�Íeo`��(�?��?vq���؟H��<��8���\�����{8�q��� 1Ԇ          0  x�}W�n�F<�_1��$A��rZ`��!���e/#NS���Q�!�|�H�p�$�=$EnH"g�Q]]��ܮ�-驾[n���1��秇������~��hc�p��x�OU�*YJ���H�ii����N�F'~��DN��Ǔ����2�f4����e�򩡠�>����Z僊�I�� N[5x6sMVn)FX�rQw:Q7*��@l�
�������U7O�Ju���%�jK���M��Gn�b�FJ�484��cp|��}�#�`0�<�緷oZ��%��Q6Eำ"F�Yฮ�,y��M7�`�]
:&���l�m��(!Ծ��X���.ؔN*�nm�V�g����@jG�"�Q�h��(��po(H<��� Uh
�A���a`���	\����zE����--��l�#\
L%��� �Fϑ���fh��@�|�igߴ��F��bl1#	pm[{.nɁ�Z�C.�Fo�>�C�hj�\*������Ph�Z}v�ݻ'�
����F_Y�Ǐ`�Ľ\+H�GQ��B���6eI8��5@��#�Р����r����=��Ƽ��t�L����PHԯ�ǔv)��~�Qx�X·{D��o)$?�}�_G���e��c86�83wwT��WO���R�
;���{[��'^��,A��d$�)�=�:�F�uEWc�|���(O ��t�"U����v�|�C0��PϽ������M;Ml|8Imr��5�Ѣ���ʤ"vA��a�������?w�d��#�X��=}{q����I� c��3oc��'#p�����m�4c��X�ၣ7�W�/�O��t���<��R?bTm�`0�i]ߙ�O�-{��}:�X�*�Ax/�9�"
p�Y�� �}~��)쨡�}YgW{�m�#w>�4�<�hR�︈�L�*�,G5춑Ρ��@�PP��2�R��2�0�u��F�Ӧ'��P�"��b�:�.(�A���������9J6�`xh��	BV� >�ߡ\b�w2�e����yPV `�U[�s�*r�����[��h"_]�t*/XW{g
�B�0���D�^� ,���!z����ǀ`�<�*r��<`��gw�����2�Z+>/3z�0N8T�㰮d,CVN +n�a��3��SԻy��������8/e-�3l�[��L`�m�6h��2'��-��U}ǡIq�>�e�V�/�:- �� ޸���m۝A����`Z�"��yhф�c��.7k,�wO����q��5��Y/kS?<��{���};���*c�($s|�����lx�Y�����=U��}�3��x��l�ճ_[�bA��Ԥ�xb}�Th�}��y���9��mu��`Q�dTu������/�x��[���;���TB3\-
s8�Վ�?�h�S��aY�6L�~ �Z�n���@OH�umQ�^�Vxޥ���x]�&;�n��U�@kw&FjE����"���)��BYzk[ւ�{DF��B��ే��h�,E��*;��.3��!�lr>������?3��a���('���-D��������Z�Ǥ      "   �   x�}�An�0��+�$EI��ҋ$�i�"F����AQ`�a�aO>�궁� ��
�<r����r|ޞ���k?f��G�Tꅑ�KD\)��eE.�!K�݇��) �2h���{n�\Đ�V�^A�$��V����L}z)������o�x��k�:��Ud1c�w�_���;C�Z�Sjeb�&$^g����B���N�      #     x���OSG��ç�[N��VKݭ9&�ة�/���?�e��`m�|�h���Ŧ8l���IOH�3���� ѢP�i�<$q���\/g�Λm��mS>��\_��a ���a��,!�i◊��� D�"&���)yj���ʔ�iʮ���C�1��{s�}/ķ0DmT웠�
��U�����ݬW��f����}-�{������g����+�e���P-!(���M�ݽ�󸾙����o�`��_=�ċ�x(�I��R)o��(GM�A<�µ�E�-JHR�[Eb���2s�Ίa��l�U7�{�m�w7�K�g�oNӊa�C͏�~>l�e���䱛Ejt��O����F���/��To�>��i�ϻ���!��=b
���r>�\�:�f$S(�aR��d�a?)������ԓ�|�Jk�%ѱI�m\	%��fEr��)wߺ}7����ϓ[��ý��������Jn���?U��Nb��;tGT���CH"��Nuz��p���|R����v�S�1�����s���uoM�F�Q4�{�YoJ3�q��{-�۝���|u77�;�b^1������r>�2�ij!�~PVO
.�s,9r�~���F����t�_��}�>z�ψk���\�Q&�R�|� *�6z �܁��bƯ��O��!r��=��PnI�ѧC����q;Q8�)��%&{�Pfp,�S�$~<̓wz���*&�rf��i�
an���E�l�B�q�.�BՂ_����-����l;{g��4I�[��h|	�:����s����`�ِ�fP��{GD��"Ajv�	����)I^C^���i���8|%�V,��1�Abv���H6;L�#Feg�cY�PL�����1或w��7s[`�j*�W�YXG�N�,�pa>����>[Zh�m����OV���km�9�RŞ�/h��:S�Y(@��5W��㱊qb�d ��O*9�Q,t��T!����ߘ���F�ת(ѣ�$%�֚��想-���dSRxz�}>�lݶ����v������Z9������"�      %      x������ � �      (   �  x�u��n�@D��W�`�6��F@�Zk�l+B.��)�ZH�f�>�� F�����z��vL�`�`Jh`��@P�J&-wV
���t�����R�`�4��Ɣ�`�5mRW�\at��>V�?|ݎ1��X�U�8W���l��x��~U���f��q�<������m6u}��0LJwn�u�AmK��6u�;��|o���|��l�x����w?�I1��r��v�,�Kg�����
�<�|j����&~�hc	S���%(�8H<�{ϱ#��� �%(�<bJEo�s��K��E?�=��Ӫ���mޖ�e~�MW�Y��< ]���׺xY�Ǝ��$���7��2�
Ƃ�J�8���l�m���P3��X�S�(��Z���0%5�*騋�
9�x* �ͱ&y�1M��� �!q
���n��Po+�&�L.�f�#7��.FY���~�sr��|?��l��A|{7�|LGHDťlH����_��g�����H%�     