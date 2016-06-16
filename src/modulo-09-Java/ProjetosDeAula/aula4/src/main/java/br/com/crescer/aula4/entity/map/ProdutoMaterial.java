package br.com.crescer.aula4.entity.map;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Carlos H. Nonnemacher
 */
@Entity
@Table(name = "PRODUTOMATERIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdutoMaterial.findAll", query = "SELECT p FROM ProdutoMaterial p"),
    @NamedQuery(name = "ProdutoMaterial.findByIdprodutomaterial", query = "SELECT p FROM ProdutoMaterial p WHERE p.idprodutomaterial = :idprodutomaterial"),
    @NamedQuery(name = "ProdutoMaterial.findByQuantidade", query = "SELECT p FROM ProdutoMaterial p WHERE p.quantidade = :quantidade")})
public class ProdutoMaterial implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "IDPRODUTOMATERIAL")
    private Long id;

    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;

    @JoinColumn(name = "IDMATERIAL", referencedColumnName = "IDMATERIAL")
    @ManyToOne(optional = false)
    private Material material;

    @JoinColumn(name = "IDPRODUTO", referencedColumnName = "IDPRODUTO")
    @ManyToOne(optional = false)
    private Produto produto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
