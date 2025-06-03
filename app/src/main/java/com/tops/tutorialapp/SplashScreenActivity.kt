package com.tops.tutorialapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreenActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)
        supportActionBar?.hide()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        Handler(Looper.getMainLooper()).postDelayed({
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }, 5000)


        val sharedPref = getSharedPreferences(
            getString(R.string.app_name), Context.MODE_PRIVATE)
        val islogin = sharedPref?.getBoolean(IS_Login, false)

        Handler().postDelayed({
        if (islogin==true){
            val intent = Intent(this, DashboardDawer::class.java)
            startActivity(intent)
            finish()
        }else {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        },3000)
    }
}