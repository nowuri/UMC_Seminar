package com.example.umc_6week

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_6week.MypageFragment
import com.example.umc_6week.databinding.FragmentMypageBinding

class MypageFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentMypageBinding.inflate(layoutInflater).root
    }
}