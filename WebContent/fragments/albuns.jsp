<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="image_carousel">
	<div class="pvn-albuns-title">Álbuns relacionados:</div>
	<div id="foo2">    
  		<c:forEach var="album" items="${albuns}">
			<a href="galeria/album/<c:out value='${album.id}'/>"><img src="getThumb.action?id=<c:out value='${album.thumbId}'/>&dataType=3&width=140&height=140&exactlySize=true"  width="140" height="140" /></a>
		</c:forEach>
		<div class="clearfix"></div>
	</div>
</div>