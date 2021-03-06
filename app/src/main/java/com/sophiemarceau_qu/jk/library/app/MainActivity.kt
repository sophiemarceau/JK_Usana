package com.sophiemarceau_qu.jk.library.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sophiemarceau_qu.jk.library.app.demo.JKDemoActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.tv_jklog -> {
                startActivity(Intent(this, JKDemoActivity::class.java))
            }
        }
    }
}