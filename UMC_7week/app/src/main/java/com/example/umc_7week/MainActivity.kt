package com.example.umc_7week

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.os.postDelayed
import com.example.umc_7week.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    private var timenum = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.upbutton.setOnClickListener(){
            Log.d("up","Up")
            timenum++
            viewBinding.time.setText(timenum.toString() +":00")
        }

        viewBinding.downbutton.setOnClickListener(){
            Log.d("down","Down")
            timenum--
            viewBinding.time.setText(timenum.toString() + ":00")
        }

        var handler = Handler(mainLooper)
        val soundPool = SoundPool.Builder().build()
        val soundID = soundPool.load(this,R.raw.sound1,1)


        viewBinding.startbutton.setOnClickListener(){
            runOnUiThread(){
                Toast.makeText(this,"Start the timer",Toast.LENGTH_SHORT).show()
            }
            Log.d("start","Start")
            Thread(){
                while(timenum>0) {
                    Thread.sleep(1000)
                    Log.d("1min", timenum.toString())
                    timenum--
                    runOnUiThread() {
                        if (timenum == 0) {
                            viewBinding.time.setText("00:00")
                            soundPool.play(soundID,1.0f,1.0f,0,0,1.0f)
                        } else {
                            viewBinding.time.setText(timenum.toString() + ":00")
                        }
                    }
                }
                if(timenum < 0){
                    Thread.interrupted()
                }
            }.start()
        }
    }
}