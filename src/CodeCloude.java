import java.util.ArrayList;
import java.util.List;


public class CodeCloude {

	public static int calculateHours(List<String> ip,int speed , int limit){
		int result = 0 ; 
		int count = 0;
		while(true){
			result = 0;
			for(String st : ip){
				String[] a  = st.split(" ");
				int sp = Integer.valueOf(a[0]);
				int fr = Integer.valueOf(a[1]);
				int frhr = count*fr;
				int currentSpeed = sp + frhr;
				if( (currentSpeed) >= speed){
					result = result + currentSpeed;
				}
			}
			if(result >= limit){
				break;
			} else {
				count++;
			}
		}
		return count;
	}



	public static int printNumber(char[] chars){
		//char [] chars = A.toCharArray();
		int [][]LP = new int[chars.length][chars.length]; 
		for(int i=0;i<chars.length;i++){
			LP[i][i] = 1;			
		}
		for(int sublen = 2;sublen<=chars.length;sublen++){
			for(int i=0;i<=LP.length-sublen;i++){
				int j = i+sublen-1;
				if(chars[i]==chars[j]){
					LP[i][j] = Math.min(LP[i][j-1], LP[i+1][j]);
				}
				else{
					int op= Integer.MAX_VALUE;
					for(int p =i ; p < j ; p ++){
						op = Math.min(LP[i][p]+LP[p+1][j],op);
					}
					LP[i][j] = op;
				}
			}
		}
		return LP[0][LP.length-1];
	}


	public static int CountPrinter(char[] ip){
		int[][] T = new int[ip.length][ip.length];
		for(int i = 0 ; i < ip.length ; i++){
			T[i][i] = 1;
		}
		for(int gap  = 2; gap <= ip.length ; gap++){
			for(int i = 0 ; i <= T.length - gap ; i++){
				int j = i+gap -1 ;
				if(ip[i] == ip[j]){
					T[i][j] = Math.min(T[i][j-1],T[i+1][j]);
				} else {
					int  val = Integer.MAX_VALUE;
					for(int k = i ; k < j ; k ++){
						val = Math.min(val,T[i][k]+T[k+1][j]);
					}
					T[i][j] = val;
				}
			}
		}

		return T[0][T.length-1];
	}

	 static int findPlatform(int arr[], int dep[], int n)
	{
	   int plat_needed = 1, result = 1;
	   int i = 1, j = 0;
	  
	   // Similar to merge in merge sort to process all events
	   while (i < n && j < n)
	   {
	      if (arr[i] < dep[j])
	      {
	          plat_needed++;
	          i++;
	          if (plat_needed > result)  // Update result if needed
	              result = plat_needed;
	      }
	      else // Else decrements count of platforms needed
	      {
	          plat_needed--;
	          j++;
	      }
	   }
	  
	   return result;
	}

	
	
	
	
	public static void main(String kk[]){
		/*Scanner scan = new Scanner(System.in);
		//String s = scan.next();
		String ip = scan.nextLine();
		String[] op = ip.split(" ");
		int count = Integer.valueOf(op[0]);
		List<String> aa = new ArrayList<String>();
		for(int i =0 ; i< count ; i++){
			aa.add(scan.nextLine());
		}*/
		 int arr[] = {900, 940, 950, 1100, 1500, 1800};
		 int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
		 findPlatform(arr, dep, 6);
		List<String> aa = new ArrayList<String>();
		aa.add("20 20");
		aa.add("50 70");
	    aa.add("20 90");
	    //System.out.println(calculateHours(aa, 120, 400));
		System.out.println(CountPrinter("11221122311".toCharArray()));
	}
}
