

package ca.sheridancollege.project;

/**
 * This class is Software Design SYST17796 18401
 *
 * @author Mehmet Sakalli
 */
import java.util.ArrayList;

public abstract class Game {
    private String name;
    private ArrayList<UnoPlayer> players;

    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    public void addPlayer(UnoPlayer player) {
        players.add(player);
    }

    public String getName() {
        return name;
    }

    public ArrayList<UnoPlayer> getPlayers() {
        return players;
    }

    public abstract void play();
}
