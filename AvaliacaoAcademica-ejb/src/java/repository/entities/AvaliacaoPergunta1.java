/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Igansi
 */
@Entity
@Table(name = "avaliacao_pergunta1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AvaliacaoPergunta1.findAll", query = "SELECT a FROM AvaliacaoPergunta1 a"),
    @NamedQuery(name = "AvaliacaoPergunta1.findByIdAvaliacao", query = "SELECT a FROM AvaliacaoPergunta1 a WHERE a.avaliacaoPergunta1PK.idAvaliacao = :idAvaliacao"),
    @NamedQuery(name = "AvaliacaoPergunta1.findByIdPergunta", query = "SELECT a FROM AvaliacaoPergunta1 a WHERE a.avaliacaoPergunta1PK.idPergunta = :idPergunta"),
    @NamedQuery(name = "AvaliacaoPergunta1.findByResposta", query = "SELECT a FROM AvaliacaoPergunta1 a WHERE a.resposta = :resposta")})
public class AvaliacaoPergunta1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AvaliacaoPergunta1PK avaliacaoPergunta1PK;
    @Size(max = 255)
    @Column(name = "resposta")
    private String resposta;
    @JoinColumn(name = "id_pergunta", referencedColumnName = "id_pergunta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pergunta pergunta;
    @JoinColumn(name = "id_avaliacao", referencedColumnName = "id_avaliacao", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Avaliacao avaliacao;

    public AvaliacaoPergunta1() {
    }

    public AvaliacaoPergunta1(AvaliacaoPergunta1PK avaliacaoPergunta1PK) {
        this.avaliacaoPergunta1PK = avaliacaoPergunta1PK;
    }

    public AvaliacaoPergunta1(long idAvaliacao, long idPergunta) {
        this.avaliacaoPergunta1PK = new AvaliacaoPergunta1PK(idAvaliacao, idPergunta);
    }

    public AvaliacaoPergunta1PK getAvaliacaoPergunta1PK() {
        return avaliacaoPergunta1PK;
    }

    public void setAvaliacaoPergunta1PK(AvaliacaoPergunta1PK avaliacaoPergunta1PK) {
        this.avaliacaoPergunta1PK = avaliacaoPergunta1PK;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (avaliacaoPergunta1PK != null ? avaliacaoPergunta1PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvaliacaoPergunta1)) {
            return false;
        }
        AvaliacaoPergunta1 other = (AvaliacaoPergunta1) object;
        if ((this.avaliacaoPergunta1PK == null && other.avaliacaoPergunta1PK != null) || (this.avaliacaoPergunta1PK != null && !this.avaliacaoPergunta1PK.equals(other.avaliacaoPergunta1PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repository.entities.AvaliacaoPergunta1[ avaliacaoPergunta1PK=" + avaliacaoPergunta1PK + " ]";
    }
    
}
