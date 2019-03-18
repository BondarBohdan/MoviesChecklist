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
                <div class="navbar-header"><a class="navbar-brand" href="#"><i class="glyphicon glyphicon-play"></i><span class="text-title">Movies checklist&nbsp;</span></a><button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button></div>
                <div
                    class="collapse navbar-collapse" id="navcol-1"></div>
            </div>
        </nav>
    </header>
    <ul class="nav nav-pills categories">
        <li><a href="/MoviesChecklistEE_war_exploded/mymovies?pageNumber=1" data-bs-hover-animate="pulse">My Movies</a></li>
        <li><a href="/MoviesChecklistEE_war_exploded/library?pageNumber=1" data-bs-hover-animate="pulse">Library</a></li>
        <li class="active"><a href="/MoviesChecklistEE_war_exploded/settings" data-bs-hover-animate="pulse">Settigns</a></li>
        <li><a href="/MoviesChecklistEE_war_exploded/logoff" data-bs-hover-animate="pulse">Log off</a></li>
    </ul>
    <div class="contact-clean">
        <form method="post" action="/MoviesChecklistEE_war_exploded/settings">
            <h2 class="text-center">User info</h2>
            <div class="form-group"><input class="form-control" type="text" name="name" placeholder="Name" value="${user.getName()}"></div>
            <div class="form-group"><input class="form-control" type="text" name="surname" placeholder="Surname" value="${user.getSurname()}"></div>
            <div class="form-group"><input class="form-control" type="email" name="email" placeholder="Email" pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" value="${user.getEmail()}"></div>
            <div class="form-group"><button class="btn btn-primary center-block" type="submit">UPDATE</button></div>
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