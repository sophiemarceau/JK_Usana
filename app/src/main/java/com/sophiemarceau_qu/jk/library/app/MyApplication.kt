package com.sophiemarceau_qu.app

import android.app.Application
import com.google.gson.Gson
import com.sophiemarceau_qu.jk.jklibrary.log.JKConsolePrinter
import com.sophiemarceau_qu.jk.jklibrary.log.JKLogConfig
import com.sophiemarceau_qu.jk.jklibrary.log.JKLogManager

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        JKLogManager.init(object : JKLogConfig() {
            override fun injectJsonParser(): JsonParser {
                return JsonParser { src -> Gson().toJson(src) }
            }

            override fun getGlobalTag(): String {
                return "MyApplication"
            }

            override fun enable(): Boolean {
                return true
            }
        }, JKConsolePrinter())
    }
}