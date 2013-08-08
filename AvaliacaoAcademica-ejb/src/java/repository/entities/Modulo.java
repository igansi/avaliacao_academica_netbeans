/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Igansi
 */
@Entity
@Table(name = "modulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m"),
    @NamedQuery(name = "Modulo.findByCodigoModulo", query = "SELECT m FROM Modulo m WHERE m.codigoModulo = :codigoModulo"),
    @NamedQuery(name = "Modulo.findByCargaHoraria", query = "SELECT m FROM Modulo m WHERE m.cargaHoraria = :cargaHoraria"),
    @NamedQuery(name = "Modulo.findByDescricao", query = "SELECT m FROM Modulo m WHERE m.descricao = :descricao")})
public class Modulo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_modulo")
    private Long codigoModulo;
    @Column(name = "carga_horaria")
    @Temporal(TemporalType.TIME)
    private Date cargaHoraria;
    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;
    @ManyToMany(mappedBy = "moduloCollection")
    private Collection<Curso> cursoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoModulo")
    private Collection<Avaliacao> avaliacaoCollection;

    public Modulo() {
    }

    public Modulo(Long codigoModulo) {
        this.codigoModulo = codigoModulo;
    }

    public Long getCodigoModulo() {
        return codigoModulo;
    }

    public void setCodigoModulo(Long codigoModulo) {
        this.codigoModulo = codigoModulo;
    }

    public Date getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Date cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    @XmlTransient
    public Collection<Avaliacao> getAvaliacaoCollection() {
        return avaliacaoCollection;
    }

    public void setAvaliacaoCollection(Collection<Avaliacao> avaliacaoCollection) {
        this.avaliacaoCollection = avaliacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoModulo != null ? codigoModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.codigoModulo == null && other.codigoModulo != null) || (this.codigoModulo != null && !this.codigoModulo.equals(other.codigoModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repository.entities.Modulo[ codigoModulo=" + codigoModulo + " ]";
    }
    
}
