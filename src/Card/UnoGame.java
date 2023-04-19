/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Card;

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
        PlayerActions actions = new PlayerActions(player, players, discardPile, drawPile);
        int drawLimit = 0; //limits number of draws you can make
        int playerHandSize = player.getHand().getCards().size(); //size of the player's hand
        while (true){
            //This whole code activates whenever it's a new turn
            System.out.println("The top card is " + discardPile.getTopCard()); //Displays the top card of the discard pile
            System.out.println(player.getName() + ", here are your cards.");
            for (int i = 0; i < playerHandSize; i++){
                System.out.println((i + 1) + ". " + player.getHand().getCards().get(i).toString()); //Prints each card
            }
            System.out.println((playerHandSize + 1) + ". Draw a card"); //There should be some logic to make this draw a card
            System.out.print("Enter the index number of the card you would like to play: ");
            int cardIndex = scanner.nextInt()-1; //ex. if the player enters 1, it should go to index 0, hence -1
        
            /*
            sets the top card to be whatever the player discarded if valid,
            then removes the card from the players hand. otherwise, prompts the player again
            */
            if (cardIndex >= 0 && cardIndex < playerHandSize){
                if (actions.canPlayCard((UnoCard)player.getHand().getCard(cardIndex))==true){
                    actions.playCard((UnoCard)player.getHand().getCard(cardIndex));
                    break;
                }
                else {
                    System.out.println("PLEASE CHOOSE A DIFFERENT CARD.");
                }
            }
            else if (cardIndex == playerHandSize && drawLimit == 0){ //if player chooses to draw a card
                actions.playerDrawsCard();
                playerHandSize = player.getHand().getCards().size(); //gets the new size
                drawLimit++;
            }
            else {
                System.out.println("YOU CANNOT DRAW MORE CARDS THIS ROUND");
            
                boolean canPlayCard = false;
                ArrayList <UnoCard> playersCards = player.getHand().getCards();
                
                for (UnoCard c : playersCards) {
                    if (actions.canPlayCard(c)) {
                        canPlayCard = true;
                        break;
                    }
                }
                
                if (!canPlayCard) {
                    System.out.println("There are no cards you can play, your turn is skipped");
                    actions.skipTurn();
                }
            }
            
        }
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