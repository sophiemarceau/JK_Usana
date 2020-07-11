package com.sophiemarceau_qu.jk.jklibrary.log;

public class JKThreadFormatter implements JKLogFormatter<Thread> {
    @Override
    public String format(Thread data) {
        return "Thread:" + data.getName();
    }
}
