package bbcag.projekt.field;

import bbcag.projekt.Game;
import bbcag.projekt.Player;

import java.util.ArrayList;
import java.util.List;


public class RailwayField extends Field {

    private short worth = 200;
    private int[] Rent = new int[]{25, 50, 100, 200};

    public RailwayField(String name) {
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
            player.setAccountBalance(player.getAccountBalance() - getRent());
            owner.setAccountBalance(owner.getAccountBalance() + getRent());
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
        player.setAccountBalance(player.getAccountBalance() - worth);
        this.owner = player;
    }
}
