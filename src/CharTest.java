import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class CharTest {

	
	public static char[] getres(char[] input ){

		int index = 0;
		while(index < input.length){

			if(input[index] == '%'){

				if(index + 2 < input.length){

					if(input[index + 1] == '2' && input[index + 2] == '0'){
						input[index] = ' ';
						input[index + 1] = ' ';
						input[index + 2] = ' ';
						index ++;

					}
				}
			}
			index ++ ;
		}

		return input;


	}
	
	
	static int longestChain(String[] words) {
        int result = 0;
        if(words != null && words.length>0){
            Map<String,Integer> wordsList = new HashMap<>() ;
           for(String in : words){
               wordsList.put(in , 0);
           }
                for(String in : words){
                   int  count = 0 ;
                    if(in.length() == 1 ){
                         if(result == 0 ){
                           result = 1 ;
                         }
                    } else {
                        
                        for(int i = 0 ; i < in.length() ; i ++){
                        	String  check="";
                        	if(i>0){
                        		 check = in.substring(0,i) + in.substring(i+1, in.length());
                        	} else {
                            check = in.substring(i+1, in.length());
                        	}
                            int p =1;
                            while(true){
                               
                                if(wordsList.containsKey(check)){
                                	 count ++;
                                	if(p <= check.length()){
                                    check = check.substring(p, check.length());
                                    p++;
                                  
                                	} else {
                                		break;
                                	}
                            } else {
                                    if(count > result){
                                        result = count;
                                    }
                                    break;
                                }
                            }
                            
                            
                        }
                        
                        
                    }
                }
        }
     

        return result;
    }

	 static int getCountOfPossibleTeams(int[] coders) {
	      int count = 0 ;
	       for(int i = 0 ; i < coders.length-2 ; i++){
	    	   for( int temp = i+1 ; temp < coders.length-1 ; temp++){
	    		   
	    		  if(coders[i] >coders[temp] ) {
	    			  int temp1 = temp+1;
	   	           
	   	           while(temp1 < coders.length){
	   	        	   if(coders[temp] > coders[temp1] ){
	   	                  count++;
	   	               } 
	   	        	   temp1 ++;
	   	           } 
	    		  } 
	    		  
	    		  else {
	    			  int temp1 = temp+1;
		   	           
		   	           while(temp1 < coders.length){
		   	        	   if(coders[temp] < coders[temp1] ){
		   	                  count++;
		   	               } 
		   	        	   temp1 ++;
		   	           } 
	    		  }
	    	   }
	           
	        	   
	           }
	      /* for(int i = 0 ; i < coders.length-2 ; i++){
	    	   for( int temp = i+1 ; temp < coders.length-1 ; temp++){
	    		   
	    		  if(coders[i] < coders[temp] ) {
	    			  int temp1 = temp+1;
	   	           
	   	           while(temp1 < coders.length){
	   	        	   if(coders[temp] < coders[temp1] ){
	   	                  count++;
	   	               } 
	   	        	   temp1 ++;
	   	           } 
	    		  }
	    	   }
	           
	        	   
	           }   */
	       
	        
	        return count;
	    }
	
	 
/*	 static int getCountOfPossibleTeams(int[] coders) {
	      int count = 0 ;
	       for(int i = 0 ; i < coders.length-2 ; i++){
	             int temp = i+1; 
	           while(true){
	           if(coders[i] > coders[temp] ){
	                   break;
	               } else {
	               temp++;
	           }
	           if(temp >= coders.length -1 ){
	        	   break;  
	           }
	           }
	         
	           int temp1 = temp+1;
	           
	           while(temp1 < coders.length){
	        	   if(coders[temp] > coders[temp1] ){
	                  count++;
	               } 
	        	   temp1 ++;
	           }
	        	   
	           }
	           
	       
	        
	        return count;
	    }
	*/
	
	 
	 public static String findArray(String[] lineVector , int co ,int de){
	        
	        StringBuffer sb = new StringBuffer();
	        int count = 0 ;
	        int id = 0;
	        for(int i = 0 ; i <lineVector.length ; i++){
	            count ++;
	            
	            if(count % co == 0){
	                if(id == 0){
	                sb.append(String.valueOf(lineVector[i]));
	                } else {
	                     sb.append(",");
	                    sb.append(String.valueOf(lineVector[i])); 
	                    i =  i+de;
	                }
	            } else {
	                if(id == 0){
	                sb.append(String.valueOf(lineVector[i]));
	                } else {
	                     sb.append(",");
	                    sb.append(String.valueOf(lineVector[i])); 
	                }
	            }
	            id ++;
	        }
	        
	        return sb.toString();
	    }
	 
	 
	 
	 
	 static String findQualifiedNumbers(int[] numberArray) {
	        
	        String result = "";
	        Arrays.sort(numberArray);
	        for(int i = 0 ; i < numberArray.length ; i++){
	        	int count = 0;
	        	String val = String.valueOf(numberArray[i]);
	        	if(val.contains("1") && val.contains("2") && val.contains("3")){
	        		if(count ==0){
	        		result = result+ val;
	        		}
	        		else{
	        			result = result+","+ val;	
	        		}
	        	}
	        	
	        }
              if(result.length() < 2){
            	  return "-1";
              }
	        
	        return result;
	    }
	 
	 
	 
	 static int findPossibleSmallestNumberMatchingPattern(String pattern) {

		 String result = "";
		 if(pattern == null || pattern.isEmpty()  || pattern.length() > 8){
			 
			 return -1;
		 }
		 
		 char[] cr = pattern.toCharArray();
		 if( cr[0] =='N' ){
				result ="12";
			}
		 else{
			 if( cr[0] =='M' ){
					result ="21";
				}
			 else{
				 return -1;
			 }
		 }
		 
		 if(cr.length > 1){
			 if( cr[1] =='N' && cr[0] =='N' ){
					result ="123";
				}
			 if( cr[1] =='N' && cr[0] =='M' ){
					result ="213";
				}
			
				 if( cr[1] =='M' && cr[0] =='N' ){
						result ="213";
					}
				 if( cr[1] =='M' && cr[0] =='M' ){
						result ="321";
					}
				 if( cr[1] !='M' && cr[1] !='N' ){
						return -1;
					}
			 } 
		 if(cr.length > 2) {
		 for(int i = 2 ; i <cr.length; i++){
			 if( cr[i] =='N' && cr[i - 1] == 'N' ){
					result = result + String.valueOf(Integer.valueOf(result.substring(result.length()-1)) + 1) ;
				}
			 if( cr[i] =='N' && cr[i - 1] == 'M' ){
					result = result.substring(0, result.length()-1) + String.valueOf(Integer.valueOf(result.substring(result.length()-1)) + 1) +String.valueOf(result.substring(result.length()-1));
				}
			 
			 if( cr[i] =='M' && cr[i - 1] == 'M' ){
					result = result + String.valueOf(Integer.valueOf(result.substring(result.length()-1)) - 1) ;
				}
			 if( cr[i] =='M' && cr[i - 1] == 'N' ){
					result = result.substring(0, result.length()-1) + String.valueOf(Integer.valueOf(result.substring(result.length()-1))+1) +String.valueOf(result.substring(result.length()-1));
				}
		 }
		 }
		 return Integer.valueOf(result);
		 
	    }

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	public static void main(String[] args) {
		findPossibleSmallestNumberMatchingPattern("MNM");
		List<String[] > s = new ArrayList<String[]>();
	
        String line = "1,2,3,4,5,6,10,8";
        String[] lineVector;

       
        lineVector = line.split(",");
       
        System.out.println(findArray(lineVector,3,1));
		
		int[] wor = {5,6,4,3,8,9,10,1};
		System.out.println(getCountOfPossibleTeams(wor));
		/*char ff = (Character) null ;
		String a = "qwwww44455566788";
		String c = a + "@" + "hello";
	
		System.out.println(c.substring(c.lastIndexOf("@")+1, c.length()));
		System.out.println(c.substring(0,c.lastIndexOf("@")));*/
		// TODO Auto-generated method stub
  /*char[] c = {'a','a','a','%','2','0','e','3'};
  System.out.println(getres(c));*/
	}

}
