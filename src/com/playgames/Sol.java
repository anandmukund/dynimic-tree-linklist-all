package com.playgames;

public class Sol {
	 static int count = 0;
	    public static int countArrangement(int N) {
	        boolean[] visited = new boolean[N + 1];
	        calculate(N, 1, visited);
	        return count;
	    }
	    public static void calculate(int N, int pos, boolean[] visited) {
	        if (pos > N)
	            count++;
	        for (int i = 1; i <= N; i++) {
	            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
	                visited[i] = true;
	                calculate(N, pos + 1, visited);
	                visited[i] = false;
	            }
	        }
	    }
	public static void main(String[] args) {
		System.out.println(countArrangement(4));
	}

}