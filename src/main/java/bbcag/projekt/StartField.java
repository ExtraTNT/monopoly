package bbcag.projekt;

public class StartField extends Field {

    public short StartMoney;

    public StartField(short money){
        name = "Start";
        StartMoney = money;
    }
    @Override
    public void stepingOnIt(Player player) {
    }
    public void passIt(Player player){
    }
}
