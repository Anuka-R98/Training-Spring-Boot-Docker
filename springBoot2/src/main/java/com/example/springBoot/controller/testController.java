package com.example.springBoot.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class testController {
@GetMapping("/hello")
    public String hello() {
    return "Hello";
}

}
