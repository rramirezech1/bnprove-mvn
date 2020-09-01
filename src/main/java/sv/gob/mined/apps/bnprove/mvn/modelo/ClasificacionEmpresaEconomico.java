/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.modelo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import sv.gob.mined.apps.bnprove.mvn.dao.PersistenciaDao;

/**
 *
 * @author Infosoft
 */
public class ClasificacionEmpresaEconomico implements PersistenciaDao{
    
    private Integer identificadorClasificacionSectorEconomico;
    private Integer identificadorPrimarioDeLaEmpresa;
    private Integer identificadorDelSectorEconomico;
    private String especializacionPorSubsector;
    private Date fechaDeInsercion;
    private Date fechaDeModificacion;
    private Date fechaDeEliminacion;
    private Integer estadoDeEliminacion;
    private String[] tipoServicio;
    private String name;
    

    public ClasificacionEmpresaEconomico() {
    }

    public Integer getIdentificadorClasificacionSectorEconomico() {
        return identificadorClasificacionSectorEconomico;
    }

    public void setIdentificadorClasificacionSectorEconomico(Integer identificadorClasificacionSectorEconomico) {
        this.identificadorClasificacionSectorEconomico = identificadorClasificacionSectorEconomico;
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

    public String getEspecializacionPorSubsector() {
        return especializacionPorSubsector;
    }

    public void setEspecializacionPorSubsector(String especializacionPorSubsector) {
        this.especializacionPorSubsector = especializacionPorSubsector;
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

    public Integer getIdentificadorDelSectorEconomico() {
        return identificadorDelSectorEconomico;
    }

    public void setIdentificadorDelSectorEconomico(Integer identificadorDelSectorEconomico) {
        this.identificadorDelSectorEconomico = identificadorDelSectorEconomico;
    }

    public Integer getIdentificadorPrimarioDeLaEmpresa() {
        return identificadorPrimarioDeLaEmpresa;
    }

    public void setIdentificadorPrimarioDeLaEmpresa(Integer identificadorPrimarioDeLaEmpresa) {
        this.identificadorPrimarioDeLaEmpresa = identificadorPrimarioDeLaEmpresa;
    }

    public String[] getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String[] tipoServicio) {
        System.out.println(Arrays.toString(tipoServicio));
        this.tipoServicio = tipoServicio;
    } 
    
    @Override
    public String generarInsertSQL() {
        String query = "INSERT INTO dbo.ClasificacionEmpresaEconomico (identificadorPrimarioDeLaEmpresa, identificadorDelSectorEconomico, especializacionPorSubsector, fechaDeInsercion, fechaDeModificacion, fechaDeEliminacion, estadoDeEliminacion, tipoServicio, name) VALUES (?,?,?,?,?,?,?,?,?);";
        return query;
    }
    
    @Override
    public Object[] getDatosInsert() {
        return new Object[]{identificadorPrimarioDeLaEmpresa, identificadorDelSectorEconomico, especializacionPorSubsector, fechaDeInsercion, fechaDeModificacion, fechaDeEliminacion, estadoDeEliminacion, tipoServicio, name};
    }

    @Override
    public String generarUpdateSQL() {
        String query = "update dbo.ClasificacionEmpresaEconomico SET identificadorPrimarioDeLaEmpresa=?, identificadorDelSectorEconomico=?, especializacionPorSubsector=?, fechaDeInsercion=?, fechaDeModificacion=?, fechaDeEliminacion=?, estadoDeEliminacion=?, tipoServicio=?, name=? WHERE identificadorClasificacionSectorEconomico=?";
        return query;
    }
    
    @Override
    public Object[] getDatosUpdate() {
        return new Object[]{identificadorPrimarioDeLaEmpresa, identificadorDelSectorEconomico, especializacionPorSubsector, fechaDeInsercion, fechaDeModificacion, fechaDeEliminacion, estadoDeEliminacion, name, identificadorClasificacionSectorEconomico, tipoServicio};
    }

}