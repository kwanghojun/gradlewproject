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

import com.example.demo.dto.lottoDto;
import com.example.demo.service.lottoService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class lottoController {

	@Autowired
	public lottoService lottoService;
	
	@RequestMapping(value="/lotto") 
	public String home(HttpServletRequest request){ 
		System.out.println("lotto.. Controller..!!!!...");
		request.setAttribute("test","request 테스트 value");
		Map<String,String> setMap=new HashMap();
		List<lottoDto> lottoList=lottoService.selectLottoList(setMap);
		System.out.println("list size..["+lottoList.size()+"]");
		request.setAttribute("list",lottoList);
		request.setAttribute("list_size",lottoList.size());
		return "lotto"; 
	}
	
	
}
