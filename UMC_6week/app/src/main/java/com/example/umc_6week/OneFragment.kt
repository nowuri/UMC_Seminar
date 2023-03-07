package com.example.umc_6week

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.umc_6week.OneFragment
import com.example.umc_6week.databinding.FragmentOneBinding


class OneFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentOneBinding.inflate(layoutInflater).root
    }
}