package bbcag.projekt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {

    private static Map<String, Player> playerMap = new HashMap<String, Player>();
    private static ArrayList<Field> fieldList = new ArrayList<>();
    private static Map<String, Field> fieldMap = new HashMap<String, Field>();

    private static Player Bank = new Player();
    public static void main(String[] args) {

        System.out.println("\n\n\nTest\n\n");

    }



    public void start(){
    }
    public void config(){

    }

    public static Player getBank() {
        return Bank;
    }

    public static Map<String, Player> getPlayerMap() {
        return playerMap;
    }

    public static void setPlayerMap(Map<String, Player> playermap) {
        playerMap = playermap;
    }

    public static Map<String, Field> getFieldMap() {
        return fieldMap;
    }

    public static void setFieldMap(Map<String, Field> fieldmap) {
        fieldMap = fieldmap;
    }
    public static ArrayList<Field> getFieldList() {
        return fieldList;
    }

    public static void setFieldList(ArrayList<Field> fieldList) {
        Game.fieldList = fieldList;
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
