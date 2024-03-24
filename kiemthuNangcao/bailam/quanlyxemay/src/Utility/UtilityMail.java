/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author ADMIN
 */
public class UtilityMail {
    String FromMail="sungtsps28482@fpt.edu.vn";
    String PassAuth="vdev tnbz bzug ymrb";
    public static Properties getProperties(){
         Properties p=new Properties();
         p.put("mail.smtp.auth", "true");
         p.put("mail.smtp.starttls.enable", "true");
         p.put("mail.smtp.host", "smtp.gmail.com");
         p.put("mail.smtp.port", "587");
         return p;    
    }
    public void GuiMail(String toMail,String chude,String noidung){
        Session session=Session.getDefaultInstance(getProperties(),new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FromMail,PassAuth);
            }         
        });      
        try {
            MimeMessage mess = new MimeMessage(session);
            mess.setFrom(new InternetAddress(FromMail));
            mess.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
            mess.setSubject(chude);
            mess.setText(noidung);
            Transport.send(mess);
            
        } catch (Exception ex) {
            ex.printStackTrace();           
        }            
    }
 
    public static String ChuoiNgauNhien(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(rnd.nextInt(characters.length())));
        }
        return sb.toString();
    }
 
}
