package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
public class oraclejava {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		oracleTest oratest=new oracleTest();
		if(!oratest.conn()) {
			System.out.println("conn error");
		} else {
			oratest.querySelect();
		}
	}
	
	public static class oracleTest {
		Connection conn;
		PreparedStatement pstmt;
		ResultSet rs;
		boolean oracleErrorYn=false;
		public void oracleTest() {
			
		}
		public boolean conn() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url="jdbc:oracle:thin:@localhost:1521:orcl";
				String user="test_guest";
				String pw="1234";
				conn=DriverManager.getConnection(url,user,pw);
				return true;
			} catch(Exception e) {
				System.out.println("conn=["+e.getMessage()+"]");
				return false;
			} finally {
			}
		}
		
		public void querySelect() {
			String sql="SELECT  null as first,12343.33 as typ1,342343 as typ2,UP_CD,CD,CD_NM FROM TEST_GROUP_TB";
			long maxRowCnt=100;
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				ResultSetMetaData rsm=rs.getMetaData();
				int colCnt=rsm.getColumnCount();
				JSONArray jsonRowArray=new JSONArray();
				while(rs.next()) {
					Object[] objts=new Object[colCnt];
					JSONArray jsonColArray=new JSONArray();
					for(int i=0; i < colCnt;i++) {
						jsonColArray.add(rs.getObject(i+1));
					}
					jsonRowArray.add(jsonColArray);
					if(rs.getRow() >= maxRowCnt) {
						break;
					}
				}
				System.out.println(jsonRowArray.toString());
			} catch(Exception e) {
				System.out.println("err=["+e.getMessage()+"]");
			}	finally {
				try {
					if(rs !=null ) rs.close();
				} catch(Exception e) {}
				try {
					if(pstmt !=null ) pstmt.close();
				} catch(Exception e) {}
				try {
					if(conn !=null ) conn.close();
				} catch(Exception e) {}
			}
			
		}
	}
	
	
}
