CREATE SEQUENCE seq_empresa INCREMENT 1 MINVALUE 1 MAXVALUE 9999999 START 1 CACHE 1;
CREATE SEQUENCE seq_leilao INCREMENT 1 MINVALUE 1 MAXVALUE 9999999 START 1 CACHE 1;
CREATE SEQUENCE seq_lote INCREMENT 1 MINVALUE 1 MAXVALUE 9999999 START 1 CACHE 1;
CREATE SEQUENCE seq_comprador INCREMENT 1 MINVALUE 1 MAXVALUE 9999999 START 1 CACHE 1;
CREATE SEQUENCE seq_unidade INCREMENT 1 MINVALUE 1 MAXVALUE 9999999 START 1 CACHE 1;

CREATE TABLE empresa (
    id SERIAL PRIMARY KEY,
    razao_social VARCHAR(84) NOT NULL,
    cnpj VARCHAR(32) NOT NULL UNIQUE,
    logradouro VARCHAR(84),
    municipio VARCHAR(84),
    numero VARCHAR(10),
    complemento VARCHAR(84),
    bairro VARCHAR(84),
    cep VARCHAR(18),
    telefone VARCHAR(32),
    email VARCHAR(254) NOT NULL,
    site VARCHAR(254),
    usuario VARCHAR(20) NOT NULL UNIQUE,
    senha VARCHAR(128),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE TABLE leilao (
    id SERIAL PRIMARY KEY,
    codigo INTEGER,
    descricao VARCHAR(80) NOT NULL,
    vendedor INTEGER NOT NULL,
    inicio_previsto TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE TABLE lote (
    id SERIAL PRIMARY KEY,
    numero_lote INTEGER,
    descricao VARCHAR(60) NOT NULL,
    quantidade NUMERIC NOT NULL,
    valor_inicial NUMERIC,
    unidade VARCHAR(128) NOT NULL,
    leilao_id INTEGER REFERENCES leilao(id) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE TABLE comprador (
    empresa_id INTEGER,
    leilao_id INTEGER,
    PRIMARY KEY (empresa_id, leilao_id),
    FOREIGN KEY (empresa_id) REFERENCES empresa(id) NOT NULL,
    FOREIGN KEY (leilao_id) REFERENCES leilao(id) NOT NULL
);

CREATE TABLE unidade (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(128) NOT NULL
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

-- Dados para a tabela empresa
INSERT INTO empresa (razao_social, cnpj, logradouro, municipio, numero, complemento, bairro, cep, telefone, email, site, usuario, senha, created_at, updated_at) VALUES
('Empresa A', '12345678000101', 'Rua A', 'Cidade A', '10', 'Apto 101', 'Bairro A', '12345000', '1111111111', 'empresaA@example.com', 'www.empresaA.com', 'userA', 'senhaA', NOW(), NOW()),
('Empresa B', '12345678000102', 'Rua B', 'Cidade B', '20', 'Apto 202', 'Bairro B', '12345001', '2222222222', 'empresaB@example.com', 'www.empresaB.com', 'userB', 'senhaB', NOW(), NOW()),
('Empresa C', '12345678000103', 'Rua C', 'Cidade C', '30', 'Apto 303', 'Bairro C', '12345002', '3333333333', 'empresaC@example.com', 'www.empresaC.com', 'userC', 'senhaC', NOW(), NOW()),
('Empresa D', '12345678000104', 'Rua D', 'Cidade D', '40', 'Apto 404', 'Bairro D', '12345003', '4444444444', 'empresaD@example.com', 'www.empresaD.com', 'userD', 'senhaD', NOW(), NOW()),
('Empresa E', '12345678000105', 'Rua E', 'Cidade E', '50', 'Apto 505', 'Bairro E', '12345004', '5555555555', 'empresaE@example.com', 'www.empresaE.com', 'userE', 'senhaE', NOW(), NOW()),
('Empresa F', '12345678000106', 'Rua F', 'Cidade F', '60', 'Apto 606', 'Bairro F', '12345005', '6666666666', 'empresaF@example.com', 'www.empresaF.com', 'userF', 'senhaF', NOW(), NOW()),
('Empresa G', '12345678000107', 'Rua G', 'Cidade G', '70', 'Apto 707', 'Bairro G', '12345006', '7777777777', 'empresaG@example.com', 'www.empresaG.com', 'userG', 'senhaG', NOW(), NOW()),
('Empresa H', '12345678000108', 'Rua H', 'Cidade H', '80', 'Apto 808', 'Bairro H', '12345007', '8888888888', 'empresaH@example.com', 'www.empresaH.com', 'userH', 'senhaH', NOW(), NOW()),
('Empresa I', '12345678000109', 'Rua I', 'Cidade I', '90', 'Apto 909', 'Bairro I', '12345008', '9999999999', 'empresaI@example.com', 'www.empresaI.com', 'userI', 'senhaI', NOW(), NOW()),
('Empresa J', '12345678000110', 'Rua J', 'Cidade J', '100', 'Apto 1010', 'Bairro J', '12345009', '1010101010', 'empresaJ@example.com', 'www.empresaJ.com', 'userJ', 'senhaJ', NOW(), NOW());

-- Dados para a tabela leilao
INSERT INTO leilao (codigo, descricao, vendedor, inicio_previsto, created_at, updated_at) VALUES
(1001, 'Leilao A', 1, NOW(), NOW(), NOW()),
(1002, 'Leilao B', 2, NOW(), NOW(), NOW()),
(1003, 'Leilao C', 3, NOW(), NOW(), NOW()),
(1004, 'Leilao D', 4, NOW(), NOW(), NOW()),
(1005, 'Leilao E', 5, NOW(), NOW(), NOW()),
(1006, 'Leilao F', 6, NOW(), NOW(), NOW()),
(1007, 'Leilao G', 7, NOW(), NOW(), NOW()),
(1008, 'Leilao H', 8, NOW(), NOW(), NOW()),
(1009, 'Leilao I', 9, NOW(), NOW(), NOW()),
(1010, 'Leilao J', 10, NOW(), NOW(), NOW());

-- Dados para a tabela lote
INSERT INTO lote (numero_lote, descricao, quantidade, valor_inicial, unidade, leilao_id, created_at, updated_at) VALUES
(1, 'Lote 1', 100, 1000.00, 'Unidade 1', 1, NOW(), NOW()),
(2, 'Lote 2', 200, 2000.00, 'Unidade 2', 2, NOW(), NOW()),
(3, 'Lote 3', 300, 3000.00, 'Unidade 3', 3, NOW(), NOW()),
(4, 'Lote 4', 400, 4000.00, 'Unidade 4', 4, NOW(), NOW()),
(5, 'Lote 5', 500, 5000.00, 'Unidade 5', 5, NOW(), NOW()),
(6, 'Lote 6', 600, 6000.00, 'Unidade 6', 6, NOW(), NOW()),
(7, 'Lote 7', 700, 7000.00, 'Unidade 7', 7, NOW(), NOW()),
(8, 'Lote 8', 800, 8000.00, 'Unidade 8', 8, NOW(), NOW()),
(9, 'Lote 9', 900, 9000.00, 'Unidade 9', 9, NOW(), NOW()),
(10, 'Lote 10', 1000, 10000.00, 'Unidade 10', 10, NOW(), NOW());

-- Dados para a tabela comprador
INSERT INTO comprador (empresa_id, leilao_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- Dados para a tabela unidade
INSERT INTO unidade (nome, created_at, updated_at) VALUES
('Unidade 1', NOW(), NOW()),
('Unidade 2', NOW(), NOW()),
('Unidade 3', NOW(), NOW()),
('Unidade 4', NOW(), NOW()),
('Unidade 5', NOW(), NOW()),
('Unidade 6', NOW(), NOW()),
('Unidade 7', NOW(), NOW()),
('Unidade 8', NOW(), NOW()),
('Unidade 9', NOW(), NOW()),
('Unidade 10', NOW(), NOW());
