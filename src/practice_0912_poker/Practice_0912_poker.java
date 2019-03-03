/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice_0912_poker;

import java.util.Scanner;

/**
 *
 * @author wingyiu
 */
public class Practice_0912_poker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player1 name & money:");
        String name1 = scanner.next();
        int money1 = scanner.nextInt();
        
        System.out.println("Player2 name & money:");
        String name2 = scanner.next();
        int money2 = scanner.nextInt();
        
        CardGame game = new CardGame();
        
        CardPlayer cardplayer1 = new CardPlayer(name1, money1);
        CardPlayer cardplayer2 = new CardPlayer(name2, money2);
        game.setPlayer(cardplayer1, cardplayer2);
        game.start(3);
    }
    
}
