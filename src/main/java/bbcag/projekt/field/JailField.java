package bbcag.projekt.field;

import bbcag.projekt.engine.Game;
import bbcag.projekt.player.Player;

public class JailField extends Field {
    @Override
    public int getWorth() {
        return 0;
    }

    public JailField(Player bank) {
        name = "Gefaengnis / Nur zu Besuch";
    }

    @Override
    public void steppingOnIt(Player player, int rolledSum) {
            Game.getInstance().message(player.getName() + " ist zubesuch im Gefaengnis");
    }
}
