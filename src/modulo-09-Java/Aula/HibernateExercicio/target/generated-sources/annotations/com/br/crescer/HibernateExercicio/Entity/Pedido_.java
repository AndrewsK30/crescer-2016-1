package com.br.crescer.HibernateExercicio.Entity;

import com.br.crescer.HibernateExercicio.Entity.Cliente;
import com.br.crescer.HibernateExercicio.Entity.PedidoItem;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-11T23:31:33")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile ListAttribute<Pedido, PedidoItem> pedidoItem;
    public static volatile SingularAttribute<Pedido, Cliente> cliente;
    public static volatile SingularAttribute<Pedido, Character> situacao;
    public static volatile SingularAttribute<Pedido, Date> dataEntrega;
    public static volatile SingularAttribute<Pedido, Double> valor;
    public static volatile SingularAttribute<Pedido, Date> dataPedido;
    public static volatile SingularAttribute<Pedido, Long> id;

}