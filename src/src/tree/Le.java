package src.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Le {

	
	public static String modify(List<String> ip , int re , int de){
		
	     StringBuffer op = new StringBuffer();
	     if(ip.size() > 0){
	    	 int co = 0;
	     for(int i = 0 ; i < ip.size() ; i++){
	    	 if(op.length() == 0){
	    		 op.append(ip.get(i));
	    		 continue;
	    	 } 
	    	 if(co % re != 0){
	    		 op.append(",");
	    		 op.append(ip.get(i));
	    		 
	    	 } else {
	    		 i = i + de;
	    		 co = 0;
	    	 }
	     }
	     }
		 return op.toString();
}
	
	
	 public static String[] modify1(List<String> ip , int re , int de){
		 String[] op = null;
		 int count = 0;
	     int len = 0;
	     if(ip.size() > 0){
	     while(true){
	            if(count == re){
	                int st = de ;
	                count = 0;
	                while(st > 0){
	                ip.remove(len);
	                st --;
	                }
	            } else {
	                if(len == ip.size()){
	                	break;
	                }
	                count ++;
	                len ++;
	            }
	        }
	     op =  ip.toArray(new String[0]);
	     }
		 return op;
	 }
	
	
	
	 
	public static void main(String a[]){
		getCount(6, 2);
		String str = "((())))";
        System.out.println(findMaxLen(str)); 
	       
		String aa = "1,2,3,4,5,6,10,8";
		List<String> myList = new ArrayList<String>(Arrays.asList(aa.split(",")));
		 System.out.println( modify(myList,3,1));
	}
	
	

//max  length of a valid pattern of "()()()" 
	static int findMaxLen(String str)
	{
	    int n = str.length();
	    Stack<Integer> stk = new Stack<>();
	    stk.push(-1);
	    int result = 0;
	    for (int i=0; i<n; i++)
	    {
	        if (str.charAt(i) == '(')
	          stk.push(i);
	        else 
	        {
	            stk.pop();
	            if (!stk.empty())
	                result = Math.max(result, i - stk.peek());
	 
	            else stk.push(i);
	        }
	    }
	 
	    return result;
	}
	
	 public static int getCount(int girl , int boys){
	        
	        if(boys == 1){
	            if(girl%2 == 0){
	                return girl/2;
	            } else {
	            	return girl/2 + 1;
	            }
	        }
	        else {
	        	int r = girl/boys;
	        	int f = girl%boys;
	        	if(r%2 == 0){
	        		return r+f;
	        	} else {
	        		return r-1+f;
	        	}
	        }
	        
	    }
}
