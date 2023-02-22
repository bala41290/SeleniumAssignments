package week3.day2.assignment;


import java.util.LinkedHashSet;
import java.util.Set;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

public class RemoveDuplicates {

	public static void main(String[] args) {
//		Declare a String as "PayPal India"
		String cName="PayPal India";
		String replaceAll = cName.replaceAll("\s","");
		String cNameLowerCase = replaceAll.toLowerCase();
		
		
//		Convert it into a character array
		char[] cNameToArray = cNameLowerCase.toCharArray();
		
		
//		Declare a Set as charSet for Character
		Set<Character> charSet=new LinkedHashSet<Character>();
		
//		Declare a Set as dupCharSet for duplicate Character
		Set<Character> dupCharSet=new LinkedHashSet<Character>();
		
//		Iterate character array and add it into charSet
		for (int i = 0; i < cNameToArray.length; i++) {
						
			boolean charSetAdd = charSet.add(cNameToArray[i]);
						
//			if the character is already in the charSet then, add it to the dupCharSet	
			if(!charSetAdd) 
			{
				boolean dupSetAdd = dupCharSet.add(cNameToArray[i]);
			}

		}
//		Check the dupCharSet elements and remove those in the charSet			
		SetView<Character> charSetDifference = Sets.difference(charSet, dupCharSet);
		System.out.println(charSetDifference);
		System.out.println(dupCharSet);
		}

}
