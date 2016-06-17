package br.com.crescer.aula4.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Carlos H. Nonnemacher
 */
@Entity
@Table(name = "PUBLICAO")
public class Publicacao implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PUBLICAO")
    @SequenceGenerator(name = "SEQ_PUBLICAO", sequenceName = "SEQ_PUBLICAO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_PUBLICACAO")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @Basic(optional = false)
    @Column(name = "DS_CONT_PUBLICACAO", length = 2000)
    private String conteudo;

    @Temporal(TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "DT_PUBLICAO")
    private Date data;

}
