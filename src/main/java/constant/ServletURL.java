package constant;

public enum ServletURL {

    ADD_TO_MY_MOVIES("/MoviesChecklistEE_war_exploded/addToMyMovies"),
    LIBRARY("/MoviesChecklistEE_war_exploded/library"),
    LOG_IN("/MoviesChecklistEE_war_exploded/login"),
    LOG_OUT("/MoviesChecklistEE_war_exploded/logout"),
    MY_MOVIES("/MoviesChecklistEE_war_exploded/myMovies"),
    REGISTER("/MoviesChecklistEE_war_exploded/register"),
    REMOVE("/MoviesChecklistEE_war_exploded/remove"),
    ADD_NEW_MOVIE("/MoviesChecklistEE_war_exploded/addNewMovie"),
    DELETE("/MoviesChecklistEE_war_exploded/deleteMovie"),
    EDIT_MOVIE("/MoviesChecklistEE_war_exploded/editMovie"),
    SET_WATCHED("/MoviesChecklistEE_war_exploded/setWatched"),
    SETTINGS("/MoviesChecklistEE_war_exploded/settings");

    private String url;

    ServletURL(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
