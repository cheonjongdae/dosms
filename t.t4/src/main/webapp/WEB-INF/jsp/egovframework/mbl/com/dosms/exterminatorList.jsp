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
		
		<!-- title part -->
		<title>dosms list page</title>
		
		<!-- javascript part -->
		<script type="text/javascript">
			function goDetailPage(sectorid,sectorname) {
				document.getElementById("inSectId").value = sectorid;
				document.getElementById("inSectName").value = encodeURIComponent(sectorname);
	
				var frm = document.forms.goDetail;
				frm.action = '<c:url value="/exterminatorGoDetail.do"/>';
				frm.submit();
			}
		</script>
		
		<!-- css part -->
		<style type="text/css">
			::-webkit-scrollbar {
				display:none;
			}
		</style>
	</head>
	
	<body class="is-loading">
		<form name="goDetail">
			<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
				<section id="main">
					<header>
						<span class="avatar"><img src="http://www.ssis.or.kr/images/kor/main/left_icon1.png" alt="" /></span>
					</header>
					
					<footer>
						<input id="inSectId" type="hidden" name="clickSectId" value=""/>
						<input id="inSectName" type="hidden" name="clickSectName" value=""/>

						<table height="30" width="100%" style="margin-top:1%">

							<tr>
								<td style align="left">${todaydate}</td>
								<td style align="right"><c:out value="${empname}"/> 당직근무자님</td>
							</tr>
						</table>
						
						<table align="center" height="150" width="100%" style="margin-top:1%">
							</tr>
							
							<c:forEach var="dlist" items="${dlist}" varStatus="statusto">
								<tr>
									<td onClick="goDetailPage('${dlist.sectorId}','${dlist.sectorNm}')" style="background-color: ${colorList[statusto.index]};">
										<p> <font style="font-size:22px; font-weight:bold; font-color:#030066"> <c:out value="${dlist.sectorNm}"/> </font> </p>
									</td>					
								</tr>
							</c:forEach>
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