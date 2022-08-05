public class Player {
    // private Music music = new Music();

    

    public Player(){
        
    }

    public void printPlayerOption(){
        System.out.println(
            "*********************** \n" +
            "    Zoolian player      \n" + 
            "                        \n" +
            "***********************"
        );
        System.out.println(
            "Enter \n" +
                    "\t 0 - to see the player menu \n" +
                    "\t 1 - to play song \n" +
                    "\t 2 - to add song to the playlist \n" +
                    "\t 3 - to quite the player \n" +
            "By_Zoolian"
                    );
    }

    public void printPlayOption(){
        System.out.println(
            "*********************** \n" +
            "        Playing         \n" + 
            "                        \n" +
            "***********************"
        );
        System.out.println(
            "Enter \n" +
                    "\t 0 - to see the play menu \n" +
                    "\t 1 - to play next song \n" +
                    "\t 2 - to replay the current song \n" +
                    "\t 3 - to play prvious song \n" +
                    "\t 4 - to remove the current song \n"+
                    "\t 5 - to stop playing \n" +
            "By_Zoolian"
                    );
    }



    public boolean previous(String title){
        System.out.println("Now playing the previous song '" + title + "'");
        return true;
    }

    public boolean next(String title){
        System.out.println("The next music '" + title + "' is now playing ");
        return true;
    }

    public boolean pause(String title){
        System.out.println(title + " is paused");
        return true;
    }

    public boolean play(String title){
        System.out.println("Now playing : " + title);
        return true;
    }



}
