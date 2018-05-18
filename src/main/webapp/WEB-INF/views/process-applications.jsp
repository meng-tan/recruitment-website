<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Process Application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  </head>
  <body>

    <header>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${cp}/register">Register</a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled" href="${cp}/login">Login</a>
            </li>
            <li class="nav-item">
              <a class="nav-link disabled" href="${cp}/logout">Logout</a>
            </li>
          </ul>
        </div>
      </nav>
    </header>


      <div class="container" style="margin-top: 100px">
<c:choose>
<c:when test="${not empty applications}">      
		<table class="table table-hover">
		  <h3>List of Applications</h3>
		  <thead class="thead-light">
		    <tr>
		   	  <th scope="col">Apply Time</th>
		   	  <th scope="col">Position Title</th>
		      <th scope="col">Resume Title</th>
			  <th scope="col">Cover Letter</th>
		      <th scope="col">Application Status</th>
		      <th scope="col">Message</th>
		      <th scope="col">Process</th>
		    </tr>
		  </thead>
		  <tbody>
<c:forEach items="${applications}" var="application">
			<form action="${cp}/hr/processApplication" method="post">
			<input type="hidden" name="Application_ID" value="${application.id}">
		    <tr>
		      <td>${application.applyTime}</td>
		      <td><a href="${cp}/hr/viewPost/${application.post.id}">${application.post.postTitle}</a></td>
		      <td><a href="${cp}/hr/viewResume/${application.resume.id}">${application.resume.resumeTitle}</a></td>
			  <td>${application.coverLetter}</td>
			  
<c:choose>
<c:when test="${application.status eq 'Pending'}">  
				<td>  			  
			  	<select name="status">
					<option value="Accepted">Accepted</option>
					<option value="Declined">Declined</option>
				</select>
				</td>
</c:when>
<c:otherwise>
				<td>${application.status}</td>
</c:otherwise>				
</c:choose>					

<c:choose>
<c:when test="${empty application.message}">
			  <td><textarea name="message" placeholder="Leave your message..." rows="3"></textarea></td>
</c:when>			  
<c:otherwise>		      
		      <td>${application.message}</td>
</c:otherwise>
</c:choose>

<c:choose>
<c:when test="${application.status eq 'Pending'}">  
				<td><input type="submit" name="submit"></td>
</c:when>
<c:otherwise>
				<td>Processed</td>
</c:otherwise>				
</c:choose>	

		    </tr>
		    </form>
</c:forEach>		    
		  </tbody>
		</table>
</c:when>		
<c:otherwise>
		<p>You haven't received any applications.</p>
		<a class="btn btn-primary btn-lg" href="${cp}/hr/resumeIndex"  role="button">Seek Applicants &raquo;</a>
</c:otherwise>				
</c:choose>		
      </div>


<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-1.9.0.min.js"></script>    
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
  </body>
</html>
