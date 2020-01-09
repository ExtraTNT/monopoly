package bbcag.projekt.board;

import bbcag.projekt.player.Player;
import bbcag.projekt.config.Configuration;

public class BoardFactory {
    private static final String CONFIG_KEY = "board.type";
    private static BoardFactory instance;
    /**BoardFactory
     * it loads the right board...
     * if you want to load an other board, edit the config
     */
    private BoardFactory() {}
    /** createBoard
     * @param bank the bank player object
     * @return the board -> edit the config for an other board
     */
    public Board createBoard(Player bank) {
        String type = Configuration.getInstance().get(CONFIG_KEY);
        switch (type){
            case SwissBoard.NAME:
                return new SwissBoard(bank);
            case FalloutBoard.NAME: //custom board 1
                return new FalloutBoard(bank);
            case DebianBoard.NAME: //special board 2
                return new DebianBoard(bank);
                default: //boar dows not exit
                    throw new RuntimeException(type + " does not exist");
        }
    }
    /**getInstance
     * Singleton
     * @return instance of the class BoardFactory
     */
    public static BoardFactory getInstance() {
        if (instance == null) { instance = new BoardFactory();}
        return instance;
    }
}