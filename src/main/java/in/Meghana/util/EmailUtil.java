package in.Meghana.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

///JavaMail API,
@Component
public class EmailUtil 
{
	public void sendMessage(String to,String subject ,String body)
	{
		//simple smptp protocol is used 
		 String host = "smtp.gmail.com"; // SMTP server (e.g., Gmail: smtp.gmail.com)
	     final String username = "pmeghana1310@gmail.com"; // Your email
	     final String password = "lfwo bthg bbgj dwti"; // Your email password

	     // Recipient's email ID
	    

	     // Setting up the mail server properties
	     Properties properties = new Properties();
	     properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", "587"); // Default port for SMTP
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true"); 
	     //   Port 587 is the port used by Gmail for sending emails with TLS security.
	       // TLS (Transport Layer Security) encrypts your email so that no hacker can see your content
	     
	     
	       // 👉 It creates an email session to connect to your Gmail account using username/password.
	     // Get the Session object and authenticate the user
	     Session session = Session.getInstance(properties, new Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	             return new PasswordAuthentication(username, password);
	         }
	     });
//	     This line is very important.
//	     👉 It creates an email session to connect to your Gmail account using username/password.
//	     👉 It uses Authenticator to log in to your email like this:
	     
	     
	     
	     
	     try {
	         // Create a default MimeMessage object
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field
	         message.setFrom(new InternetAddress(username));

	         // Set To: header field
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject(subject);

	         // Set the actual message
	         message.setText(body);

	         // Send the email
	         Transport.send(message);
	         //Finally, I used Transport.send() to send the email.


	         System.out.println("Email sent successfully!");
	     } catch (MessagingException e) {
	         e.printStackTrace();
	     }
	}
	
}



//This is an Email Utility class in Spring Boot that uses the JavaMail API to send emails from my Gmail account to any recipient.
//I have used the SMTP (Simple Mail Transfer Protocol) with TLS (Transport Layer Security) for secure email transmission.
//
//First, I set up the SMTP host, port, and authentication.
//Then, I created a Session object to authenticate using my email and password.
//After that, I used a MimeMessage to create the email content (subject, body, etc.).
//Finally, I used Transport.send() to send the email.
//If any exception occurs (like invalid email or network issues), it will be handled in the catch block.
//
//Session → To connect with your Gmail account.
//Message → To create the email content.
//MimeMessage → To format the email content.
//Transport → To send the email.
////
