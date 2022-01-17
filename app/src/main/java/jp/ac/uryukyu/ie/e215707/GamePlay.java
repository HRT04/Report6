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
            for(int P=0; P<hand_cards.size(); P++){
                System.out.println(I + "ターン目:\n");
                System.out.println(player[P] + "のターン");
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("[Continue with Enter]");
                String ConEnter1 = scanner1.nextLine();
                System.out.println("手札:");

                for(int n=0; n<5; n++){
                    System.out.println(n + ":" + hand_cards.get(P).get(n));
                    }
                System.out.println();
                System.out.println("選択アクション:");
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("0:ドローする\n1:パスする"); 
                int value1 = scanner2.nextInt();

                if(value1 == 0){
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("どのカードと交代しますか？(0〜4)"); 
                    int value2 = scanner3.nextInt();
                    for(int i=0; i<5; i++){
                        if(value2 == i){
                            System.out.println(player[P] + "は" + hand_cards.get(P).get(i) + "を捨てて" + c.getCards().get(0) + "を手札に加えた!");
                            Scanner scanner4 = new Scanner(System.in);
                            System.out.println("[Continue with Enter]");
                            String ConEnter2 = scanner4.nextLine();
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
                Scanner scanner5 = new Scanner(System.in);
                System.out.println("[End of turn with Enter]");
                String ConEnter3 = scanner5.nextLine();
                System.out.println("ターン終了\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            }
        }

        System.out.println("全てのターンが終了\n\n\n:Role_Judgement:");
        Scanner scanner6 = new Scanner(System.in);
        System.out.println("[Continue with Enter]");
        String ConEnter4 =scanner6.nextLine();
        Judge j = new Judge();
        j.Judge(hand_cards.get(0), hand_cards.get(1));
        j.Judge_Ment();
    }
}
