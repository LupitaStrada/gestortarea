package sv.edu.ues.entities;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Tarea")
public class Tarea implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTarea")
    private int idTarea;

    @Column(name = "titulo", length = 255)
    private String titulo;

    @Column(name = "fechaAsignacion")
    private java.sql.Date fechaAsignacion;

    @Column(name = "fechaLimite")
    private java.sql.Date fechaLimite;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "nivelPrioridad", length = 50)
    private String nivelPrioridad;

    @Column(name = "estado", length = 50)
    private String estado;

    @Column(name = "finalizada")
    private boolean finalizada;

    @ManyToOne
    @JoinColumn(name = "idMiembroResponsable", referencedColumnName = "idMiembroEquipo")
    private MiembroEquipo miembroResponsable;

    @OneToMany(mappedBy = "tarea")
    private List<ProgresoTarea> progresoTareas;

    // Getters y Setters

    public Tarea() {
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNivelPrioridad() {
        return nivelPrioridad;
    }

    public void setNivelPrioridad(String nivelPrioridad) {
        this.nivelPrioridad = nivelPrioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public MiembroEquipo getMiembroResponsable() {
        return miembroResponsable;
    }

    public void setMiembroResponsable(MiembroEquipo miembroResponsable) {
        this.miembroResponsable = miembroResponsable;
    }

    public List<ProgresoTarea> getProgresoTareas() {
        return progresoTareas;
    }

    public void setProgresoTareas(List<ProgresoTarea> progresoTareas) {
        this.progresoTareas = progresoTareas;
    }
    
}
