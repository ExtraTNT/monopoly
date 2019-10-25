package bbcag.projekt.field;

import bbcag.projekt.engine.Game;
import bbcag.projekt.player.Player;

/**JailField
 * the left bottom edge (index 10) Field
 * !important! is a neutral field the functionality is in the game engine and in the player !important!
 */
public class JailField extends Field {

    /**getWorth
     * @return the worth of the field == 0
     */
    @Override
    public int getWorth() {
        return 0;
    }

    /**JailField
     * constructor -> neutral Field nothing special
     * @param bank the bank player
     */
    public JailField(Player bank) {
        name = "Gefaengnis / Nur zu Besuch";
    }

    /**steppingOnIt
     * in this case just a message except if you get cachet
     * @param player the current player
     * @param rolledSum the sum of the 2 dies, which the player has rolled
     */
    @Override
    public void steppingOnIt(Player player, int rolledSum) {
            Game.getInstance().message(player.getName() + " ist zubesuch im Gefaengnis");
    }
}
