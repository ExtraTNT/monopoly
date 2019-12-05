package bbcag.projekt.field;

import bbcag.projekt.engine.Game;
import bbcag.projekt.player.Player;

import java.util.ArrayList;
import java.util.List;

public class NormalField extends BuyableField {
    private short worth;
    private byte Hotel = 0;
    private int[] Rent;
    private int worthHotel;
    private int groupIndex;
    public NormalField(String name, short worth, int[] rent, int worthHotel, int gIndex) {
        this(name, worth, rent, worthHotel, gIndex, null);
    }
    public NormalField(String name, short worth, int[] rent, int worthHotel, int gIndex, Player owner) {
        super(owner);
        this.name = name;
        this.worth = worth;
        this.Rent = rent;
        this.worthHotel = worthHotel;
        this.groupIndex = gIndex;
    }
    private int getRent() {
        return Rent[Hotel];
    }
    public int[] getRentList(){return Rent;}
    public int getGroupIndex() {
        return groupIndex;
    }
    public void buy(Player player) {
        if (owner == null) {
            player.setAccountBalance(player.getAccountBalance() - worth);
            this.owner = player;
            canBuy = false;
        }
    }
    public byte getHotel() {
        return Hotel;
    }
    public void setHotel(byte hotel) {
        Hotel = hotel;
    }
    public int getWorthHotel() {
        return worthHotel;
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
                Game.getInstance().message(player.getName() + " moechtest du " + this.getName() + " kaufen fuer " + this.getWorth() + "$?");
            }
        } else {
            player.setAccountBalance(player.getAccountBalance() - getRent());
            owner.setAccountBalance(owner.getAccountBalance() + getRent());
            Game.getInstance().littleUpdateGUI();
            if (owner != player) {
                if (getRent() > 0) {
                    Game.getInstance().message(player.getName() + " hat "
                            + owner.getName() + " " + getRent() + "$ gezahlt.");
                } else {
                    Game.getInstance().message(player.getName() + " hat von "
                            + owner.getName() + " " + (-getRent()) + "$ erhalten.");
                }
            }
        }
    }
}

