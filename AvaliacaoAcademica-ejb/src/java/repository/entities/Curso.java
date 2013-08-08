/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Igansi
 */
@Entity
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByCodigoCurso", query = "SELECT c FROM Curso c WHERE c.cursoPK.codigoCurso = :codigoCurso"),
    @NamedQuery(name = "Curso.findByIdTurma", query = "SELECT c FROM Curso c WHERE c.cursoPK.idTurma = :idTurma"),
    @NamedQuery(name = "Curso.findByCargaHoraria", query = "SELECT c FROM Curso c WHERE c.cargaHoraria = :cargaHoraria"),
    @NamedQuery(name = "Curso.findByDescricao", query = "SELECT c FROM Curso c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Curso.findByTipo", query = "SELECT c FROM Curso c WHERE c.tipo = :tipo")})
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CursoPK cursoPK;
    @Column(name = "carga_horaria")
    @Temporal(TemporalType.TIME)
    private Date cargaHoraria;
    @Size(max = 255)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "tipo")
    private Integer tipo;
    @JoinTable(name = "curso_modulo", joinColumns = {
        @JoinColumn(name = "curso_codigo", referencedColumnName = "codigo_curso"),
        @JoinColumn(name = "id_turma", referencedColumnName = "id_turma")}, inverseJoinColumns = {
        @JoinColumn(name = "modulo_codigo", referencedColumnName = "codigo_modulo")})
    @ManyToMany
    private Collection<Modulo> moduloCollection;
    @JoinColumn(name = "id_turma", referencedColumnName = "id_turma", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Turma turma;

    public Curso() {
    }

    public Curso(CursoPK cursoPK) {
        this.cursoPK = cursoPK;
    }

    public Curso(long codigoCurso, long idTurma) {
        this.cursoPK = new CursoPK(codigoCurso, idTurma);
    }

    public CursoPK getCursoPK() {
        return cursoPK;
    }

    public void setCursoPK(CursoPK cursoPK) {
        this.cursoPK = cursoPK;
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

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Modulo> getModuloCollection() {
        return moduloCollection;
    }

    public void setModuloCollection(Collection<Modulo> moduloCollection) {
        this.moduloCollection = moduloCollection;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursoPK != null ? cursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.cursoPK == null && other.cursoPK != null) || (this.cursoPK != null && !this.cursoPK.equals(other.cursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "repository.entities.Curso[ cursoPK=" + cursoPK + " ]";
    }
    
}
