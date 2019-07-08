/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.modelo;

import java.util.Date;

/**
 *
 * @author Infosoft
 */
public class TipoDePersoneria {
    private Integer identificadorDePersoneria;
    private String descripcionDePersoneria;
    public java.util.Date fechaDeInsercion;
    public java.util.Date fechaDeModificacion;
    public java.util.Date fechaDeEliminacion;
    public Integer estadoDeEliminacion;
    public java.lang.String name;

    public TipoDePersoneria() {
    }

    public String getDescripcionDePersoneria() {
        return descripcionDePersoneria;
    }

    public void setDescripcionDePersoneria(String descripcionDePersoneria) {
        this.descripcionDePersoneria = descripcionDePersoneria;
    }

    public Integer getIdentificadorDePersoneria() {
        return identificadorDePersoneria;
    }

    public void setIdentificadorDePersoneria(Integer identificadorDePersoneria) {
        this.identificadorDePersoneria = identificadorDePersoneria;
    }

    public Date getFechaDeInsercion() {
        return fechaDeInsercion;
    }

    public void setFechaDeInsercion(Date fechaDeInsercion) {
        this.fechaDeInsercion = fechaDeInsercion;
    }

    public Date getFechaDeModificacion() {
        return fechaDeModificacion;
    }

    public void setFechaDeModificacion(Date fechaDeModificacion) {
        this.fechaDeModificacion = fechaDeModificacion;
    }

    public Date getFechaDeEliminacion() {
        return fechaDeEliminacion;
    }

    public void setFechaDeEliminacion(Date fechaDeEliminacion) {
        this.fechaDeEliminacion = fechaDeEliminacion;
    }

    public Integer getEstadoDeEliminacion() {
        return estadoDeEliminacion;
    }

    public void setEstadoDeEliminacion(Integer estadoDeEliminacion) {
        this.estadoDeEliminacion = estadoDeEliminacion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return descripcionDePersoneria;
    }   
}