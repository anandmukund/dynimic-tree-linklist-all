package com.algo1;

public class Test {
	public static void main(String s[]) {
		String errorDescription = "Transaction timed-out. No modelets defined in Pool  R23. Timeout period 69 sec/attempt. Number of attempts - 1";
		int noOfAttempts = Integer.valueOf(errorDescription.substring(errorDescription.length()-1 ,errorDescription.length()));
		String file= "tester_12_1234344_11.json";
		Test.isNotValidFileName(file);
				
		int[] s1 = { 0, 5, 0, 2, 4, 6, 0, 0, 0, 3, 0, 8, 2, 0, 8 };
		s1 = Test.testAll(s1);
		for (int o = 0; o < s1.length; o++) {
			System.out.println(s1[o]);
		}
	}
	public static int[] testAll(int[] a) {
		int j = 0 ,k = 0;
		while (k < a.length) {
			if (a[k] == 0) {
				j++;
			}
			if (a[k] != 0) {
				int temp = a[k];
				a[k] = a[k - j];
				a[k - j] = temp;
			}
			k++;
		}
		return a;
	}
	 private static boolean isNotValidFileName(String fileName) {
	    	
	    	if(fileName.contains(".")){
	          String ext = fileName.substring(fileName.length()-5,fileName.length());
	          
	          if(ext.equalsIgnoreCase(".json")){
	        	  if(fileName.contains("_")){
	        	  String sequenceNo = fileName.substring(fileName.lastIndexOf("_") + 1, fileName.indexOf(".json"));
	        	  int seqNo = Integer.valueOf(sequenceNo);
	        	  String withoutSequence = fileName.substring(0, fileName.lastIndexOf("_"));  
	        	  if(withoutSequence.contains("_")){
	        		  String withoutseq = withoutSequence.substring(withoutSequence.lastIndexOf("_")+1 , withoutSequence.length());
	        		  long dateTime = Long.valueOf(withoutSequence.substring(withoutSequence.lastIndexOf("_")+1 , withoutSequence.length()));
	        		  String withoutDate = withoutSequence.substring(0, withoutSequence.lastIndexOf("_")); 
	        		  int version = Integer.valueOf(withoutSequence.substring(withoutDate.lastIndexOf("_") + 1, withoutDate.length()));
	        		  if(withoutDate.contains("_") && seqNo!=0  && dateTime != 0 && version != 0){
	        			 return false;
	        		  }
	        	  }
	        	  }
	          }
	    		
	    	}
	    	
	        return true;
	    }
	 
	public static int[] merge(int[] a, int[] b) {
		int[] answer = new int[a.length + b.length];
		int i = 0, j = 0, k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				answer[k] = a[i];
				i++;
			} else {
				answer[k] = b[j];
				j++;
			}
			k++;
		}
		while (i < a.length) {
			answer[k] = a[i];
			i++;
			k++;
		}
		while (j < b.length) {
			answer[k] = b[j];
			j++;
			k++;
		}

		return answer;
	}
}
