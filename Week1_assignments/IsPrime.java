package week1.day2.assignment;

public class IsPrime 
{

	public static void main(String[] args) 
	
	{
		int primeNumber=4;
		
		for(int i=2;i<=20;i++)
		
		if(i%primeNumber==0)
		{
			System.out.println(i+" is primenumber");
		}
		else
		{
			System.out.println(i+" is not a primenumber");
		}
	}
}
