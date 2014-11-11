<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="fragments/head.jsp" />
	<script type="text/javascript" src="js/jquery.carouFredSel-5.6.4-packed.js"></script>
	<script> 
 
	    $(document).ready(function() { 
		
	    	$("#foo2").carouFredSel({
   		        items: 5
	    	});
	    }); 
		    
		 
	</script>	
	<body>
		<jsp:include page="fragments/header.jsp" />
		<jsp:include page="fragments/path.jsp" />
		<div id="pvn-article">
			<c:if test="${not empty category.thumbId}">
				<div class="image"><img src="getThumb.action?id=<c:out value='${category.thumbId}'/>&dataType=6&width=250&height=250&exactlySize=false"  alt=""></div>
			</c:if>
			<div class="titulo"><c:out value="${category.text}"/></div>
			<div class="cont_artigo"><c:out value="${category.description}" escapeXml="false"/></div>
			<div id="pvn-main-content-agenda-horizontal">
				<%-- <jsp:include page="fragments/agendaHorizontal.jsp" /> --%>
			</div>
			<div id="pvn-main-content-articles-category">
				<jsp:include page="fragments/articles.jsp" />
			</div>
			
			<c:choose>
			 <c:when test="${empty albuns}">
			 </c:when>
			 <c:otherwise>
			      <jsp:include page="fragments/albuns.jsp" />
			 </c:otherwise>
			</c:choose>
			
		</div>
		
		<jsp:include page="fragments/footer.jsp" />
	</body>
</html>