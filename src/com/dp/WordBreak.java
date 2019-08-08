package com.dp;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public boolean findUsingDP(String s, HashSet<String> dict,
			HashSet<String> memory, String answer) {
		if (s.length() == 0) {
			System.out.println(answer);
			return true;
		} else if (memory.contains(s)) {
			return false;
		} else {

			int index = 0;
			String word = "";
			while (index < s.length()) {
				word += s.charAt(index);// add one char at a time
				// check if word already being solved
				if (dict.contains(word)) {
					if (findUsingDP(s.substring(index + 1), dict, memory,
							answer + word + " ")) {
						return true;
					} else {
						System.out.println("backtrack");
						index++;
					}
				} else {					
					index++;
				}
			}
			memory.add(s);// memoization for future;
			return false;
		}
	}

	
	   public String breakWordDP(String word, Set<String> dict){
	        int T[][] = new int[word.length()][word.length()];
	        
	        for(int i=0; i < T.length; i++){
	            for(int j=0; j < T[i].length ; j++){
	                T[i][j] = -1; //-1 indicates string between i to j cannot be split
	            }
	        }
	        
	        //fill up the matrix in bottom up manner
	        for(int l = 1; l <= word.length(); l++){
	            for(int i=0; i < word.length() -l + 1 ; i++){
	                int j = i + l-1;
	                String str = word.substring(i,j+1);
	                //if string between i to j is in dictionary T[i][j] is true
	                if(dict.contains(str)){
	                    T[i][j] = i;
	                    continue;
	                }
	                //find a k between i+1 to j such that T[i][k-1] && T[k][j] are both true 
	                for(int k=i+1; k <= j; k++){
	                    if(T[i][k-1] != -1 && T[k][j] != -1){
	                        T[i][j] = k;
	                        break;
	                    }
	                }
	            }
	        }
	        if(T[0][word.length()-1] == -1){
	            return null;
	        }
	        
	        //create space separate word from string is possible
	        StringBuffer buffer = new StringBuffer();
	        int i = 0; int j = word.length() -1;
	        while(i < j){
	            int k = T[i][j];
	            if(i == k){
	                buffer.append(word.substring(i, j+1));
	                break;
	            }
	            buffer.append(word.substring(i,k) + " ");
	            i = k;
	        }
	        
	        return buffer.toString();
	    }

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("this");
		hs.add("is");
		hs.add("sumit");
		hs.add("jain");
		hs.add("the");
		hs.add("problem");
		String s = "thisissumitjain";
		
		WordBreak ws = new WordBreak();
		HashSet<String> memoization = new HashSet<String>();
		ws.findUsingDP(s, hs, memoization, "");
	}

}