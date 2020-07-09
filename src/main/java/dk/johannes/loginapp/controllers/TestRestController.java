package dk.johannes.loginapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @GetMapping("/sec")
    public String getSec(){
        return "secured resource";
    }


    @GetMapping("/nosec")
    public String getNoSec(){
        return "No security";
    }
}
