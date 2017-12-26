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
		<title>dosms workingCalender page</title>
		
		<!-- javascript part -->
		<script type="text/javascript">
			
		</script>
		
		<!-- css part -->
		<style type="text/css">
			::-webkit-scrollbar {
				display:none;
			}
			
			#font1 {
				font-family: 'Nanum Pen Script', cursive;
				font-size: 25px;
			}
			
			#font2 {
				font-family: 'Nanum Pen Script', cursive;
				font-size: 20px;
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
						<span class="avatar"><img src="http://www.ssis.or.kr/images/kor/main/right_icon5.gif" alt="" /></span>
					</header>
					
					<footer>
						<table bgcolor = #FFFFE4 align="center" border="3px" cellspacing="0" width="100%" height = "500px">
							<tr>
								<td><center><k id="font1">— 주요업무 —</k></center></td>
							</tr>
							
							<tr>
								<td><center><k id="font1">제 8조 당직 근무 요령</k></center></td>
							</tr>
							
							<tr>
								<td><k id="font2">① 당직근무자는 당직근무 개시시간 30분전에 당직업무 주관부장에게 당직신고를 하여야 한다.
								다만, 휴일의 당직근무자는 그 전일인 정상근무 시간에 당직신고를 하여야 한다.</k></td>
							</tr>
							
							<tr>
								<td><k id="font2">② 당직근무자는 당직신고 전에 당직업무 주관부에서 별지 제1호서식의 당직근무일지,
								당직용 이동전화 등의 서류와 비품을 인수․확인하여야 하며, 당직근무를 마칠 때에는 이를 당직업무 주관부에 인계하고
								이상 유무를 보고하여야 한다.</k></td>
							</tr>
							
							<tr>
								<td><k id="font2">③ 평일 당직의 경우, 당직근무 개시시간 30분 전 당직신고 후
								18:00부터 20:00까지 2시간동안 사무실 순찰․보안점검 등 근무에 임하며, 익일 09:00까지 재택당직을 실시한다.</k></td>
							</tr>
							
							<tr>
								<td><k id="font2">④ 휴일 당직의 경우(연휴기간 포함), 휴일 전일의 근무자가 휴일(연휴)기간 동안 재택당직에 임한다.
								다만, 휴일의 당직근무자는 그 전일인 정상근무 시간에 당직신고를 하여야 한다.</k></td>
							</tr>
							
							<tr>
								<td><k id="font2">⑤ 재택당직 시 당직용 이동전화, 직원비상연락망, 관리사무소 전화번호, 무인경비업체 전화번호를 항시 휴대하여
								비상상황 시 신속한 상황전파 및 비상연락체계를 유지하여야 한다.</k></td>
							</tr>
						</table>
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