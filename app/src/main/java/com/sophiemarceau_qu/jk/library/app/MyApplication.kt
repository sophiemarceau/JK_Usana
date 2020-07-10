package com.sophiemarceau_qu.app

import android.app.Application
import com.sophiemarceau_qu.jk.jklibrary.log.JKLogConfig
import com.sophiemarceau_qu.jk.jklibrary.log.JKLogManager

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        JKLogManager.init(object : JKLogConfig() {
            override fun getGlobalTag(): String {
                return "MyApplication"
            }

            override fun enable(): Boolean {
                return true
            }
        })
    }
}