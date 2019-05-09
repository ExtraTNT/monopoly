package bbcag.projekt.field;

import bbcag.projekt.Player;

public class PolicemanField extends Field {

    public PolicemanField(Player bank) {
        this.name = "Gehe ins Gefaengnis!";
    }

    @Override
    public void steppingOnIt(Player player, int rolledSum) {
        player.setPosition((byte) 10);
        player.setRemainingDaysInPrison((byte) 3);
    }
}
