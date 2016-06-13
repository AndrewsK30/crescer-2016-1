package com.br.crescer.HibernateExercicio.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
 * @author Carlos H. Nonnemacher
 */
@Entity
@Table(name = "Material")
public class Material implements Serializable {

    public Material(String descricao, double pesoLiquido, double precoCusto) {
        this.descricao = descricao;
        this.pesoLiquido = pesoLiquido;
        this.precoCusto = precoCusto;
    }

    public Material(Long id, String descricao, double pesoLiquido, double precoCusto) {
        this.id = id;
        this.descricao = descricao;
        this.pesoLiquido = pesoLiquido;
        this.precoCusto = precoCusto;
    }

    public Material() {}

    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_MATERIAl")
    @SequenceGenerator(name = "SEQ_MATERIAl", sequenceName = "SEQ_MATERIAl", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDMATERIAL")
    private Long id;

    @Basic(optional = false)
    @Column(name = "Descricao")
    private String descricao;
    
    @Basic(optional = false)
    @Column(name = "PesoLiquido")
    private double pesoLiquido;
    
    @Basic(optional = false)
    @Column(name = "PrecoCusto")
    private double precoCusto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(double pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

}
