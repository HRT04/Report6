package jp.ac.uryukyu.ie.e215707;
import java.util.Scanner;
/**
 * ゲーム開始の際に表示する。
 */
public class Command {

/**
 * ゲーム説明
 */
    void Start_Command(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("      POKER\n\n[Start with Enter]");
        String Enter = scanner.nextLine();
        System.out.println("    全3ターン\n   Poker Start!\n");
    }
}




