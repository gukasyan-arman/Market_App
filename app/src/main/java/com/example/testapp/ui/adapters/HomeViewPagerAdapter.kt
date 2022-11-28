package com.example.testapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.home.HomeStore
import com.example.testapp.R
import kotlinx.android.synthetic.main.viewpager_item.view.*

class HomeViewPagerAdapter(): RecyclerView.Adapter<HomeViewPagerAdapter.PagerViewHolder>() {

    inner class PagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val callback = object : DiffUtil.ItemCallback<HomeStore>() {
        override fun areItemsTheSame(oldItem: HomeStore, newItem: HomeStore): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: HomeStore, newItem: HomeStore): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeViewPagerAdapter.PagerViewHolder {
        return PagerViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.viewpager_item, parent, false))
    }

    override fun onBindViewHolder(holder: HomeViewPagerAdapter.PagerViewHolder, position: Int) {
        val product = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(product.picture).centerCrop().into(pagerImage)
            titleCard.text = product.title
            descriptionCard.text = product.subtitle
            if (product.is_new) {
                newLabel.visibility = View.VISIBLE
            } else {
                newLabel.visibility = View.INVISIBLE
            }
        }
    }

    override fun getItemCount() = differ.currentList.size
}