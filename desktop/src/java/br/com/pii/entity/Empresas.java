/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pii.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juliana
 */
@Entity
@Table(name = "empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresas.findAll", query = "SELECT e FROM Empresas e")
    , @NamedQuery(name = "Empresas.findByIdempresas", query = "SELECT e FROM Empresas e WHERE e.idempresas = :idempresas")
    , @NamedQuery(name = "Empresas.findByCnpj", query = "SELECT e FROM Empresas e WHERE e.cnpj = :cnpj")
    , @NamedQuery(name = "Empresas.findByEndereco", query = "SELECT e FROM Empresas e WHERE e.endereco = :endereco")
    , @NamedQuery(name = "Empresas.findByTelefone", query = "SELECT e FROM Empresas e WHERE e.telefone = :telefone")
    , @NamedQuery(name = "Empresas.findByRedesocial", query = "SELECT e FROM Empresas e WHERE e.redesocial = :redesocial")
    , @NamedQuery(name = "Empresas.findBySite", query = "SELECT e FROM Empresas e WHERE e.site = :site")
    , @NamedQuery(name = "Empresas.findByNome", query = "SELECT e FROM Empresas e WHERE e.nome = :nome")
    , @NamedQuery(name = "Empresas.findByEmail", query = "SELECT e FROM Empresas e WHERE e.email = :email")
    , @NamedQuery(name = "Empresas.findBySenha", query = "SELECT e FROM Empresas e WHERE e.senha = :senha")
    , @NamedQuery(name = "Empresas.findByRazaosocial", query = "SELECT e FROM Empresas e WHERE e.razaosocial = :razaosocial")})
public class Empresas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idempresas")
    private Integer idempresas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cnpj")
    private String cnpj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "redesocial")
    private String redesocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "site")
    private String site;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
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
    @Column(name = "razaosocial")
    private String razaosocial;

    public Empresas() {
    }

    public Empresas(Integer idempresas) {
        this.idempresas = idempresas;
    }

    public Empresas(Integer idempresas, String cnpj, String endereco, String telefone, String redesocial, String site, String nome, String email, String senha, String razaosocial) {
        this.idempresas = idempresas;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.redesocial = redesocial;
        this.site = site;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.razaosocial = razaosocial;
    }

    public Integer getIdempresas() {
        return idempresas;
    }

    public void setIdempresas(Integer idempresas) {
        this.idempresas = idempresas;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRedesocial() {
        return redesocial;
    }

    public void setRedesocial(String redesocial) {
        this.redesocial = redesocial;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idempresas != null ? idempresas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresas)) {
            return false;
        }
        Empresas other = (Empresas) object;
        if ((this.idempresas == null && other.idempresas != null) || (this.idempresas != null && !this.idempresas.equals(other.idempresas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.PII.entity.Empresas[ idempresas=" + idempresas + " ]";
    }
    
}
