
package es.ulpgc.dis.katablackjack;

public class RegularCard extends Card{
    private final int value;

    public RegularCard(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return this.value;
    }
}