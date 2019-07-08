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
public class OferenteDeBienesYServicios implements PersistenciaDao{
    
    private Long identificadorPrimarioOferente;
    private Long calificacionOferente;
    private String principalesProductosSuministra;
    private Date fechaDeInsercion;
    private Date fechaDeModificacion;
    private Integer esContribuyente;
    private String nrc;
    private Date fechaDeEliminacion;
    private Integer estadoDeEliminacion;
    private String name;

    public OferenteDeBienesYServicios() {
    }

    public OferenteDeBienesYServicios(Long identificadorPrimarioOferente) {
        this.identificadorPrimarioOferente = identificadorPrimarioOferente;
    }

    public OferenteDeBienesYServicios(Long identificadorPrimarioOferente, Date fechaDeInsercion) {
        this.identificadorPrimarioOferente = identificadorPrimarioOferente;
        this.fechaDeInsercion = fechaDeInsercion;
    }

    public Long getIdentificadorPrimarioOferente() {
        return identificadorPrimarioOferente;
    }

    public void setIdentificadorPrimarioOferente(Long identificadorPrimarioOferente) {
        this.identificadorPrimarioOferente = identificadorPrimarioOferente;
    }

    public Long getCalificacionOferente() {
        return calificacionOferente;
    }

    public void setCalificacionOferente(Long calificacionOferente) {
        this.calificacionOferente = calificacionOferente;
    }

    public String getPrincipalesProductosSuministra() {
        return principalesProductosSuministra;
    }

    public void setPrincipalesProductosSuministra(String principalesProductosSuministra) {
        this.principalesProductosSuministra = principalesProductosSuministra;
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

    public Integer getEsContribuyente() {
        return esContribuyente;
    }

    public void setEsContribuyente(Integer esContribuyente) {
        this.esContribuyente = esContribuyente;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
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
        return "sv.gob.mined.apps.bnprove.mvn.modelo.OferenteDeBienesYServicios[ identificadorPrimarioOferente=" + identificadorPrimarioOferente + " ]";
    }
    
    @Override
    public String generarInsertSQL(){
        return "INSERT INTO OferenteDeBienesYServicios (calificacionOferente,principalesProductosSuministra,fechaDeInsercion,fechaDeModificacion,esContribuyente,Nrc,fechaDeEliminacion,estadoDeEliminacion,name) VALUES (?,?,?,?,?,?,?,?,?)";
    }
    
    @Override
    public Object[] getDatosInsert() {
        return new Object[]{calificacionOferente, principalesProductosSuministra, fechaDeInsercion, fechaDeModificacion, esContribuyente, nrc, fechaDeEliminacion, estadoDeEliminacion, name};
    }

    @Override
    public String generarUpdateSQL() {
        return null;
    }

    @Override
    public Object[] getDatosUpdate() {
        return null;
    }
}
