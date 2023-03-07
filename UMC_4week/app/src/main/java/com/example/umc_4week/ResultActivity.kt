package com.example.umc_4week

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc_4week.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        //extras에 넘겨 받은 데이터 넣음
        val extras = intent.extras

        //data에 (key)Input에 있는 내용을 String으로 가져옴
        val data = extras!!["Input"] as String

        //output라는 TextView에서 data 내용을 보여줌
        viewBinding.output.text = data
    }
}