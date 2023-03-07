package com.example.umc_3week

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.umc_3week.databinding.ActivityShowTextBinding

class ShowTextActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityShowTextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityShowTextBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val extras = intent.extras

        val data = extras!!["Input"] as String

        viewBinding.showtextView.text = data

        viewBinding.moveto3.setOnClickListener(){
            val intent1 = Intent(this, FragmentActivity::class.java)
            startActivity(intent1)
        }

        viewBinding.back.setOnClickListener(){
            val intent4 = Intent(this, MainActivity::class.java)
            var Back = viewBinding.showtextView.getText().toString()
            intent4.putExtra("Input",Back)
            startActivity(intent4)

            Toast.makeText(this.applicationContext,Back,Toast.LENGTH_SHORT).show()
        }
    }

}