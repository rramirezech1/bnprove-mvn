/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.modelo;

import java.util.Date;
import sv.gob.mined.apps.bnprove.mvn.dao.PersistenciaDao;

/**
 *
 * @author RAREcheverria
 */

public class ClasificacionEmpresaTamano implements PersistenciaDao {
    private Integer identificadorEmpresaTamano;
    private String descripcionEmpresaTamano;
    private Date fechaDeInsercion;
    private Date fechaDeModificacion;
    private Date fechaDeEliminacion;
    private String name;
    private Integer estadoDeEliminacion;

    public ClasificacionEmpresaTamano() {
    }

    public ClasificacionEmpresaTamano(Integer identificadorEmpresaTamano) {
        this.identificadorEmpresaTamano = identificadorEmpresaTamano;
    }

    public Integer getIdentificadorEmpresaTamano() {
        return identificadorEmpresaTamano;
    }

    public void setIdentificadorEmpresaTamano(Integer identificadorEmpresaTamano) {
        this.identificadorEmpresaTamano = identificadorEmpresaTamano;
    }

    public String getDescripcionEmpresaTamano() {
        return descripcionEmpresaTamano;
    }

    public void setDescripcionEmpresaTamano(String descripcionEmpresaTamano) {
        this.descripcionEmpresaTamano = descripcionEmpresaTamano;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEstadoDeEliminacion() {
        return estadoDeEliminacion;
    }

    public void setEstadoDeEliminacion(Integer estadoDeEliminacion) {
        this.estadoDeEliminacion = estadoDeEliminacion;
    }    
    
    @Override
    public String generarInsertSQL() {
        String query = "INSERT INTO dbo.ClasificacionEmpresaTamano (identificadorEmpresaTamano, descripcionEmpresaTamano, fechaDeInsercion, fechaDeModificacion, fechaDeEliminacion, name, estadoDeEliminacion) VALUES (?,?,?,?,?,?,?);";
        return query;
    }
    
    @Override
    public Object[] getDatosInsert() {
        return new Object[]{descripcionEmpresaTamano, fechaDeInsercion, fechaDeModificacion, fechaDeEliminacion, name, estadoDeEliminacion};
    }

    @Override
    public String generarUpdateSQL() {
        String query = "update dbo.ClasificacionEmpresaTamano SET identificadorEmpresaTamano=?, descripcionEmpresaTamano=?, fechaDeInsercion=?, fechaDeModificacion=?, fechaDeEliminacion=?, name=?, estadoDeEliminacion=? WHERE identificadorEmpresaTamano=?";
        return query;
    }
    
    @Override
    public Object[] getDatosUpdate() {
        return new Object[]{identificadorEmpresaTamano, descripcionEmpresaTamano, fechaDeInsercion, fechaDeModificacion, fechaDeEliminacion, name, estadoDeEliminacion};
    }
}
