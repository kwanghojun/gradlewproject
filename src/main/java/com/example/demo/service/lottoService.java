package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.lottoDao;
import com.example.demo.dto.lottoDto;

@Service
public class lottoService {
	@Autowired
	public lottoDao lottoDao;
	
	public List<lottoDto> selectLottoList(Map<String, String> data) {
    	System.out.println("selectLottoList Dao..Start..!");
    	return lottoDao.selectLottoList(data);
    }
}
