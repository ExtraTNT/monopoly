package bbcag.projekt;
import java.util.Random;

public class Dice {
    private static Random rand = new Random();
    private Dice() {
    }
    public static int rollDice() {
        return rand.nextInt(6) + 1;
    }
}


