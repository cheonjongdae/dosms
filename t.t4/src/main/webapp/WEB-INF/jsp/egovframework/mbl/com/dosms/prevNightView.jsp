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
		<title>dosms night prev list page</title>
		
		<!-- javascript part -->
		<script type="text/javascript">
			function goCal() {
				var frm = document.forms.nightMenuList;
				frm.action = '<c:url value="/exterminatorGoCal.do" />';
				frm.submit();
			}
			
			function goDes() {
				var frm = document.forms.nightMenuList;
				frm.action = '<c:url value="/exterminatorGoDes.do" />';
				frm.submit();
			}
			
			function goList() {
				var frm = document.forms.nightMenuList;
				frm.action = '<c:url value="/exterminatorGoList.do" />';
				frm.submit();
			}
		</script>
		
		<!-- css part -->
		<style type="text/css">
			::-webkit-scrollbar {
				display:none;
			}
			
			#font1 {
				font-family: 'Nanum Pen Script', cursive;
				font-size: 30px;
			}
		</style>
	</head>
	
	<body class="is-loading">
	
		<form name="nightMenuList">
			<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
				<section id="main">
					<header>
						<span class="avatar"><img src="http://www.ssis.or.kr/images/kor/main/right_icon2.gif" alt="" /></span>
					</header>
					
					<footer>
						<table height="30" width="100%" style="margin-top:1%">
							<tr>
								<td style align="left">사회보장정보원</td>
								<td style align="right"><c:out value="${extname}"/></td>
							</tr>
						</table>
					
						<table bgcolor = #F5F6CE align="center" border="3px" cellspacing="0" width="100%" height = "60px" style="margin-top:4%">
							<tr>
								<td>
									<input type="button" onclick="goCal()" value="나의 당직 일정" style="width:100%; height:60px; background-color:#FAE0D4; color:#FFFFFF; font-size:20px; font-weight:bold; border:solid 1px #FAE0D4; "/>
								</td>
							</tr>
						 </table>
						
						
						<table bgcolor = #81F79F align="center" border="3px" cellspacing="0" width="100%" height = "60px" style="margin-top:4%">
							<tr>
								<td>
									<input type="button" onclick="goDes()" value="당직 근무 요령" style="width:100%; height:60px; background-color:#E4F7BA; color:#FFFFFF; font-size:20px; font-weight:bold; border:solid 1px #E4F7BA; "/>
								</td>	
							</tr>
						</table>
						
						<table bgcolor = #81F7F3 align="center" border="3px" cellspacing="0" width="100%" height = "60px" style="margin-top:4%">
							<tr>
								<td>
									<input type="button" onclick="goList()" value="보안 점검표 작성" style="width:100%; height:60px; background-color:#DAD9FF; color:#FFFFFF; font-size:20px; font-weight:bold; border:solid 1px #DAD9FF; "/>
								</td>
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