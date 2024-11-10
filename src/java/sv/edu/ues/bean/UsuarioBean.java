/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.bean;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import sv.edu.ejb.UsuarioFacadeLocal;
import sv.edu.ues.entities.Usuario;

/**
 *
 * @author guada
 */
@ManagedBean
public class UsuarioBean {

    @Inject
    private UsuarioFacadeLocal usuarioFacadeLocal;
    private Usuario usuario;
    private List<Usuario> usuarios;

    @PostConstruct
    public void init() {
        System.out.println("UsuarioBean creado.");       
        usuario = new Usuario();
        String usuarioldParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("usuarioName");
        if (usuarioldParam != null) {
            usuario = usuarioFacadeLocal.find(usuarioldParam);
        }
        this.usuarios = usuarioFacadeLocal.findAll();
    }

    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al cifrar la contraseña", e);
        }
    }

    public void create() throws IOException {
        usuario.setUltimaConexion(Date.valueOf(LocalDate.now()));
      usuario.setPassword(encryptPassword(usuario.getPassword()));
        usuarioFacadeLocal.create(usuario);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro creado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    // Permite ditar un registro

    public void edit() throws IOException {
        usuarioFacadeLocal.edit(usuario);
        FacesContext.getCurrentInstance()
                .getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage("Registro actualizado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    // Permite borrar un registro

    public void delete() throws IOException {
        usuarioFacadeLocal.remove(usuario);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro eliminado."));
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    //  @return the etiquetas 

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    //   * Creturn the etiquetas

    public Usuario getUsuario() {
        return usuario;

    }
}
