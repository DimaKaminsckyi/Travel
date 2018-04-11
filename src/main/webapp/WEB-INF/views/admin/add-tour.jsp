<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="/WEB-INF/taglib.jsp" %>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<style>
	#footer{
		height: 135px;
	}
</style>

<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Create Tour</h3>
					<form:form method="POST" 
					action="/add-tour" 
					modelAttribute="tourModel"
					enctype="multipart/form-data">
					
						<div class="form-group">
							<form:errors path="*" cssClass="error"/>
						</div>
						<div class="form-group">
							
							
							<label class="control-label">Tour Title:</label>
							<form:input path="title" cssClass="form-control" />
						
							<label class="control-label">Description:</label>
							<form:input path="description" cssClass="form-control" />
						
  							<label class="control-label">Price:</label>
							<form:input path="price" cssClass="form-control"/>
							
							<label class="control-label">Country:</label>
							<form:input path="countryName" cssClass="form-control"/>
							
							<label class="control-label">Tour Image:</label>
							<form:input path="tourImage" type="file" cssClass="form-control"/>
								
							<label class="control-label">Grubby:</label>							
							<form:input path="grubby" cssClass="form-control"/>
							
							<label class="control-label">City:</label>							
							<form:input path="departureFromTheCity" cssClass="form-control"/>
							
							<label class="control-label">Day:</label>							
							<form:input path="dayInTour" cssClass="form-control"/>
							
							<label class="control-label">Hotel Title:</label>							
							<form:input path="hotelTitle" cssClass="form-control"/>
							
							<label class="control-label">Rooms:</label>							
							<form:input path="numberOfRooms" cssClass="form-control"/>
							
							<label class="control-label">Category:</label>							
							<form:input path="category" cssClass="form-control"/>
							
							<label class="control-label">About Hotel:</label>							
							<form:input path="aboutHotel" type="text" cssClass="form-control"/>
							
							
						
						</div>
						<div class="form-group">
							<span class="input-group-btn">
								<input type="submit" style="background-color: #ff944d; border: none;" class="btn btn-primary btn-block" value="Create tour">
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>