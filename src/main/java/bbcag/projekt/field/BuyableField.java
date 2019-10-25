package bbcag.projekt.field;

import bbcag.projekt.player.Player;

/**BuyableField
 * a class, just to group somme other Classes
 * gives the new abstract method buy -> so, a player can buy a BuyableField...
 */
public abstract class BuyableField extends Field {

    /**BuyableField
     * a constructor to construct the Railway and WorkFields
     */
    public BuyableField() {
        this(null);
    }

    /**BuyableField
     * a constructor to construct the NormalFields
     * @param owner the owner of the Field
     */
    public BuyableField(Player owner) {
        this.owner = owner;
    }

    /**buy
     * abstract... implements that the player can buy this Field...
     * @param player the player-object
     */
    public abstract void buy(Player player);
}
