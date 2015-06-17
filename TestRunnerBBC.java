import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunnerBBC {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(TestBBC.class);
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
      System.out.println("Product and their prices and sales tax match: "+ result.wasSuccessful());
   }
}  	