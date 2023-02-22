package week3.day2.assignment;

public class Automation extends MultipleLangauge  {
	
	public void Selenium() 
	
	{
		
		System.out.println("From TestTool Interface: Selenium is used for webapplication automation");
		
	}

	public void Java() 
	
	{
		
		System.out.println("From Language Interface: Java is programming lanuage used for selenium automation");
		
	}
	
	@Override
	public void ruby() 
	
	{
		
		System.out.println("From MultipleLanguage Abstract Class: Ruby is programming lanuage used for selenium automation");
		
	}

	public static void main(String[] args) 
	
	{
		Automation automationTool=new Automation();
		automationTool.Selenium();
		automationTool.Java();
		automationTool.python();
		automationTool.ruby();

	}





}
