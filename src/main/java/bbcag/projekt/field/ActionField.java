package bbcag.projekt.field;

import bbcag.projekt.Game;
import bbcag.projekt.Player;
import bbcag.projekt.field.Field;

public class ActionField extends Field {

    public ActionField(String name, Player bank){
        owner = bank;
        this.name = name;
    }
    @Override
    public void steppingOnIt(Player player, int rolledSum) {
        int event = (int) Math.random()*6;
        switch (event){
            case 1:
                Game.getInstance().playMove(-3);
                break;
            case 2:
                player.setAccountBalance(player.getAccountBalance()-50);
                break;
            case 3:
                player.setAccountBalance(player.getAccountBalance() + 100);
                break;
            case 4:
                player.setPosition((byte)10);
                player.setRemainingDaysInPrison((byte)3);
                break;
            case 5:
                Game.getInstance().playMove(40 - player.getPosition());
                break;
            default:
                break;

        }
    }


}
