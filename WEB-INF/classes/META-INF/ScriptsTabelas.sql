-- Scripts para criação do projeto --

CREATE TABLE usuario (
	cpf VARCHAR(100) NOT NULL,
	nome VARCHAR(100) NOT NULL,
  	senha VARCHAR(100) NOT NULL,
 	PRIMARY KEY (cpf) 
);

CREATE TABLE livro (
	id INT NOT NULL,
	nome VARCHAR(100) NOT NULL,
    editora VARCHAR(100) NOT NULL,
    genero VARCHAR(100) NOT NULL,
    edicao VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
 	PRIMARY KEY (id) 
);

CREATE SEQUENCE ID_LIVRO 
	MINVALUE 1 MAXVALUE 999999 INCREMENT BY 1 START WITH 1 ;


