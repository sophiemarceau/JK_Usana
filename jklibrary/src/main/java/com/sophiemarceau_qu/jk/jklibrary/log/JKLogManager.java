package com.sophiemarceau_qu.jk.jklibrary.log;

import androidx.annotation.NonNull;

public class JKLogManager {
    private JKLogConfig config;
    private static JKLogManager instance;

    private JKLogManager(JKLogConfig config) {
        this.config = config;
    }

    public static JKLogManager getInstance() {
        return instance;
    }

    public static void init(@NonNull JKLogConfig config) {
        instance = new JKLogManager(config);
    }

    public JKLogConfig getConfig() {
        return config;
    }
}
