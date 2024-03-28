package com.lim.assignment_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ContentInfoCompat.Flags

import kotlin.random.Random


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val randomImg = findViewById<ImageView>(R.id.iv_home)
        val random = Random

        val selectedImage = when (random.nextInt(1, 5)) {
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

        val btnClose = findViewById<Button>(R.id.btn_close)
        btnClose.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)

            /*startActivity(intent) 를 하지 않고 finish()를 할 경우
            이전에 입력했던 아이디, 비밀번호가 그대로 남아있고, startActivity(intent)를 할 경우 스택이 쌓이는 것을 확인*/
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
    }
}