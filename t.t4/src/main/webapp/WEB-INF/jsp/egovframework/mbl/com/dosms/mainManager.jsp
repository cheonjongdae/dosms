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
		<title>dosms main manager page</title>
		
		<!-- javascript part -->
		<script type="text/javascript">
			function showDetail(detailid) {
				if(document.getElementById(detailid).style.display == "block") {
					document.getElementById(detailid).style.display = "none"
				} else {
					document.getElementById(detailid).style.display = "block"
				}
			}
			
			function goNext() {
				var frm = document.forms.MainManagerForm;
				frm.action = '<c:url value="/Action/mainManagerNext.do" />';
				frm.submit();
			}
			
			function goPrev() {
				var frm = document.forms.MainManagerForm;
				frm.action = '<c:url value="/Action/mainManagerPrev.do" />';
				frm.submit();
			}
			
			function submitMain() {
				var frm = document.forms.MainManagerForm;
				frm.action = '<c:url value="/Action/mainManagerSubmit.do" />';
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
		<form:form name = "MainManagerForm" >
			<!-- Wrapper -->
			<div id="wrapper">
			
				<!-- Main -->
				<section id="main">
					<header>
						<span class="avatar"><img src="http://www.ssis.or.kr/images/kor/main/right_icon2.gif" alt="" /></span>
					</header>
					
					<footer>
						<table width="100%">
							<tr>
								<td colspan="3">
									<span style align="right" height="150" font-size="35" color="#000075">
										<p><c:out value="${MainManagerName}"/> 보안관리장님</p>
									</span>
								</td>
							</tr>
				
							<tr>
								<td style align="left"> 
									<c:if test="${currentDateCount > -30}"> 
										<input type="image" onclick="goPrev()" src="https://eclass.dongguk.edu/lmsdata/img/classroom/arrow_prev.png"/>
									</c:if> 
								
								</td>
								
								<td style align="center"> ${currentDate} </td>
								
				        		<td style align="right"> 
				        			<c:if test="${currentDateCount < 0}"> 
				        				<input type="image" onclick="goNext()" src="https://eclass.dongguk.edu/lmsdata/img/classroom/arrow_next.png"/>
				        			</c:if> 
				        		</td>
							</tr>
							
							<c:forEach var="mtlist" items="${mainTotalList}" varStatus="statusto">
								<tr style="margin-top:1%">
									<td colspan="3" onclick="showDetail('detail${statusto.index}');" style="background-color: ${colorList1[statusto.index]};">
										<p><c:out value="${mtlist.sectorNm}"/></p>
									</td>
								</tr>
								
								<tr>
									<td colspan="3" style="background-color: ${colorList2[statusto.index]};">
										<div id="detail${statusto.index}" style="display:none;">
										
											<c:choose>
												<c:when test="${not empty mainCheckedList}">
												
													<c:forEach var="mclist" items="${mainCheckedList}" varStatus="statusto2">
													
														<c:choose>
														
															<c:when test="${mclist.sectorId == mtlist.sectorId}"> 
																comment:
																<p> <c:out value="${mclist.cmnt}"/> </P>
																결재
																<input id="box${statusto.index}" type="checkbox" ${mclist.issue == true ? "checked":""} disabled > <label for="box${statusto.index}"> &nbsp; </label> </input>
															</c:when>
															
															<c:otherwise>
																<p> 등록된 정보 없음 </p>
															</c:otherwise>
														
														</c:choose>
														
													</c:forEach>
													
												</c:when>
												
												<c:otherwise>
													<p> 일치하는 정보 없음 </p>
												</c:otherwise>
												
											</c:choose>
										</div>
									</td>
								</tr>
							</c:forEach>
				
						</table>
						
						<table align="center" height="22" width="100%" style="margin-top:6%">
							<tr>
								<td>
									<c:choose>
										<c:when test="${CheckSubmitMain == 0}">
											<input type="button" onclick="submitMain()" value="제출하기" style="height:50px; width:150px;  background-color:#B5B2FF; color:#FFFFFF; font-size:20px; font-weight:bold; border:solid 1px #B5B2FF; "/>
										</c:when>
										
										<c:otherwise>
											<p> 이미 제출했습니다. </p>
										</c:otherwise>
									</c:choose>
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
			
		</form:form>
	</body>
</html>