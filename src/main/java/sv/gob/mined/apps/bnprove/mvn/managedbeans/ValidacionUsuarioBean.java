/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.managedbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.component.inputmask.InputMask;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sv.gob.mined.apps.bnprove.mvn.bo.ProveedoresBo;
import sv.gob.mined.apps.bnprove.mvn.modelo.Persona;
import sv.gob.mined.apps.bnprove.mvn.modelo.PreguntaValidaUsuario;
import sv.gob.mined.apps.bnprove.mvn.modelo.Usuario;
import sv.gob.mined.apps.bnprove.mvn.util.JsfUtil;
import sv.gob.mined.apps.bnprove.mvn.util.EMailEJB;

/**
 *
 * @author Infosoft
 */
@Component(value = "validacionUsuarioBean")
@Scope(value = "view")
public class ValidacionUsuarioBean {

    private String usuario;
    private String claveDeAcceso;
    private String dui;
    private String email;
    private String respuesta1;
    private String respuesta2;
    private Persona currentPersona;
    private Usuario currentUsuario;
    private Boolean mostrarSignUp= Boolean.FALSE;
    private Boolean mostrarRecuperarCont= Boolean.FALSE;

    
    @Autowired
    private ProveedoresBo provBo;
    private List<PreguntaValidaUsuario> lstPreguntasUsuario = new ArrayList<PreguntaValidaUsuario>();

    public ValidacionUsuarioBean() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClaveDeAcceso() {
        return claveDeAcceso;
    }

    public void setClaveDeAcceso(String claveDeAcceso) {
        this.claveDeAcceso = claveDeAcceso;
    }

