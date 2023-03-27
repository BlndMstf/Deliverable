package ca.sheridancollege.project;

public class UnoPlayer extends Player {
    /**
    * The class for the UnoPlayer player which extends from the abstract class Player
    * Since Player is an abstract class, you cannot make instances of it,
    * so for that reason, this class exists.
    * Each player in Uno essentially plays the same role, the role of a dealer is not so important
    * since the dealer role does not come with any additional responsibilities or functionalities.
    * 
    * @author Blend Mustafa March 2023
    */
    public UnoPlayer(String name) {
        super(name);
    }
    
    @Override
    public void play(){
    
    }
}