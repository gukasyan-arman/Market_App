package com.example.testapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.detail.DetailResponse
import com.example.testapp.R
import kotlinx.android.synthetic.main.detail_view_pager_item.view.*

class DetailViewPagerAdapter(): RecyclerView.Adapter<DetailViewPagerAdapter.PagerViewHolder>() {

    inner class PagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val callback = object : DiffUtil.ItemCallback<DetailResponse>() {
        override fun areItemsTheSame(oldItem: DetailResponse, newItem: DetailResponse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DetailResponse, newItem: DetailResponse): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.detail_view_pager_item, parent, false))
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        val image = differ.currentList[position].images[position]
        holder.itemView.apply {
            Glide.with(this).load(image).placeholder(R.mipmap.ic_launcher).centerCrop().into(detailPagerImage)
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

}