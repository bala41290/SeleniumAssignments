package week3.day2.assignment;

import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicatesWords {

	public static void main(String[] args) {
		
		String text = "We learn java basics as part of java sessions in java week1";
		
		//Split the String based on white spaces and save as String Array ,Then iterate the Array
		String[] splitText = text.split("\s");
		
		
		Set<String> emptyString=new TreeSet<String>();
		
		
		for (int i = 0; i < splitText.length; i++) {
			
			
			boolean addToSet = emptyString.add(splitText[i]);
			
			if(addToSet)
			{
				System.out.print(splitText[i]+" ");
			}
			
			
		}

	}

}
