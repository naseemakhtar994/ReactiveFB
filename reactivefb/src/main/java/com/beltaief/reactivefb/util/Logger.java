package com.beltaief.reactivefb.util;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

public final class Logger {

    private static boolean DEBUG = false;
    private static boolean DEBUG_WITH_STACKTRACE = false;

    private Logger() {
    }

    public static <T> void logInfo(Class<T> cls, String message) {
        if (DEBUG || DEBUG_WITH_STACKTRACE) {
            String tag = cls.getName();
            Log.i(tag, "-----");
            Log.i(tag, LogType.INFO + ": " + message);

            if (DEBUG_WITH_STACKTRACE) {
                Log.i(tag, getStackTrace());
            }
        }
    }

    public static <T> void logWarning(Class<T> cls, String message) {
        if (DEBUG || DEBUG_WITH_STACKTRACE) {
            String tag = cls.getName();
            Log.w(tag, "-----");
            Log.w(tag, LogType.WARNING + ": " + message);

            if (DEBUG_WITH_STACKTRACE) {
                Log.w(tag, getStackTrace());
            }
        }
    }

    public static <T> void logError(Class<T> cls, String message) {
        if (DEBUG || DEBUG_WITH_STACKTRACE) {
            String tag = cls.getName();
            Log.e(tag, "-----");
            Log.e(tag, LogType.ERROR + ": " + message);

            if (DEBUG_WITH_STACKTRACE) {
                Log.e(tag, getStackTrace());
            }
        }
    }

    public static <T> void logError(Class<T> cls, String message, Throwable e) {
        if (DEBUG || DEBUG_WITH_STACKTRACE) {
            String tag = cls.getName();
            Log.e(tag, "-----");
            Log.e(tag, LogType.ERROR + ": " + message, e);

            if (DEBUG_WITH_STACKTRACE) {
                Log.e(tag, getStackTrace());
            }
        }
    }

    private enum LogType {
        INFO,
        WARNING,
        ERROR
    }

    private static String getStackTrace() {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        new Throwable().printStackTrace(pw);
        return sw.toString();
    }
}
