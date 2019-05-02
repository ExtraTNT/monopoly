package bbcag.projekt;


public abstract class Field {
    protected Player Owner = null;
    protected String name;

    public abstract void steppingOnIt(Player player);
    public void passIt(Player player){
    }

    public Player getOwner() {
        return Owner;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
