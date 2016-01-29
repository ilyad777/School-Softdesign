package com.softdesign.school.utils;

import android.util.Log;

public class Lg {

    private static final String PREFIX = "HTC ";
    public static final int LOGCAT_BUFFER_SIZE = 3000;

    public static boolean shouldLog() {
//      return BuildConfig.IS_LOGCAT_LOGGER_ENABLED;
        return true;
    }

    /**
     * <p>Выводит логи заданного уровня</p>
     *
     * @param level Уровень логирования
     * @param tag   Метка лог сообщения
     * @param text  Текст лог сообщения
     */

    private static void wrap(int level, String tag, String text) {
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

    /**
     * Выводит лог на уровне вывода verbose
     */
    public static void v(String tag, String text) {
        wrap(Log.VERBOSE, tag, text);
    }

    /**
     * Выводит лог на уровне вывода warn
     */
    public static void w(String tag, String text) {
        wrap(Log.WARN, tag, text);
    }

    /**
     * Выводит лог на уровне вывода debug
     */
    public static void d(String tag, String text) {
        wrap(Log.DEBUG, tag, text);
    }

    /**
     * Выводит лог на уровне вывода assert
     */
    public static void a(String tag, String text) {
        wrap(Log.ASSERT, tag, text);
    }

    /**
     * Выводит лог на уровне вывода error
     */
    public static void e(String tag, String text) {
        wrap(Log.ERROR, tag, text);
    }

    /**
     * Выводит лог на уровне вывода info
     */
    public static void i(String tag, String text) {
        wrap(Log.INFO, tag, text);
    }
}