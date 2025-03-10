package com.example.damd2_pmdm_examen_final_alvarocamacho.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String
): Parcelable
