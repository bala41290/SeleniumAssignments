package week1.day1.assignment;

public class Mobile 
{
	public static void main(String[] args) 
	{
		
		String mobileBrandName="Apple";  				//Brand of phone
		char mobileLogo='@';             				//Logo of phone
		short noOfMobilepiece= 1;        				//Total no of phone
		int modelNumber = 13;            				//Model of the phone
		long mobileimeiNumber = 4567891234569L;			//IMEI no of phone
		float mobilePrice = 120400.00F;					//Rate of the phone
		boolean isDamaged = false;						//Damaged
		
		System.out.println(mobileBrandName+" is the brand of the mobile phone");
		System.out.println(mobileLogo+" is the logo of the mobile phone");
		System.out.println(noOfMobilepiece+" is the number of available mobile phone");
		System.out.println(modelNumber+" is the model number of the mobile phone");
		System.out.println(mobileimeiNumber+" is the imei number of mobile phone");
		System.out.println(mobilePrice+" is the price of the mobile phone");
		System.out.println("Mobile is not damaged "+isDamaged);

	}
	
}