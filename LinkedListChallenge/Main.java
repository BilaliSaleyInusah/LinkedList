import java.util.ListIterator;
import java.util.Scanner;

public class Main{
    private static Scanner scanner = new Scanner(System.in);
    private static Music music = new Music();
    private static Player player = new Player();
    private static boolean playingState = false;

    public static void main(String[] args) {
        // boolean quite = false;
        // printOption();
        // while (!quite) {
        //     System.out.println("");
        //     System.out.print("Enter your option : ");
        //     int choice = scanner.nextInt();
        //     scanner.nextLine();
        //     switch (choice) {
        //         case 0:
        //             printOption();
        //             break;
        //         case 1:
        //             addAlbum();
        //             break;
        //         case 2:
        //             removeAlbum();
        //             break;
        //         case 3:
        //             addSong();
        //             break;
        //         case 4:
        //             removeSong();
        //             break;
        //         case 5:
        //             music.printAlbums();
        //             break;
        //         case 6:
        //             showSongs();
        //             break;
        //         case 7:
        //             addToPlaylist();
        //             break;
        //         // case :
        //         //     removeFromPlaylist();
        //         //     break;
        //         case 8:
        //             playSong();
        //             break;
        //         case 9:
        //             quite = true;
        //             break;
        //     }
        // }
        music.addAlbum("bilali");
        music.addSong("bilali", "bil", "6");
        music.addSong("bilali", "ali", "6");
        music.addSong("bilali", "saley", "6");
        music.addToPlaylist("bil");
        music.addToPlaylist("ali");
        music.addToPlaylist("saley");
        System.out.println("1");
        music.next();
        System.out.println(34);
        play();
    }

    public static void playSong(){
        System.out.println();
        boolean quiteSong = false;
        player.printPlayerOption();
        while (!quiteSong) {
            System.out.println();
            System.out.print("Enter your player option : ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    player.printPlayerOption();
                    break;
                case 1:
                    play();
                    break;
                case 2:
                    addToPlaylist();
                    break;
                case 3:
                    quiteSong = true;
                    break;
            }
        }
    }

    public static void play(){
        int size = music.getPlaylist().size();
        ListIterator<Song> songs = music.getPlaylist().listIterator();
        if (size > 0) {
                playingState = true;
                boolean goingForward = true;
                player.printPlayOption();
                while (playingState) {
                    System.out.println("");
                    System.out.print("Enter play option : ");
                    int option = scanner.nextInt();
                    scanner.nextLine();
                    switch (option) {
                        case 0:
                            player.printPlayOption();
                            break;
                        case 1:
                            if (songs.hasNext()) {
                                if (goingForward) {
                                    System.out.println("Now playing " + songs.next().getTitle());
                                } else {
                                    songs.next();
                                    System.out.println("Now playing " + songs.next().getTitle());
                                    goingForward = true;
                                }
                                
                            } else {
                                System.out.println("Reached the end of the list");
                                goingForward = false;
                            }
                            break;
                        case 2:
                            if (goingForward) {
                                if (songs.hasPrevious()) {
                                    System.out.println("Now playing " + songs.previous().getTitle());
                                    goingForward = false;
                                } else {
                                    System.out.println("Reached the beging of the list");
                                }
                            } else {
                                if (songs.hasNext()) {
                                    System.out.println("Now playing " + songs.next().getTitle());
                                    goingForward = true;
                                } else {
                                    System.out.println("Reached the end of the list");
                                }
                            }
                            break;
                        case 3:
                            if (songs.hasPrevious()) {
                                if (!goingForward) {
                                    System.out.println("Now playing " + songs.previous().getTitle());
                                } else {
                                    songs.previous();
                                    if (songs.hasPrevious()) {
                                        System.out.println("Now playing " + songs.previous().getTitle());
                                        goingForward = false;
                                    }else {
                                        System.out.println("Reached the beging of the list");
                                        goingForward  = true;
                                    }
                                    
                                }
                                
                            } else {
                                System.out.println("Reached the beging of the list");
                                goingForward  = true;
                            }
                            break;
                        case 4:
                            if (music.getPlaylist().size() > 0) {
                                songs.remove();
                                if (songs.hasNext()) {
                                    System.out.println("Now playing " + songs.next().getTitle());
                                } else {
                                    System.out.println("Now playing " + songs.previous().getTitle());
                                }
                            } else {
                                System.out.println("No music to removed");
                            }
                            break;
                        case 5:
                            playingState = false;
                    }
                }
        } else {
            System.out.println("There is no music in the playlist \n " +
                                    "Enter '6' to add song to the playlist");
        }

    }


    public static void addToPlaylist(){
        System.out.print("Enter the name of the song to add to the playlist : ");
        String title = scanner.nextLine();
        boolean state = music.addToPlaylist(title);
        if (state) {
            System.out.println("added");
        } else {
            System.out.println("error");
        }
    }

    public static void showSongs(){
        System.out.print("Enter the name the album : ");
        String albumName = scanner.nextLine();
        music.printSongs(albumName);
    }

    public static void removeSong(){
        System.out.print("Enter the name the album to add the song to : ");
        String albumName = scanner.nextLine();
        System.out.print("Enter the song title : ");
        String title = scanner.nextLine();
        boolean state = music.removeSong(albumName, title);
        if (state) {
            System.out.println("removed");
        } else {
            System.out.println("error");
        }
    }

    public static void addSong(){
        System.out.print("Enter the name the album to add the song to : ");
        String albumName = scanner.nextLine();
        System.out.print("Enter the song title : ");
        String title = scanner.nextLine();
        System.out.print("Enter the duration (02:40 , 01:23): ");
        String duration = scanner.nextLine();
        boolean state = music.addSong(albumName, title, duration);
        if (state) {
            System.out.println("added");
        } else {
            System.out.println("error");
        }
    }

    public static void removeAlbum(){
        System.out.print("Enter the name of the album to reove : ");
        String albumName = scanner.nextLine();
        boolean state = music.removeAlbum(albumName);
        if (state) {
            System.out.println("removed");
        } else {
            System.out.println("error");
        }
    }

    public static void addAlbum(){
        System.out.print("Enter the name of the album : ");
        String albumName = scanner.nextLine();
        boolean state = music.addAlbum(albumName);
        if (state) {
            System.out.println("added");
        } else {
            System.out.println("error");
        }
        
    }

    public static void printOption(){
        System.out.println(
            "Enter \n" +
                    "\t 0 - to see the menu \n" +
                    "\t 1 - to add album \n" +
                    "\t 2 - to remove album \n" +
                    "\t 3 - to add song \n" +
                    "\t 4 - to remove song \n" + 
                    "\t 5 - to show all available albums \n" +
                    "\t 6 - to show all available songs \n" +
                    "\t 7 - to add song to playlist \n" +
                    "\t 8 - to play song \n"+
                    "\t 9 - to quite the program \n" +
            "By_Zoolian"
                    );
    }


}