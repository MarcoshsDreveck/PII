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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "fotografos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fotografos.findAll", query = "SELECT f FROM Fotografos f")
    , @NamedQuery(name = "Fotografos.findByIdfotografo", query = "SELECT f FROM Fotografos f WHERE f.idfotografo = :idfotografo")
    , @NamedQuery(name = "Fotografos.findByNome", query = "SELECT f FROM Fotografos f WHERE f.nome = :nome")
    , @NamedQuery(name = "Fotografos.findByCelular", query = "SELECT f FROM Fotografos f WHERE f.celular = :celular")
    , @NamedQuery(name = "Fotografos.findByEmail", query = "SELECT f FROM Fotografos f WHERE f.email = :email")
    , @NamedQuery(name = "Fotografos.findBySenha", query = "SELECT f FROM Fotografos f WHERE f.senha = :senha")
    , @NamedQuery(name = "Fotografos.findByNascimento", query = "SELECT f FROM Fotografos f WHERE f.nascimento = :nascimento")})
public class Fotografos implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fotografosIdfotografo")
    private Collection<Preferencias> preferenciasCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfotografo")
    private Integer idfotografo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "celular")
    private String celular;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nascimento")
    private String nascimento;

    public Fotografos() {
    }

    public Fotografos(Integer idfotografo) {
        this.idfotografo = idfotografo;
    }

    public Fotografos(Integer idfotografo, String nome, String celular, String email, String senha, String nascimento) {
        this.idfotografo = idfotografo;
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.senha = senha;
        this.nascimento = nascimento;
    }

    public Integer getIdfotografo() {
        return idfotografo;
    }

    public void setIdfotografo(Integer idfotografo) {
        this.idfotografo = idfotografo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfotografo != null ? idfotografo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fotografos)) {
            return false;
        }
        Fotografos other = (Fotografos) object;
        if ((this.idfotografo == null && other.idfotografo != null) || (this.idfotografo != null && !this.idfotografo.equals(other.idfotografo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.pii.entity.Fotografos[ idfotografo=" + idfotografo + " ]";
    }

    @XmlTransient
    public Collection<Preferencias> getPreferenciasCollection() {
        return preferenciasCollection;
    }

    public void setPreferenciasCollection(Collection<Preferencias> preferenciasCollection) {
        this.preferenciasCollection = preferenciasCollection;
    }
    
}
