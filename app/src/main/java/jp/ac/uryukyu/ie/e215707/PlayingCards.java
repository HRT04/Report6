package jp.ac.uryukyu.ie.e215707;
import java.util.ArrayList;
import java.util.Collections;

public class PlayingCards{
    private String[] design = {"♠️", "❤️", "♣️", "♦️"}; 
    private String[] number = {"1", "2", "3", "4", "5", "6", "7", "8","9", "10", "11", "12", "13"}; 
    ArrayList<ArrayList<String>> hand_cards_1P = new ArrayList<ArrayList<String>>(); 
    ArrayList<ArrayList<String>> hand_cards_2P = new ArrayList<ArrayList<String>>(); 
    ArrayList<ArrayList<String>> cards = new ArrayList<ArrayList<String>>(); 

    ArrayList<ArrayList<String>> getCards(){
        return cards;
        }
    ArrayList<ArrayList<String>> getHand_cards_1P(){
        return hand_cards_1P;
        }
    ArrayList<ArrayList<String>> getHand_cards_2P(){
        return hand_cards_2P;
        }

    void playcards(){ 
        for(int d = 0; d < 4; d++){
            for(int n = 0; n < 13; n++){
                ArrayList<String> card = new ArrayList<>();
                card.add(design[d]);
                card.add(number[n]);
                cards.add(card);
            }
        }

        Collections.shuffle(cards);

        for(int I = 0; I < 5; I++){
            int i = 0;
            ArrayList<String> hand_card_1P = new ArrayList<>();
            for(int c=0; c<2; c++){
                hand_card_1P.add(cards.get(i).get(c));
            }
            hand_cards_1P.add(hand_card_1P);
            cards.remove(i);
        }
        
        for(int I = 0; I < 5; I++){
            int i = 0;
            ArrayList<String> hand_card_2P = new ArrayList<>();
            for(int c=0; c<2; c++){
                hand_card_2P.add(cards.get(i).get(c));
            }
            hand_cards_2P.add(hand_card_2P);
            cards.remove(i);
        }
    }
}
    
    



