package com.sophiemarceau_qu.jk.library.app.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sophiemarceau_qu.jk.jklibrary.log.JKLog
import com.sophiemarceau_qu.jk.jklibrary.log.JKLogConfig
import com.sophiemarceau_qu.jk.jklibrary.log.JKLogType
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
        //自定义log配置
        JKLog.log(object : JKLogConfig(){
            override fun includeTread(): Boolean {
                return true
            }

            override fun stackTraceDepth(): Int {
                return 0
            }
        }, JKLogType.E, "------", "5566")
        JKLog.a("888888")
    }
}