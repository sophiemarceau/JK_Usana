package com.sophiemarceau_qu.jk.library.app.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sophiemarceau_qu.jk.jklibrary.log.JKLog
import com.sophiemarceau_qu.jk.library.app.R

class JKDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_j_k_demo)
        findViewById<View>(R.id.btn_log).setOnClickListener{
            printLog()
        }
    }

    private fun printLog() {
        JKLog.a("888888")
    }
}