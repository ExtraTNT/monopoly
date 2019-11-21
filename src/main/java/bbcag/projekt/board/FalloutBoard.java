package bbcag.projekt.board;

import bbcag.projekt.player.Player;
import bbcag.projekt.field.*;
import java.util.ArrayList;
import java.util.List;

/**FalloutBoard
 * Custom Board by ExtraTNT (and a dude who has uploaded a picture of his custom fallout-monopoly-board)
 */
class FalloutBoard extends Board {

    static final String NAME = "FALLOUT";

    FalloutBoard(Player bank) {
        super(bank);
    }

    @Override
    protected List<Field> createFields() {
        List<Field> fieldList = new ArrayList<>();

        //Free to reconfigure

        fieldList.add(new StartField((short) 400, getBank()));

        fieldList.add(new NormalField("Camp Searchlight", (short) 60, new int[]{2, 10, 30, 90, 160, 250}, 50, 1));

        fieldList.add(new ActionField("Lockpick", getBank()));

        fieldList.add(new NormalField("Vault 22", (short) 60, new int[]{4, 20, 60, 180, 320, 450}, 50, 1));

        fieldList.add(new NormalField("NCR Tax", (short) 0, new int[]{200},0, 0, getBank()));

        fieldList.add(new RailwayField("South NRC Monorail"));
        fieldList.add(new NormalField("Nipton", (short) 100, new int[]{6, 30, 90, 270, 400, 550}, 50, 2));

        fieldList.add(new ActionField("Luck", getBank()));

        fieldList.add(new NormalField("Boulder City", (short) 100, new int[]{6, 30, 90, 270, 400, 550}, 50, 2));
        fieldList.add(new NormalField("Sloan", (short) 120, new int[]{8, 40, 100, 300, 450, 600}, 50, 2));

        fieldList.add(new JailField(getBank()));

        fieldList.add(new NormalField("Goodsprings", (short) 140, new int[]{10, 50, 150, 450, 625, 750},100,3));
        fieldList.add(new NormalField("Primm", (short) 140, new int[]{10, 50, 150, 450, 625, 750},100, 3));
        fieldList.add(new WorkField("Poseidon Energy"));
        fieldList.add(new NormalField("Freeside", (short) 160, new int[]{12, 60, 180, 500, 700, 900},100, 3));
        fieldList.add(new RailwayField("West NCR Monorail"));
        fieldList.add(new NormalField("Novac", (short) 180, new int[]{14, 70, 200, 550, 750, 950},100, 4));
        fieldList.add(new NormalField("188 Traiding Post", (short) 180, new int[]{14, 70, 200, 550, 750, 950},100, 4));

        fieldList.add(new ActionField("Lockpick", getBank()));

        fieldList.add(new NormalField("Sarsaparilla Factory", (short) 200, new int[]{16, 80, 220, 600, 800, 1000},100, 4));

        fieldList.add(new NormalField("Bed", (short) 0, new int[]{-200},0, 0, getBank()));

        fieldList.add(new NormalField("Mojave Outpost", (short) 220, new int[]{18, 90, 250, 700, 875, 1050},150, 5));

        fieldList.add(new ActionField("Luck", getBank()));

        fieldList.add(new NormalField("Heliso One", (short) 220, new int[]{18, 90, 250, 700, 875, 1050},150, 5));
        fieldList.add(new NormalField("Repconn Test Site", (short) 240, new int[]{20, 100, 300, 750, 925, 1100},150, 5));
        fieldList.add(new RailwayField("North NCR Monorail"));
        fieldList.add(new NormalField("Hidden Valley", (short) 260, new int[]{22, 110, 330, 800, 975, 1150},150, 6));
        fieldList.add(new NormalField("Jacob's Town", (short) 260, new int[]{22, 110, 330, 800, 975, 1150},150, 6));
        fieldList.add(new WorkField("Lake Mead"));
        fieldList.add(new NormalField("Gun Runners", (short) 280, new int[]{24, 120, 360, 850, 1025, 1200},150, 6));

        fieldList.add(new PolicemanField(getBank()));

        fieldList.add(new NormalField("Nellis Air Fore Base", (short) 300, new int[]{26, 130, 390, 900, 1100, 1275},200, 7));
        fieldList.add(new NormalField("The Fort", (short) 300, new int[]{26, 130, 390, 900, 1100, 1275},200, 7));

        fieldList.add(new ActionField("Lockpick", getBank()));

        fieldList.add(new NormalField("Camp McCarran", (short) 320, new int[]{28, 150, 450, 1000, 1200, 1400},200, 7));
        fieldList.add(new RailwayField("East NCR Monorail"));

        fieldList.add(new ActionField("Luck", getBank()));

        fieldList.add(new NormalField("Hoover Dam", (short) 350, new int[]{35, 175, 500, 1100, 1300, 1500},200, 8));

        fieldList.add(new NormalField("Strip Credit Check", (short) 0, new int[]{75},0,0, getBank()));

        fieldList.add(new NormalField("The Strip", (short) 400, new int[]{50, 200, 600, 1400, 1700, 2000},200, 8));

        return fieldList;
    }
}