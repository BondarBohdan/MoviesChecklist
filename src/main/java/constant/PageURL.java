package constant;

public enum PageURL {

    ADD_MOVIE("/addNewMovie.jsp"),
    LIBRARY("/library.jsp"),
    ADMIN_LIBRARY("/adminLibrary.jsp"),
    LOG_IN("/login.jsp"),
    MY_MOVIES("/myMovies.jsp"),
    REGISTRATION("/registration.jsp"),
    EDIT_MOVIE("/editMovie.jsp"),
    ACCESS_DENIED("/accessDenied.jsp"),
    SETTINGS("/settings.jsp");

    private String url;

    PageURL(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
