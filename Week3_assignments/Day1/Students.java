package week3.day1.assignment;

public class Students {
	
	public void getStudentInfo(int studentID) 
	
	{
	
		System.out.println("ID number of the student is: "+studentID);
	
	}
	
	public void getStudentInfo(int studentid,String studentName) 
	
	{
		System.out.println("Roll number of the student is: "+studentid);
		System.out.println("Name of the student is: "+studentName);
	
	}
	
	public void getStudentInfo(String studentEmail,float studentPhoneNumber) 
	
	{
		System.out.println("Email id of the student is: "+studentEmail);
		System.out.println("Phonenumber of the student is: "+studentPhoneNumber);
		
	}
	
	public static void main(String[] args) {
		
		Students newStudent=new Students();
		newStudent.getStudentInfo(19);
		newStudent.getStudentInfo(19,"Bala");
		newStudent.getStudentInfo("bala@gmail.com",8056278468F);
		
	}
}
