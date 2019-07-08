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
public class Departamento {

    private Integer identificadorDelDepartamento;
    private String codigo_departamento;
    private String identificadorDeLaZona;
    private String nombre;
    private Date fechaDeInsercion;
    private Date fechaDeModificacion;
    private Date fechaDeEliminacion;
    private Integer estadoDeEliminacion;
    private String identificadorDeLaSesion;

    public Departamento(Integer identificadorDelDepartamento, String codigo_departamento, String identificadorDeLaZona, String nombre, Date fechaDeInsercion, Date fechaDeModificacion, Date fechaDeEliminacion, Integer estadoDeEliminacion, String identificadorDeLaSesion) {
        this.identificadorDelDepartamento = identificadorDelDepartamento;
        this.codigo_departamento = codigo_departamento;
        this.identificadorDeLaZona = identificadorDeLaZona;
        this.nombre = nombre;
        this.fechaDeInsercion = fechaDeInsercion;
        this.fechaDeModificacion = fechaDeModificacion;
        this.fechaDeEliminacion = fechaDeEliminacion;
        this.estadoDeEliminacion = estadoDeEliminacion;
        this.identificadorDeLaSesion = identificadorDeLaSesion;
    }

    public Departamento() {
    }

    public String getCodigo_departamento() {
        return codigo_departamento;
    }

    public void setCodigo_departamento(String codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }

    public Integer getEstadoDeEliminacion() {
        return estadoDeEliminacion;
    }

    public void setEstadoDeEliminacion(Integer estadoDeEliminacion) {
        this.estadoDeEliminacion = estadoDeEliminacion;
    }

    public Date getFechaDeEliminacion() {
        return fechaDeEliminacion;
    }

    public void setFechaDeEliminacion(Date fechaDeEliminacion) {
        this.fechaDeEliminacion = fechaDeEliminacion;
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

    public String getIdentificadorDeLaSesion() {
        return identificadorDeLaSesion;
    }

    public void setIdentificadorDeLaSesion(String identificadorDeLaSesion) {
        this.identificadorDeLaSesion = identificadorDeLaSesion;
    }

    public String getIdentificadorDeLaZona() {
        return identificadorDeLaZona;
    }

    public void setIdentificadorDeLaZona(String identificadorDeLaZona) {
        this.identificadorDeLaZona = identificadorDeLaZona;
    }

    public Integer getIdentificadorDelDepartamento() {
        return identificadorDelDepartamento;
    }

    public void setIdentificadorDelDepartamento(Integer identificadorDelDepartamento) {
        this.identificadorDelDepartamento = identificadorDelDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
