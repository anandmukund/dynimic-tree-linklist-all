import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WhatFix {

	public static void main(String[] args) {
		String a = "abc dec aaa \"aaa aaaa\" ppp ";
		String[] ar = a.split(" ");
		List<String> list = new ArrayList<String>();
		Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(a);
		while (m.find())
		    list.add(m.group(1)); // Add .replace("\"", "") to remove surrounding quotes.


		System.out.println(list);
				}

	public static int[] bes(int[] p) {
		p[1]= 7;
				return p;
	}
	
	public static boolean tt(boolean a) {
		a = true;
		return a;
	}
	public static void rrrr() {
		throw new Error();
	}
}
