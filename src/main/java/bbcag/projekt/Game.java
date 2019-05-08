package bbcag.projekt;

import bbcag.projekt.board.Board;
import bbcag.projekt.board.BoardFactory;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private Game() {
        board = BoardFactory.getInstance().createBoard(bank);
    }

    private static Game instance;

    private Map<String, Player> playerMap = new HashMap<String, Player>();

    private Board board;

    private Player bank = new Player();

    public Player getBank() {
        return bank;
    }

    public Map<String, Player> getPlayerMap() {
        return playerMap;
    }

    public void setPlayerMap(Map<String, Player> playermap) {
        playerMap = playermap;
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
