package utils;

import constants.DatePatterns;

import java.time.temporal.ChronoUnit;

public class LrcUtils {
    public static void lrc(String lrc,int time) {
        System.out.println();
        System.out.println();
        for (String lrcLine : lrc.split("\n")) {
            String[] split = lrcLine.split("]");
            for (int i = 0; i < split.length; i++) {
                if (split[i].contains("[")) {
                    System.out.print("["+TimeUtil.format(TimeUtil.addTime(TimeUtil.parseDate(split[i].replace("[", "")+"0", DatePatterns.MM_SS_SSS),time, ChronoUnit.MILLIS ), DatePatterns.MM_SS_SS)+"]");
                }else {
                    System.out.print(split[i]);
                }
            }
            System.out.println();
        }
    }
}
