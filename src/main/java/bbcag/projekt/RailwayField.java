package bbcag.projekt;

public class RailwayField extends Field {

    private short Worth = 200;
    private int[] Rent = new int[]{25, 50, 100, 200};

    public RailwayField(String name){
        this.name = name;
    }
    @Override
    public void steppingOnIt(Player player) {
        if(this.Owner == null){
            if(this.Worth < player.Money) {
                if (true)//UI.askBuy {
                    this.buy(player);
            }
        }
        else {
            player.Money -= this.getRent();
            Owner.Money += this.getRent();
        }
    }

    public int getRent() {
        return Rent[Owner.railwayStations - 1];
    }

    private void buy (Player player){
        player.Money = player.Money - this.Worth;
        this.Owner = player;
        player.railwayStations += 1;
    }
}
