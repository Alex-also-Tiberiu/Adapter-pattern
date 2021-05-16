package myAdapter.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/***
 * This class performs SubListIdioms class tests. <br>
 * @see SubListIdioms SubListIdioms. <br>
 */
public class SubListTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(SubListIdioms.class);

        for(Failure fail : result.getFailures())
            System.out.println(fail.toString());

        System.out.println(result.wasSuccessful());
    }
}