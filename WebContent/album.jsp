<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="fragments/head.jsp" />
	<!--[if lt IE 9]>
  		<script type="text/javascript" src="js/excanvas.js"></script>
	<![endif]-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/spinners.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/lightview.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/lightview.css"/>
	
	<c:set var="req" value="${pageContext.request}" />
    <c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />
	<body>
		<jsp:include page="fragments/header.jsp" />
		<jsp:include page="fragments/path.jsp" />
		<div id = "pvn-content-galery">
			<div id = "pvn-galery">
				<div id="pvn-album-name"><c:out value="${album.title}"/></div>
				<c:if test="${not empty album.items}">
					    <c:forEach var="item" items="${album.items}">
					    	<div class="pvn-galery-item">
					    		<div class="image">
					    			<a href="${baseURL}/getThumb.action?id=<c:out value='${item.id}'/>&dataType=10" 
										class="lightview"
										data-lightview-group ='album'
										data-lightview-title ='<c:out value="${item.title}"/>' 
			   							data-lightview-caption ="<c:out value='${item.description}'/>"
			   							data-lightview-group-options ="controls: 'thumbnails'">
			   							<img src="${pageContext.request.contextPath}/getThumb.action?id=<c:out value='${item.id}'/>&dataType=5" width="280" height="200" alt="" />
			   						</a>
			   					</div>
			   					<div class="title-image"><c:out value='${item.title}'/></div>
								<div class="caption-image"><c:out value='${item.description}'/></div>
			   				</div>
					    </c:forEach>
			    </c:if>
			</div>
		</div>
		<jsp:include page="fragments/footer.jsp" />
	</body>
</html>