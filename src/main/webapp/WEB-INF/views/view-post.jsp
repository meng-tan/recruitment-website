<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!doctype html>
<html lang="en">
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>View Post</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  </head>
  <body class="bg-light">
    <div class="container">
      <div class="py-5 text-center">
        <h2>Position Information</h2>
      </div>

      <div class="row justify-content-md-center">
        <div class="col-md-8 order-md-1">
          <h4 class="mb-3">General Information</h4>
          <hr class="mb-4">

          <div class="card">
            <img class="card-img-top" src="${post.picPath}" alt="Card image cap">
            <div class="card-body">
              <h5 class="card-title">${post.position}</h5>
              <p class="card-text">${post.company}</p>
            </div>
            <ul class="list-group list-group-flush">
              <li class="list-group-item">Type: ${post.type}</li>
              <li class="list-group-item">Salary: ${post.salary}</li>
              <li class="list-group-item">Number Needed: ${post.numNeeded}</li>
              <li class="list-group-item">Requirement: ${post.requirement}</li>
              <li class="list-group-item">Responsibility: ${post.responsibility}</li>
              <li class="list-group-item">Email: ${post.contact}</li>
              <li class="list-group-item">Apply Before: ${post.dateBefore}</li>
            </ul>
          </div>

          <hr class="mb-4">
<sec:authorize access="hasRole('USER')">
	<c:choose>
		<c:when test="${not empty user.resumes}">
			<button type="button" class="btn btn-primary btn-lg btn-block" data-toggle="modal" data-target="#exampleModal">Apply</button>
		</c:when>
		<c:otherwise>
			 <a class="btn btn-primary btn-lg btn-block" href="${cp}/user/addResume"  role="button">Add A Resume To Apply &raquo;</a>
		</c:otherwise>
	</c:choose>
</sec:authorize>  
        </div>
      </div>
      
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">New Application</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <form id="applyForm" action="${cp}/user/applyPost" method="post">
		          <input type="hidden" name="Post_ID" value="${post.id}"/>
		          <input type="hidden" name="Hr_ID" value="${post.hr.id}"/>
		          <div class="form-group">
	                  <label for="resumes">Select From My Resumes:</label>
	                  <select class="custom-select d-block w-100" name="Resume_ID" id="resumes" required="required">
						<c:forEach items="${user.resumes}" var="resume">
	                    <option value="${resume.id}">${resume.resumeTitle}</option>
	                    </c:forEach> 
					  </select>
                  </div>
                 
		          <div class="form-group">
		            <label for="coverletter" class="col-form-label">Cover Letter:</label>
		            <textarea name="coverLetter" rows="10" class="form-control" id="coverletter"></textarea>
		          </div>
		          
		        </form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary" id="apply" data-dismiss="modal">Send Application</button>
		      </div>
		    </div>
		  </div>
		</div>      

      <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2017-2018 Company Name</p>
        <ul class="list-inline">
          <li class="list-inline-item"><a href="#">Privacy</a></li>
          <li class="list-inline-item"><a href="#">Terms</a></li>
          <li class="list-inline-item"><a href="#">Support</a></li>
        </ul>
      </footer>
    </div>
<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-1.9.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
  <script type="text/javascript">
       $("#apply").click(function() {
    	   $("#applyForm").submit();
      });
</script>
  </body>
</html>

