package DataStructers;

public class Games {
    private String game;

    public Games(String game)
    {
        this.game = game;
    }

    public String getGame() {
        return game;
    }

    @Override
    public String toString() {
        return "\nGame: " + game;
    }
}
