<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="styleChanger/colorpicker/colorpicker.js"></script>
<script type="text/javascript" src="styleChanger/changer.js"></script>
<script type="text/javascript" src="rs-plugin/js/jquery.themepunch.plugins.min.js"></script>
<script type="text/javascript" src="rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
<script type="text/javascript">
   var tpj=jQuery;
   tpj.noConflict();
   
   tpj(document).ready(function() {
   
   if (tpj.fn.cssOriginal!=undefined)
   	tpj.fn.css = tpj.fn.cssOriginal;
   
   	tpj('.fullwidthbanner').revolution(
   		{	
   			delay:8000,												
   			startwidth:890,
   			startheight:350,
   			
   			onHoverStop:"on",						// Stop Banner Timet at Hover on Slide on/off
   			
   			thumbWidth:100,							// Thumb With and Height and Amount (only if navigation Tyope set to thumb !)
   			thumbHeight:50,
   			thumbAmount:3,
   			
   			hideThumbs:200,
   			navigationType:"none",					//bullet, thumb, none, both	 (No Shadow in Fullwidth Version !)
   			navigationArrows:"verticalcentered",		//nexttobullets, verticalcentered, none
   			navigationStyle:"square",				//round,square,navbar
   			
   			touchenabled:"on",						// Enable Swipe Function : on/off
   			
   			navOffsetHorizontal:0,
   			navOffsetVertical:20,
   			
   			fullWidth:"off",
   			
   			shadow:0,								//0 = no Shadow, 1,2,3 = 3 Different Art of Shadows -  (No Shadow in Fullwidth Version !)
   			
   			stopLoop:"off"							// on == Stop loop at the last Slie,  off== Loop all the time.
   										
   		});	
   	
   });
   
</script>
<script type="text/javascript" src="js/jquery-ui-1.8.20.custom.min.js"></script>
<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="js/superfish.js"></script>
<script type="text/javascript" src="js/supersubs.js"></script>
<script type="text/javascript" src="js/jquery.prettyPhoto.js"></script>
<script type="text/javascript" src="js/ddaccordion.js"></script>
<script type="text/javascript" src="js/jquery.carouFredSel-5.5.0-packed.js"></script>
<script type="text/javascript" src="js/accordation.js"></script>
<script type="text/javascript" src="js/jquery.zflickrfeed.min.js"></script>
<script type="text/javascript" src="js/isotope.js"></script>
<script>
   jQuery(document).ready(function() {
   		jQuery('.carousel').carouFredSel({
   			responsive : true,
   			width:'100%',
   			scroll: 1,
   			items: {
   				width: 450,
   				visible: {
   					min: 1,
   					max: 1
   				}
   			},
   			next : '.client-next',
   			prev : '.client-prev',
   			auto: true
   		});
   	});
   
</script>
<script type="text/javascript" src="js/mobilenav.js"></script>
<script type="text/javascript" src="js/custom.js"></script>
<script>
   (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
   (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
   m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
   })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
   
   ga('create', 'UA-48870092-2', 'auto');
   ga('send', 'pageview');
   window.onload = function () {
       var script = document.createElement("script");
       script.type = "text/javascript";
       script.src = "http://www.telize.com/jsonip?callback=DisplayIP";
       document.getElementsByTagName("head")[0].appendChild(script);
   };
   function DisplayIP(response) {
	   
	   var ipaddress = response.ip;
	   ga('send', 'event', ipaddress, document.location.pathname,Date().toLocaleString());
      
   }
   
</script>