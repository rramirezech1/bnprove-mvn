/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.modelo;

import java.util.Date;
import sv.gob.mined.apps.bnprove.mvn.dao.PersistenciaDao;

/**
 *
 * @author Infosoft
 */
public class CoberturaTerritorio implements PersistenciaDao{

    private Integer identificadorDeCobertura;
    private Integer identificadorPrimarioDeLaEmpresa;
    private Integer identificadorDelDepartamento;
    private Date fechaDeInsercion;
    private Date fechaDeModificacion;
    private Date fechaDeEliminacion;
    private Integer estadoDeEliminacion;
    private String name;

    public CoberturaTerritorio() {
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

    public Integer getIdentificadorPrimarioDeLaEmpresa() {
        return identificadorPrimarioDeLaEmpresa;
    }

    public void setIdentificadorPrimarioDeLaEmpresa(Integer identificadorPrimarioDeLaEmpresa) {
        this.identificadorPrimarioDeLaEmpresa = identificadorPrimarioDeLaEmpresa;
    }

    public Integer getIdentificadorDeCobertura() {
        return identificadorDeCobertura;
    }

    public void setIdentificadorDeCobertura(Integer identificadorDeCobertura) {
        this.identificadorDeCobertura = identificadorDeCobertura;
    }

    public Integer getIdentificadorDelDepartamento() {
        return identificadorDelDepartamento;
    }

    public void setIdentificadorDelDepartamento(Integer identificadorDelDepartamento) {
        this.identificadorDelDepartamento = identificadorDelDepartamento;
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
    public String generarInsertSQL() {
        String query = "INSERT INTO dbo.CoberturaTerritorio (identificadorPrimarioDeLaEmpresa, identificadorDelDepartamento, fechaDeInsercion, fechaDeModificacion, fechaDeEliminacion, estadoDeEliminacion, name) VALUES (?,?,?,?,?,?,?)";
        return query;
    }

    @Override
    public Object[] getDatosInsert() {
        return new Object[]{identificadorPrimarioDeLaEmpresa, identificadorDelDepartamento, fechaDeInsercion, fechaDeModificacion, fechaDeEliminacion, estadoDeEliminacion, name};
    }

    @Override
    public String generarUpdateSQL() {
        String query = "update dbo.CoberturaTerritorio SET identificadorPrimarioDeLaEmpresa=?,identificadorDelDepartamento=?,fechaDeInsercion=?,fechaDeModificacion=?,fechaDeEliminacion=?,estadoDeEliminacion=?,name=? where identificadorDeCobertura=?";
        return query;
    }
    
    @Override
    public Object[] getDatosUpdate() {
        return new Object[]{identificadorPrimarioDeLaEmpresa, identificadorDelDepartamento, fechaDeInsercion, fechaDeModificacion, fechaDeEliminacion, estadoDeEliminacion, name, identificadorDeCobertura};
    }
}
