import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class VYMO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Float> weight = new ArrayList<>();
		weight.add((float) 1.5);
		weight.add((float) 1.5);
		weight.add((float) 1.5);
		weight.add((float) 1.5);
		//weight.add((float) 1.5);
		efficientJanitor(weight);
	}

	public static int efficientJanitor(List<Float> weight) {
	    // Write your code here
	    int result =0;
	    
	    if(!weight.isEmpty()) {
	    	
	    	Collections.sort(weight);
	    	int i =0;
	    	int j = weight.size() -1;
	    	while(i<=j) {
	    		
	    		if(weight.get(i) + weight.get(j) <= 3.0) {
	    			result = result + 1;
	    			i++;
	    			j--;
	    		} else {
	    			result = result + 1;
	    			j--;
	    		}
	    	}
	    }

	    return result;

	    }
}
