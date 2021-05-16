package myAdapter.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/***
 * This class performs EntrySetTest class tests. <br>
 * @see EntrySetTest EntrySetTest. <br>
 * @see MapAdapterTest MapAdapterTest. <br>
 */

public class EntrySetTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(EntrySetTest.class);

        for(Failure fail : result.getFailures())
            System.out.println(fail.toString());

        System.out.println(result.wasSuccessful());
        System.out.println(result.getFailures());

    }
}