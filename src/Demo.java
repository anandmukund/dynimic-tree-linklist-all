import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Demo {
	 public static void main(String[] args)
	    {
		 Scanner sc = new Scanner(System.in);
	        String message = new String();
	        message = sc.next();
	        int p = Integer.valueOf(message);
		 List<String> a =  new  ArrayList<String>();
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		 
		 try {
			for(int i = 0 ; i < p ; i++ ){
				 a.add(br.readLine());
			 }
			
			String add = add(a);
			
			String[] re = add.split(" ");
			
			for(int i = 1 ; i < re.length ;i++){
				System.out.println(re[i]);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	 
	 public static String add(List<String> a){
		 String result = "";
		 
		 for(int i=0 ;i<a.size() ; i++){
			 String ip = a.get(i);
			 String[] val  = ip.split(" ");
			 
			 int re = Integer.valueOf(val[0]) + Integer.valueOf(val[1]);
			 result = result + " " + String.valueOf(re);
		 }
		 
		 return result;
	 }
}
