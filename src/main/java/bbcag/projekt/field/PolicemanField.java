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

    @Override
    public void steppingOnIt(Player player, int rolledSum) {
        Game.getInstance().message(player.getName() + " wurde leider von der Polizei erwischt. Ab ins Gefaengnis");
        player.setPosition((byte) 10);
        player.setRemainingDaysInPrison((byte) 3);
    }
}
