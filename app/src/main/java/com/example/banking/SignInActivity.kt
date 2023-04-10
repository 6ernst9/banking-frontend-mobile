package com.example.banking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.banking.R
import com.google.android.material.card.MaterialCardView
import android.content.Intent
import android.text.InputType
import android.widget.EditText
import android.widget.ImageView
import com.example.banking.CreateAccountActivity
import com.example.banking.MenuActivity

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val nextBtn = findViewById<MaterialCardView>(R.id.nextBtn)
        val loginBtn = findViewById<MaterialCardView>(R.id.loginBtn)
        val showPasswordBtn : ImageView = findViewById(R.id.showPassword)
        val passwordForm : EditText = findViewById(R.id.passwordForm)
        var isHidden : Boolean = true;
        showPasswordBtn.setOnClickListener{
            if(isHidden){
                passwordForm.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                isHidden = false
                showPasswordBtn.setImageDrawable(resources.getDrawable(R.drawable.eye_off));
            }
            else{
                passwordForm.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                isHidden = true;
                showPasswordBtn.setImageDrawable(resources.getDrawable(R.drawable.eye));
            }
        }
        loginBtn.setOnClickListener {
            val intent = Intent(this@SignInActivity, CreateAccountActivity::class.java)
            startActivity(intent)
        }
        nextBtn.setOnClickListener {
            val intent = Intent(this@SignInActivity, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}