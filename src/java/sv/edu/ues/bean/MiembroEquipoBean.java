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
import sv.edu.ejb.MiembroEquipoFacadeLocal;
import sv.edu.ejb.RolFacadeLocal;
import sv.edu.ejb.UsuarioFacadeLocal;
import sv.edu.ues.entities.Equipo;
import sv.edu.ues.entities.MiembroEquipo;
import sv.edu.ues.entities.Rol;
import sv.edu.ues.entities.Usuario;

/**
 *
 * @author guada
 */
@ManagedBean
public class MiembroEquipoBean {

    @Inject
    private MiembroEquipoFacadeLocal miembroEquipoFacadeLocal;
    @Inject
    private UsuarioFacadeLocal usuarioFacadeLocal;
    @Inject
    private RolFacadeLocal rolFacadeLocal;
    @Inject
    private EquipoFacadeLocal equipoFacadeLocal;
    
    private MiembroEquipo miembroEquipo;
    private List<MiembroEquipo> miembroEquipos;
    private List<Usuario> usuarios;
    private List<Rol> roles;
    private List<Equipo> equipos;

    @PostConstruct
    public void init() {
        //inicializamos la eqtiqueta
        miembroEquipo = new MiembroEquipo();
        miembroEquipo.setUsuario(new Usuario());
        miembroEquipo.setRol(new Rol());
        miembroEquipo.setEquipo(new Equipo());
        
        String miembroEquipoldParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idMiembroEquipo");
        if (miembroEquipoldParam != null) {

            int idMiembroEquipo = Integer.parseInt(miembroEquipoldParam);
            miembroEquipo = miembroEquipoFacadeLocal.find(idMiembroEquipo);
        }
        this.miembroEquipos = miembroEquipoFacadeLocal.findAll();
        this.usuarios = usuarioFacadeLocal.findAll();
        this.roles = rolFacadeLocal.findAll();
        this.equipos = equipoFacadeLocal.findAll();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
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
