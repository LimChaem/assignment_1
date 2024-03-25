package com.lim.assignment_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val randomImg = findViewById<ImageView>(R.id.iv_home)
        val random = Random

        val selectedImage = when(random.nextInt(1,5)) {
            1 -> R.drawable.img_lv1
            2 -> R.drawable.img_lv2
            3 -> R.drawable.img_lv3
            4 -> R.drawable.img_lv4
            else -> R.drawable.img_lv5
        }

        randomImg.setImageResource(selectedImage)

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