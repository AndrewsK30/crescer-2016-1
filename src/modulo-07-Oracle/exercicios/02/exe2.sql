/*DECLARE
vNomeCliente Cliente.Nome%Type;
vNomeCidade Cidade.Nome%Type;

vIDCli integer;

vDataPrimeiraCompra DATE;
vDataUltimaCompra DATE;

vValorTotal NUMBER(12,2);

BEGIN

vIDCli := &p;


SELECT cli.Nome,
       cid.Nome ,
       Min(ped.DataPedido),
       Max(ped.DataPedido),
       Sum(ped.ValorPedido)
INTO vNomeCliente,vNomeCidade,vDataPrimeiraCompra,vDataUltimaCompra,vValorTotal
FROM CLIENTE cli
  LEFT JOIN Cidade cid ON cid.IDCidade = cli.IDCidade
  LEFT JOIN Pedido ped ON ped.IDCliente = cli.IDCliente
WHERE cli.IDCliente = vIDCli
GROUP BY cli.Nome,cid.Nome;


DBMS_OUTPUT.PUT_LINE('Nome:' || vNomeCliente);
DBMS_OUTPUT.PUT_LINE('Cidade:' || vNomeCidade);
DBMS_OUTPUT.PUT_LINE('Primeira compra:' || vDataPrimeiraCompra);
DBMS_OUTPUT.PUT_LINE('Ultima compra:' || vDataUltimaCompra);
DBMS_OUTPUT.PUT_LINE('Valor total dos pedidos:' || vValorTotal);


END;
*/

DECLARE

vExiste integer;
vNome Cidade.Nome%Type := '&Nome';
vUF Cidade.UF%Type := '&UF';

BEGIN

SELECT count(1)
into vExiste
from Cidade
where lower(nome) = lower(vNome)
AND lower(UF) = lower(vUF);

IF vExiste > 0 then
 DBMS_OUTPUT.PUT_LINE('Já há cadastro.');  
ELSE
    INSERT INTO Cidade (Nome, UF)
    VALUES (Initcap(vNome,Upper(vUF)));
    DBMS_OUTPUT.PUT_LINE('Cadastrado com sucesso.');
END IF;

END;