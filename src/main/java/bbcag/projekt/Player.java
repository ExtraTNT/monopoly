package bbcag.projekt;

public class Player {
    public byte Position;
    public int Money;
    public byte Days;
    public byte FreeCards;
    public Figure Color;
    public String name;

    public void playMove(){
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
