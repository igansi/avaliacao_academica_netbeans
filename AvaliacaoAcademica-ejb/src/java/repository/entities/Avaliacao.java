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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Igansi
 */
@Entity
@Table(name = "avaliacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliacao.findAll", query = "SELECT a FROM Avaliacao a"),
    @NamedQuery(name = "Avaliacao.findByIdAvaliacao", query = "SELECT a FROM Avaliacao a WHERE a.idAvaliacao = :idAvaliacao"),
    @NamedQuery(name = "Avaliacao.findByDataFim", query = "SELECT a FROM Avaliacao a WHERE a.dataFim = :dataFim"),
    @NamedQuery(name = "Avaliacao.findByDataInicio", query = "SELECT a FROM Avaliacao a WHERE a.dataInicio = :dataInicio"),
    @NamedQuery(name = "Avaliacao.findByStatus", query = "SELECT a FROM Avaliacao a WHERE a.status = :status")})
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_avaliacao")
    private Long idAvaliacao;
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Column(name = "status")
    private Integer status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avaliacao")
    private Collection<AvaliacaoPergunta1> avaliacaoPergunta1Collection;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "id_questionario", referencedColumnName = "id_questionario")
    @ManyToOne(optional = false)
    private Questionario idQuestionario;
    @JoinColumn(name = "codigo_modulo", referencedColumnName = "codigo_modulo")
    @ManyToOne(optional = false)
    private Modulo codigoModulo;

    public Avaliacao() {
    }

    public Avaliacao(Long idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Long getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Long idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<AvaliacaoPergunta1> getAvaliacaoPergunta1Collection() {
        return avaliacaoPergunta1Collection;
    }

    public void setAvaliacaoPergunta1Collection(Collection<AvaliacaoPergunta1> avaliacaoPergunta1Collection) {
        this.avaliacaoPergunta1Collection = avaliacaoPergunta1Collection;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Questionario getIdQuestionario() {
        return idQuestionario;
    }

    public void setIdQuestionario(Questionario idQuestionario) {
        this.idQuestionario = idQuestionario;
    }

    public Modulo getCodigoModulo() {
        return codigoModulo;
    }

    public void setCodigoModulo(Modulo codigoModulo) {
        this.codigoModulo = codigoModulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAvaliacao != null ? idAvaliacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.idAvaliacao == null && other.idAvaliacao != null) || (this.idAvaliacao != null && !this.idAvaliacao.equals(other.idAvaliacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repository.entities.Avaliacao[ idAvaliacao=" + idAvaliacao + " ]";
    }
    
}
