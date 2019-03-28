<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

<body class="body">
<c:set var="movies" value="${movies}"/>
<c:set var="totalCount" value="${movies.size()}"/>
<c:set var="perPage" value="${5}"/>
<c:set var="pageStart" value="${param.start}"/>
<c:if test="${empty pageStart or pageStart < 0}">
    <c:set var="pageStart" value="0"/>
</c:if>
<c:if test="${totalCount < pageStart}">
    <c:set var="pageStart" value="${pageStart - perPage}"/>
</c:if>

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
    <li class="active"><a href="${ServletURL.MY_MOVIES.getUrl()}" data-bs-hover-animate="pulse">My Movies</a></li>
    <li><a href="${ServletURL.LIBRARY.getUrl()}" data-bs-hover-animate="pulse">Library</a></li>
    <li><a href="${ServletURL.SETTINGS.getUrl()}" data-bs-hover-animate="pulse"><c:out value="${settingsText}"/></a>
    </li>
    <li><a href="${ServletURL.LOG_OUT.getUrl()}" data-bs-hover-animate="pulse"><c:out value="${logText}"/></a></li>
</ul>

<c:forEach var="movie" items="${movies}" begin="${pageStart}" end="${pageStart + perPage - 1}">
    <div class="container post">
        <div class="row">
            <div class="col-md-6 post-title ${movie.isWatched() ? 'line-through' : ''}" style="height:450px;">
                <h1><c:out value="${movie.getName()}"/></h1><img class="img-thumbnail"
                                                                 src="<c:out value="${movie.getPosterUrl()}"/>"></div>
            <div class="col-md-6 col-md-offset-0 post-body" style="height:420px;">
                <br>
                <br>
                <p><c:out value="${movie.getDescription()}"/></p>
                <figure></figure>
                <button class="btn btn-default" type="button" data-bs-hover-animate="pulse"
                        onclick="location.href = '${ServletURL.REMOVE.getUrl()}?id=${movie.getId()}&start=${pageStart}';"
                        style="margin:0px;">REMOVE
                </button>
                <button class="btn btn-default" type="button" data-bs-hover-animate="pulse"
                        onclick="location.href = '${ServletURL.SET_WATCHED.getUrl()}?id=${movie.getId()}&start=${pageStart}&isWatched=${movie.isWatched()}';"
                        style="margin:0px;">WATCHED
                </button>
            </div>
        </div>
    </div>
    <hr>
</c:forEach>

<div class="row nav nav-pills categories">
    <div class="col-md-12">
        <nav>
            <ul class="pagination">
                <li><a aria-label="Previous" href="?start=${pageStart - perPage}"><span
                        aria-hidden="true"><< Previous</span></a></li>
                <li><span>${pageStart + 1} - ${pageStart + perPage}</span></li>
                <li><a aria-label="Next" href="?start=${pageStart + perPage}"><span
                        aria-hidden="true">Next >></span></a></li>
            </ul>
        </nav>
    </div>
</div>

<footer>
    <h5>Bohdan Bondar © 2019</h5>
</footer>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/bs-animation.js"></script>
</body>
</html>