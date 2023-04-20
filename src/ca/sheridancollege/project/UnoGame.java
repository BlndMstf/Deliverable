/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ca.sheridancollege.project;

/**
 * This Class is SYST10199 Web Programming
 *
 * @author Mehmet Yunus Sakalli
 * @author Blend Mustafa
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UnoGame extends Game {

    private DrawPile drawPile;
    private DiscardPile discardPile;
    private ArrayList<UnoPlayer> players = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public UnoGame(String name) {
        super(name);
        discardPile = new DiscardPile();
        drawPile = new DrawPile(discardPile);
    }
    
    public void declareWinner(UnoPlayer player){
        System.out.println("The winner is " + player.getName());
        
    }
    
    public void takeTurn(UnoPlayer player){
        Scanner scanner = new Scanner(System.in);
        PlayerActions actions = new PlayerActions(player, players, discardPile, drawPile);
        int drawLimit = 0;

        do {
            System.out.println("The top card is " + discardPile.getTopCard());
            System.out.println(player.getName() + ", here are your cards:");

            var playerHand = player.getHand().getCards();

            for (int i = 0; i < playerHand.size(); i++) {
                System.out.println((i + 1) + ". " + playerHand.get(i).toString());
            }

            System.out.println((playerHand.size() + 1) + ". Draw a card");
            System.out.print("Enter the index number of the card you would like to play: ");
            int cardIndex = scanner.nextInt() - 1;

            if (cardIndex >= 0 && cardIndex < playerHand.size()) {
                if (actions.canPlayCard((UnoCard)playerHand.get(cardIndex))) {
                    actions.playCard((UnoCard)playerHand.get(cardIndex));
                    break;
                } else {
                    System.out.println("PLEASE CHOOSE A DIFFERENT CARD.");
                }
            } else if (cardIndex == playerHand.size() && drawLimit == 0) {
                actions.playerDrawsCard();
                playerHand = player.getHand().getCards();
                drawLimit++;
            } else {
                System.out.println("YOU CANNOT DRAW MORE CARDS THIS ROUND");

                boolean canPlayCard = false;

                for (var card : playerHand) {
                    if (actions.canPlayCard(card)) {
                        canPlayCard = true;
                        break;
                    }
                }

                if (!canPlayCard) {
                    System.out.println("There are no cards you can play, your turn is skipped");
                    actions.skipTurn();
                }
            }
        } while (true);
    }


    @Override
    public void play() {
        //ArrayList<UnoPlayer> players = new ArrayList<>();

        
        int numOfPlayers = 4;
        String playerName = "";
        // Create players
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Enter The Name of Player #" + (i+1));
            playerName = scanner.nextLine();
            players.add(new UnoPlayer(playerName));
        }

        drawPile.fill();

        // Shuffle the draw pile and distribute cards to players
        Collections.shuffle(drawPile.getCards());
        for (int i = 0; i < 7; i++) {
            for (UnoPlayer player : players) {
                player.getHand().addCard(drawPile.drawCard());
            }
        }

        // Set top card on discard pile
        discardPile.setTopCard(drawPile.drawCard());

        // Keep playing until someone wins
        boolean isGameOver = false;
        while (!isGameOver) {
            for (UnoPlayer player : players) {
                // Player's turn
                takeTurn(player);

                // Check if player has won
                if (player.getHand().getSize() == 0) {
                    declareWinner(player);
                    isGameOver = true;
                    break;
                }
            }
        }
    }
}
