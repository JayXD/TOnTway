package com.services.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @GetMapping({"/",""})
    public String index(Model model, @RequestParam String optype){

        return "Index";
    }

    @ModelAttribute
    public void getMsg(Model model, @RequestParam String optype){
        if ("login".equals(optype)){
            model.addAttribute("message","login");

        }else{
            model.addAttribute("message","else");

        }
    }

    @GetMapping({"/login"})
    public String login(Model model, @RequestParam String optype){
        return "login";
    }
}
