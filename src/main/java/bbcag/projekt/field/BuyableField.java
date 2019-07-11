package bbcag.projekt.field;

import bbcag.projekt.GameListener;
import bbcag.projekt.Player;

import java.util.Set;

public abstract class BuyableField extends Field {
    private Set<GameListener> listeners;
    public BuyableField() {
        this(null);
    }

    public BuyableField(Player owner) {
        this.owner = owner;
    }

    public abstract void buy(Player player);
}
