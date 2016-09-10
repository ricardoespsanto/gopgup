package net.ddns.dustriel.model.movie;

/**
 * The result of searching for a movie will fill in the details in this pojo. This class aims to hold basic movie
 * details that have been curated to focus only on the most interesting and common references for a movie.
 */
public class MovieSearchResult {

    private String director;

    private String title;

    private String date;

    public MovieSearchResult(String director, String title, String date) {
        this.director = director;
        this.title = title;
        this.date = date;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
