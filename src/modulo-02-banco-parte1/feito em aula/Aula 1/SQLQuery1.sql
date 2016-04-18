/*
Criando tabela cidade:

	CREATE TABLE Cidade(
	IDCidade	INT			NOT NULL,
	Nome		VARCHAR(30)	NOT NULL,
	UF			VARCHAR(2)	NOT	NULL,
	CONSTRAINT PK_Cidade PRIMARY KEY (IDCidade)
	);

Altera tabela,para ID primary key:

	ALTER TABLE Cidade ADD 
	CONSTRAINT PK_Cidade PRIMARY KEY (IDCidade);

Insere dados de forma certa:
	
	INSERT INTO Cidade
		(IDCidade, Nome, UF)
	VALUES
		(1,"São Lepoldo", "RS");

Deleta resultados já deletados:

	DELETE TABLE Cidade;

Seleciona tudo tabela:

	SELECT * FROM Cidade;


Criando tabela cidade com identidade IDENTITY(Começo,Incremento):

	CREATE TABLE Cliente(
	IDCliente	INT			IDENTITY	NOT NULL,
	Nome		VARCHAR(30)	NOT NULL,
	Endereco	VARCHAR(35),
	Bairro		VARCHAR(35),
	IDCidade	int
	);

Insert com identy:

	INSERT INTO Cliente
		(Nome)
	VALUES
		('Maria');

Resultado:

	SELECT * FROM Cliente;

	IDCliente	Nome	Endereco	Bairro	IDCidade
	1			Maria	NULL		NULL	NULL

Cria tabela, com chave unica(Unique):
	Create table Cidade ( IDCidade   int NOT NULL, 
	Nome       varchar(30) NOT NULL, 
	UF         varchar(2) NOT NULL, 
	constraint PK_Cidade      Primary Key (IDCidade), 
	constraint UK_Cidade_Nome Unique (Nome) 
	);

Tabela com key foreign key e check:
	Create table Empregado ( 
	IDEmpregado int NOT NULL, 
	Nome        varchar(50) NOT NULL, 
	Sexo        char(1) NOT NULL, 
	IDCidade int NOT NULL, 
	constraint PK_Empregado        
	Primary Key (IDEmpregado), 
	constraint CC_Empregado_Sexo   Check (Sexo in ('F','M')), 
	constraint FK_Empregado_Cidade Foreign Key (IDCidade) References Cidade (IDCidade) 
	);

Descrição da tabela:
	exec SP_HELP 'Empregado'
*/

INSERT INTO Empregado
		(IDEmpregado, Nome, Sexo, IDCidade)
		VALUES
		(1, 'Maria', 'F', 1);




