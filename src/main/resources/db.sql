PGDMP     	    )        
    	    {            postgres    15.2    15.2 5    J           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
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
                        false    2            �            1259    16398    authors    TABLE       CREATE TABLE public.authors (
    author_id uuid NOT NULL,
    created_at timestamp(6) without time zone,
    name character varying(255),
    updated_at timestamp(6) without time zone,
    photo_url character varying(255),
    description character varying(2048)
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
       public         heap    postgres    false            �            1259    16402    books    TABLE       CREATE TABLE public.books (
    book_id uuid NOT NULL,
    created_at timestamp(6) without time zone,
    title character varying(255),
    updated_at timestamp(6) without time zone,
    author_author_id uuid,
    number_of_reviews integer,
    sum_of_rating integer
);
    DROP TABLE public.books;
       public         heap    postgres    false            �            1259    16405 	   books_seq    SEQUENCE     s   CREATE SEQUENCE public.books_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
     DROP SEQUENCE public.books_seq;
       public          postgres    false            �            1259    16471    genres    TABLE     \   CREATE TABLE public.genres (
    genre_id uuid NOT NULL,
    name character varying(255)
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
   TABLE DATA           b   COPY public.authors (author_id, created_at, name, updated_at, photo_url, description) FROM stdin;
    public          postgres    false    215   �;       G          0    16486 
   book_genre 
   TABLE DATA           7   COPY public.book_genre (book_id, genre_id) FROM stdin;
    public          postgres    false    229   OC       ;          0    16402    books 
   TABLE DATA           {   COPY public.books (book_id, created_at, title, updated_at, author_author_id, number_of_reviews, sum_of_rating) FROM stdin;
    public          postgres    false    217   �C       F          0    16471    genres 
   TABLE DATA           0   COPY public.genres (genre_id, name) FROM stdin;
    public          postgres    false    228   �E       >          0    16407    quotes 
   TABLE DATA           Y   COPY public.quotes (quote_id, content, created_at, updated_at, book_book_id) FROM stdin;
    public          postgres    false    220   �F       ?          0    16410    reviews 
   TABLE DATA           j   COPY public.reviews (review_id, content, created_at, rate, updated_at, book_book_id, user_id) FROM stdin;
    public          postgres    false    221   SG       A          0    16414    token 
   TABLE DATA           Q   COPY public.token (id, expired, revoked, token, token_type, user_id) FROM stdin;
    public          postgres    false    223   �I       D          0    16421    users 
   TABLE DATA           x   COPY public.users (id, created_at, first_name, last_name, password, role, updated_at, username, avatar_url) FROM stdin;
    public          postgres    false    226   YQ       P           0    0    book_collections_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.book_collections_seq', 1, false);
          public          postgres    false    216            Q           0    0 	   books_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.books_seq', 1001, true);
          public          postgres    false    218            R           0    0 	   posts_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.posts_seq', 101, true);
          public          postgres    false    219            S           0    0    single_books_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.single_books_seq', 1, false);
          public          postgres    false    222            T           0    0 	   token_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.token_seq', 2701, true);
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
       public          postgres    false    221    3477    217            �           2606    16446 !   books fk7nphya60sreok6xd9kucg7cd6    FK CONSTRAINT     �   ALTER TABLE ONLY public.books
    ADD CONSTRAINT fk7nphya60sreok6xd9kucg7cd6 FOREIGN KEY (author_author_id) REFERENCES public.authors(author_id);
 K   ALTER TABLE ONLY public.books DROP CONSTRAINT fk7nphya60sreok6xd9kucg7cd6;
       public          postgres    false    3475    215    217            �           2606    16451 #   reviews fk8omq0tc18jd43bu5tjh6jvraq    FK CONSTRAINT     �   ALTER TABLE ONLY public.reviews
    ADD CONSTRAINT fk8omq0tc18jd43bu5tjh6jvraq FOREIGN KEY (user_id) REFERENCES public.users(id);
 M   ALTER TABLE ONLY public.reviews DROP CONSTRAINT fk8omq0tc18jd43bu5tjh6jvraq;
       public          postgres    false    226    221    3487            �           2606    16456 !   token fkj8rfw4x0wjjyibfqq566j4qng    FK CONSTRAINT     �   ALTER TABLE ONLY public.token
    ADD CONSTRAINT fkj8rfw4x0wjjyibfqq566j4qng FOREIGN KEY (user_id) REFERENCES public.users(id);
 K   ALTER TABLE ONLY public.token DROP CONSTRAINT fkj8rfw4x0wjjyibfqq566j4qng;
       public          postgres    false    3487    223    226            �           2606    16461 "   quotes fklan4q0uqacadkmd6fyxitep4b    FK CONSTRAINT     �   ALTER TABLE ONLY public.quotes
    ADD CONSTRAINT fklan4q0uqacadkmd6fyxitep4b FOREIGN KEY (book_book_id) REFERENCES public.books(book_id);
 L   ALTER TABLE ONLY public.quotes DROP CONSTRAINT fklan4q0uqacadkmd6fyxitep4b;
       public          postgres    false    220    3477    217            �           2606    16491 &   book_genre fknkh6m50njl8771p0ll3lylqp2    FK CONSTRAINT     �   ALTER TABLE ONLY public.book_genre
    ADD CONSTRAINT fknkh6m50njl8771p0ll3lylqp2 FOREIGN KEY (genre_id) REFERENCES public.genres(genre_id);
 P   ALTER TABLE ONLY public.book_genre DROP CONSTRAINT fknkh6m50njl8771p0ll3lylqp2;
       public          postgres    false    228    229    3489            �           2606    16496 &   book_genre fkq0f88ptislu8lv230mvgonssl    FK CONSTRAINT     �   ALTER TABLE ONLY public.book_genre
    ADD CONSTRAINT fkq0f88ptislu8lv230mvgonssl FOREIGN KEY (book_id) REFERENCES public.books(book_id);
 P   ALTER TABLE ONLY public.book_genre DROP CONSTRAINT fkq0f88ptislu8lv230mvgonssl;
       public          postgres    false    3477    217    229            9   r  x�uWM���=����/�H��pfȹ퇀]�v�Ќ�8�h�=d���1����:%p`�r� >	�C���?����"UMw�u.Z��ѯ^�*�Q0���N�$���8JS;f�;a�p�L�=��������������^��.�d��s&��y�9�N��q��R������U�?\����K�8�..a������x�⯯_�ނXU�h2< ���C�f�k�JԼ���+K��BI`2�:�DY��y*��y�A׬�yj���@H�Ѹ�EU�8�_KQ����%+��Z�C�7���/�m��*����<a�ხ5�X&��1^��RE�]��U���Rׂ�	��xB�[X�Z7[3V0���Ә�� ؾ�yp��������Us<s�.�Fdb4�ۚ� ?}@�}���Nl�J���l`�Ո����{�&θ�8���or��螕6��!��.���B+�ڕ�Cʪ�H���Yax��������KG�h9���$��x�C���`�<p;2���L��4�p2��h�8Gg��>�����Q8�GN���\�&W��4�c?������ͷ?������T!c�����w����V����e&$����n�iAF<APD&;��TԪ%.�4���s�%"�wM�+Z옋y����,3�om�;�V[����5�*�ګ���q�L��,)�q&1@YX�n^vu%�})4^�ʜ��X��\L��ı�5b��j������#�˺�KU�jC�rV�)w)>R	��X�y?*sr���Ϥ�T=|��v���pq8�'��0�|tb^<�|�����2Y��Sz]���Ԏs������2�2��e���3sjƔ�P��[Mb����Z��f0-�nbD1o�ס58��FX&���o`�E�7m���q4k��.r&J�1�1����<òmap��J�U) ED�`�~�'�Rf�����_ڡ�B�{Qc��K��Utם���9~���-~���p.V��~��;����>5�z�:�n�
���+&�~#�ᝏsD��6	�MJH����ہ#�b�Tߪ�n���R�p� �+<$���VF�D��}7���,�� ]k OH寉��!�;p�Pĉ�O���ar��4Um��ƪ�B�.C;b|lC�S��8�y�p��Vd�C��Sw�s�	�Q�s�Td���%�z�h��a4�m���*����[o����Ͽ��|�����cfeVm�r~��M�Z���� ��l����͟H��iK��M�G�&P҂T�G%��U]`�#a�-�0v����Ќ�#�W|w�q�Y��ٴ�&5*�#V���͖^jIgb�ƼO��
����f����M�<��/Zi��A�2�$x�VkQ�[��O��I٥l�<[R2�Z���A�Xt/
G�B����_k38\�~2Or��ʕ4۟80����Q#�5<S�)���t���CR���r:M��(2nvW��n��L&����X	\9`@*<�I����8���%�����H�hW9����)��n?~�q�JX	�Ly�uih9c�P�T0��߹�7�i�he����/2����`�HR���cN�"b��ve2MOJ@��^8�'i4���;k*�p¯�i	�u��HHj�h� ��D��ԷQ��݉tg�:�P�^��ĝ���ȕ�XrݣwW�B׵\��ma��*n%۳����^�L�F�눲���(�w6Sd��f��حJ���墥�n��p���ט�������t`�/�z������a��G�b� ��z�ՠ�o����b�OO������J�m�\�l	RS�^Ͷ�����m�䞆2�vW�7
��]9C@�I���lV����p�����F�{��Ɓ����������}      G   �   x����q@!ϡe��z��<��K%p��JZ���o!��B1m"V�Ɨ��G:���P~b|pS�tU'�Տ��d�˳Tl����$���>�mh���6ú_�=0�32�KzY�~3֙gFEAd9BJ�D�K��ۻ7�˦����?�`      ;   �  x��R;n�0��S�+,�]~T� �R�Y���Cb'0��e��n� @\��{*m��IV	l�D�Ý���"ذ86 �����[h���F��w~�q�0�cJ�?ܬ��}~���������o������	�s���g�@1Y(�%���bv���l�u4g�jM��,@�t���bP�Q��X���i�<8y���]_����~��^W�(8+�45����)C(I�Q%$o���;Nu.|�D9�Pc������t�?"�#��*�@L���Z�_�^����=ܼ��nj�@�P`7C����\��X�ƙܥ9������XA�V����>�
��H_o�H8`�����П�������B�"L�V5���$�2y�b6h�#�j���)�ҵ�!3�Xh�RuOX�=V�q�_����u�����\�Ӻ�T��͉�<\�,o�?����<;�Uqn��w�T=��Թ,)$}�T���*��ŭ7��X�S	�s?X��+�E�ؽ�����      F   y   x�-�;� @g��+ƆtKOЅƶĒHm�޾�߇ֲ���g �]��I���=9�m~.{c/B�� +��^.�.=kx��ܯy�p5�8�x1P�
���k�ʺ��~�b�?ȩ&�      >   �   x�}�An�0��+�$EI��ҋ$�i�"F����AQ`�a�aO>�궁� ��
�<r����r|ޞ���k?f��G�Tꅑ�KD\)��eE.�!K�݇��) �2h���{n�\Đ�V�^A�$��V����L}z)������o�x��k�:��Ud1c�w�_���;C�Z�Sjeb�&$^g����B���N�      ?   N  x���Oo�0��Χ�m'E���;�vێ�P�m�!u�u�~J�I�;0d؏6z~4��ɷZbr�K�X�aj}�ݗ�(�q�-{��|�c��n4��D�8��O��.��h��1�Q����@B�P�,ըAkW���x���mQ���uÂmu-z� �r_���Ѷ��І/�w�(���^�a�Џe���=�r��zd�LM�T!��a*�9�<|ګ��.�m�Uot[_�h�di"����>S����f��>�� 1WηH1��yQR좃�Q�!�Р��}&��n��c�(���z��汬���s�8�[��'�/��ڐ�C���7Y��� M��FV��A�汻^Gy��v}��Z�#�XXw@�.�(��OE���;z3.�<�����i��{xA=���89\F:ɱp9ڊ�d�p��(�E���j߄�@7���]���9�r?�v�3@4�eo��U�;q��נ���f)������Fd�Z_�n�zN�n����O�1N>-c�o��*��V�Z�p���g�k�ݐ�%��<|���U���X����	Sw��*����\, ���      A   �  x���YϢ�������a��s��L� ���?�9��v^b�1�WO���VFP������Ur��TOW� ��+���8�`zLv2VRP��99
���O�O����t�%-Ȯ���sf�p2�l�]Í��z$���I�*F�(��ɋ��.���xK�~��1`X4DX�D#����$��#�aq��A�g&��o��?��E��ؤ)="8BdP��\�Kն���ÙP�k8�D?R\"�,��Wp'n� ���Ji�+2LZMI=-ZG.t��1-q�OĎw��^�S��0�]x�5�#�e�t��i�*F-e"�2FW��nK�6[�n	\i����8��G ��	[-}����#8�_�(���y$C��sdER�����+Wu������\H�'}�"$KsH��MP'�dTx�F�?@�'�uQ��a�\W'y�g���hS`H���,��j�T=���U� c�=|U<�Q�~?�	�?�݄����{J,;��Pau+��A�-2k�l�?�3���吂��g��O���E�f+�����6Up8i���5�*��J׺�*¹�ď��� <�����9���T� ��]��e���27��j�m�[mvi_S	�u=B��8�Qv���U�	܂��]�j�{��9�E�~��^�}�J��7���
�Y;c�?x<��<dϢ����/�'���ȍ�-����`xE��"N��ٝ	�����v���>NMM�&�!�3g!���ő�����6 �����tE�������g?P��8*˷/���"������`�Q%�P'�GVB���ƔJ��Tl���)YCݝ]=��5�Ĵ�l��;�&�-�n��B�mmQ�#e����Lٻ�XC˵}F/�}�d�y��G�g՝�} �kp��; ����j��e���k�X��U�n�! &�\�%+v<�#�38��m����O��Q� �4|X���6��[�kp22L:�ku��Kd8�~�M�Wp��2�/�c�j�cNy���zŻ����z���`����nG�V�'��E��\p�I�@!4PF�F&�v<R#���>�p�=��<�X���į��@mts&n��Π�*#YRޗ7{���I�g�y��7=��� �=N�f���+N�ȗ�j�=c�K^>F�Pe]Aܥ��k��K3�?�

