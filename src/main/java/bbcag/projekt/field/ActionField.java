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
        int event = (int) (Math.random()*6);
        System.out.println(event);
        switch (event){
            case 1:
                player.setAccountBalance(player.getAccountBalance() + rolledSum * 3 + 10);
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
                player.setAccountBalance((int)(player.getAccountBalance()-player.getAccountBalance()/10));
                break;
            default:
                player.setAccountBalance(player.getAccountBalance() + rolledSum * 5);
                break;
        }
    }


}
