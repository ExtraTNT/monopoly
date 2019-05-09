package bbcag.projekt.field;

import bbcag.projekt.Player;

public class StartField extends Field {

    private short startMoney;

    public StartField(short money, Player bank) {
        name = "Start";
        startMoney = money;
        owner = bank;
    }

    @Override
    public void steppingOnIt(Player player) {
        player.setAccountBalance(player.getAccountBalance() + (2 * startMoney));
    }

    public void passIt(Player player) {
        player.setAccountBalance(player.getAccountBalance() + startMoney);
    }

    public void setStartMoney(short startMoney) {
        this.startMoney = startMoney;
    }
}
