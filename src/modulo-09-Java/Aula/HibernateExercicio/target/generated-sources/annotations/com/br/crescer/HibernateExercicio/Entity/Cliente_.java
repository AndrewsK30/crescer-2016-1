package com.br.crescer.HibernateExercicio.Entity;

import com.br.crescer.HibernateExercicio.Entity.Cidade;
import com.br.crescer.HibernateExercicio.Entity.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-11T23:31:33")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Cidade> cidade;
    public static volatile SingularAttribute<Cliente, Character> situacao;
    public static volatile SingularAttribute<Cliente, String> endereco;
    public static volatile SingularAttribute<Cliente, String> bairro;
    public static volatile SingularAttribute<Cliente, String> nome;
    public static volatile SingularAttribute<Cliente, Long> id;
    public static volatile ListAttribute<Cliente, Pedido> pedidos;
    public static volatile SingularAttribute<Cliente, String> razaoSocial;
    public static volatile SingularAttribute<Cliente, Integer> cep;

}