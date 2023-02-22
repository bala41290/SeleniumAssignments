package week3.day1.assignment;

public class RemoveDuplicates 
{	
	public static void main(String[] args) 
	{
		
		String text= "We learn java basics as part of java sessions in java week1";
		//Initialize an integer variable as count
		int count=0;
		
		//Split the String into array and iterate over it 
		String[] textSplit = text.split(" ");
		
		for (int i = 0; i < textSplit.length; i++) 
		{			
			for(int j=1;j<textSplit.length; j++)
			{
				if(textSplit[i]==textSplit[j])
				{
					count++;
				}
			}
			if(count>1)
			{
				String replaceString = text.replace(textSplit[i],"");
				System.out.println(replaceString);
				break;
			}
		}
	}
}
