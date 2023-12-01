package com.example.hello

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var tv : TextView

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
//            Toast.makeText(this@MainActivity, "버튼 클릭 이벤트", Toast.LENGTH_SHORT).show()
            tv.text = "Android"
        }

        button2.setOnClickListener {
            tv.text = "안드로이드"
        }

        val button3 = findViewById<Button>(R.id.buttonToGetTime)

        button3.setOnClickListener {
            getTime()
        }

        val button4 = findViewById<Button>(R.id.buttonToGetDate)

        button4.setOnClickListener {
            getDate()
        }

    }

    private fun getTime() {
        val handler = Handler(Looper.getMainLooper())
        handler.post(object : Runnable {
            override fun run() {
                val currentTime = Calendar.getInstance().time
                val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
                val timeString = timeFormat.format(currentTime)
                tv.text = "현재 시간 : $timeString"
                handler.postDelayed(this, 1000)
            }
        })
    }


    @SuppressLint("SetTextI18n")
    private fun getDate() {
        val currentDate = Calendar.getInstance().time
        val timeFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val timeString = timeFormat.format(currentDate)
        tv.text = "오늘 날짜 : $timeString"
    }


}