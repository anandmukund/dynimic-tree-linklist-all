
public class FlipKart {

	 public static void main(String[] args){
		 int[] ip  = {3,3,2,1};
		 checkReverse(ip, ip.length);
	 }
	
	public static void checkReverse(int arr[], int n)
	{
	    if (n == 1){
	        System.out.println("yes");
	    }
	 
	    int i;
	    int count = 1;
	    for (i=1; i < n ; i++){
	    	if(arr[i-1] < arr[i]){
	    		count++;
	    		if (i == n){
	   	    	 System.out.println("yes");
	   	    }
	    	}
	    	else {
	    		  int j  = 0;
	    		if(count >= i){
	     j = count;
	    		} else {
	    			j = i;
	    		}
	    while (j<n && arr[j] < arr[j-1] )
	    {
	        if (i > 1 && arr[j] < arr[i-2]){
	        	System.out.println("no");
	        	break;
	        }
	        j++;
	    }
	 
	    if (j == n){
	    	System.out.println("yes");
	         System.out.println(arr[i-1] + " " + arr[n-1] );
	    }
	      i = j;
	    }
	    }
	 
	}
}
