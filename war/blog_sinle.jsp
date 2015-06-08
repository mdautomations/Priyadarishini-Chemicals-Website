<!--============================== Load Header =================================-->
<%@include file="header.jsp" %>
<!-- ======================== Page Title =========================== -->
<div class="wrapper bg_title bg_grey_light">
   <div class="container_12 pagetitle">
      <article class="grid_9">
         <h1 class="color_white font_heading02">Blog</h1>
         <p><span class="color_white"><a href="index.jsp" class="wlink">home</a> &rarr; <a href="blog.jsp" class="wlink">blog</a> &rarr; blog single</span> </p>
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
               <h3 class="posttitle"><a href="blog_single.jsp">Quis Nostrud Exercitation Ullamco Laboris Nisi, Ut Aliquip</a></h3>
               <div class="postimg"><img src="http://placehold.it/600x200" class="pic2" alt=""  /></div>
               <div class="entry-utility"> <a href="#"><img src="images/blog/icon1.png" alt="">22 Oct 2012</a> <a href="#"><img src="images/blog/icon2.png" alt="">Admin</a> <a href="#"><img src="images/blog/icon3.png" alt="">25 Views</a> <a href="#"><img src="images/blog/icon4.png" alt="">10 Comments</a> <a href="#"><img src="images/blog/icon5.png" alt="">Responsive Template </a> </div>
               <div class="entry-content">
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                  <h3 class="color_black">Large Heading</h3>
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                  <h4 class="color_black">Small Sub Heading</h4>
                  <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
               </div>
            </section>
            <section id="comment">
               <div class="heading_line">
                  <h3 class="color_black font_heading ucase"><span>4 Comments</span></h3>
               </div>
               <ol class="commentlist">
                  <li>
                     <div class="comment-body">
                        <div class="avatar-img"><img src="images/blog/avatar2.png" alt="" class="avatar pic2"/></div>
                        <cite class="fn"><a href="#">Dean John</a></cite><br/>
                        <span class="tdate">October 22, 2012 8:45 am</span> &nbsp;/&nbsp; <span class="reply"><a href="#" class="more">Reply</a></span>
                        <div class="commenttext">
                           <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo</p>
                        </div>
                     </div>
                  </li>
                  <li>
                     <div class="comment-body">
                        <div class="avatar-img"><img src="images/blog/avatar2.png" alt="" class="avatar pic2"/></div>
                        <cite class="fn"><a href="#">Patrick Roger</a></cite><br/>
                        <span class="tdate">October 22, 2012 8:45 am</span> &nbsp;/&nbsp; <span class="reply"><a href="#" class="more">Reply</a></span>
                        <div class="commenttext">
                           <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
                        </div>
                     </div>
                     <ol>
                        <li>
                           <div class="com-line"></div>
                           <div class="comment-body">
                              <div class="avatar-img"><img src="images/blog/avatar1.png" alt="" class="avatar pic2"/></div>
                              <cite class="fn"><a href="#">Jane Snow</a></cite><br/>
                              <span class="tdate">October 20, 2012 8:45 am</span> &nbsp;/&nbsp; <span class="reply"><a href="#" class="more">Reply</a></span>
                              <div class="commenttext">
                                 <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
                              </div>
                           </div>
                        </li>
                     </ol>
                  </li>
                  <li>
                     <div class="comment-body">
                        <div class="avatar-img"><img src="images/blog/avatar2.png" alt="" class="avatar pic2"/></div>
                        <cite class="fn"><a href="#">John Doe</a></cite><br/>
                        <span class="tdate">October 18, 2012 8:45 am</span> &nbsp;/&nbsp; <span class="reply"><a href="#" class="more">Reply</a></span>
                        <div class="commenttext">
                           <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
                        </div>
                     </div>
                  </li>
               </ol>
               <div class="heading_line">
                  <h3 class="color_black font_heading ucase"><span>Leave Comment</span></h3>
               </div>
               <form id="contact-form">
                  <div class="success">Contact form submitted!<br>
                     <strong>We will be in touch soon.</strong> 
                  </div>
                  <fieldset>
                     <label class="name">
                     <input type="text" value="Name:">
                     <span class="error">*This is not a valid name.</span> <span class="empty">*This field is required.</span> </label>
                     <label class="email">
                     <input type="text" value="E-mail:">
                     <span class="error">*This is not a valid email address.</span> <span class="empty">*This field is required.</span> </label>
                     <label class="message">
                     <textarea>Message:</textarea>
                     <span class="error">*The message is too short.</span> <span class="empty">*This field is required.</span> </label>
                     <div class="buttons2"> <a href="#" data-type="reset" class="button orange">Clear</a><a href="#" data-type="submit" class="button orange">Submit</a> </div>
                  </fieldset>
               </form>
            </section>
         </article>
         <article class="grid_4 last-col">
            <aside id="sidebar">
               <ul>
                  <li class="widget-container">
                     <ul class="tabs-nav">
                        <li class="active"><a href="#tab1" class="ucase">Recent Post</a></li>
                        <li><a href="#tab2" class="ucase">Popular Post</a></li>
                     </ul>
                     <!-- end .tabs-nav -->
                     <div class="tabs-container" style="margin-top:-27px;">
                        <div class="tab-content" id="tab1">
                           <ul class="rp-widget">
                              <li>
                                 <img src="http://placehold.it/60x60" alt="" class="f_left15 pic2"/>
                                 <p><a href="#" class="more_gray">vero eos et accusamus et iusto odio dignissimos.</a></p>
                                 <span class="smalldate">October 18, 2012</span> 
                              </li>
                              <li>
                                 <img src="http://placehold.it/60x60" alt="" class="f_left15 pic2" />
                                 <p><a href="#" class="more_gray">vero eos et accusamus et iusto odio dignissimos.</a></p>
                                 <span class="smalldate">October 16, 2012</span> 
                              </li>
                              <li>
                                 <img src="http://placehold.it/60x60" alt="" class="f_left15 pic2" />
                                 <p><a href="#" class="more_gray">vero eos et accusamus et iusto odio dignissimos.</a></p>
                                 <span class="smalldate">October 14, 2012</span> 
                              </li>
                           </ul>
                        </div>
                        <!-- end #tab1 -->
                        <div class="tab-content" id="tab2">
                           <ul class="rp-widget">
                              <li>
                                 <img src="http://placehold.it/60x60" alt="" class="f_left15 pic2"/>
                                 <p><a href="#" class="more_gray">quia non numquam eius modi tempora incidunt.</a></p>
                                 <span class="smalldate">October 12, 2012</span> 
                              </li>
                              <li>
                                 <img src="http://placehold.it/60x60" alt="" class="f_left15 pic2" />
                                 <p><a href="#" class="more_gray">quia non numquam eius modi tempora incidunt.</a></p>
                                 <span class="smalldate">October 11, 2012</span> 
                              </li>
                              <li>
                                 <img src="http://placehold.it/60x60" alt="" class="f_left15 pic2" />
                                 <p><a href="#" class="more_gray">quia non numquam eius modi tempora incidunt.</a></p>
                                 <span class="smalldate">October 10, 2012</span> 
                              </li>
                           </ul>
                        </div>
                        <!-- end #tab2 -->
                        <!-- end #tab3 -->
                     </div>
                  </li>
                  <li class="widget-container">
                     <div class="heading_line">
                        <h3 class="color_black font_heading ucase"><span>Tags</span></h3>
                     </div>
                     <div class="tag-cloud"> <a title="Tag link" href="#">Web Design</a> <a title="Tag link" href="#">Graphic</a> <a title="Tag link" href="#">Wordpress</a> <a title="Tag link" href="#">Jquery</a> <a title="Tag link" href="#">HTML</a> <a title="Tag link" href="#">Advertising</a> <a title="Tag link" href="#">Responsive</a> <a title="Tag link" href="#">Branding</a> <a title="Tag link" href="#">Photography</a> </div>
                     <div class="clear"></div>
                  </li>
                  <li class="widget-container">
                     <div class="heading_line">
                        <h3 class="color_black font_heading ucase"><span>Recent Work</span></h3>
                     </div>
                     <ul class="rp-widget">
                        <li>
                           <img src="http://placehold.it/60x60" alt="" class="f_left15 pic2"/>
                           <p><a href="#">vero eos et accusamus et iusto odio dignissimos ducimus.</a></p>
                           <span class="smalldate">October 08, 2012</span> <span class="clear"></span> 
                        </li>
                        <li>
                           <img src="http://placehold.it/60x60" alt="" class="f_left15 pic2" />
                           <p><a href="#">vero eos et accusamus et iusto odio dignissimos ducimus.</a></p>
                           <span class="smalldate">October 07, 2012</span> <span class="clear"></span> 
                        </li>
                        <li>
                           <img src="http://placehold.it/60x60" alt="" class="f_left15 pic2" />
                           <p><a href="#">vero eos et accusamus et iusto odio dignissimos ducimus.</a></p>
                           <span class="smalldate">October 05, 2012</span> <span class="clear"></span> 
                        </li>
                     </ul>
                  </li>
                  <li class="widget-container">
                     <div class="heading_line">
                        <h3 class="color_black font_heading ucase"><span>Categories</span></h3>
                     </div>
                     <ul>
                        <li><a href="#">Clean</a></li>
                        <li><a href="#">Portfolio</a></li>
                        <li><a href="#">General</a></li>
                        <li><a href="#">Video</a></li>
                        <li><a href="#">Typography</a></li>
                     </ul>
                  </li>
                  <li class="widget-container">
                     <div class="heading_line">
                        <h3 class="color_black font_heading ucase"><span>Text Widgets</span></h3>
                     </div>
                     <div class="textwidget">Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae.</div>
                  </li>
               </ul>
            </aside>
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
