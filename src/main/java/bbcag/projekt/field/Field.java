package bbcag.projekt.field;


import bbcag.projekt.Player;
import javafx.scene.canvas.GraphicsContext;

public abstract class Field {
    protected Player owner = null;
    protected String name;

    public boolean isCanBuy() {
        return canBuy;
    }

    protected boolean canBuy = false;

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
        return owner;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
