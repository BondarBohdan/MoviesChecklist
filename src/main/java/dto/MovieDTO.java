package dto;

public class MovieDTO {
    private int id;
    private String name;
    private String posterUrl;
    private String description;
    private boolean isWatched;

    public MovieDTO() {
    }

    public MovieDTO(String name, String posterUrl, String description) {
        this.name = name;
        this.posterUrl = posterUrl;
        this.description = description;
    }

    public MovieDTO(int id, String name, String poster_url, String description,
                    boolean isWatched) {
        this.id = id;
        this.name = name;
        this.posterUrl = poster_url;
        this.description = description;
        this.isWatched = isWatched;
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

    public boolean isWatched() {
        return isWatched;
    }

    public void setWatched(boolean watched) {
        isWatched = watched;
    }
}
