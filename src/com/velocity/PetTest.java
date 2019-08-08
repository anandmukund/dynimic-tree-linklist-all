package com.velocity;

import java.io.StringWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
public class PetTest
{
    public static void main( String[] args )
        throws Exception
    {
        /*  first, get and initialize an engine  */
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        List<DTO> list = new ArrayList<DTO>();
        DTO d = new DTO();
        d.setName("aaa");
        d.setPrice("333");
        DTO d1 = new DTO();
        d1.setName("bbb");
        d1.setPrice("444");
        list.add(d1);
        list.add(d);
        /*  organize our data  */
        /*List< Map<String , String>> list = new ArrayList< Map<String , String>>();
        Map<String , String> map = new HashMap<String , String>();
        map.put("name", "horse");
        map.put("price", "00.00");
        list.add( map );
 
        map = new HashMap<String, String>();
        map.put("name", "dog");
        map.put("price", "9.99");
        list.add( map );
        map = new HashMap<String, String>();
        map.put("name", "bear");
        map.put("price", ".99");
        list.add( map );*/
        /*  add that list to a VelocityContext  */
        VelocityContext context = new VelocityContext();
        context.put("petList", list);
        /*  get the Template  */
        Template t = ve.getTemplate( "src\\templet\\pet.vm" );
        /*  now render the template into a Writer  */
        StringWriter writer = new StringWriter();
        t.merge( context, writer );
        /* use the output in your email body */
       // sendMail(writer.toString());
      System.out.println(( writer.toString() ));
    }
    
    
    public static void sendMail(String htmlMsg){
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
			InternetAddress[] i = new InternetAddress[toEmails.length];
			InternetAddress t = new InternetAddress(toEmails[0]);
			t.validate();
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmails[0]));
			message.setSubject("Testing Subject");
			message.setContent(htmlMsg, "text/html; charset=utf-8");
			
			String emailHost = "NAV8EHCNMP01.ASCORP.COM";
			String fromUser = "anand.kumar@altisource.com";//just the id alone without @gmail.com
			String fromUserEmailPassword = "Today+15";

			Transport transport = session.getTransport("mail02.svc.mia.vz.altidev.net");
            
			transport.connect(emailHost, fromUser, fromUserEmailPassword);
			transport.sendMessage(message , message.getAllRecipients());
			transport.close();
			System.out.println("Done");

		} 
		catch (AddressException e) {
			throw new RuntimeException(e);
		}
		catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
    
}
