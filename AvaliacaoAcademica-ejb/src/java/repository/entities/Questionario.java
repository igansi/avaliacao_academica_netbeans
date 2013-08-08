/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Igansi
 */
@Entity
@Table(name = "questionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questionario.findAll", query = "SELECT q FROM Questionario q"),
    @NamedQuery(name = "Questionario.findByIdQuestionario", query = "SELECT q FROM Questionario q WHERE q.idQuestionario = :idQuestionario"),
    @NamedQuery(name = "Questionario.findByTitulo", query = "SELECT q FROM Questionario q WHERE q.titulo = :titulo")})
public class Questionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_questionario")
    private Long idQuestionario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "titulo")
    private String titulo;
    @ManyToMany(mappedBy = "questionarioCollection")
    private Collection<Pergunta> perguntaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idQuestionario")
    private Collection<Avaliacao> avaliacaoCollection;

    public Questionario() {
    }

    public Questionario(Long idQuestionario) {
        this.idQuestionario = idQuestionario;
    }

    public Questionario(String titulo, Collection<Pergunta> perguntaCollection) {
        this.titulo = titulo;
        this.perguntaCollection = perguntaCollection;
    }

    public Long getIdQuestionario() {
        return idQuestionario;
    }

    public void setIdQuestionario(Long idQuestionario) {
        this.idQuestionario = idQuestionario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlTransient
    public Collection<Pergunta> getPerguntaCollection() {
        return perguntaCollection;
    }

    public void setPerguntaCollection(Collection<Pergunta> perguntaCollection) {
        this.perguntaCollection = perguntaCollection;
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
        hash += (idQuestionario != null ? idQuestionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questionario)) {
            return false;
        }
        Questionario other = (Questionario) object;
        if ((this.idQuestionario == null && other.idQuestionario != null) || (this.idQuestionario != null && !this.idQuestionario.equals(other.idQuestionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repository.entities.Questionario[ idQuestionario=" + idQuestionario + " ]";
    }
    
}
