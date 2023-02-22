package week3.day2.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MissingNumber {
	
	public static void main(String[] args) { 
	
	int[] data = {3,2,1,4,6,7,5,3,7,9};
	
	//Remove the duplicates using Set
	Set<Integer> uniqueSet=new TreeSet<Integer>();
	for (int i = 0; i < data.length; i++) 
	{
		uniqueSet.add(data[i]);
	}
    System.out.println("Unique numbers in the set: "+uniqueSet);
        
    //Converting to list
     List<Integer> uniqueList=new ArrayList<Integer>(uniqueSet);
     
    //Iterate from the starting number and verify the next number is + 1
     for (int i = 0; i < data.length;i++) 
     {
    	 if(!uniqueList.contains(i))
    	 {
    		 System.out.println("Missing number from the list is: "+i);
    	 }

     }
	}
}
