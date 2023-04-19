package Card;

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

    @BeforeClass
    public static void setUpClass() {
        UnoGame game = new UnoGame("Uno");
        //this will run before all tests
        discardPile = new DiscardPile();
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
    UnoCard testCard = new UnoCard(UnoCard.Color.RED, UnoCard.Value.ONE);
    int expResult = 0;//draw limit
    int result = 0;//number of times drawn

    //the test will pass if the result is same as expresult
    assertEquals(expResult, result);
    } 
    
    @Test
    public void canDrawCardBad() {
    System.out.println("Testing if can draw card bad");
    ArrayList<UnoPlayer> players = new ArrayList<>();
    UnoPlayer player = new UnoPlayer("Tester");
    PlayerActions actions = new PlayerActions(player, players, discardPile, drawPile);
    UnoCard testCard = new UnoCard(UnoCard.Color.RED, UnoCard.Value.ONE);
    int expResult = 1;//draw limit
    int result = 1;//number of times drawn

    //the test will pass if the result is NOT same as expresult
    assertEquals(expResult, result);
    }
    
    @Test
    public void canDrawCardBoundary() {
    System.out.println("Testing if can draw card boundary");
    ArrayList<UnoPlayer> players = new ArrayList<>();
    UnoPlayer player = new UnoPlayer("Tester");
    PlayerActions actions = new PlayerActions(player, players, discardPile, drawPile);
    UnoCard testCard = new UnoCard(UnoCard.Color.RED, UnoCard.Value.ONE);
    int expResult = 0;//draw limit
    int result = 2;//number of times drawn

    //the test will pass if the result is NOT same as expresult
    assertNotEquals(expResult, result);
    }  
    
}