package com.dp;

public class LongestPalindromicSubsequence {

	public int findPalindrome(String A){
		char [] chars = A.toCharArray();  //Convery string to character array..
		int [][]LP = new int[chars.length][chars.length]; 
		//LP[i][j] - length of palindrome from ith index to jth index
		// all the characters in the string are palindrome by itself of length 1.
		//So all LP[i][i] =  1 
		for(int i=0;i<chars.length;i++){
			LP[i][i] = 1;			
		}
		for(int sublen = 2;sublen<=chars.length;sublen++){
			for(int i=0;i<=LP.length-sublen;i++){
				int j = i+sublen-1;
				if(chars[i]==chars[j] && sublen==2){
					LP[i][j] = 2;
				}
				else if(chars[i]==chars[j]){
					LP[i][j] = LP[i+1][j-1]+2;
				}
				else{
					LP[i][j] = Math.max(LP[i+1][j],LP[i][j-1]);
				}
			}
		}
		printMatrix(LP);
		return LP[0][LP.length-1];
		
	}
	
	
	//Longest sequence palindromic 
	
	public int longestPalindromeDynamic(char []str){
        boolean T[][] = new boolean[str.length][str.length];
        
        for(int i=0; i < T.length; i++){
            T[i][i] = true;
        }
        
        int max = 1;
        for(int l = 2; l <= str.length; l++){
            int len = 0;
            for(int i=0; i < str.length-l+1; i++){
                int j = i + l-1;
                len = 0;
                if(l == 2){
                    if(str[i] == str[j]){
                        T[i][j] = true;
                        len = 2;
                    }
                }else{
                    if(str[i] == str[j] && T[i+1][j-1]){
                        T[i][j] = true;
                        len = j -i + 1;
                    }
                }
                if(len > max){
                    max = len;
                }
            }
        }
        return max;
    }
	public void printMatrix(int [][] LP){
		for(int i=0;i<LP.length;i++){
			for(int j=0;j<LP.length;j++){
				System.out.print("  " + LP[i][j]);
			}	
			System.out.println("");
		}
	}
	
	public static void main(String arg[]){
		String strA = "AABCDEBAZ";
		LongestPalindromicSubsequence i = new LongestPalindromicSubsequence();
		int x = i.findPalindrome(strA);
		System.out.println("Length of Longest Palindrome in '" + strA + "' is- " + x);
	}
}
