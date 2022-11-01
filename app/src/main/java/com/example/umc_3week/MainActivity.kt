package com.example.umc_3week

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.umc_3week.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.inputbutton.setOnClickListener(){
            val intent = Intent(this, ShowTextActivity::class.java)
            var strText = viewBinding.inputText.getText().toString()
            intent.putExtra("Input", strText)
            startActivity(intent)
        }

        viewBinding.toAct3.setOnClickListener(){
            val intent5 = Intent(this,FragmentActivity::class.java)
            var strText = viewBinding.inputText.getText().toString()
            startActivity(intent5)
            Toast.makeText(this.applicationContext,strText,Toast.LENGTH_SHORT).show()
        }
    }

}