package com.lim.assignment_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val inputName = findViewById<EditText>(R.id.edit_name)
        val inputId = findViewById<EditText>(R.id.edit_id)
        val inputPassWord = findViewById<EditText>(R.id.edit_password)

        val btn_signup = findViewById<Button>(R.id.btn_signUp2)
        btn_signup.setOnClickListener {
            if(inputName.text.isEmpty() || inputId.text.isEmpty() || inputPassWord.text.isEmpty()){
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }else {
                val intent = Intent(this, SignlnActivity::class.java)
                Toast.makeText(this, "가입이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                startActivity(intent)
                finish()
            }
        }


    }



}