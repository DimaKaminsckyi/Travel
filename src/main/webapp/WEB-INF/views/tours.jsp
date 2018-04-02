<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
	
	
	
	<c:url var="prevUrl" value="${pageContext.request.contextPath}/tours/${currentIndex - 1}?field=${sortByField}&sort=${sortDirection}&total=${totalPerPage}" />
	<c:url var="nextUrl" value="${pageContext.request.contextPath}/tours/${currentIndex + 1}?field=${sortByField}&sort=${sortDirection}&total=${totalPerPage}" />
	
	
	<style>
		#footer{
			height: 135px;
		}
	</style>
	
	<div class="container">
	
		<ul class="pagination">
			<c:choose>
				<c:when test="${currentIndex == 1}">

					<li class="disabled"><a style="color: #ff944d;" href="#">&lt;</a></li>
					<li class="disabled"><a style="color: #ff944d;" href="${firstUrl}">1</a></li>
				</c:when>
				<c:otherwise>

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

				</c:when>
				<c:otherwise>
					<li><a href="${nextUrl}">&gt;</a></li>

				</c:otherwise>
			</c:choose>
		</ul>
		

<div class="container">
<c:forEach items="${tourListByPageSize}" var="tours" >
			<div class="products">
					<div class="col-sm-4">
						<div class="product">
						
							<div class="product-img">
								<a href="${pageContext.request.contextPath}/${tours.id}/tour-info"><img style="border-radius: 10px;" src="data:image/png; base64, ${tours.imagePath}" alt="img"></a>
							</div>
							<p class="product-title">
								<a href="${pageContext.request.contextPath}/${tours.id}/tour-info">${tours.title}</a>
							</p>
							<p class="product-desc">${tours.description}</p>
							<p class="product-price">Ціна: $ ${tours.price}</p>
						</div>
					</div>
			</div>
	</c:forEach>
	</div>
	
</div>