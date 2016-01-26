package com.softdesign.school.utils;

import android.util.Log;

public class Lg {

    private static final String PREFIX = "HTC ";
    public static final int LOGCAT_BUFFER_SIZE = 3000;
    public static final int VERBOSE = 2;
    public static final int DEBUG = 3;
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final int ERROR = 6;
    public static final int ASSERT = 7;

    public static boolean shouldLog() {
//      return BuildConfig.IS_LOGCAT_LOGGER_ENABLED;
        return true;
    }

    /**
     * <p>Выводит логи заданного уровня</p>
     *
     * @param level Уровень логирования (Verbose = 2, debug = 3, info = 4,
     *                                      warn = 5, error = 6, assert = 7)
     * @param tag   Метка лог сообщения
     * @param text  Текст лог сообщения
     */

    public static void log(int level, String tag, String text) {
        if (shouldLog()) {
            if (text.length() > LOGCAT_BUFFER_SIZE) {
                String s = text;
                while (s.length() > LOGCAT_BUFFER_SIZE) {
                    String s1 = s.substring(0, LOGCAT_BUFFER_SIZE);
                    s = s.substring(LOGCAT_BUFFER_SIZE);
                    Log.println(level, PREFIX + tag, s1);
                }
                Log.println(level, PREFIX + tag, s);
            } else {
                Log.println(level, PREFIX + tag, text);
            }
        }
    }
}