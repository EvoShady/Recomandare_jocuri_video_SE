package main.java.DataStructers;

public class UserChoices {

    private String spMpChoice, platformChoice, genreChoice, contentRatingChoice;

    public UserChoices(String spMpChoice, String platformChoice, String genreChoice, String contentRatingChoice) {
        this.spMpChoice = spMpChoice;
        this.platformChoice = platformChoice;
        this.genreChoice = genreChoice;
        this.contentRatingChoice = contentRatingChoice;
    }

    public String getSpMpChoice() {
        return spMpChoice;
    }

    public String getPlatformChoice() {
        return platformChoice;
    }

    public String getGenreChoice() {
        return genreChoice;
    }

    public String getContentRatingChoice() {
        return contentRatingChoice;
    }

    public String toString(){
        return "Singleplayer or multiplayer: " + spMpChoice + "\nPlatform: " + platformChoice + "\nGenre: " + genreChoice + "\nContentRating: " + contentRatingChoice;
    }
}
