package bbcag.projekt.board;

import bbcag.projekt.field.*;
import bbcag.projekt.player.Player;

import java.util.ArrayList;
import java.util.List;

public class DebianBoard extends Board{

        static final String NAME = "DEBIAN";

    /** DebianBoard
     * a custom board by myself -> I use debian as my os on my notebooks -> I'm programming a lot on my notebooks... -> I really like debian -> I'm free     * @param bank the bank player object
     */
    DebianBoard(Player bank) {
            super(bank);
        }

        @Override
        protected List<Field> createFields() {
            List<Field> fieldList = new ArrayList<>();

            //Free to reconfigure
            //todo values

            fieldList.add(new StartField((short) 400, getBank(), "Reboot"));

            fieldList.add(new NormalField("xrdp", (short) 60, new int[]{2, 10, 30, 90, 160, 250}, 50, 1));

            fieldList.add(new ActionField("Luck", getBank()));

            fieldList.add(new NormalField("ssh", (short) 60, new int[]{4, 20, 60, 180, 320, 450}, 50, 1));

            fieldList.add(new NormalField("Donation", (short) 0, new int[]{200},0, 0, getBank()));

            fieldList.add(new RailwayField("github"));
            fieldList.add(new NormalField("conky", (short) 100, new int[]{6, 30, 90, 270, 400, 550}, 50, 2));

            fieldList.add(new ActionField("Luck", getBank()));

            fieldList.add(new NormalField("htop", (short) 100, new int[]{6, 30, 90, 270, 400, 550}, 50, 2));
            fieldList.add(new NormalField("Monitorix", (short) 120, new int[]{8, 40, 100, 300, 450, 600}, 50, 2));

            fieldList.add(new JailField(getBank(), "Windows"));

            fieldList.add(new NormalField("Image Magic", (short) 140, new int[]{10, 50, 150, 450, 625, 750},100,3));
            fieldList.add(new NormalField("GIMP", (short) 140, new int[]{10, 50, 150, 450, 625, 750},100, 3));
            fieldList.add(new WorkField("Opensource Software"));
            fieldList.add(new NormalField("Inkscape", (short) 160, new int[]{12, 60, 180, 500, 700, 900},100, 3));
            fieldList.add(new RailwayField("Free Software Foundation"));
            fieldList.add(new NormalField("virtual Box", (short) 180, new int[]{14, 70, 200, 550, 750, 950},100, 4));
            fieldList.add(new NormalField("vmWare Workstation", (short) 180, new int[]{14, 70, 200, 550, 750, 950},100, 4));

            fieldList.add(new ActionField("Luck", getBank()));

            fieldList.add(new NormalField("KVM", (short) 200, new int[]{16, 80, 220, 600, 800, 1000},100, 4));

            fieldList.add(new NormalField("Updates", (short) 0, new int[]{-200},0, 0, getBank()));

            fieldList.add(new NormalField("openbox", (short) 220, new int[]{18, 90, 250, 700, 875, 1050},150, 5));

            fieldList.add(new ActionField("Luck", getBank()));

            fieldList.add(new NormalField("KDE", (short) 220, new int[]{18, 90, 250, 700, 875, 1050},150, 5));
            fieldList.add(new NormalField("i3wm", (short) 240, new int[]{20, 100, 300, 750, 925, 1100},150, 5));
            fieldList.add(new RailwayField("git"));
            fieldList.add(new NormalField("Mozilla Firefox", (short) 260, new int[]{22, 110, 330, 800, 975, 1150},150, 6));
            fieldList.add(new NormalField("torbrowser", (short) 260, new int[]{22, 110, 330, 800, 975, 1150},150, 6));
            fieldList.add(new WorkField("Coffee"));
            fieldList.add(new NormalField("Lynx", (short) 280, new int[]{24, 120, 360, 850, 1025, 1200},150, 6));

            fieldList.add(new PolicemanField(getBank(), "Install windows"));

            fieldList.add(new NormalField("zsh", (short) 300, new int[]{26, 130, 390, 900, 1100, 1275},200, 7));
            fieldList.add(new NormalField("fish", (short) 300, new int[]{26, 130, 390, 900, 1100, 1275},200, 7));

            fieldList.add(new ActionField("Luck", getBank()));

            fieldList.add(new NormalField("bash", (short) 320, new int[]{28, 150, 450, 1000, 1200, 1400},200, 7));
            fieldList.add(new RailwayField("The Linux Foundation"));

            fieldList.add(new ActionField("Luck", getBank()));

            fieldList.add(new NormalField("nano", (short) 350, new int[]{35, 175, 500, 1100, 1300, 1500},200, 8));

            fieldList.add(new NormalField("Donation", (short) 0, new int[]{75},0,0, getBank()));

            fieldList.add(new NormalField("Vim", (short) 400, new int[]{50, 200, 600, 1400, 1700, 2000},200, 8));

            return fieldList;
        }
}
