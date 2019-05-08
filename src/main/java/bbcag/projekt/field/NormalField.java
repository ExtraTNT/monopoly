package bbcag.projekt.field;

import bbcag.projekt.Player;
import bbcag.projekt.field.Field;

public class NormalField extends Field {
    private short Worth;
    private byte Hotel = 0;
    private int[] Rent;

    public NormalField(String name, short worth, int[] rent) {
        this(name, worth, rent, null);
    }

    public NormalField(String name, short worth, int[] rent, Player owner) {
        super(owner);
        this.name = name;
        this.Worth = worth;
        this.Rent = rent;
    }

    @Override
    public void steppingOnIt(Player player) {
        if (this.Owner == null) {
            if (this.Worth < player.Money) {
                if (true)//UI.askBuy {
                    this.buy(player);
            }
        }
        else {
            player.Money -= this.getRent();
            Owner.Money += this.getRent();
        }
    }

    public int getRent() {
        return Rent[Hotel];
    }

    private void buy(Player player) {
        player.Money = player.Money - this.Worth;
        this.Owner = player;
    }

    public byte getHotel() {
        return Hotel;
    }

    public void setHotel(byte hotel) {
        Hotel = hotel;
    }
}
