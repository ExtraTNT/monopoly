package bbcag.projekt.engine;

import bbcag.projekt.player.Player;

/**GameListener Interface
 * Simple interface which allows the gui to communicate with the engine
 */
public interface GameListener {

    void onStart();

    void onPlayerAdded(Player player);

    void onCurrentPlayerChange(Player player);

    void onDicesRolled(int dice1, int dice2);

    void onStartDealing(Player currentPlayer);

    void onWin(Player winer);

    void onBuy(Player player);

    void onHotel();

    void onDone();

    void onMessage(String message);
}
