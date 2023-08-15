package com.example.demo.testApp;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.testService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping
public class testController {

	@Autowired
	public testService testservice;
	
	@RequestMapping(value="/") 
	public String home(Model model,HttpServletRequest request){ 
		System.out.println("home.. Controller..!!!!...");
		request.setAttribute("test","request 테스트 value");
		List list=new ArrayList();
		List<Map> listMap=new ArrayList();
		Map setMap=new HashMap();
		setMap.put("filed1","field1");
		setMap.put("filed2","field2");
		listMap.add(setMap);
		Map setMap2=new HashMap();
		setMap2.put("filed1","field1");
		setMap2.put("filed2","field2");
		listMap.add(setMap2);
		list.add(listMap);
		model.addAttribute("result", list);
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
	
	@RequestMapping(value="/gridtest") 
	public String gridtest(HttpServletRequest request){ 
		System.out.println("home.. gridtest..!!!!...");
		request.setAttribute("test","request 테스트 value");
		return "gridtest"; 
	}
	
	@RequestMapping(value="/bootstrap1") 
	public String bootstrap1(HttpServletRequest request){ 
		System.out.println("home.. gridtest..!!!!...");
		request.setAttribute("test","request 테스트 value");
		return "bootstrap1"; 
	}
	
	@RequestMapping("/fileUpload")
	public void fileUploadDisk( ModelMap model, @RequestParam("file") MultipartFile file) throws 
	IOException {
	    // 파일정보가 없는 경우가 리턴합니다.
		if (file.isEmpty()) {
	        return;
	    } else {
	    	
	    }
	} 
	
	@RequestMapping("/fileDownload")
	public void fileDownload(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
	   
	    // String filename = (String) umap.get("original_file_name");
	    //String fileNm = new String(filename.getBytes("UTF-8"), "ISO-8859-1");

	    response.setContentType("application/octet-stream");
	    //response.setHeader("Content-Disposition", "attachment;filename=" + fileNm);

	    //byte[] data = (byte[]) umap.get("file");
	    //response.getOutputStream().write(data);
	}
	
	@Scheduled(fixedDelay = 1000)
	// @Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}") // 문자열 milliseconds 사용 시
	public void scheduleFixedDelayTask() throws InterruptedException {
	    System.out.println("Fixed delay task {"+ System.currentTimeMillis() / 1000 +"}");
	    Thread.sleep(5000);
	}
}
