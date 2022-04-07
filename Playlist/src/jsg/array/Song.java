package jsg.array;

public class Song {
    private String title;
    private double duration; //could be converted

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

}
