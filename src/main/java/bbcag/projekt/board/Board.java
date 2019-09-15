package bbcag.projekt.board;

import bbcag.projekt.player.Player;
import bbcag.projekt.field.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class Board {

    private final List<Field> FIELDS;
    private final Player BANK;

    protected abstract List<Field> createFields();

    /**
     * FIELDS -> all FIELDS from the Board aka the board... xD
     * @param bank the Player who owns all FIELDS that can't be sold to Player
     */
    protected Board(Player bank) {
        this.BANK = bank;
        FIELDS = createFields();
    }

    /**
     * @return BANK, the Player who owns all FIELDS that can't be sold to Player
     */
    protected Player getBank() {
        return BANK;
    }

    public Field getFieldByName(String name) {
        for (Field candidate : FIELDS) {
            if (candidate.getName().equals(name)) {
                return candidate;
            }
        }
        return null;
    }
    public List<Field> getFieldsByOwner(Player owner){
        List fieldshousable = new ArrayList<>();
        for (Field candidate : FIELDS) {
            if(candidate.getOwner() == null){

            }
            else if (candidate.getOwner().equals(owner)){
                fieldshousable.add(candidate);
            }
        }
    return fieldshousable;
    }
    public int getIndexFromField(Field field){
        return FIELDS.indexOf(field);
    }
    public List<Field> getFields() {
        return FIELDS;
    }
    public Field getFieldByIndex(int index){
        return FIELDS.get(index);
    }

    public int size() {
        return FIELDS.size();
    }
}