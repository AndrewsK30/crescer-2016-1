package com.br.crescer.HibernateExercicio.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * @author Carlos H. Nonnemacher
 */
@Entity
@Table(name = "ProdutoMaterial")
public class ProdutoMaterial implements Serializable {

    public ProdutoMaterial() {}

    public ProdutoMaterial(int quantidade, Produto produto, Material material) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.material = material;
    }

    public ProdutoMaterial(Long id, int quantidade, Produto produto, Material material) {
        this.id = id;
        this.quantidade = quantidade;
        this.produto = produto;
        this.material = material;
    }

    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PRODUTOMATERIAL")
    @SequenceGenerator(name = "SEQ_PRODUTOMATERIAL", sequenceName = "SEQ_PRODUTOMATERIAL", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPRODUTOMATERIAL")
    private Long id;

    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
 
    @ManyToOne(optional = false)
    @JoinColumn(name = "IDPRODUTO")
    private Produto produto;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "IDMATERIAL")
    private Material material;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

}
