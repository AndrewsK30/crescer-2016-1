/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.crescer.aula4.entity;

/**
 *
 * @author andrews.silva
 */
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PESSOA2")
public class Pessoa implements Serializable {

    @Id // Identifica a PK
    @Basic(optional = false)
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PESSOA")
    @SequenceGenerator(name = "SEQ_PESSOA", sequenceName = "SEQ_PESSOA",allocationSize = 1)
    @Column(name = "IDPESSOA")
    private Long idPessoa;

    @Basic(optional = false)
    @Column(name = "NMPESSOA")
    private String nmPessoa;
    Pessoa (){}
    
    public Pessoa(String pessoa) {
        this.nmPessoa = pessoa;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNmPessoa() {
        return nmPessoa;
    }

    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }
    
}