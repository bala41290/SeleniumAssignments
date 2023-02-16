package week2.day2.assignment;

import java.util.Arrays;

public class FindSecondLargest {
	
	public static void main(String[] args) {
		
		int[] data = {3,2,11,4,6,7};
		
		//Length of the Array
		int dataLength=data.length;

		//Sorting of Array
		Arrays.sort(data);
		
		// Pick the 2nd element from the last and print it
		for(int i=dataLength-1;i>=0;i--)
		{
			if(i==(dataLength-2))
			{
			System.out.println("Second largest element from the last is: "+data[i]);
			}
		}
	
	}

}