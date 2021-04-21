
package ca.sheridancollege.project;
import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * @author dancye, 2018
 * Modified by Natalie Dib
 * April 19 2021 
 * Modified by Nabila Ahmed
 * April 20,2021
 */
public class Player 
{
    private String playerID; //the unique ID for this player
    public ArrayList<Card> cardHand = new ArrayList<Card>(); 
    
    /**
     * A constructor that allows you to set the player's unique ID
     * @param name the unique ID to assign to this player.
     */
    public Player(String name)
    {
        playerID= name;
    }
    
    /**
     * @return the playerID
     */
    public String getPlayerID() 
    {
        return playerID;
    }

    /**
     * Ensure that the playerID is unique
     * @param givenID the playerID to set
     */
    public void setPlayerID(String givenID) 
    {
        playerID = givenID;
    }
    
    public int sumOfCards(ArrayList<Card> hand) {
        int total = 0;
        if(hand.size() > 0) {
            for (Card card : hand) {
                int toAdd = 0;
                 toAdd = card.valueToNumber(card.getValue());
                 total +=toAdd;
                
            }
            return total;
            
        }
        else 
            return 0;
    }
    
    public void dealCard(ArrayList<Card> deck, ArrayList<Card> hand) {
        Card deal = deck.get(0);
        hand.add(deal);
        deck.remove(0);
        
    }
    
}