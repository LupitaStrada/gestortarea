/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ejb;

import java.util.List;
import javax.ejb.Local;
import sv.edu.ues.entities.MiembroEquipo;

/**
 *
 * @author guada
 */
@Local
public interface MiembroEquipoFacadeLocal {

    void create(MiembroEquipo miembroEquipo);

    void edit(MiembroEquipo miembroEquipo);

    void remove(MiembroEquipo miembroEquipo);

    MiembroEquipo find(Object id);

    List<MiembroEquipo> findAll();

    List<MiembroEquipo> findRange(int[] range);

    int count();
    
}
