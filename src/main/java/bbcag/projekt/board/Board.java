package bbcag.projekt.board;

import bbcag.projekt.player.Player;
import bbcag.projekt.field.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class Board {

    private final List<Field> FIELDS;
    private final Player BANK;

    /**createFields
     * creates a list with all fields and return it
     * @return a list with all fields
     */
    protected abstract List<Field> createFields();

    /**Board
     * FIELDS -> all FIELDS from the Board aka the board... xD
     * @param bank the Player who owns all FIELDS which can't be sold to Player
     */
    Board(Player bank) {
        this.BANK = bank;
        FIELDS = createFields();
    }

    /**getBank
     * @return BANK, the Player who owns all FIELDS that can't be sold to Player
     */
    Player getBank() {
        return BANK;
    }

    /**getFieldByName
     *return field by name
     * @param name the name of the field
     * @return field with name name
     */
    public Field getFieldByName(String name) {
        for (Field candidate : FIELDS) {
            if (candidate.getName().equals(name)) {
                return candidate;
            }
        }
        return null;
    }

    /**ggetFieldsByOwner
     * returns fields by owner
     * @param owner the owner of the field
     * @return field with owner owner
     */
    public List<Field> getFieldsByOwner(Player owner){
        List fieldshousable = new ArrayList<>();
        for (Field candidate : FIELDS) {
            if (candidate.getOwner() != null) {
                if (candidate.getOwner().equals(owner)){
                    fieldshousable.add(candidate);
                }
            }
        }
    return fieldshousable;
    }

    /**getIndexFromField
     * return index of field
     * @param field the field object
     * @return the index of the given field
     */
    public int getIndexFromField(Field field){
        return FIELDS.indexOf(field);
    }

    /**getFields
     * @return a list with all fields
     */
    public List<Field> getFields() {
        return FIELDS;
    }

    /**getFieldByIndex
     * @param index the index of the field
     * @return thef field with index index
     */
    public Field getFieldByIndex(int index){
        return FIELDS.get(index);
    }

    /**size
     * @return the size of the list with the fields -> a little bit useless, because size is always 40
     */
    public int size() {
        return FIELDS.size();
    }
}