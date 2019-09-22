/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Mueble;
import java.util.List;

/**
 *
 * @author wmoramor
 */
@javax.ejb.Local
public interface MuebleFacadeLocal {

    void create(Mueble mueble);

    void edit(Mueble mueble);

    void remove(Mueble mueble);

    Mueble find(Object id);

    List<Mueble> findAll();

    List<Mueble> findRange(int[] range);

    int count();
    
}
