CREATE TABLE usuarios (
                          id int PRIMARY KEY AUTO_INCREMENT,
                          email varchar(50) UNIQUE NOT NULL,
                          senha varchar(20) NOT NULL,
                          nome varchar(50) NOT NULL,
                          username varchar(30) UNIQUE NOT NULL,
                          data_nascimento date NOT NULL
);