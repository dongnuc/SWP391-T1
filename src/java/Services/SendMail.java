/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.util.Date;
import java.util.Properties;
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
    public final String emailSend = "dongnuc2401@gmail.com";
    public final String passwordEmail = "vtrj dniw sjqq vcww";

    public void sendMailDefault(String tittle, String content, String sendToEmail) {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
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
    
    public void replyMailForm(String tittle,String content,String sendToMail,String mailSend,String tokenEmail){
         Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        javax.mail.Authenticator authenticator;
        authenticator = new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailSend, tokenEmail);
            }
        };
        Session session = Session.getInstance(prop, authenticator);
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.setFrom(mailSend);
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendToMail, false));
            msg.setSubject(tittle);
            msg.setText(content);
            msg.setSentDate(new Date());
            javax.mail.Transport.send(msg);
        } catch (Exception e) {
            System.out.println(e);

        }
    }
    public static void main(String[] args) {
        SendMail send = new SendMail();
        send.replyMailForm("", "khi nào", "dongnuc2k3@gmail.com", "dongnuc2401@gmail.com", "yohakisbzmmsxruq");
    }
}
