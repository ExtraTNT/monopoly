package bbcag.projekt.field;


import bbcag.projekt.player.Player;

public abstract class Field {
    protected Player owner;
    protected String name;
    protected boolean canBuy = false;

    public Field() {
        this(null);
    }
    public Field(Player owner) {
        this.owner = owner;
    }

    public abstract int getWorth();
    public abstract void steppingOnIt(Player player, int rolledSum);

    public boolean canBuy() {
        return canBuy;
    }
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
