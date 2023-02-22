package week3.day2.assignment;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueCharacter {

	public static void main(String[] args) {
		
		String name="character";
		
		//Convert String to Character array
		char[] nameArray = name.toCharArray();

		//Create a new Set -> HashSet
		Set<Character> setHashSet=new HashSet<Character>();
		
		//Add each character to the Set and if it is already there, remove it		
		
		for (int i = 0; i < nameArray.length; i++) {
			
			boolean setAdd = setHashSet.add(nameArray[i]);
			
			if(!setAdd)
			{
				setHashSet.remove(nameArray[i]);
			}
			
		}

			System.out.println("Unique Character in the name is: "+setHashSet);	

			
		}
		
	}

