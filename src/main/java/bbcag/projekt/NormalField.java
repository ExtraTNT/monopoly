package bbcag.projekt;

public class NormalField extends Field{
    private short Worth;
    private byte Hotel = 0;
    private int[] Rent;

    public NormalField(String name, short worth, int[] rent){
        this.name = name;
        this.Worth = worth;
        this.Rent = rent;
    }
    @Override
    public void stepingOnIt(Player player) {

    }

    public int getRent() {
        return Rent[Hotel];
    }

    private void buy (Player player){

    }
}
