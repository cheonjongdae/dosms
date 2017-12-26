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
		<link href="http://fonts.googleapis.com/earlyaccess/nanumpenscript.css" rel="stylesheet"/>
		
		<!-- title part -->
		<title>dosms watcher page</title>
		
		<!-- jpegmeta extraction part -->
		<script src="<c:url value="/js/egovframework/mbl/com/dosms/jpegmeta.js" />"></script>
		<script src="<c:url value="/js/egovframework/mbl/com/dosms/demo.js" />"></script>
		
		<!-- jquery part -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script>
			$(document).ready(function(){
			    if (!('url' in window) && ('webkitURL' in window)) {
			        window.URL = window.webkitURL;
			    }
			 
			    $('#fileWidget').change(function(e){
				    $('#checktable').css("display", "none");
				    $('#uploadbox').css("display", "none");
				    $('#submitbox').css("display", "block");
			    });
			});
		</script>
		
		<!-- javascript part -->
		<script type="text/javascript">
			function doCheck() {
				var frm = document.forms.exterminatorForm;
				
				frm.action = '<c:url value="/Action/doCheck.do" />';
				frm.submit();
			}
			
			function check_all() {
				exterminatorForm.first.checked = true;
				exterminatorForm.second.checked = true;
				exterminatorForm.third.checked = true;
				exterminatorForm.forth.checked = true;
				exterminatorForm.fifth.checked = true;
			}
			
			function loc() {
				var a = "aa sector";
				alert(a + " is ...");
			}
			
			function playAll(secid) {
				var myAudio = document.getElementById("sample1");
				myAudio.currentTime=0;
				myAudio.play();
			}
		</script>
		
		<!-- css part -->
		<style type="text/css">
			::-webkit-scrollbar {
				display:none;
			}

			input.upload {  
				position: relative;
				width: 90%;
				height: 50px;
				border-radius: 3px;
				border-color: transparent;
				cursor: pointer;
				opacity: 0;       /*input type="file" tag 투명하게 처리*/
				font-family: 'Nanum Pen Script', cursive;
				font-size: 20px;
			}
			
			button.replace {    /*button tag 에 원하는 스타일 적용*/
				position: absolute;
				width: 90%;
				height: 50px;
				border-radius: 3px;
				border:solid 1px #B5B2FF;
				background-color:#B5B2FF;
				cursor: pointer;
				font-family: 'Nanum Pen Script', cursive;
				font-size: 20px;
			}
			
			input.submit {
				width: 90%;
				height: 50px;
				border-radius: 3px;
				border:solid 1px #B5B2FF;
				background-color:#B5B2FF;
				cursor: pointer;
				font-family: 'Nanum Pen Script', cursive;
				font-size: 20px;
			}
			
			@font-face { 
				font-family: 'digital-7'; 
				src: url(fonts/digital-7.ttf) format('truetype'); 
				} 
				
			div.digitaldiv { 
				font-family: digital-7; 
			}
			
			#font1 {
				font-family: 'Nanum Pen Script', cursive;
				font-size: 30px;
			}
		</style>
	
	</head>
	
	<body class="is-loading">
		<form commandName='exterminatorForm' name='exterminatorForm' method="post" enctype="multipart/form-data">
			<!-- Wrapper -->
			<div id="wrapper">
			
				<!-- Main -->
				<section id="main">
					<header>
						<span class="avatar"><img src="http://www.ssis.or.kr/images/kor/main/right_icon2.gif" alt="" /></span>
						<audio id="sample1" src=" <c:choose>
													<c:when test = "${currentSecId == 'SEC_1401'}">
														<c:url value="/css/egovframework/mbl/dosms/css/spSEC_1401.mp3"/>
													</c:when>
													<c:when test = "${currentSecId == 'SEC_1501'}">
														<c:url value="/css/egovframework/mbl/dosms/css/spSEC_1501.mp3"/>
													</c:when>
													<c:when test = "${currentSecId == 'SEC_1502'}">
														<c:url value="/css/egovframework/mbl/dosms/css/spSEC_1502.mp3"/>
													</c:when>
													<c:when test = "${currentSecId == 'SEC_1701'}">
														<c:url value="/css/egovframework/mbl/dosms/css/spSEC_1701.mp3"/>
													</c:when>
													<c:when test = "${currentSecId == 'SEC_1702'}">
														<c:url value="/css/egovframework/mbl/dosms/css/spSEC_1702.mp3"/>
													</c:when>
													<c:when test = "${currentSecId == 'SEC_1801'}">
														<c:url value="/css/egovframework/mbl/dosms/css/spSEC_1801.mp3"/>
													</c:when>
													<c:when test = "${currentSecId == 'SEC_1802'}">
														<c:url value="/css/egovframework/mbl/dosms/css/spSEC_1802.mp3"/>
													</c:when>
													<c:when test = "${currentSecId == 'SEC_2001'}">
														<c:url value="/css/egovframework/mbl/dosms/css/spSEC_2001.mp3"/>
													</c:when>
													<c:when test = "${currentSecId == 'SEC_2101'}">
														<c:url value="/css/egovframework/mbl/dosms/css/spSEC_2101.mp3"/>
													</c:when>
													<c:when test = "${currentSecId == 'SEC_2102'}">
														<c:url value="/css/egovframework/mbl/dosms/css/spSEC_2102.mp3"/>
													</c:when>
													<c:otherwise>
														<c:url value="/css/egovframework/mbl/dosms/css/sp.mp3"/>
													</c:otherwise>
												</c:choose>
					"></audio>
						<h1><img onclick="playAll()" src="<c:url value="/css/egovframework/mbl/dosms/css/icon.png"/>"/> <c:out value="${secNm}"/> </h1>
					</header>
					
					<footer>
						<table id="checktable">
							<tr>
								<td id="font1" width="80%"> 상태  </td>
								<td id="font1" align="right" width="200px"> check </td>
							</tr>
							
							<tr>
								<td width="80%" height="60px"> <strong> <font size = 3 ><k id="font1"> 서류보관상태 </k> </font>  </strong> </td>
								<td align="right" width="200px"> <input type="checkbox" name="first" value="true" id="box1"> <label for="box1"> &nbsp; </label></input></td>
							</tr>
							
							<tr>
								<td width="80%" height="60px"> <strong> <font size = 3 ><k id="font1"> 청소 상태 </k></font>  </strong> </td>
								<td align="right" width="200px"> <input type="checkbox" name="second" value="true" id="box2"> <label for="box2"> &nbsp; </label></input></td>
							</tr>
							
							<tr>
								<td width="80%" height="60px"> <strong> <font size = 3 ><k id="font1"> 소등 상태  </k></font> </strong> </td>
								<td align="right" width="200px"> <input type="checkbox" name="third" value="true" id="box3"> <label for="box3"> &nbsp; </label></td>
							</tr>
							
							<tr>
								<td width="80%" height="60px"> <strong> <font size = 3 ><k id="font1"> 화기단속상태 </k></font> </strong> </td>
								<td align="right" width="200px">  <input type="checkbox" name="forth" value="true" id="box4"> <label for="box4"> &nbsp;  </label></td>
							</tr>
							
							<tr>
								<td width="80%" height="60px"> <strong> <font size = 3 ><k id="font1"> 문단속상태 </k></font> </strong> </td>
								<td align="right" width="200px">  <input type="checkbox" name="fifth" value="true" id="box5"> <label for="box5"> &nbsp; </label></td>
							</tr>
							
							<tr>
								<td width="80%" height="60px"></td>
								<td align="right" width="200px" height="60px"> <input type='button' onclick='check_all();' value="모두 체크"/></td>
							</tr>
							
							<tr>
								<td width="90%" height="100px" colspan="2">
									<center>
										<input type="text" name="cmnt" value="comment를 입력하세요" onclick= this.value="" style="text-align: center; width:80%; height:70px; letter-spacing:3px;"/> 
									</center>	
								</td>
							</tr>			
						</table>
						
						<br/>
						
						<div id="uploadbox" style="width: 100%; text-align: center; position: relative; left: 0;">
							<button class="replace">제출하기</button>
							<input class="upload" id="fileWidget" name="file123" type="file" capture="camera" accept="image/*">
						</div>
						
						<input id="status2" name="imgdate" type="hidden" value=""> </input>
			        	<input id="status3" name="inspecttime" type="hidden" value=""> </input>
			        	
			        	<div style="width: 100%; position: relative;">
							<img id="img" width="100%" alt="" src="" style="position: relative; top: 0; left: 0; z-index: 1;"/>
							<div class="digitaldiv" id="status" style="position: absolute; top: 42%; left: 22%; z-index: 2; font-weight: bold; font-size: 3em; color: white;"> </div>
						</div>
			
						
						<div id="submitbox" style="width: 100%; text-align: center; position: relative; left: 0; z-index: 3; display: none;">
							<br/>
							<input class="submit" type="button" value='사진제출하기' onClick='doCheck();'/>
						</div>
				
					</footer>
				</section>
			
				<!-- Footer -->
				<footer id="footer">
					<ul>
						<li><a href="http://www.ssis.or.kr/index.do">사회보장정보원SSIS</a></li>
						<li></li>
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