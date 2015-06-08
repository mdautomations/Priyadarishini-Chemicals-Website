
<!--============================== Load Header =================================-->
<%@include file="header.jsp"%>
<!-- ======================== Page Title =========================== -->
<div class="wrapper bg_title bg_grey_light">
	<div class="container_12 pagetitle">
		<article class="grid_9">
			<h1 class="color_white font_heading02">Skylark</h1>
			<p>
				<span class="color_white"><a href="index.jsp" class="wlink">Home</a>
					&rarr; <a href="blog.jsp" class="wlink">Domestic Chemicals</a>
					&rarr; Skylark</span>
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
	<section class="cont_pad">
		<div class="container_12">
			<article class="grid_8">
				<section class="post">
					<h3 class="posttitle">
						<a href="blog_single.jsp"
							style="font-size: 31px; font-weight: bolder; color: rgb(97, 178, 221);">Skylark</a>
					</h3>
					<br>
					<div class="postimg">
						<img src="images/skylark-banner.gif" class="pic2" alt=""
							style="background-color: white;">
					</div>
					<div class="entry-content">
						<h3 class="color_black ucase font_heading">
							<span style="color: #0A6291; font-size: 20px;">Salient
								Features</span>
						</h3>
						<ul
							style="line-height: 2.5; font-size: 13px; font-weight: bold; color: black;">
							<li><b style="color: #61b2dd;">SKYLARK</b> engine coolant is designed to protect cars and
								trucks radiators and cooling system for long stand. <b style="color: #61b2dd;">SKYLARK</b> have
								additives that are intended to protect cooling systems by
								preventing cooling systems by preventing corrosion, lubricating
								and increasing cooling efficiency to all vehicles. <b style="color: #61b2dd;">SKYLARK</b> suits
								for all environmental situations. It meets class II IS 5759 and
								Japanese JIS - K 2234 Standard.</li>
						</ul>
						<br>

						<h3 class="color_black ucase font_heading">
							<span style="color: #0A6291; font-size: 20px;">Dilutions</span>
						</h3>
						<ul
							style="line-height: 2.5; font-size: 13px; font-weight: bold; color: black;">
							<li>At normal temperature, 1 part of coolant, with 2 parts
								of water recommended for effective result. Can also dilute upto
								5 parts with water. For topping up, use only concentrated with
								no dilution. Fill up expansion bottle when cold.</li>
						</ul>
						<br>
						<h3 class="color_black ucase font_heading">
							<span style="color: #0A6291; font-size: 20px;">Caution</span>
						</h3>
						<ul
							style="line-height: 2.5; font-size: 13px; font-weight: bold; color: black;">
							<li style="color: rgb(200, 118, 118); font-weight: bolder;">
								Do not open radiator cap, when engine is hot. Keep Out reach of
								children. Harmfull if swallowed. To avoid staining on paint
								work, remove coolant spillage immedietly by washing off with
								water.</li>
						</ul>
						<br>
					</div>
				</section>
			</article>
			 <!--============================== Sideoption =================================-->
			<%@include file="sideoption.jsp" %>
	 <!--============================== Sideoption =================================-->
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
