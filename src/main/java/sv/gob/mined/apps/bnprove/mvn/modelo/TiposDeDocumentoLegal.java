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
public class TiposDeDocumentoLegal {
    private Integer identificadorDeDocumentoLegal;
    private String descripcionDeDocumentoLegal;
    private Date fechaDeInsercion;
    private Date fechaDeModificacion;
    private Date fechaDeEliminacion;
    private Integer estadoDeEliminacion;
    private String name;

    public TiposDeDocumentoLegal() {
    }

    public Integer getIdentificadorDeDocumentoLegal() {
        return identificadorDeDocumentoLegal;
    }

    public void setIdentificadorDeDocumentoLegal(Integer identificadorDeDocumentoLegal) {
        this.identificadorDeDocumentoLegal = identificadorDeDocumentoLegal;
    }

    public String getDescripcionDeDocumentoLegal() {
        return descripcionDeDocumentoLegal;
    }

    public void setDescripcionDeDocumentoLegal(String descripcionDeDocumentoLegal) {
        this.descripcionDeDocumentoLegal = descripcionDeDocumentoLegal;
    }

    @Override
    public String toString() {
        return descripcionDeDocumentoLegal;
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
}