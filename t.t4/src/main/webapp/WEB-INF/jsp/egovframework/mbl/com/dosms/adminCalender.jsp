<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- meta part -->
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
		
		<!-- view css import -->
		<link rel="stylesheet" href="<c:url value='/css/egovframework/mbl/dosms/css/main.css'/>"/>
		<link rel="stylesheet" href="<c:url value='/css/egovframework/mbl/dosms/css/noscript.css'/>"/>
		<link href="http://fonts.googleapis.com/earlyaccess/nanumpenscript.css" rel="stylesheet">
		
		<!-- title part -->
		<title>dosms adminCalender page</title>
		
		<!-- javascript part -->
		<script type="text/javascript">
			function showEdit(num) {
				if(document.getElementById("detailEdit" + num).style.display == "") {
					document.getElementById("prevsubmitbt" + num).value = "수정";
					document.getElementById("detailEdit" + num).style.display = "none";
				} else {
					document.getElementById("submitdate").value = "";
					document.getElementById("submitid").value = "";
					document.getElementById("prevsubmitbt" + num).value = "수정취소";
					document.getElementById("detailEdit" + num).style.display = "";
				}
			}
			
			function submitChange(num) {
				
				document.getElementById("submitdate").value = document.getElementById("date" + num).value;
				document.getElementById("submitid").value = document.getElementById("id" + num).value;
				document.getElementById("prevsubmitbt" + num).value = "수정";
				document.getElementById("detailEdit" + num).style.display = "none";
				
				var frm = document.forms.adminNightForm;
				
				frm.action = '<c:url value="/Action/doChange.do" />';
				frm.submit();
			}
		</script>
		
		<!-- css part -->
		<style type="text/css">
			::-webkit-scrollbar {
				display:none;
			}

			div.wrap{position: relative; padding-top:30px; width:100%; height: 300px; overflow: hidden;}
			div.wrap > div {height: 300px; overflow: auto;}
			table{width: 100%}
			thead { }
			thead tr{position: relative; top: 0; display: table-row; background-color: #FAF4C0; width: 100%; height: 30px}
			thead th{ }
			tbody{display: table-row-group; height: auto;}
			tbody tr{ height: auto;}
			tbody td{text-align: center;}

			#font1 {
				font-family: 'Nanum Pen Script', cursive;
				font-size: 25px;
			}

			#font2 {
				font-family: 'Nanum Pen Script', cursive;
				font-size: 17px;
			}

			#font3 {
				font-family: 'Nanum Pen Script', cursive;
				font-size: 16px;
			}
		</style>
	</head>
	
	<body class="is-loading">
	
		<form name="adminNightForm">
			<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
				<section id="main">
					<header>
						<span class="avatar"><img src="http://www.ssis.or.kr/images/kor/main/left_icon1.png" alt="" /></span>
						<h1 style="margin: 0 auto; text-align: center;">당직근무표</h1>
					</header>
					
					<footer>
						<div class="wrap">
							<div>
								<input id="submitdate" name="changedateString" type="hidden" value=""/>
								<input id="submitid" name="changeid" type="hidden" value=""/>

								<table width = "100%">
									<thead>
										<tr>
											<th id="font1" style="width: 20%;">날짜</th>
											<th id="font1" style="width: 20%;">이름</th>
											<th id="font1" style="width: 30%; ">부서</th>
											<th id="font1" style="width: 30%;" colspan="2">수정하기</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach var="anlist" items="${adminNightList}" varStatus="statusto">
											<tr>
												<td id="font2" style="width: 20%; background-color: #FFFFD2;">${anlist.date1}</td>
												<td id="font2" style="width: 20%; background-color: #FFFFD2;">${anlist.empId}</td>
												<td id="font3" style="width: 30%; background-color: #FFFFD2;">${anlist.empNm}</td>
												<td id="font2" style="width: 30%; background-color: #FFFFD2;"> <input id="prevsubmitbt${statusto.index}" type="button" onclick="showEdit('${statusto.index}')" value="수정" style="width:100%; padding:0; font-family: 'Nanum Pen Script', cursive; font-size:15px;"/> </td>
											</tr>

                      						<tr id="detailEdit${statusto.index}" style="display:none;">
												<td id="font2" style="width: 20%; background-color: #EFEFC2;"><input id="date${statusto.index}" type="text" onclick="" value="${anlist.date1}" style="height:auto; width:100%; padding:0; text-align:center; display:inline; font-family: 'Nanum Pen Script', cursive;"/></td>
												<td id="font2" style="width: 20%; background-color: #EFEFC2;">${anlist.empId}<input id="id${statusto.index}" type="hidden" onclick="" value="${anlist.empId}" style="height:100%; width:100%; padding:0; text-align:center; display:inline; font-family: 'Nanum Pen Script', cursive;"/></td>
												<td id="font3" style="width: 30%; background-color: #EFEFC2;">${anlist.empNm}</td>
												<td id="font2" style="width: 30%; background-color: #FFFFD2;" colspan="2"> <input id="submitbt" type="button" onclick="submitChange('${statusto.index}')" value="수정제출" style="width:100%; padding:0; font-family: 'Nanum Pen Script', cursive; font-size:15px;"/> </td>
											</tr>
										</c:forEach>
										
										<tr>
											<td colspan="4">
												<span style="margin-top:50px;"> </span>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</footer>
				</section>
					
				<!-- Footer -->
				<footer id="footer">
					<ul>
						<li><a href="http://www.ssis.or.kr/index.do">사회보장정보원SSIS</a></li>
					</ul>
				</footer>
			</div>
			
			<script>
				if ('addEventListener' in window) {
					window.addEventListener('load', function() { document.body.className = document.body.className.replace(/\bis-loading\b/, ''); });
					document.body.className += (navigator.userAgent.match(/(MSIE|rv:11\.0)/) ? ' is-ie' : '');
				}
			</script>
			
		</form>
	</body>
</html>