package com.dp;

public class EditDistanceProblem {
	 public int editDistanceDP(String s1, String s2) {
	        int [][] solution = new int[s1.length()+1][s2.length()+1];
	        
	        //base case
	        //If any of the string if empty then number of operations
	        //needed would be equal to the length of other string
	        //(Either all characters will be removed or inserted)
	        for (int i = 0; i <=s2.length(); i++) {//all elements will be inserted
	            solution[0][i] =i;
	        }

	        for (int i = 0; i <=s1.length(); i++) {//all elements will be removed
	            solution[i][0] =i;
	        }

	        //solving it bottom-up manner
	        int m = s1.length();
	        int n = s2.length();
	        for (int i = 1; i <=m ; i++) {
	            for (int j = 1; j <=n ; j++) {
	                //If last characters are matching, ignore the last character
	                // then the solution will be same as without the last character.
	                if(s1.charAt(i-1)==s2.charAt(j-1))
	                    solution[i][j] = solution[i-1][j-1];
	                else
	                    solution[i][j] = 1 +    Math.min(solution[i][j-1], //Insert
	                                            Math.min(solution[i-1][j], // Remove
	                                            solution[i-1][j-1])); //Replace
	            }
	        }
	        return solution[s1.length()][s2.length()];
	    }
	 
	 
	 public int editDistanceRecursion(String s1, String s2, int m, int n){
         //If any of the string if empty then number of operations
         //needed would be equal to the length of other string
         //(Either all characters will be removed or inserted)

         if(m==0)
             return n; //all elements will be inserted.
         if(n==0)
             return m; // all elements will be removed.

         //If last characters are matching, ignore the last character
         // and make a recursive call with last character removed.
         if(s1.charAt(m-1)==s2.charAt(n-1))
             return editDistanceRecursion(s1, s2, m-1, n-1);

         //If nothing above worked then we need to try all 3 operations
         //and choose the minimum among them
         return 1 + Math.min(editDistanceRecursion(s1, s2, m, n-1), //Insert
                 Math.min(editDistanceRecursion(s1, s2, m-1, n), // Remove
                         editDistanceRecursion(s1, s2, m-1, n-1))); //Replace
     }
	 
	 
	    public static void main(String[] args) {
	        String s1 = "horizon";
	        String s2 = "horizontal";
	        EditDistanceProblem ed = new EditDistanceProblem();
	        System.out.println("Minimum Edit Distance -(DP): " + ed.editDistanceDP(s1, s2));
	    }
}
