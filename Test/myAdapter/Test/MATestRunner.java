package myAdapter.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MATestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MapAdapterTest.class);

        for(Failure fail : result.getFailures())
            System.out.println(fail.toString());

        System.out.println(result.wasSuccessful());
        System.out.println(result.getFailures());
    }
}