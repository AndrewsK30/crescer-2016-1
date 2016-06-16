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
@Table(name = "PEDIDOITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoItem.findAll", query = "SELECT p FROM PedidoItem p"),
    @NamedQuery(name = "PedidoItem.findByIdpedidoitem", query = "SELECT p FROM PedidoItem p WHERE p.idpedidoitem = :idpedidoitem"),
    @NamedQuery(name = "PedidoItem.findByQuantidade", query = "SELECT p FROM PedidoItem p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "PedidoItem.findByPrecounitario", query = "SELECT p FROM PedidoItem p WHERE p.precounitario = :precounitario"),
    @NamedQuery(name = "PedidoItem.findBySituacao", query = "SELECT p FROM PedidoItem p WHERE p.situacao = :situacao")})
public class PedidoItem implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDPEDIDOITEM")
    private BigDecimal idpedidoitem;
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Basic(optional = false)
    @Column(name = "PRECOUNITARIO")
    private BigDecimal precounitario;
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private Character situacao;
    @JoinColumn(name = "IDPEDIDO", referencedColumnName = "IDPEDIDO")
    @ManyToOne(optional = false)
    private Pedido idpedido;
    @JoinColumn(name = "IDPRODUTO", referencedColumnName = "IDPRODUTO")
    @ManyToOne
    private Produto idproduto;

    public PedidoItem() {
    }

    public PedidoItem(BigDecimal idpedidoitem) {
        this.idpedidoitem = idpedidoitem;
    }

    public PedidoItem(BigDecimal idpedidoitem, BigDecimal quantidade, BigDecimal precounitario, Character situacao) {
        this.idpedidoitem = idpedidoitem;
        this.quantidade = quantidade;
        this.precounitario = precounitario;
        this.situacao = situacao;
    }

    public BigDecimal getIdpedidoitem() {
        return idpedidoitem;
    }

    public void setIdpedidoitem(BigDecimal idpedidoitem) {
        this.idpedidoitem = idpedidoitem;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecounitario() {
        return precounitario;
    }

    public void setPrecounitario(BigDecimal precounitario) {
        this.precounitario = precounitario;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    public Pedido getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Pedido idpedido) {
        this.idpedido = idpedido;
    }

    public Produto getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Produto idproduto) {
        this.idproduto = idproduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpedidoitem != null ? idpedidoitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoItem)) {
            return false;
        }
        PedidoItem other = (PedidoItem) object;
        if ((this.idpedidoitem == null && other.idpedidoitem != null) || (this.idpedidoitem != null && !this.idpedidoitem.equals(other.idpedidoitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.aula4.entity.map.PedidoItem[ idpedidoitem=" + idpedidoitem + " ]";
    }

}
