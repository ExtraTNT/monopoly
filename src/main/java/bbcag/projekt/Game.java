package bbcag.projekt;

import bbcag.projekt.board.Board;
import bbcag.projekt.board.BoardFactory;
import bbcag.projekt.exception.NotEnoughPlayersException;
import bbcag.projekt.field.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    private static Game instance;

    private Set<GameListener> listeners;

    private List<Player> allPlayers = new ArrayList<>();



    private Player currentPlayer;
    private boolean currentPlayerHasRolledDice;

    private Board board;
    private Player bank = new Player("bank", "#FFFFFF");

    private Game() {
        listeners = new HashSet<>();

        board = BoardFactory.getInstance().createBoard(bank);
    }

    public void addListener(GameListener listener) {
        listeners.add(listener);
    }

    public void addPlayer(String name, String color) {
        Player player = new Player(name, color);

        allPlayers.add(player);
        currentPlayer = player;

        for (GameListener listener : listeners) {
            listener.onPlayerAdded(player);
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public Player getBank() {
        return bank;
    }

    public List<Player> getPlayerList() {
        return allPlayers;
    }

    public void setPlayerList(List<Player> playermap) {
        allPlayers = playermap;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }


    //Start function to check if there are at least 2 players + listener functions
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

    public void onDone() {
        for(GameListener listener : listeners) {
                listener.onDone();
        }
    }


    public void nextPlayer() {
        if (!currentPlayerHasRolledDice) {
            return;
        }

        currentPlayer = allPlayers.get((allPlayers.indexOf(currentPlayer) + 1) % allPlayers.size());
        currentPlayerHasRolledDice = false;

        for (GameListener listener : listeners) {
            listener.onCurrentPlayerChange(currentPlayer);
        }
    }

    public void rollDiceForCurrentPlayer() {
        if(currentPlayerHasRolledDice){
            return;
        }
        currentPlayerHasRolledDice = true;

        int dice1 = Dice.rollDice();
        int dice2 = Dice.rollDice();

        if(dice1 == dice2){
            currentPlayer.setRemainingDaysInPrison((byte)0);
        }

        for (GameListener listener : listeners) {
            listener.onDicesRolled(dice1, dice2);
        }

        playMove(dice1 + dice2);

        for (GameListener listener : listeners) {
            listener.onDicesRolled(dice1, dice2);
        }
    }

    public void buyField(){
        if(board.getFieldByIndex(currentPlayer.getPosition()).canBuy()){
            ((BuyableField) board.getFieldByIndex(currentPlayer.getPosition())).buy(currentPlayer);
            for (GameListener listener : listeners) {
                listener.onBuy(currentPlayer);
            }
        }
    }

    public void setOnHotel(){
        for(GameListener listener : listeners){
            listener.onHotel();
        }
    }

    //Function Hugi made to move or check where the Player is using the dice result from rollDiceForCurrentPlayer()
    public void playMove(int diceNbr) {
        if (currentPlayer.isDeath()) {
            allPlayers.remove(currentPlayer);
            if(allPlayers.size() == 1){
                for (GameListener listener : listeners) {
                    listener.onWin(allPlayers.get(0));
                }

            }
        }
        if(currentPlayer.getRemainingDaysInPrison() == 0) {
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
        }
        else {
            currentPlayer.setRemainingDaysInPrison((byte)(currentPlayer.getRemainingDaysInPrison()-1));
            if(currentPlayer.getRemainingDaysInPrison() == 0){
                currentPlayer.setAccountBalance(currentPlayer.getAccountBalance()-100);
            }
        }


    }

    public void onHotel() {
        for(GameListener listener : listeners) {
            listener.onHotel();
        }
    }


    public void startDealing() {
        for (GameListener listener : listeners) {
            listener.onStartDealing(currentPlayer);
        }
    }

    public List<NormalField> getListOfMyHousableFields(){

        List<NormalField> normalFields = new ArrayList<>();
        for(int i = 0; i < board.getFieldsByOwner(currentPlayer).size(); i++){
            if(board.getFieldsByOwner(currentPlayer).get(i) instanceof NormalField) {
                normalFields.add((NormalField) board.getFieldsByOwner(currentPlayer).get(i));
            }
        }
        return normalFields;
    }

    public List<NormalField> getListHousableFields(){
        List<NormalField> normalFields = new ArrayList<>();
        for(int i = 0; i < board.getFields().size(); i++){
            if(board.getFields().get(i) instanceof NormalField) {
                normalFields.add((NormalField)(board.getFields().get(i)));
            }
        }
        return normalFields;

    }

    public void buildHouse(NormalField field){
        if(field.getHotel() >= 5){
            return;
        }
        field.setHotel((byte)(field.getHotel() + 1));
        currentPlayer.setAccountBalance(currentPlayer.getAccountBalance() - field.getWorthHotel());
        for (GameListener listener : listeners) {
            listener.onHotel();
        }
    }

    public void removeHotel(NormalField field){
        if(field.getHotel() <= 0){
            return;
        }
        field.setHotel((byte)(field.getHotel() - 1));
        currentPlayer.setAccountBalance(currentPlayer.getAccountBalance() + field.getWorthHotel()/2);
        for (GameListener listener : listeners) {
            listener.onHotel();
        }
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }

        return instance;
    }

}
