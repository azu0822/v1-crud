package com.cinehome.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String cineHome(){
        return "home/cineHome";
    }
}
