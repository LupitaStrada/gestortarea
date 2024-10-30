package sv.edu.ues.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ProgresoTarea")
public class ProgresoTarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProgreso")
    private int idProgreso;

    @Column(name = "porcentajeAvance")
    private float porcentajeAvance;

    @Column(name = "fechaActualizacion")
    private java.sql.Date fechaActualizacion;

    @ManyToOne
    @JoinColumn(name = "idTarea", referencedColumnName = "idTarea")
    private Tarea tarea;

    public int getIdProgreso() {
        return idProgreso;
    }

    public void setIdProgreso(int idProgreso) {
        this.idProgreso = idProgreso;
    }

    public float getPorcentajeAvance() {
        return porcentajeAvance;
    }

    public void setPorcentajeAvance(float porcentajeAvance) {
        this.porcentajeAvance = porcentajeAvance;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = (java.sql.Date) fechaActualizacion;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    // Getters y Setters

    public ProgresoTarea() {
    }
}
