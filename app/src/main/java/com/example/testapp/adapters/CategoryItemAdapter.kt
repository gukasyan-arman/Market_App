package com.example.testapp.adapters

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.models.CategoryItem
import kotlinx.android.synthetic.main.category_button_item.view.*

class CategoryItemAdapter(
    private val itemsList: List<CategoryItem>,
    private val clickListener: (CategoryItem) -> Unit
    ): RecyclerView.Adapter<CategoryItemAdapter.CategoryViewHolder>() {

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
            clickListener(itemsList[it])
        }
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = itemsList[position]

        holder.itemView.apply {
            categoryItemTitle.text = item.text
            categoryItemImage.setImageResource(item.iconRes)
            for (categoryItem in itemsList) {
                if (!categoryItem.isSelected) {
                    categoryItemImage.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.white))
                    categoryItemImage.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.light_gray))
                }
            }

            setOnClickListener {
                item.isSelected = !item.isSelected
                holder.itemView.apply {
                    if (item.isSelected) {
                        categoryItemTitle.setTextColor(ContextCompat.getColor(context,R.color.orange))
                        categoryItemImage.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.orange))
                        categoryItemImage.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.white))
                    } else {
                        categoryItemTitle.setTextColor(ContextCompat.getColor(context,R.color.blue))
                        categoryItemImage.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.white))
                        categoryItemImage.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.light_gray))
                    }
                }
            }

        }

    }

    override fun getItemCount(): Int = itemsList.size
}