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
        if(this.Owner == null){
            if(this.Worth < player.Money) {
                if (true)//UI.askBuy {
                    this.buy(player);
                }
            else {
                    //
                }
            }
        }

    public int getRent() {
        return Rent[Hotel];
    }

    private void buy (Player player){
        player.Money = player.Money - this.Worth;
        this.Owner = player;
    }
}
