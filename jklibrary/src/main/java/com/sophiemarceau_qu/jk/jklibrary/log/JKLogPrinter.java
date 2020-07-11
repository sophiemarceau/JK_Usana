package com.sophiemarceau_qu.jk.jklibrary.log;

import androidx.annotation.NonNull;

public interface JKLogPrinter {
    void print(@NonNull JKLogConfig config, int level, String tag, @NonNull String printString);
}
