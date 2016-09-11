package net.ddns.dustriel.model.album;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return Objects.toString(name);
    }
}
