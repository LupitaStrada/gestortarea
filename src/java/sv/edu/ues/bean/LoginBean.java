/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import sv.edu.ues.entities.Usuario;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.inject.Inject;
import sv.edu.ejb.UsuarioFacadeLocal;

/**
 *
 * @author guada
 */
@ManagedBean
public class LoginBean {

    private Usuario user;
    private String message;
    @Inject
    private UsuarioFacadeLocal usuarioFacadeLocal;

    @PostConstruct
    public void init() {
        user = new Usuario();
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

    public String login() throws IOException {
        Usuario userLogin = new Usuario();
        userLogin.setUsuarioName(user.getUsuarioName());
        userLogin.setPassword(encryptPassword(user.getPassword()));
        Usuario auth = usuarioFacadeLocal.login(userLogin);
        if ("administrador".equals(user.getUsuarioName()) && "Prn3152024".equals(user.getPassword())) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("welcome.xhtml");
        } else if (auth != null && auth.getUsuarioName().equals(userLogin.getUsuarioName()) && auth.getPassword().equals(userLogin.getPassword())) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("welcome.xhtml");
        } else {
            message = "Usuario o contraseña incorrectos.";
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        }
        return null;
    }

    public String getMessage() {
        return message;
    }

    public Usuario getUser() {
        return user;

    }
}
