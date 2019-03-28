package entity;

import java.util.Objects;

public class UserHasMovie {
    private int userId;
    private int movieId;
    private boolean isWatched;

    public UserHasMovie() {
    }

    public UserHasMovie(int userId, int movieId) {
        this.userId = userId;
        this.movieId = movieId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public boolean isWatched() {
        return isWatched;
    }

    public void setWatched(boolean watched) {
        isWatched = watched;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserHasMovie that = (UserHasMovie) o;
        return userId == that.userId &&
                movieId == that.movieId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, movieId);
    }

    @Override
    public String toString() {
        return "UserHasMovie{" +
                "userId=" + userId +
                ", movieId=" + movieId +
                '}';
    }
}
