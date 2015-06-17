import java.util.*;
import java.text.*;
import java.lang.Math.*;
class bigBillsCalculator
{
	
	 DecimalFormat df = new DecimalFormat("##.##");
	 
     String product;
     double price;
     String []category;
 	 String []exempt_cat;
 	 
 	 productCategoryList pcl; 
 	 exemptCategories ec;
 	 
 	 double total=0.0, total_tax=0.0;
 	 
 	 
 	 String [] books={"1 book"};
 	 String [] food={"1 chocolate bar","1 imported box of chocolates","1 box of imported chocolates"};
 	 String [] medprod={"1 packet of headache pills"};
 	 String [] luxury={"1 imported bottle of perfume","1 bottle of perfume"};
 	 String [] electronics={"1 music cd"};

 	 
 	 
     bigBillsCalculator()
     {
    	category=new String[]{"books","food","medical products","luxury","electronics"};
		pcl = new productCategoryList();
		
		pcl.addCat(category[0],books);
		pcl.addCat(category[1],food);
		pcl.addCat(category[2],medprod);
		pcl.addCat(category[3],luxury);
		pcl.addCat(category[4],electronics);
		
		exempt_cat=new String[]{"books","food","medical products"};
		ec=new exemptCategories();
		ec.addCat(exempt_cat);
//		ec.displayCat();
//		pcl.displayCat();

	 }


	 public int findExemptCat(String items)
	 {
	 	exempt_cat=ec.getCat();
	 	String obtCat=pcl.getItemCat(items);
	 	
	 	for(String tmp:exempt_cat)
	 		if(tmp.equalsIgnoreCase(obtCat))
	 			return 1;
		return 0;
	 }
	 
	 public double calc_tax(double temp_total,String items)
	 {	 	
	 		double temp_sales_tax=0.0;
	 		//10% tax
	 		int flg=findExemptCat(items);	
        	if(flg==1);
        	else
				temp_sales_tax=(0.1*temp_total);
				
        	//5% tax on all imported goods
        	if(items.contains("imported"))
				temp_sales_tax+=(0.05*temp_total);
		
			//to apprx to nearest 0.05
            return (Math.ceil(temp_sales_tax/0.05)*0.05);
	 	
	 }
	 
	 /*
	 public void displayItems(String str,double price);
	 {
	 	System.out.print("\n"+str+":\t"+price);
	 }
	 */
	 
	 public String getBill(String str)
	 {
	
        double temp_sales_tax=0.0;
        	
	 	String []items=str.split("[\r\n]+");
	 	int size=items.length;
		for(int i=0;i<size;i++)
		{
			items[i]=items[i].replaceAll("\\bat\\b"," ").replaceAll("\\s+"," ").trim().toLowerCase();
			String []data=items[i].split(" ");
			int size1=data.length - 1;
			try
			{
				price=Double.parseDouble(data[size1]);
				if(price<=0.0)
					continue;
				temp_sales_tax=calc_tax(price,items[i].replaceAll(data[size1],""));
				price+=temp_sales_tax;
				total+=price;
				total_tax+=temp_sales_tax;
				
				System.out.print("\n"+(items[i].replaceAll(data[size1],""))+":\t"+df.format(price));			
			}
			catch(Exception e){
				System.out.println(""+e);}
			
		}	 
		System.out.println("\nSales Taxes:\t"+df.format(total_tax)+"\nTotal Bill:\t"+df.format(total)); 
	 	
	 	return (""+df.format(total_tax)+"\t"+df.format(total));
	  }

	 public void clearBill()
	 {
	 	total=0.0;
	 	total_tax=0.0;
	 }
	 
	 public static void main(String []args)
	 {
	 	System.out.println("\nBig Bill's Calculator");
	 	Scanner sc = new Scanner(System.in);
	 	
	 	bigBillsCalculator bbc=new bigBillsCalculator();
	 	
	 	String str_tmp="",str="";
	 	
	 	while(true)
	 	{
	 		str_tmp="";
	 		str="";
	 		System.out.println("Enter your Items:(* to stop)");
	 		while(true)
	 		{
	 			str_tmp=sc.nextLine();
	 			if(str_tmp.equals("*"))
	 				break;
	 			str+=str_tmp+"\n";
			}	
	 		bbc.getBill(str);
	 		str=sc.next();
	 		if(str.equals("#"))
	 			break;
	 		bbc.clearBill();
	 	}
	 
	 }
}
    