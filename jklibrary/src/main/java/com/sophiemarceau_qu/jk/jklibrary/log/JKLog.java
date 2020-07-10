package com.sophiemarceau_qu.jk.jklibrary.log;


import android.util.Log;

import androidx.annotation.NonNull;

/**
 * 打印日志堆栈信息
 * File输出
 * 模拟控制台
 */
public class JKLog {
    public static void v(Object... contents) {
        log(JKLogType.V, contents);
    }

    public static void vt(String tag, Object... contents) {
        log(JKLogType.V, tag, contents);
    }

    public static void d(Object... contents) {
        log(JKLogType.D, contents);
    }

    public static void dt(String tag, Object... contents) {
        log(JKLogType.D, tag, contents);
    }

    public static void i(Object... contents) {
        log(JKLogType.I, contents);
    }

    public static void it(String tag, Object... contents) {
        log(JKLogType.I, tag, contents);
    }

    public static void w(Object... contents) {
        log(JKLogType.W, contents);
    }

    public static void wt(String tag, Object... contents) {
        log(JKLogType.W, tag, contents);
    }

    public static void e(Object... contents) {
        log(JKLogType.E, contents);
    }

    public static void et(String tag, Object... contents) {
        log(JKLogType.E, tag, contents);
    }

    public static void a(Object... contents) {
        log(JKLogType.A, contents);
    }

    public static void at(String tag, Object... contents) {
        log(JKLogType.A, tag, contents);
    }

    public static void log(@JKLogType.TYPE int type, Object... contents) {
        log(type, JKLogManager.getInstance().getConfig().getGlobalTag(), contents);
    }

    public static void log(@JKLogType.TYPE int type, @NonNull String tag, Object... contents) {
        log(JKLogManager.getInstance().getConfig(), type, tag, contents);
    }

    public static void log(@NonNull JKLogConfig config, @JKLogType.TYPE int type, @NonNull String tag, Object... contents) {
        if (!config.enable()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        String body = parseBody(contents);
        sb.append(body);
        Log.println(type, tag, body);
    }

    private static String parseBody(@NonNull Object[] contents) {
        StringBuilder sb = new StringBuilder();
        for (Object o : contents) {
            sb.append(o.toString()).append(";");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}