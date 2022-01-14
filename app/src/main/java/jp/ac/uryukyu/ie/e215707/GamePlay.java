package jp.ac.uryukyu.ie.e215707;
import java.util.Scanner;
import java.util.ArrayList;

public class GamePlay {
    String[] player = {"1P", "2P"};
    Command com = new Command();
    PlayingCards c = new PlayingCards();
    
    void GamePlay(){
        com.Start_Command();
        c.playcards();
        ArrayList<ArrayList> hand_cards = new ArrayList<>();
        hand_cards.add(c.getHand_cards_1P());
        hand_cards.add(c.getHand_cards_2P());
        for(int I=1; I<4; I++){
            for(int P=0; P<2; P++){
                System.out.println(I + "ターン目:\n");
                System.out.println(player[P] + "のターン\n手札:");
                for(int n=0; n<5; n++){
                    System.out.println(n + ":" + hand_cards.get(P).get(n));
                    }
                System.out.println();
                System.out.println("選択アクション:");
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("0:ドローする\n1:パスする"); 
                int value1 = scanner1.nextInt();

                if(value1 == 0){
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("どのカードと交代しますか？(0〜4)"); 
                    int value2 = scanner2.nextInt();
                    for(int i=0; i<5; i++){
                        if(value2 == i){
                            System.out.println(player[P] + "は" + hand_cards.get(P).get(i) + "を捨てて" + c.getCards().get(0) + "を手札に加えた!");
                            hand_cards.get(P).set(i, c.getCards().get(0));
                            c.getCards().remove(0);
                        }
                    }
                }else if(value1 == 1){
                    System.out.println(player[P] + "はパスをした");
                }
                System.out.println("手札:");
                for(int n=0; n<5; n++){
                    System.out.println(n + ":" + hand_cards.get(P).get(n));   
                }
                System.out.println("ターン終了");
            }
        }

        System.out.println("全ての誕が終了\n\nRole_Judgment:");
    }
}
