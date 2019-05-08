package bbcag.projekt.field;

import bbcag.projekt.Game;
import bbcag.projekt.Player;
import bbcag.projekt.field.Field;

public class PolicemanField extends Field {

    public PolicemanField(){
        Owner = Game.getBank();
        this.name = "Gehe ins Gefaengnis!";
    }

    @Override
    public void steppingOnIt(Player player) {
        player.Position = 10;
        player.Days = 3;
    }
}
