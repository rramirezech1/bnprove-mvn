/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.util;

import java.io.IOException;
import java.util.Properties;
import javax.faces.context.FacesContext;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import sv.gob.mined.apps.bnprove.mvn.modelo.Usuario;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.primefaces.json.JSONObject;

/**
 *
 * @author RMendez
 */
public class UtilidadesController {

    private String correoEnvia = "seguimiento.tickets.dite@gmail.com";
    private String contrasena = "dwtuklxdyztlyrdt";
    private String destinatario;
    private String mensaje;
    private String asunto;
    private Usuario us;
    
    

    public String getCorreoEnvia() {
        return correoEnvia;
    }

    public void setCorreoEnvia(String correoEnvia) {
        this.correoEnvia = correoEnvia;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }
    
    
    
    
    
    
    
    

    public void enviarCorreo(String destinatario, String asunto, String mensaje) throws AddressException, MessagingException {
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail smtp port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        Session sesion = Session.getDefaultInstance(propiedad);
        sesion.getProperties().put("mail.smtp.ssl.trust", "smtp.gmail.com");
        sesion.getProperties().put("mail.smtp.starttls.enable", "true");
        this.correoEnvia = "seguimiento.tickets.dite@gmail.com";
        this.contrasena = "dwtuklxdyztlyrdt";
        this.destinatario = destinatario;
        this.asunto=asunto;
        this.mensaje = mensaje;
        MimeMessage mail = new MimeMessage(sesion);
        mail.setFrom(new InternetAddress(correoEnvia));
        mail.addRecipient(Message.RecipientType.TO, new InternetAddress(this.destinatario));
        mail.setSubject(this.asunto);
            mail.setText(this.mensaje);
            try (Transport transporte = sesion.getTransport("smtp")) {
                transporte.connect(correoEnvia, contrasena);
                transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            }
        
        
        
        
    }
    
    
    public void verificarSesion(){
         try{
            FacesContext context= FacesContext.getCurrentInstance();
             us=(Usuario)context.getExternalContext().getSessionMap().get("usuario_");
            System.out.println("Estoy plantilla - 181524072022 - "+us);
          
            if(us==null)
            {
                 System.out.println("Estoy en if de verificar session");
                context.getExternalContext().redirect("/systemscore16_04/index.systemcore");
               
            }
            
        }catch(Exception e){
            
        }
        
    }
    
    
     public void enviarMensajeV2(String celularPersonal, String mensaje) throws IOException {
        JSONObject json = new JSONObject();
        
        json.put("message", mensaje);
        json.put("celularPersonal", celularPersonal);
        String concat = json.getString("message") + "";
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpPost request = new HttpPost("http://localhost:9000/send");
            StringEntity params = new StringEntity(json.toString());
            request.setEntity(params);
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-type", "application/json");
            httpClient.execute(request);
        } catch (Exception ex) {
        } finally {
            httpClient.close();
        }

    }
    
    
    
    
    
    
    
    
    
    

}
