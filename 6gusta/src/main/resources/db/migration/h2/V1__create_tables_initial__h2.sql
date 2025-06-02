-- V1__create_tables_initial_h2.sql

CREATE TABLE PetModel (
                          idpet INT AUTO_INCREMENT PRIMARY KEY,
                          nome VARCHAR(255),
                          idade VARCHAR(255),
                          sexo VARCHAR(255),
                          porte VARCHAR(255),
                          cidade VARCHAR(255),
                          estado VARCHAR(255),
                          caracteristicas VARCHAR(255),
                          descricao VARCHAR(255),
                          fotoperfil CLOB
);

CREATE TABLE interessadosPet (
                                 idCadastrado BIGINT AUTO_INCREMENT PRIMARY KEY,
                                 nome VARCHAR(255),
                                 email VARCHAR(255),
                                 descricao VARCHAR(255),
                                 telefone VARCHAR(255)
);

CREATE TABLE CadastroOng (
                             idong INT AUTO_INCREMENT PRIMARY KEY,
                             nome VARCHAR(255),
                             email VARCHAR(255),
                             senha VARCHAR(255),
                             role VARCHAR(255)
);
