package com.algo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.algo1.BinaryTreeTest.Node;

public class ZeroShifting {

	// seperate a array by non zero and zero side by side
	public static int[] result(int[] input){
		
		int i =0; 
		int j = 0;
		
		while(i<input.length){
			if(input[i] == 0 ){
				j++;
				i++;
			}
			else{
				
				 int temp = input[i-j];
				 input[i-j] = input[i];
				 input[i] = temp;
				 i++;
			}
		}
		
		return input;
	}
	public String longestPalindrome(String s) {
		if (s.isEmpty()) {
			return null;
		}
	 
		if (s.length() == 1) {
			return s;
		}
	 
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			// get longest palindrome with center of i
			String tmp = helper(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
	 
			// get longest palindrome with center of i, i+1
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
	 
		return longest;
	}
	 
	// Given a center, either one letter or two letter, 
	// Find longest palindrome
	public String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}
	// longest palindrome in a string
	 public static String getLongestPalindrome(final String input) {
	        int rightIndex = 0, leftIndex = 0;
	        String currentPalindrome = "", longestPalindrome = "";
	        for (int centerIndex = 1; centerIndex < input.length() - 1; centerIndex++) {
	            leftIndex = centerIndex - 1;  rightIndex = centerIndex + 1;
	            while (leftIndex >= 0 && rightIndex < input.length()) {
	                if (input.charAt(leftIndex) != input.charAt(rightIndex)) {
	                    break;
	                }
	                currentPalindrome = input.substring(leftIndex, rightIndex + 1);
	                longestPalindrome = currentPalindrome.length() > longestPalindrome.length() ? currentPalindrome : longestPalindrome;
	                leftIndex--;  rightIndex++;
	            }
	        }
	        return longestPalindrome;
	    }
	 //min jump to reach end of a array
	 
