package com.teguhrmdhn.simata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btn_addmaincore.setOnClickListener {
            val moveMaincore = Intent(this@DashboardActivity, AddMaincoreActivity::class.java)
            startActivity(moveMaincore)
        }
    }
}