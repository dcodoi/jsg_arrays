package jsg.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    private static AlbumsCollection albumsCollection;
    private static LinkedList<Song> playlist = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean goingForward = true; //handles direction

    public static void main(String[] args) {

        //loads initial data so it doesn't need to be added manually through scanner
        loadMusicData();

        // adds songs to the playlist so they don't have to be added manually through scanner

        addToPlaylist("DiscO-Zone","Fiesta de la noche");
        addToPlaylist("DiscO-Zone","De ce plâng chitarele");
        addToPlaylist("DiscO-Zone","Dragostea Din Tei");
        //addToPlaylist("DiscO-Zone","Printre nori");
        addToPlaylist("DiscO-Zone","Oriunde ai fi");
        //addToPlaylist("DiscO-Zone","Numai tu ");
        addToPlaylist("DiscO-Zone","Dar, unde ești?");
        addToPlaylist("DiscO-Zone","Despre tine");
        //addToPlaylist("DiscO-Zone","Sărbătoarea nopților de vară");
        addToPlaylist("DiscO-Zone","Nu mă las de limba noastră...");
        addToPlaylist("DiscO-Zone","Crede-mă");
       // addToPlaylist("DiscO-Zone","ma ya hi");
        addToPlaylist("A Love Supreme", "Resolution");
        addToPlaylist("Time Out", "Take Five");


        //playlist manipulation
        ListIterator<Song> i = playlist.listIterator();

        boolean quit = false;
        int action;
        printMenu();
        while (!quit) {
            System.out.println("\nEnter your choice: ");
            action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nExiting music player...");
                    quit = true;
                    break;

                case 1:
                    playNext(i);
                    break;

                case 2:
                    playPrevious(i);
                    break;

                case 3:
                    replay(i);
                    break;

                case 4:
                    printPlaylist();
                    break;

                case 5:
                    printMenu();
            }
        }
    }

    private static void playNext(ListIterator<Song> i) {
        if (!goingForward) {
            if(i.hasNext()) {
                i.next();
            }
            goingForward = true;
        }
        if(i.hasNext()) {
            System.out.println("Now playing " + i.next().getTitle());
        } else {
            System.out.println("You are at the end of the list.");
            goingForward = false;
        }
    }

    private static void playPrevious(ListIterator<Song> i) {
        if (goingForward) {
            if(i.hasPrevious()) {
                i.previous();
            }
            goingForward = false;
        }
        if(i.hasPrevious()) {
            System.out.println("Now playing " + i.previous().getTitle());
        } else {
            System.out.println("You are at the beginning of the list.");
            goingForward = true;
        }
    }

    private static void replay(ListIterator<Song> i) {
        if(goingForward) {
            if(i.hasPrevious()) {
                System.out.println("Now playing " + i.previous().getTitle());
                i.next();
            } else {
                System.out.println("You're at the beginning of the list.");
            }
        } else {
            if(i.hasNext()) {
                i.next();
                System.out.println("Now playing " + i.previous().getTitle());
            } else {
                System.out.println("You are at the end of the list.");
            }
        }
    }

    private static void loadMusicData() {
        ArrayList<Song> ozoneTracklist = new ArrayList<>();

        ozoneTracklist.add(new Song("Fiesta de la noche", 4.0));
        ozoneTracklist.add(new Song("De ce plâng chitarele", 4.11));
        ozoneTracklist.add(new Song("Dragostea Din Tei", 3.33));
        ozoneTracklist.add(new Song("Printre nori",3.43));
        ozoneTracklist.add(new Song("Oriunde ai fi", 4.25));
        ozoneTracklist.add(new Song("Numai tu ", 4.0));
        ozoneTracklist.add(new Song("Dar, unde ești?", 4.02));
        ozoneTracklist.add(new Song("Despre tine", 3.50));
        ozoneTracklist.add(new Song("Sărbătoarea nopților de vară", 3.51));
        ozoneTracklist.add(new Song("Nu mă las de limba noastră...", 3.49));
        ozoneTracklist.add(new Song("Crede-mă", 4.44));
        
        ArrayList<Song> aLoveSupremeTracklist = new ArrayList<>();

        aLoveSupremeTracklist.add(new Song("Acknowledgement", 7.8));
        aLoveSupremeTracklist.add(new Song("Resolution", 7.5));
        aLoveSupremeTracklist.add(new Song("Pursuance/Psalm", 17.8));
        ArrayList<Album> albumsList = new ArrayList<>();

        albumsList.add(new Album("DiscO-Zone", "O-Zone", ozoneTracklist));
        albumsList.add(new Album("A Love Supreme", "John Coltrane", aLoveSupremeTracklist));

        albumsCollection = new AlbumsCollection("JSG's collection", albumsList);
    }

    private static void addToPlaylist(String albumName, String songTitle) {
        Album album = albumsCollection.findAlbum(albumName);
        if(album != null) {
            Song song = album.findSong(songTitle);
            if(song != null) {
                playlist.add(song);
                System.out.println("Song " + song.getTitle() + " added to the playlist.");
            }
            else 
            	System.out.println("Song " + songTitle + " not added to the playlist.");
        }
    }

    private static void printPlaylist() {
        ListIterator<Song> i = playlist.listIterator();
        System.out.println("\nCurrently on playlist:");
        if(playlist.size() > 0) {
            while(i.hasNext()) {
                System.out.println(i.next().getTitle());
            }
        } else {
            System.out.println("No songs in playlist.");
        }
        System.out.println(playlist.size()+" songs found in the playlist.");

    }

    private static void printMenu() {
        System.out.println("\nAvailable actions:\npress ");
        System.out.println("0 - exit\n" +
                "1 - skip forward to the next song\n" +
                "2 - skip backwards to the previous song\n" +
                "3 - replay the current song\n" +
                "4 - list the songs in the playlist\n" +
                "5 - show menu on the screen");
    }
}