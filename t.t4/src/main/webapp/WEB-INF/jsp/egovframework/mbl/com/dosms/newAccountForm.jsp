<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- meta part -->
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
		
		<!-- view css import -->
		<link rel="stylesheet" href="<c:url value='/css/egovframework/mbl/dosms/css/main.css'/>"/>
		<link rel="stylesheet" href="<c:url value='/css/egovframework/mbl/dosms/css/noscript.css'/>"/>
		
		<!-- title part -->
		<title>dosms login page</title>
		
		<!-- javascript part -->
		<script type="text/javascript">
			
			/*
			* account key event
			*/
			function onlyNumber(event){
				event = event || window.event;
				var keyID = (event.which) ? event.which : event.keyCode;
				if ( (keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105) || keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
					return;
				else
					return false;
			}
			function removeChar(event) {
				event = event || window.event;
				var keyID = (event.which) ? event.which : event.keyCode;
				if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
					return;
				else
					event.target.value = event.target.value.replace(/[^0-9]/g, "");
			}

			/*
			* next page call func
			*/
			function goMain() {
				if(document.getElementById("loginaccount").value == null || document.getElementById("loginaccount").value == "" || document.getElementById("loginaccount").value == "undefined") {
					document.getElementById("loginaccount").value = 0;
				}

				var frm = document.forms.accountinfo;
				frm.action = '<c:url value="/Action/login.do" />';
				frm.submit();
			}
			
			if ('addEventListener' in window) {
				window.addEventListener('load', function() { document.body.className = document.body.className.replace(/\bis-loading\b/, ''); });
				document.body.className += (navigator.userAgent.match(/(MSIE|rv:11\.0)/) ? ' is-ie' : '');
			}
		</script>
		
		<!-- css part -->
		<style type="text/css">
			::-webkit-scrollbar {
				display:none;
			}
			
			body {
				text-align: center;
			}
		</style>
	</head>
	
	
	<body class="is-loading">
		<form:form name='accountinfo' commandName="accountinfo">
			<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
				<section id="main">
					<header>
						<span class="avatar"><img src="http://www.ssis.or.kr/images/kor/main/left_icon1.png" alt="" /></span>
						<h1>사무실보안관리시스템</h1>
						<p>OFFICE SECURITY MANAGEMENT SYSTEM</p>
					</header>
					
					<footer>
						<table align="center" height="100%" width="100%" border="0" style="border:solid 2px #B5B2FF; margin-top:4%">
					           <tr>
					                <td>ID<form:input id="loginaccount" path="account" type="text" name='account' onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)' style="ime-mode:disabled; height:40px; width:100%;" size="20" maxlength="10"/></td>
					                
					           </tr>
					    </table>


					   <table align="center" height="40" width="100%" border="0" style="border:solid 2px #B5B2FF; margin-top:1%">
					            <tr>
					                <td>PASSWORD<form:input path="password" type="password" name='password' id="password" size="20" maxlength="20" style="height:40px; width:100%;"/></td>
					                
					           </tr>
					   </table>


						 <table align="center" height="40" width="100%" style="margin-top:4%">
						 			 <tr>
						 					<td><input onClick='goMain();' type="button" name="login" value="LOGIN" style="height:50px; width:100%;  background-color:#B5B2FF; color:#eee; font-size:20px; border:solid 1px #050099;"></td>
											<br/>
											<p style="color: red"> <c:out value="${loginAccept}"/> &nbsp; </p>
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
			
		</form:form>
			
	</body>
</html>