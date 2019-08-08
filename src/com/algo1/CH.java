package com.algo1;

import java.util.ArrayList;
import java.util.List;

public class CH extends PR{
	
	public static void main(String a[]){
		List<String> aq = new ArrayList<String>();
		aq.add("s");
		aq.add("s");
		aq.add("s");
		aq.add("s");
		aq.add("s");
		aq.add("s");
		aq.add("s");
		filterList(aq);
		System.out.println(aq.size());
	}
	private static void filterList(List comparableProperties){
		if(comparableProperties.size() > 4){
			comparableProperties.subList(4, comparableProperties.size()).clear();
		}
}
}
