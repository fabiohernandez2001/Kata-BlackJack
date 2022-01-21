
package es.ulpgc.dis.katablackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Card> bet;

    public Player(ArrayList<Card> bet) {
        this.bet= bet;
    }

    public List<Card> getBet() {
        return this.bet;
    }
    public boolean isBlackJack(){
        if(this.bet.size()==2){
            for(Card card:this.bet){
                if(card.getValue()<10)return false;
            }
            return this.bet.get(0).getValue()!=this.bet.get(1).getValue();
        }
        return false;
    }
    public int totalBet(){
        int sum=0;
        for(Card card:this.bet){
            sum+=card.getValue();
        }
        if(sum>21){
            for(Card card:this.bet){
                if(card.getValue()==11){
                    sum-=10;
                }
            }
        }
        return sum;
    }
    @Override
    public String toString(){
        String cards="";
        int sum=0;
        for(Card card: this.bet) {
            sum+=card.getValue();
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