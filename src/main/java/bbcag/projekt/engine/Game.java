package bbcag.projekt.engine;

import bbcag.projekt.board.Board;
import bbcag.projekt.board.BoardFactory;
import bbcag.projekt.exception.NotEnoughPlayersException;
import bbcag.projekt.field.*;
import bbcag.projekt.player.Player;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Game
 * the engine as such...
 * this class is a singleton class...
 */
public class Game {
    private static Game instance;
    private Set<GameListener> listeners;
    private List<Player> allPlayers = new ArrayList<>();
    private Player currentPlayer;
    private boolean currentPlayerHasRolledDice;
    private Board board;
    private Player bank = new Player("bank", "#FFFFFF");
    private boolean alertValue;
     /** Game
     * the engine as such...
     * crates the listeners and the board...
     */
    private Game() {
        listeners = new HashSet<>();
        board = BoardFactory.getInstance().createBoard(bank);
    }
    /**getInstance
     * Singleton!
     * @return the instance
     */
    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }
    /**addListener
     * adds new GameListener to the listener set.
     * used in the UI-classes to communicate with the engine
     * @param listener the new listener
     */
    public void addListener(GameListener listener) {
        listeners.add(listener);
    }
    /**addPlayer
     * adds a new player in the allPlayer list, sets the current player and trigger the listener onPlayerAdded
     * @param name  the name of new player
     * @param color the color of the new player
     */
    public void addPlayer(String name, String color) {
        Player player = new Player(name, color);
        allPlayers.add(player);
        currentPlayer = player;
        for (GameListener listener : listeners) {
            listener.onPlayerAdded(player);
        }
    }
    /**getCurrentPlayer
     * @return the current player
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    /**getBank
     * returns a non human player, which is used to own field like the StartField
     * @return the non human player bank
     */
    public Player getBank() {
        return bank;
    }
    /**getPlayerList
     * @return a list with all not death human-player in this session
     */
    public List<Player> getPlayerList() {
        return allPlayers;
    }
    /**getBoard
     * @return the created board-object -> more details in the Game constructor, the BoardFactory class and the Board class
     */
    public Board getBoard() {
        return board;
    }
    /**getFieldsCurrentPlayer
     * @return the fields, owned by the current PLayer
     */
    public List<Field> getFieldsCurrentPlayer() {
        return board.getFieldsByOwner(currentPlayer);
    }
    /**getListHousableFields
     * @return a list with all normalFields
     */
    public List<NormalField> getListHousableFields() {
        List<NormalField> normalFields = new ArrayList<>();
        for (int i = 0; i < board.getFields().size(); i++) {
            if (board.getFields().get(i) instanceof NormalField) {
                normalFields.add((NormalField) (board.getFields().get(i)));
            }
        }
        return normalFields;
    }
    /**getListOfMyHousableFields
     * simpler control
     * @return the fields witch are the current player own -> simpler control
     */
    public List<NormalField> getListOfMyHousableFields() {
        List<NormalField> normalFields = new ArrayList<>();
        for (int i = 0; i < board.getFieldsByOwner(currentPlayer).size(); i++) {
            if (board.getFieldsByOwner(currentPlayer).get(i) instanceof NormalField) {
                normalFields.add((NormalField) board.getFieldsByOwner(currentPlayer).get(i));
            }
        }
        return normalFields;
    }
    /**start
     * Start function to check if there are at least 2 players + listener functions (onStart and on CurrentPlayerChange)
     * @throws NotEnoughPlayersException not enough players
     */
    public void start() throws NotEnoughPlayersException {
        if (allPlayers.size() < 2) {
            throw new NotEnoughPlayersException();
        }
        for (GameListener listener : listeners) {
            listener.onStart();
        }
        for (GameListener listener : listeners) {
            listener.onCurrentPlayerChange(currentPlayer);
        }
    }
    /**message
     * sends a message to the gui, used for things like: playerxy has rolled
     * @param message the message to display in the gui
     */
    public void message(String message) {
        for (GameListener listener : listeners) {
            listener.onMessage(message);
        }
    }
    /**onHotel
     * call the listener onHotel -> ezer control
     */
    public void onHotel() {
        for (GameListener listener : listeners) {
            listener.onHotel();
        }
    }
    /**startDealing
     * call the listener startDealing -> ezer control
     */
    public void startDealing() {
        for (GameListener listener : listeners) {
            listener.onStartDealing(currentPlayer);
        }
    }
    /**onDone
     * calls a listener
     * is used, if a gui action done...
     */
    public void onDone() {
        for (GameListener listener : listeners) {
            listener.onDone();
        }
    }
    /**littleUpdateGUI
     * updates the gui by using the onBuy listener -> this listener was the first, which needs this default set of actions
     */
    public void littleUpdateGUI() {
        for (GameListener listener : listeners) { // listener buy -> includes exactly that, what must
            listener.onBuy(currentPlayer);
        }
    }
    /**onCardShow
     * calls the onCardShow listener
     */
    public void onCardShow() {
        for (GameListener listener : listeners) {
            listener.onCardShow();
        }
    }
    /**nextPlayer
     * tests, if the currentPlayer done with the round
     * if it so, change the current player
     */
    public void nextPlayer() {
        if (currentPlayer.isDeath()) {
            message(currentPlayer.getName() + " hat kein Geld mehr und scheidet darum aus.");
            allPlayers.remove(currentPlayer);
        }
        else if (!currentPlayerHasRolledDice) {
            message(currentPlayer.getName() + " hat den Zug nicht richtig beendet!");
            return;
        }else { message(currentPlayer.getName() + " hat den Zug beendet.");}
        if (allPlayers.size() == 1) {
            for (GameListener listener : listeners) {
                listener.onWin(allPlayers.get(0));
            }
        }
        currentPlayer = allPlayers.get((allPlayers.indexOf(currentPlayer) + 1) % allPlayers.size());
        currentPlayerHasRolledDice = false;
        for (GameListener listener : listeners) {
            listener.onCurrentPlayerChange(currentPlayer);
        }
        message(currentPlayer.getName() + " ist nun dran!");
    }
    /**rollDiceForCurrentPlayer
     * rolls the Dices for the current player, handles the pach-rules, calls the listener and calls the playMove function
     * edit pach-rules here
     */
    public void rollDiceForCurrentPlayer() {
        if (currentPlayerHasRolledDice) {
            message("Du kannst nicht nochmals ziehen!");
            return;
        }
        currentPlayerHasRolledDice = true;
        boolean pach = false;
        int dice1 = Dice.rollDice();
        int dice2 = Dice.rollDice();
        message(currentPlayer.getName() + " hat gewuerfelt.");
        currentPlayer.setCount(currentPlayer.getCount() + 1);
        boolean tester = false;
        if (dice1 == dice2) {
            message("Pach!");
            pach = true;
            if (currentPlayer.getRemainingDaysInPrison() <= 0) {
                currentPlayerHasRolledDice = false;
                if (currentPlayer.getCount() > 2) {
                    currentPlayerHasRolledDice = true;
                    currentPlayer.setRemainingDaysInPrison((byte) 4); // because the playmove hasn't start yet
                    currentPlayer.setPosition((byte) 10); //pos JailFields
                    currentPlayer.setCount(0);
                    tester = true;
                    pach = false;
                    message(currentPlayer.getName() + " hat 3x Pach gewuerfelt und kam ins Gefaengnis.");
                }
            } else {
                pach = false;
            }
            if (!tester && currentPlayer.getRemainingDaysInPrison() > 0) {
                currentPlayer.setRemainingDaysInPrison((byte) 0);
                message(currentPlayer.getName() + " ist aus dem Gefaengnis ausgebrochen.");
            }
        } else {
            currentPlayer.setCount(0);
        }

        for (GameListener listener : listeners) {
            listener.onDicesRolled(dice1, dice2);
        }
        playMove(dice1 + dice2);
        if (pach) message(currentPlayer.getName() + " hat Pach gewuerfelt und ist darum nochmals dran.");
        for (GameListener listener : listeners) {
            listener.onDicesRolled(dice1, dice2);
        }
    }
    //Function Hugi made to move or check where the Player is using the dice result from rollDiceForCurrentPlayer()
    /**playMove
     * function move the Player if necessary or check if the player has remainingDaysInPrison -> wait, if go from 1 to 0 -> pay
     * tests also if the player wins.
     * if the player move in a field will the method passIt with the player (currentPlayer) called.
     * if the player step to the final field, steppingOnIt will called with the player (currentPlayer)
     * @param diceNbr int -> dice1-result + dice2-result
     */
    private void playMove(int diceNbr) {
        if (currentPlayer.getRemainingDaysInPrison() <= 0) {
            byte oldPos = currentPlayer.getPosition();
            currentPlayer.setPosition((byte) ((currentPlayer.getPosition() + diceNbr) % board.size()));
            for (int i = 1; i <= diceNbr; i++) {
                if (i < diceNbr) {
                    board.getFieldByIndex((oldPos + i) % board.size()).passIt(currentPlayer);
                }
                if (i == diceNbr) {
                    board.getFieldByIndex((oldPos + i) % board.size()).steppingOnIt(currentPlayer, diceNbr);
                }
            }
        } else {
            currentPlayer.setRemainingDaysInPrison((byte) (currentPlayer.getRemainingDaysInPrison() - 1));
            if (currentPlayer.getRemainingDaysInPrison() == 0) {
                currentPlayer.setAccountBalance(currentPlayer.getAccountBalance() - 100);
                message(currentPlayer.getName() + " hat sich frei gekauft -100$");
            }
        }
        if (currentPlayer.isDeath()) {
            message(currentPlayer.getName() + " hat kein Geld mehr und scheidet darum aus.");
            allPlayers.remove(currentPlayer);
        }
    }
    /**buyField
     * test, if the player can buy the fiel, on which he is standing and calls the buy method form this field, with the player + calls the onBuy listener and send a message
     */
    public void buyField() {
        if (board.getFieldByIndex(currentPlayer.getPosition()).canBuy()) {
            ((BuyableField) board.getFieldByIndex(currentPlayer.getPosition())).buy(currentPlayer);
            for (GameListener listener : listeners) {
                listener.onBuy(currentPlayer);
            }
            message(currentPlayer.getName() + " hat " + board.getFieldByIndex(currentPlayer.getPosition()).getName() + " fuer " + board.getFieldByIndex(currentPlayer.getPosition()).getWorth() + "$ gekauft");
        }
    }
    /**buildHouse
     * tests, if a field has les, than 5 houses and if it own by the currentPlayer, if true it test, if the current player have all Fields of the group, if that is also true:
     * it increment 1 to the hotel-value from the field and reduce the player accountbalance by the worth of the house / hotel
     * finally the listener onHotel gets called and a message gets created
     * @param field the selected field
     */
    public void buildHouse(NormalField field) {
        if (field.getHotel() >= 5 || field.getOwner() != currentPlayer || currentPlayer.getAccountBalance() < field.getWorthHotel()) {
            return;
        }
        int groupIndex = field.getGroupIndex();
        int count = 0;
        for(Field candidate : board.getFieldsByOwner(currentPlayer)){
            if(candidate.getClass() == NormalField.class){
                NormalField parsedCandidat = (NormalField) candidate;
                if(parsedCandidat.getGroupIndex() == groupIndex){
                    count ++;
                }
            }
        }
        if(board.getFieldsByGroup(groupIndex).size() > count){
            message( currentPlayer.toString() + " besitzt leider nicht genug Grundstueke dieser Farbe.");
            return;
        }
        field.setHotel((byte) (field.getHotel() + 1));
        currentPlayer.setAccountBalance(currentPlayer.getAccountBalance() - field.getWorthHotel());
        for (GameListener listener : listeners) {
            listener.onHotel();
        }
        littleUpdateGUI();
        message(field.getName() + ", Haus wurde gebaut");
    }
    /**removeHouse
     * test if the field has more than 0 houses and is own by the current player, if true:
     * it reduce the hotel-value from the field by 1 and adds the half of the worth of a hotel / house to the player accountbalance
     * finally the listener onHotel gets called and a message gets created
     * @param field the selected field
     */
    public void removeHouse(NormalField field) {
        if (field.getHotel() <= 0 || field.getOwner() != currentPlayer) {
            return;
        }
        field.setHotel((byte) (field.getHotel() - 1));
        currentPlayer.setAccountBalance(currentPlayer.getAccountBalance() + field.getWorthHotel() / 2);
        for (GameListener listener : listeners) {
            listener.onHotel();
        }
        message(field.getName() + ", Haus wurde entfernt");
    }
    /**dealMoney
     * <p>
     * test, if any player have enough money to deal with -> if it not so, make a message "Es konnte nicht getauscht werden, ein Player ist zu arm."
     * deal with the money
     * make a message, which player pays which how much...
     * @param p1      player1 (current player)
     * @param moneyP1 money given form player1 to player2
     * @param p2      player2
     * @param moneyP2 money given form player2 to player1
     * @return success
     */
    private boolean dealMoney(Player p1, int moneyP1, Player p2, int moneyP2) {
        if (p1.getAccountBalance() >= moneyP1 && p2.getAccountBalance() >= moneyP2) {
            p1.setAccountBalance(p1.getAccountBalance() + moneyP2 - moneyP1);
            p2.setAccountBalance(p2.getAccountBalance() + moneyP1 - moneyP2);
            if (moneyP1 > moneyP2) {
                message(p1 + " hat " + p2 + " " + (moneyP1 - moneyP2) + "$ gegeben.");
            } else if (moneyP1 < moneyP2) {
                message(p2 + " hat " + p1 + " " + (moneyP2 - moneyP1) + "$ gegeben.");
            }
            return true;
        } else {
            message("Es konnte nicht getauscht werden, ein Player ist zu arm.");
            return false;
        }
    }
    /**dealPlaces
     * <p>
     * changes the owner of the fields and make messages
     * if a modifyOwner fails, it resets the owner of the fields to the sate before
     * @param p1 player1 (current player)
     * @param f1 field of player1
     * @param p2 player2
     * @param f2 field of player2
     * @return success
     */
    private boolean dealPlaces(Player p1, Field f1, Player p2, Field f2) {
        boolean p1Fail = false;
        boolean p2Fail = false;
        if (f1 != null) {
            if (f1.modifyOwner(p1, p2)) {
                message(p1.getName() + " hat " + p2.getName() + " " + f1.getName() + " gegeben");
            } else {
                p1Fail = true;
            }
        }
        if (f2 != null) {
            if (f2.modifyOwner(p2, p1)) {
                message(p2.getName() + " hat " + p1.getName() + " " + f2.getName() + " gegeben");
            } else {
                p2Fail = true;
            }
        }
        if (p1Fail || p2Fail) {
            if (f1 != null) {
                f1.setOwner(p1);
            }
            if (f2 != null) {
                f2.setOwner(p2);
            }
            message("Es konnte leider kein Grundstück getauscht werden.");
            return false;
        }
        return true;
    }
    /**onDeal
     * if the current player = player 2 returns straight
     * <p>
     * first calls dealMoney, if this works, calls dealPlaces, if this fails it redo the money changes
     * finally updates the gui
     * @param player2 the player2
     * @param moneyP1 the money the current player will give to player2
     * @param moneyP2 the money player2 will give to the current player
     * @param fieldP1 the field the current player will give to player2
     * @param fieldP2 the field player2 will give to the current player
     */
    public void onDeal(Player player2, int moneyP1, int moneyP2, Field fieldP1, Field fieldP2) {
        if (player2 == currentPlayer) {
            return;
        }
        message(currentPlayer.getName() + " handelt mit " + player2.getName());
        if (dealMoney(currentPlayer, moneyP1, player2, moneyP2)) { //-> 2 if to simplify the code...
            if (!dealPlaces(currentPlayer, fieldP1, player2, fieldP2)) { //to not create the messages a 2. time
                player2.setAccountBalance(player2.getAccountBalance() + moneyP2 - moneyP1);
                currentPlayer.setAccountBalance(currentPlayer.getAccountBalance() + moneyP1 - moneyP2);
            }
        }
        littleUpdateGUI();
    }
    public void sellFieldToBank(Field field){
        if(field.getOwner() == currentPlayer){
            currentPlayer.setAccountBalance(currentPlayer.getAccountBalance() + field.getWorth() / 2);
            field.setOwner(null);
            message(field.getName() + " wurde für " + field.getWorth() + "$ an die Bank verkauft.");
            littleUpdateGUI();
        }
    }

    public void setAlertValue(boolean alertValue) {
        this.alertValue = alertValue;
    }
}

//todo make jail better... -> make possible to sell free directly...