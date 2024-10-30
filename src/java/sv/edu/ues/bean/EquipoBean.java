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
import sv.edu.ejb.EquipoFacadeLocal;
import sv.edu.ues.entities.Equipo;

/**
 *
 * @author guada
 */
@ManagedBean
public class EquipoBean {

    @Inject
    private EquipoFacadeLocal equipoFacadeLocal;
    private Equipo equipo;
    private List<Equipo> equipos;

    @PostConstruct
    public void init() {
        System.out.println("EquipoBean creado.");
        //inicializamos la eqtiqueta
        equipo = new Equipo();
        String equipoldParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("equipold");
        if (equipoldParam != null) {

            Long equipold = Long.parseLong(equipoldParam);
            equipo = equipoFacadeLocal.find(equipold);
        }
        this.equipos = equipoFacadeLocal.findAll();
    }

    public void create() throws IOException {
        equipoFacadeLocal.create(equipo);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro creado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    // Permite ditar un registro

    public void edit() throws IOException {
        equipoFacadeLocal.edit(equipo);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro actualizado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    // Permite borrar un registro

    public void delete() throws IOException {
        equipoFacadeLocal.remove(equipo);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro eliminado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    //  @return the etiquetas 

    public List<Equipo> getEquipos() {
        return equipos;
    }
    //   * Creturn the etiquetas

    public Equipo getEquipo() {
        return equipo;

    }
}
