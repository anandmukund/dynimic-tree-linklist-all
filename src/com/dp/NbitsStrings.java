package com.dp;

import java.util.Arrays;

public class NbitsStrings {
	int[] arrA;

	public NbitsStrings(int n) {
		arrA = new int[n];
	}

	public void nBits(int n) {
		if (n <= 0) {
			System.out.println(Arrays.toString(arrA));
		} else {
			arrA[n - 1] = 0;
			nBits(n - 1);
			arrA[n - 1] = 1;
			nBits(n - 1);
		}
	}
	public static void Validparentheses(int openP, int closeP, String string) {
		if (openP == 0 && closeP == 0) // mean all opening and closing in
										// string,
										// print it
			System.out.println(string);
		if (openP > closeP) // means closing parentheses is more than open ones
			return;
		if (openP > 0)
			Validparentheses(openP - 1, closeP, string + "("); // put ( and
																// reduce
																// the count by
																// 1
		if (closeP > 0)
			Validparentheses(openP, closeP - 1, string + ")"); // put ) and
																// reduce
																// the count by
																// 1
	}

	public static void printParentheses(int n) {
		Validparentheses(n / 2, n / 2, "");
	}

	public static void main(String[] args) throws java.lang.Exception {
		String sss= "9dsdf";
		int iii = sss.indexOf("9");
		int n = 3;
		NbitsStrings i = new NbitsStrings(n);
		i.nBits(n);
		int on = 4;
		printParentheses(on);
	}
}