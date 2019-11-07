package bbcag.projekt.engine;

import bbcag.projekt.player.Player;

/**GameListener Interface
 * Simple interface which allows the gui to communicate with the engine
 */
public interface GameListener {
    /**onStart
     *called if the game starts
     */
    void onStart();

    /**onPlayerAdded
     * called if a player gets added
     * @param player the added player
     */
    void onPlayerAdded(Player player);

    /**onCurrentPlayerChange
     * called if the current player change
     * @param player the new current player
     */
    void onCurrentPlayerChange(Player player);

    /**onDicesRolled
     * called if a player rolled the dice
     * @param dice1 dice one
     * @param dice2 dice two
     */
    void onDicesRolled(int dice1, int dice2);

    /**onStartDealing
     * called if a player want to deal with an other
     * @param currentPlayer the current player -> player who want to deal (u know what i mean)
     */
    void onStartDealing(Player currentPlayer);

    /**onWin
     * called if just one player remaining
     * @param winer the last player
     */
    void onWin(Player winer);

    /**onBuy
     * called if something on the gui needs to update
     * @param player the current player
     */
    void onBuy(Player player);

    /**onHotel
     * called if something on the hotelUI change (also to change to the hotelUI)
     */
    void onHotel();

    /**onDone
     * return to the mainUI
     */
    void onDone();

    /**onMessage
     * to throw a message to the UI
     * @param message the message
     */
    void onMessage(String message);
}
