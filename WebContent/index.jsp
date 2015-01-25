<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<jsp:include page="fragments/head.jsp" />
	<link rel="stylesheet" href="css/slides.css">
	<script type="text/javascript" src="js/slides.min.jquery.js"></script>
	<script type="text/javascript" src="js/jquery.carouFredSel-5.6.4-packed.js"></script>
	<script> 
 
	    $(document).ready(function() { 
		
			$('#slides').slides({
				preload: true,
				preloadImage: 'images/loading.gif',
				play:5000,
				pause: 4500,
				hoverPause: true,
				generatePagination:false,
				effect: 'fade'
			});


			$("#foo2").carouFredSel({
				items : 1
			});

		});
	</script>
	<body>
		<jsp:include page="fragments/header.jsp" />
		
		<jsp:include page="fragments/banners.jsp" />
		
		
		<div id="pvn-content-banner">
			<div class = "pvn-inner-content-banner">
				<div class="pvn-inner-title-banner"><span>Testemunhos</span></div>
				<div class="pvn-inner-image-banner"><img src="images/fotos/testemunho.jpg" width="230" height="150" alt="Testemunhos"></div>
				<div class="pvn-inner-text-banner">Os médicos disseram "não tem jeito" mas a Mão de Deus curou o bébé que ainda estava no meu ventre. O Senhor seja louvado.</div>
				<a href="category.action?id=23"><div class="pvn-button">Mais informacões</div></a>
			</div>
			<div class = "pvn-inner-content-banner">
				<div class="pvn-inner-title-banner"><span>FEAC- Projeto Social</span></div>
				<div class="pvn-inner-image-banner"><img src="images/fotos/pcaac.jpg" width="230" height="150" alt="PCAAC - Projeto Social"></div>
				<div class="pvn-inner-text-banner">Em parceria com outras instituições sociais apoiamos várias  famílias sendo mediadores na entrega de alimentos.</div>
				<a href="category.action?id=24"><div class="pvn-button">Mais informacões</div></a>
			</div>
			<div class = "pvn-inner-content-banner">
				<div class="pvn-inner-title-banner"><span>Semear</span></div>
				<div class="pvn-inner-image-banner"><img src="images/fotos/semear.jpg" width="230" height="150" alt="Image 1"></div>
				<div class="pvn-inner-text-banner"><i>"Jesus disse: Escutem! Certo homem saiu para semear"</i>  Mc. 4:3 - Seja você também um semeador em terra fértil</div>
				<a href="article.action?id=44"><div class="pvn-button">Mais informacões</div></a>
			</div>
		</div>
		<div id="pvn-main-content">
			<div id="pvn-main-content-left">
				<jsp:include page="fragments/albunsHome.jsp" />
				<div id="pvn-main-content-agenda">
					<jsp:include page="fragments/agenda.jsp" />
				</div>
			</div>
			<div id="pvn-main-content-articles">
				<jsp:include page="fragments/articles.jsp" />
			</div>
		</div>

		<jsp:include page="fragments/footer.jsp" />
	</body>
</html>