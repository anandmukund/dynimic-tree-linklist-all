package com.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Lopaid {

	
	public static void findNumber(String input) {
		
		    int setCount = 6;                                                  
		    int setSize = 7;                                                  
		    int range = 59;                                                   
		    int lucky;                                                        
		    int luckyCount;                                                   
		 
		    for(int i = 0 ; i < setCount ; ++i) {
		      int lucky1 = 0;                                                 
		      int lucky2 = 0;
		      int lucky3 = 0;
		      int lucky4 = 0;
		      int lucky5 = 0;
		      int lucky6 = 0;
		      int lucky7 = 0;
		 
		      luckyCount = 0;                                                  
		      while(luckyCount < setSize) {
		       // Generate a lucky number between 0 and 48 and add 1:
		       lucky = (int)(range*Math.random()) + 1;
		        switch(luckyCount) {
		          case 0:                                                     
		            lucky1 = lucky;                                           
		            luckyCount++;                                             
		            break;
		          case 1:                                                    
		            if(lucky != lucky1) {                                     
		              lucky2 = lucky;                                         
		              luckyCount++;                                           
		            }
		            break;
		          case 2:                                                     
		            if(lucky != lucky1 && lucky != lucky2) {
		              lucky3 = lucky;
		              luckyCount++;
		            }
		            break;
		           case 3:                                                    
		            if(lucky != lucky1 && lucky != lucky2 && lucky != lucky3) {
		              lucky4 = lucky;
		              luckyCount++;
		            }
		            break;
		           case 4:                                                   
		            if(lucky != lucky1 && lucky != lucky2 && lucky != lucky3 && lucky != lucky4) {
		              lucky5 = lucky;
		              luckyCount++;
		            }
		            break;
		           case 5:                                                   
		            if(lucky != lucky1 && lucky != lucky2 && lucky != lucky3 && lucky != lucky4 && lucky != lucky5) {
		              lucky6 = lucky;
		              luckyCount++;
		            }
		            break;
		            
		           case 6:                                                   
			            if(lucky != lucky1 && lucky != lucky2 && lucky != lucky3 && lucky != lucky4 && lucky != lucky5  && lucky != lucky6) {
			              lucky7 = lucky;
			              luckyCount++;
			            }
			            break;
		        }
		      }
		 
		                        
		 
		      System.out.print(" " + lucky1 + " " + lucky2  + " " + lucky3  + 
		                       " " + lucky4  + " " + lucky5  + " " + lucky6 + " " + lucky7);
		 
		    }
		  }
	
	
	
	
	 private static void isLottery(String number) {
         int numberOfTwoDigit = number.length() - 7;
         int numberOfSingleDigit = 7 - numberOfTwoDigit;
         Integer[] positions = {0,1, 2, 3, 4, 5, 6};
         List<Integer> positionsAvailable = Arrays.asList(positions);
          List<List<Integer>> mainListResult =  getPositions(new ArrayList<Integer>(), positionsAvailable, numberOfTwoDigit, number);

          if(!mainListResult.isEmpty()) {
     Collections.sort(mainListResult, new Comparator<List<Integer>>() {
         @Override
         public int compare(List<Integer> o1, List<Integer> o2) {
             for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
               int c = o2.get(i).compareTo(o1.get(i));
               if (c != 0) {
                 return c;
               }
             }
             return Integer.compare(o1.size(), o2.size());
           }
     });
     Collections.reverse(mainListResult); 
     for(List<Integer> mainList : mainListResult ) {
      System.out.println(number +" ->" + " " + mainList.get(0) + " " + mainList.get(1) + " " + mainList.get(2)
      + " " + mainList.get(3) + " " + mainList.get(4) + " " + mainList.get(5) + " " + mainList.get(6));
     
 }
 }
     }

    private static  List<List<Integer>> getPositions(List<Integer> positions, List<Integer> positionsRemaining, int numberRequired, String inputNumber) {
         List<List<Integer>> mainListResult = new ArrayList<>();
         if (numberRequired == 0) {
             String number = inputNumber;
             Set<Integer> numbersFromLottery = new LinkedHashSet<>();
             for (int i = 0; i < 7; i++) {
                 if (positions.contains(i)) {
                     if (Integer.parseInt(number.substring(0, 2)) > 59) {
                         break;
                     }
                     numbersFromLottery.add(Integer.parseInt(number.substring(0, 2)));
                     number = number.substring(2);
                 } else {
                     numbersFromLottery.add(Integer.parseInt(number.substring(0, 1)));
                     number = number.substring(1);
                 }
             }
             if (numbersFromLottery.size() == 7) {
                 List<Integer> mainList = new ArrayList<Integer>(numbersFromLottery);
                 mainListResult.add(mainList);
                
             }
           
         } else {
             boolean currentoutput = false;
             for (int i = 0; i < positionsRemaining.size(); i++) {
                 List<Integer> positionsLocal = new ArrayList();
                 positionsLocal.addAll(positions);
                 List<Integer> positionsRemainingLocal = new ArrayList<>();
                 positionsRemainingLocal.addAll(positionsRemaining);
                 int n = positionsRemainingLocal.get(i);
                 if (positionsLocal.isEmpty() || n > positionsLocal.get(positions.size() - 1)) {
                     positionsLocal.add(n);
                     positionsRemainingLocal.remove(i);
                    getPositions(positionsLocal, positionsRemainingLocal, numberRequired - 1, inputNumber);
                 } else {
                     continue;
                 }
             }
            
         }
 
 
  return mainListResult;
}    
	
	
	
	
	
	
	
	public static void main(String as[]) {
		
		isLottery("5198155156");
	}
	
	
	
	
	
	
	
	
	

}
