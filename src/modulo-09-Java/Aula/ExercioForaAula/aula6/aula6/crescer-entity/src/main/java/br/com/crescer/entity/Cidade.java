package br.com.crescer.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * @author Carlos H. Nonnemacher
 */
@Entity
@Table(name = "CIDADE")
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT p FROM Cidade p"),
    @NamedQuery(name = "Cidade.findById", query = "SELECT p FROM Cidade p WHERE p.id = :id"),
    @NamedQuery(name = "Cidade.findByNome", query = "SELECT p FROM Cidade p WHERE p.nome = :nome")})
public class Cidade extends SerializableID<Long> {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CIDADE")
    @SequenceGenerator(name = "SEQ_CIDADE", sequenceName = "SEQ_CIDADE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDCIDADE")
    private Long id;

    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    
    @Basic(optional = false)
    @Column(name = "UF")
    private String UF;
    
    @Override
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

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    } 
}
