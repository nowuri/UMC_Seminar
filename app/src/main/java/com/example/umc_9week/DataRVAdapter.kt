package com.example.umc_9week

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.umc_9week.databinding.ItemDataBinding
import retrofit2.Response

class DataRVAdapter:RecyclerView.Adapter<DataRVAdapter.DataViewHolder>(){
    private lateinit var binding:ItemDataBinding
    private var dataitem = mutableListOf<Faq_item>()

    inner class DataViewHolder(binding: ItemDataBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data:Faq_item){
            binding.setVariable(BR.Response,data)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.item_data,parent,false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataitem[position])
    }

    override fun getItemCount(): Int {
        return dataitem.size
    }

    fun setListItem(datalist: MutableList<Faq_item>){
        this.dataitem = datalist
        notifyDataSetChanged()
    }
}