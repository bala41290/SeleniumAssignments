package week3.day1.assignment;

public class ChangeOddIndexToUpperCase {
	
	public static void main(String[] args) {
		
		String test = "changeme";
		String emptyString="";
		
		// Convert the String to character array
		char[] testArray = test.toCharArray();
		
		// Traverse through each character (using loop)
		for (int i = 0; i < testArray.length; i++) 
		{
			// find the odd index within the loop (use mod operator)
			if(i%2!=0)
			{
				// within the loop, change the character to uppercase, if the index is odd else don't change
				emptyString=emptyString+testArray[i];
				System.out.print(emptyString.toUpperCase());
				emptyString="";
			}
			else
			{
			System.out.print(testArray[i]);
			}
		}
	
	}

}