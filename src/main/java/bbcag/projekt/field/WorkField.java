package bbcag.projekt.field;

import bbcag.projekt.Game;
import bbcag.projekt.GameListener;
import bbcag.projekt.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkField extends BuyableField  {
    private short worth = 150;

    public WorkField(String name) {
        this.name = name;
    }

    @Override
    public int getWorth() {
        return worth;
    }

    @Override
    public void steppingOnIt(Player player, int rolledSum) {
            Game.getInstance().message(player.getName() + " ist auf " + this.getName() + " gelandet.");
        canBuy = false;
        if (this.owner == null) {
            if (this.worth < player.getAccountBalance()) {
                canBuy = true;
            }
        }
        else {
            List<Field> listToCount = new ArrayList<>();
            for(Field f : Game.getInstance().getBoard().getFieldsByOwner(owner)){
                if(f instanceof WorkField){
                    listToCount.add(f);
                }
            }
            int toPay = 0;
            if(listToCount.size() == 2){
                toPay = rolledSum + 11;
            }
            if(listToCount.size() == 1){
                toPay = rolledSum * 4;
            }
            player.setAccountBalance(player.getAccountBalance() - (toPay));
            owner.setAccountBalance(owner.getAccountBalance() + (toPay));
            Game.getInstance().message(player.getName() + " hat " + owner.getName() + " " + toPay + "$ gezahlt.");
            Game.getInstance().littleUpdateGUI();
        }

    }



    public void buy(Player player) {
        if (owner == null) {
            player.setAccountBalance(player.getAccountBalance() - worth);
            this.owner = player;
            canBuy = false;
        }
    }
}
