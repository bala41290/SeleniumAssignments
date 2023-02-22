package week3.day1.assignment;


public class ReverseEvenWords {
	
	public static void main(String[] args) {
		
		String test = "I am a software tester";
				
		//split the words and have it in an array
		String[] splitTest=test.split("\\s");
		
		//Traverse through each word (using loop)
		for (int i = 0; i < splitTest.length; i++) {
			//find the odd index within the loop (use mod operator)
			if (i%2==0) 
			{
				//print the even position words in reverse order using another loop (nested loop)
				System.out.print(" "+splitTest[i]+" ");
			} 
			else 
			{
				//print the even position words in reverse order using another loop (nested loop) 
				char[] reverseArray = splitTest[i].toCharArray();
				for (int j = reverseArray.length-1; j >=0; j--) 
				{				
					//Convert words to character array if the position is even print the word as it is(concatenate space at the end).
					System.out.print(reverseArray[j]);
				}
				
			}
			 
			
		}		
	}

}
