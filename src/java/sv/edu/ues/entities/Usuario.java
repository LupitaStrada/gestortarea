
package sv.edu.ues.entities;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

    @Id
    @Column(name = "usuarioName", length = 255)
    private String usuarioName;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "fechaNacimiento")
    private java.sql.Date fechaNacimiento;

    @Column(name = "ultimaConexion")
    private java.sql.Date ultimaConexion;

    @Column(name = "edad")
    private int edad;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "fotoPerfil", length = 255)
    private String fotoPerfil;

    // Getters y Setters

    public String getUsuarioName() {
        return usuarioName;
    }

    public void setUsuarioName(String usuarioName) {
        this.usuarioName = usuarioName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getUltimaConexion() {
        return ultimaConexion;
    }

    public void setUltimaConexion(Date ultimaConexion) {
        this.ultimaConexion = ultimaConexion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public Usuario() {
    }
    
}
