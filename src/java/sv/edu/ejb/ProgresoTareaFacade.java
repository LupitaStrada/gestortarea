/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.ues.entities.ProgresoTarea;

/**
 *
 * @author guada
 */
@Stateless
public class ProgresoTareaFacade extends AbstractFacade<ProgresoTarea> implements ProgresoTareaFacadeLocal {

    @PersistenceContext(unitName = "GestorTareasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProgresoTareaFacade() {
        super(ProgresoTarea.class);
    }
    
}
