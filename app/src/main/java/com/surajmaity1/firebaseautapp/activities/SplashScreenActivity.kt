package com.surajmaity1.firebaseautapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.surajmaity1.firebaseautapp.R
import com.surajmaity1.firebaseautapp.realtime_database.FireBaseRDB

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler().postDelayed({
            val curUsrId = FireBaseRDB().getCurrentUserId()

            if (curUsrId.isNotEmpty()){
                startActivity(Intent(this, MainActivity::class.java))

            }else{
                startActivity(Intent(this, ActivityRLF::class.java))
            }
            finish()
        }, 1000)
    }
}