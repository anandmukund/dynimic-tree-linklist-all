package com.dp;

import java.util.HashMap;
import java.util.Stack;

public class TrackMaxInStack {

	// objective here is to keep track of maximum value in a stack of integers
	// create another another Stack which will keep track of maximum
	Stack<Integer> main = new Stack<>();
	Stack<Integer> track = new Stack<>();

	public void insert(int x) {
		if (main.isEmpty()) { // if stack is empty, insert the number in both
								// stacks
			main.add(x);
			track.add(x);
		} else {
			// check if number in Stack(track) is bigger than x
			// which ever is bigger, insert it into Stack

			int a = track.peek();
			track.add(Math.max(a, x));
			main.add(x); // insert it into main stack.
		}
	}
	public int remove() {
		if (!main.isEmpty()) { // pop the top elements
			track.pop();
			return main.pop();
		}
		return 0;
	}

	public int getMax() {
		return track.peek();
	}

	
	
	// no of min cuts to split a string to minimum no of palindrome 
	public int splitRecursion(String x){
		if(x=="" || isPalindrome(x)){
//			System.out.println(x);
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
	// Same using DP 
	static HashMap<String,Integer> solutions = new HashMap<String, Integer>();

	public int splitDP(String x){
		if(x=="" || isPalindrome(x)){
//			System.out.println(x);
			return 0;
		}else{
			int cuts = Integer.MAX_VALUE;
			for (int i = 1; i <x.length() ; i++) {
					int leftSolution =0;
					int rightSolution = 0;
					String leftPart = x.substring(0,i);
					String rightPart = x.substring(i,x.length());
					if(solutions.containsKey(leftPart)){
						leftSolution = solutions.get(leftPart);
					}else{
						leftSolution = splitDP(leftPart);
						solutions.put(leftPart,leftSolution);
					}
				if(solutions.containsKey(rightPart)){
					rightSolution = solutions.get(rightPart);
				}else{
					rightSolution = splitDP(rightPart);
					solutions.put(rightPart,rightSolution);
				}
				cuts  = Math.min(1+ leftSolution  + rightSolution,cuts);
			}
			return cuts;
		}
	}
	
	public static void main(String[] args) {
		TrackMaxInStack i = new TrackMaxInStack();
		i.insert(4);
		i.insert(2);
		i.insert(14);
		i.insert(1);
		i.insert(18);
		System.out.println("Max Element is " + i.getMax());
		System.out.println("Removing Element " + i.remove());
		System.out.println("Max Element is " + i.getMax());
	}

}