/*
--BEGIN TRANSACTION
--GO 

--Volata atras:
--ROLLBACK

--commit 
--Exercicios:
--1)
INSERT INTO Associado 
	(IDAssociado, Nome, DataNascimento, Sexo, CPF, Endereco, Bairro, Complemento, IDCidade)
VALUES
	(3, 'Marcio Silva', getDate(), 'M', '0897373290', 'Pinheiro rodrigues', 'Bisa', 'Perto hospital',2 );

--2)
SELECT * 
INTO CidadeAux
FROM Cidade;

--3)

TRUNCATE TABLE CidadeAux;
INSERT INTO CidadeAux
SELECT * FROM Cidade

--4)

CREATE TABLE Produtos(
	IDProduto		INT IDENTITY    NOT NULL,
	NomeCurto		VARCHAR(10)		NOT NULL,
	NomeDescricao	VARCHAR(40)		NOT NULL,
	DataCriacao		DATETIME		NOT NULL,
	LocalNoEstoque	VARCHAR(20)		NOT NULL,
	Quantidade		INT				NOT NULL,
	Preco			FLOAT			NOT NULL,
	constraint PK_Produto primary key (IDProduto)
);

--5)
INSERT INTO Produtos
	(NomeCurto,NomeDescricao,DataCriacao,LocalNoEstoque,Quantidade,Preco)
VALUES
	('Bolacha', 'Trakinas de morango', getDate(), 'Armazem R1', 20, '1.78'),

	('Salgadinho', 'Doritos', getDate(), 'Armazem R2', 20, '2.00');

*/



