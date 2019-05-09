package bbcag.projekt.field;

import bbcag.projekt.Player;

public class WorkField extends Field {
    private short worth = 150;

    public WorkField(String name) {
        this.name = name;
    }

    @Override
    public void steppingOnIt(Player player) {
        if (this.owner == null) {
            if (this.worth < player.getAccountBalance()) {
                if (true)//UI.askBuy {
                    this.buy(player);
            }
        } else {
            //player 1 work 4x, 2 = 11x
        }

    }

    private void buy(Player player) {
        player.setAccountBalance(player.getAccountBalance() - worth);
        this.owner = player;
        player.setWorkFieldsCount((byte) (player.getWorkFieldsCount() + 1));
    }
}
