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
public class Usuario implements PersistenciaDao{
    
    private String userName;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String eMail;
    private String password;
    private String respuesta1;
    private String respuesta2;
    private Date fechaInsercion;
    private Date fechaModificacion;
    private Date fechaEliminacion;
    private Integer estadoDeEliminacion;
    private String name;
    private Integer idPregunta1;
    private Integer idPregunta2;

    public Usuario() {
    }

    public Usuario(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public Date getFechaInsercion() {
        return fechaInsercion;
    }

    public void setFechaInsercion(Date fechaInsercion) {
        this.fechaInsercion = fechaInsercion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Date getFechaEliminacion() {
        return fechaEliminacion;
    }

    public void setFechaEliminacion(Date fechaEliminacion) {
        this.fechaEliminacion = fechaEliminacion;
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

    public Integer getIdPregunta1() {
        return idPregunta1;
    }

    public void setIdPregunta1(Integer idPregunta1) {
        this.idPregunta1 = idPregunta1;
    }

    public Integer getIdPregunta2() {
        return idPregunta2;
    }

    public void setIdPregunta2(Integer idPregunta2) {
        this.idPregunta2 = idPregunta2;
    }


    @Override
    public String toString() {
        return userName;
    }

    @Override
    public String generarInsertSQL() {
        return "INSERT INTO dbo.usuario (userName, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, eMail, password, idPregunta1, respuesta1, idPregunta2, respuesta2, fechaInsercion, fechaModificacion, fechaEliminacion, estadoDeEliminacion, name) " +
                    "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public Object[] getDatosInsert() {
        return new Object[]{userName, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, eMail, password, idPregunta1, respuesta1, idPregunta2, respuesta2, fechaInsercion, fechaModificacion, fechaEliminacion, estadoDeEliminacion, name};
    }

    @Override
    public String generarUpdateSQL() {
        return "UPDATE dbo.usuario SET primerNombre=?, segundoNombre=?, primerApellido=?, segundoApellido=?, telefono=?, eMail=?, password=?, idPregunta1=?, respuesta1=?, idPregunta2=?, respuesta2=?, fechaInsercion=?, fechaModificacion=?, fechaEliminacion=?, estadoDeEliminacion=?, name =? WHERE userName=?";
    }

    @Override
    public Object[] getDatosUpdate() {
        return new Object[]{primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, eMail, password, idPregunta1, respuesta1, idPregunta2, respuesta2, fechaInsercion, fechaModificacion, fechaEliminacion, estadoDeEliminacion, name, userName};
    }
    
}
