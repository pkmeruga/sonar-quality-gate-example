package sonarexample;

import org.junit.Test;
import sonarexample.HelloWorld;

public class HelloWorldUnitTest {

    @Test
    public void test() {
        new HelloWorld().coveredByUnitTest();
    }

}
