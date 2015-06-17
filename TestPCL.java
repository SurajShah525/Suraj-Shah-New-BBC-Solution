import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TestPCL {
   
   static productCategoryList pcl = new productCategoryList();
 
   String [] books={"1 book","1 book"};		//duplicates shouldnt be added twice
   String [] food={"1 chocolate bar","1 imported box of chocolates","1 box of imported chocolates","1 packet of butter"};
   
   
   @Test
   public void testProdList() 
   {
   	  pcl.addCat("books",books);
   	  pcl.addCat("luxury","1 bottle of perfume");
   	  pcl.addCat("food",food);
   	  pcl.addCat("books","1 book"); 
      assertEquals("{books=[1 book], luxury=[1 bottle of perfume], food=[1 chocolate bar, 1 imported box of chocolates, 1 box of imported chocolates, 1 packet of butter]}",pcl.displayCat());
   	  assertEquals(1,pcl.containsProd("books","1 book"));
   	  assertEquals(0,pcl.containsProd("luxury","1 chocolate bar"));
	 
   }
   
   @Test
   public void testProdRemoval()
   {
      pcl.delProduct("food","1 imported box of chocolates");
   	  assertEquals(0,pcl.containsProd("food","1 imported box of chocolates"));
   }
   
   
   @Test
   public void testItemCatGet()
   {
   	  assertEquals("food",pcl.getItemCat("1 imported box of chocolates"));
   	  assertEquals("none",pcl.getItemCat("xyz"));
   }
   
}