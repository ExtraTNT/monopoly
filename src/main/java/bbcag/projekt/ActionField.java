package bbcag.projekt;

public class ActionField extends Field {

    public ActionField(String name){
        Owner = Game.getBank();
        this.name = name;
    }
    @Override
    public void stepingOnIt(Player player) {

    }


}
