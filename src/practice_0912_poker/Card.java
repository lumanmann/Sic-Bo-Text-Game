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
public class Card {
    private String suit;
    private int point;
    private int suitOrder;
    
    // constructor
    public Card(String suit, int point) {
        this.suit = suit;
        this.point = point;
    }

    
    public String getSuit() {
        return suit;
    }

    public int getPoint() {
        return point;
    }

    
    public int getSuitOrder() {
        return suitOrder;
    }

    protected void setSuitOrder(int suitOrder) {
        this.suitOrder = suitOrder;
    }
    
    public void printCardDetails() {
        System.out.println(this.suit + " "+ this.point);
    }
   
    
}