    public String validarCredencialesDeAcceso() {
        if (usuario != null && claveDeAcceso != null) {
            Persona per = provBo.findPersonaByUsuarioClave(usuario, claveDeAcceso);

            if (per != null) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().getSessionMap().put(JsfUtil.sUsuario, usuario);
                context.getExternalContext().getSessionMap().put(JsfUtil.sIdPersona, per.getIdentificadorDeLaPersona());

                return "/app/vistas/registro.jsf?faces-redirect=true";
            } else {
                JsfUtil.addErrorMessage("Usuario y/o Clave de acceso erroneas.");
                return null;
            }
        } else {
            JsfUtil.addErrorMessage("Usuario y/o Clave de acceso erroneas.");
            return "";
        }
    }

    public ProveedoresBo getProvBo() {
        return provBo;
    }

    public void setProvBo(ProveedoresBo provBo) {
        this.provBo = provBo;
    }

    public void nuevoUsuario() {
        Boolean valido;
        
        valido = JsfUtil.addErrorStyle("frmPrincipal", "txtPrimerNombre", InputText.class, currentUsuario.getPrimerNombre());
        valido = JsfUtil.addErrorStyle("frmPrincipal", "txtPrimerApellido", InputText.class, currentUsuario.getPrimerApellido())& valido;
        
        valido = JsfUtil.addErrorStyle("frmPrincipal", "txtTelefono", InputMask.class, currentUsuario.getTelefono())& valido;
        valido = JsfUtil.addErrorStyle("frmPrincipal", "txtEmail", InputText.class, currentUsuario.getEMail())& valido;
        
        valido = JsfUtil.addErrorStyle("frmPrincipal", "txtUsuarioDeAcceso", InputText.class, currentUsuario.getUserName())& valido;
        valido = JsfUtil.addErrorStyle("frmPrincipal", "txtPass", InputText.class, currentUsuario.getPassword())& valido;
        
        valido = JsfUtil.addErrorStyle("frmPrincipal", "cbPregunta1", SelectOneMenu.class, currentUsuario.getIdPregunta1())& valido;
        valido = JsfUtil.addErrorStyle("frmPrincipal", "txtRespuesta1", InputText.class, currentUsuario.getRespuesta1())& valido;
        valido = JsfUtil.addErrorStyle("frmPrincipal", "cbPregunta2", SelectOneMenu.class, currentUsuario.getIdPregunta2())& valido;
        valido = JsfUtil.addErrorStyle("frmPrincipal", "txtRespuesta2", InputText.class, currentUsuario.getRespuesta2())& valido;
        
        if(valido ){
            if (provBo.isExistPersonaByUsuario(currentUsuario.getUserName())) {
                JsfUtil.addWarningMessage("Ya existe el nombre de usuario " + currentUsuario.getUserName() + ". Escriba otro nombre de usuario.");
                this.mostrarSignUp = Boolean.TRUE;
            } else {
                currentUsuario.setFechaInsercion(new Date());
                currentUsuario.setEstadoDeEliminacion(0);
                int var = provBo.saveUsuario(currentUsuario);

                if (var != 0) {
                    JsfUtil.addSuccessMessage("Registro completado.");
                    this.mostrarSignUp = Boolean.FALSE;
                    //RequestContext.getCurrentInstance().execute("registroUsuario.show();");
                } else {
                    JsfUtil.addErrorMessage("Ocurrio un error al registrar el nuevo usuario.");
                    this.mostrarSignUp = Boolean.TRUE;
                }
            }
        }else{
            JsfUtil.addErrorMessage("Los campos marcados con rojo son REQUERIDOS");
            this.mostrarSignUp = Boolean.TRUE;
        }
        RequestContext.getCurrentInstance().update("frmPrincipal:registroUsuario");
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

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().clear();
        ExternalContext externalContext = context.getExternalContext();
        Object session = externalContext.getSession(true);
        HttpSession httpSession = (HttpSession) session;
        httpSession.invalidate();
        return "/inicio.jsp?faces-redirect=true";
    }

    public Usuario getCurrentUsuario() {
        if (currentUsuario == null) {
            currentUsuario = new Usuario();
            currentUsuario.setIdPregunta1(getLstPreguntas().get(0).getIdPregunta());
        }
        return currentUsuario;
    }

    public void setCurrentUsuario(Usuario currentUsuario) {
        this.currentUsuario = currentUsuario;
    }

    public List<PreguntaValidaUsuario> getLstPreguntas() {
        return provBo.findAllPreguntas();
    }

    public List<PreguntaValidaUsuario> getLstPreguntas2() {
        return provBo.findAllPreguntasExcepto(currentUsuario.getIdPregunta1());
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    /*public void buscarUsuarioPreguntas() {
        mostrarRecuperarCont = Boolean.TRUE;
        if (dui.replace("_", "").length() >= 9) {
            lstPreguntasUsuario = provBo.findAllByDui(dui);
            if(lstPreguntasUsuario == null || lstPreguntasUsuario.isEmpty()){
                JsfUtil.addWarningMessage("El usuario con # Documento Legal " + dui + " no esta registrado");
            }
        }
        RequestContext.getCurrentInstance().update("frmPrincipal:dlgRecuperarContra");
    }*/

    public void buscarUsuarioPreguntas() {
        mostrarRecuperarCont = Boolean.TRUE;
        lstPreguntasUsuario = provBo.findAllByEmail(email);
        
        if(lstPreguntasUsuario == null || lstPreguntasUsuario.isEmpty()){
           JsfUtil.addWarningMessage("No existe ningún usuario relacionado al Email ingresado");
        }
        RequestContext.getCurrentInstance().update("frmPrincipal:dlgRecuperarContra");
    }
    
    public List<PreguntaValidaUsuario> getLstPreguntasUsuario() {
        return lstPreguntasUsuario;
    }

    public void setLstPreguntasUsuario(List<PreguntaValidaUsuario> lstPreguntasUsuario) {
        this.lstPreguntasUsuario = lstPreguntasUsuario;
    }

    public PreguntaValidaUsuario getPregunta1() {
        if (lstPreguntasUsuario != null && !lstPreguntasUsuario.isEmpty()) {
            return lstPreguntasUsuario.get(0);
        } else {
            return null;
        }
    }

    public PreguntaValidaUsuario getPregunta2() {
        if (lstPreguntasUsuario != null && !lstPreguntasUsuario.isEmpty()) {
            return lstPreguntasUsuario.get(1);
        } else {
            return null;
        }
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
    
    public void comprobarRespuestas(){
        EMailEJB correo = new EMailEJB();
        mostrarRecuperarCont = Boolean.TRUE;
        Usuario usuario = provBo.findUsuarioByEmail(email);
        if(usuario == null){
            JsfUtil.addWarningMessage("Lo sentimos, el correo ingresado no se encuentra registrado");
        }else{
            if(provBo.comprobarRespuestas(usuario.getUserName(), respuesta1, respuesta2)){
                JsfUtil.addSuccessMessage("Respuestas correctas, se le ha enviado su contraseña al correo registrado");
                correo.enviarMail("info",email,"contraseña");
                
                mostrarRecuperarCont = Boolean.FALSE;
            }else{
                JsfUtil.addErrorMessage("Respuestas incorrectas");
            }
        }
        RequestContext.getCurrentInstance().update("frmPrincipal:dlgRecuperarContra");
    }
    
   /* public void envioUsrPassMail(String usr) {

    String para = "carlosp@codehero.co";
    String de = "cpicca@codehero.co";

    // El servidor (host). En este caso usamos localhost
    String host = "localhost";

    // Obtenemos las propiedades del sistema
    Properties propiedades = System.getProperties();

    // Configuramos el servidor de correo
    propiedades.setProperty("mail.smtp.host", host);

    // Obtenemos la sesión por defecto
    Session sesion = Session.getDefaultInstance(propiedades);

    try{
      // Creamos un objeto mensaje tipo MimeMessage por defecto.
      MimeMessage mensaje = new MimeMessage(sesion);

      // Asignamos el “de o from” al header del correo.
      mensaje.setFrom(new InternetAddress(de));

      // Asignamos el “para o to” al header del correo.
      mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(para));

      // Asignamos el asunto
      mensaje.setSubject("Primer correo HTML");

      // Asignamos el contenido HTML, tan grande como nosotros queramos
      mensaje.setContent("<h1>El mensaje de nuestro primer correo HTML</h1>","text/html" );

      // Enviamos el correo
      Transport.send(mensaje);
      System.out.println("Mensaje enviado");
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }*/
    
    public Boolean getMostrarSignUp() {
        return mostrarSignUp;
    }

    public void setMostrarSignUp(Boolean mostrarSignUp) {
        this.mostrarSignUp = mostrarSignUp;
    }

    public Boolean getMostrarRecuperarCont() {
        return mostrarRecuperarCont;
    }

    public void setMostrarRecuperarCont(Boolean mostrarRecuperarCont) {
        this.mostrarRecuperarCont = mostrarRecuperarCont;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}