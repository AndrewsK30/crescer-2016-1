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

--7)


