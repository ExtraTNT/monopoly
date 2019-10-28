package bbcag.projekt.player;

public class Player {
    private String name;
    private int accountBalance = 1500;
    private String color;
    private byte position = 0;
    private byte remainingDaysInPrison;
    private int count = 0;

    /**Player
     * a object with data in it...
     * @param name the player name
     * @param color the color used in the gui
     */
    public Player(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public boolean isDeath() {return (accountBalance < 0);}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getAccountBalance() {return accountBalance;}
    public void setAccountBalance(int accountBalance) {this.accountBalance = accountBalance;}
    public byte getPosition() {return position;}
    public void setPosition(byte position) {this.position = position;}
    public byte getRemainingDaysInPrison() {return remainingDaysInPrison;}
    public void setRemainingDaysInPrison(byte remainingDaysInPrison) {this.remainingDaysInPrison = remainingDaysInPrison;}
    public String getColor() {return color;}
    public int getCount() {return count;}
    public void setCount(int count) {this.count = count;}
    @Override
    public String toString() {return name;}
}