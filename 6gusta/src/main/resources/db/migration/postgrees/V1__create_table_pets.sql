-- V1__create_tables_initial.sql

CREATE TABLE PetModel (
                          idpet SERIAL PRIMARY KEY,
                          nome VARCHAR(255),
                          idade VARCHAR(255),
                          sexo VARCHAR(255),
                          porte VARCHAR(255),
                          cidade VARCHAR(255),
                          estado VARCHAR(255),
                          caracteristicas VARCHAR(255),
                          descricao VARCHAR(255),
                          fotoperfil TEXT
);

CREATE TABLE interessadosPet (
                                 idCadastrado BIGSERIAL PRIMARY KEY,
                                 nome VARCHAR(255),
                                 email VARCHAR(255),
                                 descricao VARCHAR(255),
                                 telefone VARCHAR(255)
);

CREATE TABLE CadastroOng (
                             idong SERIAL PRIMARY KEY,
                             nome VARCHAR(255),
                             email VARCHAR(255),
                             senha VARCHAR(255),
                             role VARCHAR(255)
);
