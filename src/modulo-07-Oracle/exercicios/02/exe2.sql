DECLARE
vNomeCliente CHAR(60);
vNomeCidade CHAR(60);
vIDCli integer;

vDataPrimeiraCompra DATE;
vDataUltimaCompra DATE;

vValorTotal NUMBER(12,2);

BEGIN

vIDCli := &p;


SELECT cli.Nome,
       cid.Nome       
INTO vNomeCliente,vNomeCidade
FROM CLIENTE cli
  LEFT JOIN Cidade cid ON cid.IDCidade = cli.IDCidade
WHERE cli.IDCliente = vIDCli;


SELECT DATAPEDIDO
into vDataPrimeiraCompra
        FROM PEDIDO
        WHERE IDCLiente = vIDCli AND rownum <= 1
        ORDER BY IDPedido DESC;
        
        
SELECT DATAPEDIDO
into vDataUltimaCompra
        FROM PEDIDO
        WHERE IDCLiente = vIDCli AND rownum <= 1
        ORDER BY IDPedido ASC;
        
SELECT SUM(ValorPedido)
into vValorTotal
FROM Pedido
WHERE IDCLiente = vIDCli
ORDER BY IDPedido ;       

DBMS_OUTPUT.PUT_LINE('Nome:' || vNomeCliente);
DBMS_OUTPUT.PUT_LINE('Cidade:' || vNomeCidade);
DBMS_OUTPUT.PUT_LINE('Primeira compra:' || vDataPrimeiraCompra);
DBMS_OUTPUT.PUT_LINE('Ultima compra:' || vDataUltimaCompra);
DBMS_OUTPUT.PUT_LINE('Valor total dos pedidos:' || vValorTotal);



END;