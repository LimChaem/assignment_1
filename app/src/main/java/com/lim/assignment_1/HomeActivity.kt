package com.lim.assignment_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val idData = intent.getStringExtra("ID")
        val userId = findViewById<TextView>(R.id.tv_userId)
        userId.text = idData

        val btn_close = findViewById<Button>(R.id.btn_close)
        btn_close.setOnClickListener {
            val intent = Intent(this, SignlnActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

}