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
public class Cards {
    private static final String POKER_PATTERN[] = new String[]{"club", "diamond", "heart", "spade"};
    private Card[] cards;
    private int currentCardIndex;
    
    
    
    public Cards(){
        cards = new Card[52];
        this.reset();
        currentCardIndex = 0;
    }

    // getter
    public Card getCards(int i) {
        return cards[i];
    }
    
    // 將cards中的順序洗亂
    public void shuffle() {
        for(int i=0; i<52; i++){
            int targetIndex = (int)(Math.random()*52);
            // 把位置i 跟 位置targetIndex 的牌交換
            Card tmpCard = this.cards[i];
            this.cards[i] = this.cards[targetIndex];
            this.cards[targetIndex] = tmpCard;
        }
       
    }
    
    // 發出一張牌(第二次呼叫deal將發第二張 第三次呼叫發第三張 以此類推)
    public Card deal(){
        return cards[currentCardIndex++];
    }
    
    // 將cards還原到初始模樣(deal刷新回到第一張 順序還原)
    public void reset(){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 13; j++){
                // 取得index 0 ~ 52
                int index = j + (13*i);
                // 把花色和數字按順序assign進card array
                this.cards[index] = new Card(POKER_PATTERN[i], (j+1));
                this.cards[index].setSuitOrder(i);
            }
        }
    }
    
    public void printCards(){
        for (int i = 0; i< 52; i++){
            cards[i].printCardDetails();
        }
    }
    
    
}
