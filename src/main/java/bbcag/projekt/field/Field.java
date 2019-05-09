package bbcag.projekt.field;


import bbcag.projekt.Player;
import javafx.scene.canvas.GraphicsContext;

public abstract class Field {
    protected Player owner = null;
    protected String name;

    public Field() {
        this(null);
    }

    public Field(Player owner) {
        this.owner = owner;
    }

    public abstract void steppingOnIt(Player player, int rolledSum);
    public void passIt(Player player){
    }

    public Player getOwner() {
        if (owner == null){
            return new Player("debugNotOwner","#000000");
        }
        return owner;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
