package week3.day2.assignment;

import java.util.Arrays;

public class SortingUsingCollection {

	public static void main(String[] args) {
		
		// Declare a String array and add the Strings values as (HCL, Wipro,  Aspire Systems, CTS)
		String[] companyName= {"HCL", "Wipro",  "Aspire Systems", "CTS"};

		// get the length of the array
		int companyLength = companyName.length;
		System.out.println("Length of the array is: "+companyLength);
		
		// sort the array
		Arrays.sort(companyName);
		
		//Iterate it in the reverse order
		for (int i = companyLength-1; i >= 0; i--) {
			
			System.out.print(companyName[i]+",");
			
		}
	}

}
