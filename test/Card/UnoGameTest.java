package Card;

import ca.sheridancollege.project.UnoCard;
import ca.sheridancollege.project.UnoPlayer;
import ca.sheridancollege.project.UnoGame;
import ca.sheridancollege.project.DiscardPile;
import ca.sheridancollege.project.DrawPile;
import ca.sheridancollege.project.PlayerActions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
*
* @author meghapatel
* @author Blend Mustafa
*/
public class UnoGameTest {

    private static DiscardPile discardPile;
    private static DrawPile drawPile;
    private static UnoGame game;
    
    public UnoGameTest() {

    }

    @Before
    public void setUpClass() {
        //this will run before all tests
        discardPile = new DiscardPile();
        drawPile = new DrawPile(discardPile);
        //Default card to be used in each test is RED ZERO
        discardPile.setTopCard(new UnoCard(UnoCard.Color.RED,UnoCard.Value.ZERO));
        System.out.println("Beginning of Unit test\n ");
    }

    @AfterClass
    public static void tearDownClass() {
        //this will run after all tests
        System.out.println("\nUnit test completed");
    }

    @Before
    public void setUp() {
        //before each test
        System.out.println("Hello");
    }

    @After
    public void tearDown() {
        //after each test
        System.out.println("-----------");
    }
    
    @Test
    public void canPlayCardGood() {
    System.out.println("Testing playCardGood");
    ArrayList<UnoPlayer> players = new ArrayList<>();
    PlayerActions actions = new PlayerActions(new UnoPlayer("Tester"), players, discardPile, drawPile);
    UnoCard testCard = new UnoCard(UnoCard.Color.RED, UnoCard.Value.ONE);
    boolean expResult = true;//card is playable so expect true
    //invoking the method and store the result
    boolean result = actions.canPlayCard(testCard);

    //the test will pass if the result is same as expresult
    assertEquals(expResult, result);
    }
    
    @Test
    public void canPlayCardBad() {
    System.out.println("Testing playCardBad");
    ArrayList<UnoPlayer> players = new ArrayList<>();
    PlayerActions actions = new PlayerActions(new UnoPlayer("Tester"), players, discardPile, drawPile);
    UnoCard testCard = new UnoCard(UnoCard.Color.BLUE, UnoCard.Value.ONE);
    boolean expResult = false;//card is not playable so expect false
    //invoking the method and store the result
    boolean result = actions.canPlayCard(testCard);

    //the test will pass if the result is same as expresult
    assertEquals(expResult, result);
    }
    
    @Test
    public void canPlayCardBoundary() {
    System.out.println("Testing playCardBoundary");
    ArrayList<UnoPlayer> players = new ArrayList<>();
    PlayerActions actions = new PlayerActions(new UnoPlayer("Tester"), players, discardPile, drawPile);
    UnoCard testCard = new UnoCard(UnoCard.Color.BLUE, UnoCard.Value.ZERO);
    boolean expResult = true;//card is playable because both are ZERO so expect true
    //invoking the method and store the result
    boolean result = actions.canPlayCard(testCard);

    //the test will pass if the result is same as expresult
    assertEquals(expResult, result);
    }
    
    @Test
    public void canDrawCardGood() {
    System.out.println("Testing if can draw card good");
    ArrayList<UnoPlayer> players = new ArrayList<>();
    UnoPlayer player = new UnoPlayer("Tester");
    PlayerActions actions = new PlayerActions(player, players, discardPile, drawPile);
    drawPile.fill(); //fill drawpile with cards
    boolean hasDrawn = false; //checks if user already drew card (only checks manual draws)
    if (hasDrawn == false){
        actions.playerDrawsCard(); //player draws a card
        hasDrawn = true;
    }
    int handSize = player.getHand().getCards().size(); //number of cards in player's hand
    int expResult = 1;//number of cards that are expected to be in hand
    int result = handSize; //number of cards in hand

    //the test will pass if the result is same as expresult
    assertEquals(expResult, result);
    } 
    
