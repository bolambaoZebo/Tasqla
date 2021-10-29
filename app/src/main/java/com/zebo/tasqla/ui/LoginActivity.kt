package com.zebo.tasqla.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout
import com.zebo.tasqla.MainActivity
import com.zebo.tasqla.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val userName = findViewById<EditText>(R.id.edt_username)
        val passWord = findViewById<EditText>(R.id.edt_password)
        val buttonLogin = findViewById<Button>(R.id.btn_login)
        val register = findViewById<TextView>(R.id.txt_register)

        userName.doOnTextChanged { _, _, _, _ ->
            findViewById<TextInputLayout>(R.id.container_edtusername).error = null
        }

        passWord.doOnTextChanged { _, _, _, _ ->
            findViewById<TextInputLayout>(R.id.container_edtpassword).error = null
        }

        buttonLogin.setOnClickListener {
            //preform login user here
            if((userName.text.isNullOrEmpty() || userName.text.length < 4)
                || (passWord.text.isNullOrEmpty() || passWord.text.length < 4)){
                findViewById<TextInputLayout>(R.id.container_edtusername).error = "Input at least 4 characters"
                findViewById<TextInputLayout>(R.id.container_edtpassword).error = "Input at least 4 characters"
            }else{

                Intent(this@LoginActivity, MainActivity::class.java).apply {
                    startActivity(this)
                    finish()
                }
            }

        }

        register.setOnClickListener {
            Intent(this@LoginActivity, RegisterActivity::class.java).apply {
                startActivity(this)
            }
        }
    }
}