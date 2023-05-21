	package com.example.demo.testApp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.lottoDto;
import com.example.demo.service.lottoService;

@RestController
@RequestMapping("rest")
public class restControll {
	
		@Autowired
		public lottoService lottoService;
	
	  	@GetMapping("/{id}/{name}")
	  	@ResponseBody
	    public Book getBook(@PathVariable String id,@PathVariable String name) {
	  		System.out.println("id..["+id+"]");
	  		System.out.println("name..["+name+"]");
	        return findBookById(id,name);
	    }

	    private Book findBookById(String id,String name) {
	    	Book book=new Book();
	    	book.setId(id);
	    	book.setName(name);
	    	return book;
	        // ...
	    }
	    
	    @SuppressWarnings("unchecked")
	    @RequestMapping(value="/test2",method= {RequestMethod.GET,RequestMethod.POST})
	    public String restApi(HttpServletRequest request) {
	    	System.out.println("restApi..Method..!");
	  		JSONObject jObj=new JSONObject();
	  		jObj.put("A","aaaa-11");
	  		jObj.put("B","bbbb-22");
	  		jObj.put("C","cccc-33");
	    	return jObj.toJSONString();
	        // ...
	    }
	    
	    @SuppressWarnings("unchecked")
	    @RequestMapping(value="/lotto_res",method= {RequestMethod.GET,RequestMethod.POST})
	    public String lottoApi(HttpServletRequest request) {
	    	System.out.println("lottoApi..Method..!");
	    	
	    	JSONArray jsonList=new JSONArray();
	    	Map<String,String> setMap=new HashMap();
			List<lottoDto> lottoList=lottoService.selectLottoList(setMap);
			for(int i=0; i < lottoList.size();i++) {
				lottoDto getDto=lottoList.get(i);
				JSONObject jObj=new JSONObject();
		  		jObj.put("lotto_num1",getDto.getLotto_num1());
		  		jObj.put("lotto_num2",getDto.getLotto_num2());
		  		jObj.put("lotto_num3",getDto.getLotto_num3());
		  		jObj.put("lotto_num4",getDto.getLotto_num4());
		  		jObj.put("lotto_num5",getDto.getLotto_num5());
		  		jObj.put("lotto_num6",getDto.getLotto_num6());
		  		jObj.put("lotto_num_plus",getDto.getLotto_num_plus());
		  		jsonList.add(jObj);
			}
	    	return jsonList.toJSONString();
	        // ...
	    }
}
