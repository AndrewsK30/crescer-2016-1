--1-Consulta Nome empregado, ordena por admisão
SELECT NomeEmpregado FROM Empregado ORDER BY DataAdmissao ASC;
--2- seleciona nome do mepregado, e salario anual, onde o cargo é atendente
--		e salario anula não é maior que 18500
SELECT NomeEmpregado,Salario*12 AS 'Salario Anual' FROM Empregado 
WHERE Cargo = 'Atendente' AND Salario*12<18500 ;
--3-Seleciona id da cidade onde nome é uberlandia.
SELECT IDCidade FROM Cidade WHERE Nome='Uberlândia';
--4-Seleciona id e nome onde o estado é iqual a RS.
SELECT IDCidade,Nome FROM Cidade WHERE UF='RS';