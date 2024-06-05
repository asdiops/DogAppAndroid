package com.example.randomimage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.createBitmap
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.randomimage.databinding.ItemListBinding
import com.squareup.picasso.Picasso

class ListAdapter : Adapter<ListAdapter.MyVeiwHolder>() {

    private var myData: List<String> = listOf()

    fun setList(list: List<String>) {
        myData = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVeiwHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context))
        return MyVeiwHolder(binding)
    }

    override fun getItemCount(): Int {
        return myData.size
    }

    override fun onBindViewHolder(holder: MyVeiwHolder, position: Int) {
        holder.bind(myData[position])
    }

    class MyVeiwHolder(
        private val binding: ItemListBinding
    ): ViewHolder(binding.root) {
        fun bind(data: String) {
            binding.myTextView.text = data
            Picasso.get().load("https://storage.yandexcloud.net/storage.yasno.media/nat-geo/images/2023/6/28/a9c7c5ba9c2e4caa9330c1ec5c0fc499.max-2000x1000.jpg").into(binding.itemImage);
        }
    }
}