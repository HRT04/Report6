package jp.ac.uryukyu.ie.e215707;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 役とプレイヤーの勝敗を判別する。
 * 手札の数字が何枚揃っているかを数える:num_count
 * 手札に絵柄が何枚揃っているかを数える:design_count
 * プレイヤーが揃えた役の名前を保存する:role
 * 1Pの手札の揃い具合を保存する:map_1P
 * 2Pの手札の揃い具合を保存する:map_2P
 */
public class Judge {
    int num_count;
    int Design_count_1P;
    int Design_count_2P;
    int design_count;
    String role;
    Map<Integer, Integer> map_1P = new HashMap<Integer, Integer>();
    Map<Integer, Integer> map_2P = new HashMap<>();
    ArrayList<ArrayList> Players = new ArrayList<>();
    Map<String, String>  role_names = new HashMap<String, String> ();
    Map<String, Integer> Point_Players = new HashMap<String, Integer>();
    ArrayList<Map<Integer, Integer>> Judge_Players_List = new ArrayList<Map<Integer, Integer>>();

/**
 * 手札の揃い具合をリストに保管する。
 * @param Player1P 揃い具合を調べたい手札のリスト。
 * @param Player2P 揃い具合を調べたい手札のリスト。
 */
    void Judge(ArrayList<ArrayList<String>> Player1P, ArrayList<ArrayList<String>> Player2P){
        Players.add(Player1P);
        Players.add(Player2P);
        Design_count_1P = 0;
        Design_count_2P = 0;

        for(ArrayList<ArrayList> i : Players){
            for(int H=0; H<5; H++){
                num_count = 0;
                design_count = 0;
                for(int S=0; S<5; S++){
                    if(i.get(H).get(1) == i.get(S).get(1)){
                        num_count += 1;
                    }
                    if(i.get(H).get(0) == i.get(S).get(0)){
                        design_count += 1;
                    }
                }

                String s = i.get(H).get(1).toString();
                int num = Integer.valueOf(s);

                if(i.equals(Player1P)){
                    if(!(map_1P.containsKey(num))){
                        map_1P.put(num, num_count);
                    }
                    if((design_count == 5) && (Design_count_1P == 0)){
                        Design_count_1P += design_count;
                    }
                    
                }

                if(i.equals(Player2P)){
                    if(!(map_2P.containsKey(num))){
                        map_2P.put(num, num_count);
                    }
                    if((design_count == 5) && (Design_count_2P == 0)){
                        Design_count_2P += design_count;
                    }
                }
            }
        }
    }        

/**
 * 役を判別し、その情報から勝敗も判別する。
 */
    void Judge_Ment(){
        ArrayList<Map<Integer, Integer>> Judge_Players_List = new ArrayList<Map<Integer, Integer>>();
        Judge_Players_List.add(map_1P);
        Judge_Players_List.add(map_2P);

        Set<Integer> Royal = new HashSet<Integer>();
        Royal.add(1);
        Royal.add(10);
        Royal.add(11);
        Royal.add(12);
        Royal.add(13);

        ArrayList<Set<Integer>> Straight = new ArrayList<Set<Integer>> ();
        for(int i=1; i<10; i++){
            Set<Integer> st = new HashSet<Integer>();
            st.add(i);
            st.add(i+1);
            st.add(i+2);
            st.add(i+3);
            st.add(i+4);
            Straight.add(st);
        }


        String[] name ={"1P", "2P"};
        int[] D_Point_Players = {Design_count_1P, Design_count_2P};

        for(int D=0; D<2; D++){
            int Po = 0;
            if((Judge_Players_List.get(D).keySet().equals(Royal)) && (D_Point_Players[D] == 5)){//ロイヤルストレートフラッシュ
                Po += 1000;
                role = "ロイヤルストレートフラッシュ";
            }

            for(Set<Integer> i : Straight){
                if((Judge_Players_List.get(D).keySet().equals(i)) && (D_Point_Players[D] == 5)){//ストレートフラッシュ
                    Po += 900;
                    role = "ストレートフラッシュ";
                }else if(Judge_Players_List.get(D).keySet().equals(i)){//ストレート
                    Po += 500;
                    role = "ストレート";
                }
            }

            if(!(role == "ストレートフラッシュ") && !(role == "ストレート")){
                if((D_Point_Players[D] == 5) && !(((Judge_Players_List.get(D).containsValue(4)) && (Judge_Players_List.get(D).containsValue(1))) || ((Judge_Players_List.get(D).containsValue(3)) && (Judge_Players_List.get(D).containsValue(2))))){//フラッシュ
                    Po += 600;
                    role = "フラッシュ";
                }else if(!(D_Point_Players[D] == 5) && !(Judge_Players_List.get(D).containsValue(2) || Judge_Players_List.get(D).containsValue(3) || Judge_Players_List.get(D).containsValue(4))){//ノーペア
                    Po += 100;
                    role = "ノーペア";
                }
            }    
        
            if((Judge_Players_List.get(D).containsValue(4)) && (Judge_Players_List.get(D).containsValue(1))){//フォーカード
                    Po += 800;
                    role = "フォーカード";
            }

            if((Judge_Players_List.get(D).containsValue(3)) && (Judge_Players_List.get(D).containsValue(2))){//フルハウス
                    Po += 700; 
                    role = "フルハウス";   
            }

            if(((Judge_Players_List.get(D).containsValue(3)) && (Judge_Players_List.get(D).containsValue(1))) && !(D_Point_Players[D] == 5)){//スリーカード
                    Po += 400;
                    role = "スリーカード";
            }

            if(((Judge_Players_List.get(D).containsValue(2)) && (Judge_Players_List.get(D).containsValue(1))) && !(D_Point_Players[D] == 5)){
                if(Judge_Players_List.get(D).size() == 4 ){//ワンペア
                    Po += 200;
                    role = "ワンペア";
                }else if(Judge_Players_List.get(D).size() == 3){//ツーペア
                    Po += 300;
                    role = "ツーペア";
                }
            }
            Point_Players.put(name[D],Po);
            role_names.put(name[D],role);
        }

        System.out.println("1P:" + role_names.get("1P"));
        System.out.println("2P:" + role_names.get("2P"));

        if(Point_Players.get("1P") < Point_Players.get("2P")){
            System.out.println("2Pの役が強いので2Pの勝利!!");
        }else if(Point_Players.get("1P") > Point_Players.get("2P")){
            System.out.println("1Pの役が強いので1Pの勝利!!");
        }else{
            System.out.println("1P, 2P 共に同じ役なので引き分け");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("[End the game with Enter]");
        String ConEnter =scanner.nextLine();

        for(int N=0; N<2; N++){
            System.out.println(name[N] + "の手札:");
            for(int n=0; n<5; n++){
                System.out.println(Players.get(N).get(n));
            }
            System.out.println();
        }
        System.out.println("        [ゲーム終了]");
        
        
    }
    Map<String, String> getRole_names(){
            return role_names;
        }    

} 

