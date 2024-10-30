/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author guada
 */
@Named
@ViewScoped
public class CalendarBean implements Serializable {

    private static final long serialVersionUID = 1;
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {

        this.date = date;
    }

}
