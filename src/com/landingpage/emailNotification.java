package com.landingpage;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class emailNotification {
   public void sending(String email, String name, String phn) {
      
      String to = email;//will change accordingly
      String reg_name = name;
      String phone = phn;
      // Web Page owner's email ID needs to be mentioned
      String from = "meghana.sampelli2811@gmail.com";//change website owner email_id change accordingly
      String cc = from;
      final String username = "meghana.sampelli2811";//change website owner username accordingly
      final String password = "";//change password of website owner

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

      try {
         // Create a default MimeMessage object for form filler
         Message message1 = new MimeMessage(session);
         // Create a default MimeMessage object for website owner, here it is CC to the sender
         Message message2 = new MimeMessage(session);
         
         // Set From: header field of the header.
         message1.setFrom(new InternetAddress(from));

         // Set To form filler's email_id: header field of the header.
         message1.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));
         // Set cc or website owner's email Id: header field of the header
         message2.setRecipients(Message.RecipientType.CC,
                 InternetAddress.parse(cc));
         
         // Set Subject: for form filler
         message1.setSubject("You are welcome!");

         // Now set the actual message for form filler
         message1.setText("Hello " + reg_name+"," + "\n" + " Thank you for registering with PROFESSIONAL PAINTERS. "
         		+ "You can redeem your PROMO CODE after the scheduled estimate" );
         
        // Set Subject: for website owner
         message2.setSubject("A new member registered");

         // Now set the actual message for website owner
         message2.setText("Hello " + username+"," + "\n" + "A new member with " + reg_name + " registered at PROFESSIONAL PAINTERS" +
         "\n" + "Details are: " + "\n" + reg_name + "\n" + to + "\n" + phone );
         // Send message to form filler and website owner
         Transport.send(message1);
         Transport.send(message2);
         System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
    	  System.out.println("Error: Enter valid email Id .");
      }
   }
}