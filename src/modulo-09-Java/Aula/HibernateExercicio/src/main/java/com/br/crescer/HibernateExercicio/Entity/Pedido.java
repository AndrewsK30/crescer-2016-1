package com.br.crescer.HibernateExercicio.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Carlos H. Nonnemacher
 */
@Entity
@Table(name = "Pedido")
public class Pedido implements Serializable {

    public Pedido() {}

    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PEDIDO")
    @SequenceGenerator(name = "SEQ_PEDIDO", sequenceName = "SEQ_PEDIDO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPEDIDO")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "IDCliente")
    private Cliente cliente;

    @Temporal(TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "DataPedido")
    private Date dataPedido;
    
    @Temporal(TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "DataEntrega")
    private Date dataEntrega;
    
    @Basic(optional = false)
    @Column(name = "ValorPedido") 
    private double valor;
    
    @Basic(optional = false)
    @Column(name = "Situacao",length=1)  
    private char situacao;
       
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }
}
