/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author wmoramor
 */
@Entity
@Table(name = "mueble")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mueble.findAll", query = "SELECT m FROM Mueble m")
    , @NamedQuery(name = "Mueble.findByIdMueble", query = "SELECT m FROM Mueble m WHERE m.idMueble = :idMueble")
    , @NamedQuery(name = "Mueble.findByValor", query = "SELECT m FROM Mueble m WHERE m.valor = :valor")})
public class Mueble implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMueble")
    private Integer idMueble;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "muebleidMueble", fetch = FetchType.LAZY)
    private List<Color> colorList;
    @JoinColumn(name = "Tipo_idTipo", referencedColumnName = "idTipo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipo tipoidTipo;

    public Mueble() {
    }

    public Mueble(Integer idMueble) {
        this.idMueble = idMueble;
    }

    public Mueble(Integer idMueble, double valor) {
        this.idMueble = idMueble;
        this.valor = valor;
    }

    public Integer getIdMueble() {
        return idMueble;
    }

    public void setIdMueble(Integer idMueble) {
        this.idMueble = idMueble;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @XmlTransient
    public List<Color> getColorList() {
        return colorList;
    }

    public void setColorList(List<Color> colorList) {
        this.colorList = colorList;
    }

    public Tipo getTipoidTipo() {
        return tipoidTipo;
    }

    public void setTipoidTipo(Tipo tipoidTipo) {
        this.tipoidTipo = tipoidTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMueble != null ? idMueble.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mueble)) {
            return false;
        }
        Mueble other = (Mueble) object;
        if ((this.idMueble == null && other.idMueble != null) || (this.idMueble != null && !this.idMueble.equals(other.idMueble))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Mueble[ idMueble=" + idMueble + " ]";
    }
    
}
