package com.br.crescer.HibernateExercicio.Entity;

import java.io.Serializable;
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

/**
 * @author Carlos H. Nonnemacher
 */
@Entity
@Table(name = "PedidoItem")
public class PedidoItem implements Serializable {

    public PedidoItem() {}

    public PedidoItem(Long id, Pedido pedido, Produto produto, int quantidade, double precoUnitario, char situacao) {
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.situacao = situacao;
    }

    public PedidoItem(Pedido pedido, Produto produto, int quantidade, double precoUnitario, char situacao) {
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.situacao = situacao;
    }

    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PEDIDOITEM")
    @SequenceGenerator(name = "SEQ_PEDIDOITEM", sequenceName = "SEQ_PEDIDOITEM", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPEDIDOITEM")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "IDPEDIDO")
    private Pedido pedido;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "IDPRODUTO")
    private Produto produto;
    
    @Basic(optional = false)
    @Column(name = "Quantidade") 
    private int quantidade;
    
    @Basic(optional = false)
    @Column(name = "PrecoUnitario") 
    private double precoUnitario;   
    
    @Basic(optional = false)
    @Column(name = "Situacao",length=1)  
    private char situacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }
}
