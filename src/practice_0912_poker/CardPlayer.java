/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice_0912_poker;

/**
 *
 * @author wingyiu
 */
public class CardPlayer {
//    撰寫一類別 CardPlayer 內含屬性 String name, int money
//
//CardPlayer有一建構子 CardPlayer(String name, int money)
//
//CardPlayer有下列方法
//
// int bet(int money) 
//
//void addMoney(int money) 
    
    private String name;
    private int money;
    private Card myCard;
    
    
    public CardPlayer(String name, int money) {
        this.name = name;
        this.money = money;
    }
    
    // 用來下注 當傳入的金額>持有金額則回傳-1
    public int bet(int money) {
        if (this.getMoney() < money) {
            return -1;
        } else {
            this.money -= money;
            return money;
        }
    }
 
    // 添加金額
    public void addMoney(int money) {
        this.money += money;
    }

   
    public String getName() {
        return name;
    }

    
    public int getMoney() {
        return money;
    }

   
    public void setMoney(int money) {
        this.money = money;
    }
    
    public Card getMyCard() {
        return myCard;
    }

    public void setMyCard(Card myCard) {
        this.myCard = myCard;
    }
    
    
    // 1代表大於 -1代表小於
    public int compare(CardPlayer cardPlayer){
      Card selfCard = this.getMyCard();
      Card otherCard = cardPlayer.getMyCard();
      if (selfCard.getPoint() > otherCard.getPoint()){
          return 1;
      } else if (selfCard.getPoint() < otherCard.getPoint()){
          return -1;
      } else {
          if (selfCard.getSuitOrder() > otherCard.getSuitOrder()){
             return 1; 
          } else {
              return -1;
          }
      } 
    }

   
}
