package com.br.crescer.HibernateExercicio.Entity;

import com.br.crescer.HibernateExercicio.Entity.Material;
import com.br.crescer.HibernateExercicio.Entity.Produto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-11T23:31:33")
@StaticMetamodel(ProdutoMaterial.class)
public class ProdutoMaterial_ { 

    public static volatile SingularAttribute<ProdutoMaterial, Produto> produto;
    public static volatile SingularAttribute<ProdutoMaterial, Material> material;
    public static volatile SingularAttribute<ProdutoMaterial, Long> id;
    public static volatile SingularAttribute<ProdutoMaterial, Integer> quantidade;

}