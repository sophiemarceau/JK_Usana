package com.sophiemarceau_qu.jk.jklibrary.log;


import android.util.Log;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

/**
 * 打印日志堆栈信息
 * File输出
 * 模拟控制台
 */
public class JKLog {
    private static final String JK_LOG_PACKAGE;

    static {
        String className = JKLog.class.getName();
        JK_LOG_PACKAGE = className.substring(0, className.lastIndexOf('.') + 1);
    }

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
        if (config.includeTread()) {
            String threadInfo = JKLogConfig.JK_THREAD_FORMATTER.format(Thread.currentThread());
            sb.append(threadInfo).append("\n");
        }
        if (config.stackTraceDepth() > 0) {
            String stackTrace = JKLogConfig.JK_STACK_TRACE_FORMATTER.format(
                    JKStackTraceUtil.getCroppedRealStackTrack(
                            new Throwable().getStackTrace(), JK_LOG_PACKAGE, config.stackTraceDepth()));
            sb.append(stackTrace).append("\n");
        }
        String body = parseBody(contents, config);
        sb.append(body);
        List<JKLogPrinter> printers = config.printers() != null ?
                Arrays.asList(config.printers())
                : JKLogManager.getInstance().getPrinters();
        if (printers == null) {
            return;
        }
        //打印LOG
        for (JKLogPrinter printer : printers) {
            printer.print(config, type, tag, sb.toString());
        }
    }

    private static String parseBody(@NonNull Object[] contents, @NonNull JKLogConfig config) {
        if (config.injectJsonParser() != null) {
            return config.injectJsonParser().toJson(contents);
        }
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