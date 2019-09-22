/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreaWood.login.controllers;

import CreaWood.util.MessageUtil;
import DAO.UsuarioFacadeLocal;
import Entities.Rol;
import Entities.Usuario;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author wmoramor
 */
@Stateless
public class SessionRule {
    
    @EJB
    private UsuarioFacadeLocal ufl;

    public Usuario iniciar(Long noidentificacion, String contraseña) {
        Usuario p = null;
        if (noidentificacion != null && noidentificacion > 0
                && contraseña != null && contraseña.length() > 0) {
            p = ufl.login(noidentificacion, contraseña);
            if (p != null) {
                if (p.getEstado() == 2) {
                    p = null;
                    MessageUtil.enviarMensajeErrorGlobal(
                            "Usuario bloqueado",
                            "Contacte al administrador par que solucione el incoveniente.");

                }
            } else {
                MessageUtil.enviarMensajeErrorGlobal(
                        "Datos incorrectos",
                        "Documento y/o clave invalidos");
            }
        } else {
            MessageUtil.enviarMensajeErrorGlobal(
                    "Datos obligatorios",
                    "Documento y/o clave son necesarios para iniciar sesión");
        }
        return p;
    }

    public Rol validarRol(Usuario p) {
        Rol r = null;
        if (p.getRolList() != null && p.getRolList().size() > 0) {
            r = p.getRolList().get(0);
        } else {
            MessageUtil.enviarMensajeErrorGlobal(
                    "Rol no asignado",
                    "Debe esperar a que se le asigne un rol dentro del sistema");
        }
        return r;
    }
}
