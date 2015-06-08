<!--============================== Load Header =================================-->
<%@include file="header.jsp" %>
<!--============================== Page Title =================================-->
<div class="wrapper bg_title bg_grey_light">
  <div class="container_12 pagetitle">
    <article class="grid_9">
      <h1 class="color_white font_heading02">Contact Us</h1>
      <p><span class="color_white"><a href="index.jsp" class="wlink">home</a> &rarr; contact us</span> </p>
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
  <article>
    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3916.2343361176345!2d76.98688699999997!3d11.021037000000005!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3ba858560c69b243%3A0x6f2388a45d986f46!2sPriyadarishini+Chemicals!5e0!3m2!1sen!2sin!4v1419565575049" width="100%" height="300" frameborder="0" style="border:0"></iframe>
  </article>
  <!--==============================content================================-->
  <section class="cont_pad2">
    <div class="container_12" style="margin-bottom:30px;" >
      <article class="grid_8 ">
        <div class="heading_line">
          <h3 class="color_black font_heading ucase"><span>Leave us a message</span></h3>
        </div>
        <form id="contact-form">
          <div class="success">Contact form submitted!<br>
            <strong>We will be in touch soon.</strong> </div>
          <fieldset>
          <label class="name">
          <input type="text" value="Name:">
          <span class="error">*This is not a valid name.</span> <span class="empty">*This field is required.</span> </label>
          <label class="email">
          <input type="text" value="E-mail:">
          <span class="error">*This is not a valid email address.</span> <span class="empty">*This field is required.</span> </label>
          <label class="phone">
          <input type="text" value="Phone:">
          <span class="error">*This is not a valid phone number.</span> <span class="empty">*This field is required.</span> </label>
          <label class="message">
          <textarea>Message:</textarea>
          <span class="error">*The message is too short.</span> <span class="empty">*This field is required.</span> </label>
          <div class="buttons2"> <a href="#" data-type="reset" class="button orange">Clear</a><a href="#" data-type="submit" class="button orange">Submit</a> </div>
          </fieldset>
        </form>
      </article>
      <article class="grid_4 last-col">
        <div class="heading_line">
          <h3 class="color_black font_heading ucase"><span>Reach to Us</span></h3>
        </div>
        <dl class="adress1" style="line-height: 2.0;">
        <dt><img src="images/prichemicals.png" style="margin-left: -2%;"><br>
           #49/2, Guru Building, Nava India Road.</dt>
           <dd>Near SNR Sons College, K. R. Puram</dd>
           <dd>Coimbatore, Tamil Nadu - 641 006, India</dd>
          <dd><span>Mobile:</span> +91. 9443022310, 8508888111</dd>
          <dd><span>Telephone:</span> +91. 422-2567040, 2567114</dd>
          <dd>E-mail: <a href="#" class="link1">info@prichemgroups.com</a></dd>
          <dd>Web: <a href="/index.jsp" class="link1">http://prichemgroups.com</a></dd>
        </dl>
      </article>
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
