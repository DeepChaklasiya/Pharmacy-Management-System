import java.util.*;
import java.io.*;
class Samplepro
{
	public static void main(String args[])throws Exception
	{
		String s;
		Scanner in=new Scanner(System.in);
		int flag=0,count=0;
	    System.out.println("Enter the name");
		while(true)
		{  int count1=0;
			s=in.nextLine();
			for(int i=0;i<s.length();i++)
			{   if(s.charAt(0)==' ')
		{
			flag=0;
			System.out.println("Enter a valid name");
			break;
		}
				else if(((int)s.charAt(i)>=65 && (int)s.charAt(i)<=91)|| ((int)s.charAt(i)>=97 && (int)s.charAt(i)<=122))
				{
					flag=1;count1++;
					if(count1==s.length()) break;
					continue;
				}
				else if(s.charAt(i)==' ')
				{
                   if(count==0) 
                   	{count1++;
                   	continue;}
                   count++;
                    if(count==1) 
                   {
                   	flag=0;System.out.println("Enter a valid name");
			
                   	break;
                   }
				}
			}
			if(flag==1) break;
		}
	}
}
