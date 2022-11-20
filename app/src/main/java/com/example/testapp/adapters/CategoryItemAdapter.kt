package com.example.testapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import kotlinx.android.synthetic.main.category_button_item.view.*
import kotlin.properties.Delegates

class CategoryItemAdapter(
    private val iconsList: List<Int>,
    private val titlesList: List<String>,
    private val clickListener: (Int) -> Unit
    ): RecyclerView.Adapter<CategoryItemAdapter.CategoryViewHolder>() {

    private var selectedItemPosition by Delegates.notNull<Int>()

    inner class CategoryViewHolder(
        itemView: View,
        clickAtPosition: (Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
            init {
                itemView.setOnClickListener {
                    clickAtPosition(adapterPosition)
                }
            }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.category_button_item, parent, false)) {
            clickListener(iconsList[it])
        }
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.itemView.apply {
            categoryItemTitle.text = titlesList[position]
            categoryItemImage.setImageResource(iconsList[position])
        }
    }

    override fun getItemCount(): Int = titlesList.size
}