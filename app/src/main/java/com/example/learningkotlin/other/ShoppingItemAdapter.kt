package com.example.learningkotlin.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learningkotlin.R
import com.example.learningkotlin.data.db.entities.ShoppingItem
import com.example.learningkotlin.databinding.ShoppingItemBinding
import com.example.learningkotlin.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter(
    var items : List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val binding = ShoppingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoppingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]

        holder.binding.tvName.text = curShoppingItem.name


    }

    inner class ShoppingViewHolder(val binding: ShoppingItemBinding): RecyclerView.ViewHolder(binding.root)
}