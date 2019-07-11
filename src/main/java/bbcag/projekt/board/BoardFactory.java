package bbcag.projekt.board;

import bbcag.projekt.Player;
import bbcag.projekt.config.Confiuration;

public class BoardFactory {

    private static final String CONFIG_KEY = "board.type";

    private static BoardFactory instance;

    private BoardFactory() {
    }

    public Board createBoard(Player bank) {
        String type = Confiuration.getInstance().get(CONFIG_KEY);
        switch (type){
            case SwissBoard.NAME:
                return new SwissBoard(bank);
            case FalloutBoard.NAME:
                return new FalloutBoard(bank);
                default:
                    throw new RuntimeException(type + " does not exist");
        }

    }


    public static BoardFactory getInstance() {
        if (instance == null) {
            instance = new BoardFactory();
        }
        return instance;
    }
}
