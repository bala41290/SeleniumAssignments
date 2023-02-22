package org.system;

public class Desktop extends Computer {
	
	public void desktopSize() 
	{
	
		System.out.println("Size of the desktop is 24inches");
	}
	
	public static void main(String[] args) 
	{
		Desktop singleInheritance=new Desktop();
		singleInheritance.desktopSize();
		singleInheritance.computerModel();
		singleInheritance.memorySpace();
		singleInheritance.ramSize();
	}

}
