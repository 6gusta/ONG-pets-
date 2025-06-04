CREATE TABLE CadastroOng (
                             idong INT NOT NULL AUTO_INCREMENT,
                             nome VARCHAR(255),
                             email VARCHAR(255),
                             senha VARCHAR(255),
                             role VARCHAR(255),
                             PRIMARY KEY (idong)
);

CREATE TABLE INTERESSADOSPET (
                                 IDCadastrado BIGINT NOT NULL AUTO_INCREMENT,
                                 nome VARCHAR(255),
                                 email VARCHAR(255),
                                 descricao VARCHAR(255),
                                 telefone VARCHAR(255),
                                 PRIMARY KEY (IDCadastrado)
);

CREATE TABLE PETMODEL (
                          idpet INT NOT NULL AUTO_INCREMENT,
                          nome VARCHAR(255),
                          idade VARCHAR(255),
                          sexo VARCHAR(255),
                          porte VARCHAR(255),
                          cidade VARCHAR(255),
                          estado VARCHAR(255),
                          caracteristicas VARCHAR(255),
                          descricao VARCHAR(255),
                          fotoperfil TEXT,
                          PRIMARY KEY (idpet)
);
