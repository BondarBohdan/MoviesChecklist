package entity;

import java.util.Objects;

public class Movie {
    private int id;
    private String name;
    private String posterUrl;
    private String description;

    public Movie() {
    }

    public Movie(String name, String posterUrl, String description) {
        this.name = name;
        this.posterUrl = posterUrl;
        this.description = description;
    }

    public Movie(int id, String name, String poster_url, String description) {
        this.id = id;
        this.name = name;
        this.posterUrl = poster_url;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String poster_url) {
        this.posterUrl = poster_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
                Objects.equals(name, movie.name) &&
                Objects.equals(posterUrl, movie.posterUrl) &&
                Objects.equals(description, movie.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, posterUrl, description);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", poster_url='" + posterUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
