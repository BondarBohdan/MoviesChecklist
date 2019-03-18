<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <header style="background-image:url(&quot;assets/img/1.jpg&quot;);">
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header"><a class="navbar-brand" href="#"><i class="glyphicon glyphicon-play"></i><span
                        class="text-title">Movies checklist&nbsp;</span></a>
                    <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span
                            class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
                            class="icon-bar"></span><span class="icon-bar"></span></button>
                </div>
                <div
                        class="collapse navbar-collapse" id="navcol-1"></div>
            </div>
        </nav>
    </header>
    <ul class="nav nav-pills categories">
        <li class="active"><a href="/MoviesChecklistEE_war_exploded/mymovies?pageNumber=1" data-bs-hover-animate="pulse">My Movies</a></li>
        <li><a href="/MoviesChecklistEE_war_exploded/library?pageNumber=1" data-bs-hover-animate="pulse">Library</a></li>
        <li><a href="/MoviesChecklistEE_war_exploded/settings" data-bs-hover-animate="pulse">Settigns</a></li>
        <li><a href="/MoviesChecklistEE_war_exploded/logoff" data-bs-hover-animate="pulse">Log off</a></li>
    </ul>
    <c:forEach var="movie" items="${movies}" begin="${start}" end="${stop}">
        <div class="container post">
            <div class="row">
                <div class="col-md-6 post-title" style="height:450px;">
                    <h1><c:out value="${movie.getName()}"/></h1><img class="img-thumbnail"
                                                                     src="<c:out value="${movie.getPosterUrl()}"/>"></div>
                <div class="col-md-6 col-md-offset-0 post-body" style="height:420px;">
                    <br>
                    <br>
                    <p><c:out value="${movie.getDescription()}"/></p>
                    <figure></figure>
                    <button class="btn btn-default" type="button" data-bs-hover-animate="pulse" onclick="location.href = '/MoviesChecklistEE_war_exploded/remove?id=${movie.getId()}';" style="margin:0px;">REMOVE
                    </button>
                </div>
            </div>
        </div>
        <hr>
    </c:forEach>

    <div class="row nav nav-pills categories">
        <%--For displaying Previous link --%>
        <c:if test="${pageNumber gt 1}">
            <a href="library?pageNumber=${pageNumber - 1}">Previous</a>
        </c:if>
        <c:forEach begin="1" end="${numberOfPages}" var="i">
            <c:choose>
                <c:when test="${i!=pageNumber}">
                    <a href="library?pageNumber=<c:out value="${i}"/>"><c:out value="${i}"/></a>
                </c:when>
                <c:otherwise>
                    <c:out value="${i}"/>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <%--For displaying Next link --%>
        <c:if test="${pageNumber lt numberOfPages}">
            <a href="library?pageNumber=${pageNumber + 1}">Next</a>
        </c:if>
    </div>

    <footer>
        <h5>Bohdan Bondar © 2019</h5>
    </footer>

    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/bs-animation.js"></script>
</body>
</html>