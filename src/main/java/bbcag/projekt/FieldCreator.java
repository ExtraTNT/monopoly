package bbcag.projekt;

import java.util.HashMap;
import java.util.Map;

public class FieldCreator {
    public void createField(){
        Map<String, Field> fieldMap = new HashMap<String, Field>();

        fieldMap.put("Start", new StartField((short) 400)); //start extension... (opt)
        fieldMap.put("Chur, Kornplatz", new NormalField("Chur, Kornplatz", (short)60, new int[] {1,2,3,4,5,6}));
        fieldMap.put("Kanzlei1", new ActionField("Kanzlei"));
        fieldMap.put("Schaffhausen, Vordergasse", new NormalField("Schaffhausen, Vordergasse", (short) 60, new int[]{1,2,3,4,5,6}));

        fieldMap.put("Einkommenssteuer", new NormalField("Einkommenssteuer", (short) 0, new int[]{200}));
        fieldMap.get("Einkommenssteuer").Owner = Game.getBank();

        fieldMap.put("Vereinigte Privatbahnen", new RailwayField("Vereinigte Privatbahnen"));
        fieldMap.put("Arrau, Rathausplatz", new NormalField("Arrau, Rathausplatz", (short) 100, new int[]{1,2,3,4,5,6}));
        fieldMap.put("Chance1", new ActionField("Chance"));
        fieldMap.put("Neuenburg, Place Pury", new NormalField("Neuenburg, Place Pury", (short) 100, new int[]{1,2,3,4,5,6}));
        fieldMap.put("Thun, Hauptgasse", new NormalField("Thun, Hauptgasse", (short) 120, new int[]{1,2,3,4,5,6}));
        fieldMap.put("Gefängnis / Nur zu Besuch", new SpecialField("Gefängnis / Nur zu Besuch"));
        fieldMap.put("Basel, Steinen-Vorstadt", new NormalField("Basel, Steinen-Vorstadt", (short) 140, new int[]{1,2,3,4,5,6}));
        fieldMap.put("Elektrizitätswerk", new WorkField("Elektrizitätswerk"));
        fieldMap.put("Solothurn, Hauptgasse", new NormalField("Solothurn, Hauptgasse", (short) 140, new int[]{1,2,3,4,5,6}));
        fieldMap.put("Lugano, Via Nassa", new NormalField("Lugano, Via Nassa", (short) 160, new int[]{1,2,3,4,5,6}));
        fieldMap.put("Vereinigte Bergbahnen", new RailwayField("Vereinigte Bergbahnen"));
        fieldMap.put("Biel, Nidaugasse", new NormalField("Biel Nidaugasse", (short) 180, new int[]{1,2,3,4,5,6}));
        fieldMap.put("Kanzlei2", new ActionField("Kanzlei"));
        fieldMap.put("Freiburg, Bahnofstrasse", new NormalField("Freiburg, Bahnofstrasse", (short) 180, new int[]{1,2,3,4,5,6}));
        fieldMap.put("La Chaux-de-Fonds", new NormalField("La Chaux-de-Fonds", (short) 200, new int[]{1,2,3,4,5,6}));

        fieldMap.put("Freier Parkplatz", new NormalField("Freier Parkplatz", (short) 0, new int[]{-200}));
        fieldMap.get("Freier Parkplatz").Owner = Game.getBank();

        fieldMap.put("Winterthur, Bahnhofplatz", new NormalField("Winterthur, Bahnhofplatz", (short) 220, new int[]{1,2,3,4,5,6}));
        fieldMap.put("Chance2", new ActionField("Chance"));
        fieldMap.put("St Gallen, Marktplatz", new NormalField("St Gallen, Marktplatz", (short) 220, new int[]{1,2,3,4,5,6}));
        fieldMap.put("Bern, Bundesplatz", new NormalField("Bernbundesplatz", (short) 240, new int[]{1,2,3,4,5,6}));


        Game.setFieldMap(fieldMap);
    }
}
