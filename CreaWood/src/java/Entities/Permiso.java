/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author wmoramor
 */
@Entity
@Table(name = "permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p")
    , @NamedQuery(name = "Permiso.findByIdPermisos", query = "SELECT p FROM Permiso p WHERE p.idPermisos = :idPermisos")
    , @NamedQuery(name = "Permiso.findByDescripcion", query = "SELECT p FROM Permiso p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Permiso.findByUrl", query = "SELECT p FROM Permiso p WHERE p.url = :url")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPermisos")
    private Integer idPermisos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "url")
    private String url;
    @JoinTable(name = "roleswithpermisos", joinColumns = {
        @JoinColumn(name = "idPermiso", referencedColumnName = "idPermisos")}, inverseJoinColumns = {
        @JoinColumn(name = "idRol", referencedColumnName = "idRol")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Rol> rolList;

    public Permiso() {
    }

    public Permiso(Integer idPermisos) {
        this.idPermisos = idPermisos;
    }

    public Permiso(Integer idPermisos, String descripcion, String url) {
        this.idPermisos = idPermisos;
        this.descripcion = descripcion;
        this.url = url;
    }

    public Integer getIdPermisos() {
        return idPermisos;
    }

    public void setIdPermisos(Integer idPermisos) {
        this.idPermisos = idPermisos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermisos != null ? idPermisos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.idPermisos == null && other.idPermisos != null) || (this.idPermisos != null && !this.idPermisos.equals(other.idPermisos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Permiso[ idPermisos=" + idPermisos + " ]";
    }
    
}
