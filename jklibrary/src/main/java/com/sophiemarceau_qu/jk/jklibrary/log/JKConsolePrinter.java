package com.sophiemarceau_qu.jk.jklibrary.log;

import android.util.Log;

import androidx.annotation.NonNull;

import static com.sophiemarceau_qu.jk.jklibrary.log.JKLogConfig.MAX_LEN;

public class JKConsolePrinter implements JKLogPrinter {
    @Override
    public void print(@NonNull JKLogConfig config, int level, String tag, @NonNull String printString) {
        int len = printString.length();
        int countOfSub = len / MAX_LEN;
        if (countOfSub > 0) {
            int index = 0;
            for (int i = 0; i < countOfSub; i++) {
                Log.println(level, tag, printString.substring(index, index + MAX_LEN));
                index += MAX_LEN;
            }
            if (index != len) {
                Log.println(level, tag, printString.substring(index, len));
            }
        } else {
            Log.println(level, tag, printString);
        }
    }
}
