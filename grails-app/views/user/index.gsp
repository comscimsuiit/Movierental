<html lang="en">
<head>
	<meta name="layout" content="login"/>
	<meta charset="utf-8">
	<title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Starter files for implementing Twitter Bootstrap's Carousel -- using Bootstrap version 2.0.4">
    <meta name="author" content="David Cochran for webdesign.tutsplus.com">
	<meta name="swift-page-name" id="swift-page-name" content="front">
	
	<style type="text/css">
		body {
			padding-top: 30px;
			padding-bottom: 40px;
			background-color: #ffffff;
		}
	</style>

    <style>

    /* GLOBAL STYLES
    -------------------------------------------------- */
    /* Padding below the footer and lighter body text */

    body {
      padding-bottom: 40px;
      color: #5a5a5a;
    }


    /* CUSTOMIZE THE CAROUSEL
    -------------------------------------------------- */

    /* Carousel base class */
    .carousel {
      margin-bottom: 60px;
    }

    .carousel .container {
      position: relative;
      z-index: 9;
    }

    .carousel-control {
      height: 80px;
      margin-top: 0;
      font-size: 120px;
      text-shadow: 0 1px 1px rgba(0,0,0,.4);
      background-color: transparent;
      border: 0;
      z-index: 10;
    }

    .carousel .item {
      height: 445px;
    }
    .carousel img {
      position: absolute;
      top: 0;
      left: ;
      min-width: 100%;
      height: 500px;
    }

    .carousel-caption {
      background-color: transparent;
      position: static;
      max-width: 550px;
      padding: 0 20px;
      margin-top: 200px;
    }
    .carousel-caption h1,
    .carousel-caption .lead {
      margin: 0;
      line-height: 1.25;
      color: #fff;
      text-shadow: 0 1px 1px rgba(0,0,0,.4);
    }
    .carousel-caption .btn {
      margin-top: 10px;
    }

    /* Featurettes
    ------------------------- */

    .featurette-divider {
      margin: 80px 0; /* Space out the Bootstrap <hr> more */
    }
    .featurette {
      padding-top: 1500px; /* Vertically center images part 1: add padding above and below text. */
      overflow: hidden; /* Vertically center images part 2: clear their floats. */
    }
    .featurette-image {
      margin-top: -120px; /* Vertically center images part 3: negative margin up the image the same amount of the padding to center it. */
    }

    /* Give some space on the sides of the floated elements so text doesn't run right into it. */
    .featurette-image.pull-left {
      margin-right: 40px;
    }
    .featurette-image.pull-right {
      margin-left: 40px;
    }

    /* Thin out the marketing headings */
    .featurette-heading {
      font-size: 50px;
      font-weight: 300;
      line-height: 1;
      letter-spacing: -1px;
    }



    /* RESPONSIVE CSS
    -------------------------------------------------- */

    @media (max-width: 979px) {

      .container.navbar-wrapper {
        margin-bottom: 0;
        width: auto;
      }
      .navbar-inner {
        border-radius: 0;
        margin: -20px 0;
      }

      .carousel .item {
        height: 500px;
      }
      .carousel img {
        width: auto;
        height: 500px;
      }

      .featurette {
        height: auto;
        padding: 0;
      }
      .featurette-image.pull-left,
      .featurette-image.pull-right {
        display: block;
        float: none;
        max-width: 40%;
        margin: 0 auto 20px;
      }
    }


    @media (max-width: 767px) {

      .navbar-inner {
        margin: -20px;
      }

      .carousel {
        margin-left: -20px;
        margin-right: -20px;
      }
      .carousel .container {

      }
      .carousel .item {
        height: 300px;
      }
      .carousel img {
        height: 300px;
      }
      .carousel-caption {
        width: 65%;
        padding: 0 70px;
        margin-top: 100px;
      }
      .carousel-caption h1 {
        font-size: 30px;
      }
      .carousel-caption .lead,
      .carousel-caption .btn {
        font-size: 18px;
      }

      .marketing .span4 + .span4 {
        margin-top: 40px;
      }

      .featurette-heading {
        font-size: 30px;
      }
      .featurette .lead {
        font-size: 18px;
        line-height: 1.5;
      }
    }
    </style>
	
</head>
<body>
	
	<div id="myCarousel" class="carousel slide">
      <div class="carousel-inner">
        <div class="item active">
          <img src="images/img/ironman3.jpg" alt="">
          <div class="container">
            <div class="carousel-caption">
            </div>
          </div>
        </div>
        <div class="item">
          <img src="images/img/jackslayer.jpg" alt="">
          <div class="container">
            <div class="carousel-caption">
            </div>
          </div>
        </div>
        <div class="item">
          <img src="images/img/oz.jpg" alt="">
          <div class="container">
            <div class="carousel-caption">
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
      <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
    </div><!-- /.carousel -->
	
	<g:if test="${flash.message }">
		<%--<div class="message">
			${flash.message}
		</div>--%>
	</g:if>
	<g:if test="${session.user }">
		<br/>
		Login as : ${session.user } | <g:link action="logout">Logout</g:link>
	</g:if>
	<g:else>
		<div class="container">
		 <div id="example" class="modal hide fade in" style="display: none; ">
        	<div class="modal-header">
            	<a class="close icon-remove" data-dismiss="modal"></a>
				<h3>Please Login</h3>
            </div>
            <div class="modal-body">
            	<g:form controller="user" action="login">
					<center>
					<input type="text" name="user_name" value="${user_name}" placeholder="Username"/><br/>
					<input type="password" name="password" value="${password}" placeholder="Password"/><br/>
					<input type="submit" class="btn btn-primary btn-default" value="Login"/>
					</center>
				</g:form>		        
            </div>
            <div class="modal-footer">
              	<%--<a href="#" class="btn btn-success">Confirm</a>--%>
            	<a href="#" class="btn" data-dismiss="modal">Close</a>
            </div>
         </div>
		</div>
			<center><a data-toggle="modal" href="#example" class="btn btn-success btn-large">Login</a></center>
		
		<%--<g:form controller="user" action="login" style="padding-left:450px">
		<h1>Please sign-in</h1>
		<div id="main" style="width:100px">
		<script type="text/javascript" src="js/contact-form.js"></script>
		<div class="forms">
			<input type="text" name="user_name" value="${user_name}" placeholder="Username"/>
			<input type="password" name="password" value="${password}" placeholder="Password"/>
			<input type="submit" class="btn btn-primary btn-default" value="Login"/>
		</div>
		</div>
		</g:form>--%>
	</g:else>
	
	<script src="js/bootstrap-carousel.js"></script>
    <script>
      !function ($) {
        $(function(){
          $('#myCarousel').carousel()
        })
      }(window.jQuery)
    </script>
	<script>
      $(document).ready(function(){
        $('#myCarousel').carousel({
          interval: 20
        });
      });
    </script>
	
</body>
</html>