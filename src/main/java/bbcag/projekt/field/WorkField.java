package bbcag.projekt.field;

import bbcag.projekt.Player;
import bbcag.projekt.field.Field;

public class WorkField extends Field {
    private short Worth = 150;

    public WorkField (String name){
        this.name = name;
    }
    @Override
    public void steppingOnIt(Player player) {
        if(this.Owner == null){
            if(this.Worth < player.Money) {
                if (true) {
                    this.buy(player);
                }
            }
        }
        else {
            //player 1 work 4x, 2 = 11x
        }

    }
    private void buy (Player player){
        player.Money = player.Money - this.Worth;
        this.Owner = player;
        player.works += 1;
    }
}
