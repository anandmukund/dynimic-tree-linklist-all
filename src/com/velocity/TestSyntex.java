package com.velocity;

public class TestSyntex {


	public static boolean checkString(String input){
		String b = "";
		boolean result = true;
		for(int i = 0 ; i < input.length() ; i++){
			char c = input.charAt(i);
			char s ;
			switch(c) {
			case '{' : 
				b = b +c;
				break;
				
			case '[' : 
				b = b + c;
				break;
				
			case '(' : 
				b = b + c;
				break;
				
			case '}' :
				if(b.length() > 1){
					s = b.charAt(b.length() - 1);
				} else {
					s = b.charAt(0);
				}
				if(s == '{'){
					b = b.substring(0 , b.length() - 1);
				} else {

					return false;
				}
				break;
				
			case ']' : 
				if(b.length() > 1){
					s = b.charAt(b.length() - 1);
				} else {
					s = b.charAt(0);
				}
				if(s == '['){
					b = b.substring(0 , b.length() - 1);
				} else {

					return false;
				}
				break;
				
			case ')' : 
				if(b.length() > 1){
					s = b.charAt(b.length() - 1);
				} else {
					s = b.charAt(0);
				}
				if(s == '('){
					b = b.substring(0 , b.length() - 1);
				} else {

					return false;
				}
				break;
			}

		}
		if (! b.isEmpty()) {
			result = false;
		}
		return result;
	}

	
	public static void main (String as[]){
		System.out.println(checkString("[[][12]+2{(6)}+12{{{{}}}}]"));
	}
}
