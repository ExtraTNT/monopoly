package bbcag.projekt;

public class StartField extends Field {

    public short StartMoney;

    public StartField(short money){
        name = "Start";
        StartMoney = money;
        Owner = Game.getBank();
    }
    @Override
    public void steppingOnIt(Player player) {
    }
    public void passIt(Player player){
    }
}
