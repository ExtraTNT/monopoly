package bbcag.projekt.field;

import bbcag.projekt.Player;

public class NormalField extends Field {
    private short worth;
    private byte Hotel = 0;
    private int[] Rent;

    public NormalField(String name, short worth, int[] rent) {
        this(name, worth, rent, null);
    }

    public NormalField(String name, short worth, int[] rent, Player owner) {
        super(owner);
        this.name = name;
        this.worth = worth;
        this.Rent = rent;
    }

    @Override
    public void steppingOnIt(Player player) {
        if (this.owner == null) {
            if (this.worth < player.getAccountBalance()) {
                if (true) {
                    this.buy(player);
                }
            }
        } else {
            player.setAccountBalance(player.getAccountBalance() - getRent());
            owner.setAccountBalance(owner.getAccountBalance() + getRent());
        }
    }

    public int getRent() {
        return Rent[Hotel];
    }

    private void buy(Player player) {
        player.setAccountBalance(player.getAccountBalance() - worth);
        this.owner = player;
    }

    public byte getHotel() {
        return Hotel;
    }

    public void setHotel(byte hotel) {
        Hotel = hotel;
    }
}
