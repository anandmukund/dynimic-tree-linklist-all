package com.test;

import java.util.HashMap;
import java.util.Map;

public class ObjectArrayTEst {
	static Map  r;
static {
  r = new HashMap();

		r.put("employees", "{ \"employees\": [ { \"firstName\":\"John\" , \"lastName\":\"Doe\" }, { \"firstName\":\"Anna\" , \"lastName\":\"Smith\" }, { \"firstName\":\"Peter\" , \"lastName\":\"Jones\" } ]}");
}	
	public static void doSome(Map p){
	Object[] listObj = (Object[]) p.get("employees");
	}
	
	public static void main(String s[]){
		doSome((Map)r.get("employees"));
	}
}