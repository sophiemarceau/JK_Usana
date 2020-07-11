package com.sophiemarceau_qu.jk.jklibrary.log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JKLogManager {
    private JKLogConfig config;
    private static JKLogManager instance;
    private List<JKLogPrinter> printers = new ArrayList<>();

    private JKLogManager(JKLogConfig config, JKLogPrinter[] printers) {
        this.config = config;
        this.printers.addAll(Arrays.asList(printers));
    }

    public static JKLogManager getInstance() {
        return instance;
    }

    public static void init(@NonNull JKLogConfig config, JKLogPrinter... printers) {
        instance = new JKLogManager(config, printers);
    }

    public JKLogConfig getConfig() {
        return config;
    }

    public List<JKLogPrinter> getPrinters() {
        return printers;
    }

    public void addPrinter(JKLogPrinter printer) {
        printers.add(printer);
    }

    public void removePrinter(JKLogPrinter printer) {
        if (printers != null) {
            printers.remove(printer);
        }
    }
}
