/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.managedbeans;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import org.primefaces.PrimeFaces;
import org.primefaces.component.inputmask.InputMask;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.DefaultTreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import sv.gob.mined.apps.bnprove.mvn.bo.ProveedoresBo;
import sv.gob.mined.apps.bnprove.mvn.modelo.ClasificacionEmpresaEconomico;
import sv.gob.mined.apps.bnprove.mvn.modelo.ClasificacionEmpresaTamano;
import sv.gob.mined.apps.bnprove.mvn.modelo.CoberturaTerritorio;
import sv.gob.mined.apps.bnprove.mvn.modelo.Departamento;
import sv.gob.mined.apps.bnprove.mvn.modelo.Empresa;
import sv.gob.mined.apps.bnprove.mvn.modelo.EstadoDeRegistro;
import sv.gob.mined.apps.bnprove.mvn.modelo.Genero;
import sv.gob.mined.apps.bnprove.mvn.modelo.Municipio;
import sv.gob.mined.apps.bnprove.mvn.modelo.OrigenDelCiudadano;
import sv.gob.mined.apps.bnprove.mvn.modelo.Pais;
import sv.gob.mined.apps.bnprove.mvn.modelo.Persona;
import sv.gob.mined.apps.bnprove.mvn.modelo.RegimenDeAdministracion;
import sv.gob.mined.apps.bnprove.mvn.modelo.SectorEconomico;
import sv.gob.mined.apps.bnprove.mvn.modelo.TipoDePersoneria;
import sv.gob.mined.apps.bnprove.mvn.modelo.TiposDeDocumentoLegal;
import sv.gob.mined.apps.bnprove.mvn.util.ArbolRecursivo;
import sv.gob.mined.apps.bnprove.mvn.util.JsfUtil;

/**
 *
 * @author Infosoft
 */
@Component(value = "registroBean")
@Scope(value = "view")
public class RegistroBean {

    private Integer idEmpresa;
    private Integer idDepto;
    private Persona currentPersona;
    private Empresa currentEmpresa;
    private List<String> departamentosUbicacion = new ArrayList<>();
    private List<CoberturaTerritorio> lstCobertura;
    private List<SectorEconomico> lstSubSector;
    private List<ClasificacionEmpresaEconomico> lstClasificacion;
    private Integer idGenero;
    private Integer idTipoDoc;
    private Integer idPersoneria;
    private String codPais;
    private Integer idOrigen;
    private Integer idEstadoReg;
    private Integer idSector;
    private Integer idSubSector;
    private String espClasificacion;
    private Integer idRegimen;
    private Short numPaso = 0;
    private DefaultTreeNode arbol;
    private Boolean especificacion = false;
    private SectorEconomico subSector;
    private List<String> tipoServicio;
    private String hostname, smtp_port, user, pass, remitente;
    /**
     * variables de funcionalidad
     */
    private boolean skip;
    private boolean mostrarPnlJuridica = false;
    private boolean mostrarDeptoMunic = false;
    private boolean mostrarDeptoMunicPersona = false;
    private String paso1 = "../../resources/images/personas_enable.png";
    private String paso2 = "../../resources/images/empresa_enable.png";
    private String paso3 = "../../resources/images/ubicacion_enable.png";
    private String paso4 = "../../resources/images/productos_enable.png";
    private Boolean disable = false;
    private String usuario;
    private String tituloWizard = "1 - Persona o Representante Legal";
    @Autowired
    private ProveedoresBo provBo;

