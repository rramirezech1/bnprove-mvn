/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.modelo;

import java.io.Serializable;
import java.util.Date;
import sv.gob.mined.apps.bnprove.mvn.dao.PersistenciaDao;

/**
 *
 * @author Infosoft
 */
public class Persona implements PersistenciaDao, Serializable {

    private Integer identificadorDeLaPersona;
    private Integer identificadorDeGenero;
    private String primerApellido;
    private String segundoApellido;
    private String primerNombre;
    private String segundoNombre;
    private Date fechaDeNacimiento;
    private String numeroDeDui;
    private String numeroDeNit;
    private String numeroTelefono;
    private String numeroCelular;
    private String domicilio;
    private Integer identificadorDeDocumentoLegal;
    private String profesion;
    private String aCasada;
    private String eMail;
    private Integer inactivo;
    private String canton;
    private String direccionOficina;
    private String telefonoOficina;
    private String estadoOProvincia;
    private String lecturaDeFirma;
    private String numeroDocumentoLegal;
    private String lugarYFechaExpedicion;
    private String isssPersonal;
    private String sitioWeb;
    private String name;
    private String userName;
    private Date fechaDeInsercion;
    private Date fechaDeModificacion;
    private Date fechaDeEliminacion;
    private Integer estadoDeEliminacion;
    private String lugarEntregaDocumentos;
    private Integer identificadorPrimarioOferente = 1;
    private Integer identificadorOrigenlCiudadano;
    public Integer identificadorDelDepartamento;
    public Integer idMunicipio;

    public Persona() {
    }

    public Persona(Integer identificadorDeLaPersona) {
        this.identificadorDeLaPersona = identificadorDeLaPersona;
    }

    public Integer getIdentificadorDeLaPersona() {
        return identificadorDeLaPersona;
    }

