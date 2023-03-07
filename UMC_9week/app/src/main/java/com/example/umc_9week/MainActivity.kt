package com.example.umc_9week

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.umc_9week.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var dataAdapter: DataRVAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView(){
        dataAdapter = DataRVAdapter()
        binding.recyclerview.apply{
            adapter = dataAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        binding.tvBtnSearch.setOnClickListener{
            requestApplyList()
        }
    }

    private fun requestApplyList(){
        val ListService = RetrofitClient.getInstance().create(ApiService::class.java)
        val listCall = ListService.getDetail()

        listCall.enqueue(object:Callback<ResponseDTO>{
            override fun onResponse(call: Call<ResponseDTO>, response: retrofit2.Response<ResponseDTO>) {
                if(response.isSuccessful){
                    dataAdapter?.let{
                        it.setListItem(response.body()?.item?: mutableListOf())
                    }
                }
                else{
                    Toast.makeText(this@MainActivity,"response Code: " + response.code(),Toast.LENGTH_SHORT).show()
                    Log.e(TAG,response.toString())
                }
            }

            override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                Log.e("OnFail",t.stackTraceToString())
            }
        })
    }
}