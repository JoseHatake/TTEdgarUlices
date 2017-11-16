/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.escom.socialwriters.accesoDB.utilidades;

 
import java.util.Properties;
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
 * @author Lock
 */
public class Correo {
    private final Properties properties = new Properties();
    private Session session;
    private static final String CORREO = "tt2016a010@gmail.com";
    private static final String PASS = "edgula010";
   

    public Correo() {
    }
    
    private void init(){
                properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port","587");
	        properties.put("mail.smtp.auth", "true");
                Authenticator auth = new SMTPAuthenticator();
		session = Session.getInstance(properties, auth);
                
    }
    //función que envia un correo, recibe el correo al que se enviará, el mensaje a enviar y el asunto.
    public boolean enviarCorreo(String destinatario,  String asunto, String msg){
                init();
		try{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(CORREO));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			message.setSubject(asunto);                        
			message.setText(msg, "UTF-8", "html");
			Transport t = session.getTransport("smtp");                        
			t.connect();                        
			t.sendMessage(message, message.getAllRecipients());
			t.close();
		        return true;
                }catch (MessagingException me){
                        me.printStackTrace();
			return false;
		}
		
    }
    
    //autenticador
    private class SMTPAuthenticator extends javax.mail.Authenticator {
        @Override
        public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(CORREO,PASS);
        }
    }
    
    
   
    
}
