/**
 * 
 */
package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author kwangho
 *
 */
@Repository
public class dicDao {
	@Resource(name = "sqlSession")
    private SqlSessionTemplate sqlSession;

    public List<Map> selectDicList(Map<String, String> data) {
    	System.out.println("selectDicList Dao..Start..!");
        return this.sqlSession.selectList("mybatis.testMapper.selectLowData", data);
    }
    
    public int insertDic(Map<String, String> param) {    	
    	System.out.println("insertDicInfo Dao..Start..!");
        return this.sqlSession.insert("mybatis.testMapper.deleteLowDataCopy",param);
    }
}
