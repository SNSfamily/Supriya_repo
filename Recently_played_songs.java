import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayDeque;
import java.util.Deque;

public class PlaylistTest {

    private Deque<String> playlist;
    private final int initialCapacity = 3;

    public PlaylistTest() {
        playlist = new ArrayDeque<>();
    }

    public void addSong(String song) {
        if (playlist.size() >= initialCapacity) {
            playlist.removeFirst();
        }
        playlist.addLast(song);
    }

    public void printPlaylist() {
        System.out.println(playlist);
    }

    @Test
    public void testPlaylist() {
        // Initial playlist: []
        printPlaylist();
        Assert.assertEquals(playlist.size(), 0);

        // Add S1
        addSong("S1");
        // Playlist: [S1]
        printPlaylist();
        Assert.assertEquals(playlist.size(), 1);
        Assert.assertEquals(playlist.peekLast(), "S1");

        // Add S2
        addSong("S2");
        // Playlist: [S1, S2]
        printPlaylist();
        Assert.assertEquals(playlist.size(), 2);
        Assert.assertEquals(playlist.peekLast(), "S2");

        // Add S3
        addSong("S3");
        // Playlist: [S1, S2, S3]
        printPlaylist();
        Assert.assertEquals(playlist.size(), 3);
        Assert.assertEquals(playlist.peekLast(), "S3");

        // Add S4
        addSong("S4");
        // Playlist: [S2, S3, S4]
        printPlaylist();
        Assert.assertEquals(playlist.size(), 3);
        Assert.assertEquals(playlist.peekLast(), "S4");

        // Play S2
        addSong("S2");
        // Playlist: [S3, S4, S2]
        printPlaylist();
        Assert.assertEquals(playlist.size(), 3);
        Assert.assertEquals(playlist.peekLast(), "S2");

        // Play S1
        addSong("S1");
        // Playlist: [S4, S2, S1]
        printPlaylist();
        Assert.assertEquals(playlist.size(), 3);
        Assert.assertEquals(playlist.peekLast(), "S1");
    }

    public static void main(String[] args) {
        PlaylistTest playlistTest = new PlaylistTest();
        playlistTest.testPlaylist();
    }
}