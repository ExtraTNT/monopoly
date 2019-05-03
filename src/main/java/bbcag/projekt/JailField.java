package bbcag.projekt;

public class JailField extends Field {

    public JailField(){
        Owner = Game.getBank();
        name = "Gefängnis / Nur zu Besuch";
    }

    @Override
    public void steppingOnIt(Player player) {
    }
}
