package losexds.minecraftfishingplugin.utils;

public class СalculationSystem {
    public static double Calculation (int level, int XpMax) {
        if (level > 0) {
            double xp;
            xp = XpMax / 10;
            return xp;
        }
        return 0;
    }
}
