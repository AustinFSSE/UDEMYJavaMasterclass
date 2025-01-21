import java.util.ArrayList;
import java.util.LinkedList;



public class Album {
    private String name, artist;
    private ArrayList <Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public boolean addSong(String title, double duration) {

        if (songs.isEmpty()) {
            songs.add(new Song(title, duration));
            return true;
        }
        Song existingSong = findSong(title);
        if (existingSong != null && existingSong.getTitle().equals(title)) {
            System.out.println("Song already exists " + songs.toString());
            return false;
        }
        songs.add(new Song(title, duration));
        return true;

    }
    private Song findSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }
    public boolean addToPlayList(int number, LinkedList <Song> playlist) {
        int index = number - 1; // number represents the track number so we need to subtract one to convert number to index notation
        if ((index >= 0) && (index <= songs.size())) {
            playlist.add(songs.get(index));
            return true;
        }
        return false;
    }
    public boolean addToPlayList(String title, LinkedList <Song> playlist) {
        Song existingSong = findSong(title);
        if (songs.contains(existingSong) && existingSong != null) {
            playlist.add(existingSong);
            return true;
        }
        return false;
    }
}
