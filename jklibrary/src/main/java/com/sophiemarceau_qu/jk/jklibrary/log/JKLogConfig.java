package com.sophiemarceau_qu.jk.jklibrary.log;

public abstract class JKLogConfig {
    public String getGlobalTag() {
        return "JKLog";
    }

    public boolean enable() {
        return true;
    }
}

