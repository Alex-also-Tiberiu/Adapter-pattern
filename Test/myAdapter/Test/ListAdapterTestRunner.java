package myAdapter.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/***
 * This class performs ListAdapterTest class tests. <br>
 * @see ListAdapterTest ListAdapterTest. <br>
 */
public class ListAdapterTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ListAdapterTest.class);

        for(Failure fail : result.getFailures())
            System.out.println(fail.toString());

        System.out.println(result.wasSuccessful());
    }
}
