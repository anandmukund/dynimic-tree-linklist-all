package general;

public class ArrayRelated {

	/*
	Input :   arr[] = {10, 40, 23, 35, 50, 7}
    Output :  3
    The elements are 10, 40 and 50.
     Input :   arr[] = {5, 4, 1}
        Output :  1*/
	// Method to count elements that are greater than all
    // previous elements
    static int countElements(int arr[], int n)
    {
        // First element will always be considered as greater
        // than previous ones
        int result = 1;
      
        // Store the arr[0] as maximum
        int max_ele = arr[0];
      
        // Traverse array starting from second element
        for (int i=1; i<n; i++)
        {
            // Compare current element with the maximum
            // value if it is true otherwise continue
            if (arr[i] > max_ele)
            {
                // Update the maximum value
                max_ele = arr[i];
      
                // Increment the result
                result++;
            }
        }
      
        return result;
    }
}
