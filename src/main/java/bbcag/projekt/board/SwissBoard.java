package bbcag.projekt.board;

import bbcag.projekt.field.ActionField;
import bbcag.projekt.Player;
import bbcag.projekt.field.*;

import java.util.ArrayList;
import java.util.List;

class SwissBoard extends Board {

    protected static final String NAME = "SWISS";

    protected SwissBoard(Player bank) {
        super(bank);
    }

    @Override
    protected List<Field> createFields() {
        List<Field> fieldList = new ArrayList<>();

        //Free to reconfigure

        fieldList.add(new StartField((short) 400, getBank()));

        fieldList.add(new NormalField("Chur, Kornplatz", (short) 60, new int[]{2, 10, 30, 90, 160, 250}, 50));

        fieldList.add(new ActionField("Kanzlei", getBank()));

        fieldList.add(new NormalField("Schaffhausen, Vordergasse", (short) 60, new int[]{4, 20, 60, 180, 320, 450}, 50));

        fieldList.add(new NormalField("Einkommenssteuer", (short) 0, new int[]{200},0, getBank()));

        fieldList.add(new RailwayField("Vereinigte Privatbahnen"));
        fieldList.add(new NormalField("Arrau, Rathausplatz", (short) 100, new int[]{6, 30, 90, 270, 400, 550}, 50));

        fieldList.add(new ActionField("Chance", getBank()));

        fieldList.add(new NormalField("Neuenburg, Place Pury", (short) 100, new int[]{6, 30, 90, 270, 400, 550}, 50));
        fieldList.add(new NormalField("Thun, Hauptgasse", (short) 120, new int[]{8, 40, 100, 300, 450, 600}, 50));

        fieldList.add(new JailField(getBank()));

        fieldList.add(new NormalField("Basel, Steinen-Vorstadt", (short) 140, new int[]{10, 50, 150, 450, 625, 750},100));
        fieldList.add(new WorkField("Elektrizitätswerk"));
        fieldList.add(new NormalField("Solothurn, Hauptgasse", (short) 140, new int[]{10, 50, 150, 450, 625, 750},100));
        fieldList.add(new NormalField("Lugano, Via Nassa", (short) 160, new int[]{12, 60, 180, 500, 700, 900},100));
        fieldList.add(new RailwayField("Vereinigte Bergbahnen"));
        fieldList.add(new NormalField("Biel Nidaugasse", (short) 180, new int[]{14, 70, 200, 550, 750, 950},100));

        fieldList.add(new ActionField("Kanzlei", getBank()));

        fieldList.add(new NormalField("Freiburg, Bahnofstrasse", (short) 180, new int[]{14, 70, 200, 550, 750, 950},100));
        fieldList.add(new NormalField("La Chaux-de-Fonds", (short) 200, new int[]{16, 80, 220, 600, 800, 1000},100));

        fieldList.add(new NormalField("Freier Parkplatz", (short) 0, new int[]{-200},0, getBank()));

        fieldList.add(new NormalField("Winterthur, Bahnhofplatz", (short) 220, new int[]{18, 90, 250, 700, 875, 1050},150));

        fieldList.add(new ActionField("Chance", getBank()));

        fieldList.add(new NormalField("St Gallen, Marktplatz", (short) 220, new int[]{18, 90, 250, 700, 875, 1050},150));
        fieldList.add(new NormalField("Bern, bundesplatz", (short) 240, new int[]{20, 100, 300, 750, 925, 1100},150));
        fieldList.add(new RailwayField("Ueberlandbahnen"));
        fieldList.add(new NormalField("Luzern, Weggisgasse", (short) 260, new int[]{22, 110, 330, 800, 975, 1150},150));
        fieldList.add(new NormalField("Zuerich, Rennweg", (short) 260, new int[]{22, 110, 330, 800, 975, 1150},150));
        fieldList.add(new WorkField("Wasserwerk"));
        fieldList.add(new NormalField("Lausanne, Rue de Bourg", (short) 280, new int[]{24, 120, 360, 850, 1025, 1200},150));

        fieldList.add(new PolicemanField(getBank()));

        fieldList.add(new NormalField("Basel, Freie Strasse", (short) 300, new int[]{26, 130, 390, 900, 1100, 1275},200));
        fieldList.add(new NormalField("Genf, Rue de la Croix-d'or", (short) 300, new int[]{26, 130, 390, 900, 1100, 1275},200));

        fieldList.add(new ActionField("Kanzlei", getBank()));

        fieldList.add(new NormalField("Bern, Spitalgasse", (short) 320, new int[]{28, 150, 450, 1000, 1200, 1400},200));
        fieldList.add(new RailwayField("Vereinigte Schwebebahnen"));

        fieldList.add(new ActionField("Chance", getBank()));

        fieldList.add(new NormalField("Lausanne, Place St. Franços", (short) 350, new int[]{35, 175, 500, 1100, 1300, 1500},200));

        fieldList.add(new NormalField("Nachsteuer", (short) 0, new int[]{100},0, getBank()));

        fieldList.add(new NormalField("Zuerich, Paradeplatz", (short) 400, new int[]{50, 200, 600, 1400, 1700, 2000},200));

        return fieldList;
    }
}
