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
public class CardGame {

    private static final int playerNum = 2;
    private CardPlayer[] cardPlayers;
    private Cards cards;
    private int bet;        

    
    
    public CardGame() {
        cardPlayers = new CardPlayer[playerNum ];
        cards = new Cards();
        bet = 0;
    }
    
    public void setPlayer(CardPlayer cardplayer1, CardPlayer cardplayer2){   
        cardPlayers[0] = cardplayer1;
        cardPlayers[1] = cardplayer2;
    }
    
    public void start(int round) {
        if (cardPlayers[0] == null || cardPlayers[1] == null) {
            System.out.println("沒有足夠的玩家");
            return;
        }
        
        
        //若有一方金額歸零/回合結束 則遊戲結束
        for (int i = 0 ; i < round; i++){
            game();
            if (cardPlayers[0].getMoney() == 0 || cardPlayers[1].getMoney() == 0){
                break;
            }
            
        }
        
        //依照持有金額比較輸贏 印出勝利者的姓名 ( XXX 贏得遊戲/平手)
        if (cardPlayers[0].getMoney() > cardPlayers[1].getMoney()){
            System.out.println("Player " + cardPlayers[0].getName() + "贏得遊戲");
        } else if (cardPlayers[0].getMoney() < cardPlayers[1].getMoney()){
            System.out.println("Player " + cardPlayers[1].getName() + "贏得遊戲");
        } else {
            System.out.println("Player" + cardPlayers[0].getName() +
                    "Player" + cardPlayers[1].getName() + "平手");
        }
        
    }
    
    private void game(){
        Scanner scanner = new Scanner(System.in);
        //每一回合開始時 會讓兩位玩家使用bet方法提出賭注(如果得到-1則重新提出)
        this.cards.shuffle();
    
        for (int i = 0; i< playerNum; i++){
            System.out.print("Plyaer"+ (i+1) + "'s bet:");
            int betMoney = scanner.nextInt();
            int tmpBet;
            
            tmpBet = cardPlayers[i].bet(betMoney);
            
            if (tmpBet == -1) {
                    cardPlayers[i].addMoney(tmpBet);
                    tmpBet = 0;
                    i--;
                    System.out.println("not enough money to bet");
            }
            
           
            //提出的賭注會寫入int bet(總賭金)
            bet += tmpBet;
        }
        
      //提出賭注後使用Card的 deal方法發出兩張牌進行比大小 勝者可取走賭金 (如果牌發完則重新產生洗亂)
        
        cardPlayers[0].setMyCard(this.cards.deal());
        cardPlayers[1].setMyCard(this.cards.deal());
        
        int result = cardPlayers[0].compare(cardPlayers[1]);
        
        if (result == 1 ){
            System.out.println("Player1 wins this round");
            cardPlayers[0].addMoney(bet);
            bet = 0;
        } else {
            System.out.println("Player2 wins this round");
            cardPlayers[1].addMoney(bet);
            bet = 0;
        }
        
        // 印出回合的勝利者和玩家的現有金額
        System.out.print("Player1's card: ");
        cardPlayers[0].getMyCard().printCardDetails();
        System.out.print("Player2's card: ");
        cardPlayers[1].getMyCard().printCardDetails();
        System.out.println("Player1's money: " + cardPlayers[0].getMoney());
        System.out.println("Player2's money: " + cardPlayers[1].getMoney());
        System.out.println("--------------");
         
    }
}
