import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;


public class ValMertTest {
	
	public int CompatibilityChecker(int[] first, int[] second)
	{
		int relativeDifference = 0;
		for (int i = 0; i < first.length; i++)
		{
			if (first[i] != second[i])
			{
				int j = i + 1;
				while (first[i] != second[j])
				{
					j++;
				}
				while (j != i)
				{
					Swap(second, j, j - 1);
					j--;
					relativeDifference++;
				}

			}
		}
		return relativeDifference;
	}
	 void Swap(int[] ip , int no , int no1){
    	
    	int temp = ip[no];
    	ip[no] = ip[no1];
    	ip[no1] = temp;
    }
	
	public int getDiff(List<Integer> kout , List<Integer> dout){
		
		int k  = 0;
		int d = 0;
		int mis = 0;
		
		while(k < kout.size() && d < dout.size()){
			
			if(kout.get(k) == dout.get(0)){
				k++;
				d++;
			}  else {
				
				for(int i= d ; i<dout.size() ; i++){
					
					if(kout.get(k) == dout.get(i)){
						
					}
				}
			}
		}
		
		return 0;
	}

	public static long getMax(String lval , int sNo){
		
		while(sNo > 0){
			int count = 0;
			int i  = 0;
			while(true){
			if(Integer.valueOf(lval.charAt(i)) < Integer.valueOf(lval.charAt(i + 1))){
				if(count == 0){
				lval = String.valueOf(lval.charAt(i + 1)) +  String.valueOf (lval.charAt(i)) + lval.substring(i+2 ,lval.length());
				break;
				}
				else if(count == 1){
					lval = String.valueOf(lval.charAt(0))+ String.valueOf(lval.charAt(i + 1)) +  String.valueOf (lval.charAt(i)) + lval.substring(i+2 ,lval.length());
					break;
				} else {
					lval =  lval.substring(0,count)+ String.valueOf(lval.charAt(i + 1)) +  String.valueOf (lval.charAt(i)) + lval.substring(i+2 ,lval.length());
					break;
				}
				
			}
			i++;
			count ++;
			}
			
			sNo --;
		}
		
		return Long.valueOf(lval);
	}
	
	public static void main (String[] as){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
         Scanner s = new Scanner(System.in);
            int N = s.nextInt();
        System.out.println(getMax(line , N));
			
	}
}
