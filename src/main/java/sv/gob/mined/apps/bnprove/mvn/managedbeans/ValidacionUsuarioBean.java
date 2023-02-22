/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.managedbeans;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
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
import sv.gob.mined.apps.bnprove.mvn.util.UtilidadesController;

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
    private Usuario usuarioRecUsuCla;
    private Boolean mostrarSignUp = Boolean.FALSE;
    private Boolean mostrarRecuperarCont = Boolean.FALSE;
    private Persona personaRecUsuCla;
    private Persona persona;
    private String ultDigDeCelular;
    private String asunto, mensaje;
    private Persona per;
    private String nuevaClave;
    private Usuario us;

    @Autowired
    private ProveedoresBo provBo;
    @Autowired
    private ProveedoresBo provBoRecUsuCla;
    @Autowired
    private ProveedoresBo provBoRecUsuCla02;

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

    public Usuario getUsuarioRecUsuCla() {
        return usuarioRecUsuCla;
    }

    public void setUsuarioRecUsuCla(Usuario usuarioRecUsuCla) {
        this.usuarioRecUsuCla = usuarioRecUsuCla;
    }

    public Persona getPersonaRecUsuCla() {
        return personaRecUsuCla;
    }

    public void setPersonaRecUsuCla(Persona personaRecUsuCla) {
        this.personaRecUsuCla = personaRecUsuCla;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public ProveedoresBo getProvBoRecUsuCla() {
        return provBoRecUsuCla;
    }

    public void setProvBoRecUsuCla(ProveedoresBo provBoRecUsuCla) {
        this.provBoRecUsuCla = provBoRecUsuCla;
    }

    public String getUltDigDeCelular() {
        return ultDigDeCelular;
    }

    public void setUltDigDeCelular(String ultDigDeCelular) {
        this.ultDigDeCelular = ultDigDeCelular;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ProveedoresBo getProvBoRecUsuCla02() {
        return provBoRecUsuCla02;
    }

    public void setProvBoRecUsuCla02(ProveedoresBo provBoRecUsuCla02) {
        this.provBoRecUsuCla02 = provBoRecUsuCla02;
    }

    public Persona getPer() {
        return per;
    }

    public void setPer(Persona per) {
        this.per = per;
    }

    public String getNuevaClave() {
        return nuevaClave;
    }

    public void setNuevaClave(String nuevaClave) {
        this.nuevaClave = nuevaClave;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

    public String validarCredencialesDeAcceso() {

        FacesContext context = FacesContext.getCurrentInstance();

        if (usuario != null && claveDeAcceso != null) {

            per = provBo.findPersonaByUsuarioClave(usuario, claveDeAcceso);
            usuarioRecUsuCla = provBoRecUsuCla02.buscarPorUsuario(per.getUserName());
            System.out.println("Estoy en session para el usuario: " + usuarioRecUsuCla.getUserName());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario_", usuarioRecUsuCla);
            if (per != null && usuarioRecUsuCla.getEstadoDeContrasena() == 1) {

                context.getExternalContext().getSessionMap().put(JsfUtil.sUsuario, usuario);
                context.getExternalContext().getSessionMap().put(JsfUtil.sIdPersona, per.getIdentificadorDeLaPersona());

                return "/app/vistas/registro.jsf?faces-redirect=true";
            } else if (per != null && usuarioRecUsuCla.getEstadoDeContrasena() == 2) {
                return "/app/vistas/cambiaClaveAleatoria.jsf?faces-redirect=true";
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
        valido = JsfUtil.addErrorStyle("frmPrincipal", "txtPrimerApellido", InputText.class, currentUsuario.getPrimerApellido()) & valido;

        valido = JsfUtil.addErrorStyle("frmPrincipal", "txtTelefono", InputMask.class, currentUsuario.getTelefono()) & valido;
        valido = JsfUtil.addErrorStyle("frmPrincipal", "txtEmail", InputText.class, currentUsuario.getEMail()) & valido;

        valido = JsfUtil.addErrorStyle("frmPrincipal", "txtUsuarioDeAcceso", InputText.class, currentUsuario.getUserName()) & valido;
        valido = JsfUtil.addErrorStyle("frmPrincipal", "txtPass", InputText.class, currentUsuario.getPassword()) & valido;

        valido = JsfUtil.addErrorStyle("frmPrincipal", "cbPregunta1", SelectOneMenu.class, currentUsuario.getIdPregunta1()) & valido;
        valido = JsfUtil.addErrorStyle("frmPrincipal", "txtRespuesta1", InputText.class, currentUsuario.getRespuesta1()) & valido;
        valido = JsfUtil.addErrorStyle("frmPrincipal", "cbPregunta2", SelectOneMenu.class, currentUsuario.getIdPregunta2()) & valido;
        valido = JsfUtil.addErrorStyle("frmPrincipal", "txtRespuesta2", InputText.class, currentUsuario.getRespuesta2()) & valido;

        if (valido) {
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
        } else {
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

        if (lstPreguntasUsuario == null || lstPreguntasUsuario.isEmpty()) {
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

    public void comprobarRespuestas() {
        EMailEJB correo = new EMailEJB();
        mostrarRecuperarCont = Boolean.TRUE;
        Usuario usuario = provBo.findUsuarioByEmail(email);
        if (usuario == null) {
            JsfUtil.addWarningMessage("Lo sentimos, el correo ingresado no se encuentra registrado");
        } else {
            if (provBo.comprobarRespuestas(usuario.getUserName(), respuesta1, respuesta2)) {
                JsfUtil.addSuccessMessage("Respuestas correctas, se le ha enviado su contraseña al correo registrado");
                correo.enviarMail("info", email, "contraseña");

                mostrarRecuperarCont = Boolean.FALSE;
            } else {
                JsfUtil.addErrorMessage("Respuestas incorrectas");
            }
        }
        RequestContext.getCurrentInstance().update("frmPrincipal:dlgRecuperarContra");
    }

    public void buscarUsuario() {
        dui = StringUtils.deleteWhitespace(dui);

        if (dui.length() == 9 && dui.matches("[0-9]+")) {

            try{
            personaRecUsuCla = provBoRecUsuCla.buscarPorDui(dui);
            usuarioRecUsuCla = provBoRecUsuCla02.buscarPorUsuario(personaRecUsuCla.getUserName());
            ultDigDeCelular = personaRecUsuCla.getNumeroCelular().substring(personaRecUsuCla.getNumeroCelular().length() - 4);
            }catch(Exception e){
                JsfUtil.addWarningMessage("No se ha encontrado registro con ese número de DUI.");
            }
            
            
            
            

            //JsfUtil.addWarningMessage("No se ha encontrado registro con ese número de DUI.");
        } else {

            JsfUtil.addWarningMessage("Favor revisa lo que has ingresado, no es valido");

        }

    }

    public void recuperarClave() throws IOException, MessagingException {

        if (dui == null || dui.trim().isEmpty()) {
            JsfUtil.addWarningMessage("Favor revisa lo que has ingresado, no es valido");
        } else if (dui.length() == 9 && dui.matches("[0-9]+")) {
            FacesContext context = FacesContext.getCurrentInstance();
            UtilidadesController enviCorreo = new UtilidadesController();
            UtilidadesController enviaWhatsapp = new UtilidadesController();
            int claveTemporal = ((int) ((Math.random() * 97)) * 1500);
            asunto = "MINED - Recuperación automática de Usuario y Clave.";
            mensaje = "Estimad@ " + personaRecUsuCla.getPrimerNombre() + " " + personaRecUsuCla.getPrimerApellido() + ". \n\nSomos de la Gerencia de Desarrollo tecnológico, No compartas esta información con nadie. Recuerda que MINED nunca te solicitará que entregues tu información de usuario o cualquier código/clave enviado a tu correo electrónico o celular.\n\nHas realizado una solicitud de recuperación de usuario y clave."
                    + "\n\nTu usuario de acceso es: " + personaRecUsuCla.getUserName() + "\n\nTu clave temporal de acceso es: " + claveTemporal + "\n\nSi necesitas soporte de Desarrollo tecnológico, nos puedes contactar al teléfono 2592-4309 habilitado las 24 horas del día, los 7 días de la semana.\n\nAtentamente,\n\nMINED. \n\nMensaje automático, por favor no responder.";
            enviCorreo.enviarCorreo(personaRecUsuCla.getEMail(), asunto, mensaje);
            enviaWhatsapp.enviarMensajeV2(personaRecUsuCla.getNumeroCelular(), mensaje);

            usuarioRecUsuCla.setPassword(Integer.toString(claveTemporal));
            usuarioRecUsuCla.setEstadoDeContrasena(2);
            provBoRecUsuCla.updateUsuario(usuarioRecUsuCla);
            context.getExternalContext().redirect("/bnprove-mvn/index.jsf");
        } else {

            JsfUtil.addWarningMessage("Favor revisa lo que has ingresado, no es valido");

        }

    }

    public void cambiarClaveAleatoria() throws IOException {

        this.us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario_");

        if (us.getPassword().equals(claveDeAcceso)) {
            us.setPassword(nuevaClave);
            us.setEstadoDeContrasena(1);
            provBoRecUsuCla.updateUsuario(us);
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("/bnprove-mvn/index.jsf");

        }
    }

    public void limpiar() throws IOException {
        System.out.println("Estoy en limpiar");
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().redirect("/bnprove-mvn/index.jsf");

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
