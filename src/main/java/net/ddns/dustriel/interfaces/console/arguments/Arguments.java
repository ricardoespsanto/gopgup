package net.ddns.dustriel.interfaces.console.arguments;

import com.github.jankroken.commandline.annotations.AllAvailableArguments;
import com.github.jankroken.commandline.annotations.LongSwitch;
import com.github.jankroken.commandline.annotations.Required;
import com.github.jankroken.commandline.annotations.SingleArgument;

/**
 * Validates arguments given to the start of the system
 */
public class Arguments {

    private String api;

    private boolean isAMusicAPI;

    private String movie;

    private String album;

    public String getApi() {
        return api;
    }

    @Required
    @SingleArgument
    @LongSwitch("api")
    public void setApi(String api) {
        this.api = api;
    }

    public String getMovie() {
        return movie;
    }

    @AllAvailableArguments
    @LongSwitch("movie")
    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getAlbum() {
        return album;
    }

    @AllAvailableArguments
    @LongSwitch("album")
    public void setAlbum(String album) {
        this.album = album;
    }

    public boolean isAMusicAPI() {
        return isAMusicAPI;
    }

    public void setAMusicAPI(boolean AMusicAPI) {
        isAMusicAPI = AMusicAPI;
    }
}
