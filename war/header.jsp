<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <title>Priyadarishini Chemicals</title>
      <meta name="robots" content="index, follow" />
      <meta name="keywords" content="" />
      <meta name="description" content="" />
      <meta name="author" content="" />
      <meta name="viewport" content="width=device-width; initial-scale=1.0">
      <!-- ========================  CSS Files  ========================== -->
      <link rel="stylesheet" type="text/css" media="screen" href="css/style.css">
      <link rel="stylesheet" type="text/css" media="all" href="css/prettyPhoto.css" />
      <link rel="stylesheet" type="text/css" href="css/fullwidth.css" media="screen" />
      <link rel="stylesheet" type="text/css" href="rs-plugin/css/settings.css" media="screen" />
      <link rel="stylesheet" type="text/css" href="styleChanger/changer.css" />
      <link rel="stylesheet" type="text/css" href="styleChanger/colorpicker/colorpicker.css" />
      <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
      <script type="text/javascript" src="js/jquery.min.js"></script>
      <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
      <script type="text/javascript" src="js/jquery.zflickrfeed.min.js"></script>
      <script type="text/javascript" src="js/jquery.flexslider.js"></script>
      <script type="text/javascript" src="js/supersubs.js"></script>
      <script type="text/javascript" src="js/superfish.js"></script>
      <script type="text/javascript" src="js/jquery-ui-1.8.20.custom.min.js"></script>
      <script type="text/javascript" src="styleChanger/colorpicker/colorpicker.js"></script>
      <script type="text/javascript" src="styleChanger/changer.js"></script>
      <script type="text/javascript">
         $(function() { 
         /*Quick Contact on top*/
         $('a.contact-bar-tab').hover(function() {
             $(this).parent().parent().toggleClass("close");
         });
         var expand = $('#contact-wrap .qcontact');
         expand.css("display", "none");
         $('a.contact-bar-tab').click(function() {
             if (expand.is(":visible")) {
                 expand.slideUp(500, 'easeInOutExpo');
                 $(this).removeClass("close");
                 $(this).parent().parent().parent().removeClass("close");
             } else {
                 expand.slideDown(500, 'easeInOutExpo');
                 $(this).addClass("close");
                 $(this).parent().parent().parent().addClass("close");
             };
             return false;
         });
         
         
         /*jQuery init*/
         $('body').removeClass('sg-nojs');
         $(".proj-img").fitVids();
         
         
         });
         $(function(){
           SyntaxHighlighter.all();
         });
         $(window).load(function(){
           $('.flexslider').flexslider({
             animation: "fade",
             start: function(slider){
               $('body').removeClass('loading');
             }
           });
         });
      </script>
      <style id="cFontStyleWColor1" type="text/css">
         a, .sf-menu>li>a:hover, .sf-menu>li.current>a, .sf-menu>li.sfHover>a, .sf-menu li li a:hover, .sf-menu li.sfHover li.sfHover>a, .more, .color_orange, ul.list-box .price-text .price, .posttime h1, .smalldate, .posttitle a:hover, .caption.big_green, .caption.very_big_green, .button.white, .resp_navigation:hover, .resp_navigation.active, .sf-menu>li>a:hover, .sf-menu>li.current>a, .sf-menu>li.sfHover>a, .botlink a:hover {
         color:#61b2dd;
         }
      </style>
      <style id="cFontStyleWColor2" type="text/css">
         .view-tenth .mask, .pic:hover, .pic2:hover, .skills li span, .orange, .social a:hover img, .button.orange, .filterable li a:hover, .filterable li.current a, .tabs-nav li.active a, .tag-cloud a:hover, .caption.very_big_white {
         background-color:#61b2dd;
         }
      </style>
      <style id="cFontStyleWColor3" type="text/css">
         .color_green, .circle:hover, .heading_line span, header {
         border-color:#61b2dd;
         }
      </style>
      <style id="cFontStyleWColor4" type="text/css">
         body {
         }
         .pic, .rad30, .pic2, .pic3, .button.orange, .button, .button.white {
         behavior: url(PIE.htc);
         }
         .sidedock {
         display:none !important;
         }
      </style>
   </head>
   <body>
      <!--============================== Top Bar =================================-->
      <div id="contact-wrap">
         <div class="qcontact clearfix">
            <div class="container_12">
               <article class="grid_8">
                  <h3 class="color_white font_heading02 txt_shd">One of the leading manufacturers of chemicals<a href="#" class="button orange" style="top:-12px; position:relative;"> Purchase Now!</a></h3>
               </article>
               <article class="grid_4 last-col">
                  <div class="social"> <a href="#" title="Twitter"><img src="images/social/twitter.png" alt=""></a> <a href="#" title="Facebook"><img src="images/social/facebook.png" alt=""></a> <a href="#" title="Linkedin"><img src="images/social/linkedin.png" alt=""></a> <a href="#" title="Skype"><img src="images/social/skype.png" alt=""></a> <a href="#" title="RSS"><img src="images/social/rss.png" alt=""></a></div>
               </article>
            </div>
            <div class="ef-list"></div>
         </div>
         <div class="top-line">
            <div><a href="#" class="contact-bar-tab"></a></div>
         </div>
      </div>
      <!--============================== Header =================================-->
      <header>
         <!-- <img src="/images/prichem.jpg" style="height: 50px;float: left;"> -->
         <div class="container_12" style="width: 100%;">
            <h1>
               <a class="logo ucase" href="index.jsp"><img src="/images/logo3.png" style="height: 46px;">&nbsp;Priyadarishini&nbsp;<span class="color_orange">Chemicals</span></a>
            </h1>
            <div class="nav_wrap">
               <div class="nav_wrap_inner">
                  <div class="responsibe_block">
                     <div class="responsibe_block_inner"> <a href="#" class="resp_navigation"></a> </div>
                  </div>
                  <nav class="main-menu">
                     <ul class="sf-menu">
                        <li><a href="index.jsp" data-description="All starts here">Home</a></li>
                        <li>
                           <a href="about.jsp" data-description="Who We Are">About Us</a>
                           <ul>
                              <li><a href="/about.jsp">Vision and Value</a></li>
                              <li><a href="/about.jsp">Infrastructure</a></li>
                              <li><a href="/about.jsp">Our Team</a></li>
                              <li><a href="/about.jsp">R&D</a></li>
                              <li class="last_item"><a href="/policy.jsp">Safety Policy</a></li>
                           </ul>
                        </li>
                        <li><a href="gallery.jsp" data-description="Splendid Photos">Gallery</a></li>
                        <li>
                           <a href="#" data-description="Prichem at domestic">Domestic</a>
                           <ul>
                              <li><a href="/autobond1.jsp">Autobond</a></li>
                              <li><a href="/brakefluid.jsp">Brake Fluid</a></li>
                              <li><a href="/cowmax1.jsp">Cowmax LS</a></li>
                              <li ><a href="/cowmax2.jsp">Cowmax SR</a></li>
                              <li><a href="/ferrokare.jsp">Ferrokare</a></li>
                              <li><a href="/flax.jsp">Flax</a></li>
                              <li><a href="/forkoil.jsp">Fork Oil</a></li>
                              <li><a href="/gem20w40.jsp">Gem 20W40</a></li>
                              <li><a href="/gem20w50.jsp">Gem 20W50</a></li>
                              <li><a href="/gemg90.jsp">Gem G90</a></li>
                              <li><a href="/gemg140.jsp">Gem G140</a></li>
                              <li><a href="/paicor.jsp">Paicor</a></li>
                              <li><a href="/pritobond.jsp">Pritobond</a></li>
                              <li><a href="/pritocoolplus.jsp">Pritocool Plus</a></li>
                              <li><a href="/pritocoolplusgreen.jsp">Pritocool Plus Green</a></li>
                              <li><a href="/pritocoolstar.jsp">Pritocool Star</a></li>
                              <li class="last_item"><a href="/skylarks.jsp">Skylark</a></li>
                           </ul>
                        </li>
                        <li>
                           <a href="/industrialchemical.jsp" data-description="Prichem at Industrial">Industrial</a>
                           <ul>
                              <li><a href="/industrialchemical.jsp">Metal Treatment Chemicals</a></li>
                              <li><a href="/industrialchemical.jsp">Abrasive & Vibro Polishing Chemicals</a></li>
                              <li><a href="/industrialchemical.jsp">Automobile and Electronic Speciality Chemicals</a></li>
                              <li ><a href="/industrialchemical.jsp">Powder Coating and Plating Chemicals</a></li>
                              <li><a href="/industrialchemical.jsp">Aluminium and Non-Ferrous Industrial Chemicals</a></li>
                              <li><a href="/industrialchemical.jsp">Water and Sewage Treatments Chemicals</a></li>
                              <li><a href="/industrialchemical.jsp">Textile Industry Chemicals</a></li>
                              <li class="last_item"><a href="/industrialchemical.jsp">Construction Chemicals</a></li>
                           </ul>
                        </li>
                        <li>
                           <a href="/services.jsp" data-description="Our proud partners">Trading</a>
                           <ul>
                              <li><a href="/services.jsp">General (Powder)</a></li>
                              <li><a href="/services.jsp">Solvents</a></li>
                              <li><a href="/services.jsp">Acids</a></li>
                              <li><a href="/services.jsp">Oils and Lubricants</a></li>
                              <li><a href="/services.jsp">Abrasives & Vibro Polishing Media</a></li>
                              <li><a href="/services.jsp">Lab Equipments and Glassware</a></li>
                              <li class="last_item"><a href="/services.jsp">Gloves and Masks</a></li>
                           </ul>
                        </li>
                        <li><a href="/downloads.jsp" data-description="Know our products">Downloads</a></li>
                        <li class="last" ><a href="/contacts.jsp" data-description="Let us know">Contact</a></li>
                     </ul>
                  </nav>
               </div>
            </div>
         </div>
      </header>