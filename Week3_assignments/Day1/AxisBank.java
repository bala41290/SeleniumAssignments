package week3.day1.assignment;

public class AxisBank extends BankInfo{
	
	public void deposit(float depositLimit) 
	{
		System.out.println("Per day depositLimit in the bank is: "+depositLimit);

	}
	
	public static void main(String[] args) {
		
		AxisBank ab=new AxisBank();
		ab.fixed(15.1);
		ab.saving(100);
		ab.deposit(500000);
				
	}

}
