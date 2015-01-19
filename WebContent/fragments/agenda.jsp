<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="pvn-main-content-agenda-title">Agenda:</div>        
<c:forEach var="event" items="${events}">
	<div class="pvn-main-content-agenda-list">
		<div class="agenda-image"><a href="evento/<c:out value="${event.id}"/>">
			<c:choose>
				<c:when test="${empty event.thumbId}">
					<img src="images/fotos/events.jpg" width="100" height="100" alt="">
				</c:when>
				<c:otherwise>
					<img src="getThumb.action?id=<c:out value='${event.thumbId}'/>&dataType=3" width="100" height="100" alt="">
				</c:otherwise>
			</c:choose>	    		
		</a></div>
		<div class="agenda-conteudo">
			<div class="agenda-date">
				<fmt:formatDate pattern="E" value="${event.start}"/>
				<fmt:formatDate dateStyle="MEDIUM" value="${event.start}"/>
			</div>
			<div class="agenda-title"><c:out value="${event.title}"/></div>
			<div class="agenda-more">
				<a href="evento/<c:out value="${event.id}"/>">
				LEIA MAIS
				</a>
			</div>
		</div>
	</div>
</c:forEach> 
