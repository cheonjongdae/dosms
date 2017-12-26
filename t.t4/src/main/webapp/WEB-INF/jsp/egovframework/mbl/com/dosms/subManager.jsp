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
		<link href="http://fonts.googleapis.com/earlyaccess/nanumpenscript.css" rel="stylesheet">
		
		<!-- title part -->
		<title>dosms sub manager page</title>
		
		<!-- javascript part -->
		<script type="text/javascript">
			function checkCmnt(inputValue) {
				alert(inputValue + "");
			}
			
			
			
			function goNext() {
				var frm = document.forms.SubManagerForm;
				frm.action = '<c:url value="/Action/subManagerNext.do" />';
				frm.submit();
			}
			
			function goPrev() {
				var frm = document.forms.SubManagerForm;
				frm.action = '<c:url value="/Action/subManagerPrev.do" />';
				frm.submit();
			}
			
			function submitCheck() {
				var frm = document.forms.SubManagerForm;
				frm.action = '<c:url value="/Action/subManagerSubmit.do" />';
				frm.submit();
			}
			
			function checkCamFinal() {
				document.getElementById("testbox1").style.display = "block";
			}
			
			function checkCamNight() {
				document.getElementById("testbox2").style.display = "block";
			}
			
			function test3() {
				document.getElementById("testbox1").style.display = "none";
			}
			
			function test4() {
				document.getElementById("testbox2").style.display = "none";
			}
		</script>
		
		<!-- css part -->
		<style type="text/css">
			::-webkit-scrollbar {
				display:none;
			}

		    @font-face {
				font-family: 'digital-7';
				src: url(fonts/digital-7.ttf) format('truetype');
		    }

			.digitaldiv { 
				font-family: digital-7; 
			}
			
			#font1 {
				font-family: 'Nanum Pen Script', cursive;
				font-size: 25px;
			}
			    	
			#font2 {
				font-family: 'Nanum Pen Script', cursive;
				font-size: 20px;
			}
			
			.dim1 { position: fixed; left: 0; top: 0; width: 100%; height: 100%; background-color: rgba(0, 0, 0, .5); z-index: 10;}
			.pop1 { position: absolute; left: 50%; top: 50%; width: 350px; height: 350px;  margin:-175px 0 0 -175px; z-index: 11; font-family: digital-7; }
			
			.dim2 { position: fixed; left: 0; top: 0; width: 100%; height: 100%; background-color: rgba(0, 0, 0, .5); z-index: 10;}
			.pop2 { position: absolute; left: 50%; top: 50%; width: 350px; height: 350px;  margin:-175px 0 0 -175px; z-index: 11; font-family: digital-7; }

		</style>
	</head>
	
	<body class="is-loading">
		<form name = "SubManagerForm" >
			<!-- Wrapper -->
			<div id="wrapper">
			
				<!-- Main -->
				<section id="main">
					<header>
						<span class="avatar"><img src="http://www.ssis.or.kr/images/kor/main/right_icon2.gif" alt="" /></span>
						<h1><img src="http://www.ssis.or.kr/images/kor/main/right_icon3.gif"/> <c:out value="${SubManagerSectorName}"/> </h1>
					</header>
					
					<footer>
						<table border="1" width="100%" style="margin-top:1%">
							<tr>
								<td colspan="3">
									<span style align="right" height="150" font-size="35" color="#000075">
										<p><c:out value="${SubManagerName}"/> 보안관리자님</p>
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
				        				<input type="image" onclick="goNext()" src="https://eclass.dongguk.edu/lmsdata/img/classroom/arrow_next.png">
				        			</c:if> 
				        		</td>
							</tr>
				
							<tr>
								<td id="font1"> 상태 </td>
								<td id="font1"> 최종퇴실자 </td>
								<td id="font1"> 당직자 </td>
							</tr>
				
							<tr>
								<td> <strong> <font size = 5 > <k id="font1"> 서류보관상태 </k></font> </strong> </td>

								<td> 
									<c:choose>
										<c:when test="${empty subManagerCheckListFinal[0]}">
											미제출
										</c:when>
										
										<c:when test="${subManagerCheckListFinal[0].docStrgFinal == true}">
											<img src="<c:url value='/css/egovframework/mbl/dosms/css/good_icon.png'/>"/>
										</c:when>
										
										<c:when test="${subManagerCheckListFinal[0].docStrgFinal == false}">
											<img src="<c:url value='/css/egovframework/mbl/dosms/css/bad_icon.png'/>"/>
										</c:when>
									</c:choose>
								</td>
								
								<td>
									<c:choose>
										<c:when test="${empty subManagerCheckListNight[0]}">
											미제출
										</c:when>
										
										<c:when test="${subManagerCheckListNight[0].docStrgNight == true}">
											<img src="<c:url value='/css/egovframework/mbl/dosms/css/good_icon.png'/>"/>
										</c:when>
										
										<c:when test="${subManagerCheckListNight[0].docStrgNight == false}">
											<img src="<c:url value='/css/egovframework/mbl/dosms/css/bad_icon.png'/>"/>
										</c:when>
									</c:choose>
								</td>
							</tr>
				
							<tr>
								<td> <strong> <font size = 3 ><k id="font1"> 청소 상태 </k></font> </strong> </td>
								<td>
									<c:choose>
										<c:when test="${empty subManagerCheckListFinal[0]}">
											미제출
										</c:when>
										
										<c:when test="${subManagerCheckListFinal[0].clnStatFinal == true}">
											<img src="<c:url value='/css/egovframework/mbl/dosms/css/good_icon.png'/>"/>
										</c:when>
										
										<c:when test="${subManagerCheckListFinal[0].clnStatFinal == false}">
											<img src="<c:url value='/css/egovframework/mbl/dosms/css/bad_icon.png'/>"/>
										</c:when>
									</c:choose>
								</td>
								
								<td>
									<c:choose>
										<c:when test="${empty subManagerCheckListNight[0]}">
											미제출
										</c:when>
										
										<c:when test="${subManagerCheckListNight[0].clnStatNight == true}">
											<img src="<c:url value='/css/egovframework/mbl/dosms/css/good_icon.png'/>"/>
										</c:when>
										
										<c:when test="${subManagerCheckListNight[0].clnStatNight == false}">
											<img src="<c:url value='/css/egovframework/mbl/dosms/css/bad_icon.png'/>"/>
										</c:when>
									</c:choose>
								</td>
							</tr>
				
							<tr>
								<td> <strong> <font size = 3 ><k id="font1"> 소등 상태  </k></font> </strong> </td>
								<td>
									<c:choose>
										<c:when test="${empty subManagerCheckListFinal[0]}">
											미제출
										</c:when>
										
										<c:when test="${subManagerCheckListFinal[0].lightStatFinal == true}">
											<img src="<c:url value='/css/egovframework/mbl/dosms/css/good_icon.png'/>"/>
										</c:when>
										
										<c:when test="${subManagerCheckListFinal[0].lightStatFinal == false}">
											<img src="<c:url value='/css/egovframework/mbl/dosms/css/bad_icon.png'/>"/>
										</c:when>
									</c:choose>
								</td>
								
								<td>
									<c:choose>
										<c:when test="${empty subManagerCheckListNight[0]}">
											미제출
										</c:when>
										
										<c:when test="${subManagerCheckListNight[0].lightStatNight == true}">
											<img src="<c:url value='/css/egovframework/mbl/dosms/css/good_icon.png'/>"/>
										</c:when>
										
										<c:when test="${subManagerCheckListNight[0].lightStatNight == false}">
											<img src="<c:url value='/css/egovframework/mbl/dosms/css/bad_icon.png'/>"/>
										</c:when>
									</c:choose>
								</td>
							</tr>
				
							<tr>
								<td> <strong> <font size = 3 ><k id="font1"> 화기단속상태 </k></font> </strong></td>
								<td>
									<c:choose>
										<c:when test="${empty subManagerCheckListFinal[0]}">
											미제출
										</c:when>
										
										<c:when test="${subManagerCheckListFinal[0].fireextStatFinal == true}">
											<img src="<c:url value='/css/egovframework/mbl/dosms/css/good_icon.png'/>"/>
										</c:when>
										
										<c:when test="${subManagerCheckListFinal[0].fireextStatFinal == false}">
											<img src="<c:url value='/css/egovframework/mbl/dosms/css/bad_icon.png'/>"/>
										</c:when>
									</c:choose>
								</td>
								
								<td>								
									<c:choose>
										<c:when test="${empty subManagerCheckListNight[0]}">
											미제출
										</c:when>
										
										<c:when test="${subManagerCheckListNight[0].fireextStatNight == true}">
											<img src="<c:url value='/css/egovframework/mbl/dosms/css/good_icon.png'/>"/>
										</c:when>
										
										<c:when test="${subManagerCheckListNight[0].fireextStatNight == false}">
											<img src="<c:url value='/css/egovframework/mbl/dosms/css/bad_icon.png'/>"/>
										</c:when>
									</c:choose>
								</td>
							</tr>
				
							<tr>
								<td> <strong> <font size = 3 ><k id="font1"> 문단속상태 </k></font></strong> </td>
								<td>
									<c:choose>
										<c:when test="${empty subManagerCheckListFinal[0]}">
											미제출
										</c:when>
										
										<c:when test="${subManagerCheckListFinal[0].doorStatFinal == true}">
											<img src="<c:url value='/css/egovframework/mbl/dosms/css/good_icon.png'/>"/>
										</c:when>
										
										<c:when test="${subManagerCheckListFinal[0].doorStatFinal == false}">
											<img src="<c:url value='/css/egovframework/mbl/dosms/css/bad_icon.png'/>"/>
										</c:when>
									</c:choose>
								</td>
								
								<td>
									<c:choose>
										<c:when test="${empty subManagerCheckListNight[0]}">
											미제출
										</c:when>
										
										<c:when test="${subManagerCheckListNight[0].doorStatNight == true}">
											<img src="<c:url value='/css/egovframework/mbl/dosms/css/good_icon.png'/>"/>
										</c:when>
										
										<c:when test="${subManagerCheckListNight[0].doorStatNight == false}">
											<img src="<c:url value='/css/egovframework/mbl/dosms/css/bad_icon.png'/>"/>
										</c:when>
									</c:choose>
								</td>
							</tr>
				
							<tr>
								<td> <strong> <font size = 3 ><k id="font1"> 사진/댓글 </k></font> </strong> </td>
								<td> 
									<img src="https://i.imgur.com/C0xtiql.png" width="40" height="40" onclick="checkCamFinal();"/> 
									<img src="http://www.ssis.or.kr/images/kor/main/right_icon6.gif" width="40" height="40" onclick="checkCmnt('${subManagerCheckListFinal[0].cmntFinal}');"/> 
									<input id="finalPicName" type="hidden" value="${subManagerCheckListFinal[0].appendpicFianl}"/>
									<input id="finalPicTime" type="hidden" value="${subManagerCheckListFinal[0].inspectTimeFinal}"/>
								</td>
								
								<td> 
									<img src="https://i.imgur.com/C0xtiql.png" width="40" height="40" onclick="checkCamNight();"/> 
									<img src="http://www.ssis.or.kr/images/kor/main/right_icon6.gif" width="40" height="40" onclick="checkCmnt('${subManagerCheckListNight[0].cmntNight}');"/> 
									<input id="nightPicName" type="hidden" value="${subManagerCheckListNight[0].appendpicNight}"/>
									<input id="nightPicTime" type="hidden" value="${subManagerCheckListNight[0].inspectTimeNight}"/>
								</td>
							</tr>
							
						</table>

						<c:choose>
						
							<c:when test="${submitStand == 0}"> 
								<table align="center" height="22" width="100%" style="margin-top:6%"/>
									<tr>
										<td colspan="3"> <center> <input id="submanagercmnt" name="cmnt" type="text" value="comment를 입력하세요" onclick= this.value="" style="text-align: center; width:90%; height:70px; letter-spacing: 3px;"/> </center> </td>
										<br/>
									</tr>
								</table>
							
								<table align="center" height="22" width="100%" style="margin-top:6%"/>
									<tr>
										<td colspan="3">
											<input type="button" value="제출하기" onclick="submitCheck()" style="height:50px; width:150px;  background-color:#B5B2FF; color:#FFFFFF; font-size:20px; border:solid 1px #B5B2FF;"/>
										</td>
									</tr>
								</table>
							</c:when> 
							
							<c:otherwise>
								<table align="center" height="22" width="100%" style="margin-top:6%"/>
									<tr>
										<td colspan="3"> 
											<p style="font-family: digital-7;"> 이미 제출했습니다. </p>
										</td>
									</tr>
								</table>
							</c:otherwise>
						
						</c:choose>
						
						<div id ="testbox1" class="dim1" style="display:none; font-family: digital-7;" onclick="test3()">
							<div class="pop1" onclick="test3()" style="font-family: digital-7;">
								<img id="atchFileId" name="atchFileId" width="100%" alt="" src="<c:url value='/cmm/fms/getImage.do?fileSn=0&atchFileId=${att2}'/>" style="position: relative; top: 0; left: 0; z-index: 1;"/>
								<div class="digitaldiv" id="status" style="position: absolute; top: 25%; left: 30%; z-index: 2; font-weight: bold; font-size: 3em; color: white; font-family: digital-7;"> ${subManagerCheckListFinal[0].inspectTimeFinal} </div>
							</div>
						</div>
						
						<div id ="testbox2" class="dim2" style="display:none; font-family: digital-7;" onclick="test4()">
							<div class="pop2" onclick="test4()" style="font-family: digital-7;">
								<img id="atchFileId" name="atchFileId" width="100%" alt="" src="<c:url value='/cmm/fms/getImage.do?fileSn=0&atchFileId=${att3}'/>" style="position: relative; top: 0; left: 0; z-index: 1;"/>
								<div class="digitaldiv" id="status" style="position: absolute; top: 25%; left: 30%; z-index: 2; font-weight: bold; font-size: 3em; color: white; font-family: digital-7;"> ${subManagerCheckListNight[0].inspectTimeNight} </div>
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