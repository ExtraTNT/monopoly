package bbcag.projekt;

public class ActionField extends Field {

    public ActionField(String name){
        Owner = Game.getBank();
        this.name = name;
    }
    @Override
    public void steppingOnIt(Player player) {
        //Random events (pay 50, go 5 backwards ect.)
    }


}