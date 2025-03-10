package com.example.damd2_pmdm_examen_final_alvarocamacho.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.damd2_pmdm_examen_final_alvarocamacho.databinding.ItemProductBinding
import com.example.damd2_pmdm_examen_final_alvarocamacho.model.Product
import com.squareup.picasso.Picasso

class ProductViewHolder(view: View) : ViewHolder(view) {
    private val binding = ItemProductBinding.bind(view)

    fun bind(product: Product, onClickListener: (Product) -> Unit) {
        binding.tvTitle.text = product.title
        Picasso.get().load("https://image.tmdb.org/t/p/w500${product.image}")
            .into(binding.ivProduct)
        itemView.setOnClickListener {
            onClickListener(product)

        }
    }
}