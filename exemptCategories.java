import java.util.*;
class exemptCategories
{
	private static LinkedList<String> ls = new LinkedList<String>();
	
	public void addCat(String []cat)
	{		
		for(String val:cat)
			ls.add(val);
	}	
	public void addCat1(String str)
	{
		ls.add(str);
	}
	public void delCat(String cat)
	{
		ls.remove(cat);
	}
	public String[] getCat()
	{
//		System.out.println("LL1:"+ls);
		String []obj = new String[(int)ls.size()];
		for(int i=0;i<ls.size();i++)
			obj[i] = ""+ls.get(i);
		return obj;
	}		
	public void displayCat()
	{
		String []obj =(new exemptCategories()).getCat();
			for(int i=0;i<ls.size();i++)
			System.out.print(""+(i+1)+"."+obj[i]+"\t");
	}
	public static void main(String []args)	
	{}	
}