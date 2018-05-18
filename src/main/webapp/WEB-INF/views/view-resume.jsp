<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resume</title>
<link type="text/css" rel="stylesheet" href="${cp}/resources/css/blue.css" />
<link type="text/css" rel="stylesheet" href="${cp}/resources/css/print.css" media="print"/>
<script type="text/javascript" src="${cp}/resources/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${cp}/resources/js/jquery.tipsy.js"></script>
<script type="text/javascript" src="${cp}/resources/js/cufon.yui.js"></script>
<script type="text/javascript" src="${cp}/resources/js/scrollTo.js"></script>
<script type="text/javascript" src="${cp}/resources/js/myriad.js"></script>
<script type="text/javascript" src="${cp}/resources/js/jquery.colorbox.js"></script>
<script type="text/javascript" src="${cp}/resources/js/custom.js"></script>
<script type="text/javascript">
		Cufon.replace('h1,h2');
</script>
</head>
<body>
<!-- Begin Wrapper -->
<div id="wrapper">
  <div class="wrapper-top"></div>
  <div class="wrapper-mid">
    <!-- Begin Paper -->
    <div id="paper">
      <div class="paper-top"></div>
      <div id="paper-mid">
        <div class="entry">
          <!-- Begin Image -->
          <img class="portrait" src="${cp}/resources/images/image.jpg" alt="John Smith" />
          <!-- End Image -->
          <!-- Begin Personal Information -->
          <div class="self">
            <h1 class="name">
              <span style="float: left;">${resume.firstName}</span>
              <span style="float:left;">${resume.lastName}</span>
            </h1>
            <ul>
              <li class="mail">${resume.email}</li>
              <li class="tel">${resume.tel}</li>
            </ul>
          </div>
          <!-- End Personal Information -->
          <!-- Begin Social -->
          <div class="social">
            <ul>
              <li><a class='north' href="#" title="Download .pdf"><img src="${cp}/resources/images/icn-save.jpg" alt="Download the pdf version" /></a></li>
              <li><a class='north' href="javascript:window.print()" title="Print"><img src="${cp}/resources/images/icn-print.jpg" alt="" /></a></li>
              <li><a class='north' href="#" title="Follow me on Twitter"><img src="${cp}/resources/images/icn-twitter.jpg" alt="" /></a></li>
              <li><a class='north' href="#" title="My Facebook Profile"><img src="${cp}/resources/images/icn-facebook.jpg" alt="" /></a></li>
            </ul>
          </div>
          <!-- End Social -->
        </div>
        <!-- Begin 1st Row -->
        <div class="entry">
          <h2>OBJECTIVE</h2>
          <p>${resume.objective}</p>
        </div>
        <!-- End 1st Row -->
        <!-- Begin 2nd Row -->
        <div class="entry">
          <h2>EDUCATION</h2>
          
<c:forEach items="${resume.educationBackgrounds}" var="edu">
          <div class="content">
            <h3>${edu.eduFrom} - ${edu.eduTo}</h3>
            <p>${edu.university}<br />
              <em>${edu.degree}</em>
              <em>${edu.major}</em></p>
          </div>
</c:forEach>
        </div>
        <!-- End 2nd Row -->
        <!-- Begin 3rd Row -->
        <div class="entry">
          <h2>EXPERIENCE</h2>
          
<c:forEach items="${resume.experiences}" var="exp">          
          <div class="content">
            <h3>${exp.expFrom} - ${exp.expTo}</h3>
            <p>${exp.company}<br />
              <em>${exp.title}</em></p>
            <ul class="info">
              <li>${exp.responsibility}</li>
            </ul>
          </div>
</c:forEach>
          
        </div>
        <!-- End 3rd Row -->
        <!-- Begin 4th Row -->
        <div class="entry">
          <h2>SKILLS</h2>
          <div class="content">
            <ul class="skills">
<c:forEach items="${resume.skills}" var="skill">                
              <li>${skill.skill}</li>
</c:forEach>              
            </ul>
          </div>
        </div>
        <!-- End 4th Row -->

      </div>
      <div class="clear"></div>
      <div class="paper-bottom"></div>
    </div>
    <!-- End Paper -->
  </div>
  <div class="wrapper-bottom"></div>
</div>

<div id="message"><a href="#top" id="top-link">Go to Top</a></div>
<!-- End Wrapper -->
</body>
</html>