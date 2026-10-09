package com.example.logging

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализация Timber
        Timber.plant(Timber.DebugTree())

        val editText = findViewById<EditText>(R.id.edit_text)
        val buttonLog = findViewById<Button>(R.id.button_log)
        val buttonTimber = findViewById<Button>(R.id.button_timber)

        buttonLog.setOnClickListener {
            // Отправляем verbose сообщение через стандартный Log
            Log.v("From EditText", editText.text.toString())
        }

        buttonTimber.setOnClickListener {
            // Отправляем verbose сообщение через Timber (тег подставится автоматически)
            Timber.v(editText.text.toString())
        }
    }
}