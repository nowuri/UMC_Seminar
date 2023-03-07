package com.example.umc_5week

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_5week.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    private var dataList: ArrayList<Data> = arrayListOf()
    //var dataList: ArrayList<Data> = arrayListOf()
    var dataRVAdapter = DataRVAdapter(this,dataList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.rvData.adapter = dataRVAdapter

        viewBinding.rvData.layoutManager = LinearLayoutManager(this)

        viewBinding.addnote.setOnClickListener() {
            //val intent = Intent(this, AddNote::class.java)
            val inflter = LayoutInflater.from(this)
            val v = inflter.inflate(R.layout.add_item, null)

            val datatext = v.findViewById<EditText>(R.id.noteinput)
            val addDialog = AlertDialog.Builder(this)

            addDialog.setView(v)
            addDialog.setPositiveButton("OK") { dialog, _ ->
                val text = datatext.text.toString()
                dataList.add(Data(text))
                dataRVAdapter.notifyDataSetChanged()
                Toast.makeText(this, "Adding Note", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            addDialog.setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()

            }
            addDialog.create()
            addDialog.show()
        }
    }
}