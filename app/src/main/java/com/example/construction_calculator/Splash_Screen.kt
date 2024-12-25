package com.example.construction_calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.ComponentActivity
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer
import java.util.TimerTask


class Splash_Screen : ComponentActivity() {
    private lateinit var tv: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)


        tv = findViewById(R.id.textview3)
       setText("Calculate every construction detail with ease—precise,\nfast, and all-in-one for all your project needs!")


        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                )
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )


        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@Splash_Screen,Home_Screen::class.java)
            startActivity(intent)
            finish()
        },3500)

    }




    fun setText(s: String) {
        var i = 0
        val length = s.length
        val handler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                if (i < length){
                    val c = s[i]
                    tv.append(c.toString())
                    i++
                }

            }
        }

        val timer = Timer()
        val taskEverySplitSecond = object : TimerTask() {
            override fun run() {
                handler.sendEmptyMessage(0)
                if (i >= length) {
                    timer.cancel()
                }
            }
        }

        timer.schedule(taskEverySplitSecond, 100, 10)
    }
}