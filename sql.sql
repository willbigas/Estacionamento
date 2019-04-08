create database  if not exists estacionamento;
use estacionamento;

CREATE TABLE carro (
  id int(10) NOT NULL auto_increment,
  placa varchar(50) NULL,
  cor varchar(50) NULL,
  modelo varchar(50) null,
  marca varchar(50) null,
  PRIMARY KEY(id)
);

CREATE TABLE condutor (
  id int(10) NOT NULL auto_increment,
  nome varchar(50) NULL,
  PRIMARY KEY(id)
);

CREATE TABLE tipoCliente (
  id int(10) NOT NULL auto_increment,
  idTipo Integer(1) NULL,
  PRIMARY KEY(id)
);

CREATE TABLE ultimaEntrada (
  id int(10) NOT NULL auto_increment,
  dataEntrada datetime,
  dataSaida datetime,
  valorTotal decimal(10,2),
  fk_carro int,
  fk_condutor int,
  fk_tipoCliente int,
  PRIMARY KEY(id),
  FOREIGN KEY (fk_carro) REFERENCES carro(id),
  FOREIGN KEY (fk_condutor) REFERENCES condutor(id),
  FOREIGN KEY (fk_tipoCliente) REFERENCES tipoCliente(id)
);


CREATE TABLE entrada (
  id int(10) NOT NULL auto_increment,
  dataEntrada datetime,
  dataSaida datetime,
  valorTotal decimal(10,2),
  fk_carro int,
  fk_condutor int,
  fk_tipoCliente int,
  fk_ultimaEntrada int,
  PRIMARY KEY(id),
  FOREIGN KEY (fk_carro) REFERENCES carro(id),
  FOREIGN KEY (fk_condutor) REFERENCES condutor(id),
  FOREIGN KEY (fk_tipoCliente) REFERENCES tipoCliente(id),
  FOREIGN KEY (fk_ultimaEntrada) REFERENCES ultimaEntrada(id)
);


select * from carro;

select * from condutor;

select * from tipoCliente;

select * from Entrada;

select * from ultimaEntrada;