package bbcag.projekt.field;

import bbcag.projekt.Game;
import bbcag.projekt.GameListener;
import bbcag.projekt.Player;

import java.util.HashSet;
import java.util.Set;

public class NormalField extends BuyableField {
    private short worth;
    private byte Hotel = 0;
    private int[] Rent;

    private int worthHotel;


    public NormalField(String name, short worth, int[] rent, int worthHotel) {
        this(name, worth, rent, worthHotel, null);
    }

    public NormalField(String name, short worth, int[] rent, int worthHotel, Player owner) {
        super(owner);
        this.name = name;
        this.worth = worth;
        this.Rent = rent;
        this.worthHotel = worthHotel;
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
                if (getRent() > 0) {
                    Game.getInstance().message(player.getName() + " hat " + owner.getName() + " " + getRent() + "$ gezahlt.");
                } else {
                    Game.getInstance().message(player.getName() + " hat von " + owner.getName() + " " + (-getRent()) + "$ erhalten.");
                }
            }
        }

    }

    public int getRent() {
        return Rent[Hotel];
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
}

