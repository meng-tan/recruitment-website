<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!doctype html>
<html lang="en">
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Post Form</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
   <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   <link  href="<c:url value="/resources/css/form-validation.css"/>" rel="stylesheet">
  </head>
  <body class="bg-light">

    <div class="container">
      <div class="py-5 text-center">
        <h2>List A Position</h2>
      </div>
      <div class="row justify-content-md-center">
        <div class="col-md-8 order-md-1">
          <h4 class="mb-3">General Information</h4>
          <hr class="mb-4">
          <form:form modelAttribute="post" action="${cp}/hr/addPost" method="post" enctype="multipart/form-data">

            <div class="mb-3">
              <label for="postTitle">Post Title</label>
              <form:input type="text" class="form-control" path="postTitle" name="postTitle" id="postTitle" value="My Post"  required="required"/>
            </div>

            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="company">Company</label>
                <form:input path="company" name="company" type="text" class="form-control" id="company" placeholder="" value="NEU" required="required" />
              </div>
              
              <div class="col-md-6 mb-3">
                <label for="position">Position</label>
                <form:input type="text" path="position" name="position" class="form-control" id="position" placeholder="" value="Web Developer"  required="required"/>
              </div>
            </div>
            
            <div class="mb-3">
              <label for="companyLogo">Company Logo</label>
              <input type="file" class="form-control" name="companyLogo" id="companyLogo" required="required"/>
            </div>

            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="numNeeded">Number Needed</label>
                <form:input path="numNeeded" name="numNeeded" type="numble" class="form-control" id="numNeeded" placeholder="" value="10" required="required" />
              </div>
              
              <div class="col-md-6 mb-3">
                <label for="salary">Salary</label>
                <form:input type="text" path="salary" name="salary" class="form-control" id="salary" placeholder="" value="200/day"  required="required"/>
              </div>
            </div>

            <div class="row">
              <div class="col-md-6 mb-3">
                  <label for="type">Type</label>
                  <form:select class="custom-select d-block w-100" path="type" name="type" id="type" required="required">
                    <option value="">Choose...</option>
                    <form:option value="Intern" selected="selected">Intern</form:option>
                    <form:option value="Part-time">Part-time</form:option>
                    <form:option value="Full-time">Full-time</form:option>
                  </form:select>
                </div>

              <div class="col-md-6 mb-3">
                  <label for="contact">Contact</label>
                  <form:input type="email" name="contact" path="contact" class="form-control" id="contact" placeholder="you@example.com" value="1@qq.com" required="required"/>
              </div>
          </div>            

            <div class="mb-3">
              <label for="requirement">Requirement</label>
              <form:textarea name="requirement" path="requirement" class="form-control" value="Master" id="requirement" required="required" ></form:textarea>
            </div>

            <div class="mb-3">
              <label for="responsibility">Responsibility</label>
              <form:textarea name="responsibility" path="responsibility" class="form-control" value="test" id="responsibility" required="required"></form:textarea>
            </div>

            <div class="mb-3">
              <label for="address">Address</label>
              <form:input type="text" class="form-control" path="address" name="address" id="address" value="360 Huntington Ave"  required="required"/>
            </div>
            
            <div class="mb-3">
              <label for="dateBefore">Date Before</label>
              <form:input type="text" class="form-control" path="dateBefore" name="dateBefore" id="datepicker" value=""  required="required"/>
            </div>
			
            <hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" id="save" type="submit" >Save And Post</button>
          </form:form>
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
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script>
  $(document).ready(function() {
    $("#datepicker").datepicker();
  });
</script>
  
  </body>
</html>
