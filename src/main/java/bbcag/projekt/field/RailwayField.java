package bbcag.projekt.field;

import bbcag.projekt.Game;
import bbcag.projekt.GameListener;
import bbcag.projekt.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RailwayField extends BuyableField  {
    private short worth = 200;
    private int[] Rent = new int[]{25, 50, 100, 200};

    public RailwayField(String name) {
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
            player.setAccountBalance(player.getAccountBalance() - getRent());
            owner.setAccountBalance(owner.getAccountBalance() + getRent());
            Game.getInstance().littleUpdateGUI();
            if(owner != player) {
                Game.getInstance().message(player.getName() + " hat " + owner.getName() + " " + getRent() + "$ gezahlt.");
            }
        }

    }

    public int getRent(){
        List<Field> listToCount = new ArrayList<>();
        for(Field f : Game.getInstance().getBoard().getFieldsByOwner(owner)){
            if(f instanceof RailwayField){
                listToCount.add(f);
            }
        }

        return Rent[listToCount.size()-1];
    }



    public void buy(Player player) {
        if (owner == null) {
            player.setAccountBalance(player.getAccountBalance() - worth);
            this.owner = player;
            canBuy = false;
        }
    }
}
