package bbcag.projekt.field;

import bbcag.projekt.engine.Game;
import bbcag.projekt.player.Player;

import java.util.ArrayList;
import java.util.List;

/**WorkField
 * the Field with the water and electricity...
 */
public class WorkField extends BuyableField {
    private short worth = 150;

    public WorkField(String name) {
        this.name = name;
    }

    public void buy(Player player) {
        if (owner == null) {
            player.setAccountBalance(player.getAccountBalance() - worth);
            this.owner = player;
            canBuy = false;
        }
    }

    @Override
    public int getWorth() {
        return worth;
    }

    /**steppingOnIt
     * test, if the field has no owner and the current player have enough money to buy -> if it so, the player can buy it...
     * if the field have a owner, it calculates the rent for it ->
     * test how much WorkFields the owner have and how much the current player has rolled...
     * if the rent calculate, it move the money for the rent from the current player to the owner of this field.
     * @param player the current player
     * @param rolledSum the sum of the 2 dies, which the player has rolled
     */
    @Override
    public void steppingOnIt(Player player, int rolledSum) {
        Game.getInstance().message(player.getName() + " ist auf " + this.getName() + " gelandet.");
        canBuy = false;
        if (this.owner == null) {
            if (this.worth < player.getAccountBalance()) {
                canBuy = true;
                Game.getInstance().message(player.getName() + " moechtest du " + this.getName() + " kaufen fuer " + this.getWorth() + "$?");
            }
        } else {
            List<Field> listToCount = new ArrayList<>();
            for (Field f : Game.getInstance().getBoard().getFieldsByOwner(owner)) {
                if (f instanceof WorkField) {
                    listToCount.add(f);
                }
            }
            int toPay = 0;
            if (listToCount.size() == 2) {
                toPay = rolledSum * 11;
            }
            if (listToCount.size() == 1) {
                toPay = rolledSum * 4;
            }
            player.setAccountBalance(player.getAccountBalance() - (toPay));
            owner.setAccountBalance(owner.getAccountBalance() + (toPay));
            if (owner != player) {
                Game.getInstance().message(player.getName() + " hat " + owner.getName() + " " + toPay + "$ gezahlt.");
            }
            Game.getInstance().littleUpdateGUI();
        }

    }
}
