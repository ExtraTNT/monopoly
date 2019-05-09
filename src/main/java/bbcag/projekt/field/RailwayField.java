package bbcag.projekt.field;

import bbcag.projekt.Player;

public class RailwayField extends Field {

    private short worth = 200;
    private int[] Rent = new int[]{25, 50, 100, 200};

    public RailwayField(String name) {
        this.name = name;
    }
    @Override
    public void steppingOnIt(Player player, int rolledSum) {
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
        return Rent[owner.getRailwayStationCount() - 1];
    }

    private void buy(Player player) {
        player.setAccountBalance(player.getAccountBalance() - worth);
        this.owner = player;
        player.setRailwayStationCount((byte) (player.getRailwayStationCount() + 1));
    }
}
