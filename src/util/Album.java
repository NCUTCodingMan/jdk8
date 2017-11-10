package util;

import java.util.List;

public class Album {
    private List<Track> tracks;
    private String name;
    private List<String> musician;

    public Album(List<Track> tracks, String name, List<String> musician) {
        super();
        this.tracks = tracks;
        this.name = name;
        this.musician = musician;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMusician() {
        return musician;
    }

    public void setMusician(List<String> musician) {
        this.musician = musician;
    }

}
