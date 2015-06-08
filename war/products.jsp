
<!--============================== Load Header =================================-->
<%@include file="header.jsp"%>
<!--============================== Page Title =================================-->
<div class="wrapper bg_title bg_grey_light">
	<div class="container_12 pagetitle">
		<article class="grid_9">
			<h1 class="color_white font_heading02">Portfolio</h1>
			<p>
				<span class="color_white"><a href="index.jsp" class="wlink">home</a>
					&rarr; <a href="portfolio_masonry.jsp" class="wlink">portfolio</a>
					&rarr; portfolio masonry</span>
			</p>
		</article>
		<article class="grid_1 last-col" style="float: right;">
			<form method="get" id="searchform" action="#">
				<div class="bgsearch">
					<input type="text" name="s" id="s2" value="Site Search..."
						onFocus="if (this.value == 'Site Search...')this.value = '';"
						onBlur="if (this.value == '')this.value = 'Site Search...';" /> <input
						type="submit" class="searchbutton2" value="" />
				</div>
			</form>
		</article>
	</div>
</div>
<!--============================== Content ================================-->
<div class="brd2"></div>
<div class="wrapper bg_white">
	<section class="cont_pad2">
		<div class="container_12 align_center">
			<h2 class="color_black font_heading02 lh0">
				We create professional and unique responsive design...<span
					class="color_orange ucase">oo yeah!</span>
			</h2>
			<h6 style="padding: 0 50px;">"Lorem ipsum dolor sit amet,
				consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
				labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
				exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat</h6>
		</div>
	</section>
	<div class="brd3"></div>
	<section class="cont_pad">
		<div class="container_12">
			<div class="filterable">
				<ul id="portfolio-nav">
					<li class="current"><a href="#" data-filter="*">All</a><span>/</span></li>
					<li><a data-filter=".web" href="#">Web Design</a><span>/</span></li>
					<li><a data-filter=".graphic" href="#">Graphic Design</a><span>/</span></li>
					<li><a data-filter=".illustrator" href="#illustrator">Illustrator</a><span>/</span></li>
					<li><a data-filter=".photography" href="#">Photography</a></li>
				</ul>
			</div>
			<div class="portfolio-grid">
				<ul id="thumbs">
					<li class="col3 item web"><img
						src="http://placehold.it/319x200" alt="" height="200" />
						<div class="item-info">
							<h3 class="title">Title Here</h3>
							<p>Ut enim ad minima veniam, quis nostrum exercitationem
								ullam corporis suscipit laboriosam, nisi ut aliquid ex ea
								commodi consequatur.</p>
						</div>
						<div class="item-info-overlay">
							<div>
								<a href="portfolio_single.jsp" class="link">preview</a> <a
									href="http://placehold.it/500x344" class="preview"
									data-rel="prettyPhoto[web]">preview</a>
							</div>
						</div></li>
					<li class="col3 item graphic"><img
						src="http://placehold.it/319x270" alt="" height="270" />
						<div class="col3 item-info">
							<h3 class="title">Title Here</h3>
							<p>Ut enim ad minima veniam, quis nostrum exercitationem
								ullam corporis suscipit laboriosam, nisi ut aliquid ex ea
								commodi consequatur.</p>
						</div>
						<div class="item-info-overlay">
							<div>
								<a href="portfolio_single.jsp" class="link">preview</a> <a
									href="http://placehold.it/500x344" class="preview"
									data-rel="prettyPhoto[web]">preview</a>
							</div>
						</div></li>
					<li class="col3 item illustrator"><img
						src="http://placehold.it/319x220" alt="" height="220" />
						<div class="col3 item-info">
							<h3 class="title">Title Here</h3>
							<p>Ut enim ad minima veniam, quis nostrum exercitationem
								ullam corporis suscipit laboriosam, nisi ut aliquid ex ea
								commodi consequatur.</p>
						</div>
						<div class="item-info-overlay">
							<div>
								<a href="portfolio_single.jsp" class="link">preview</a> <a
									href="http://placehold.it/500x344" class="preview"
									data-rel="prettyPhoto[web]">preview</a>
							</div>
						</div></li>
					<li class="col3 item photography"><img
						src="http://placehold.it/319x270" alt="" height="270" />
						<div class="col3 item-info">
							<h3 class="title">Title Here</h3>
							<p>Ut enim ad minima veniam, quis nostrum exercitationem
								ullam corporis suscipit laboriosam, nisi ut aliquid ex ea
								commodi consequatur.</p>
						</div>
						<div class="item-info-overlay">
							<div>
								<a href="portfolio_single.jsp" class="link">preview</a> <a
									href="http://placehold.it/500x344" class="preview"
									data-rel="prettyPhoto[web]">preview</a>
							</div>
						</div></li>
					<li class="col3 item illustrator"><img
						src="http://placehold.it/319x300" alt="" height="300" />
						<div class="col3 item-info">
							<h3 class="title">Title Here</h3>
							<p>Ut enim ad minima veniam, quis nostrum exercitationem
								ullam corporis suscipit laboriosam, nisi ut aliquid ex ea
								commodi consequatur.</p>
						</div>
						<div class="item-info-overlay">
							<div>
								<a href="portfolio_single.jsp" class="link">preview</a> <a
									href="http://placehold.it/500x344" class="preview"
									data-rel="prettyPhoto[web]">preview</a>
							</div>
						</div></li>
					<li class="col3 item graphic"><img
						src="http://placehold.it/319x250" alt="" height="250" />
						<div class="col3 item-info">
							<h3 class="title">Title Here</h3>
							<p>Ut enim ad minima veniam, quis nostrum exercitationem
								ullam corporis suscipit laboriosam, nisi ut aliquid ex ea
								commodi consequatur.</p>
						</div>
						<div class="item-info-overlay">
							<div>
								<a href="portfolio_single.jsp" class="link">preview</a> <a
									href="http://placehold.it/500x344" class="preview"
									data-rel="prettyPhoto[web]">preview</a>
							</div>
						</div></li>
					<li class="col3 item web"><img
						src="http://placehold.it/319x210" alt="" height="210" />
						<div class="col3 item-info">
							<h3 class="title">Title Here</h3>
							<p>Ut enim ad minima veniam, quis nostrum exercitationem
								ullam corporis suscipit laboriosam, nisi ut aliquid ex ea
								commodi consequatur.</p>
						</div>
						<div class="item-info-overlay">
							<div>
								<a href="portfolio_single.jsp" class="link">preview</a> <a
									href="http://placehold.it/500x344" class="preview"
									data-rel="prettyPhoto[web]">preview</a>
							</div>
						</div></li>
					<li class="col3 item photography"><img
						src="http://placehold.it/319x315" alt="" height="315" />
						<div class="col3 item-info">
							<h3 class="title">Title Here</h3>
							<p>Ut enim ad minima veniam, quis nostrum exercitationem
								ullam corporis suscipit laboriosam, nisi ut aliquid ex ea
								commodi consequatur.</p>
						</div>
						<div class="item-info-overlay">
							<div>
								<a href="portfolio_single.jsp" class="link">preview</a> <a
									href="http://placehold.it/500x344" class="preview"
									data-rel="prettyPhoto[web]">preview</a>
							</div>
						</div></li>
					<li class="col3 item web"><img
						src="http://placehold.it/319x240" alt="" height="240" />
						<div class="col3 item-info">
							<h3 class="title">Title Here</h3>
							<p>Ut enim ad minima veniam, quis nostrum exercitationem
								ullam corporis suscipit laboriosam, nisi ut aliquid ex ea
								commodi consequatur.</p>
						</div>
						<div class="item-info-overlay">
							<div>
								<a href="portfolio_single.jsp" class="link">preview</a> <a
									href="http://placehold.it/500x344" class="preview"
									data-rel="prettyPhoto[web]">preview</a>
							</div>
						</div></li>
				</ul>
			</div>
			<div class="wp-pagenavi">
				<span class="pages">Page 1 of 2</span><span class="current">1</span><a
					href="#" class="page">2</a><a href="#" class="page">&raquo;</a>
			</div>
		</div>
	</section>
	<section id="content" class="cont_pad">
		<div class="container_12">
			<div class="heading_line">
				<h3 class="color_black font_heading ucase">
					<span>Our Clients</span>
				</h3>
			</div>
			<ul class="client">
				<li><img src="../images/clientlogo/gtnlog.gif"
					class="grayscale" alt="" /></li>
				<li><img src="../images/clientlogo/dum.gif" class="grayscale"
					alt="" /></li>
				<li><img src="../images/clientlogo/main.gif" class="grayscale"
					alt="" /></li>
				<li><img src="../images/clientlogo/hes.gif" class="grayscale"
					alt="" /></li>
				<li class="last"><img src="../images/clientlogo/cri.gif"
					class="grayscale" alt="" /></li>
			</ul>
		</div>
	</section>
</div>
<!--============================== Footer =================================-->
<%@include file="footer.jsp"%>
<!--============================== Load Footer Scripts =================================-->
<%@include file="footerscripts.jsp"%>
<!-- ============================================================================= -->

</body>
</html>
