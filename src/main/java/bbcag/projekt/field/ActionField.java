package bbcag.projekt.field;

import bbcag.projekt.Game;
import bbcag.projekt.GameListener;
import bbcag.projekt.Player;
import bbcag.projekt.board.Board;
import bbcag.projekt.field.Field;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ActionField extends Field {
    public ActionField(String name, Player bank){
        owner = bank;
        this.name = name;
    }

    @Override
    public int getWorth() {
        return 0;
    }

    @Override
    public void steppingOnIt(Player player, int rolledSum) {
            Game.getInstance().message(player.getName() + " ist auf " + this.getName() + " gelandet.");
        //int event = (int) (Math.random()*8);
        int event = 7;
        switch (event){
            case 1:
                player.setAccountBalance(player.getAccountBalance() + rolledSum * 3 + 10);
                Game.getInstance().message("Du bekommst die gewuerfelte Zahl * 3 plus 10$. (" + (rolledSum*3+10) + "$)");
                break;
            case 2:
                player.setAccountBalance(player.getAccountBalance()-50);
                Game.getInstance().message("Busse 50$");
                break;
            case 3:
                player.setAccountBalance(player.getAccountBalance() + 100);
                Game.getInstance().message("Bonus 100$");
                break;
            case 4:
                player.setPosition((byte)10);
                player.setRemainingDaysInPrison((byte)3);
                Game.getInstance().message("Ins Gefaengnis!");
                break;
            case 5:
                Game.getInstance().message("Zusatzsteuer 10% deines Vermoegens. (" + (player.getAccountBalance()/10) + "$)");
                player.setAccountBalance((player.getAccountBalance()-player.getAccountBalance()/10));
                break;
            case 6:
                int toPay = 0;
                for (Field f :Game.getInstance().getBoard().getFieldsByOwner(player)) {
                    if(f.getClass() == NormalField.class){
                        toPay += 10;
                    }
                }
                player.setAccountBalance(player.getAccountBalance() -toPay);
                Game.getInstance().message("Du laesst deine Strassen und Plaetze reinigen, -10$ pro Strasse oder Platz. (" + toPay + "$)");
                break;
            case 7:
                Game.getInstance().message("Du gehst 3 Felder zurueck!");
                player.setPosition((byte)((player.getPosition() + Game.getInstance().getBoard().size() - 3) % Game.getInstance().getBoard().size()));
                Game.getInstance().getBoard().getFieldByIndex(player.getPosition()).steppingOnIt(player, rolledSum);

                break;
            default:
                player.setAccountBalance(player.getAccountBalance() + rolledSum * 5);
                Game.getInstance().message("Du kriegst den 5-Fachen wert, von dem was du gewuefelt hast ausbezahlt. (" + (rolledSum * 5) + "$)");
                break;
        }

    }
}
