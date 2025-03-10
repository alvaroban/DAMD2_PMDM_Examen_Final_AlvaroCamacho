package com.example.damd2_pmdm_examen_final_alvarocamacho.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.damd2_pmdm_examen_final_alvarocamacho.R
import com.example.damd2_pmdm_examen_final_alvarocamacho.model.Product

class ProductAdapter(
    private var products: MutableList<Product>,
    private val onClickListener: (Product) -> Unit
) : RecyclerView.Adapter<ProductViewHolder>()  {

    fun updateData(newMovies: List<Product>){
        var size = products.size
        products.clear()
        notifyItemRangeRemoved(0, size)
        products.addAll(newMovies)
        size = products.size
        notifyItemRangeRemoved(0, size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position], onClickListener)
    }
}