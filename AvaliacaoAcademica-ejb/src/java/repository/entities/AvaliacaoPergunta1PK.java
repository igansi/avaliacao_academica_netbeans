/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Igansi
 */
@Embeddable
public class AvaliacaoPergunta1PK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_avaliacao")
    private long idAvaliacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pergunta")
    private long idPergunta;

    public AvaliacaoPergunta1PK() {
    }

    public AvaliacaoPergunta1PK(long idAvaliacao, long idPergunta) {
        this.idAvaliacao = idAvaliacao;
        this.idPergunta = idPergunta;
    }

    public long getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(long idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public long getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(long idPergunta) {
        this.idPergunta = idPergunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAvaliacao;
        hash += (int) idPergunta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvaliacaoPergunta1PK)) {
            return false;
        }
        AvaliacaoPergunta1PK other = (AvaliacaoPergunta1PK) object;
        if (this.idAvaliacao != other.idAvaliacao) {
            return false;
        }
        if (this.idPergunta != other.idPergunta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repository.entities.AvaliacaoPergunta1PK[ idAvaliacao=" + idAvaliacao + ", idPergunta=" + idPergunta + " ]";
    }
    
}
