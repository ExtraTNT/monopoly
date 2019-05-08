package bbcag.projekt.field;

import bbcag.projekt.Game;
import bbcag.projekt.Player;
import bbcag.projekt.field.Field;

public class JailField extends Field {

    public JailField(){
        Owner = Game.getBank();
        name = "Gefängnis / Nur zu Besuch";
    }

    @Override
    public void steppingOnIt(Player player) {
    }
}
