import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunnerExemptCat {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(TestExemptCat.class);
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
      System.out.println("Successful addition and removal: "+ result.wasSuccessful());
   }
}  	