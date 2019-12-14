package bbcag.projekt.field;

import bbcag.projekt.engine.Game;
import bbcag.projekt.player.Player;

/**ActionField
 * the "random thing" fields
 */
public class ActionField extends Field {
    public ActionField(String name, Player bank){
        owner = bank;
        this.name = name;
    }
    /**getWorth
     * @return the worth of the field == 0
     */
    @Override
    public int getWorth() {
        return 0;
    }
    /**steppingOnIt
     * just a random action like give the player money or move player 3 fields back or what ever.
     * @param player the current player
     * @param rolledSum the sum  of the 2 dies, which the player has rolled
     */
    @Override
    public void steppingOnIt(Player player, int rolledSum) {
            Game.getInstance().message(player.getName() + " ist auf " + this.getName() + " gelandet.");
        int event = (int) (Math.random()*8);
                switch (event){
            case 1: //give money (rolledSum * 3 + 10)
                player.setAccountBalance(player.getAccountBalance() + rolledSum * 3 + 10);
                Game.getInstance().message("Du bekommst die gewuerfelte Zahl * 3 plus 10$. (" + (rolledSum*3+10) + "$)");
                break;
            case 2: //reduce accountBalance by 50
                player.setAccountBalance(player.getAccountBalance()-50);
                Game.getInstance().message("Busse 50$");
                break;
            case 3: //give 100 money
                player.setAccountBalance(player.getAccountBalance() + 100);
                Game.getInstance().message("Bonus 100$");
                break;
            case 4: //police
                player.setPosition((byte)10);
                player.setRemainingDaysInPrison((byte)3);
                Game.getInstance().message("Du wurdest von der Polizei erwischt. Du wurdest nach " + Game.getInstance().getBoard().getFieldByIndex(10) + " gebracht.");
                break;
            case 5: //reduce accountBalance by 10%
                Game.getInstance().message("Zusatzsteuer 10% deines Vermoegens. (" + (player.getAccountBalance()/10) + "$)");
                player.setAccountBalance((player.getAccountBalance()-player.getAccountBalance()/10));
                break;
            case 6: //reduces accountBalance 10, for each normalField the player owns
                int toPay = 0;
                for (Field f :Game.getInstance().getBoard().getFieldsByOwner(player)) {
                    if(f.getClass() == NormalField.class){
                        toPay += 10;
                    }
                }
                player.setAccountBalance(player.getAccountBalance() -toPay);
                Game.getInstance().message("Du laesst deine Strassen und Plaetze reinigen, -10$ pro Strasse oder Platz. (" + toPay + "$)");
                break;
            case 7: // step 3 Fields back
                Game.getInstance().message("Du gehst 3 Felder zurueck!");
                player.setPosition((byte)((player.getPosition() + Game.getInstance().getBoard().size() - 3) % Game.getInstance().getBoard().size()));
                Game.getInstance().getBoard().getFieldByIndex(player.getPosition()).steppingOnIt(player, rolledSum);
                break;
            default: //give money (rolledSum * 5)
                player.setAccountBalance(player.getAccountBalance() + rolledSum * 5);
                Game.getInstance().message("Du kriegst den 5-Fachen wert, von dem was du gewuerfelt hast ausbezahlt. (" + (rolledSum * 5) + "$)");
                break;
        }
    }
}
