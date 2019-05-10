package bbcag.projekt.field;

import bbcag.projekt.Game;
import bbcag.projekt.Player;

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
            Game.getInstance().littleUpdateGUI();
        }

    }

    public int getRent() {
        return Rent[Hotel];
    }

    public void buy(Player player) {
        if (owner == null) {
            player.setAccountBalance(player.getAccountBalance() - worth);
            this.owner = player;
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