	 public static int minJump(int[] a , int size , int mi , int mx , int count ){

		 if (mx >= size){
			 return count;
		 }
		 int maxV = a[mi] + mi;
		 int index =mi;
		 for(int i = mi ; i <mx ; i++) {
			 if(i + a[i] == size ){
				 maxV =  a[i];
			     index = i;
				 break;
			 } 
			 if(maxV < a[i] + i){
				 maxV = a[i];
				 index =i;
				 break;
			 }

		 }

		 return minJump(a ,  size , index+1 , index+1 + maxV ,  ++count );

	 }
	 // min jump dymanic 
	 private static int minJumps(int[] arr, int n) { 
		    int jumps[] = new int[n];  // jumps[n-1] will hold the 
		                               // result
		    int i, j;
		          
		    if (n == 0 || arr[0] == 0)
		         return Integer.MAX_VALUE;  // if first element is 0,
		                                   // end cannot be reached
		          
		    jumps[0] = 0;
		          
		    // Find the minimum number of jumps to reach arr[i]
		    // from arr[0], and assign this value to jumps[i]
		    for (i = 1; i < n; i++)
		    {
		        jumps[i] = Integer.MAX_VALUE;
		         for (j = 0; j < i; j++)
		         {
		              if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE)
		              {
		                  jumps[i] = Math.min(jumps[i], jumps[j] + 1);
		                  break;
		              }
		          }
		    }
		        return jumps[n-1];
		    }
	 
	 // All anagram for a given string
	 public static String getAnagramsTogether( String[] words){
	        HashMap<String,List<String>> map =new HashMap<String,List<String>>();
	        for(String word:words)
	        {
	            char[] wordArray = word.toCharArray();
	            Arrays.sort(wordArray);

	            List<String> tempList = map.get(new String(wordArray));
	            if(tempList == null) tempList = new ArrayList<String>(); 
	            tempList.add(word);
	                            map.put(new String(wordArray),tempList);
	        }
	        StringBuilder result = new StringBuilder();
	        for(Map.Entry<String, List<String>> entry : map.entrySet())
	        {

	            for(String item:entry.getValue()){
	                result.append(item+ " ");
	            }
	        }


	        return result.toString();
	    }


	 //search in 2d array sort by L to R and T to B
	 public static boolean search(int[][] mat, int length, int searchedNo)
	 {
		boolean found = false;
	    int i = 0, j = length-1;  //set indexes for top right element
	    while ( i < length && j >= 0 )
	    {
	       if ( mat[i][j] == searchedNo )
	       {
	    	   found = true;
	       }
	       if ( mat[i][j] > searchedNo ){
	         j--;
	       }
	       else {
	         i++;
	       }
	    }
	  
	    return found;  // if ( i==n || j== -1 )
	 }
	  // mearge 2 sorted array as a final sorted array
	 public static int[] merge(int[] a, int[] b) {

		    int[] answer = new int[a.length + b.length];
		    int i = 0, j = 0, k = 0;
		    while (i < a.length && j < b.length)
		    {
		        if (a[i] < b[j])
		        {
		            answer[k] = a[i];
		            i++;
		        }
		        else
		        {
		            answer[k] = b[j];
		            j++;
		        }
		        k++;
		    }

		    while (i < a.length)
		    {
		        answer[k] = a[i];
		        i++;
		        k++;
		    }

		    while (j < b.length)
		    {
		        answer[k] = b[j];
		        j++;
		        k++;
		    }

		    return answer;
		}
	 //mearge 2 sorted array as a final sorted array
	 public static int[] merge1(int[] a, int[] b) {
		    int[] answer = new int[a.length + b.length];
		    int i = a.length - 1, j = b.length - 1, k = answer.length;

		    while (k > 0){
		        answer[--k] = (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--];
		    }
			return answer;
		}
	 //Intrersection point of two sorted array
	 public int intersection(int[] arrA, int[] arrB) {
		 int intersectionPoint = -1;
			int x = 0;
			int y = 0;
			while (x < arrA.length && y < arrB.length) {
				if (arrA[x] > arrB[y])
					y++;
				else if (arrA[x] < arrB[y])
					x++;
				else {
					intersectionPoint = arrA[x];
					return intersectionPoint;
				}
			}
			return intersectionPoint;
		}
	// binary Search 
	 public int binarySearch(int[] inputArr, int key) {
         
	        int start = 0;
	        int end = inputArr.length - 1;
	        while (start <= end) {
	            int mid = (start + end) / 2;
	            if (key == inputArr[mid]) {
	                return mid;
	            }
	            if (key < inputArr[mid]) {
	                end = mid - 1;
	            } else {
	                start = mid + 1;
	            }
	        }
	        return -1;
	    }
	  // by using binary Search means complexcity should be O(log n)
	 public static boolean noIsSquare(int number) {
         
	        int start = 0;
	        int end = number/2;
	        while (start <= end) {
	            int mid = (start + end) / 2;
	            if (mid * mid == number) {
	                return true;
	            }
	            if (mid * mid > number) {
	                end = mid - 1;
	            } else {
	                start = mid + 1;
	            }
	        }
	        return false;
	    }
	  // rotation of a sorted array
	static  int FindSortedArrayRotation(int A[], int N) {
		  int L = 0;
		  int R = N - 1;
		  
		  while (A[L] > A[R]) {
		    int M = L + (R - L) / 2;
		    if (A[M] > A[R])
		      L = M + 1;
		    else
		      R = M;
		  }
		  return L;
		}
	 // find the minimum integer which in not be the sum of the elements of  sorted array// Array {1,2,6,7,9} smallest Number : 4
	public int find(int [] arrA){
		int smlNumber = 1;
		for(int i = 0;i<arrA.length;i++){
			if(arrA[i]<=smlNumber){
 				smlNumber += arrA[i];
 			}else{
 				break;
 			}
		}
 		return smlNumber;
 	}
	
	
	public void printData(Node node , Node leftChild ){

	    
		if(node != null ) {
			if(node.right != null){
				// sy(node.data);

				printData(node.right , node.left);
			} else {

				if(leftChild!= null){
					if(leftChild.right != null){
						// syso(leftChild .right);
						printData(leftChild .right , leftChild .left);
					} else {
						// syso(leftChild .left);
						printData(leftChild .left, null);

					}
				}}}     


	  
	}
