import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TestExemptCat {
   
   exemptCategories ec = new exemptCategories();
   String []str = {"books","food","medical products","luxury","electronics"};
   
   @Test
   public void testCatList() 
   {
   	  ec.addCat(str);
      assertEquals(str,ec.getCat());
   }
   
   @Test
   public void testCatRemoval()
   {
   	  String []str1 = {"food","medical products","luxury","electronics"};
   	  ec.delCat("books");
   	  assertEquals(str1,ec.getCat());
   	  
	  ec.delCat("medical");			//not a category
   	  assertEquals(str1,ec.getCat());
   }
}