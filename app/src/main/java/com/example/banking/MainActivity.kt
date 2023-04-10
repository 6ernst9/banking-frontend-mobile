package com.example.banking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.banking.R
import com.google.android.material.card.MaterialCardView
import android.content.Intent
import com.example.banking.CreateAccountActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nextBtn = findViewById<MaterialCardView>(R.id.nextBtn)
        nextBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, CreateAccountActivity::class.java)
            startActivity(intent)
        }
    }
}