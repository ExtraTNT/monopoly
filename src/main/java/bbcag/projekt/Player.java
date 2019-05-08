package bbcag.projekt;

public class Player {
    public int pach = 0;
    public boolean roll = true;
    public int rolled = 0;
    public byte Position = 0;
    public int Money = 1500;
    public byte Days;
    public byte FreeCards;
    public Figure Color;
    public String name;
    public byte works;
    public byte railwayStations;


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
