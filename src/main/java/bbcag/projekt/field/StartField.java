package bbcag.projekt.field;

import bbcag.projekt.Player;

public class StartField extends Field {

    private short StartMoney;
    public StartField(short money, Player bank){
        name = "Start";
        StartMoney = money;
        Owner = bank;
    }
    @Override
    public void steppingOnIt(Player player) {
        player.Money += (2*StartMoney);
    }
    public void passIt(Player player){
        player.Money += StartMoney;
    }
    public void setStartMoney(short startMoney) {
        StartMoney = startMoney;
    }
}
