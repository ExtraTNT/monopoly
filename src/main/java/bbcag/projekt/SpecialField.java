package bbcag.projekt;

public class SpecialField extends Field {

    public SpecialField(String name){
        Owner = Game.getBank();
        this.name = name;
    }

    @Override
    public void steppingOnIt(Player player) {

    }
}
