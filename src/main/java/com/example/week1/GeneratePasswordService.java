package com.example.week1;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneratePasswordService {
    @RequestMapping(path = "/{name}.ganerate", method = RequestMethod.GET)
    public String generate(@PathVariable("name") String name){
        String newString = "Hi, "+name+"\n"+"Your new password is "+String.valueOf((int)(Math.random()*100000000));
        return newString;
    }
}
