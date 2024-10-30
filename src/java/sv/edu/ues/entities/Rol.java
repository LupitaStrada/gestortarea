package sv.edu.ues.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Rol")
public class Rol implements Serializable {

    @Id
    @Column(name = "idRol")
    private int idRol;

    @Column(name = "nombreRol", length = 255)
    private String nombreRol;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    // Getters y Setters

    public Rol() {
    }
}
