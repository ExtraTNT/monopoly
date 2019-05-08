package bbcag.projekt;

public class Player {
    public byte Position = 0;
    public int Money;
    public byte Days;
    public byte FreeCards;
    public Figure Color;
    public String name;
    public byte works;
    public byte railwayStations;

    public void playMove(){
    }

    public Player(String name, Figure color){
        this.name = name;
        this.Color = color;
    }
    public boolean isDeath(){
        if (Money < 0){
            return true;
        }
        else{
            return false;
        }
    }
}
