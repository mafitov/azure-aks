package com.example.azure.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String index() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        return "Greetings from " + localHost.getHostAddress();
    }
}
