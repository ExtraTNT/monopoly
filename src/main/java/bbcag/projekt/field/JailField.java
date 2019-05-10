package bbcag.projekt.field;

import bbcag.projekt.Player;

public class JailField extends Field {

    public JailField(Player bank) {
        name = "Gefaengnis / Nur zu Besuch";
    }

    @Override
    public void steppingOnIt(Player player, int rolledSum) {
    }
}
