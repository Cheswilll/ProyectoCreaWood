/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Mueble;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author wmoramor
 */
@javax.ejb.Stateless
public class MuebleFacade extends AbstractFacade<Mueble> implements MuebleFacadeLocal {

    @PersistenceContext(unitName = "CreaWoodPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MuebleFacade() {
        super(Mueble.class);
    }
    
}
