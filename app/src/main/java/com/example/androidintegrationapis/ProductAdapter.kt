package com.example.androidintegrationapis

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidintegrationapis.model.Product
import kotlinx.android.synthetic.main.product_item.view.*

class ProductAdapter(
    private val context: Context,
    private val productList: List<Product>
): RecyclerView.Adapter<ProductViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.product_item, parent, false)
        )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.itemView.product_name.text = product.prName
        holder.itemView.product_price.text = product.prPrice
        Glide.with(context).load(product.prImage).into(holder.itemView.product_image)
    }

    override fun getItemCount(): Int = productList.size

}

class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)