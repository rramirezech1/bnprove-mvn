/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.apps.bnprove.mvn.util;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author RAREcheverria
 */
public class EMailEJB {

    private Session mailSession;

    private Properties config = new Properties();

    private void configuracionesDeSession() {
        config.setProperty("mail.transport.protocol", "smtp");
        config.setProperty("mail.host", "192.168.19.51");
        config.setProperty("mail.user", "RAREcheverria");
        config.setProperty("mail.password", "echeverria17");
        //config.put("mail.smtp.auth", "true");
        //config.put("mail.smtp.starttls.enable", "true");
        //config.put("mail.smtp.port", "587");
        
        mailSession = Session.getInstance(config, new Authenticator() {

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("RAREcheverria@mined.gob.sv", "echeverria17");
            }

        });
    }

    /**
     * Este método envía un mail
     *
     * @param subject asunto del mail
     * @param remitente - destinatarios.
     * @param message - contenido del mensaje.
     */
    
    @Asynchronous
    public void enviarMail(String subject, String destino, String message) {
        try {
            configuracionesDeSession();
            MimeMessage m = new MimeMessage(mailSession);
            Address from = new InternetAddress("RAREcheverria@mined.gob.sv");

            m.setFrom(from);
            m.setRecipients(Message.RecipientType.TO, destino);
            m.setSubject(subject, "UTF-8");
            m.setSentDate(new java.util.Date());
            m.setText(message, "UTF-8", "html");
            Transport.send(m);
        } catch (MessagingException ex) {
            Logger.getLogger(EMailEJB.class.getName()).log(Level.INFO, ex.getMessage(),"==============================================");
            ex.printStackTrace();
        }
    }
}

