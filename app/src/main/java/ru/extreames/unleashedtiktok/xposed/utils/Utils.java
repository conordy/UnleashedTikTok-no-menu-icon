package ru.extreames.unleashedtiktok.xposed.utils;

import android.util.Log;

public class Utils {
    public enum DEBUG_LEVEL {
        INFO,
        WARNING,
        ERROR
    }

    public static void log(DEBUG_LEVEL level, String text) {
        Log.i("UnleashedTikTok", "[ UnleashedTikTok ] [ " + level + " ] " + text);
    }
}