    /**
     * Creates a new instance of registroBean
     */
    public RegistroBean() {
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context != null) {
            if (context.getExternalContext().getSessionMap().containsKey(JsfUtil.sUsuario)) {
                usuario = context.getExternalContext().getSessionMap().get(JsfUtil.sUsuario).toString();
                Integer idPersona = (Integer) context.getExternalContext().getSessionMap().get(JsfUtil.sIdPersona);
                currentPersona = provBo.findPersonaById(idPersona);
                //idDepto = currentPersona.getIdentificadorDelDepartamento();
                currentEmpresa = provBo.findEmpresaByIdOferente(currentPersona.getIdentificadorPrimarioOferente());

                if (currentEmpresa == null) {
                    currentEmpresa = new Empresa();
                    currentEmpresa.setEsContribuyente(0);
                    currentEmpresa.setRegimenDeAdministracion(1);
                    currentEmpresa.setTipoDeEstablecimiento(1);
                } else {
                    idPersoneria = currentEmpresa.getIdentificadorDePersoneria();
                    this.tipoPersoneria();
                    this.tipoDomicilio();
                    this.tipoOrigen();

                    //cargar Cobertura
                    this.cargarCobertura(currentEmpresa.getIdentificadorPrimarioDeLaEmpresa());

                    this.cargarOferta(currentEmpresa.getIdentificadorPrimarioDeLaEmpresa());
                }
            }
        }
    }

    private void cargarCobertura(Integer idEmpresa) {
        lstCobertura = provBo.findAllCobertura(idEmpresa);
        departamentosUbicacion = new ArrayList<>();

        if (lstCobertura == null) {
            lstCobertura = new ArrayList<>();
        } else {
            for (CoberturaTerritorio coberturaTerritorio : lstCobertura) {
                departamentosUbicacion.add(coberturaTerritorio.getIdentificadorDelDepartamento().toString());
            }
        }
    }

    private void cargarOferta(Integer idEmpresa) {
        lstClasificacion = provBo.findAllClasificacion(idEmpresa);
    }

   
    public String getEstadoRegistro() {
        List<EstadoDeRegistro> lst = getLstEstadoRegistros();
        for (EstadoDeRegistro estadoDeRegistro : lst) {
            if (estadoDeRegistro.getIdentificadorDelEstadoDeRegistro() == getCurrentEmpresa().getEstadoDeRegistro()) {
                return estadoDeRegistro.getDescripcionDeEstado();
            }
        }
        return "";
    }

    public void prepareCreate() {
        disable = false;
        currentPersona = new Persona();
    }

    public String onFlowProcess(FlowEvent event) {
        numPaso = Short.parseShort(event.getNewStep().replace("paso", ""));

        if (skip) {
            skip = false;   //reset in case user goes back  
            return "confirm";
        } else {
            if (event.getNewStep().equals("paso1")) {
                tituloWizard = "1 - Persona o Representante Legal";
            }
            if (event.getNewStep().equals("paso2")) {
                tituloWizard = "2 - Empresa";
            }
            if (event.getNewStep().equals("paso3")) {
                tituloWizard = "3 - Ubicación";
            }
            if (event.getNewStep().equals("paso4")) {
                tituloWizard = "4 - Que Ofrece";
            }
            if (event.getOldStep().equals("paso4")) {
            }

            PrimeFaces.current().ajax().update("frmPrincipal:tituloWizard");
            //RequestContext.getCurrentInstance().update("frmPrincipal:tituloWizard");
            return event.getNewStep();
        }
    }

    public void tipoPersoneria() {
        mostrarPnlJuridica = (currentEmpresa.getIdentificadorDePersoneria() == 2);
        if (currentEmpresa.getIdentificadorDePersoneria() == 1) {
            currentEmpresa.setRegimenDeAdministracion(6);
        }
    }

    public void tipoDomicilio() {
        mostrarDeptoMunic = (!"SV".equals(currentEmpresa.getPais()));
        
        if (mostrarDeptoMunic){
            currentEmpresa.setIdentificadorDelDepartamento(16);
            currentEmpresa.setIdMunicipio(266);
        }
        else
        {
            currentEmpresa.setIdentificadorDelDepartamento(null);
            currentEmpresa.setIdMunicipio(null);
        } 
        
    }

    public void tipoOrigen() {
        mostrarDeptoMunicPersona = (currentPersona.getIdentificadorOrigenlCiudadano() != 1);
  
        if (currentPersona.getIdentificadorOrigenlCiudadano() != 1){
            currentPersona.identificadorDelDepartamento = 16;
            currentPersona.idMunicipio = 266;
        }
        
    }

    public void cambioPersoneria() {
        if (currentEmpresa.getIdentificadorDePersoneria() == 1) {
            currentEmpresa.setDireccionCompleta(currentPersona.getDomicilio());
            currentEmpresa.setCorreoElectronico(currentPersona.getEMail());
            currentEmpresa.setTelefonos(currentPersona.getNumeroTelefono());
            currentEmpresa.setIdMunicipio(currentPersona.getIdMunicipio());
            currentEmpresa.setIdentificadorDelDepartamento(currentPersona.getIdentificadorDelDepartamento());
            currentEmpresa.setNumeroDeCelular(currentPersona.getNumeroCelular());
            currentEmpresa.setNombreComercial(currentPersona.getPrimerNombre() + ' ' + currentPersona.getSegundoNombre() + ' ' + currentPersona.getPrimerApellido() + ' ' + currentPersona.getSegundoApellido()+ ' ' + currentPersona.getACasada());
            currentEmpresa.setRazonSocial(currentPersona.getPrimerNombre() + ' ' + currentPersona.getSegundoNombre() + ' ' + currentPersona.getPrimerApellido() + ' ' + currentPersona.getSegundoApellido()+ ' ' + currentPersona.getACasada());
            currentEmpresa.setRegimenDeAdministracion(6);
        } else {
            currentEmpresa.setDireccionCompleta("");
            currentEmpresa.setCorreoElectronico("");
            currentEmpresa.setTelefonos("");
            currentEmpresa.setIdMunicipio(0);
            currentEmpresa.setIdentificadorDelDepartamento(0);
            currentEmpresa.setNumeroDeCelular("");
            currentEmpresa.setNombreComercial("");
            currentEmpresa.setRazonSocial("");
            currentEmpresa.setRegimenDeAdministracion(1);
        }

    }

    public void abrirAsistente() {
        String paso = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("opcion");
        PrimeFaces.current().executeScript("PF('wzRegistro').loadStep(PF('wzRegistro').cfg.steps[" + paso + "], false)");
        PrimeFaces.current().executeScript("PF('dlgPersonas').show();");
    }

    public void cambioUbicacion(ValueChangeEvent event) {
        if (event.getOldValue() != null) {
            if (!((ArrayList<String>) event.getOldValue()).contains("0") && ((ArrayList<String>) event.getNewValue()).contains("0")) {
                departamentosUbicacion.clear();
                ((ArrayList<String>) event.getNewValue()).clear();
                ((ArrayList<String>) event.getNewValue()).add("0");
            } else if (((ArrayList<String>) event.getOldValue()).contains("0") && ((ArrayList<String>) event.getOldValue()).size() == 1
                    && ((ArrayList<String>) event.getNewValue()).indexOf("0") != 0) {
                String codDepa = ((ArrayList<String>) event.getNewValue()).get(0);
                departamentosUbicacion.clear();
                ((ArrayList<String>) event.getNewValue()).clear();
                ((ArrayList<String>) event.getNewValue()).add(codDepa);
            }
        }
    }

    public void validarDepartamento() {
        if (!currentPersona.getIdentificadorDelDepartamento().equals("06")) {
            System.out.println("no ha seleccionado san salvador");
        }
    }

    public void guardar() {
        if (guardarPersona()) {
            Boolean correcto = guardadoEnCascada();

            if (correcto) {
                JsfUtil.addSuccessMessage("Registro almacenado satisfactoriamente");
            }
        }
    }

    private Boolean guardadoEnCascada() {
        Boolean correcto;
        correcto = guardarEmpresa();
        if (correcto) {
            correcto = guardarUbicacion();
        }
        if (correcto) {
            guardarOferta();
        }

        return correcto;
    }

    private Boolean guardarPersona() {
        Boolean valor = isValidaPersona();
        if (valor) {
            if (currentPersona.getIdentificadorDeLaPersona() != null) {
                currentPersona.setFechaDeModificacion(new Date());
                currentEmpresa.setEstadoDeEliminacion(0);
                if (currentEmpresa.getEstadoDeRegistro() != 6) {
                    currentEmpresa.setEstadoDeRegistro(4);
                }
            } else {
                currentPersona.setFechaDeInsercion(new Date());
            }
            provBo.savePersona(currentPersona);
        } else {
            JsfUtil.addErrorMessage("Los campos marcados con rojo son REQUERIDOS");
            abrirTab("0");
        }
        return valor;
    }

    private Boolean guardarEmpresa() {
        Boolean valido = isValidaEmpresa();
        if (valido) {
            if (currentEmpresa.getIdentificadorPrimarioDeLaEmpresa() != null) {
                currentEmpresa.setFechaDeModificacion(new Date());
                if (currentEmpresa.getEstadoDeRegistro() != 6) {
                    currentEmpresa.setEstadoDeRegistro(4);
                }
            } else {
                currentEmpresa.setFechaDeInsercion(new Date());
                currentEmpresa.setIdentificadorPrimarioOferente(currentPersona.getIdentificadorPrimarioOferente());
            }
            if (currentEmpresa.getIdentificadorDePersoneria() == 1) {
                currentEmpresa.setNumeroDeNit(currentPersona.getNumeroDeNit());
                currentEmpresa.setRazonSocial(currentEmpresa.getNombreComercial());
                currentEmpresa.setCorreoElectronico(currentPersona.getEMail());
            }
            provBo.saveEmpresa(currentEmpresa);
        } else {
            JsfUtil.addErrorMessage("Los campos marcados con rojo son REQUERIDOS");
            abrirTab("1");
        }
        return valido;
    }

    private Boolean guardarUbicacion() {
        Boolean valido = true;
        if (departamentosUbicacion != null && !departamentosUbicacion.isEmpty()) {
            for (CoberturaTerritorio cobertura : getLstCobertura()) {
                cobertura.setEstadoDeEliminacion(1);
            }

            for (String codDepa : departamentosUbicacion) {
                Boolean existe = false;
                for (CoberturaTerritorio cobertura : lstCobertura) {
                    if (cobertura.getIdentificadorDelDepartamento() == Integer.parseInt(codDepa)) {
                        cobertura.setEstadoDeEliminacion(0);
                        existe = true;
                        break;
                    }
                }

                if (!existe) {
                    CoberturaTerritorio cobertura = new CoberturaTerritorio();
                    cobertura.setIdentificadorDelDepartamento(codDepa.equals("0") ? 15 : Integer.parseInt(codDepa));
                    cobertura.setFechaDeInsercion(new Date());
                    cobertura.setEstadoDeEliminacion(0);
                    cobertura.setIdentificadorPrimarioDeLaEmpresa(currentEmpresa.getIdentificadorPrimarioDeLaEmpresa());

                    lstCobertura.add(cobertura);
                }
            }

            if (!lstCobertura.isEmpty()) {
                for (CoberturaTerritorio cobertura : lstCobertura) {
                    provBo.saveCobertura(cobertura);
                }

                cargarCobertura(currentEmpresa.getIdentificadorPrimarioDeLaEmpresa());
            }
        } else {
            JsfUtil.addErrorMessage("Debe de seleccionar al menos un departamento");
            abrirTab("2");
            valido = false;
        }
        return valido;
    }

    private void guardarOferta() {
        for (ClasificacionEmpresaEconomico clasificacionEmp : getLstClasificacion()) {
            provBo.saveClasificacionEmpresa(clasificacionEmp);
            if (currentEmpresa.getEstadoDeRegistro() != 6) {
                currentEmpresa.setEstadoDeRegistro(2);
            }
            provBo.saveEmpresa(currentEmpresa);
        }
    }

    public void agregarClasificacion() {
        if (idSector != null && idSector != 0 && idSubSector != null && idSubSector != 0) {
            Boolean existe = false;
            for (ClasificacionEmpresaEconomico cla : getLstClasificacion()) {
                if (cla.getIdentificadorDelSectorEconomico().equals(idSubSector) && !subSector.getDescripcionDelSectorEconomico().contains("No aparece")) {
                    existe = true;
                    JsfUtil.addErrorMessage("Ya existe este subsector asociado...");
                    break;
                }
            }

            if (!existe) {
                ClasificacionEmpresaEconomico clasificacion = new ClasificacionEmpresaEconomico();

                if (subSector.getDescripcionDelSectorEconomico().contains("No aparece")) {
                    clasificacion.setEspecializacionPorSubsector(espClasificacion);
                } else {
                    clasificacion.setEspecializacionPorSubsector(subSector.getDescripcionDelSectorEconomico());
                }
                clasificacion.setIdentificadorDelSectorEconomico(idSubSector);
                clasificacion.setIdentificadorPrimarioDeLaEmpresa(currentEmpresa.getIdentificadorPrimarioDeLaEmpresa());
                clasificacion.setEstadoDeEliminacion(0);
                clasificacion.setFechaDeInsercion(new Date());
                clasificacion.setTipoServicio(tipoServicio);
                clasificacion.setName("admin");
                
                if (!tipoServicio.isEmpty()){
                    lstClasificacion.add(clasificacion);
                }else{
                    JsfUtil.addErrorStyle("frmPrincipal", "tipoServicio", InputText.class, clasificacion.getTipoServicio());
                }
                    
            }

            especificacion = false;
            idSector = null;
            idSubSector = null;
            subSector = null;
            espClasificacion = "";
        }
    }

    public List<SectorEconomico> getLstSubSector() {
        List<SectorEconomico> tmpLstSubSector = provBo.findAllSubSectorEconomico(idSector);
        for (ClasificacionEmpresaEconomico cla : getLstClasificacion()) {
            for (int i = 0; i < tmpLstSubSector.size(); i++) {
                SectorEconomico tmpSubSector = (SectorEconomico) tmpLstSubSector.get(i);
                if (cla.getIdentificadorDelSectorEconomico().equals(tmpSubSector.getIdentificadorDelSectorEconomico())) {

                    if (!tmpSubSector.getDescripcionDelSectorEconomico().contains("No aparece")) {
                        tmpLstSubSector.remove(i);
                    }
                    break;
                }
            }
        }
        lstSubSector = tmpLstSubSector;
        return lstSubSector;
    }

    public void activarEspecificacion() {
        for (SectorEconomico ss : lstSubSector) {
            if (ss.getIdentificadorDelSectorEconomico().equals(idSubSector)) {
                subSector = ss;

                if (ss.getDescripcionDelSectorEconomico().contains("No aparece")) {
                    especificacion = true;
                    break;
                } else {
                    especificacion = false;
                }
            }
        }
    }

    public Boolean isValidaPersona() {
        Boolean valido = true;
        if (currentPersona != null) {
            valido = JsfUtil.addErrorStyle("frmPrincipal", "cbGenero", SelectOneMenu.class, currentPersona.getIdentificadorDeGenero());
            valido = JsfUtil.addErrorStyle("frmPrincipal", "txtPriNombre", InputText.class, currentPersona.getPrimerNombre()) && valido;
            valido = JsfUtil.addErrorStyle("frmPrincipal", "txtPriApellido", InputText.class, currentPersona.getPrimerApellido()) && valido;
            valido = JsfUtil.addErrorStyle("frmPrincipal", "txtDomicilio", InputText.class, currentPersona.getDomicilio()) && valido;
            valido = JsfUtil.addErrorStyle("frmPrincipal", "txtTelPersona", InputMask.class, currentPersona.getNumeroTelefono()) && valido;
            valido = JsfUtil.addErrorStyle("frmPrincipal", "cbOrigen", SelectOneMenu.class, currentPersona.getIdentificadorOrigenlCiudadano()) && valido;
            valido = JsfUtil.addErrorStyle("frmPrincipal", "cbTipoDoc", SelectOneMenu.class, currentPersona.getIdentificadorDeDocumentoLegal()) && valido;
            valido = JsfUtil.addErrorStyle("frmPrincipal", "txtNumDoc", InputText.class, currentPersona.getNumeroDocumentoLegal()) && valido;
            valido = JsfUtil.addErrorStyle("frmPrincipal", "txtNitPersona", InputMask.class, currentPersona.getNumeroDeNit()) && valido;
            if (currentPersona.getIdentificadorOrigenlCiudadano() == 1) {
                valido = JsfUtil.addErrorStyle("frmPrincipal", "cbDepaPersona", SelectOneMenu.class, currentPersona.getIdentificadorDelDepartamento()) && valido;
                valido = JsfUtil.addErrorStyle("frmPrincipal", "cbMuniPersona", SelectOneMenu.class, currentPersona.getIdMunicipio()) && valido;
            }
        }
        return valido;
    }

    public Boolean isValidaEmpresa() {
        Boolean valido = true;

        if (currentEmpresa != null) {
            valido = JsfUtil.addErrorStyle("frmPrincipal", "cbPersoneria", SelectOneMenu.class, currentEmpresa.getIdentificadorDePersoneria());
            valido = JsfUtil.addErrorStyle("frmPrincipal", "cbPais", SelectOneMenu.class, currentEmpresa.getPais()) && valido;

            if (currentEmpresa.getContribuyente()) {
                valido = JsfUtil.addErrorStyle("frmPrincipal", "txtNoIva", InputText.class, currentEmpresa.getNumeroIva()) && valido;
            }
            if ("SV".equals(currentEmpresa.getPais())) {
                valido = JsfUtil.addErrorStyle("frmPrincipal", "cbDepartamentoEmp", SelectOneMenu.class, currentEmpresa.getIdentificadorDelDepartamento()) && valido;
                valido = JsfUtil.addErrorStyle("frmPrincipal", "cbMunicipioEmp", SelectOneMenu.class, currentEmpresa.getIdMunicipio()) && valido;
            }

            valido = JsfUtil.addErrorStyle("frmPrincipal", "txtDireccion", InputText.class, currentEmpresa.getDireccionCompleta()) && valido;
            valido = JsfUtil.addErrorStyle("frmPrincipal", "txtRazonSocial", InputText.class, currentEmpresa.getRazonSocial()) && valido;
        }
        return valido;
    }
    
    public void imprimir() {
        try {
            byte[] content;
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            content = imprimirFicha();
            response.setContentType("application/pdf");
            response.setContentLength(content == null ? 0 : content.length);
            response.getOutputStream().write(content);
            response.getOutputStream().flush();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (SQLException ex) {
            Logger.getLogger(RegistroBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(RegistroBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegistroBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public byte[] imprimirFicha() throws SQLException, JRException {
        ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String reportPath = ctx.getRealPath(JsfUtil.PATH_REPORTES);
        HashMap param = new HashMap();
        param.put("SUBREPORT_DIR", reportPath + File.separator);
        param.put("ubicacionImagenes", ctx.getRealPath(JsfUtil.PATH_IMAGENES));
        param.put("identificadorPrimarioDeLaEmpresa", idEmpresa);

        return JasperRunManager.runReportToPdf(reportPath + File.separator + "fichaOferente.jasper", param, jdbcTemplate.getDataSource().getConnection());
    }
    
    public static boolean validaNit( String nit ){//Creamos metodo estatico para poderlo llamar en cualquier parte; pedimos como datos una cadena string donde se aloja el nit
        int calculo = 0;//Variable para llevar el control de la suma del algoritmo
        int digitos = Integer.parseInt(nit.substring(12, 15));//Tomamos los digitos que estan entre la posicion 12 y 15
        boolean resultado;
        
        if ( digitos <= 100 ) {//Verificamos que estos digitos sean menores o iguales a 100
            for ( int posicion = 0; posicion <= 14; posicion++ ) {//Ciclo que nos ayuda a ir aumentando la posicion que se utiliza posteriormente en el algoritmo
                if ( !( posicion == 4 || posicion == 11 ) ){
                    calculo += ( 14 * (int) ( Character.getNumericValue( nit.charAt( posicion ) ) ) );
                }//Si la posicion no es 4 ni 11 (que son los guiones) se ejecuta esta operacion
      
                calculo = calculo % 11;//Al calculo se le va sacando el modular de 11
            }
        } else {
            int n = 1;//Variable contadora
            
            for ( int posicion = 0; posicion <= 14; posicion++ ){//Ciclo que nos ayuda a ir aumentando la posicion que se utiliza posteriormente en el algoritmo
                if ( !( posicion == 4 || posicion == 11 ) ){
                    calculo = (int) ( calculo + ( ( (int) Character.getNumericValue( nit.charAt( posicion ) ) ) * ( ( 3 + 6 * Math.floor( Math.abs( ( n + 4) / 6 ) ) ) - n ) ) );
                    n++;
                }//Si la posicion no es 4 ni 11 (que son los guiones) se ejecuta esta operacion
            }
            
            calculo = calculo % 11;//sacamos el modular 11 de calculo
            
            if ( calculo > 1 ){
                calculo = 11 - calculo;//Si el resultado nos da mayor a uno se le resta a 11 esta respuesta
            } else {
                calculo = 0;//Sino el calculo lo hacemos 0
            }
        }
        resultado = (calculo == (int) ( Character.getNumericValue( nit.charAt( 16 ) ) ) ); //Verificamos si el calculo es direfente del resultado de nuestro algoritmo, si lo es entonces es falso

        return resultado;//enviamos el resultado
    }
  
    
    public void ConfiguracionMail() {
        hostname =    "aaa";
        smtp_port =   "aaaaa";
        user =        "aaa";
        pass =        "aaa";
        remitente =   "aaaa";
    } 

    public Integer getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(Integer idDepto) {
        this.idDepto = idDepto;
    }
    
    public boolean isMostrarPnlJuridica() {
        return mostrarPnlJuridica;
    }

    public void setMostrarPnlJuridica(boolean mostrarPnlJuridica) {
        this.mostrarPnlJuridica = mostrarPnlJuridica;
    }

    public String getPaso1() {
        return paso1;
    }

    public void setPaso1(String paso1) {
        this.paso1 = paso1;
    }

    public String getPaso2() {
        return paso2;
    }

    public void setPaso2(String paso2) {
        this.paso2 = paso2;
    }

    public String getPaso3() {
        return paso3;
    }

    public void setPaso3(String paso3) {
        this.paso3 = paso3;
    }

    public String getPaso4() {
        return paso4;
    }

    public void setPaso4(String paso4) {
        this.paso4 = paso4;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public void setArbol(DefaultTreeNode arbol) {
        this.arbol = arbol;
    }
    
    public Persona getCurrentPersona() {
        if (currentPersona == null) {
            currentPersona = new Persona();
        }
        return currentPersona;
    }

    public void setCurrentPersona(Persona currentPersona) {
        this.currentPersona = currentPersona;
    }

    public Empresa getCurrentEmpresa() {
        if (currentEmpresa == null) {
            currentEmpresa = new Empresa();
            currentEmpresa.setEstadoDeRegistro(1);
            currentEmpresa.setEsContribuyente(0);
        }
        return currentEmpresa;
    }

    public void setCurrentEmpresa(Empresa currenteEmpresa) {
        this.currentEmpresa = currenteEmpresa;
    }

    public List<Departamento> getLstDepaPer() {
        return provBo.findAllDepartamentos();
    }

    public List<Municipio> getLstMunPer() {
        if (currentPersona != null) {
            return provBo.findAllMunicipioByDepartamento(currentPersona.getIdentificadorDelDepartamento());
        } else {
            return null;
        }
    }
    
    public List<String> getDepartamentosUbicacion() {
        return departamentosUbicacion;
    }

    public void setDepartamentosUbicacion(List<String> departamentosUbicacion) {
        this.departamentosUbicacion = departamentosUbicacion;
    }

    public List<Departamento> getLstDepaEmp() {
        return provBo.findAllDepartamentos();
    }

    public List<Municipio> getLstMunEmp() {
        if (currentEmpresa != null) {
            return provBo.findAllMunicipioByDepartamento(currentEmpresa.getIdentificadorDelDepartamento());
        } else {
            return null;
        }
    }

    public List<Genero> getLstGeneros() {
        return provBo.findAllGeneros();
    }

    public List<EstadoDeRegistro> getLstEstadoRegistros() {
        return provBo.findAllEstadoRegistro();
    }

    public List<OrigenDelCiudadano> getLstOrigenCiudadano() {
        return provBo.findAllOrigenDelCiudadano();
    }

    public List<Pais> getLstPaises() {
        return provBo.findAllPais();
    }

    public List<SectorEconomico> getLstSectorEconomico() {
        return provBo.findAllSectorEconomico();
    }

    public void setLstSubSectorEconomico() {
        if (idSector != null) {
            lstSubSector = provBo.findAllSubSectorEconomico(idSector);
        }
    }

    public List<TipoDePersoneria> getLstTipoDePersoneria() {
        return provBo.findAllTipoDePersoneria();
    }

    public List<ClasificacionEmpresaTamano> getLstClasificacionEmpresaTamano() {
        return provBo.findAllEmpresaTamano();
    }

    public List<TiposDeDocumentoLegal> getLstTipoDocLegal() {
        return provBo.findAllTiposDeDocumentoLegal();
    }

    public List<RegimenDeAdministracion> getLstRegimenAdmon() {
        return provBo.findAllRegimenAdministracion();
    }

    public ProveedoresBo getProvBo() {
        return provBo;
    }

    public void setProvBo(ProveedoresBo provBo) {
        this.provBo = provBo;
    }

    public Integer getIdPersoneria() {
        return idPersoneria;
    }

    public void setIdPersoneria(Integer idPersoneria) {
        this.idPersoneria = idPersoneria;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public Integer getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(Integer idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setIdPais(String codPais) {
        this.codPais = codPais;
    }

    public Integer getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(Integer idOrigen) {
        this.idOrigen = idOrigen;
    }

    public Integer getIdEstadoReg() {
        return idEstadoReg;
    }

    public void setIdEstadoReg(Integer idEstadoReg) {
        this.idEstadoReg = idEstadoReg;
    }

    public Integer getIdSector() {
        return idSector;
    }

    public void setIdSector(Integer idSector) {
        this.idSector = idSector;
    }

    public Integer getIdSubSector() {
        return idSubSector;
    }

    public void setIdSubSector(Integer idSubSector) {
        this.idSubSector = idSubSector;
    }

    public Integer getIdRegimen() {
        return idRegimen;
    }

    public void setIdRegimen(Integer idRegimen) {
        this.idRegimen = idRegimen;
    }

    public DefaultTreeNode getArbol() {
        if (arbol == null) {
            arbol = ArbolRecursivo.getArbolTblRecursiva(getLstSectorEconomico(), SectorEconomico.class, "getIdentificadorDelSectorEconomico", "getSec_identificadorDelSectorEconomico");
        }
        return arbol;
    }

    public void armarArbol() {
        //arbol = ArbolRecursivo.getArbolSectorEconomico(getLstSectorEconomico());
    }

    public void setEspClasificacion(String espClasificacion) {
        this.espClasificacion = espClasificacion;
    }

    public Short getNumPaso() {
        return numPaso;
    }

    public void setNumPaso(Short numPaso) {
        this.numPaso = numPaso;
    }

    public List<ClasificacionEmpresaEconomico> getLstClasificacion() {
        if (lstClasificacion == null) {
            lstClasificacion = new ArrayList<>();
        }
        return lstClasificacion;
    }

    public void setLstClasificacion(List<ClasificacionEmpresaEconomico> lstClasificacion) {
        this.lstClasificacion = lstClasificacion;
    }

    public String getEspClasificacion() {
        return espClasificacion;
    }
    
    public List<CoberturaTerritorio> getLstCobertura() {
        if (lstCobertura == null) {
            lstCobertura = new ArrayList<>();
        }
        return lstCobertura;
    }

    public void setLstSubSector(List<SectorEconomico> lstSubSector) {
        this.lstSubSector = lstSubSector;
    }

    public Boolean getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(Boolean especificacion) {
        this.especificacion = especificacion;
    }

    public List<String> getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(List<String> tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

  
    public String getTituloWizard() {
        return tituloWizard;
    }

    public void setTituloWizard(String tituloWizard) {
        this.tituloWizard = tituloWizard;
    }
    
    public void setLstCobertura(List<CoberturaTerritorio> lstCobertura) {
        this.lstCobertura = lstCobertura;
    }

    public boolean isMostrarDeptoMunic() {
        return mostrarDeptoMunic;
    }

    public void setMostrarDeptoMunic(boolean mostrarDeptoMunic) {
        this.mostrarDeptoMunic = mostrarDeptoMunic;
    }

    public boolean isMostrarDeptoMunicPersona() {
        return mostrarDeptoMunicPersona;
    }

    public void setMostrarDeptoMunicPersona(boolean mostrarDeptoMunicPersona) {
        this.mostrarDeptoMunicPersona = mostrarDeptoMunicPersona;
    }
    
    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    private void abrirTab(String numeroTab) {
        PrimeFaces.current().executeScript("frmPrincipal.wzRegistro.loadStep (frmPrincipal.wzRegistro.cfg.steps [" + numeroTab + "], true)");
        PrimeFaces.current().dialog().openDynamic("dlgPersonas");
        //RequestContext.getCurrentInstance().execute("wzRegistro.loadStep (wzRegistro.cfg.steps [" + numeroTab + "], true)");
        //RequestContext.getCurrentInstance().execute("dlgPersonas.show();");
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getSmtp_port() {
        return smtp_port;
    }

    public void setSmtp_port(String smtp_port) {
        this.smtp_port = smtp_port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }
    
}
