package main.java.DataStructers;

public class AvailableOptions {
    public String[] smMp;
    public String[] platform;
    public String[] genre;
    public String[] contentRating;

    public AvailableOptions(String[] smMp, String[] platform, String[] genre, String[] contentRating){
        this.smMp = smMp;
        this.platform = platform;
        this.genre = genre;
        this.contentRating = contentRating;
    }

    public String getAvailableSmMp(){
        String temp = "";
        for(int i = 0; i < smMp.length; i++){
            temp += smMp[i] + "\n";
        }
        return temp + "\n";
    }
    public String getAvailablePlatforms(){
        String temp = "";
        for(int i = 0; i < platform.length; i++){
            temp += platform[i] + "\n";
        }
        return temp + "\n";
    }
    public String getAvailableGenres(){
        String temp = "";
        for(int i = 0; i < genre.length; i++){
            temp += genre[i] + "\n";
        }
        return temp + "\n";
    }
    public String getAvailableContentRatings(){
        String temp = "";
        for(int i = 0; i < contentRating.length; i++){
            temp += contentRating[i] + "\n";
        }
        return temp + "\n";
    }
}
