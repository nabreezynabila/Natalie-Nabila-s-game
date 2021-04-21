
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author dancye, 2018
 * Modified by Natalie Dib
 * April 19 2021 
 * Modified by Nabila Ahmed
 * April 20,2021
 */
public class Card 
{
    public enum suits{
        HEARTS,
        DIAMONDS,
        CLUBES,
        SPADES
    };

    public enum values{ 
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE, 
        TEN, 
        JACK, 
        QUEEN, 
        KING   
    };
    
    private suits suit; 
    private values value;
    
    public Card(suits suit, values value) {
        this.suit = suit; 
        this.value = value;
    }
    
    
    
    /**
     * Students should implement this method for their specific children classes 
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    
    public suits getSuit() {
        return this.suit;
    }
    
    public values getValue() {
        return this.value;
    }
   
    public void setSuit(suits s) {
        this.suit = s; 
    }
    
    public void setValue(values v) {
        this.value = v;
    }
    
    public int valueToNumber(values v) {
        
        switch(v) {
            case ONE:
                return 1;
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN:
                return 10;
            case JACK:
                return 10;
            case QUEEN:
                return 10;
            case KING:
                return 10;
            
            default: 
                return 0;
        }

    }
}
