package com.br.crescer.HibernateExercicio.Entity;

import com.br.crescer.HibernateExercicio.Entity.Pedido;
import com.br.crescer.HibernateExercicio.Entity.Produto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-11T23:31:33")
@StaticMetamodel(PedidoItem.class)
public class PedidoItem_ { 

    public static volatile SingularAttribute<PedidoItem, Double> precoUnitario;
    public static volatile SingularAttribute<PedidoItem, Character> situacao;
    public static volatile SingularAttribute<PedidoItem, Produto> produto;
    public static volatile SingularAttribute<PedidoItem, Pedido> pedido;
    public static volatile SingularAttribute<PedidoItem, Long> id;
    public static volatile SingularAttribute<PedidoItem, Integer> quantidade;

}