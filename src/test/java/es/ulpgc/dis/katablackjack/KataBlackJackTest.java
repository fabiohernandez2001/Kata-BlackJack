package es.ulpgc.dis.katablackjack;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class KataBlackJackTest {
    @Test
    public void bet_with_Jack_and_Ace(){
        ArrayList<Player> listTest=new ArrayList<>();
        ArrayList<Card> betplayer1=new ArrayList<>();
        betplayer1.add(new Card_Value_10());
        betplayer1.add(new Card_Value_10());
        ArrayList<Card> betplayer2=new ArrayList<>();
        betplayer2.add(new RegularCard(10));
        betplayer2.add(new RegularCard(2));
        betplayer2.add(new RegularCard(6));
        
        ArrayList<Card> betplayer3=new ArrayList<>();
        betplayer3.add(new RegularCard(8));
        betplayer3.add(new RegularCard(8));
        betplayer3.add(new RegularCard(5));
        
        ArrayList<Card> betcrupier=new ArrayList<>();
        betcrupier.add(new RegularCard(5));
        betcrupier.add(new RegularCard(10));
        
        Player player1=new Player(betplayer1);
        Player player2=new Player(betplayer2);
        Player player3=new Player(betplayer3);
        Crupier crupier=new Crupier(betcrupier);
        
        listTest.add(player1);
        listTest.add(player3);
        ArrayList<Card> deck=new ArrayList<>();
        deck.add(new Ace());
        deck.add(new RegularCard(3));
        deck.add(new Card_Value_10());
        deck.add(new RegularCard(2));
        BlackJack bl= new BlackJack(deck);
        List<Player> listWinners= bl.GetWinners(player1, player2, player3, crupier);
        assert (listWinners.equals(listTest));    
    }
    @Test
    public void return_Player1_with_CASE1() {
        ArrayList<Player> listTest=new ArrayList<>();
        ArrayList<Card> betplayer1=new ArrayList<>();
        betplayer1.add(new Card_Value_10());
        betplayer1.add(new Ace());
        ArrayList<Card> betplayer2=new ArrayList<>();
        betplayer2.add(new RegularCard(10));
        betplayer2.add(new RegularCard(5));
        betplayer2.add(new RegularCard(6));
        ArrayList<Card> betplayer3=new ArrayList<>();
        betplayer3.add(new RegularCard(3));
        betplayer3.add(new RegularCard(6));
        betplayer3.add(new Ace());
        betplayer3.add(new RegularCard(3));
        betplayer3.add(new Ace());
        betplayer3.add(new Card_Value_10());
        ArrayList<Card> betcrupier=new ArrayList<>();
        betcrupier.add(new RegularCard(9));
        betcrupier.add(new RegularCard(7));
        Player player1=new Player(betplayer1);
        Player player2=new Player(betplayer2);
        Player player3=new Player(betplayer3);
        player1.toString();
        player2.toString();
        player3.toString();
        Crupier crupier=new Crupier(betcrupier);
        betcrupier.toString();
        listTest.add(player1);
        ArrayList<Card> deck=new ArrayList<>();
        deck.add(new RegularCard(5));
        deck.add(new RegularCard(4));
        deck.add(new Card_Value_10());
        deck.add(new RegularCard(2));
        BlackJack bl= new BlackJack(deck);
        List<Player> listWinners= bl.GetWinners(player1, player2, player3, crupier);
        assert (listWinners.equals(listTest));    }
    
}
