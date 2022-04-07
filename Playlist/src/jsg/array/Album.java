package jsg.array;

import java.util.ArrayList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> tracklist;

    public Album(String name, String artist, ArrayList<Song> tracklist) {
        this.name = name;
        this.artist = artist;
        this.tracklist = tracklist;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Song> getTracklist() {
        return tracklist;
    }

    public Song findSong (String title) {
        for (Song currentSong : this.tracklist) {
            if (currentSong.getTitle().equals(title)) {
                return currentSong;
            }
        }
        System.out.println("Song not found.");
        return null;
    }
}
