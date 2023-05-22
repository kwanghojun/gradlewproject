package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class bootRestartController {
	  	@GetMapping(value="/restart")
	  	@ResponseBody()
	    public void restart() {
	  		System.out.println("restart..!");
	        gradlewApplication.restart();
	    } 
}
