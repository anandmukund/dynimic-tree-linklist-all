import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T {
public static void main(String sa[]) {
		int a[] = {1,3,4,2,5};
		r(a);
	}

public static void  r(int[] a) {
	
	int count =0;
	Arrays.sort(a);
	List<Integer> op = new ArrayList<Integer>();
	for (int i : a)
	{
	    op.add(i);
	}
	int i = 0;
	while(i<op.size()) {
		boolean inc = false;
		for(int j=i+1; j<op.size() ; j ++) {
			int p =(int) op.get(i);
			int q = (int) op.get(j);
			if(p*2 <=  q ) {
				count++;
				op.remove(i);
				op.remove(j);
				inc = true;
				break;
				
			}
		}
		if(!inc) {
		i++;
		}
	}
	
	
}
}
