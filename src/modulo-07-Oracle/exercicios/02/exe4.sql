
--1)
CREATE PROCEDURE AtulizaValorPed(pIDPedido in integer) AS
BEGIN

UPDATE Pedido
  SET ValorPedido = peditem.Quantidade * prod.PrecoVenda
FROM Pedido ped
 LEFT JOIN PedidoItem peditem ON peditem.IDPedido = ped.IDPedido
 LEFT JOIN Produto prod ON prod.IDProduto = peditem.IDProduto
WHERE ped.IDPedido =  pIDPedido;

END;

--2)
CREATE FUNCTION UltimoPedido(pIDCliente in integer) RETURN DATE AS
vData DATE;
BEGIN
SELECT MAX(DATAPEDIDO)
INTO vData
FROM PEDIDO
WHERE IDCliente = &id;
GROUP BY IDPedido;
RETURN vData;

END: