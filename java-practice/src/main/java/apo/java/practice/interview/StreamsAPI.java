package apo.java.practice.interview;


import java.util.ArrayList;
import java.util.*;

public class StreamsAPI {
    public static void main(String[] args) {

        var cr7 = new Player("Cristiano Ronaldo", "CR7");
        var messi = new Player("Lionel Messi", "La Pulga");
        var ney = new Player("Neymar Jr.", "Ney");
        List<Vote> votes = new ArrayList<>(10);
        votes.add(new Vote(cr7, 3));
        votes.add(new Vote(messi, 3));
        votes.add(new Vote(ney, 1));
        votes.add(new Vote(cr7, 3));
        votes.add(new Vote(ney, 1));
        votes.add(new Vote(ney, 1));
        votes.add(new Vote(messi, 3));
        votes.add(new Vote(messi, 1));
        votes.add(new Vote(ney, 2));
        votes.add(new Vote(messi, 3));

        // Cristiano Ronaldo -> 3 + 3 = 6
        // Lionel Messi -> 3 + 1 + 3 + 3 = 10
        // Neymar Jr. -> 1 + 1 + 1 + 2 = 5

        var answer = sortedPlayerName(votes);
        System.out.println(answer.get(0).equals("Lionel Messi"));
        System.out.println(answer.get(1).equals("Cristiano Ronaldo"));
        System.out.println(answer.get(2).equals("Neymar Jr."));
    }

    //Return the list of player's names sorted by their total score in descending order
    static List<String> sortedPlayerName(List<Vote> votes) {

            return null;
    }
}

class Vote {
    public Player player;
    public int value;

    public Vote(Player player, int value) {
        this.player = player;
        this.value = value;
    }
}

class Player {
    private final String name;
    private final String nickname;

    public Player(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }
}