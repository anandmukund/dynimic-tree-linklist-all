package src.tree;

public class DTest {

	 static void nextGreatest(int arr[])
	    {
	        int size = arr.length;
	 
	        // Initialize the next greatest element
	        int max_from_right =  arr[size-1];
	 
	        // The next greatest element for the rightmost
	        // element is always -1
	        arr[size-1] = -1;
	 
	        // Replace all other elements with the next greatest
	        for (int i = size-2; i >= 0; i--)
	        {
	            // Store the current element (needed later for
	            // updating the next greatest element)
	            int temp = arr[i];
	 
	            // Replace current element with the next greatest
	            arr[i] = max_from_right;
	 
	            // Update the greatest element, if needed
	            if(max_from_right < temp)
	            max_from_right = temp;
	        }
	    }
}
