package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.dicDao;

@Service
public class dicService {
	
	@Autowired
	public dicDao dicDao;
	
	public List<Map> selectDic(Map<String, String> data) {
    	System.out.println("dicService selectTest .Start..!");
    	return dicDao.selectDicList(data);
    }
    
    public int insertDic(Map<String, String> param) {    	
    	System.out.println("dicService insert .Start..!");
        return dicDao.insertDic(param);
    }
}
