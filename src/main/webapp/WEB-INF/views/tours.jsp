<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
	
	
	<c:url var="firstUrl" value="${pageContext.request.contextPath}/tours/1?field=${sortByField}&sort=${sortDirection}&total=${totalPerPage}" />
	<c:url var="lastUrl" value="${pageContext.request.contextPath}/tours/${coursesList.totalPages}?field=${sortByField}&sort=${sortDirection}&total=${totalPerPage}" />
	<c:url var="prevUrl" value="${pageContext.request.contextPath}/tours/${currentIndex - 1}?field=${sortByField}&sort=${sortDirection}&total=${totalPerPage}" />
	<c:url var="nextUrl" value="${pageContext.request.contextPath}/tours/${currentIndex + 1}?field=${sortByField}&sort=${sortDirection}&total=${totalPerPage}" />
	
	<div class="container">
	
		<ul class="pagination">
			<c:choose>
				<c:when test="${currentIndex == 1}">
					<li class="disabled"><a href="#">&lt;&lt;</a></li>
					<li class="disabled"><a href="#">&lt;</a></li>
					<li class="disabled"><a href="${firstUrl}">1</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${firstUrl}">&lt;&lt;</a></li>
					<li><a href="${prevUrl}">&lt;</a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
				<c:url var="pageUrl" value="${pageContext.request.contextPath}/tours/${i+1}" />
				<c:choose>
					<c:when test="${i+1 == currentIndex}">
						<li class="disabled"><a href="${pageUrl}?field=${sortByField}&sort=${sortDirection}&total=${totalPerPage}"><c:out value="${i+1}" /></a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${pageUrl}?field=${sortByField}&sort=${sortDirection}&total=${totalPerPage}"><c:out value="${i+1}" /></a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:choose>
				<c:when test="${currentIndex == coursesList.totalPages}">
					<li class="disabled"><a href="#">&gt;</a></li>
					<li class="disabled"><a href="#">&gt;&gt;</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${nextUrl}">&gt;</a></li>
					<li><a href="${lastUrl}">&gt;&gt;</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		

<div class="container">
<c:forEach items="${tourListByPageSize}" var="tours" >
			<div class="products">
					<div class="col-sm-4">
						<div class="product">
							<div class="product-img">
								<a href="${pageContext.request.contextPath}/tour-info/${tours.id}"><img src="${pageContext.request.contextPath}/resources/img/plyazh-s-volnami1.jpg" alt="img"></a>
							</div>
							<p class="product-title">
								<a href="${pageContext.request.contextPath}/tour-info/${tours.id}">${tours.title}</a>
							</p>
							<p class="product-desc">${tours.description}</p>
							<p class="product-price">Price: € ${tours.price}</p>
						</div>
					</div>
			</div>
	</c:forEach>
	</div>
	
</div>