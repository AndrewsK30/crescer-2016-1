package com.br.crescer.HibernateExercicio.Entity;

import java.io.Serializable;
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

/**
 * @author Carlos H. Nonnemacher
 */
@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {

    public Cliente() {}

    public Cliente(Long id, String nome, String razaoSocial, String endereco, String bairro, Cidade cidade, int cep, char situacao) {
        this.id = id;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.situacao = situacao;
    }

    public Cliente(String nome, String razaoSocial, String endereco, String bairro, Cidade cidade, int cep, char situacao) {
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.situacao = situacao;
    }

    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CLIENTE")
    @SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = "SEQ_CLIENTE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDCLIENTE")
    private Long id;

    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    
    @Basic(optional = false)
    @Column(name = "RazaoSocial")
    private String razaoSocial;
    
    @Basic(optional = false)
    @Column(name = "Endereco")
    private String endereco;
    
    @Basic(optional = false)
    @Column(name = "Bairro")
    private String bairro;

    @ManyToOne(optional = false)
    @JoinColumn(name = "IDCidade")
    private Cidade cidade;
    
    @Basic(optional = false)
    @Column(name = "CEP") 
    private int cep;
    
    @Basic(optional = false)
    @Column(name = "Situacao",length=1)  
    private char situacao;
    


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

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }
}
