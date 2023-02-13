package week1.day2.assignment;

public class Fibbinocci 

{
public static void main(String[] args) 

{
	int firstNum =0;
	int secondNum =1;
	int thirdNum = 0;
	
	System.out.println("Fibbinocci Number is: "+firstNum);
	
	for(int i=1;i<=11;i++)
	{
		thirdNum = firstNum + secondNum;
		System.out.println("Fibbinocci Number is: "+thirdNum);
		firstNum = secondNum;
		secondNum = thirdNum;
	}
}
}
