create database gotravel;
use gotravel;
create table usuarios(

	id int not null auto_increment primary key,
    nome varchar(60),
    dataCadastro date,
    ultimoLogin date,
    senha varchar(80) not null);

create table contatos(
	id int not null auto_increment primary key,
    nome varchar(80) not null,
    email varchar(80) not null,
    freq_viagens varchar(80) not null,
    locais_interesse varchar(400) not null);
create table destinos(
	id int not null auto_increment primary key,
    endereco varchar(200) not null,
    atracoes varchar(400) not null,
    informacoes varchar(400) not null);
    create table promocao(
	id int not null auto_increment primary key,
    id_destino int,
    perc_desconto int not null,
    valor_com_desconto decimal(15,2) not null,
    FOREIGN KEY (id_destino) REFERENCES destinos(id)
    );
