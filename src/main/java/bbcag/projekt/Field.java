package bbcag.projekt;

public abstract class Field {
    protected String Owner = null;
    protected String name;

    public abstract void stepingOnIt(Player player);
    public void passIt(Player player){
    }

    public String getOwner() {
        return Owner;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
