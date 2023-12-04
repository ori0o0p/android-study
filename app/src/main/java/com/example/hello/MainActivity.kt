package com.example.hello

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var tv : TextView
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.textView)
        buttonEvent()
    }

    private fun buttonEvent() {
        val button = findViewById<Button>(R.id.buttonToEn)
        val button2 = findViewById<Button>(R.id.buttonToKor)
        button.setOnClickListener {
            handler.removeCallbacks(runnable) // 시간 갱신 작업 중단
            buttonClickMessage("영어 선택")
            tv.text = "Android"
        }

        button2.setOnClickListener {
            handler.removeCallbacks(runnable) // 시간 갱신 작업 중단
            buttonClickMessage("한국어 선택")
            tv.text = "안드로이드"
        }

        val button3 = findViewById<Button>(R.id.buttonToGetTime)

        button3.setOnClickListener { // 시간
            buttonClickMessage("현재 시간 선택")
            getTime()
        }

        val button4 = findViewById<Button>(R.id.buttonToGetDate)

        button4.setOnClickListener { // 날짜
            handler.removeCallbacks(runnable) // 시간 갱신 작업 중단
            buttonClickMessage("오늘 날짜 선택")
            getDate()
        }

    }

    private fun getTime() {
        handler = Handler(Looper.getMainLooper())
        runnable = Runnable {
            val currentTime = Calendar.getInstance().time
            val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
            val timeString = timeFormat.format(currentTime)
            tv.text = "현재 시간 : $timeString"
            handler.postDelayed(runnable, 1000)
        }
        handler.post(runnable)
    }

    private fun buttonClickMessage(message : String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("SetTextI18n")
    private fun getDate() {
        val currentDate = Calendar.getInstance().time
        val timeFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val timeString = timeFormat.format(currentDate)
        tv.text = "오늘 날짜 : $timeString"
    }

}
