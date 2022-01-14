package jp.ac.uryukyu.ie.e215707;
import java.util.ArrayList;
import java.util.Collections;
public class PlayingCards{
    private String[] design = {"♠️", "❤️", "♣️", "♦️"};
    private String[] number = {"1", "2", "3", "4", "5", "6", "7", "8","9", "10", "11", "12", "13"};
    ArrayList<String> hand_cards = new ArrayList<>();
    ArrayList<String> cards = new ArrayList<>();
    void playgame(){
        for(int d = 0; d < 4; d++){
            for(int n = 0; n < 13; n++){
                cards.add(design[d] + number[n]);
                }
            }
            Collections.shuffle(cards);
        for(int I = 0; I < 5; I++){
            int i = 0;
            hand_cards.add(cards.get(i));
            System.out.println(I+1 + ":" + cards.get(i));
            cards.remove(i);
            }
        }
    }



