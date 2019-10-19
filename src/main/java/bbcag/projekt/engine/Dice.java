package bbcag.projekt.engine;
import java.util.Random;

/**Dice
 *  its just a random-generator which returns a number between 1 and 6
 */
class Dice {
    private static Random rand = new Random();
    private Dice() {
    }

    /**rollDice
     * @return random number between 1 and 6
     */
    static int rollDice() {
        return rand.nextInt(6) + 1;
    }
}


