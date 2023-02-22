package org.student;

import org.department.Department;

public class Student extends Department 
{
	
	public void studentName(String sName) 
	{
		System.out.println("Name of the student is: "+sName);
	}
	
	public void studentDept(String sDept)
	{
		System.out.println("Department of the student is: "+sDept);
	}
	
	public void studentId(int sID) {
	
		System.out.println("ID number of the student is: "+sID);
	}
	
	public static void main(String[] args) {
		
		Student newStudent=new Student();
		
		newStudent.collegeName("VIT");
		newStudent.collegeCode(422);
		newStudent.collegeRank(10);
		newStudent.deptName("Computer Science, Mechanical, Civil, EEE, ECE");
		newStudent.studentName("Bala");
		newStudent.studentId(19);
		newStudent.studentDept("Mechanical");
		
	}

}
