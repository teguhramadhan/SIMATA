package com.teguhrmdhn.simata.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.teguhrmdhn.simata.R
import kotlinx.android.synthetic.main.activity_auth_menu.*

class AuthMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth_menu)

        btn_sign.setOnClickListener {
            val movelogin = Intent(this@AuthMenuActivity, LoginActivity::class.java)
            startActivity(movelogin)
            finish()
        }
    }
}