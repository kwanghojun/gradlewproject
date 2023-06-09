package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class testDao {
	
    @Resource(name = "sqlSession")
    private SqlSessionTemplate sqlSession;

    public List<Map> selectTest(Map<String, String> data) {
    	System.out.println("selectTest Dao..Start..!");
        return this.sqlSession.selectList("mybatis.testMapper.selectLowData", data);
    }
    
    public int deleteLowDataCopy(Map<String, String> param) {    	
    	System.out.println("deleteLowDataCopy Dao..Start..!");
        return this.sqlSession.delete("mybatis.testMapper.deleteLowDataCopy",param);
    }
}
