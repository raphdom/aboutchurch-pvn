<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="fragments/head.jsp" />
	<body>
		<jsp:include page="fragments/header.jsp" />
		<jsp:include page="fragments/path.jsp" />
		<div id="pvn-article">
			<div class="image">
				<c:choose>
				 <c:when test="${empty event.thbId}">
				 	<img src="${pageContext.request.contextPath}/images/fotos/events.jpg" width="100" height="100" alt="" />
				 </c:when>
				 <c:otherwise>
				 	<img src="${pageContext.request.contextPath}/getThumb.action?id=<c:out value='${event.thbId}'/>&dataType=4" width="150" height="150" alt="" />
				 </c:otherwise>
				</c:choose>
			</div>
			<div class="titulo"><c:out value="${event.title}"/></div>
			<div class="when">
				<fmt:formatDate pattern="E" value="${eventRecurrence.start}"/>
				<fmt:formatDate dateStyle="long" value="${eventRecurrence.start}"/> das
				<fmt:formatDate type="time" timeStyle="short" value="${eventRecurrence.start}"/> às
				<fmt:formatDate type="time" timeStyle="short" value="${eventRecurrence.end}"/>
			</div>
			<div class="onde">Onde: <c:out value="${event.loc}"/></div>
			<div class="cont_artigo"><c:out value="${event.notes}" escapeXml="false"/></div>
		</div>
		<jsp:include page="fragments/footer.jsp" />
	</body>
</html>