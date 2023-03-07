package com.example.umc_3week

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.umc_3week.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val firstFragment = Fragment1()

        supportFragmentManager
            .beginTransaction()
            .replace(viewBinding.containerFragment.id,firstFragment)
            .commitAllowingStateLoss()

        viewBinding.fragment1.setOnClickListener(){
            val fragment1 = Fragment1()

            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.containerFragment.id,fragment1)
                .commitAllowingStateLoss()
        }

        viewBinding.fragment2.setOnClickListener(){
            val fragment2 = Fragment2()

            supportFragmentManager
                .beginTransaction()
                .replace(viewBinding.containerFragment.id,fragment2)
                .commitAllowingStateLoss()
        }
    }
}