<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="constant.ServletURL" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MoviesChecklist</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700">
    <link rel="stylesheet" href="assets/fonts/ionicons.min.css">
    <link rel="stylesheet" href="assets/css/user.css">
    <link rel="stylesheet" href="assets/css/Contact-Form-Clean.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="assets/css/Login-Form-Dark.css">
</head>

<c:set var="logText" value="Log out"/>
<c:set var="settingsText" value="${sessionScope.userCredentials.getLogin()}"/>
<c:if test="${empty settingsText}">
    <c:set var="settingsText" value="Settings"/>
    <c:set var="logText" value="Log in"/>
</c:if>

<header style="background-image:url(&quot;assets/img/1.jpg&quot;);">
    <nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header"><a class="navbar-brand" href="#"><i class="glyphicon glyphicon-play"
                                                                           style="font-size: 125px"></i><span
                    class="text-title" style="font-size: 35px;">Movies checklist&nbsp;</span></a>
                <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span
                        class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
                        class="icon-bar"></span><span class="icon-bar"></span></button>
            </div>
            <div
                    class="collapse navbar-collapse" id="navcol-1"></div>
        </div>
    </nav>
</header>
<ul class="nav nav-pills categories" style="font-size:25px;">
    <li><a href="${ServletURL.MY_MOVIES.getUrl()}" data-bs-hover-animate="pulse">My Movies</a></li>
    <li class="active"><a href="${ServletURL.LIBRARY.getUrl()}" data-bs-hover-animate="pulse">Library</a></li>
    <li><a href="${ServletURL.SETTINGS.getUrl()}" data-bs-hover-animate="pulse"><c:out value="${settingsText}"/></a>
    </li>
    <li><a href="${ServletURL.LOG_OUT.getUrl()}" data-bs-hover-animate="pulse"><c:out value="${logText}"/></a></li>
</ul>

<div class="contact-clean">
    <form method="post" action="${ServletURL.ADD_NEW_MOVIE.getUrl()}">
        <h2 class="text-center">Add new movie</h2>
        <div class="form-group"><input class="form-control" type="text" name="name" required="" placeholder="Name">
        </div>
        <div class="form-group"><input class="form-control" type="text" name="poster_url" required=""
                                       placeholder="Poster url"></div>
        <div class="form-group"><textarea class="form-control" type="text" name="description" required=""
                                          placeholder="Description"></textarea></div>
        <div class="form-group">
            <button class="btn btn-primary center-block" type="submit">add</button>
        </div>
    </form>
</div>
<footer>
    <h5>Bohdan Bondar © 2019</h5>
</footer>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/bs-animation.js"></script>
</body>

</html>