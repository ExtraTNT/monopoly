package bbcag.projekt.field;

import bbcag.projekt.Game;
import bbcag.projekt.GameListener;
import bbcag.projekt.Player;

import java.util.Set;

public class StartField extends Field {
    private short startMoney;

    public StartField(short money, Player bank) {
        name = "Start";
        startMoney = money;
        owner = bank;
    }

    @Override
    public int getWorth() {
        return 0;
    }

    @Override
    public void steppingOnIt(Player player, int rolledSum) {
            Game.getInstance().message(player.getName() + " ist auf dem Start-Feld gelandet, das heisst doppeltes Geld");

        player.setAccountBalance(player.getAccountBalance() + (2 * startMoney));
        Game.getInstance().littleUpdateGUI();
    }

    public void passIt(Player player) {
        Game.getInstance().message(player.getName() + " ist über Los gezogen, das gibt ein bisschen Geld");
        player.setAccountBalance(player.getAccountBalance() + startMoney);
        Game.getInstance().littleUpdateGUI();
    }

    public void setStartMoney(short startMoney) {
        this.startMoney = startMoney;
    }
}
