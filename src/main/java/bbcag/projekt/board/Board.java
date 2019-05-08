package bbcag.projekt.board;

import bbcag.projekt.Player;
import bbcag.projekt.field.Field;

import java.util.List;

public abstract class Board {

    private final List<Field> fields;

    private final Player bank;

    protected Board(Player bank) {
        this.bank = bank;
        fields = createFields();
    }

    protected Player getBank() {
        return bank;
    }

    public Field getFieldByName(String name) {
        for (Field candidate : fields) {
            if (candidate.getName().equals(name)) {
                return candidate;
            }
        }

        return null;
    }

    protected abstract List<Field> createFields();
}
