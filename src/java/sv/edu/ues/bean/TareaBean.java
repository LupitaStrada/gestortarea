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
import sv.edu.ejb.TareaFacadeLocal;
import sv.edu.ues.entities.MiembroEquipo;
import sv.edu.ues.entities.Tarea;

/**
 *
 * @author Mateo
 */
@ManagedBean
public class TareaBean {

    @Inject
    private TareaFacadeLocal tareaFacadeLocal;
    @Inject
    private MiembroEquipoFacadeLocal miembroEquipoFacadeLocal;
    private Tarea tarea;
    private List<Tarea> tareas;
    private List<MiembroEquipo> miembroEquipos;

    @PostConstruct
    public void init() {
        //inicializamos la eqtiqueta
        tarea = new Tarea();
        tarea.setMiembroResponsable(new MiembroEquipo());
        String idTareaParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idTarea");
        if (idTareaParam != null) {

            int idTarea = Integer.parseInt(idTareaParam);
            tarea = tareaFacadeLocal.find(idTarea);
        }
        this.tareas = tareaFacadeLocal.findAll();
        this.miembroEquipos = miembroEquipoFacadeLocal.findAll();
    }

    public void create() throws IOException {
        tareaFacadeLocal.create(tarea);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro creado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    // Permite ditar un registro

    public void edit() throws IOException {
        tareaFacadeLocal.edit(tarea);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro actualizado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    // Permite borrar un registro

    public void delete() throws IOException {
        tareaFacadeLocal.remove(tarea);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro eliminado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    //  @return the etiquetas 

    public List<Tarea> getTareas() {
        return tareas;
    }
    //   * Creturn the etiquetas

    public Tarea getTarea() {
        return tarea;

    }

    public List<MiembroEquipo> getMiembroEquipos() {
        return miembroEquipos;
    }

    public void setMiembroEquipos(List<MiembroEquipo> miembroEquipos) {
        this.miembroEquipos = miembroEquipos;
    }

}
