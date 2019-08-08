package com.velocity;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class TestMail {

	public static void main(String sd[]){
		final String username = "anand.kumar@altisource.com";
		final String password = "Today+15";

		Properties emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", "587");
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "false");
        
		emailProperties.setProperty("mail.smtp.user", "kumanand");
		emailProperties.setProperty("mail.smtp.password", "Today+15");
		emailProperties.setProperty("mail.smtp.auth", "true"); 
		Session session = Session.getDefaultInstance(emailProperties);
        
		try {
			String[] toEmails ={"anand.tct8@gmail.com"};
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmails[0]));
			message.setSubject("Testing Subject");
			message.setContent("htmlMsg", "text/html; charset=utf-8");
			
			String emailHost = "NAV8EHCNMP01.ASCORP.COM";
			String fromUser = "anand.kumar@altisource.com";//just the id alone without @gmail.com
			String fromUserEmailPassword = "Today+15";

			Transport transport = session.getTransport("mail02.svc.mia.vz.altidev.net");
            
			transport.connect(emailHost, fromUser, fromUserEmailPassword);
			transport.sendMessage(message , message.getAllRecipients());
			transport.close();
			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
    
	}

