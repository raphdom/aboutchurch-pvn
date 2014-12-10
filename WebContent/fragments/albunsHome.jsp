<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="image_carousel_home">
	<div class="image_carousel_home_title">JÁ ACONTECEU:</div>
	<div id="foo2">    
	    <c:forEach var="album" items="${albuns}">
		    <div class = "image_carousel_home_mini">
		    	<a href="galeria/album/<c:out value='${album.id}'/>">
		    		<img src="getThumb.action?id=<c:out value='${album.thumbId}'/>&dataType=5"  
		    			width="280" height="200" />
		    	</a>
		    	<div class="title"><c:out value='${album.title}'/></div>
		   	</div>
	    </c:forEach>
   	</div>
 </div> 
