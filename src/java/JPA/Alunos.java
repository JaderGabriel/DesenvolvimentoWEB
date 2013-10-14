/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JPA;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jader
 */
@Entity
@Table(name = "alunos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alunos.findAll", query = "SELECT a FROM Alunos a"),
    @NamedQuery(name = "Alunos.findByMatricula", query = "SELECT a FROM Alunos a WHERE a.matricula = :matricula"),
    @NamedQuery(name = "Alunos.findByNome", query = "SELECT a FROM Alunos a WHERE a.nome = :nome"),
    @NamedQuery(name = "Alunos.findByNota", query = "SELECT a FROM Alunos a WHERE a.nota = :nota")})
public class Alunos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "matricula")
    private Integer matricula;
    @Size(max = 50)
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Nota")
    private Integer nota;

    public Alunos() {
    }
    
    public Alunos(Integer matricula) {
        this.matricula = matricula;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricula != null ? matricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alunos)) {
            return false;
        }
        Alunos other = (Alunos) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Alunos[ matricula=" + matricula + " ]";
    }
    
}
