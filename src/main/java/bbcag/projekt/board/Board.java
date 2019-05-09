package bbcag.projekt.board;

import bbcag.projekt.Player;
import bbcag.projekt.field.Field;
import bbcag.projekt.field.NormalField;

import java.util.ArrayList;
import java.util.List;

public abstract class Board {

    private final List<Field> fields;

    private final Player bank;

    protected Board(Player bank) { //Player Bank -> cant buy by a player
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

    public List<Field> getFieldsByOwner(Player owner){
        List fieldshousable = new ArrayList<>();
        for (Field candidate : fields) {
            if(candidate.getOwner().equals(owner)){
                fieldshousable.add(candidate);
            }
        }
    return fieldshousable;
    }

    public Field getFieldByIndex(int index){
        return fields.get(index);
    }


    protected abstract List<Field> createFields();

    public int size() {
        return fields.size();
    }
}
