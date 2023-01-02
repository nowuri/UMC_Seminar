package com.example.umc_6week

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc_6week.databinding.ActivityAddItemBinding
import java.util.zip.Inflater

class Add_item : AppCompatActivity() {
    private lateinit var viewBinding:ActivityAddItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityAddItemBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


    }
}