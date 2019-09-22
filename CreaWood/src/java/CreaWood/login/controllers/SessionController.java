/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreaWood.login.controllers;

import DAO.UsuarioFacade;
import Entities.Permiso;
import Entities.Rol;
import Entities.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author wmoramor
 */

@Named(value = "sessionController")
@SessionScoped
public class SessionController implements Serializable{
    
    @EJB
    private SessionRule sr;
    
    private UsuarioFacade uf;
   
    
    private String contraseña;
    private Long noidentificacion;
    private Rol rolSeleccionado;
    private Usuario persona;
    /**
     * Creates a new instance of SessionController
     */
    public SessionController() {
    }
    
    @PostConstruct
    public void init(){
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Long getNoidentificacion() {
        return noidentificacion;
    }

    public void setNoidentificacion(Long noidentificacion) {
        this.noidentificacion = noidentificacion;
    }

    public Rol getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(Rol rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    public Usuario getUsuario() {
        return persona;
    }

    public UsuarioFacade getUfl() {
        return uf;
    }

    public void setUfl(UsuarioFacade uf) {
        this.uf = uf;
    }
    
    
    
    
    
    
    public String iniciarSesion(){
        String urlDestino = "";
        persona = sr.iniciar(noidentificacion, contraseña);
        if(persona != null){
            rolSeleccionado = sr.validarRol(persona);
            if(rolSeleccionado != null){
                urlDestino = "/app/index_principal.xhtml?faces-redirect=true";
            } else{
                persona = null;
            }
        }
        return urlDestino;
    }
    
    public Usuario usuarioSesion(){
        persona.getNroDoc();
        return persona;
    }
    
    
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        persona = null;
        rolSeleccionado = null;
        contraseña = "";
        noidentificacion = null;
        return "/index.xhtml?faces-redirect=true";
    }
    
    public Boolean inicioSesion(){
        return (persona != null);
    }
    
    
    public Boolean tienePermiso(String urlRecurso){
        if(urlRecurso.endsWith("app/index_principal.xhtml")){
            return true;
        }
        for (Permiso p : rolSeleccionado.getPermisoList()) {
            if(p.getUrl() != null && urlRecurso.endsWith(p.getUrl())){
                return true;
            }
        }
        return false;
    }
    
    
    @PreDestroy
    public void perDestroy(){
        cerrarSesion();
    }
    
    
    
    /*
    public String iniciarSesion(){
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        String url = "";
        
        persona = sr.iniciar(noidentificacion, contraseña);
        if (persona != null) {

                List<Rol> roles = persona.getRoles();

                for (Rol role : roles) {
                    if (role.getIdRol() != null) {
                        rolSeleccionado = sr.validarRol(persona);

                    }
                }

                switch (rolSeleccionado.getIdRol()) {
                    case 1:
                        ec.getSessionMap().put("user", persona);
                        url = "/app/admin/admin.xhtml?faces-redirect=true";
                        break;
                    case 2:
                        ec.getSessionMap().put("user", persona);
                        url = "/app/profesor/profesor.xhtml?faces-redirect=true";
                        break;
                    case 3:
                        ec.getSessionMap().put("user", persona);
                        url = "/app/jugador/jugador.xhtml?faces-redirect=true";
                        break;
                    case 4:
                        ec.getSessionMap().put("user", persona);
                        url = "/app/aspirante/aspirante.xhtml?faces-redirect=true";
                        break;
                    default:
                        url="";

                }

            } 
                return url;

    }
    
    
    
    
    
    
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        persona = null;
        rolSeleccionado = null;
        contraseña = "";
        noidentificacion = null;
        return "/index_1.xhtml?faces-redirect=true";
    }
    
    public Boolean inicioSesion(){
        return (persona != null);
    }
    
    public Boolean tienePermiso(String urlRecurso){
        if(urlRecurso.endsWith("app/*")){
            return true;
        }
        for (Permiso p : rolSeleccionado.getPermisos()) {
            if(p.getUrl() != null && urlRecurso.endsWith(p.getUrl())){
                return true;
            }
        }
        return false;
    }
    
    
    @PreDestroy
    public void perDestroy(){
        cerrarSesion();
    }
    
    */
}