    @Test
    public void canDrawCardBad() {
    System.out.println("Testing if can draw card bad");
    ArrayList<UnoPlayer> players = new ArrayList<>();
    UnoPlayer player = new UnoPlayer("Tester");
    PlayerActions actions = new PlayerActions(player, players, discardPile, drawPile);
    drawPile.fill(); //fill drawpile with cards
    boolean hasDrawn = true; //checks if user already drew card (only checks manual draws)
    if (hasDrawn == false){
        actions.playerDrawsCard(); //player draws a card
        hasDrawn = true;
    }
    int handSize = player.getHand().getCards().size(); //number of cards in player's hand
    int expResult = 0;//number of cards that are expected to be in hand
    int result = handSize; //number of cards in hand
    
    assertEquals(expResult, result);
    }
    
    @Test
    public void canDrawCardBoundary() {
    System.out.println("Testing if can draw card bad");
    ArrayList<UnoPlayer> players = new ArrayList<>();
    UnoPlayer player = new UnoPlayer("Tester");
    PlayerActions actions = new PlayerActions(player, players, discardPile, drawPile);
    drawPile.fill(); //fill drawpile with cards
    actions.playerDrawsCard(); //forced draw from +2, not manual draw
    actions.playerDrawsCard(); //forced draw from +2, not manual draw
    boolean hasDrawn = false; //checks if user already drew card (only checks manual draws)
    if (hasDrawn == false){
        actions.playerDrawsCard(); //player draws a card
        hasDrawn = true;
    }
    int handSize = player.getHand().getCards().size(); //number of cards in player's hand
    int expResult = 3;//number of cards that are expected to be in hand
    int result = handSize; //number of cards in hand
    
    assertEquals(expResult, result);
    }  
    
    @Test
    public void canChooseColorGood() {
    System.out.println("Testing if can choose color good");
    System.out.println("Choose a color (Red, Green, Blue, or Yellow): ");
    String input = "blue"; //pretend the user has chosen blue
    if (input.equalsIgnoreCase("red") || input.equalsIgnoreCase("green")
                || input.equalsIgnoreCase("blue") || input.equalsIgnoreCase("yellow")){
    discardPile.getTopCard().setColor(UnoCard.Color.valueOf(input.toUpperCase()));
            }
    Enum expResult = UnoCard.Color.BLUE;//expected color, should be BLUE
    Enum result = discardPile.getTopCard().getColor(); //actual color
    
    assertEquals(expResult, result);
    } 
    
    @Test
    public void canChooseColorBad() {
    System.out.println("Testing if can choose color bad");
    System.out.println("Choose a color (Red, Green, Blue, or Yellow): ");
    String input = "purple"; //pretend the user has chosen purple
    if (input.equalsIgnoreCase("red") && !input.equalsIgnoreCase("green")
                && !input.equalsIgnoreCase("blue") && !input.equalsIgnoreCase("yellow")){
    discardPile.getTopCard().setColor(UnoCard.Color.valueOf(input.toUpperCase()));
            }
    Enum expResult = UnoCard.Color.RED;//expected color, RED because it shouldn't change
    Enum result = discardPile.getTopCard().getColor(); //actual color
    
    assertEquals(expResult, result);
    }
    
    @Test
    public void canChooseColorBoundary() {
    System.out.println("Testing if can choose color bad");
    System.out.println("Choose a color (Red, Green, Blue, or Yellow): ");
    String input = "GrEeN"; //pretend the user has chosen green
    if (input.equalsIgnoreCase("red") || input.equalsIgnoreCase("green")
                || input.equalsIgnoreCase("blue") || input.equalsIgnoreCase("yellow")){
    discardPile.getTopCard().setColor(UnoCard.Color.valueOf(input.toUpperCase()));
            }
    Enum expResult = UnoCard.Color.GREEN;//expected color, should be GREEN
    Enum result = discardPile.getTopCard().getColor(); //actual color
    
    assertEquals(expResult, result);
    }  
}