<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Tour Project</title>
	<jsp:include page="/WEB-INF/include/style.jsp" />
</head>

<body>

	<div id="app">
			<tiles:insertAttribute name="header" />

				<tiles:insertAttribute name="body"/>

			<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>


	