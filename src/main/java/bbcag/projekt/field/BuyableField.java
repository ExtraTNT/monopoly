package bbcag.projekt.field;

import bbcag.projekt.Player;

public abstract class BuyableField extends Field {
    public BuyableField() {
        this(null);
    }

    public BuyableField(Player owner) {
        this.owner = owner;
    }

    public abstract void buy(Player player);
}
