package com.example.umc_8week

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.umc_8week.databinding.ActivityStarlistBinding
import java.util.*

class Starlist : AppCompatActivity() {
    private lateinit var viewBinding: ActivityStarlistBinding
    lateinit var mAdapter: DataRVAdapter
    private var dataList = arrayListOf<Data>()

    var db: AppDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityStarlistBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        db = AppDatabase.getInstance(this)
        val list = db?.MessageDao()?.selectAll()
        mAdapter = DataRVAdapter(this, dataList)
        mAdapter.notifyDataSetChanged()

        viewBinding.rvData.adapter = mAdapter

        viewBinding.rvData.layoutManager = LinearLayoutManager(this)

    }
}