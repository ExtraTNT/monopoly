package bbcag.projekt.field;


import bbcag.projekt.GameListener;
import bbcag.projekt.Player;
import javafx.scene.canvas.GraphicsContext;

import java.util.Set;

public abstract class Field {
    protected Player owner = null;
    protected String name;
    protected boolean canBuy = false;
    private Set<GameListener> listeners;
    public boolean canBuy() {
        return canBuy;
    }


    public Field() {
        this(null);
    }

    public abstract int getWorth();

    public Field(Player owner) {
        this.owner = owner;
    }

    public abstract void steppingOnIt(Player player, int rolledSum);

    public void passIt(Player player){
    }

    public Player getOwner() {
        return owner;
    }


    public boolean modifyOwner(Player owner, Player newOwner){
        if(owner == this.owner){
            this.owner = newOwner;
            return true;
        }
        else{
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
