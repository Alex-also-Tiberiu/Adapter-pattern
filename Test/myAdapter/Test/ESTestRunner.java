package myAdapter.Test;
import com.sun.net.httpserver.Authenticator;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;


public class ESTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(EntrySetTest.class);

        for(Failure fail : result.getFailures())
            System.out.println(fail.toString());

        System.out.println(result.wasSuccessful());
        System.out.println(result.getFailures());

    }
}