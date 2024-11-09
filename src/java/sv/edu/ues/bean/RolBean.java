/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.bean;


import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import sv.edu.ejb.MiembroEquipoFacadeLocal;
import sv.edu.ejb.RolFacadeLocal;
import sv.edu.ues.entities.MiembroEquipo;
import sv.edu.ues.entities.Rol;

/**
 *
 * @author guada
 */
@ManagedBean
public class RolBean {
     @Inject
    private RolFacadeLocal rolFacadeLocal;
    private Rol rol;
    private List<Rol> roles;
@PostConstruct
    public void init() {
        System.out.println("Rol creado.");
        //inicializamos la eqtiqueta
        rol = new Rol();
        String rolIdParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idRol");
        if (rolIdParam != null) {

            int rolld = Integer.parseInt(rolIdParam);
            rol = rolFacadeLocal.find(rolld);
        }
        this.roles = rolFacadeLocal.findAll();
    }

    public void create() throws IOException {
        rolFacadeLocal.create(rol);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro creado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    // Permite ditar un registro

    public void edit() throws IOException {
        rolFacadeLocal.edit(rol);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro actualizado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    // Permite borrar un registro

    public void delete() throws IOException {
        rolFacadeLocal.remove(rol);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro eliminado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    //  @return the etiquetas 

    public List<Rol> getRoles() {
        return roles;
    }
    //   * Creturn the etiquetas

    public Rol getRol() {
        return rol;

    }
}
