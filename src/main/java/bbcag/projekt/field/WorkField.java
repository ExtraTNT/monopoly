package bbcag.projekt.field;

import bbcag.projekt.Game;
import bbcag.projekt.Player;

import java.util.ArrayList;
import java.util.List;

public class WorkField extends BuyableField  {
    private short worth = 150;

    public WorkField(String name) {
        this.name = name;
    }

    @Override
    public void steppingOnIt(Player player, int rolledSum) {
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
            if(listToCount.size() == 2){
                player.setAccountBalance(player.getAccountBalance() - (rolledSum * 11));
                owner.setAccountBalance(owner.getAccountBalance() + (rolledSum * 11));
            }
            if(listToCount.size() == 1){
                player.setAccountBalance(player.getAccountBalance() - (rolledSum * 4));
                owner.setAccountBalance(owner.getAccountBalance() + (rolledSum * 4));
            }
        }

    }



    public void buy(Player player) {
        player.setAccountBalance(player.getAccountBalance() - worth);
        this.owner = player;
    }
}
