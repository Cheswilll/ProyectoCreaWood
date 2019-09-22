/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author wmoramor
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByNroDoc", query = "SELECT u FROM Usuario u WHERE u.nroDoc = :nroDoc")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByApellido", query = "SELECT u FROM Usuario u WHERE u.apellido = :apellido")
    , @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena")
    , @NamedQuery(name = "Usuario.findByDireccion", query = "SELECT u FROM Usuario u WHERE u.direccion = :direccion")
    , @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono")
    , @NamedQuery(name = "Usuario.findByGenero", query = "SELECT u FROM Usuario u WHERE u.genero = :genero")
    , @NamedQuery(name = "Usuario.findByFechaCreacion", query = "SELECT u FROM Usuario u WHERE u.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Usuario.findByFechaActualizacion", query = "SELECT u FROM Usuario u WHERE u.fechaActualizacion = :fechaActualizacion")
    , @NamedQuery(name = "Usuario.findLogin", query = "SELECT u FROM Usuario u WHERE u.nroDoc = :noIdentificacion AND u.contrasena = :contraseña")
    , @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_doc")
    private Long nroDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "contrasena")
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "genero")
    private int genero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @Column(name = "estado")
    private Integer estado;
    @ManyToMany(mappedBy = "usuarioList", fetch = FetchType.LAZY)
    private List<Rol> rolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioidUsuario", fetch = FetchType.LAZY)
    private List<Pedido> pedidoList;
    @JoinColumn(name = "Ciudad_idCiudad", referencedColumnName = "idCiudad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ciudad ciudadidCiudad;
    @JoinColumn(name = "tipo_doc", referencedColumnName = "idTipoIdentificacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoIdentificacion tipoDoc;

    public Usuario() {
    }

    public Usuario(Long nroDoc) {
        this.nroDoc = nroDoc;
    }

    public Usuario(Long nroDoc, String nombre, String apellido, String correo, String contrasena, String direccion, String telefono, int genero, Date fechaCreacion, Date fechaActualizacion) {
        this.nroDoc = nroDoc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.telefono = telefono;
        this.genero = genero;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Long getNroDoc() {
        return nroDoc;
    }

    public void setNroDoc(Long nroDoc) {
        this.nroDoc = nroDoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    public Ciudad getCiudadidCiudad() {
        return ciudadidCiudad;
    }

    public void setCiudadidCiudad(Ciudad ciudadidCiudad) {
        this.ciudadidCiudad = ciudadidCiudad;
    }

    public TipoIdentificacion getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(TipoIdentificacion tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroDoc != null ? nroDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.nroDoc == null && other.nroDoc != null) || (this.nroDoc != null && !this.nroDoc.equals(other.nroDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Usuario[ nroDoc=" + nroDoc + " ]";
    }
    
}
