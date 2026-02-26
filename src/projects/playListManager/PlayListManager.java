package projects.playListManager;
/*
6. **Library of Music / Playlist Manager** 🎵

    * Classes: `Song`, `Playlist`, `Artist`.
    * A `Playlist` **HAS-A List<Song>`.
    * Use `List<String>`. check if the List contains a song before adding.
    * Features: add/remove songs, shuffle playlist.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayListManager {
    public static void main(String[] args) {
        Artist cloco = new Artist("Claude François");
        Artist ritaM = new Artist("Les Rita Mitsouko");
        Artist gb = new Artist("Les Garçons Boucher");
        Artist giveon = new Artist("Giveon");
        Artist brentFaiyaz = new Artist("Brent Faiyaz");
        Artist partynextdoor = new Artist("PARTYNEXTDOOR");
        Artist dvsn = new Artist("dvsn");
        Artist theWeeknd = new Artist("The Weeknd");
        PlayList french = new PlayList("French",
                new Song[]{
                        new Song("Alexandrie Alexandra",cloco),
                        new Song("Marcia Bailey",ritaM),
                        new Song("Dans la salle du bar tabac de la rue des Martyrs" ,gb),
                        new Song("Les amours finissent mal en général",ritaM),
                }
        );
        french.printPlayList();
        PlayList newSoul = new PlayList("New Soul",
                new Song[]{
                        new Song("Heartbreak Anniversary", giveon),
                        new Song("Dead Man Walking", brentFaiyaz),
                        new Song("Come and See Me" , partynextdoor),
                        new Song("Hallucinations", dvsn),
                        new Song("Blinding Lights", theWeeknd),
                        new Song("Too Deep" , dvsn),
                        new Song("Like I Want You", giveon),
                }
                );
        newSoul.printPlayList();
        newSoul.addSong(new Song("Break From Toronto" , partynextdoor));
        newSoul.addSong(new Song("Heartbreak Anniversary", giveon));
        newSoul.printPlayList();
    }
}
// Class Song.
class Song{
    private String title;
    private Artist artist;
    public Song(String title, Artist artist){
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }
}
// Class Artist.
class Artist{
    private String name;
    public Artist(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Class PlayList.
class PlayList {
    private final List<Song> songs;
    private final String name;

    public PlayList(String name, Song[] song) {
        this.name = name;
        songs = new ArrayList<>();
        songs.addAll(Arrays.asList(song));
    }

    public void printPlayList() {
        this.songs.forEach(song -> {

        });
        int index = 1;
        System.out.println("PlayList " + this.getName());
        for (Song song : songs) {
            System.out.println(index + ". " + song.getTitle() + " by " + song.getArtist().getName());
            index++;
        }
    }

    public String getName() {
        return this.name;
    }

    public void addSong(Song song) {
        if(!isDupplicate(song)){
            System.out.println(song.getTitle() + " added to " + this.getName());
            this.songs.add(song);
        }
    }

    private boolean isDupplicate(Song song) {
        for (Song s : this.songs) {
            if (s.getTitle().contentEquals(song.getTitle()) && s.getArtist().getName().contentEquals(song.getArtist().getName())) {
                System.out.println("Dupplicate");
                return true;
            }

        }

        return false;
    }
}