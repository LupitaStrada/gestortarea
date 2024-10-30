
package sv.edu.ues.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MiembroEquipo")
public class MiembroEquipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMiembroEquipo")
    private int idMiembroEquipo;

    @ManyToOne
    @JoinColumn(name = "usuarioName", referencedColumnName = "usuarioName")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idRol", referencedColumnName = "idRol")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "idEquipo", referencedColumnName = "idEquipo")
    private Equipo equipo;

    public int getIdMiembroEquipo() {
        return idMiembroEquipo;
    }

    public void setIdMiembroEquipo(int idMiembroEquipo) {
        this.idMiembroEquipo = idMiembroEquipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    // Getters y Setters
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public MiembroEquipo() {
    }
}
