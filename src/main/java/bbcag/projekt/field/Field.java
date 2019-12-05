package bbcag.projekt.field;

import bbcag.projekt.player.Player;

public abstract class Field {
    Player owner;
    protected String name;
    boolean canBuy = false;
    /**Field
     * every Field on the Board
     */
    public Field() {
        this(null);
    }
    /**Field
     * @param owner if the field is owned by the bank... (like the StartField)
     */
    public Field(Player owner) {
        this.owner = owner;
    }
    /**getWorth
     * @return the worth of the field (how much it cost)
     */
    public abstract int getWorth();
    /**steppingOnIt
     * define what happens, if a player stepping on this field
     * @param player the current player
     * @param rolledSum the sum of the 2 dies, which the player has rolled
     */
    public abstract void steppingOnIt(Player player, int rolledSum);
    /**canBuy
     * @return if the field is buyable at the time
     */
    public boolean canBuy() {
        return canBuy;
    }
    /**passIt
     * define what happens, if you step over this field (mostly nothing...)
     * @param player the current player
     */
    public void passIt(Player player){}
    /**getOwner
     * @return the owner of this Field
     */
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
        else{ return false; }
    }
    /**getName
     * @return the name -> is better to different toString and getName, but it do exactly the same...
     */
    public String getName() {
        return name;
    }
    /**setName
     * @param name the name of the Field
     */
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
    /**toString
     * @return the name
     */
    @Override
    public String toString() {
        return this.getName();
    }
}