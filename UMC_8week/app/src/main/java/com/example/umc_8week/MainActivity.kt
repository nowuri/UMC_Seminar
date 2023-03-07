package com.example.umc_8week

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.umc_8week.databinding.ActivityMainBinding
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    private var dataList: ArrayList<Data> = arrayListOf()
    var dataRVAdapter = DataRVAdapter(this,dataList)
    var roomDB : AppDatabase?=null
    private var dlist = arrayListOf<Message>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.rvData.adapter = dataRVAdapter

        viewBinding.rvData.layoutManager = LinearLayoutManager(this)

        roomDB = AppDatabase.getInstance(this)
        roomDB?.MessageDao()?.selectAll()
        val r = Runnable{
            dlist = (roomDB?.MessageDao()?.selectAll() as ArrayList<Message>?)!!
        }
        val thread = Thread(r)
        thread.start()

        viewBinding.addnote.setOnClickListener() {
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
                if(roomDB != null){
                    val message = Message(text)
                    roomDB!!.MessageDao().insert(message)
                    val messagelist = roomDB!!.MessageDao().selectAll()
                    Log.d("DB","${messagelist}")
                }
                dialog.dismiss()
            }

            addDialog.setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()

            }
            addDialog.create()
            addDialog.show()
        }
        viewBinding.savelist.setOnClickListener(){
            val intent = Intent(this, Starlist::class.java)
            startActivity(intent)
        }

        dataRVAdapter.setMyItemClickListener(object: DataRVAdapter.MyItemClickListener{
            override fun onItemClick(position: Int) {
                val message1 = Message(dataList[position].toString())
                Log.d("delete message","${message1}")
                val messagelist = roomDB?.MessageDao()?.selectAll()
                roomDB?.MessageDao()?.delete(dataList[position])
                dataList.removeAt(position)
                dataRVAdapter.notifyDataSetChanged()
                Toast.makeText(this@MainActivity,"Deleted the note",Toast.LENGTH_SHORT).show()
                Log.d("Delete DB","${messagelist}")

            }
        })
    }
}