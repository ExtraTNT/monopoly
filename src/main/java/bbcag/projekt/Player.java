package bbcag.projekt;

public class Player {
    private String name;
    private int accountBalance = 1500;
    private Figure figure;
    private byte position = 0;
    private byte remainingDaysInPrison;

    private int pach = 0;
    private int rolled = 0;
    private byte freeCards;


    public Player(String name, Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    public boolean isDeath() {
        if (accountBalance < 0) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public byte getPosition() {
        return position;
    }

    public void setPosition(byte position) {
        this.position = position;
    }

    public byte getRemainingDaysInPrison() {
        return remainingDaysInPrison;
    }

    public void setRemainingDaysInPrison(byte remainingDaysInPrison) {
        this.remainingDaysInPrison = remainingDaysInPrison;
    }
}
