create database banco_java;

use banco_java;

create table funcionarios(
                             id int primary key auto_increment not null,
                             nome varchar(255) not null,
                             data_nasc date not null,
                             salario decimal(6,2),
                             data_registro datetime(6),
                             cadastro_ativo boolean not null
);

INSERT INTO funcionarios (id, nome, data_nasc, salario, data_registro, cadastro_ativo) VALUES(1, 'Antonio', '2024-04-11', 2500.50, '2024-04-11 16:51:48.593000000', 1);
INSERT INTO funcionarios (id, nome, data_nasc, salario, data_registro, cadastro_ativo) VALUES(2, 'Rene', '1992-07-01', 1000.00, '2024-04-11 00:00:00', 1);
INSERT INTO funcionarios (id, nome, data_nasc, salario, data_registro, cadastro_ativo) VALUES(3, 'Rodrigo', '1992-07-01', 2500.88, '2024-04-11 00:00:00', 1);
INSERT INTO funcionarios (id, nome, data_nasc, salario, data_registro, cadastro_ativo) VALUES(4, 'João', '1990-01-01', 4000.00, '2024-04-11 16:57:46.586000000', 1);
INSERT INTO funcionarios (id, nome, data_nasc, salario, data_registro, cadastro_ativo) VALUES(5, 'José', '1992-07-01', 1500.50, '2024-04-12 11:05:49.302000000', 1);
INSERT INTO funcionarios (id, nome, data_nasc, salario, data_registro, cadastro_ativo) VALUES(6, 'Ana', '1992-07-01', 3000.00, '2024-05-08 22:51:51.844000000', 1);
INSERT INTO funcionarios (id, nome, data_nasc, salario, data_registro, cadastro_ativo) VALUES(7, 'Clara', '1992-07-01', 1000.00, '2024-07-11 11:41:57.195970000', 1);
INSERT INTO funcionarios (id, nome, data_nasc, salario, data_registro, cadastro_ativo) VALUES(8, 'Ronaldo', '1992-07-01', 1500.50, '2024-07-11 11:42:56.580855000', 1);
INSERT INTO funcionarios (id, nome, data_nasc, salario, data_registro, cadastro_ativo) VALUES(9, 'TESTE', '1992-07-01', 2500.50, '2024-07-12 20:04:47.047755000', 1);
