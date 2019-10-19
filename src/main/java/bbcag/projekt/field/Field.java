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

    /**steppingOnIt
     * define what happens, if a player stepping on this field
     * @param player the current player
     * @param rolledSum the sum the 2 dies, which the player has rolled
     */
    public abstract void steppingOnIt(Player player, int rolledSum);

    public boolean canBuy() {
        return canBuy;
    }
    public void passIt(Player player){
    }
    public Player getOwner() {
        return owner;
    }

    /**modifyOwner
     * sets a new owner, but check first if the player, who the field sells is the owner
     * @param owner player, to check, if the player who the field sells is the owner of it
     * @param newOwner the new owner (player)
     * @return boolean, if it was successful
     */
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

    /**setOwner
     * sets the owner of this field -> force it
     * @param owner the owner of the field
     */
    public void setOwner(Player owner) {
        this.owner = owner;
    }
    @Override
    public String toString() {
        return this.getName();
    }
}
