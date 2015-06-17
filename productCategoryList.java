import java.util.*;
class productCategoryList
{	

	private static HashMap<String,ArrayList<String>> hmap = new HashMap<String,ArrayList<String>>();
	private ArrayList<String> as ;

	public void addCat(String prodCat,String []products)
	{
		as = new ArrayList<String>();
		for(String val:products)
			if(!as.contains(val.toLowerCase().trim()))	//to avoid duplicate entries
				as.add(val.toLowerCase().trim());
		hmap.put(prodCat.toLowerCase().trim(),as);
	}
	public void addCat(String prodCat,String product)
	{
		prodCat=prodCat.toLowerCase().trim();
		product=product.toLowerCase().trim();
		as=(ArrayList<String>)hmap.get(prodCat);
		if(as==null)
		{
			as = new ArrayList<String>();
			as.add(product);
			hmap.put(prodCat,as);
		}
		else if(!as.contains(product))
			as.add(product);
	}
	public void delCat(String cat)
	{
		hmap.remove(cat);
	}
	public void delProduct(String prodCat, String prod)
	{
		as=(ArrayList<String>)hmap.get(prodCat.toLowerCase().trim());
		as.remove(prod.toLowerCase().trim());
	}
	public int containsProd(String prodCat, String prod)
	{
		prod=prod.toLowerCase().trim();
		prodCat=prodCat.toLowerCase().trim();
		as=(ArrayList<String>)hmap.get(prodCat);
		if(as!=null && as.contains(prod))
			return 1;
		else
			return 0;
	}
	
	public String getItemCat(String prod)
	{
		for(String key:hmap.keySet())
		{
			as=(ArrayList<String>)hmap.get(key);
			if(as.contains(prod.toLowerCase().trim()))
				return key;
		}
		return "none";
	}	
	public String displayCat()
	{
		System.out.println("All available categories & products are:"+hmap);
		return (""+hmap);
	}
	public static void main(String []args)	
	{}	
}