/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wmoramor
 */
@Entity
@Table(name = "color")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Color.findAll", query = "SELECT c FROM Color c")
    , @NamedQuery(name = "Color.findByIdColor", query = "SELECT c FROM Color c WHERE c.idColor = :idColor")
    , @NamedQuery(name = "Color.findByNombreColor", query = "SELECT c FROM Color c WHERE c.nombreColor = :nombreColor")})
public class Color implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idColor")
    private Integer idColor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre_color")
    private String nombreColor;
    @JoinColumn(name = "Mueble_idMueble", referencedColumnName = "idMueble")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mueble muebleidMueble;

    public Color() {
    }

    public Color(Integer idColor) {
        this.idColor = idColor;
    }

    public Color(Integer idColor, String nombreColor) {
        this.idColor = idColor;
        this.nombreColor = nombreColor;
    }

    public Integer getIdColor() {
        return idColor;
    }

    public void setIdColor(Integer idColor) {
        this.idColor = idColor;
    }

    public String getNombreColor() {
        return nombreColor;
    }

    public void setNombreColor(String nombreColor) {
        this.nombreColor = nombreColor;
    }

    public Mueble getMuebleidMueble() {
        return muebleidMueble;
    }

    public void setMuebleidMueble(Mueble muebleidMueble) {
        this.muebleidMueble = muebleidMueble;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColor != null ? idColor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Color)) {
            return false;
        }
        Color other = (Color) object;
        if ((this.idColor == null && other.idColor != null) || (this.idColor != null && !this.idColor.equals(other.idColor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Color[ idColor=" + idColor + " ]";
    }
    
}
