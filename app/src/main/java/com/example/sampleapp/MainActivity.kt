package com.example.sampleapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        btnStart.setOnClickListener {
            tvStatus.text = "Запуск..."
            try {
                val intent = packageManager.getLaunchIntentForPackage("com.axlebolt.standoff2")
                if (intent != null) {
                    startActivity(intent)
                } else {
                    tvStatus.text = "Игра не установлена."
                }
            } catch (e: Exception) {
                tvStatus.text = "Ошибка: ${e.message}"
            }
        }
    }
}