// no of count in a given sorted array , applying the approach of binary search 
	 public static int count(int[] input , int number){
	 
	 int start = 0 ; 
	 
	 int end = input.length-1;
	 
	 while(start < end) {
	 
	 int mid = start + (end-start)/2;
	 
	 if(input[mid] == number){
	    int left = mid-1;
	    int right = mid + 1;
	    int count = 1;
	    while(true){
	    if(input[left] == number){
	    count ++;
	    left --;
	    
	    }
	     if(input[right] == number){
	    count ++;
	    right ++;
	    
	    }
	    if(input[right] != number && input[left] != number){
	      return count;
	    }
	    }
	 }
	    else {
	    if(input[mid] > number){
	    end = mid;
	    
	    }
	       else {
	       start = mid -1;
	       
	       }
	    }
	 
	 }
	return 0;
	 
	 }
	 
	//rearrange -ve and + ve no side by side
	 public static int[] rearrange(int[] input){
			
			int i =0; 
			int j = 0;
			
			while(i<input.length){
				if(input[i] > 0 ){
					j++;
					i++;
				}
				else{
					
					 int temp = input[i-j];
					 input[i-j] = input[i];
					 if(j > 1){
						shift(input, j, i, temp); 
					 }
					 else {
					 input[i] = temp;
					 }
					 i++;
				}
			}
			
			return input;
		}
	 
	 public static void shift(int[] a , int c , int p , int temp){
		 
		 for(int i = 0 ; i <= c ; i ++){
			 
			 a[p-i] = a[p-i-1];
			 
			 if(i == c){
				 a[p-c] = temp;
			 }
		 }
	 }
	 
	// maximum sum for a contigues arrays
		 public static int KandaneModify(int[] arrA) {
				int max_end_here = arrA[0];
				int max_so_far = arrA[0];
				for(int i=1;i<arrA.length;i++){
					max_end_here = Math.max(arrA[i], max_end_here+arrA[i]);
					max_so_far = Math.max(max_so_far,max_end_here);
				}
				return max_so_far;
			}
		 
		 // find dupilcate in string
		 public static Boolean UniChars(String ip) {
				Boolean[] bln = new Boolean[256];
				for (int i = 0; i < 256; i++) {
					bln[i] = false;
				}
				for (int i = 0; i < ip.length(); i++) {
					char a = ip.charAt(i);
					if (bln[a] == true) {
						return false;
					} else {
						bln[a] = true;
					}
				}

				return true;
			}
		 
		// no of connected iceland 
		 static final int ROW = 5, COL = 5;

		 boolean isSafe(int M[][], int row, int col,
				 boolean visited[][])
		 {
			 return (row >= 0) && (row < ROW) &&
					 (col >= 0) && (col < COL) &&
					 (M[row][col]==1 && !visited[row][col]);
		 }
		 void DFS(int M[][], int row, int col, boolean visited[][])
		 {
			 int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
			 int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
			 visited[row][col] = true;
			 for (int k = 0; k < 8; ++k)
				 if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited) )
					 DFS(M, row + rowNbr[k], col + colNbr[k], visited);
		 }

		 int countIslands(int M[][])
		 {
			 boolean visited[][] = new boolean[ROW][COL];
			 int count = 0;
			 for (int i = 0; i < ROW; ++i)
				 for (int j = 0; j < COL; ++j)
					 if (M[i][j]==1 && !visited[i][j]) {
						 DFS(M, i, j, visited);
						 ++count;
					 }

			 return count;
		 }

		         /*String x = "xabaay"
				 5 cuts makes all the substrings palindrome : x, a, b, a, a, y
				 4 cuts makes all the substrings palindrome : x, a, b, aa, y
				 3 cuts makes all the substrings palindrome : x, aba, a, y
				 Output: 3 cuts*/
		 public int splitRecursion(String x){
				if(x=="" || isPalindrome(x)){
//					System.out.println(x);
					return 0;
				}else{
					int cuts = Integer.MAX_VALUE;
					for (int i = 1; i <x.length() ; i++) {
						cuts  = Math.min(1+ splitRecursion(x.substring(0, i)) + splitRecursion(x.substring(i, x.length())),cuts);
					}
					return cuts;
				}
			}
			public boolean isPalindrome(String s){
				int n = s.length();
				  for (int i=0;i<(n / 2) + 1;++i) {
				     if (s.charAt(i) != s.charAt(n - i - 1)) {
				         return false;
				     }
				  }
				  return true;
			}
			/*A child is climb­ing up a stair­case with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time.
			 *  Imple­ment a method to count how many pos­si­ble ways the child can jump up the stairs.
			 * Number of stairs : 3
			Number of ways = 4 ( {1,1,1}, {1,2}, {2,1}, {3} )*/
			public int possibleWays(int n) {
				if (n < 1) {
					return 0;
				}
				return 1 + possibleWays(n - 1) + possibleWays(n - 2)
						+ possibleWays(n - 3);
			}
			
				public int poosibleWaysDyna(int n, int[] dyn) {
					if (n < 1) {
						return 0;
					}
					if (dyn[n] > 0) {
						return dyn[n];
					}
					dyn[n] = 1 + poosibleWaysDyna(n - 1, dyn) + poosibleWaysDyna(n - 2, dyn)
							+ poosibleWaysDyna(n - 3, dyn);
					return dyn[n];
				}
				
				/*dictionary = ["I" , "have", "Jain", "Sumit", "am", "this", "dog"]
						String = "IamSumit"
						Output: "I am Sumit"*/	
				
				public void wordBreak(String s, HashSet<String> hs) {
					if (find(s, hs, "")) {
					} else {
						System.out.println("Cant Break");
					}
				}

				public boolean find(String s, HashSet<String> dict, String answer) {
					// System.out.println(s + "  " + answer);
					if (s.length() == 0) {
						System.out.println(answer);
						return true;
					} else {
						int index = 0;
						String word = "";
						while (index < s.length()) {
							word += s.charAt(index);// add one char at a time
							// check if word exists in dictionary				
							if (dict.contains(word)) {
								//add word to the answer and make a recursive call
								if (find(s.substring(index + 1), dict, answer + word + " ")) {
									return true;
								} else {
									//System.out.println(word + "  backtrack");
									index++;
								}
							} else {
								index++;
							}
						}
						return false;
					}
				}
	public static void main(String s[]){
		/*UniChars("Sumit_Jain");
		int[] a = { 1, -2, -3, -4, 5, -6, 7, -8, 9, -10, -11, -12, 20 };
		int arrA[] = { 1, 2, -3, -4, 2, 7, -2, 3 };
		KandaneModify(arrA);
		rearrange(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}*/
		int[] pq = {15, 14, 13, 12, 11 ,10, 9, 8, 7, 6 ,5 ,4 ,3 ,2 ,1 ,2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10 ,11 ,12 ,13 ,14 ,15 ,16};
		int oo = minJump(pq, pq.length, 0, 0, 0);
		int[] p = {1,1,1,3,3,4,4,5,5,66,66,66,76,76};
		System.out.println(count(p, 5));
		int[] t = {7,8,9,1,2,3,4,5};
		System.out.println(FindSortedArrayRotation(t,8));
		System.out.println(noIsSquare(91));
		String d = "sfsfdgsdfaaaaasaaaaaaaaaaaaasdasjfdsfldfvsn";
		System.out.println(getLongestPalindrome(d));
		int[] o = {0,0,0,4,5,5,0};
		
		System.out.println(result(o));
		
		for(int i =0 ; i<o.length ; i ++){
			System.out.println(o[i]);
		}
	}
}
