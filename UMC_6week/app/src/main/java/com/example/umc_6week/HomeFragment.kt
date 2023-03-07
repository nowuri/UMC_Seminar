package com.example.umc_6week

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.umc_6week.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


    class HomeFragment: Fragment() {
        private lateinit var viewBinding: FragmentHomeBinding

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            viewBinding = FragmentHomeBinding.inflate(layoutInflater)

            val mainVPAdapter = MainVPAdapter(this)
            viewBinding.vpMain.adapter = mainVPAdapter

            val tabTitleArray = arrayOf(
                "One",
                "Two",
                "Three"
            )

            TabLayoutMediator(viewBinding.tabMain, viewBinding.vpMain){tab, position->
                tab.text = tabTitleArray[position]
            }.attach()

            return viewBinding.root
        }

    }
