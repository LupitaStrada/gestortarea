package sv.edu.ues.bean;

import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import sv.edu.ejb.ProgresoTareaFacadeLocal;
import sv.edu.ues.entities.ProgresoTarea;

@ManagedBean
public class ProgresoTareaBean {
     @Inject
    private ProgresoTareaFacadeLocal progresoTareaFacadeLocal;
    private ProgresoTarea progresoTarea;
    private List<ProgresoTarea> progresoTareas;
@PostConstruct
    public void init() {
        System.out.println("Progresotarea creado.");
        //inicializamos la eqtiqueta
        progresoTarea = new ProgresoTarea();
        String progresoTarealdParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idProgreso");
        if (progresoTarealdParam != null) {

            int progresotareald = Integer.parseInt(progresoTarealdParam);
            progresoTarea = progresoTareaFacadeLocal.find(progresotareald);
        }
        this.progresoTareas = progresoTareaFacadeLocal.findAll();
    }

    public void create() throws IOException {
        progresoTareaFacadeLocal.create(progresoTarea);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro creado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    // Permite ditar un registro

    public void edit() throws IOException {
        progresoTareaFacadeLocal.edit(progresoTarea);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro actualizado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    // Permite borrar un registro

    public void delete() throws IOException {
        progresoTareaFacadeLocal.remove(progresoTarea);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro eliminado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    //  @return the etiquetas 

    public List<ProgresoTarea> getProgresoTareas() {
        return progresoTareas;
    }
    //   * Creturn the etiquetas

    public ProgresoTarea getProgresoTarea() {
        return progresoTarea;

    }
}
