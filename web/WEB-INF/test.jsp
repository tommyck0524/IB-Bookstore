<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
        <div class="row">
        <title>CinemaLine - Main Page</title>
        <jsp:include page="header.jsp" />


    <div class="jumbotron">
        <div class="container">
            <h1>
                <spring:if test="${loggedInUser == null}">
                    Welcome to CinemaLine, Guest!
                </spring:if>
                <spring:if test="${loggedInUser != null}">
                    Welcome back, ${loggedInUser.name}!
                </spring:if>
            </h1>
        </div>
    </div>


    <div class="container">
        <div class="alert alert-danger bs-alert-old-docs">
            <strong>Caution: This web site exists to fulfill the coursework requirement of CS4280. Do not use your real personal data as input!</strong>
        </div>
        <spring:if test="${msg != null}">
            <div class="alert alert-success fade in">
                <strong>${msg}</strong>
            </div>
        </spring:if>
        <!-- Example row of columns -->
        <div class="row">
            <div class="col-md-4">
                <div class="row">
                    <h2>batman v sperman</h2>
                </div>
                <div class="row">
                    <img src="<spring:url value="/resources/image/movie_1.jpg" />" class="img-thumbnail" />
                </div>
                <div class="row" align="justify">
                    <p>Following his titanic struggle against General Zod, Metropolis has been razed to the ground and Superman is the most controversial figure in the world. While for many he is still an emblem of hope, a growing number of people consider him a threat to humanity, seeking justice for the chaos he has brought to Earth.</p>
                </div>
                <div class="row">
                    <p><a class="btn btn-default" href="browseDetail" role="button">View details &raquo;</a></p>
                </div>
            </div>
            <div class="col-md-4">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div>
            <div class="col-md-4">
                <h2>Heading</h2>
                <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <div class="row">
                    <h2>batman v sperman</h2>
                </div>
                <div class="row">
                    <img src="<spring:url value="/resources/image/movie_1.jpg" />" class="img-thumbnail" />
                </div>
                <div class="row" align="justify">
                    <p>Following his titanic struggle against General Zod, Metropolis has been razed to the ground and Superman is the most controversial figure in the world. While for many he is still an emblem of hope, a growing number of people consider him a threat to humanity, seeking justice for the chaos he has brought to Earth.</p>
                </div>
                <div class="row">
                    <p><a class="btn btn-default" href="browseDetail" role="button">View details &raquo;</a></p>
                </div>
            </div>
            <div class="col-md-4">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div>
            <div class="col-md-4">
                <h2>Heading</h2>
                <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <div class="row">
                    <h2>batman v sperman</h2>
                </div>
                <div class="row">
                    <img src="<spring:url value="/resources/image/movie_1.jpg" />" class="img-thumbnail" />
                </div>
                <div class="row" align="justify">
                    <p>Following his titanic struggle against General Zod, Metropolis has been razed to the ground and Superman is the most controversial figure in the world. While for many he is still an emblem of hope, a growing number of people consider him a threat to humanity, seeking justice for the chaos he has brought to Earth.</p>
                </div>
                <div class="row">
                    <p><a class="btn btn-default" href="browseDetail" role="button">View details &raquo;</a></p>
                </div>
            </div>
            <div class="col-md-4">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div>
            <div class="col-md-4">
                <h2>Heading</h2>
                <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div>
        </div>        
    </div>

    <jsp:include page="footer.jsp" />

</body>
</html>
