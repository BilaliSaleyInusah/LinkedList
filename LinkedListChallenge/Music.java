import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Music {
    // private Song currentSong;
    // private String playlistName;
    private ArrayList<Album> albumList;
    private LinkedList<Song> playlist;

    
    

    public Music(){
        // this.name = name;
        this.albumList = new ArrayList<Album>();
        this.playlist = new LinkedList<Song>();
    }
    
    // public String getName() {
    //     return name;
    // }


    public LinkedList<Song> getPlaylist() {
        return playlist;
    }
    
    public ArrayList<Album> getAlbumList() {
        return albumList;
    }

    public boolean next(){
        ListIterator<Song> i = playlist.listIterator();
        if(i.hasNext()) {
            System.out.println(i.next().getTitle());
        }
        return true;
    }

    public boolean addAlbum(String albumName){
        Album existingAlbum = findAlbum(albumName);
        if (existingAlbum == null) {
            albumList.add(new Album(albumName));
            return true;
        }
        System.out.println("The album already exist");
        return false;
    }

    public boolean removeAlbum(String albumName){
        Album existingAlbum = findAlbum(albumName);
        if (existingAlbum != null) {
            int position = albumList.indexOf(existingAlbum);
            albumList.remove(position);
            return true;
        }
        System.out.println("The album is not found");
        return false;
    }

    public boolean addSong(String albumName , String title , String duration){
        Album existingAlbum = findAlbum(albumName);
        if (existingAlbum != null) {
            existingAlbum.addSong(title, duration);
            return true;
        }
        System.out.println("The album is not found");
        return false;
    }

    public boolean removeSong(String albumName , String title){
        Album existingAlbum = findAlbum(albumName);
        if (existingAlbum != null) {
            existingAlbum.removeSong(title);
            removeSongFromPlaylist(title);
            return true;
        }
        System.out.println("The album is not found");
        return false;
    }

    public boolean removeSongFromPlaylist(String title){
        int found = findSongInPlaylist(title);
        if (found >= 0) {
            playlist.remove(found);
            return true;
        }
        return false;
    }

    public boolean printAlbums(){
        int size = albumList.size();
        System.out.println("You have " + size + " albums" );
        for (int i = 0; i < size; i++) {
            System.out.println("[ " + (i+1) + " ] " + albumList.get(i).getName());
            int innerSize = albumList.get(i).getSongList().size();
            System.out.println("You have " + innerSize + " songs in this album");
            for (int j = 0; j < innerSize; j++) {
                Song songs = albumList.get(i).getSongList().get(j);
                System.out.println("\t [ "  + (j+1) + " ] Title : " + songs.getTitle() + 
                                                         " Duratio : " + songs.getDuration() );
            }
            
        }
        return true;
    }

    public boolean printSongs(String albumName ){
        Album existingAlbum = findAlbum(albumName);
        if (existingAlbum != null) {
            System.out.println("The album : " + existingAlbum.getName());
            int size = existingAlbum.getSongList().size();
            for (int i = 0; i < size; i++) {
                Song song = existingAlbum.getSongList().get(i);
                System.out.println("| " + (i+1) + " | " + "TItle : " + song.getTitle() + 
                                                            "\n\t Duration : " + song.getDuration());
            }
            
        }
        return true;
    }    

    private Album findAlbum(String albumName){
        for (int i = 0; i < albumList.size(); i++) {
            Album existingAlbum = albumList.get(i);
            if (existingAlbum.getName().toLowerCase().equals(albumName.toLowerCase())) {
                return existingAlbum;
            }
        }
        return null;
    }

    private int  findSongInPlaylist(String title){
       int size = playlist.size();
       for (int i = 0; i < size; i++) {
           if (playlist.get(i).getTitle().toLowerCase().equals(title.toLowerCase())) {
               return i;
           }
       }
       return -1;
    }

    public boolean addToPlaylist(String title){
        int size = getAlbumList().size();
        for (int i = 0; i < size; i++) {
            int innerSize = getAlbumList().get(i).getSongList().size();
            for (int j = 0; j < innerSize; j++) {
                Song existingSong = getAlbumList().get(i).getSongList().get(j);
                String existingTitle = existingSong.getTitle();
                if (existingTitle.toLowerCase().equals(title.toLowerCase()) ) {
                    Iterator<Song> list = playlist.iterator();
                    
                    while (list.hasNext()) {
                        if (list.next().getTitle().equals(title)) {
                            System.out.println("The song alredy exist");
                            return false;
                        }
                    }
                    playlist.add(existingSong);
                    return true;
                }
            }
        } 
        return false;
    }
}
