package myAdapter.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/***
 *
 * This class performs the tests of ListIteratorTest class. <br>
 * @see ListIteratorTest ListIteratorTest. <br>
 *
 */
public class ListIteratorTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ListIteratorTest.class);

        for(Failure fail : result.getFailures())
            System.out.println(fail.toString());

        System.out.println(result.wasSuccessful());
    }
}