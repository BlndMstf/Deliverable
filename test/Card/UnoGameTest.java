package Card;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
*
* @author meghapatel
* @author Blend Mustafa
*/
public class UnoGameTest {

    private static DiscardPile discardPile;
    private static DrawPile drawPile;
    
    public UnoGameTest() {
    }

    @BeforeClass
    public static void setUpClass() {
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
    PlayerActions actions = new PlayerActions(new UnoPlayer("Tester"), discardPile, drawPile);
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
    PlayerActions actions = new PlayerActions(new UnoPlayer("Tester"), discardPile, drawPile);
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
    PlayerActions actions = new PlayerActions(new UnoPlayer("Tester"), discardPile, drawPile);
    UnoCard testCard = new UnoCard(UnoCard.Color.BLUE, UnoCard.Value.ZERO);
    boolean expResult = true;//card is playable because both are ZERO so expect true
    //invoking the method and store the result
    boolean result = actions.canPlayCard(testCard);

    //the test will pass if the result is same as expresult
    assertEquals(expResult, result);
    }
}