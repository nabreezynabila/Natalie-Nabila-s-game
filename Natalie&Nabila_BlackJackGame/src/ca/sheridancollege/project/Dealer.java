package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Natalie
 * April 20,2021
 */
public class Dealer extends Player{
    
    public Dealer(String name) {
        super(name);
        
    }
    
    public boolean draw(ArrayList<Card> hand) {
        
        if(hand.size() == 0) {
            return true;
        }
        else if(sumOfCards(hand) <= 18) {
            return true;
        }
        else {
            return false;
        }
    }
    
    
}

