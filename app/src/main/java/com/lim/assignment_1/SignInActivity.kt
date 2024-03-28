package com.lim.assignment_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var inputId: EditText
    private lateinit var inputPassWord: EditText
    private lateinit var btn_logIn: Button
    private lateinit var btn_signUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        declareVariable()
        btnClickListener()
        registerForActivityResult()
        clickToSignUpButton()

        Log.d("lifecycle","onCreate")

    }

    private fun declareVariable() {
        inputId = findViewById(R.id.edit_id)
        inputPassWord = findViewById(R.id.edit_password)
        btn_logIn = findViewById(R.id.btn_login)
        btn_signUp = findViewById(R.id.btn_signup)
    }

    private fun clickToSignUpButton() {
        btn_signUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    private fun btnClickListener() {
        btn_logIn.setOnClickListener {
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
    }

    private fun registerForActivityResult() {
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



