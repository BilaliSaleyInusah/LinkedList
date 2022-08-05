import java.util.ArrayList;

public class Album {
    private String name;
    private ArrayList<Song> songList;
    

    public Album(String name){
        this.name = name;
        songList = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }
    public ArrayList<Song> getSongList() {
        return songList;
    }

    public boolean addSong(String title, String duration){
        Song existiSong = findSong(title);
        if (existiSong == null) {
            this.songList.add(new Song(title, duration));
            return true;
        }
        System.out.println("Song alread exist");
       return false;
    }

    public boolean removeSong(String title){
        Song existiSong = findSong(title);
        if (existiSong != null) {
            for (int i = 0; i < songList.size(); i++) {
                if (songList.get(i) == existiSong) {
                    songList.remove(i);
                    return true;
                }
            }
        }
        System.out.println("The song is not found");
       return false;
    }

    private Song findSong(String title){
        for (int i = 0; i < songList.size() ; i++) {
            String existingName = songList.get(i).getTitle();
            if (existingName.toLowerCase().equals(title.toLowerCase()) ) {
                return songList.get(i);
            }
        }
        return null;
    }
    
}
