
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class QuestionOne {

	private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	private static int counter = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int arr[] = new int[Integer.parseInt(input)];
		
		int arrOne[] = new int[arr.length];
		int arrTwo[] = new int[arr.length];
		
		input = br.readLine();
		populateArray(arrOne, input);
		
		input = br.readLine();
		populateArray(arrTwo, input);
		
		populateMap(arrTwo);
		
		processToFindCompatibility(arrOne, arrTwo);
		System.out.println(counter);
	}

	private static void processToFindCompatibility(int[] arrOne, int[] arrTwo) {
		for (int i = 0; i < arrOne.length; i++) {
			if (arrOne[i] != arrTwo[i]) {
				int index = map.get(arrOne[i]);
				swap(i, index, arrTwo);
				counter++;
			}
		}
	}

	private static void swap(int i, int index, int[] arr) {
		map.put(arr[i], index);
		map.put(arr[index], i);
		
		int a = arr[index];
		arr[index] = arr[i];
		arr[i] = a;
	}

	
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
	
	 private static void Swap(int[] ip , int no , int no1){
	    	
	    	int temp = ip[no];
	    	ip[no] = ip[no1];
	    	ip[no1] = temp;
	    }
	
	
	
	
	private static void populateMap(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}
	}

	private static void populateArray(int[] arr, String input) {
		String str[] = input.split(" ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
	}
	
	
}