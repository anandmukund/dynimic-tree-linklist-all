package com.jagdish.odisha;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class OpenUrl {

 
 
 public static void main(String[] args)  {

	 try {
      openWebpage("http://www.facebook.com");
 
  } catch (Exception e) {
   
   e.printStackTrace();
  }
 }

 private static void  openWebpage(String url) throws URISyntaxException, IOException {
	   URI uri= new URI(url);
	   java.awt.Desktop.getDesktop().browse(uri);
	   System.out.println("Web page opened in browser");
 }
}