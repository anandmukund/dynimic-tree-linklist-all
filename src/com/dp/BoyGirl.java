package com.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoyGirl {

	
/*public static  int gerNumber(int girls, int boys){
		
		
		int[][] result = new int[boys+ 1][girls+1];
		
		
		
		for(int i =1 ;i <= boys ; i ++){
			for(int j =1 ;j <= girls; j ++){
		
				if(i == j){
					result[i][j] = 1;
				}
			if(i>j)	{
				result[i][j]=result[i][j-1];
			}
			if(i<j){
				result[i][j]= 1 + result[i][j-i-1];
			}
			}
		}
		
		return result[boys][girls];
	}

public static void main(String as[]){
	System.out.println(gerNumber(8, 3));
}*/
	
	public static void main(String[] args) throws InterruptedException {
        List<String> inputByLine = new ArrayList<String>();
        try {
            // Get the object of DataInputStream
            InputStreamReader isr = new InputStreamReader(System.in,"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null){
                inputByLine.add(line.toString());
                if(inputByLine.size() == 2){
                	break;
                }
            }
            String[] ip = inputByLine.get(1).split(" ");
            System.out.println(gerNumber(Integer.valueOf(ip[0]), Integer.valueOf(ip[1])));
            isr.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
     public static  int gerNumber(int girls, int boys){
		
		int[][] result = new int[boys+ 1][girls+1];
		
		for(int i =1 ;i <= boys ; i ++){
			for(int j =1 ;j <= girls; j ++){
				if(i == j){
					result[i][j] = 1;
				}
			if(i>j)	{
				result[i][j]=result[i][j-1];
			}
			if(i<j){
				result[i][j]= 1 + result[i][j-i-1];
			}
			}
		}
		
		return result[boys][girls];
	}
    
   
}
