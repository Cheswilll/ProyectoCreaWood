/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Recibo;
import java.util.List;

/**
 *
 * @author wmoramor
 */
@javax.ejb.Local
public interface ReciboFacadeLocal {

    void create(Recibo recibo);

    void edit(Recibo recibo);

    void remove(Recibo recibo);

    Recibo find(Object id);

    List<Recibo> findAll();

    List<Recibo> findRange(int[] range);

    int count();
    
}
