<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<c:forEach var="article" items="${articles}">
   <div class="pvn-article-block">
		<div class="article-header">
			<a href="article.action?id=<c:out value='${article.id}'/>">
				<div class="article-header-image">
					<c:choose>
					 <c:when test="${empty article.thumbId}">
					 	<img src="images/fotos/article.jpg" width="80" height="80" alt="">
					 </c:when>
					 <c:otherwise>
					 	<img src="getThumb.action?id=<c:out value='${article.thumbId}'/>&dataType=2" width="80" height="80" alt="">
					 </c:otherwise>
					</c:choose>
				</div>
			</a>
			<a href="article.action?id=<c:out value='${article.id}'/>">
				<div class="article-header-title"><c:out value='${article.title}'/></div>
			</a>
		</div>
		<div class="article-intro"><c:out value='${article.introarticle}' escapeXml="false"/></div>
		<a href="article.action?id=<c:out value='${article.id}'/>" class="article-readmore">leia mais</a>
	</div>
</c:forEach>