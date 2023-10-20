package com.booster.proyectoAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hola/v0")
public class HolaController {
    @GetMapping("hola")
    public String Saludo(){
        return "Hola mundo desde Spring";
    }
}
