/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algorithm;
import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author Admin
 */
public class SendMail {
    
    private static final String emailSend = "hau2082003@gmail.com";
    private static final String passwordEmail = "ntbi rdsg sctz wppf";
  
    
    public void sendMailDefault(String tittle, String content, String sendToEmail) {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        javax.mail.Authenticator authenticator;
        authenticator = new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailSend, passwordEmail);
            }
        };
        Session session = Session.getInstance(prop, authenticator);
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.setFrom(emailSend);
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendToEmail, false));
            msg.setSubject(tittle);
            msg.setText(content);
            msg.setSentDate(new Date());
            javax.mail.Transport.send(msg);
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
