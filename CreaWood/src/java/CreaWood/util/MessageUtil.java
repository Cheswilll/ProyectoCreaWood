/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreaWood.util;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author wmoramor
 */
public class MessageUtil {
    
    public static SelectItem[] getSelectItems(List<?> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "---");
            i++;
        }
        for (Object x : entities) {
            items[i++] = new SelectItem(x, x.toString());
        }
        return items;
    }
    
    public static void enviarMensajeError(String idClient, String summary, String detail){
        enviarMensajeComun(FacesMessage.SEVERITY_ERROR, idClient, summary, detail);
    }
    
    public static void enviarMensajeErrorGlobal(String summary, String detail){
        enviarMensajeComun(FacesMessage.SEVERITY_ERROR,null, summary, detail);
    } 
    
    public static void enviarMensajeInformacion(String idClient, String summary, String detail){
        enviarMensajeComun(FacesMessage.SEVERITY_INFO, idClient, summary, detail);
    }
    
    public static void enviarMensajeInformacionGlobal(String summary, String detail){
        enviarMensajeComun(FacesMessage.SEVERITY_INFO, null, summary, detail);
    }
    
    private static void enviarMensajeComun(FacesMessage.Severity severity, String idClient, String summary, String detail) {
        FacesMessage fm = new FacesMessage(severity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(idClient, fm);
    }
    
}
