package com.lml.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class EsLearnJavaApplication {

    @RequestMapping("index")
    public String index(){
        return "Welcome Es Index";
    }

    public static void main(String[] args) {
        SpringApplication.run(EsLearnJavaApplication.class, args);
    }

}
