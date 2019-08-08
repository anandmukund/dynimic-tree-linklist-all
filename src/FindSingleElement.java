import java.util.Arrays;


public class FindSingleElement {
    public static void find (int [] arrA){
        int singleElement =0;
        for (int i = 0; i <32 ; i++) { //this is for calculating for every position in 32 bit integer
            int y = (1 << i);
            int tempSum = 0;
            for (int j = 0; j <arrA.length ; j++) {
                if((arrA[j] & y)>=1) //if that particular bit is set for the ith position, add 1 to sum (w.r.t that bit)
                    tempSum = tempSum +1;
            }
            //if bits are not multiple of 3 then that bit belongs to the element appearing single time
            if((tempSum%3)==1) {
                singleElement = singleElement | y;
            }
        }
        System.out.println("Element appearing once is: " + singleElement);
    }

    public static void main(String[] args) {
        int arrA [] = {1, 4, 5, 6, 1, 4, 6, 1, 4, 6};
        System.out.print(Arrays.toString(arrA));
        find(arrA);
    }
    
}