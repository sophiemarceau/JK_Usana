package com.sophiemarceau_qu.jk.jklibrary.log;

public abstract class JKLogConfig {
    static int MAX_LEN = 512;
    static JKStackTraceFormatter JK_STACK_TRACE_FORMATTER = new JKStackTraceFormatter();
    static JKThreadFormatter JK_THREAD_FORMATTER = new JKThreadFormatter();

    public JsonParser injectJsonParser() {
        return null;
    }

    public String getGlobalTag() {
        return "JKLog";
    }

    public boolean enable() {
        return true;
    }

    public boolean includeTread() {
        return false;
    }

    public int stackTraceDepth() {
        return 5;
    }

    public JKLogPrinter[] printers() {
        return null;
    }

    public interface JsonParser {
        String toJson(Object src);
    }


}

