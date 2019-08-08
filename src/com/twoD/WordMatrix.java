package com.twoD;

import java.util.ArrayList;
import java.util.List;

public class WordMatrix {
	public int[][] solution;
	int path = 1;

	// initialize the solution matrix in constructor.
	public WordMatrix(int N) {
		solution = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				solution[i][j] = 0;
			}
		}
	}

	public boolean searchWord(char[][] matrix, String word) {
		int N = matrix.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (search(matrix, word, i, j, 0, N)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean search(char[][] matrix, String word, int row, int col,
			int index, int N) {

		// check if current cell not already used or character in it is not not

		if (solution[row][col] != 0 || word.charAt(index) != matrix[row][col]) {
			return false;
		}

		if (index == word.length() - 1) {
			// word is found, return true
			solution[row][col] = path++;
			return true;
		}

		// mark the current cell as 1
		solution[row][col] = path++;		
		// check if cell is already used

		if (row + 1 < N && search(matrix, word, row + 1, col, index + 1, N)) { // go
																				// down
			return true;
		}
		if (row - 1 >= 0 && search(matrix, word, row - 1, col, index + 1, N)) { // go
																				// up
			return true;
		}
		if (col + 1 < N && search(matrix, word, row, col + 1, index + 1, N)) { // go
																				// right
			return true;
		}
		if (col - 1 >= 0 && search(matrix, word, row, col - 1, index + 1, N)) { // go
																				// left
			return true;
		}
		if (row - 1 >= 0 && col + 1 < N
				&& search(matrix, word, row - 1, col + 1, index + 1, N)) {
			// go diagonally up right
			return true;
		}
		if (row - 1 >= 0 && col - 1 >= 0
				&& search(matrix, word, row - 1, col - 1, index + 1, N)) {
			// go diagonally up left
			return true;
		}
		if (row + 1 < N && col - 1 >= 0
				&& search(matrix, word, row + 1, col - 1, index + 1, N)) {
			// go diagonally down left
			return true;
		}
		if (row + 1 < N && col + 1 < N
				&& search(matrix, word, row + 1, col + 1, index + 1, N)) {
			// go diagonally down right
			return true;
		}

		// if none of the option works out, BACKTRACK and return false
		solution[row][col] = 0;
		path--;
		return false;
	}

	public void print() {
		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution.length; j++) {
				System.out.print(" " + solution[i][j]);
			}
			System.out.println();
		}
	}
// split numric array to all possible digits
	public static List<Integer> getData(String input , int d){
		int count =0;
		List<Integer> output = new ArrayList<>();
		while(count + d <=input.length() ){
			output.add(Integer.parseInt((input.substring(count, count + d))));
			count ++;
		}
		return output;
	}
	// find a subset whose sum is a given no  int[] A = { 3, 2, 7, 1}, S = 6 Output: True, subset is (3, 2, 1}
	public static void find(int[] A, int currSum, int index, int sum,int[] solution) {
		if (currSum == sum) {
			System.out.println("\nSum found");
			for (int i = 0; i < solution.length; i++) {
				if (solution[i] == 1) {
					System.out.print("  " + A[i]);
				}
			}

		} else if (index == A.length) {
			return;
		} else {
			solution[index] = 1;// select the element
			currSum += A[index];
			find(A, currSum, index + 1, sum, solution);
			currSum -= A[index];	
			solution[index] = 0;// do not select the element
			find(A, currSum, index + 1, sum, solution);
		}
		return;
	}
	
	//size of longest palendoram in a string by using dp
	
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
		return LP[0][LP.length-1];
		
	}
	// x to pow y
	static float power(float x, int y)
	{
		float temp;
		if( y == 0)
			return 1;
		temp = power(x, y/2);       
		if (y%2 == 0)
			return temp*temp;
		else
		{
			if(y > 0)
				return x*temp*temp;
			else
				return (temp*temp)/x;
		}
	}  
	
	public boolean found(int[][] input , int no){
		int statrtCol = 0;
		int startRow =  0;
		int endCol = input.length;
		int endRow = input.length;
		while(statrtCol < endCol && startRow < endRow){
			  int midCol = (statrtCol + endCol) / 2;
			  int midRow = (startRow + endRow)/2;
			  if(input[midRow][midCol] == no){
				  return true;
			  } if(input[midRow][midCol] > no){
				  
				  
			  }
		}
		
		
		return false;
	}
	//String k = "ALGO" N=2 Result: AA LA GA OA AL LL GL OL AG LG GG OG AO LO GO OO
	public void print(int n, char[] k, char[] A) {
		if (n <= 0) {
			System.out.print(String.valueOf(A) + " ");
		} else {
			for (int i = 0; i < k.length; i++) {
				A[n - 1] = k[i];
				print(n - 1, k, A);
			}
		}
	}
	// min no which is not possible as a sum of all combination of given array input{1,3,4,} op: 2
	
	public int getMinNo(int[] input){
		int min = 1;
		for(int i = 0 ; i < input.length ; i++){
			if(input[i] <= min){
				min += input[i];
			} else {
				break;
			}
		}
		return min;
	}
	public static void main(String[] args) {
		power(2, 4);
		String s = "123456";
		List output = WordMatrix.getData(s, 2);
		char[][] matrix = { { 't', 'z', 'x', 'c', 'd' },
				{ 'a', 'h', 'n', 'z', 'x' }, { 'h', 'w', 'o', 'i', 'o' },
				{ 'o', 'r', 'n', 'r', 'n' }, { 'a', 'b', 'r', 'i', 'n' } };
		WordMatrix w = new WordMatrix(matrix.length);
		if (w.searchWord(matrix, "horizon")) {
			w.print();
		} else {
			System.out.println("NO PATH FOUND");
		}

	}
}