    public void setIdentificadorDeLaPersona(Integer identificadorDeLaPersona) {
        this.identificadorDeLaPersona = identificadorDeLaPersona;
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

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getNumeroDeDui() {
        return numeroDeDui;
    }

    public void setNumeroDeDui(String numeroDeDui) {
        if (numeroDeDui != null) {
            this.numeroDeDui = numeroDeDui.replaceAll("\\W+", "");
        } else {
            this.numeroDeDui = numeroDeDui;
        }

    }

    public String getNumeroDeNit() {
        return numeroDeNit;
    }

    public void setNumeroDeNit(String numeroDeNit) {
        if (numeroDeNit != null) {
            this.numeroDeNit = numeroDeNit.replaceAll("\\W+", "");
        } else {
            this.numeroDeNit = numeroDeNit;
        }

    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        if (numeroTelefono != null) {
            this.numeroTelefono = numeroTelefono.replaceAll("\\W+", "");
        } else {
            this.numeroTelefono = numeroTelefono;
        }
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        if (numeroCelular != null) {
            this.numeroCelular = numeroCelular.replaceAll("\\W+", "");
        } else {
            this.numeroCelular = numeroCelular;
        }
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Integer getIdentificadorDeGenero() {
        return identificadorDeGenero;
    }

    public void setIdentificadorDeGenero(Integer identificadorDeGenero) {
        this.identificadorDeGenero = identificadorDeGenero;
    }

    public Integer getIdentificadorDeDocumentoLegal() {
        return identificadorDeDocumentoLegal;
    }

    public void setIdentificadorDeDocumentoLegal(Integer identificadorDeDocumentoLegal) {
        this.identificadorDeDocumentoLegal = identificadorDeDocumentoLegal;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getACasada() {
        return aCasada;
    }

    public void setACasada(String aCasada) {
        this.aCasada = aCasada;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public Integer getInactivo() {
        return inactivo;
    }

    public void setInactivo(Integer inactivo) {
        this.inactivo = inactivo;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDireccionOficina() {
        return direccionOficina;
    }

    public void setDireccionOficina(String direccionOficina) {
        this.direccionOficina = direccionOficina;
    }

    public String getTelefonoOficina() {
        return telefonoOficina;
    }

    public void setTelefonoOficina(String telefonoOficina) {
        if (telefonoOficina != null) {
            this.telefonoOficina = telefonoOficina.replaceAll("\\W+", "");
        } else {
            this.telefonoOficina = telefonoOficina;
        }
    }

    public String getEstadoOProvincia() {
        return estadoOProvincia;
    }

    public void setEstadoOProvincia(String estadoOProvincia) {
        this.estadoOProvincia = estadoOProvincia;
    }

    public String getLecturaDeFirma() {
        return lecturaDeFirma;
    }

    public void setLecturaDeFirma(String lecturaDeFirma) {
        this.lecturaDeFirma = lecturaDeFirma;
    }

    public String getNumeroDocumentoLegal() {
        return numeroDocumentoLegal;
    }

    public void setNumeroDocumentoLegal(String numeroDocumentoLegal) {
        if (numeroDocumentoLegal != null) {
            this.numeroDocumentoLegal = numeroDocumentoLegal.replaceAll("\\W+", "");
        } else {
            this.numeroDocumentoLegal = numeroDocumentoLegal;
        }
    }

    public String getLugarYFechaExpedicion() {
        return lugarYFechaExpedicion;
    }

    public void setLugarYFechaExpedicion(String lugarYFechaExpedicion) {
        this.lugarYFechaExpedicion = lugarYFechaExpedicion;
    }

    public String getIsssPersonal() {
        return isssPersonal;
    }

    public void setIsssPersonal(String isssPersonal) {
        this.isssPersonal = isssPersonal;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getLugarEntregaDocumentos() {
        return lugarEntregaDocumentos;
    }

    public void setLugarEntregaDocumentos(String lugarEntregaDocumentos) {
        this.lugarEntregaDocumentos = lugarEntregaDocumentos;
    }

    public Integer getIdentificadorPrimarioOferente() {
        return identificadorPrimarioOferente;
    }

    public void setIdentificadorPrimarioOferente(Integer identificadorPrimarioOferente) {
        this.identificadorPrimarioOferente = identificadorPrimarioOferente;
    }

    public Integer getIdentificadorDelDepartamento() {
        return identificadorDelDepartamento;
    }

    public void setIdentificadorDelDepartamento(Integer identificadorDelDepartamento) {
        if (identificadorDelDepartamento != null) {
            this.identificadorDelDepartamento = identificadorDelDepartamento;
        }
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        if (idMunicipio != null) {
            this.idMunicipio = idMunicipio;
        }
    }

    @Override
    public String toString() {
        return "entidades.Persona[ identificadorDeLaPersona=" + identificadorDeLaPersona + " ]";
    }

    @Override
    public String generarInsertSQL() {
        return "INSERT INTO dbo.Persona (identificadorDeGenero,primerApellido,segundoApellido,primerNombre,segundoNombre,fechaDeNacimiento,numeroDeDui,"
                + "numeroDeNit,numeroTelefono,numeroCelular,Domicilio,identificadorDeDocumentoLegal,profesion,aCasada,eMail,inactivo,canton,direccionOficina,"
                + "telefonoOficina,estadoOProvincia,lecturaDeFirma,numeroDocumentoLegal,lugarYFechaExpedicion,isssPersonal,sitioWeb,name,userName,"
                + "fechaDeInsercion,fechaDeModificacion,fechaDeEliminacion,estadoDeEliminacion,lugarEntregaDocumentos,identificadorPrimarioOferente,identificadorOrigenlCiudadano,identificadorDelDepartamento,id_municipio) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    public String generarUpdateSQL() {
        return "UPDATE dbo.Persona \n"
                + "SET identificadorDeGenero=?,primerApellido=?,segundoApellido=?,primerNombre=?,segundoNombre=?,fechaDeNacimiento=?,numeroDeDui=?,"
                + "numeroDeNit=?,numeroTelefono=?,numeroCelular=?,Domicilio=?,identificadorDeDocumentoLegal=?,profesion=?,aCasada=?,eMail=?,"
                + "inactivo=?,canton=?,direccionOficina=?,telefonoOficina=?,estadoOProvincia=?,lecturaDeFirma=?,numeroDocumentoLegal=?,"
                + "lugarYFechaExpedicion=?,isssPersonal=?,sitioWeb=?,name=?,userName=?, fechaDeInsercion=?,"
                + "fechaDeModificacion=?,fechaDeEliminacion=?,estadoDeEliminacion=?,lugarEntregaDocumentos=?,identificadorPrimarioOferente=?, identificadorOrigenlCiudadano=?, identificadorDelDepartamento=?, id_municipio=?"
                + "WHERE identificadorDeLaPersona = ?";
    }

    @Override
    public Object[] getDatosInsert() {
        return new Object[]{identificadorDeGenero, primerApellido, segundoApellido, primerNombre, segundoNombre, fechaDeNacimiento, numeroDeDui, numeroDeNit, numeroTelefono, numeroCelular,
            domicilio, identificadorDeDocumentoLegal, profesion, aCasada, eMail, inactivo, canton, direccionOficina,
            telefonoOficina, estadoOProvincia, lecturaDeFirma, numeroDocumentoLegal, lugarYFechaExpedicion, isssPersonal, sitioWeb, name, userName,
            fechaDeInsercion, fechaDeModificacion, fechaDeEliminacion, estadoDeEliminacion, lugarEntregaDocumentos, identificadorPrimarioOferente, identificadorOrigenlCiudadano, identificadorDelDepartamento, idMunicipio};
    }

    @Override
    public Object[] getDatosUpdate() {
        return new Object[]{identificadorDeGenero, primerApellido, segundoApellido, primerNombre, segundoNombre, fechaDeNacimiento, numeroDeDui, numeroDeNit, numeroTelefono, numeroCelular,
            domicilio, identificadorDeDocumentoLegal, profesion, aCasada, eMail, inactivo, canton, direccionOficina,
            telefonoOficina, estadoOProvincia, lecturaDeFirma, numeroDocumentoLegal, lugarYFechaExpedicion, isssPersonal, sitioWeb, name, userName,
            fechaDeInsercion, fechaDeModificacion, fechaDeEliminacion, estadoDeEliminacion, lugarEntregaDocumentos, identificadorPrimarioOferente, identificadorOrigenlCiudadano, identificadorDelDepartamento, idMunicipio, identificadorDeLaPersona};
    }

    public Integer getIdentificadorOrigenlCiudadano() {
        return identificadorOrigenlCiudadano;
    }

    public void setIdentificadorOrigenlCiudadano(Integer identificadorOrigenlCiudadano) {
        this.identificadorOrigenlCiudadano = identificadorOrigenlCiudadano;
    }

}
