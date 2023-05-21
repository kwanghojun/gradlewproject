package com.example.demo.testApp;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.testService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class testController {

	@Autowired
	public testService testservice;
	
	@RequestMapping(value="/") 
	public String home(HttpServletRequest request){ 
		System.out.println("home.. Controller..!!!!...");
		request.setAttribute("test","request 테스트 value");
		return "home"; 
	}
	
	@RequestMapping(value="/login") 
	public ModelAndView login(HttpServletRequest request){ 
		ModelAndView view=new ModelAndView();
		System.out.println("home.. Controller.. Login ..!!!!...");
		view.addObject("test", "ModelAndView 로그인페이지 value"); 
		view.setViewName("login");
		return view; 
	}
	
	@RequestMapping(value="/testlist") 
	public ModelAndView testlist(HttpServletRequest request){ 
		ModelAndView view=new ModelAndView();
		System.out.println("home.. Controller.. testlist ..!!!!...");
		
		Map paramMap=new HashMap();
		List<Map> list=testservice.selectTest(paramMap);

		view.addObject("testlist", list); 
		view.setViewName("testlist");
		return view; 
	}
	
}
