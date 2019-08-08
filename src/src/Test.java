package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class Test {
	
	public static void main(String[] args) {
		
		Map<Integer, Integer> a = new HashMap<>();
		a.put(1, 1);
		LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
		hashSet.add(10);
		hashSet.add(5);
		hashSet.add(7);
		hashSet.add(9);
		hashSet.add(8);
		hashSet.add(16);
		hashSet.add(11);
		hashSet.add(3);
		hashSet.add(5);
		List<Integer> al = new ArrayList<>(hashSet);
		System.out.println(a.get(3));
	}

}
