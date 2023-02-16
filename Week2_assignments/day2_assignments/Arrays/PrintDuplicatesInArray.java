package week2.day2.assignment;

public class PrintDuplicatesInArray 
{
	
	public static void main(String[] args) 
	{
		
		int[] arr = {14,12,13,11,15,14,18,16,17,19,18,17,20};
		
		int arrLength = arr.length;
		System.out.println("Length of the array is: "+arrLength);
		
		
		for(int i=0;i<=arrLength-1;i++)
		{
			for(int j=i+1;j<=arrLength-1;j++)
			{
				if(arr[i]==arr[j])
				{
					System.out.println("Duplicate values in array is: "+arr[i]);
				}
			}
			
		}
	}

}
