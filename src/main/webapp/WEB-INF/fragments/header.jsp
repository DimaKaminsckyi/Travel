<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
	<%@ include file="/WEB-INF/taglib.jsp" %>
	
	
<div id="header">
<style>
		.logout-style {
		 margin-top:10px;
		 pading: 5px 5px;
 		 font-weight: 700;
		 color: white;
		 text-decoration: none;
		 border: none;
 		 padding: .8em 1em calc(.8em + 3px);
 		 border-radius: 10px;
  		background: #ff944d;
  		transition: 0.2s;
		} 
</style>
				<div class="logo">
					<h1><a href="${pageContext.request.contextPath}/home">Travel</a></h1>
				</div>
				<ul class="menu-main">
					<li><a href="${pageContext.request.contextPath}/home">Головна</a></li>
					<li><a href="${pageContext.request.contextPath}/tours/1">Гарячі пропозиції</a></li>
					<sec:authorize access="!isAuthenticated()">
						<li><a class="scroll" href="${pageContext.request.contextPath}/login">Увійти</a></li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<li><a class="scroll" href="${pageContext.request.contextPath}/add-tour">Додати тур</a></li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<form:form action="/logout" method="POST">
							<input class="logout-style" type="submit" value="Вийти">
						</form:form>
					</sec:authorize>
				</ul>
			</div>