package util;

import java.util.List;

public class Artist {
    private String name;
    private String origin;
    private List<String> members;

    public Artist() {
    }

    public Artist(String name, String origin, List<String> members) {
        super();
        this.name = name;
        this.origin = origin;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}