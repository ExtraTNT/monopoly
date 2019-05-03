package bbcag.projekt;

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
