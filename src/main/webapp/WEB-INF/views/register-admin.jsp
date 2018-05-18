<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Registration</title>
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
 	<link href="<c:url value="/resources/css/floating-labels.css"/>" rel="stylesheet">
</head>
<body>
 	<form class="form-signin" action="${cp}/admin/addAdmin" method="post">
      <div class="text-center mb-4">
        <h1 class="h3 mb-3 font-weight-normal">Admin Registration</h1>
      </div>
      
      <div class="form-label-group">
        <input name="username" type="text"  id="inputUsername" class="form-control" placeholder="Username" required="required" autofocus="autofocus"/>
        <label for="inputUsername">Username</label>
        <p style="color:red" id="checkedMsg"></p>
      </div>
      
      <div class="form-label-group">
        <input type="password" name="password"  id="inputPassword" class="form-control" placeholder="Password" required="required"/>
        <label for="inputPassword" >Password</label>
      </div>
      
      <div class="form-label-group">
        <input type="password" id="re-enterPassword" class="form-control" placeholder="Re-enter Password" required="required"/>
        <label for="re-enterPassword">Re-enter Password</label>
      </div>
      
      <p style="display:none;color:red" id="pwdErr">Inconsistent Password</p>
      
      <div style="float:left">
        <input type="radio" name="role" value="ROLE_ADMIN" id="role_admin"/>
        <label for="role_admin">Admin</label>
      </div>
      <div style="float:right">
        <input type="radio" name="role" value="ROLE_DBA" id="role_dba"/>
        <label for="role_dba">DBA</label>
      </div>
      
      <button class="btn btn-lg btn-success btn-block" type="submit">Register</button>
      <p class="mt-5 mb-3 text-muted text-center">&copy; 2017-2018</p>
    </form>
    
<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-1.9.0.min.js"></script>    
<script type="text/javascript">
       $("#inputUsername").change(function() {
    	   var username = $(this).val();
			$.ajax({
				type : "POST",
				url : "checkUsername",
				data : {"username":username},
				success : function(msg) {
					$("#checkedMsg").html(msg);
				}
			});
      });
    
	  $("#re-enterPassword").focusout(function(){
	    var pw1=$("#inputPassword").val();
	    var pw2=$("#re-enterPassword").val();
	    if(pw1!=pw2){
	    	$("#pwdErr").show();
	    }else{
	      $("#pwdErr").hide();
	    }
	  });
</script>
</body>
</html>