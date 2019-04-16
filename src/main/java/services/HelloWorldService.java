package services;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloWorldService {

    public String createHelloMessage(String name) {
        return "Hello " + name + "!";
    }

}
