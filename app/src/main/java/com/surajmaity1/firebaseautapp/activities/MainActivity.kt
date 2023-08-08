package com.surajmaity1.firebaseautapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.surajmaity1.firebaseautapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val logOut = findViewById<Button>(R.id.log_out_btn_ma)

        setUpActionBar()

        logOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()

            val intent = Intent(this, ActivityRLF::class.java)
            intent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            )
            startActivity(intent)
            finish()
        }
    }
    private fun setUpActionBar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar_main_activity)
        val mainTitleToolbar = findViewById<TextView>(R.id.main_title_toolbar_main)


        setSupportActionBar(toolbar)

        mainTitleToolbar.text = resources.getText(R.string.main_activity)
    }
}