3���8>z|�*��EF*:�i�j��LDn-v�i�5�m�5�3���?S|L���:�p�cq>�	���@5�B��BG�qsIP��}Ӟ��A��z��v8z\�������,���^��f���5.U��n�e\S��U����{O�y�f�p�D����Z�g;�P�W�/y�I�EG�W�TH�Y����������y�/��{W|�Ϯ���H��U<�D~��]Ez��@mr�5�7�b����-�;y�Kp���?��q��"�u�d��Y��lVm��́�o�1�b�!�[\}&���g���[q�Vѝx*�8@:?�_�Ĭ��i�鴓R%zh�j��&D+r�����*Nh���x�>C��*��k�N"��y�Y�j�J�Ւ�_��5t��k��'�'4��^��6�$t\�H��KSڹ�&���˘��^(m21��~/r��g�rz����<w�cN�꽏p�l}Y���Y�2�זa(��8�1M����]���bܾZE�v(�U�����fˆ�����텡|�W5�h=rE�|@C�a����x�j�D���Qwȧ���E�-S�P)*��C.7[��s�T��.燺*���9��{W�
�N�5���Ϡ5�+�����7����:5���P(���90��݃؛��7�*ۀ��܀zy�ud���a����*�{��h�N]�啱,�4�y�������?-�i      D   �  x�u��n�@D��W�`�6��F@�Zk�l+B.��)�ZH�f�>�� F�����z��vL�`�`Jh`��@P�J&-wV
���t�����R�`�4��Ɣ�`�5mRW�\at��>V�?|ݎ1��X�U�8W���l��x��~U���f��q�<������m6u}��0LJwn�u�AmK��6u�;��|o���|��l�x����w?�I1��r��v�,�Kg�����
�<�|j����&~�hc	S���%(�8H<�{ϱ#��� �%(�<bJEo�s��K��E?�=��Ӫ���mޖ�e~�MW�Y��< ]���׺xY�Ǝ��$���7��2�
Ƃ�J�8���l�m���P3��X�S�(��Z���0%5�*騋�
9�x* �ͱ&y�1M��� �!q
���n��Po+�&�L.�f�#7��.FY���~�sr��|?��l��A|{7�|LGHDťlH����_��g�����H%�     