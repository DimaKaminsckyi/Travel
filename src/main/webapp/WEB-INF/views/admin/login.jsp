<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="/WEB-INF/taglib.jsp" %>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

<style>

	#footer{
		height: 135px;
	}
	.wrapper{
		 margin-left: auto;
		 margin-top: 80px;
  		margin-bottom: 80px;
    	margin-right: auto;
   		 width: 10em;
	}

</style>

<div class="wrapper">
	
	<c:if test="${param.fail}">
		<p style="colore: red;">
			Fail to authorize
		</p>
	</c:if>
	
	
	<form:form action="/login" modelAttribute="loginPage"  method="POST">
		<div class="form-signin">
			<label for="focusedInput">Login</label>
			<input type="login" class="form-control" name="login"/>
			<br>
			<label  for="focusedInput">Password</label>
			<input type="password" class="form-control" name="password" />
			<br>
			<input type="submit" class="logout-style">
		</div>
	</form:form>
</div>