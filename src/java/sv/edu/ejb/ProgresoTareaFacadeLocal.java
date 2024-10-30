/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ejb;

import java.util.List;
import javax.ejb.Local;
import sv.edu.ues.entities.ProgresoTarea;

/**
 *
 * @author guada
 */
@Local
public interface ProgresoTareaFacadeLocal {

    void create(ProgresoTarea progresoTarea);

    void edit(ProgresoTarea progresoTarea);

    void remove(ProgresoTarea progresoTarea);

    ProgresoTarea find(Object id);

    List<ProgresoTarea> findAll();

    List<ProgresoTarea> findRange(int[] range);

    int count();
    
}
