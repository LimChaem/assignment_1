package com.lim.assignment_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignlnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signln)
        val inPutId = findViewById<EditText>(R.id.edit_id)
        val inPutPassWord = findViewById<EditText>(R.id.edit_password)


        val btn_login = findViewById<Button>(R.id.btn_login)
        btn_login.setOnClickListener {
            if (inPutId.text.isEmpty() || inPutPassWord.text.isEmpty()) {
                Toast.makeText(this, "아이디, 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                //activity_home.xml 텍스트뷰 2개로 만들었을 때
                //val idData = (inPutId.text.toString())
                val idData = ("아이디 : "+ inPutId.text.toString())
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("ID", idData)
                Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }

        val btn_sighup = findViewById<Button>(R.id.btn_signup)
        btn_sighup.setOnClickListener {
            val sign_up = Intent(this, SignUpActivity::class.java)
            startActivity(sign_up)
        }
    }

//    fun doOnClick(view: View) {
//        when(view.id) {
//            R.id.btn_login -> {
//                val login = Intent(this, HomeActivity::class.java)
//                val edit_id = findViewById<EditText>(R.id.edit_id)
//                val idData = edit_id.text.toString()
//
//                intent.putExtra("ID", idData)
//                startActivity(login)
//            }
//
//            R.id.btn_signup -> {
//                val signup = Intent(this, SignUpActivity::class.java)
//                startActivity(signup)
//}
//}
//}
}
