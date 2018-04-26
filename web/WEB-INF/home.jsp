<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
Template Name: Ost Magazine
Author: <a href="http://www.os-templates.com/">OS Templates</a>
Author URI: http://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: http://www.os-templates.com/template-terms
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>IB_Bookstore</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="resources/styles/layout.css" type="text/css" />
<script type="text/javascript" src="resources/scripts/jquery.min.js"></script>
<script type="text/javascript" src="resources/scripts/jquery.cycle.min.js"></script>
<script type="text/javascript">
$(function() {
    $('#featured_slide').after('<div id="fsn"><ul id="fs_pagination">').cycle({
        timeout: 5000,
        fx: 'fade',
        pager: '#fs_pagination',
        pause: 1,
        pauseOnPagerHover: 0
    });
});
</script>
</head>
 <% session.setAttribute("username", "sunny"); %>
<% session.setAttribute("userrole", "customer"); %>
<body id="top">
<div class="wrapper col1">
  <div id="header">
    <div id="topnav">
      <ul>       
          <%if(session.getAttribute("username")!=null ){%>         
            <li class="last"><a href="logout">Logout</a>
            <%}else{%>
           <li class="last"><a href="login">Login</a>
            <%}%>
            
        <%if(session.getAttribute("username")!=null ){%>  
        <%if(session.getAttribute("userrole")=="customer" ){%> 
        <li><a href="#"> Member area</a>
          <ul>
            <li><a href="#"> Request for refund</a></li>
            <li><a href="#"> Account information</a></li>
          </ul>
        </li>
        <%}%>
        <%if(session.getAttribute("userrole")=="admin" ){%> 
        <li><a href="#"> Adminstration </a>
          <ul>
            <li><a href="#">Book Management</a></li>
            <li><a href="#">Authorize refund request</a></li>
          </ul>
        </li>
        <%}%>
         
        <li><a href="pages/full-width.html"> Purchase book </a>
            <%}%>
        <li><a href="pages/style-demo.html">Browse a book</a>
        <li class="active"><a href="index.html">Homepage</a>
      </ul>
    </div>
    <div id="logo">
      <h1><a href="index.html"><strong>O</strong>p <strong>B</strong>ookStore</a></h1>
    </div>
    <br class="clear" />
  </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col2">
  <div id="featured_slide">
    <div class="featured_box">
    

      <img src="images/demo/930x375.gif" alt="" /> </div>
    <div class="featured_box">
      <
      <img src="images/demo/930x375.gif" alt="" /> </div>
    <div class="featured_box">
      
      <img src="images/demo/930x375.gif" alt="" /> </div>
    <div class="featured_box">
      
      <img src="images/demo/930x375.gif" alt="" /> </div>
    <div class="featured_box">
      
      <img src="images/demo/930x375.gif" alt="" /> </div>
  </div>
</div>
<!-- ####################################################################################################### -->
<div class="wrapper col3">
  <div class="container">
    <div class="content">
      <div id="topstory">
        <h2> Sales </h2>
        <ul>
          <li><img src="images/demo/190x130.gif" alt="" />
            <p> Bookdetails</p>
            <p> Bookdetails</p>
            <p class="readmore"><a href="#">More details &raquo;</a></p>
          </li>
          <li><img src="images/demo/190x130.gif" alt="" />
            <p>Bookdetails</p>
            <p>Bookdetails</p>
            <p class="readmore"><a href="#">More details &raquo;</a></p>
          </li>
          <li class="last"><img src="images/demo/190x130.gif" alt="" />
            <p>Bookdetails</p>
            <p>Bookdetails</p>
            <p class="readmore"><a href="#">More details &raquo;</a></p>
          </li>
        </ul>
        <br class="clear" />
      </div>
      <div id="latestnews">
        <h2>Featuring Books</h2>
        <ul>
          <li>
            <div class="imgholder"><img src="images/demo/imgl.gif" alt="" /></div>
            <div class="latestnews">
              <h2>About This Book !</h2>
              <p>bookdetails</a>.</p>
              <p class="readmore"><a href="#">More details  &raquo;</a></p>
            </div>
            <br class="clear" />
          </li>
          <li class="last">
            <div class="imgholder"><img src="images/demo/imgl.gif" alt="" /></div>
            <div class="latestnews">
              <h2>About This Book !</h2>
              <p> bookdetails</p>
              <p class="readmore"><a href="#">More details &raquo;</a></p>
            </div>
            <br class="clear" />
          </li>
        </ul>
      </div>
    </div>
    <div class="column">
      <div class="sponsors">
        <h2>Top ranking</h2>
        <div class="b_250"><a href="#"><img src="images/demo/250x250.gif" alt="" /></a></div>
        <div class="b_125">
          
          <div class="clear"></div>
        </div>
      </div>
    </div>
    <br class="clear" />
  </div>
</div>
</div>
</body>
</html>