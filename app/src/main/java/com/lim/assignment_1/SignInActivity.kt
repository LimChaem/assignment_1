package com.lim.assignment_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        val inputId = findViewById<EditText>(R.id.edit_id)
        val inputPassWord = findViewById<EditText>(R.id.edit_password)
        val btn_login = findViewById<Button>(R.id.btn_login)

        btn_login.setOnClickListener {
            if (inputId.text.isEmpty() || inputPassWord.text.isEmpty()) {
                Toast.makeText(this, "아이디, 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                val idData = "아이디 : " + inputId.text.toString()
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("ID", idData)
                Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }

        val btn_sighUp = findViewById<Button>(R.id.btn_signup)
        btn_sighUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }

        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                val id = result.data?.getStringExtra("ID") ?: ""
                val password = result.data?.getStringExtra("PASSWORD") ?: ""

                inputId.setText(id)
                inputPassWord.setText(password)
            }
        }
    }
}
