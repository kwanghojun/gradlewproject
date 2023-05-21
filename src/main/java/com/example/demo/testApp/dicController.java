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

import com.example.demo.service.dicService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class dicController {

	@Autowired
	public dicService dicservice;
	
	@RequestMapping(value="/dicList") 
	public String home(HttpServletRequest request){ 
		System.out.println("dic.. Controller..!!!!...");
		request.setAttribute("test","request 테스트 value");
		Map setMap=new java.util.HashMap();
		List dicList=dicservice.selectDic(setMap);
		request.setAttribute("list",dicList);
		return "dicList"; 
	}
}
