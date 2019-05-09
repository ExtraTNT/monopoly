package bbcag.projekt;

import bbcag.projekt.field.Field;

public class ActionField extends Field {

    public ActionField(String name, Player bank){
        owner = bank;
        this.name = name;
    }
    @Override
    public void steppingOnIt(Player player) {
        //Random events (pay 50, go 5 backwards ect.)
    }


}
