/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author guada
 */
@Entity
@Table (name="Equipo")

public class Equipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Equipo_Id")
    private Long id;

    @NotNull(message = "El encargado es obligatorio.")
    @Size(min = 5, max = 50,message = "El encargado debe tener entre 1 y 50 caracteres.")
    @Column(name = "Encargado")
    private String encargado;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NombreEquipo")
    private String nombreEquipo;

    @NotNull
    @Min(1)  // No se necesita @Size para un números
    @Column(name = "CantidadMiembros")
    private int cantidadMiembros;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Column(name = "FechaCreacion")
    private Date fechaCreacion;  //  para manejar fechas

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getCantidadMiembros() {
        return cantidadMiembros;
    }

    public void setCantidadMiembros(int cantidadMiembros) {
        this.cantidadMiembros = cantidadMiembros;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
