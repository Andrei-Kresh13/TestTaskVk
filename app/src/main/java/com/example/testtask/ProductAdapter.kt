package com.example.testtask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.testtask.model.Product
//import kotlinx.android.synthetic.main.item_product.view.*
import com.example.testtask.R


class ProductAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        val textViewDescription: TextView = itemView.findViewById(R.id.textViewDescription)
        val textViewPrice: TextView = itemView.findViewById(R.id.textViewPrice)
        val imageViewThumbnail: ImageView = itemView.findViewById(R.id.imageViewThumbnail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentItem = products[position]
        holder.textViewTitle.text = currentItem.title
        holder.textViewDescription.text = currentItem.description
        holder.textViewPrice.text = currentItem.price.toString()

        // Load thumbnail image using Glide
        Glide.with(holder.itemView.context)
            .load(currentItem.thumbnail)
            .diskCacheStrategy(DiskCacheStrategy.ALL) // Cache both original & resized image
            .into(holder.imageViewThumbnail)
    }

    override fun getItemCount() = products.size
}