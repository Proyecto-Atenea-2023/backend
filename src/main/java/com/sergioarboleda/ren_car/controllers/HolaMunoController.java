package com.sergioarboleda.ren_car.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/saludar")
public class HolaMunoController {

    @GetMapping("/hola")
    public String saludar(){
        return "<h1>Hola mundo G2!</h1>";
    }
}
