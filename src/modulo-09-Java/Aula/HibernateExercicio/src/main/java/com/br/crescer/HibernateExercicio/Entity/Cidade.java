package com.br.crescer.HibernateExercicio.Entity;

import java.io.Serializable;
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
/**
 * @author Carlos H. Nonnemacher
 */
@Entity
@Table(name = "Cidade")
public class Cidade implements Serializable {

    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CIDADE")
    @SequenceGenerator(name = "SEQ_CIDADE", sequenceName = "SEQ_CIDADE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDCIDADE")
    private Long id;

    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    
    @Basic(optional = false)
    @Column(name = "UF")
    private String uF;
    
    public Cidade(){}
    
    public Cidade(String nome, String uF){
        this.nome = nome;
        this.uF = uF;
    }
    
    public Cidade(Long id, String nome, String uF){
        this.id = id;
        this.nome = nome;
        this.uF = uF;
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

    public String getUF() {
        return uF;
    }

    public void setUF(String uF) {
        this.uF = uF;
    }
}
