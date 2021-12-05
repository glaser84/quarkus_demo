package at.cgsit.train.quarkus.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DemoService {

    public String reverseEcho(String echoIn) {
        StringBuilder sb= new StringBuilder(echoIn);
        sb.reverse();
        return sb.toString().toUpperCase();
    }
}
