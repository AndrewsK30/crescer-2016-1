/*1-Liste os clientes e suas respectivas cidades. 
IDCliente, Nome, Nome da Cidade e UF. */

SELECT F.IDCLIENTE,
       F.NOME,
       C.NOME AS CIDADE,
       C.UF
FROM CLIENTE  F  
  LEFT JOIN CIDADE C ON (C.IDCIDADE = F.IDCIDADE);

/*2-Liste o total de pedidos realizados no mês de maio de 2016. 
(Dica: verifique o uso do TO_DATE para conversão de String em Date). */
SELECT COUNT(IDPEDIDO) FROM PEDIDO 
WHERE EXTRACT(month FROM DATAPEDIDO)= 5
AND EXTRACT(year FROM DATAPEDIDO)= 2016;


/*3-Liste todos os clientes que tenham o LTDA no nome ou razao social. */

SELECT * FROM CLIENTE
WHERE  lower(CLIENTE.NOME) LIKE '%ltda%'
OR lower(CLIENTE.RAZAOSOCIAL) LIKE '%ltda%';
/*4-Crie (insira) um novo registro na tabela de Produto, com as seguintes informações: 
Nome: Galocha Maragato 
Preço de custo: 35.67 Preço de venda: 77.95 Situação: A */
--SELECT MAX(IDPRODUTO) FROM PRODUTO;
--CREATE SEQUENCE SQPRODUTO START WITH 8001;
INSERT INTO PRODUTO (IDPRODUTO,NOME,PRECOCUSTO,PRECOVENDA,SITUACAO) VALUES (8001,'Galocha Maragato',35.67,77.95,'A');

/*5-Identifique e liste os produtos que não tiveram nenhum pedido, considere os relacionamentos 
no modelo de dados, pois não há relacionamento direto entre Produto e Pedido (será preciso relacionar PedidoItem). 
Obs.: o produto criado anteriormente deverá ser listado (apenas este) */

SELECT IDPRODUTO,
        NOME
FROM PRODUTO
WHERE  NOT EXISTS(SELECT 1
                  FROM PEDIDOITEM
                  WHERE PEDIDOITEM.IDPRODUTO = PRODUTO.IDPRODUTO);


/*7-Faça uma consulta que receba um parâmetro sendo o IDProduto e liste a quantidade de itens na tabela PedidoItem com este IDProduto foram vendidos no último ano (desde janeiro/2016). 
Utilizando de funções de agrupamento (aggregation function), faça uma consulta que liste agrupando por ano e mês a quantidade de pedidos comprados, a quantidade de produtos distintos comprados, o valor total dos pedidos, o menor valor de um pedido, o maior valor de um pedido e valor médio de um pedido. 
(Dica: a função TO_CHAR permite converter Dates em String considerando formatos específicos). */

select sum(nvl(quantidade,0))
from PedidoItem
  inner join Pedido on Pedido.IDPedido = PedidoItem.IDPedido
where PedidoItem.IDProduto = :pIDProduto
and Pedido.DataPedido >= to_date('01/2016','mm/yyyy');

--8)

select  TO_CHAR(ped.DataPedido,'mm/yyyy') ANO_MES,
COUNT(distinct item.IDProduto) as Produtos_Distintos,
SUM(ped.ValorPedido) as Valor_Pedidos,
MIN(ped.ValorPedido) as Menor_Pedido,
MAX(ped.ValorPedido) as Maior_Pedido,
round(AVG(ped.ValorPedido),2) as Media_Pedidos,
COUNT (distinct ped.IDPedido) as Total_Pedidos
FROM Pedido ped
  inner join PedidoItem item on item.IDPedido = ped.IDPedido
GROUP BY TO_CHAR(ped.DataPedido,'mm/yyyy')
ORDER BY 1;

