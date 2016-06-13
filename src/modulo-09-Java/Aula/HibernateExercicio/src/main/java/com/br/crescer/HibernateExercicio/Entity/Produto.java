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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * @author Carlos H. Nonnemacher
 */
@Entity
@Table(name = "Produto")
public class Produto implements Serializable {    

    public Produto() {}
    
    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PRODUTO")
    @SequenceGenerator(name = "SEQ_PRODUTO", sequenceName = "SEQ_PRODUTO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPRODUTO")
    private Long id;

    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    
    @Basic(optional = false)
    @Column(name = "PrecoVenda")
    private double precoVenda;
    
    @Basic(optional = false)
    @Column(name = "PrecoCusto")
    private double precoCusto;
    
    @Temporal(TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "DataCadastro")
    private Date dataCadastro;    
    
    @Basic(optional = false)
    @Column(name = "Situacao",length=1)  
    private char situacao;  

    
    public Produto(String nome, double precoVenda, double precoCusto, Date dataCadastro, char situacao) {
        this.nome = nome;
        this.precoVenda = precoVenda;
        this.precoCusto = precoCusto;
        this.dataCadastro = dataCadastro;
        this.situacao = situacao;
    }
    
    public Produto(Long id, String nome, double precoVenda, double precoCusto, Date dataCadastro, char situacao) {
        this.id = id;
        this.nome = nome;
        this.precoVenda = precoVenda;
        this.precoCusto = precoCusto;
        this.dataCadastro = dataCadastro;
        this.situacao = situacao;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }
    

}
