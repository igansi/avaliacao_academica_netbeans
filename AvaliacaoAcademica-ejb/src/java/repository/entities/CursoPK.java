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
public class CursoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_curso")
    private long codigoCurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_turma")
    private long idTurma;

    public CursoPK() {
    }

    public CursoPK(long codigoCurso, long idTurma) {
        this.codigoCurso = codigoCurso;
        this.idTurma = idTurma;
    }

    public long getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(long codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(long idTurma) {
        this.idTurma = idTurma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoCurso;
        hash += (int) idTurma;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoPK)) {
            return false;
        }
        CursoPK other = (CursoPK) object;
        if (this.codigoCurso != other.codigoCurso) {
            return false;
        }
        if (this.idTurma != other.idTurma) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repository.entities.CursoPK[ codigoCurso=" + codigoCurso + ", idTurma=" + idTurma + " ]";
    }
    
}
