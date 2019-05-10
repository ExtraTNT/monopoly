package bbcag.projekt.field;

import bbcag.projekt.Game;
import bbcag.projekt.Player;

public class StartField extends Field {

    private short startMoney;

    public StartField(short money, Player bank) {
        name = "Start";
        startMoney = money;
        owner = bank;
    }

    @Override
    public void steppingOnIt(Player player, int rolledSum) {
        player.setAccountBalance(player.getAccountBalance() + (2 * startMoney));
        Game.getInstance().littleUpdateGUI();
    }

    public void passIt(Player player) {
        player.setAccountBalance(player.getAccountBalance() + startMoney);
        Game.getInstance().littleUpdateGUI();
    }

    public void setStartMoney(short startMoney) {
        this.startMoney = startMoney;
    }
}
