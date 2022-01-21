
package es.ulpgc.dis.katablackjack;

import java.util.ArrayList;
import java.util.List;

public class Crupier extends Player{

    public Crupier(ArrayList<Card> bet) {
        super(bet);
    }
    public void takeFromDeck(Card card){
        this.bet.add(card);
    } 
    @Override
    public String toString(){
        String cards="";
        for(Card card: this.bet) {
            if (this.bet.indexOf(card)==this.bet.size()-1){
                cards+= " " + String.valueOf(card.getValue());
            }
            else{
                cards+= " " + String.valueOf(card.getValue())+" ";
            }
        }
        return cards +"("+String.valueOf(this.totalBet())+")";
    }
}