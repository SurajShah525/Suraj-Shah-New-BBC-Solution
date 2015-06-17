import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TestBBC {
   
   bigBillsCalculator bbc=new bigBillsCalculator();
   
   @Test
   public void testTaxTotal() 
   {
   	 assertEquals("1.5	29.83",bbc.getBill("1 book at 12.49\n1 music CD at 14.99\n1 chocolate bar at 0.85")); 
   	 bbc.clearBill();
   	 
   	 assertEquals("7.65	65.15",bbc.getBill("1 imported box of chocolates at 10.00\n1 imported bottle of perfume at 47.50"));
   	 bbc.clearBill();
   	 
   	 assertEquals("6.7	74.68",bbc.getBill("1 imported bottle of perfume at 27.99\n1 bottle of perfume at 18.99\n1 packet of headache pills at 9.75\n1 box of imported chocolates at 11.25")); 
     bbc.clearBill();
    
   	 assertEquals("1.5	28.98",bbc.getBill("1 book at 12.49\n1 music CD at 14.99\n1 chocolate bar at -0.85")); 	//if negative price, skip the product
   	 bbc.clearBill();
   
   }
   
}