<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib.jsp" %>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/tour-info.css" rel="stylesheet">

<style>
	#footer{
		height: 135px;
	}
	
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
</style>

	<div id="primary" class="content-area col-lg-9">
	
		<div class="featured_card">
			<div class="tour-about">
				<div class="row">
					<div class="col-sm-6"><img src="data:image/png; base64, ${imgTour}"" alt="img"></div>
					<div class="col-sm-6">
						<h1 class="entry-title">${tour.title}</h1>
						<table class="featured_options">
							<tbody>
								<tr>
									<th>Країна</th>
									<th>${tour.country.name}</th>
								</tr>
								<tr>
									<th>Ціна</th>
									<th>${tour.price}</th>
								</tr>
								<tr>
									<th>Виїзд з</th>
									<th>${tour.tourDetails.departureFromTheCity }</th>
								</tr>
								<tr>
									<th>Готель</th>
									<th>${tour.hotel.title} </th>
								</tr>
								<tr>
									<th>Кількість зірок</th>
									<th>${tour.hotel.hotelDetails.category}</th>
								</tr>

							</tbody>
						</table>
					</div>
				</div>
			</div>
			<br>
			<div class="booking-content">
			<sec:authorize access="isAuthenticated()">
						<form:form action="/delete-tour/${tour.id }" method="GET">
							<input class="logout-style" type="submit" value="Видалити тур">
						</form:form>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
						<form:form action="/edit-tour/${tour.id }" method="GET">
							<input class="logout-style" type="submit" value="Змінити тур">
						</form:form>
				</sec:authorize>
				<h3><strong style="color: #ff944d;">${tour.hotel.title}</strong></h3>
				
				<table>
					<tr>
						<th>Кількість ночей</th>
						<th>${tour.tourDetails.dayInTour }</th>
					</tr>
					<tr>
						<th>Харчування</th>
						<th>${tour.tourDetails.grubby }</th>
					</tr>
				</table>
				
				<p>${tour.hotel.hotelDetails.aboutHotel }</p>
			</div>
		</div>
	</div>
	