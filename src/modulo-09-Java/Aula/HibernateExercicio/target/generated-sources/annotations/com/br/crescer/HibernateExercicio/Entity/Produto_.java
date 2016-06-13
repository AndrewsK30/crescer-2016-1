package com.br.crescer.HibernateExercicio.Entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-11T23:31:33")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, Double> precoVenda;
    public static volatile SingularAttribute<Produto, Character> situacao;
    public static volatile SingularAttribute<Produto, Double> precoCusto;
    public static volatile SingularAttribute<Produto, String> nome;
    public static volatile SingularAttribute<Produto, Long> id;
    public static volatile SingularAttribute<Produto, Date> dataCadastro;

}