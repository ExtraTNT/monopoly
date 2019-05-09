package bbcag.projekt;

import bbcag.projekt.board.Board;
import bbcag.projekt.board.BoardFactory;
import bbcag.projekt.exception.NotEnoughPlayersException;

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
    private Player bank = new Player("bank", new Figure("#FFFFFF"));

    private Game() {
        listeners = new HashSet<>();

        board = BoardFactory.getInstance().createBoard(bank);
    }

    public void addListener(GameListener listener) {
        listeners.add(listener);
    }

    public void addPlayer(String name, String color) {
        Player player = new Player(name, new Figure(color));

        allPlayers.add(player);
        currentPlayer = player;

        for (GameListener listener : listeners) {
            listener.onPlayerAdded(player);
        }
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

    public void config() {

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

        for (GameListener listener : listeners) {
            listener.onDicesRolled(dice1, dice2);
        }

        playMove(dice1 + dice2);
    }

    private void playMove(int diceNbr) {
        if (currentPlayer.isDeath()) {
            allPlayers.remove(currentPlayer);

        }

        for (int i = 1; i <= diceNbr; i++) {
            if (i < diceNbr) {
                board.getFieldByIndex((currentPlayer.getPosition() + i) % board.size()).passIt(currentPlayer);
            }
            if (i == diceNbr) {
                board.getFieldByIndex((currentPlayer.getPosition() + i) % board.size()).steppingOnIt(currentPlayer, diceNbr);
            }
        }
        currentPlayer.setPosition((byte) ((currentPlayer.getPosition() + diceNbr) % board.size()));
    }

    public void startDealing() {
        for (GameListener listener : listeners) {
            listener.onStartDealing(currentPlayer);
        }
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }

        return instance;
    }

}
    /*
       __
      <  \
[\\\\\\(\ (:::<======================================-
\<      >  \
 \\    /    |
  `==='____/


___________.__    .__         .__                        __                                                  .___             __  .__    .__                          .___       ___.          .__                                  __                  .__  .__      __  .__                                  .__                                                          __  .__
\__    ___/|  |__ |__| ______ |__| ______   ____   _____/  |_   ___.__. ____  __ _________    ____  ____   __| _/____       _/  |_|  |__ |__| ______   ____  ____   __| _/____   \_ |__   ____ |  |   ____   ____    ____  ______ _/  |_  ____   _____  |  | |  |   _/  |_|  |__   ____  ______ ____   __  _  _|  |__   ____   _____ _______   ____   __  _  ______________/  |_|  |__ ___.__.
  |    |   |  |  \|  |/  ___/ |  |/  ___/  /    \ /  _ \   __\ <   |  |/  _ \|  |  \_  __ \ _/ ___\/  _ \ / __ |/ __ \      \   __\  |  \|  |/  ___/ _/ ___\/  _ \ / __ |/ __ \   | __ \_/ __ \|  |  /  _ \ /    \  / ___\/  ___/ \   __\/  _ \  \__  \ |  | |  |   \   __\  |  \ /  _ \/  ___// __ \  \ \/ \/ /  |  \ /  _ \  \__  \\_  __ \_/ __ \  \ \/ \/ /  _ \_  __ \   __\  |  <   |  |
  |    |   |   Y  \  |\___ \  |  |\___ \  |   |  (  <_> )  |    \___  (  <_> )  |  /|  | \/ \  \__(  <_> ) /_/ \  ___/       |  | |   Y  \  |\___ \  \  \__(  <_> ) /_/ \  ___/   | \_\ \  ___/|  |_(  <_> )   |  \/ /_/  >___ \   |  | (  <_> )  / __ \|  |_|  |__  |  | |   Y  (  <_> )___ \\  ___/   \     /|   Y  (  <_> )  / __ \|  | \/\  ___/   \     (  <_> )  | \/|  | |   Y  \___  |
  |____|   |___|  /__/____  > |__/____  > |___|  /\____/|__|    / ____|\____/|____/ |__|     \___  >____/\____ |\___  > /\   |__| |___|  /__/____  >  \___  >____/\____ |\___  >  |___  /\___  >____/\____/|___|  /\___  /____  >  |__|  \____/  (____  /____/____/  |__| |___|  /\____/____  >\___  >   \/\_/ |___|  /\____/  (____  /__|    \___  >   \/\_/ \____/|__|   |__| |___|  / ____| /\
                \/        \/          \/       \/               \/                               \/           \/    \/  )/             \/        \/       \/           \/    \/       \/     \/                 \//_____/     \/                      \/                       \/           \/     \/               \/              \/            \/                                 \/\/      \/

       __
      <  \
[\\\\\\(\ (:::<======================================-
\<      >  \
 \\    /    |
  `==='____/

     */
