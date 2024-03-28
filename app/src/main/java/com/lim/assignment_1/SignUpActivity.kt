package com.lim.assignment_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {

    private lateinit var inputName: EditText
    private lateinit var inputId: EditText
    private lateinit var inputPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        declareVariable()
        clickSignUpButton()

    }

    private fun declareVariable() {
        inputName = findViewById(R.id.edit_name)
        inputId = findViewById(R.id.edit_id2)
        inputPassword = findViewById(R.id.edit_password)
    }

    private fun clickSignUpButton() {
        val btn_signUp = findViewById<Button>(R.id.btn_signUp2)
        btn_signUp.setOnClickListener {
            if (inputName.text.isEmpty() || inputId.text.isEmpty() || inputPassword.text.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("ID", inputId.text.toString())
                intent.putExtra("PASSWORD", inputPassword.text.toString())
                Toast.makeText(this, "가입이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                setResult(RESULT_OK, intent)

                finish()
            }
        }
    }
}