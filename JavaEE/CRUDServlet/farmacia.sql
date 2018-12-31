create database Farmacia;

use Farmacia;


CREATE TABLE estado (
	id INT NOT NULL,
	nome VARCHAR(255) NOT NULL,
    uf VARCHAR(2) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE cidade (
	id INT NOT NULL,
	nome VARCHAR(255) NOT NULL,
    estado_id INT NOT NULL,
	PRIMARY KEY (`id`),
    FOREIGN KEY (estado_id) REFERENCES estado(id)
);

CREATE TABLE laboratorio (
	id INT NOT NULL,
	nome VARCHAR(255) NOT NULL,
	cidade_id INT NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY (cidade_id) REFERENCES cidade(id)
);

CREATE TABLE medicamento (
	id INT NOT NULL,
	nome VARCHAR(255) NOT NULL,
    validade DATETIME NULL,
	laboratorio_id INT NOT NULL,
	tipo VARCHAR(255) NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (laboratorio_id) REFERENCES laboratorio(id)
);