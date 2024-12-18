/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.ues.entities.Usuario;

/**
 *
 * @author guada
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "GestorTareasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario login(Usuario usuario) {
       try {
           // 
            return em.createQuery("SELECT u FROM Usuario u WHERE u.usuarioName = :username AND u.password = :password", Usuario.class)
                     .setParameter("username", usuario.getUsuarioName())
                    .setParameter("password", usuario.getPassword())
                     .getSingleResult(); 
        } catch (Exception e) {
            return null; // Manejar excepciones adecuadamente
        }
    }
    
}
