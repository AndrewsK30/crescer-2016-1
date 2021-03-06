/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.crescer.EntidadesBean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author andrews.silva
 */
@Entity
@Table(name = "MATERIAL")
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m"),
    @NamedQuery(name = "Material.findByIdmaterial", query = "SELECT m FROM Material m WHERE m.idmaterial = :idmaterial"),
    @NamedQuery(name = "Material.findByDescricao", query = "SELECT m FROM Material m WHERE m.descricao = :descricao"),
    @NamedQuery(name = "Material.findByPesoliquido", query = "SELECT m FROM Material m WHERE m.pesoliquido = :pesoliquido"),
    @NamedQuery(name = "Material.findByPrecocusto", query = "SELECT m FROM Material m WHERE m.precocusto = :precocusto")})
public class Material implements Serializable {
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDMATERIAL")
    private BigDecimal idmaterial;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "PESOLIQUIDO")
    private BigDecimal pesoliquido;
    @Basic(optional = false)
    @Column(name = "PRECOCUSTO")
    private BigDecimal precocusto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmaterial")
    private Collection<Produtomaterial> produtomaterialCollection;

    public Material() {
    }

    public Material(BigDecimal idmaterial) {
        this.idmaterial = idmaterial;
    }

    public Material(BigDecimal idmaterial, String descricao, BigDecimal pesoliquido, BigDecimal precocusto) {
        this.idmaterial = idmaterial;
        this.descricao = descricao;
        this.pesoliquido = pesoliquido;
        this.precocusto = precocusto;
    }

    public BigDecimal getIdmaterial() {
        return idmaterial;
    }

    public void setIdmaterial(BigDecimal idmaterial) {
        this.idmaterial = idmaterial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPesoliquido() {
        return pesoliquido;
    }

    public void setPesoliquido(BigDecimal pesoliquido) {
        this.pesoliquido = pesoliquido;
    }

    public BigDecimal getPrecocusto() {
        return precocusto;
    }

    public void setPrecocusto(BigDecimal precocusto) {
        this.precocusto = precocusto;
    }

    public Collection<Produtomaterial> getProdutomaterialCollection() {
        return produtomaterialCollection;
    }

    public void setProdutomaterialCollection(Collection<Produtomaterial> produtomaterialCollection) {
        this.produtomaterialCollection = produtomaterialCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmaterial != null ? idmaterial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.idmaterial == null && other.idmaterial != null) || (this.idmaterial != null && !this.idmaterial.equals(other.idmaterial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.crescer.EntidadesBean.Material[ idmaterial=" + idmaterial + " ]";
    }
    
}
