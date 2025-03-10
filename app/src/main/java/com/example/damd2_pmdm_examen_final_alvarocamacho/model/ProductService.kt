package com.example.damd2_pmdm_examen_final_alvarocamacho.model

import retrofit2.Response
import retrofit2.http.GET

interface ProductService {
    @GET("category/electronics")
    suspend fun getElectronics(
    ): Response<Product>

    @GET("category/jewelery")
    suspend fun getJewelery(
    ): Response<Product>

    @GET("category/men's%20clothing")
    suspend fun getMen(
    ): Response<Product>

    @GET("category/women's%20clothing")
    suspend fun getWomen(
    ): Response<Product>
}