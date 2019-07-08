/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.modelo;

import java.util.Date;
import sv.gob.mined.apps.bnprove.mvn.dao.PersistenciaDao;

/**
 *
 * @author InfoSoft
 */
public class Empresa implements PersistenciaDao {

    private Integer identificadorPrimarioDeLaEmpresa;
    private java.lang.String nombreComercial;
    private java.lang.String razonSocial;
    private java.lang.String numeroDeNit;
    private java.lang.String direccionCompleta;
    private java.lang.String numeroIVA;
    private java.lang.String numeroIsssPatronal;
    private java.lang.String numeroDeRegistroDeComercio;
    private java.lang.String estadoOProvincia;
    private java.lang.String razonSocialSegunEscritura;
    private java.lang.String abreviaturaSegunEscritura;
    private java.util.Date fechaDeConstitucion;
    private Integer regimenDeAdministracion;
    private java.lang.String correoElectronico;
    private java.lang.String sitioWeb;
    private java.lang.String telefonos;
    private java.lang.String fax;
    private java.lang.String numeroDeCelular;
    private Integer tipoDeEstablecimiento;
    private Integer esContribuyente;
    private Integer estadoDeRegistro = 1;
    private Integer identificadorDePersoneria;
    private java.util.Date fechaDeInsercion;
    private java.util.Date fechaDeModificacion;
    private java.util.Date fechaDeEliminacion;
    private Integer estadoDeEliminacion;
    private java.lang.String name;
    private Integer identificadorDelDepartamento;
    private Integer idMunicipio;
    private Integer identificadorPrimarioOferente;
    private String pais;
    private String giroEmpresa;
    private Boolean contribuyente;
    private Integer clasificacionEmpresaTamano;

    public Empresa() {
    }

    public Integer getIdentificadorPrimarioDeLaEmpresa() {
        return identificadorPrimarioDeLaEmpresa;
    }

