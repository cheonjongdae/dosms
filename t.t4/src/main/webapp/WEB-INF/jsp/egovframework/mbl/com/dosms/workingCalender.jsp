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
		<title>dosms workingTips page</title>
		
		<!-- javascript part -->
		<script type="text/javascript">
			
		</script>
		
		<!-- css part -->
		<style type="text/css">
			::-webkit-scrollbar {
				display:none;
			}
			
			div.wrap{position: relative; padding-top:30px; width:100%; height: 300px; overflow: hidden;}
			div.wrap > div {height: 300px;overflow: auto;}
			table{width: 100%}
			thead { }
			thead tr{position: relative; top: 0; display: table-row; background-color: #FAF4C0; width: 100%; height: 30px}
			thead th{ }
			tbody{display: table-row-group;height: 300px;}
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
	
		<form name="menuList">
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
								<table width = "100%">
									<c:choose>
										<c:when test="${checkCalender == 1}"> 
								
											<thead>
												<tr>
													<th id="font1" style="width: 30%;">날짜</th>
													<th id="font1" style="width: 30%;">이름</th>
													<th id="font1" style="width: 40%;">부서</th>
												</tr>
											</thead>
											
											<tbody>
												<c:forEach var="nclist" items="${nightCalenderList}" varStatus="statusto">
													<c:if test="${currenteId == nclist.empId}">
														<tr>
															<td id="font2" style="width: 30%; background-color: #FFD8D8;">${nclist.date1}</td>
															<td id="font2" style="width: 30%; background-color: #FFD8D8;">${nclist.empNm}</td>
															<td id="font3" style="width: 40%; background-color: #FFD8D8;">${nclist.deptNm}</td>
														</tr>
													</c:if>
													
													<c:if test="${currenteId != nclist.empId}">
														<tr>
															<td id="font2" style="width: 30%; background-color: #FFFFD2;">${nclist.date1}</td>
															<td id="font2" style="width: 30%; background-color: #FFFFD2;">${nclist.empNm}</td>
															<td id="font3" style="width: 40%; background-color: #FFFFD2;">${nclist.deptNm}</td>
														</tr>
													</c:if>
												</c:forEach>
											</tbody>
										</c:when>
										
										<c:otherwise>
									    	<tr>
									    		<td id="font1">
									    			아직 배정되지 않았습니다.
									    		</td>
									    	</tr>
									    </c:otherwise>
									</c:choose>
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