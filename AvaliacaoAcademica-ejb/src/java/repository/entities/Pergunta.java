/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * @author Igansi
 */
@Entity
@Table(name = "pergunta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pergunta.findAll", query = "SELECT p FROM Pergunta p"),
    @NamedQuery(name = "Pergunta.findByIdPergunta", query = "SELECT p FROM Pergunta p WHERE p.idPergunta = :idPergunta"),
    @NamedQuery(name = "Pergunta.findByQuestao", query = "SELECT p FROM Pergunta p WHERE p.questao = :questao"),
    @NamedQuery(name = "Pergunta.findByTipo", query = "SELECT p FROM Pergunta p WHERE p.tipo = :tipo")})
public class Pergunta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pergunta")
    private Long idPergunta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "questao")
    private String questao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private int tipo;
    @JoinTable(name = "questionario_pergunta", joinColumns = {
        @JoinColumn(name = "id_pergunta", referencedColumnName = "id_pergunta")}, inverseJoinColumns = {
        @JoinColumn(name = "id_questionario", referencedColumnName = "id_questionario")})
    @ManyToMany
    private Collection<Questionario> questionarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pergunta")
    private Collection<AvaliacaoPergunta1> avaliacaoPergunta1Collection;

    public Pergunta() {
    }

    public Pergunta(Long idPergunta) {
        this.idPergunta = idPergunta;
    }

    public Pergunta(String questao, int tipo) {
        this.questao = questao;
        this.tipo = tipo;
    }

    public Long getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(Long idPergunta) {
        this.idPergunta = idPergunta;
    }

    public String getQuestao() {
        return questao;
    }

    public void setQuestao(String questao) {
        this.questao = questao;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Questionario> getQuestionarioCollection() {
        return questionarioCollection;
    }

    public void setQuestionarioCollection(Collection<Questionario> questionarioCollection) {
        this.questionarioCollection = questionarioCollection;
    }

    @XmlTransient
    public Collection<AvaliacaoPergunta1> getAvaliacaoPergunta1Collection() {
        return avaliacaoPergunta1Collection;
    }

    public void setAvaliacaoPergunta1Collection(Collection<AvaliacaoPergunta1> avaliacaoPergunta1Collection) {
        this.avaliacaoPergunta1Collection = avaliacaoPergunta1Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPergunta != null ? idPergunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pergunta)) {
            return false;
        }
        Pergunta other = (Pergunta) object;
        if ((this.idPergunta == null && other.idPergunta != null) || (this.idPergunta != null && !this.idPergunta.equals(other.idPergunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repository.entities.Pergunta[ idPergunta=" + idPergunta + " ]";
    }
    
}
