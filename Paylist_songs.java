import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<String> songs;
    private int capacity;

    public Playlist(int capacity) {
        this.songs = new ArrayList<>();
        this.capacity = capacity;
    }

//add songs to the playlist
    public void playSong(String song) {
        if (songs.contains(song)) {
            songs.remove(song);
        } else if (songs.size() >= capacity) {
            songs.remove(0);
        }
        songs.add(song);
    }

    public List<String> getPlaylist() {
        return songs;
    }

    public static void main(String[] args) {
        Playlist playlist = new Playlist(3);
        playlist.playSong("S1");
        playlist.playSong("S2");
        playlist.playSong("S3");
        System.out.println("Playlist after playing S1, S2, and S3: " + playlist.getPlaylist());

//get recently played songs for a user after S4 played
        playlist.playSong("S4");
        System.out.println("Playlist after playing S4: " + playlist.getPlaylist());

//get recently played songs for a user after S2 played
        playlist.playSong("S2");
        System.out.println("Playlist after playing S2: " + playlist.getPlaylist());
        
//get recently played songs for a user after S1 played
        playlist.playSong("S1");
        System.out.println("Playlist after playing S1: " + playlist.getPlaylist());
    }
}
