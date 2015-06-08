<!--============================== Load Header =================================-->
<%@include file="header.jsp" %>
<!-- ======================== Page Title =========================== -->
<div class="wrapper bg_title bg_grey_light">
   <div class="container_12 pagetitle">
      <article class="grid_9">
         <h1 class="color_white font_heading02">Cowmox LS</h1>
         <p><span class="color_white"><a href="index.jsp" class="wlink">Home</a> &rarr; <a href="#" class="wlink">Domestic Chemicals</a> &rarr; Cowmox LS</span> </p>
      </article>
      <article class="grid_1 last-col" style="float:right;">
         <form method="get" id="searchform" action="#">
            <div class="bgsearch">
               <input type="text" name="s" id="s2" value="Site Search..." onFocus="if (this.value == 'Site Search...')this.value = '';" onBlur="if (this.value == '')this.value = 'Site Search...';" />
               <input type="submit" class="searchbutton2" value="" />
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
               <h3 class="posttitle"><a href="#" style="
                  font-size: 31px;
                  font-family: bahamas;
                  color: rgb(97, 178, 221);
                  ">Cowmox LS</a></h3>
               <br>
               <div class="postimg"><img src="images/cowmax3-banner.gif" class="pic2" alt=""  /></div>
               <div class="entry-content">
                  <h3 class="color_black ucase font_heading"><span style="color: #0A6291;font-size: 20px;">Uses</span></h3>
                  <ul style="line-height: 2.5;  font-size: 13px;   font-weight: bold;    color: black;">
                     <li>
                        <b style="color: #61b2dd;">Cowmox LS</b> is recommended for washing floors, wash clothes, vessels, vehicles, carpets, window curtains, remove oils, greases, dirts, muds, etc.
                     </li>
                  </ul>
                  <br>
                  <h3 class="color_black ucase font_heading"><span style="color: #0A6291;font-size: 20px;">Directions to use</span></h3>
                  <ul style="line-height: 2.5;  font-size: 13px;   font-weight: bold;    color: black;">
                     <li>
                        Dilute with 10% of water (1:9) and start using.
                     </li>
                  </ul>
                  <br>
                  <h3 class="color_black ucase font_heading"><span style="color: #0A6291;font-size: 20px;">Caution</span></h3>
                  <ul style="line-height: 2.5;  font-size: 13px;   font-weight: bold;    color: black;">
                     <li style="color: rgb(200, 118, 118); font-weight: bolder;">
                        Not for medical use. Keep out of reach of children.
                     </li>
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
<%@include file="footer.jsp" %>
<!--============================== Load Footer Scripts =================================-->
<%@include file="footerscripts.jsp" %>
<!-- ============================================================================= -->
</body>
</html>