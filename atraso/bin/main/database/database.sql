-- 1. Tenta apagar a tabela primeiro, se ela existir
DROP TABLE IF EXISTS ocorrencias;

-- 2. Tenta apagar o banco de dados, se ele existir
DROP DATABASE IF EXISTS atrasos;

-- 3. Cria o banco de dados se não existir
CREATE DATABASE IF NOT EXISTS atrasos;

-- 4. Seleciona o banco de dados para criar a tabela dentro dele
USE atrasos;

-- 5. Cria a tabela com a estrutura definida
CREATE TABLE IF NOT EXISTS ocorrencia (
    id INT NOT NULL AUTO_INCREMENT,         
    nome_aluno VARCHAR(100) NOT NULL,      
    horario DATETIME NOT NULL,              
    justificativa TEXT,                     
    PRIMARY KEY (id)                        
);


INSERT INTO ocorrencia (nome_aluno, horario, justificativa) 
VALUES 
('Ana Souza', '2023-10-25 07:15:00', 'Ônibus quebrou no trajeto'),
('Bruno Oliveira', '2023-10-25 07:45:30', 'Consulta médica agendada'),
('Carla Dias', '2023-10-26 08:00:00', NULL),
('Diego Lima', '2023-10-26 08:10:00', 'Problemas com o despertador');