package jsg.array;

import java.util.ArrayList;

public class AlbumsCollection {

    private String name;
    private ArrayList<Album> albumsCollection;

    public AlbumsCollection(String name, ArrayList<Album> albumsCollection) {
        this.name = name;
        this.albumsCollection = albumsCollection;
    }

    public Album findAlbum(String albumName) {
        for (Album currentAlbum : this.albumsCollection) {
            if (currentAlbum.getName().equals(albumName)) {
                return currentAlbum;
            }
        }
        System.out.println("Album "+albumName+" not found.");
        return null;
    }

}
