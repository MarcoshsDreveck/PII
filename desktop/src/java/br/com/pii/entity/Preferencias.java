/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pii.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juliana
 */
@Entity
@Table(name = "preferencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preferencias.findAll", query = "SELECT p FROM Preferencias p")
    , @NamedQuery(name = "Preferencias.findByIdpreferencia", query = "SELECT p FROM Preferencias p WHERE p.idpreferencia = :idpreferencia")
    , @NamedQuery(name = "Preferencias.findByDescricao", query = "SELECT p FROM Preferencias p WHERE p.descricao = :descricao")})
public class Preferencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpreferencia")
    private Integer idpreferencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "fotografos_idfotografo", referencedColumnName = "idfotografo")
    @ManyToOne(optional = false)
    private Fotografos fotografosIdfotografo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preferenciasIdpreferencia")
    private Collection<Preferencias> preferenciasCollection;
    @JoinColumn(name = "preferencias_idpreferencia", referencedColumnName = "idpreferencia")
    @ManyToOne(optional = false)
    private Preferencias preferenciasIdpreferencia;

    public Preferencias() {
    }

    public Preferencias(Integer idpreferencia) {
        this.idpreferencia = idpreferencia;
    }

    public Preferencias(Integer idpreferencia, String descricao) {
        this.idpreferencia = idpreferencia;
        this.descricao = descricao;
    }

    public Integer getIdpreferencia() {
        return idpreferencia;
    }

    public void setIdpreferencia(Integer idpreferencia) {
        this.idpreferencia = idpreferencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Fotografos getFotografosIdfotografo() {
        return fotografosIdfotografo;
    }

    public void setFotografosIdfotografo(Fotografos fotografosIdfotografo) {
        this.fotografosIdfotografo = fotografosIdfotografo;
    }

    @XmlTransient
    public Collection<Preferencias> getPreferenciasCollection() {
        return preferenciasCollection;
    }

    public void setPreferenciasCollection(Collection<Preferencias> preferenciasCollection) {
        this.preferenciasCollection = preferenciasCollection;
    }

    public Preferencias getPreferenciasIdpreferencia() {
        return preferenciasIdpreferencia;
    }

    public void setPreferenciasIdpreferencia(Preferencias preferenciasIdpreferencia) {
        this.preferenciasIdpreferencia = preferenciasIdpreferencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpreferencia != null ? idpreferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preferencias)) {
            return false;
        }
        Preferencias other = (Preferencias) object;
        if ((this.idpreferencia == null && other.idpreferencia != null) || (this.idpreferencia != null && !this.idpreferencia.equals(other.idpreferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.pii.entity.Preferencias[ idpreferencia=" + idpreferencia + " ]";
    }
    
}
