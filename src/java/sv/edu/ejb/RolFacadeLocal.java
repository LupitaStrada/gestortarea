/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ejb;

import java.util.List;
import javax.ejb.Local;
import sv.edu.ues.entities.Rol;

/**
 *
 * @author guada
 */
@Local
public interface RolFacadeLocal {

    void create(Rol rol);

    void edit(Rol rol);

    void remove(Rol rol);

    Rol find(Object id);

    List<Rol> findAll();

    List<Rol> findRange(int[] range);

    int count();
    
}
