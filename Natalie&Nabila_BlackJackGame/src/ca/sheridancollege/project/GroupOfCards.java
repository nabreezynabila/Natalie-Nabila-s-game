
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 * Modified by Natalie Dib
 * April 19 2021 
 * Modified by Nabila Ahmed
 * April 20,2021
 */
public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    public ArrayList <Card> cards = new ArrayList<Card>();
    
    public GroupOfCards() 
    {
    }
    
    
    public ArrayList<Card> getCards() {
        return this.cards;
        
    }
    public void makeStandardDeck() {
        for(Card.suits s: Card.suits.values() ) {
            for(Card.values v : Card.values.values()) {
                Card toAdd = new Card(s,v);
                cards.add(toAdd);
            }
        }
        
        
    }
    public ArrayList<Card> showCards()
    {
        return cards;
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */


    /**
     * @param givenSize the max size for the group of cards
     */

    

    
}//end class
