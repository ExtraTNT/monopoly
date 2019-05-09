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

/*
        Random rand = new Random();
        int dice1 = 0;
        int dice2 = 0;
        int total = 0;
        int pach = -1;

        while (dice1 == dice2) {
            if (pach == 3) {
                Game.getInstance().currentPlayer.Days = 3;
                Game.getInstance().currentPlayer.Position = 10;
                break;
            }
            pach += 1;
            dice1 = rand.nextInt(2);
            dice1 += 1;
            dice2 = rand.nextInt(2);
            dice2 += 1;
            total += (dice1 + dice2);
            UI.setRollResult(dice1 + " and " + dice2);

        }
        return (total + "");
*/




