package bbcag.projekt.field;

import bbcag.projekt.Game;
import bbcag.projekt.GameListener;
import bbcag.projekt.Player;

import java.util.HashSet;
import java.util.Set;

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
