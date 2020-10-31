package pl.arturzaczek.api_demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class MainController {

    @GetMapping("/home")
    public String getHome (){
        System.out.println("getHome()");
        return "{'respose' : 'jason' }";
    }

    @GetMapping("/1")
    public ResponseEntity getTestController() {
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
