package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.*;


@Repository
public class lottoDao {
	
    @Resource(name = "sqlSession")
    private SqlSessionTemplate sqlSession;

    public List<lottoDto> selectLottoList(Map<String, String> data) {
    	System.out.println("selectLottoList Dao..Start..!");
        return this.sqlSession.selectList("mybatis.lottoMapper.selectLotoList", data);
    }
}
