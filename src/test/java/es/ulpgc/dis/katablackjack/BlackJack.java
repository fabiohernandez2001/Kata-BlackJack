
package es.ulpgc.dis.katablackjack;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {
    public Card pop(ArrayList<Card> deck){
        Card card=deck.get(0);
        deck.remove(0);
        return card;
    }
    public List<Player> GetWinners(Player player1, Player player2, Player player3, Crupier crupier, ArrayList<Card> deck){
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
        while((betcrupier=crupier.totalBet())<=17){
            if(betcrupier>21) return players;
            crupier.takeFromDeck(pop(deck));
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
