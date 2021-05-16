package myAdapter.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/***
 * This class performs CollectionValuesTest class tests. <br>
 * @see CollectionValuesTest CollectionValuesTest. <br>
 * @see MapAdapterTest MapAdapterTest. <br>
 */
public class CollectionValuesTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(CollectionValuesTest.class);

        for(Failure fail : result.getFailures())
            System.out.println(fail.toString());

        System.out.println(result.wasSuccessful());
    }
}