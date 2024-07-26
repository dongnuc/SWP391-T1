/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author 84358
 */
public class SendEmailHuy {
    public  void sendemailfail(String nguoinhan,String mess){     
        final String from="huytestnguyen@gmail.com";
        final String password="rcjmvvsweiaeuwdt";
        Random random = new Random();
        Properties prop=new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable","true");
        javax.mail.Authenticator authenticator;
        authenticator = new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return  new PasswordAuthentication(from,password);
            }
        };
         Session session1 =Session.getInstance(prop, authenticator);
         MimeMessage msg=new MimeMessage(session1);
         try {
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.setFrom(from);
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(nguoinhan,false));
            msg.setSubject("Thong bao Dang Ki Tham Gia Event");
            msg.setSentDate(new Date());
            
            msg.setText("Xin loi ban da ki That bai Event Reason: "+mess);      
            
            javax.mail.Transport.send(msg);
        } catch (Exception e) {
            
        } 
    }
    public  void sendemailsuccess(String nguoinhan){     
        final String from="huytestnguyen@gmail.com";
        final String password="rcjmvvsweiaeuwdt";
        Random random = new Random();
        Properties prop=new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable","true");
        javax.mail.Authenticator authenticator;
        authenticator = new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return  new PasswordAuthentication(from,password);
            }
        };
         Session session1 =Session.getInstance(prop, authenticator);
         MimeMessage msg=new MimeMessage(session1);
         try {
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.setFrom(from);
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(nguoinhan,false));
            msg.setSubject("Thong bao Dang Ki Tham Gia Event");
            msg.setSentDate(new Date());
            
            msg.setText("Ban Da Dang ki thanh cong: ");      
            
            javax.mail.Transport.send(msg);
        } catch (Exception e) {
            
        } 
    }
    public static void main(String[] args) {
        SendEmailHuy s=new SendEmailHuy();
        s.sendemailfail("a1k28cbq@gmail.com", "123");
    }
}
