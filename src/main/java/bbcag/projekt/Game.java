package bbcag.projekt;

import bbcag.projekt.board.Board;
import bbcag.projekt.board.BoardFactory;
import bbcag.projekt.UI;


import java.util.ArrayList;
import java.util.List;

public class Game {
    private Game() {
        board = BoardFactory.getInstance().createBoard(bank);
        //allPlayer.add(new Player("test", new Figure())); DEBUG
        //Player currentPlayer = allPlayer.get(0); DEBUG
    }
    List<Player> allPlayer = new ArrayList<>();
    Player currentPlayer;

    private static Game instance;

    private Board board;
    private Player bank = new Player("bank", new Figure());
    public Player getBank() {
        return bank;
    }
    public List<Player> getPlayerList() {
        return allPlayer;
    }
    public void setPlayerList(List<Player> playermap) {
        allPlayer = playermap;
    }
    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }

        return instance;
    }

    public void start() {
    }

    public void config() {
        //while

    }
    public void playMove(int diceNbr) {
        if (currentPlayer.isDeath()){
            allPlayer.remove(currentPlayer);

        }

        for (int i = 1; i <= diceNbr; i++) {
            if(i < diceNbr) {
                board.getFieldByIndex((currentPlayer.Position + i) % board.size()).passIt(currentPlayer);
            }
            if (i == diceNbr){
                board.getFieldByIndex((currentPlayer.Position + i) % board.size()).steppingOnIt(currentPlayer);
            }
        }
        currentPlayer.Position = (byte) ((currentPlayer.Position + diceNbr) % board.size());
    }

    public void nextPlayer() {
        currentPlayer.roll = true;
        currentPlayer = allPlayer.get((allPlayer.indexOf(currentPlayer) + 1) % allPlayer.size());
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
