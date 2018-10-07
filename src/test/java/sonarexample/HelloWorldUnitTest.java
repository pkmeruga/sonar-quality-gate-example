package sonarexample;

import org.junit.Ignore;
import org.junit.Test;
import sonarexample.HelloWorld;

public class HelloWorldUnitTest {

    @Test
    public void test() {
        new HelloWorld().coveredByUnitTest();
    }

    @Ignore
    public void skipTest() {
        new HelloWorld().coveredByUnitTest();
    }

    @Ignore
    public void skipTest2() {
        new HelloWorld().coveredByUnitTest();
    }

}
