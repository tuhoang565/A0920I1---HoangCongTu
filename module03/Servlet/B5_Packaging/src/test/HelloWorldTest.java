package test;

import main.Greeter;
import main.HelloWorld;

public class HelloWorldTest {

    public void testGreet(){
        Greeter greeter = new HelloWorld();
        String actual = greeter.greet();
        String expected = "Hello world";

    }
}