    public void setIdentificadorPrimarioDeLaEmpresa(Integer identificadorPrimarioDeLaEmpresa) {
        this.identificadorPrimarioDeLaEmpresa = identificadorPrimarioDeLaEmpresa;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNumeroDeNit() {
        return numeroDeNit;
    }

    public void setNumeroDeNit(String numeroDeNit) {
        this.numeroDeNit = numeroDeNit;
    }

    public String getDireccionCompleta() {
        return direccionCompleta;
    }

    public void setDireccionCompleta(String direccionCompleta) {
        this.direccionCompleta = direccionCompleta;
    }

    public String getNumeroIVA() {
        return numeroIVA;
    }

    public void setNumeroIVA(String numeroIVA) {
        this.numeroIVA = numeroIVA;
    }

    public String getNumeroIsssPatronal() {
        return numeroIsssPatronal;
    }

    public void setNumeroIsssPatronal(String numeroIsssPatronal) {
        this.numeroIsssPatronal = numeroIsssPatronal;
    }

    public String getNumeroDeRegistroDeComercio() {
        return numeroDeRegistroDeComercio;
    }

    public void setNumeroDeRegistroDeComercio(String numeroDeRegistroDeComercio) {
        this.numeroDeRegistroDeComercio = numeroDeRegistroDeComercio;
    }

    public String getEstadoOProvincia() {
        return estadoOProvincia;
    }

    public void setEstadoOProvincia(String estadoOProvincia) {
        this.estadoOProvincia = estadoOProvincia;
    }

    public String getRazonSocialSegunEscritura() {
        return razonSocialSegunEscritura;
    }

    public void setRazonSocialSegunEscritura(String razonSocialSegunEscritura) {
        this.razonSocialSegunEscritura = razonSocialSegunEscritura;
    }

    public String getAbreviaturaSegunEscritura() {
        return abreviaturaSegunEscritura;
    }

    public void setAbreviaturaSegunEscritura(String abreviaturaSegunEscritura) {
        this.abreviaturaSegunEscritura = abreviaturaSegunEscritura;
    }

    public Date getFechaDeConstitucion() {
        return fechaDeConstitucion;
    }

    public void setFechaDeConstitucion(Date fechaDeConstitucion) {
        this.fechaDeConstitucion = fechaDeConstitucion;
    }

    public Integer getRegimenDeAdministracion() {
        return regimenDeAdministracion;
    }

    public void setRegimenDeAdministracion(Integer regimenDeAdministracion) {
        this.regimenDeAdministracion = regimenDeAdministracion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getNumeroDeCelular() {
        return numeroDeCelular;
    }

    public void setNumeroDeCelular(String numeroDeCelular) {
        this.numeroDeCelular = numeroDeCelular;
    }

    public Integer getTipoDeEstablecimiento() {
        return tipoDeEstablecimiento;
    }

    public void setTipoDeEstablecimiento(Integer tipoDeEstablecimiento) {
        this.tipoDeEstablecimiento = tipoDeEstablecimiento;
    }

    public Integer getEsContribuyente() {
        return esContribuyente;
    }

    public void setEsContribuyente(Integer esContribuyente) {
        this.esContribuyente = esContribuyente;
    }

    public Integer getEstadoDeRegistro() {
        return estadoDeRegistro;
    }

    public void setEstadoDeRegistro(Integer estadoDeRegistro) {
        this.estadoDeRegistro = estadoDeRegistro;
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

    public Integer getIdentificadorPrimarioOferente() {
        return identificadorPrimarioOferente;
    }

    public void setIdentificadorPrimarioOferente(Integer identificadorPrimarioOferente) {
        this.identificadorPrimarioOferente = identificadorPrimarioOferente;
    }

    @Override
    public String generarInsertSQL() {
        String query = "INSERT INTO dbo.Empresa (identificadorPrimarioOferente, nombreComercial, razonSocial, numeroDeNit, direccionCompleta, numeroIVA, numeroIsssPatronal, numeroDeRegistroDeComercio, estadoOProvincia, razonSocialSegunEscritura, abreviaturaSegunEscritura, fechaDeConstitucion, regimenDeAdministracion, correoElectronico, sitioWeb, telefonos, fax, numeroDeCelular, tipoDeEstablecimiento, esContribuyente, estadoDeRegistro, identificadorDePersoneria, fechaDeInsercion, fechaDeModificacion, fechaDeEliminacion, estadoDeEliminacion, name, identificadorDelDepartamento, id_Municipio, pais, giroEmpresa, clasificacionEmpresaTamano) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return query;
    }

    @Override
    public String generarUpdateSQL() {
        return "UPDATE dbo.Empresa "
                + " SET identificadorPrimarioOferente=?, nombreComercial=?, razonSocial=?, numeroDeNit=?, direccionCompleta=?, numeroIVA=?, numeroIsssPatronal=?,"
                + " numeroDeRegistroDeComercio=?, estadoOProvincia=?, razonSocialSegunEscritura=?, abreviaturaSegunEscritura=?, fechaDeConstitucion=?,"
                + " regimenDeAdministracion=?, correoElectronico=?, sitioWeb=?, telefonos=?, fax=?, numeroDeCelular=?, tipoDeEstablecimiento=?, esContribuyente=?,"
                + " estadoDeRegistro=?, identificadorDePersoneria=?, fechaDeInsercion=?, fechaDeModificacion=?, fechaDeEliminacion=?, estadoDeEliminacion=?, name=?,"
                + " identificadorDelDepartamento=?, id_Municipio=?, pais=?, giroEmpresa=?, clasificacionEmpresaTamano=?"
                + "WHERE identificadorPrimarioDeLaEmpresa =?";
    }

    @Override
    public Object[] getDatosInsert() {
        return new Object[]{identificadorPrimarioOferente, nombreComercial, razonSocial, numeroDeNit, direccionCompleta, numeroIVA, numeroIsssPatronal, numeroDeRegistroDeComercio, estadoOProvincia, razonSocialSegunEscritura, abreviaturaSegunEscritura, fechaDeConstitucion, regimenDeAdministracion, correoElectronico, sitioWeb, telefonos, fax, numeroDeCelular, tipoDeEstablecimiento, esContribuyente, estadoDeRegistro, identificadorDePersoneria, fechaDeInsercion, fechaDeModificacion, fechaDeEliminacion, estadoDeEliminacion, name, identificadorDelDepartamento, idMunicipio, pais, giroEmpresa, clasificacionEmpresaTamano};
    }

    @Override
    public Object[] getDatosUpdate() {
        return new Object[]{identificadorPrimarioOferente, nombreComercial, razonSocial, numeroDeNit, direccionCompleta, numeroIVA, numeroIsssPatronal, numeroDeRegistroDeComercio, estadoOProvincia, razonSocialSegunEscritura, abreviaturaSegunEscritura, fechaDeConstitucion, regimenDeAdministracion, correoElectronico, sitioWeb, telefonos, fax, numeroDeCelular, tipoDeEstablecimiento, esContribuyente, estadoDeRegistro, identificadorDePersoneria, fechaDeInsercion, fechaDeModificacion, fechaDeEliminacion, estadoDeEliminacion, name, identificadorDelDepartamento, idMunicipio, pais, giroEmpresa, clasificacionEmpresaTamano, identificadorPrimarioDeLaEmpresa};
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getGiroEmpresa() {
        return giroEmpresa;
    }

    public void setGiroEmpresa(String giroEmpresa) {
        this.giroEmpresa = giroEmpresa;
    }

    public Boolean getContribuyente() {
        return esContribuyente == 1;
    }

    public Integer getClasificacionEmpresaTamano() {
        return clasificacionEmpresaTamano;
    }

    public void setClasificacionEmpresaTamano(Integer clasificacionEmpresaTamano) {
        this.clasificacionEmpresaTamano = clasificacionEmpresaTamano;
    }

    public void setContribuyente(Boolean contribuyente) {
        this.contribuyente = contribuyente;
        if (contribuyente) {
            esContribuyente = 1;
        } else {
            esContribuyente = 0;
        }
    }
}
