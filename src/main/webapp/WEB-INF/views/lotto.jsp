<%@page import="com.example.demo.dto.lottoDto"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
		java.util.List getList=(java.util.List)request.getAttribute("list");
	    java.lang.Integer getSize=(java.lang.Integer)request.getAttribute("list_size");
%>	    
<html>
<head>
<meta charset="UTF-8">
<title>로또.</title>
</head>
<!-- <script src="/js/jquery-3.6.4.min.js"/>  -->
<script language="javascript">
	
	function makeLoto() {
		var repetCnt=50;
		var setHtml="<table border='1'>";
		var lottoenty=new Array();
		var lottowinList=new Array();
		var view_cnt=1;
		setHtml+="<tr><td>순번</td><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td><td>6</td></tr>";
		for(var r=0; r < repetCnt;r++) {
			setHtml+="<tr>";
			lottoenty=[];
			for(var i=0 ; i < 6;i++) {
				lottoenty.push(getRandomNum());
			}
			lottoenty.sort(cust_sort);
			//alert(lottoenty.toString());
			var setObj=document.getElementById("lotto_create_view");
			setHtml+="<td>"+view_cnt+"</td>";
			for(var i=0; i < lottoenty.length;i++) {
				setHtml+="<td>"+lottoenty[i]+"</td>";
			}
			setHtml+="</tr>";
			view_cnt+=1;
		}
		setHtml+="</table>";
		setObj.innerHTML=setHtml;
		getWinList();
	}
	
	function getRandomNum() {
		var getNum=Math.floor(Math.random() * 44) + 1;
		return getNum;
	}
	
	function cust_sort (a,b) {
				if(a > b) return 1;
				if(a == b) return 0;
				if(a < b) return -1;
			}
	
	function getWinList() {
		var req = new XMLHttpRequest();
		req.open("GET",'http://localhost:8080/rest/lotto_res',true);
		req.send();
		// XMLHttpRequest.readyState 프로퍼티가 변경(이벤트 발생)될 때마다 콜백함수(이벤트 핸들러)를 호출한다.
		req.onreadystatechange = function (e) {
		  // 이 함수는 Response가 클라이언트에 도달하면 호출된다.

		  // readyStates는 XMLHttpRequest의 상태(state)를 반환
		  // readyState: 4 => DONE(서버 응답 완료)
		  //if (req.readyState === XMLHttpRequest.DONE) {
		    // status는 response 상태 코드를 반환 : 200 => 정상 응답
		    if(req.status == 200) {
		    	jsonParse(req.responseText);	
		        console.log(req.responseText);
		    } else {
		      console.log("Error!");
		    }
		  //}
		};
    }
	
	function jsonParse(getObj) {
		
	}
</script>
<body>
<div>
<input type="button"  onClick="makeLoto()" value="생성"/>
</div>
<div id="loto_create" style="border: 1px solid gold; float: left; width: 40%;height:500px;">
	생성 리스트
	<div id="lotto_create_view" style="overflow-y:scroll;height:480px;">
	</div>
</div>
<div id="lotto_view" style="border: 1px solid gold; float: left; width: 40%;height:500px;margin-left:10px;">
    당첨번호 리스트
	<%
	    if(getList !=null && getSize !=null && getSize.intValue() >=1) {
	%>
		<table>
	<%	
	    	for(int i=0; i < getList.size();i++) {
	    		lottoDto getLotto=(lottoDto)getList.get(i);
	%> 
			<tr>
				<td>
					<%=getLotto.getLotto_turn() %>회&nbsp;
				</td>
				<td>
					<%=getLotto.getLotto_num1()%>&nbsp;
					<%=getLotto.getLotto_num2()%>&nbsp;
					<%=getLotto.getLotto_num3()%>&nbsp;
					<%=getLotto.getLotto_num4()%>&nbsp;
					<%=getLotto.getLotto_num5()%>&nbsp;
					<%=getLotto.getLotto_num6()%>&nbsp;+&nbsp;
					<%=getLotto.getLotto_num_plus()%>
				</td>
			</tr>
	<%
	    	}
	%>
		
		</table>
	<%
	    }
		
	%>
</div>
</body>
</html>