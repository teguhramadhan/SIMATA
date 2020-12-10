package com.teguhrmdhn.simata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.teguhrmdhn.simata.maincore.AddMaincoreActivity
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btn_addmaincore.setOnClickListener {
            val moveAddMaincore = Intent(this@DashboardActivity, AddMaincoreActivity::class.java)
            startActivity(moveAddMaincore)
        }

        btn_viewmaincore.setOnClickListener {
            val moveViewMaincore = Intent(this@DashboardActivity, ShowMaincoreActivity::class.java)
            startActivity(moveViewMaincore)
        }
    }
}