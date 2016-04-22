--1)Selecione o nome do empregado e nome do departamento que cada um est� relacionado.
SELECT e.NomeEmpregado,
	   d.NomeDepartamento
	   FROM Empregado e
INNER JOIN Departamento d ON d.IDDepartamento=e.IDDepartamento;
--2)Exibir o nome do associado e sua cidade, exibir tamb�m associados sem Cidade relacionada.
SELECT a.Nome,
	   c.Nome AS Nome_Cidade
	   FROM Associado a
LEFT JOIN Cidade c ON c.IDCidade=a.IDCidade;
/*3)Lista os estados (UF) e total de cidades, exibir apenas as cidades que n�o possuem associados relacionados.
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
--4)Fa�a uma consulta que liste o nome do associado, o nome da cidade, e uma coluna que indique se a cidade � da regi�o SUL (RS, SC, PR), se for imprimir *** (3 asteriscos), sen�o imprimir nulo.
--5)Liste o nome do empregado, o nome do gerente, e o departamento de cada um.
--6)Fa�a uma c�pia da tabela Empregado e altere o sal�rio de todos os empregados (Empregado) que o departamento fique na localidade de SAO PAULO, fa�a um reajuste de 14,5%
--7)Liste a diferen�a que representar� o reajuste aplicado no item anterior no somat�rio dos sal�rios de todos os empregados.
--8)Liste o departamento com o empregado de maior sal�rio.
--9)Fa�a uma consulta para exibir o nome de cada associado e sua cidade e juntamente com os empregados (nome) e a cidade (localidade) de seu departamento, isto deve ser exibido em uma consulta.
--10)Lista as cidades que tenham associado relacionados. Exibr: Nome e UF apenas