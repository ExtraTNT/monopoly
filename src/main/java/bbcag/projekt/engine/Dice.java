package bbcag.projekt.engine;
import java.util.Random;

class Dice {
    private static Random rand = new Random();
    private Dice() {
    }
    static int rollDice() {
        return rand.nextInt(6) + 1;
    }
}


