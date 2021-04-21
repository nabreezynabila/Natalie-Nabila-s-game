
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Author Natalie Dib
 * April 19 2021 
 * Modified by Nabila Ahmed
 * April 20,2021
 */
public class BlackJack {

    public static void main(String[] args) {

        System.out.println("Welcome to Natalie & Nabila's BlackJack Game");

        System.out.println("Type in your name to get started: ");

        Scanner input = new Scanner(System.in);

        String playerName = input.nextLine();

        Player player1 = new Player(playerName);

        System.out.println("Welcome " + player1.getPlayerID() + " are you ready to play?");

        System.out.println("Enter 1 for Yes " + "and 2 for No: ");
        //checking if user is pressing 1 or 2 only. 

        String playerReady = input.nextLine();

        boolean play = false;

        boolean valid = validInput(playerReady);

        while (valid == false) {
            System.out.println("Not a valid response");
            System.out.println("Enter 1 for Yes " + "and 2 for No: ");
            playerReady = input.nextLine();
            valid = validInput(playerReady);
        }

        if (playerReady.equals("1")) {
            play = true;
        } else {
            System.out.println("You left the game");
            play = false;
        }

        while (play == true) {

            GroupOfCards newDeck = new GroupOfCards();

            newDeck.makeStandardDeck();

            newDeck.shuffle();

            Dealer dealer = new Dealer("Dealer");

            System.out.println("What would you like to do: ");
            System.out.println("Enter 1 to draw a card ");
            System.out.println("Enter 2 to quit game");
            System.out.println("Enter 3 to show your cards.");

            String playerMove = input.nextLine();

            boolean valid2 = validInputGamePlay(playerMove);

            while (valid2 == false) {
                System.out.println("Not a valid response");
                System.out.println("Enter 1 to Draw a Card " + " and 2 to quit the Game");
                playerMove = input.nextLine();

                valid2 = validInputGamePlay(playerMove);
            }

            if (playerMove.equals("2")) {
                play = false;
                System.out.println("You quit the game");
                System.out.println("Thank you for playing!");
                break;
            }

            if (playerMove.equals("1")) {
                player1.dealCard(newDeck.cards, player1.cardHand);
                System.out.println("You cards are: ");
                for (Card card : player1.cardHand) {
                    System.out.println(card.getValue() + " of " + card.getSuit());
                }
                System.out.println("The total sum of your cards are: " + player1.sumOfCards(player1.cardHand));

            }

            if (dealer.draw(dealer.cardHand)) {
                System.out.println("-------------------");
                System.out.println("Dealer draws a card");
                System.out.println("-------------------");
                dealer.dealCard(newDeck.cards, dealer.cardHand);
            }

            if (playerMove.equals("3")) {
                if (player1.sumOfCards(player1.cardHand) > 21) {
                    System.out.println("You busted!");
                    System.out.println("Dealer wins!");
                    break;
                }
                if (dealer.sumOfCards(dealer.cardHand) > 21) {
                    System.out.println("Dealer busted!");
                    System.out.println("Player wins!");
                    break;
                }

                for (Card card : player1.cardHand) {
                    System.out.println("Cards in your hand right now: ");
                    System.out.println(card.getValue() + " of " + card.getSuit());

                }

                for (Card card : dealer.cardHand) {
                    System.out.println("Cards in the dealers hands right now: ");
                    System.out.println(card.getValue() + " of " + card.getSuit());

                }

                if (dealer.sumOfCards(dealer.cardHand) <= 21 && player1.sumOfCards(player1.cardHand) <= 21) {
                    int pScore = player1.sumOfCards(player1.cardHand) - 21;
                    int dScore = dealer.sumOfCards(dealer.cardHand) - 21;
                    if (pScore < dScore) {
                        System.out.println("Player Wins!");
                        play = false;
                    } else if (pScore == dScore) {
                        System.out.println("Its a tie!");
                        play = false;
                    } else {
                        System.out.println("Dealer wins");
                        System.out.println("Try again next time!");
                        play = false;
                    }
                }

            }

            if (win21Player(player1)) {
                System.out.println("Congradulations! You Won!");
                play = false;
            }

            if (win21Dealer(dealer)) {
                System.out.println("Sorry you lose, the dealer wins");
                play = false;
            }

            if (bust(player1, dealer)) {
                play = false;
            };

        }

    }

    public static boolean validInputGamePlay(String i) {
        if (i.equals("1") || i.equals("2") || i.equals("3")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validInput(String i) {
        if (i.equals("1") || i.equals("2")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean win21Player(Player p) {
        if (p.sumOfCards(p.cardHand) == 21) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean win21Dealer(Dealer d) {
        if (d.sumOfCards(d.cardHand) == 21) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean bust(Player p, Dealer d) {
        if (p.sumOfCards(p.cardHand) > 21) {
            System.out.println("You busted!");
            System.out.println("Better luck next time!");
            return true;
        } else if (d.sumOfCards(d.cardHand) > 21) {
            System.out.println("dealer busted!");
            System.out.println(p.getPlayerID() + " wins the game!");
            return true;

        } else {
            return false;
        }
    }
}
