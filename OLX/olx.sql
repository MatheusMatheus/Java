/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     24/09/2018 21:20:36                          */
/*==============================================================*/


drop table if exists CATEGORIA;

drop table if exists COMPRA;

drop table if exists COMPRADOR;

drop table if exists INSERCAO;

drop table if exists LOCALIZACAO;

drop table if exists LOGIN;

drop table if exists PRODUTO;

drop table if exists VENDEDOR;

/*==============================================================*/
/* Table: CATEGORIA                                             */
/*==============================================================*/
create table CATEGORIA
(
   ID_CATEGORIA         bigint not null,
   NOME_CATEGORIA       varchar(100) not null,
   primary key (ID_CATEGORIA)
);

/*==============================================================*/
/* Table: COMPRA                                                */
/*==============================================================*/
create table COMPRA
(
   ID_VENDEDOR          bigint not null,
   ID_COMPRADOR         bigint not null,
   ID_PRODUTO           bigint not null,
   ID_COMPRA            bigint,
   DATA_COMPRA          date,
   primary key (ID_VENDEDOR, ID_COMPRADOR, ID_PRODUTO)
);

/*==============================================================*/
/* Table: COMPRADOR                                             */
/*==============================================================*/
create table COMPRADOR
(
   ID_COMPRADOR         bigint not null,
   ID_LOCALIZACAO       bigint not null,
   ID_LOGIN             bigint not null,
   NOME_COMPRADOR       varchar(100) not null,
   EMAIL_COMPRADOR      varchar(100),
   TELEFONNE_COMPRADOR  varchar(20),
   primary key (ID_COMPRADOR)
);

/*==============================================================*/
/* Table: INSERCAO                                              */
/*==============================================================*/
create table INSERCAO
(
   ID_VENDEDOR          bigint not null,
   ID_PRODUTO           bigint not null,
   ID_INSERCAO          bigint,
   DATA_INSERCAO        date,
   primary key (ID_VENDEDOR, ID_PRODUTO)
);

/*==============================================================*/
/* Table: LOCALIZACAO                                           */
/*==============================================================*/
create table LOCALIZACAO
(
   ID_LOCALIZACAO       bigint not null,
   CIDADE               varchar(100) not null,
   ESTADO               varchar(100) not null,
   CEP                  varchar(8) not null,
   ENDERECO             varchar(100) not null,
   primary key (ID_LOCALIZACAO)
);

/*==============================================================*/
/* Table: LOGIN                                                 */
/*==============================================================*/
create table LOGIN
(
   ID_LOGIN             bigint not null,
   USUARIO              varchar(100) not null,
   SENHA                varchar(100) not null,
   primary key (ID_LOGIN)
);

/*==============================================================*/
/* Table: PRODUTO                                               */
/*==============================================================*/
create table PRODUTO
(
   ID_PRODUTO           bigint not null,
   ID_CATEGORIA         bigint not null,
   DESCRICAO            text not null,
   VALOR                float not null,
   primary key (ID_PRODUTO)
);

/*==============================================================*/
/* Table: VENDEDOR                                              */
/*==============================================================*/
create table VENDEDOR
(
   ID_VENDEDOR          bigint not null,
   ID_LOCALIZACAO       bigint not null,
   ID_LOGIN             bigint not null,
   NOME_VENDEDOR        varchar(100) not null,
   EMAIL_VENDEDOR       varchar(100) not null,
   TELEFONE             varchar(20) not null,
   primary key (ID_VENDEDOR)
);

alter table COMPRA add constraint FK_COMPRA foreign key (ID_VENDEDOR)
      references VENDEDOR (ID_VENDEDOR) on delete restrict on update restrict;

alter table COMPRA add constraint FK_COMPRA2 foreign key (ID_COMPRADOR)
      references COMPRADOR (ID_COMPRADOR) on delete restrict on update restrict;

alter table COMPRA add constraint FK_COMPRA3 foreign key (ID_PRODUTO)
      references PRODUTO (ID_PRODUTO) on delete restrict on update restrict;

alter table COMPRADOR add constraint FK_RELATIONSHIP_3 foreign key (ID_LOCALIZACAO)
      references LOCALIZACAO (ID_LOCALIZACAO) on delete restrict on update restrict;

alter table COMPRADOR add constraint FK_RELATIONSHIP_6 foreign key (ID_LOGIN)
      references LOGIN (ID_LOGIN) on delete restrict on update restrict;

alter table INSERCAO add constraint FK_INSERCAO foreign key (ID_VENDEDOR)
      references VENDEDOR (ID_VENDEDOR) on delete restrict on update restrict;

alter table INSERCAO add constraint FK_INSERCAO2 foreign key (ID_PRODUTO)
      references PRODUTO (ID_PRODUTO) on delete restrict on update restrict;

alter table PRODUTO add constraint FK_RELATIONSHIP_4 foreign key (ID_CATEGORIA)
      references CATEGORIA (ID_CATEGORIA) on delete restrict on update restrict;

alter table VENDEDOR add constraint FK_POSSUI foreign key (ID_LOCALIZACAO)
      references LOCALIZACAO (ID_LOCALIZACAO) on delete restrict on update restrict;

alter table VENDEDOR add constraint FK_RELATIONSHIP_5 foreign key (ID_LOGIN)
      references LOGIN (ID_LOGIN) on delete restrict on update restrict;

