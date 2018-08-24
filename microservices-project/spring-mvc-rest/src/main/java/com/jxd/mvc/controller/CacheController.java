package com.jxd.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class CacheController {


    @GetMapping
    @ResponseBody
    public String simple(){
        return "Hello World";
    }
    //304取上一次body，若直接为304 则不读取body
    @RequestMapping("/cache")
    public ResponseEntity cache(@RequestParam(required = false,defaultValue = "false") boolean cache){

        if (cache){
            return new ResponseEntity("Hello World",HttpStatus.NOT_MODIFIED);
        } else{
            return new ResponseEntity("Hello World",HttpStatus.OK);
        }
    }
}
