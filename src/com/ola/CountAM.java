package com.ola;

import java.util.Collections;
import java.util.List;

public class CountAM {


	public static int count(int[] a) {
		int res = 0;
		int oCou = 0;
		if (a.length < 3) {
			return 0;
		}
		for (int i = 0; i < a.length - 2; i++) {
			if (a[i + 1] - a[i] == a[i + 2] - a[i + 1]) {
				res++;
				oCou++;
			} else {
				if (oCou > 1) {
					int real = oCou - 1;
					int com = real * (real + 1);
					res = res + com / 2;
				}
				oCou = 0;
			}
		}

		if (oCou > 1) {
			int real = oCou - 1;
			int com = real * (real + 1);
			res = res + com / 2;
		}
		return res;

	}

	public static void main(String[] as ){

		int[] a = {1,2,3,4,5,-1,1,3,6,8,0,7,8,9,10,11,2,3,4,1};

		System.out.println(count(a));
	}
	
	private void sortUsingJava8(List<String> names){
		  Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
		}
}
