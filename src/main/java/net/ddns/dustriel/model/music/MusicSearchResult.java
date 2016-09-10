package net.ddns.dustriel.model.music;

/**
 * The result of searching for a music album will fill in the details in this pojo. This class aims to hold basic album
 * data.
 */
public class MusicSearchResult {

    private String band;

    private String releaseDate;

    private String name;

    public MusicSearchResult(String band, String releaseDate, String name) {
        this.band = band;
        this.releaseDate = releaseDate;
        this.name = name;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
