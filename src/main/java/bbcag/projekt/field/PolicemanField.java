package bbcag.projekt.field;

import bbcag.projekt.engine.Game;
import bbcag.projekt.player.Player;


public class PolicemanField extends Field {

    @Override
    public int getWorth() {
        return 0;
    }

    public PolicemanField(Player bank) {
        this.name = "Gehe ins Gefaengnis!";
    }

    /**steppingOnIt
     * that happens, if you go to the police...
     * make a message, set the position to 10 (the JailField) and set RemainingDaysInPrison
     * @param player the current player
     * @param rolledSum the sum of the 2 dies, which the player has rolled
     */
    @Override
    public void steppingOnIt(Player player, int rolledSum) {
        Game.getInstance().message(player.getName() + " wurde leider von der Polizei erwischt. Ab ins Gefaengnis");
        player.setPosition((byte) 10);
        player.setRemainingDaysInPrison((byte) 3);
    }
}
