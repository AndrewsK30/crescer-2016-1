/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.crescer.aula4.entity;

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
 *
 * @author andrews.silva
 */
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    @Id // Identifica a PK
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_Usuario")
    @SequenceGenerator(name = "SEQ_Usuario", sequenceName = "SEQ_Usuario",allocationSize = 1)
    @Column(name = "IDUsuario")
    private Long idUsuario;

    @Basic(optional = false)
    @Column(name = "NmUsuario")
    private String nmUsuario;
  
    @OneToMany(mappedBy="usuario")
    private List<Amigo> amigos;
    
    Usuario (){}
    
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public List<Amigo> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Amigo> amigos) {
        this.amigos = amigos;
    }
  
}
