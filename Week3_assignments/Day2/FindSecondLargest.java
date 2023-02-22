package week3.day2.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {
	
	public static void main(String[] args) {
		
		int[] data = {3,2,11,4,6,7,2,3,3,6,7};
		
		//Create a empty Set Using TreeSet
		Set<Integer> emptySet=new TreeSet<Integer>();
		
		//Declare for loop iterator from 0 to data.length and add into Set
		for (int i = 0; i < data.length; i++) {
			
			emptySet.add(data[i]);
			
		}
		System.out.println("Unique numbers from the set is: "+emptySet);
		
		//converted Set into List
		List<Integer> emptyList=new ArrayList<Integer>(emptySet);

		//Print the second last element from List
		int listSize = emptyList.size();
		
		for (int i = 0; i <= listSize; i++) {
			
			if(i==(listSize-2))
			{
				System.out.println("Second largest number from the set is: "+emptyList.get(i));
			}
				
		}
		
	}

}
