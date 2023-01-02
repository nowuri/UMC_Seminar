package com.example.umc_8week

import android.content.Context
import android.content.Context.MODE_APPEND
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.edit
import androidx.recyclerview.widget.RecyclerView

class DataRVAdapter(val c:Context,val dataList: ArrayList<Data>): RecyclerView.Adapter<DataRVAdapter.DataViewHolder>() {

    interface MyItemClickListener{
        fun onItemClick(position: Int)
    }

    private lateinit var mItemClickListener: MyItemClickListener
    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        mItemClickListener = itemClickListener
    }

    //ViewHolder 객체
    inner class DataViewHolder(val v: View): RecyclerView.ViewHolder(v) {
        var datatext: TextView
        var deleteB: Button

        init{
            itemView.setOnClickListener{
                mItemClickListener.onItemClick(adapterPosition)
            }
        }
        init {
            datatext = v.findViewById<TextView>(R.id.textdata)
            deleteB = v.findViewById<Button>(R.id.delete)
            deleteB.setOnClickListener {
                AlertDialog.Builder(c)
                    .setTitle("Delete")
                    .setMessage("Are you sure delete this Note")
                    .setPositiveButton("Yes"){
                            dialog,_->
                        dataList.removeAt(adapterPosition)
                        notifyDataSetChanged()
                        dialog.dismiss()
                    }
                    .setNegativeButton("No"){
                            dialog,_->
                        dialog.dismiss()
                    }
                    .create()
                    .show()
            }
        }
    }

    //ViewHolder 만들어질 때 실행할 동장
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.list_item, parent, false)
        return DataViewHolder(v)
    }

    //Viewholder가 실제로 데이터를 표시해야 할 때 호출되는 함수
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val newList = dataList[position]
        holder.datatext.text = newList.desc
    }

    //표현할 Item의 총 갯수
    override fun getItemCount(): Int {
        return dataList.size
    }
}