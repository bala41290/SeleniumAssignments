package week2.day2.assignment;

import java.util.Arrays;

public class MissingElementInAnArray {
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,7,6,8};
		int newArr=0;
		
		//Length of the array
		int arrayLength = arr.length;
		
		//sorting the array
		Arrays.sort(arr);
		
		for(int i=arr[newArr];i<=arrayLength;i++)
		{
			if(arr[newArr]==i)
			{
				newArr++;
			}
			else
			{
				System.out.println(i);
				break;
			}
		}

	}

}
