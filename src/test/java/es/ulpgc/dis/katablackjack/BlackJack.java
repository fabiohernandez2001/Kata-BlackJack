
package es.ulpgc.dis.katablackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {
    private List<Card> deck;

    public BlackJack(ArrayList<Card> deck) {
        this.deck = deck;
    }
    public Card takeDeck(){
        Card card=this.deck.get(0);
        this.deck=this.deck.subList(1, this.deck.size()-1);
        return card;
    }
    public List<Player> GetWinners(Player player1, Player player2, Player player3, Crupier crupier){
        if(crupier.isBlackJack())return null;
        ArrayList<Player> winners=new ArrayList<>();
        ArrayList<Player> players=new ArrayList<>();
        players.add(player1);players.add(player2);players.add(player3);
        ArrayList<Player> BlackJacks=new ArrayList<>();
        players.stream().filter(player -> (player.isBlackJack())).
                forEachOrdered(player -> {
            BlackJacks.add(player);
        });
        if (BlackJacks.size()>0)return BlackJacks;
        int betcrupier;
        while((betcrupier=crupier.totalBet())<17){
            if(betcrupier>21) return players;
            crupier.takeFromDeck(this.takeDeck());
        }
        if(player1.totalBet()>=crupier.totalBet()){
            winners.add(player1);
        }
        if(player2.totalBet()>=crupier.totalBet()){
            winners.add(player2);
        }
        if(player3.totalBet()>=crupier.totalBet()){
            winners.add(player3);
        }
        return winners ;
    }
}