--1)Retorna primero nome associados.
SELECT 
	SUBSTRING(Nome, 1, CHARINDEX(' ', Nome) - 1) AS PrimeiroNome
FROM Associado;
--2)Idade dos associados em anos.
SELECT Nome,
	CONVERT(int,ROUND(DATEDIFF(year,DataNascimento,GETDATE()),0)) AS Idade
FROM Associado;
--3)Meses trabalhados
SELECT NomeEmpregado,
	DATEDIFF(month,DataAdmissao,'2000-12-31') AS MesesTraballhados
FROM Empregado
WHERE DataAdmissao>='1980-05-01' AND
	  DataAdmissao<='1982-01-20';

--4)Maior numero em cargo
SELECT TOP(1) Cargo,Count(1) AS Total
FROM Empregado
GROUP BY Cargo
ORDER BY Total DESC

--6)Quanto tempo falta pra 50 anos
SELECT Nome,
	   DATEADD(year,50,DataNascimento) As DataDos50,
	   DATENAME(weekday, DATEADD(year,50,DataNascimento)) as Dia
FROM Associado;
--7)Liste a quantidade de cidades por UF
SELECT UF,Count(1) AS Total
FROM Cidade
GROUP BY UF
ORDER BY Total DESC
--8)Liste a quantidade de cidades que possuem mesmo nome e UF
SELECT Nome, COUNT(1) AS Duplicados 
FROM Cidade 
GROUP BY Nome 
HAVING (COUNT(1) > 1)
--9)Proximo id da tabela associados
SELECT MAX(IDAssociado)+1 AS ProximoID
FROM Associado ;
--10)Limpe CidadeAux e ensira somente nomes e UF não iguais
TRUNCATE TABLE CidadeAux;
INSERT INTO CidadeAux
	SELECT Distinct  MIN(IDCidade),Nome,UF
	FROM   Cidade
	GROUP BY Nome,UF;
--11)Coloque um * no incio do nome de cidades duplicadas
UPDATE Cidade 
SET Nome= CONCAT('*',Nome)  
WHERE Nome IN (
	SELECT Nome  
	FROM Cidade 
	GROUP BY Nome 
	HAVING (COUNT(1) > 1)
);
--12)Selecione o nome e o sexo de associados, sendo que se for f= feminino e m=masculino
SELECT Nome,
	   CASE WHEN Sexo='F' then 'Feminino'
			WHEN Sexo ='M' then 'Masculino'
			ELSE 'Indefinido'
	   END Sexo
FROM Associado;
--13)mostre nome, salario e percentual do impsoto de renda de empreagaods
SELECT NomeEmpregado,Salario,
	   CASE WHEN Salario<1164 then '0%'
			WHEN Salario>=1164 AND Salario<=2326 then '15%'
			ELSE '27,5%'
	   END ImposoDeRenda
FROM Empregado;
--14)Deletar cidades duplicadas
DELETE FROM Cidade WHERE IDCidade NOT IN(
	SELECT MIN(IDCidade)
	FROM Cidade 
	GROUP BY Nome,UF); 
--15)Adiciona regra para nao ter cidades iguais em estados.

ALTER TABLE Cidade
ADD CONSTRAINT UnicoEstadoCidade UNIQUE(Nome,UF);
