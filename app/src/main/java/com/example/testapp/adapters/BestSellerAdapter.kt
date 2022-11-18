package com.example.testapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapp.R
import com.example.testapp.models.BestSeller
import kotlinx.android.synthetic.main.best_seller_item.view.*


class BestSellerAdapter(): RecyclerView.Adapter<BestSellerAdapter.BestSellerViewHolder>() {

    inner class BestSellerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val callback = object : DiffUtil.ItemCallback<BestSeller>() {
        override fun areItemsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BestSellerAdapter.BestSellerViewHolder {
        return BestSellerViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.best_seller_item, parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: BestSellerAdapter.BestSellerViewHolder, position: Int) {
        val product = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(product.picture).centerCrop().into(productImage)
            productName.text = product.title
            discountPrice.text = "$" + product.price_without_discount
            fullPrice.text = "$" + product.discount_price
            if (product.is_favorites) {
                favoriteToggle.setImageResource(R.drawable.ic_baseline_favorite_24)
            } else {
                favoriteToggle.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            }
        }
    }

    override fun getItemCount() = differ.currentList.size
}