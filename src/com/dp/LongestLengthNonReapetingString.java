package com.dp;

public class LongestLengthNonReapetingString {

	static int NO_OF_CHARS = 256;
	 
    static int longestUniqueSubsttr(String str)
    {
        int n = str.length();
        int cur_len = 1;    // length of current substring
        int max_len = 1;    // result
        int prev_index;        //  previous index
        int i;
        int visited[] = new int[NO_OF_CHARS];
         
        /* Initialize the visited array as -1, -1 is 
         used to indicate that character has not been 
         visited yet. */
        for (i = 0; i < NO_OF_CHARS; i++) {
            visited[i] = -1;
        }
         
        /* Mark first character as visited by storing the
             index of first   character in visited array. */
        visited[str.charAt(0)] = 0;
         
        /* Start from the second character. First character is
           already processed (cur_len and max_len are initialized
         as 1, and visited[str[0]] is set */
        for(i = 1; i < n; i++)
        {
            prev_index = visited[str.charAt(i)];
             
            /* If the current character is not present in
           the already processed substring or it is not
              part of the current NRCS, then do cur_len++ */
            if(prev_index == -1 || i - cur_len > prev_index)
                cur_len++;
             
            /* If the current character is present in currently
               considered NRCS, then update NRCS to start from
               the next character of previous instance. */
            else
            {
                /* Also, when we are changing the NRCS, we
                   should also check whether length of the
                   previous NRCS was greater than max_len or
                   not.*/
                if(cur_len > max_len)
                    max_len = cur_len;
                 
                cur_len = i - prev_index;
            }
             
             // update the index of current character
            visited[str.charAt(i)] = i;
        }
         
        // Compare the length of last NRCS with max_len and
        // update max_len if needed
        if(cur_len > max_len)
            max_len = cur_len;
         
        return max_len;
    }
     
    public static int findLength(char[] ip){
		int[][] T = new int[ip.length][ip.length];
		for(int i = 0 ; i < ip.length ; i++){
			T[i][i] = 1;
		}
		for(int i = 0 ; i < ip.length -1 ; i++){
			if(ip[i] == ip[i+1]){
			T[i][i+1] = 1;
			} else {
				T[i][i+1] = 2;
			}
		}
		for(int gap  = 3; gap <= ip.length ; gap++){
			for(int i = 0 ; i <= T.length - gap ; i++){
				int j = i+gap -1 ;
				if(ip[i] == ip[j]){
					T[i][j] = Math.min(T[i][j-1],T[i+1][j]);
				} else {
					int min = Math.min(T[i][j-1],T[i+1][j]);
					int min1 = Math.min(min,T[i+1][j-1]);
					T[i][j] = min1+1;
				}
			}
		}

		return T[0][T.length-1];
	}
    
    
    
    /* Driver program to test above function */
    public static void main(String[] args) 
    {
        String str = "ABCAAB";
        System.out.println("The input string is "+str);
        int len = findLength(str.toCharArray());
        System.out.println("The length of "
                + "the longest non repeating character is "+len);
    }
}
