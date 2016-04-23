--1)Selecione o nome do empregado e nome do departamento que cada um está relacionado.
SELECT e.NomeEmpregado,
	   d.NomeDepartamento
	   FROM Empregado e
INNER JOIN Departamento d ON d.IDDepartamento=e.IDDepartamento;
--2)Exibir o nome do associado e sua cidade, exibir também associados sem Cidade relacionada.
SELECT a.Nome,
	   c.Nome AS Nome_Cidade
	   FROM Associado a
LEFT JOIN Cidade c ON c.IDCidade=a.IDCidade;
/*3)Lista os estados (UF) e total de cidades, exibir apenas as cidades que não possuem associados relacionados.
Exemplo: UF Total_Cidades
		 RS      10
		 SP      5*/
SELECT UF,COUNT(1) Total_Cidades
FROM Cidade 
WHERE IDCidade NOT IN(
	SELECT  IDCidade 
	FROM Associado
)	
GROUP BY UF
--4)Faça uma consulta que liste o nome do associado, o nome da cidade, e uma coluna que indique se a cidade é da região SUL (RS, SC, PR), se for imprimir *** (3 asteriscos), senão imprimir nulo.
SELECT a.Nome AS NomeAssociado,
	   c.Nome AS NomeCidade,
	   CASE WHEN c.UF='RS' OR c.UF='SC' OR c.UF='PR' then '***'
			ELSE NULL
	   END UF
FROM Associado a
INNER JOIN Cidade c ON c.IDCidade = a.IDAssociado;

--5)Liste o nome do empregado, o nome do gerente, e o departamento de cada um.
SELECT e.NomeEmpregado AS Empregado,
	   g.NomeEmpregado AS Gerente,
	   d.NomeDepartamento as GerenteDepartamento,
	   h.NomeDepartamento as FuncionarioDepartamento
	   FROM	Empregado e 
INNER JOIN Empregado g ON e.IDGerente = g.IDGerente
INNER JOIN Departamento d ON d.IDDepartamento = g.IDDepartamento
INNER JOIN Departamento h ON h.IDDepartamento = e.IDDepartamento
--6)Faça uma cópia da tabela Empregado e altere o salário de todos os empregados (Empregado) que o departamento fique na localidade de SAO PAULO, faça um reajuste de 14,5%
SELECT * 
INTO EmpregadoAux
FROM Empregado;

UPDATE EmpregadoAux SET Salario*1.145
WHERE IDDepartamento IN (
	SELECT IDDepartamento 
	FROM   Departamento
	WHERE  Localizacao='SAO PAULO'
)
--7)Liste a diferença que representará o reajuste aplicado no item anterior no somatório dos salários de todos os empregados.
SELECT  SUM(Novo.Salario)-SUM(Velho.Salario) AS DiferencaReajuste  		
 		FROM Empregado Velho
INNER JOIN EmpregadoAux Novo ON Novo.IDEmpregado =  Velho.IDEmpregado;
--8)Liste o departamento com o empregado de maior salário.
SELECT NomeDepartamento
FROM Departamento
WHERE IDDepartamento IN(
	SELECT TOP 1 IDDepartamento
	FROM Empregado
	ORDER BY Salario DESC
)
--9)Faça uma consulta para exibir o nome de cada associado e sua cidade e juntamente com os empregados (nome) e a cidade (localidade) de seu departamento, isto deve ser exibido em uma consulta.
SELECT a.Nome AS Nome,
	   c.Nome AS Cidade
FROM Associado a
INNER JOIN Cidade c ON c.IDCidade = a.IDCidade
UNION ALL
SELECT e.NomeEmpregado,
	   d.Localizacao 
FROM Empregado e
INNER JOIN Departamento d ON d.IDDepartamento = e.IDDepartamento

--10)Lista as cidades que tenham associado relacionados. Exibr: Nome e UF apenas

SELECT Nome,UF
FROM Cidade
WHERE IDCidade IN(
	SELECT IDCidade
	FROM Associado
);