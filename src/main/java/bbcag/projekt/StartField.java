package bbcag.projekt;

public class StartField extends Field {

    private short StartMoney;
    public StartField(short money){
        name = "Start";
        StartMoney = money;
        Owner = Game.getBank();
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
