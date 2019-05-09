package bbcag.projekt.field;

import bbcag.projekt.Player;

public class WorkField extends Field {
    private short worth = 150;

    public WorkField(String name) {
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
        }  else {
            if(owner.getWorkFieldsCount() == 2){
                player.setAccountBalance(player.getAccountBalance() - (rolledSum * 11));
                owner.setAccountBalance(owner.getAccountBalance() + (rolledSum * 11));
            }
            if(owner.getWorkFieldsCount() == 1){
                player.setAccountBalance(player.getAccountBalance() - (rolledSum * 4));
                owner.setAccountBalance(owner.getAccountBalance() + (rolledSum * 4));
            }
        }

    }

    private void buy(Player player) {
        player.setAccountBalance(player.getAccountBalance() - worth);
        this.owner = player;
        player.setWorkFieldsCount((byte) (player.getWorkFieldsCount() + 1));
    }
}
