package bbcag.projekt.board;

import bbcag.projekt.ActionField;
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

        fieldList.add(new StartField((short) 400, getBank())); //start extension... (opt)

        fieldList.add(new NormalField("Chur, Kornplatz", (short) 60, new int[]{1, 2, 3, 4, 5, 6}));

        fieldList.add(new ActionField("Kanzlei", getBank()));

        fieldList.add(new NormalField("Schaffhausen, Vordergasse", (short) 60, new int[]{1, 2, 3, 4, 5, 6}));

        fieldList.add(new NormalField("Einkommenssteuer", (short) 0, new int[]{200}, getBank()));

        fieldList.add(new RailwayField("Vereinigte Privatbahnen"));
        fieldList.add(new NormalField("Arrau, Rathausplatz", (short) 100, new int[]{1, 2, 3, 4, 5, 6}));

        fieldList.add(new ActionField("Chance", getBank()));

        fieldList.add(new NormalField("Neuenburg, Place Pury", (short) 100, new int[]{1, 2, 3, 4, 5, 6}));
        fieldList.add(new NormalField("Thun, Hauptgasse", (short) 120, new int[]{1, 2, 3, 4, 5, 6}));

        fieldList.add(new JailField(getBank()));

        fieldList.add(new NormalField("Basel, Steinen-Vorstadt", (short) 140, new int[]{1, 2, 3, 4, 5, 6}));
        fieldList.add(new WorkField("Elektrizitätswerk"));
        fieldList.add(new NormalField("Solothurn, Hauptgasse", (short) 140, new int[]{1, 2, 3, 4, 5, 6}));
        fieldList.add(new NormalField("Lugano, Via Nassa", (short) 160, new int[]{1, 2, 3, 4, 5, 6}));
        fieldList.add(new RailwayField("Vereinigte Bergbahnen"));
        fieldList.add(new NormalField("Biel Nidaugasse", (short) 180, new int[]{1, 2, 3, 4, 5, 6}));

        fieldList.add(new ActionField("Kanzlei", getBank()));

        fieldList.add(new NormalField("Freiburg, Bahnofstrasse", (short) 180, new int[]{1, 2, 3, 4, 5, 6}));
        fieldList.add(new NormalField("La Chaux-de-Fonds", (short) 200, new int[]{1, 2, 3, 4, 5, 6}));

        fieldList.add(new NormalField("Freier Parkplatz", (short) 0, new int[]{-200}, getBank()));

        fieldList.add(new NormalField("Winterthur, Bahnhofplatz", (short) 220, new int[]{1, 2, 3, 4, 5, 6}));

        fieldList.add(new ActionField("Chance", getBank()));

        fieldList.add(new NormalField("St Gallen, Marktplatz", (short) 220, new int[]{1, 2, 3, 4, 5, 6}));
        fieldList.add(new NormalField("Bern, bundesplatz", (short) 240, new int[]{1, 2, 3, 4, 5, 6}));
        fieldList.add(new RailwayField("Ueberlandbahnen"));
        fieldList.add(new NormalField("Luzern, Weggisgasse", (short) 260, new int[]{1, 2, 3, 4, 5, 6}));
        fieldList.add(new NormalField("Zuerich, Rennweg", (short) 260, new int[]{1, 2, 3, 4, 5, 6}));
        fieldList.add(new WorkField("Wasserwerk"));
        fieldList.add(new NormalField("Lausanne, Rue de Bourg", (short) 280, new int[]{1, 2, 3, 4, 5, 6}));

        fieldList.add(new JailField(getBank()));

        fieldList.add(new NormalField("Basel, Freie Strasse", (short) 300, new int[]{1, 2, 3, 4, 5, 6}));
        fieldList.add(new NormalField("Genf, Rue de la Croix-d'or", (short) 300, new int[]{1, 2, 3, 4, 5, 6}));

        fieldList.add(new ActionField("Kanzlei", getBank()));

        fieldList.add(new NormalField("Bern, Spitalgasse", (short) 320, new int[]{1, 2, 3, 4, 5, 6}));
        fieldList.add(new RailwayField("Vereinigte Schwebebahnen"));

        fieldList.add(new ActionField("Chance", getBank()));

        fieldList.add(new NormalField("Lausanne, Place St. Franços", (short) 350, new int[]{1, 2, 3, 4, 5, 6}));

        fieldList.add(new NormalField("Nachsteuer", (short) 0, new int[]{100}, getBank()));

        fieldList.add(new NormalField("Zuerich, Paradeplatz", (short) 400, new int[]{1, 2, 3, 4, 5, 6}));

        return fieldList;
    }
}
