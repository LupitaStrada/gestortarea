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
import sv.edu.ues.entities.MiembroEquipo;

/**
 *
 * @author guada
 */
@ManagedBean
public class MiembroEquipoBean {
     @Inject
    private MiembroEquipoFacadeLocal miembroEquipoFacadeLocal;
    private MiembroEquipo miembroEquipo;
    private List<MiembroEquipo> miembroEquipos;
@PostConstruct
    public void init() {
        System.out.println("MiembroEquipo creado.");
        //inicializamos la eqtiqueta
        miembroEquipo = new MiembroEquipo();
        String miembroEquipoldParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("miembroEquipold");
        if (miembroEquipoldParam != null) {

            Long miembroEquipold = Long.parseLong(miembroEquipoldParam);
            miembroEquipo = miembroEquipoFacadeLocal.find(miembroEquipold);
        }
        this.miembroEquipos = miembroEquipoFacadeLocal.findAll();
    }

    public void create() throws IOException {
        miembroEquipoFacadeLocal.create(miembroEquipo);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro creado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    // Permite ditar un registro

    public void edit() throws IOException {
        miembroEquipoFacadeLocal.edit(miembroEquipo);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro actualizado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    // Permite borrar un registro

    public void delete() throws IOException {
        miembroEquipoFacadeLocal.remove(miembroEquipo);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro eliminado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    //  @return the etiquetas 

    public List<MiembroEquipo> getMiembrosEquipos() {
        return miembroEquipos;
    }
    //   * Creturn the etiquetas

    public MiembroEquipo getMiembroEquipo() {
        return miembroEquipo;

    }
}
