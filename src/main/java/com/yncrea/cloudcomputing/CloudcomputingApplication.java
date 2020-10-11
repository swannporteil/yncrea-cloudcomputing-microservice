package com.yncrea.cloudcomputing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CloudcomputingApplication {

	@RequestMapping("/")
    public String home() {
        String hostname = System.getenv("HOSTNAME");
        return "Hello Docker World - hostname : " + hostname;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello " + System.getenv("GREETING");
    }

    @RequestMapping("/secret")
    @ResponseBody
    public String getSecret() {
        String secret = System.getenv("MY_SECRET") == null ? "" : System.getenv("MY_SECRET");
        return "Secret : " + secret;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(CloudcomputingApplication.class, args);
	}

}
